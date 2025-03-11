package com.icure.cardinal.sdk.crypto.impl

import com.icure.cardinal.sdk.api.DataOwnerApi
import com.icure.cardinal.sdk.crypto.BaseExchangeKeysManager
import com.icure.cardinal.sdk.crypto.ExchangeKeysManager
import com.icure.cardinal.sdk.crypto.UserEncryptionKeysManager
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.concurrent.Volatile

@InternalIcureApi
class ExchangeKeysManagerImpl(
	private val dataOwnerApi: DataOwnerApi,
	override val base: BaseExchangeKeysManager,
	private val userKeysManager: UserEncryptionKeysManager,
	private val sdkScope: CoroutineScope
) : ExchangeKeysManager {
	@Volatile // delegator -> delegate -> lazy key decryption job
	private var cache: Deferred<Map<String, Map<String, Deferred<List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>>>> = sdkScope.async {
		doLoadCache()
	}

	override suspend fun getDecryptionExchangeKeysFor(delegatorId: String, delegateId: String): List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>> =
		cache.await()[delegatorId]?.get(delegateId)?.await().orEmpty()

	override fun requestCacheReload() {
		cache = sdkScope.async {
			doLoadCache()
		}
	}

	private suspend fun doLoadCache(): Map<String, Map<String, Deferred<List<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>>>> = coroutineScope {
		val encryptedKeysDataByHierarchyMember = dataOwnerApi.getCurrentDataOwnerHierarchyIds().map {
			async { base.getAllExchangeKeysWith(it, DataOwnerType.entries.toSet()) }
		}.awaitAll()
		val encryptedData = mutableMapOf<String, MutableMap<String, MutableList<Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>>()
		encryptedKeysDataByHierarchyMember.forEach { info ->
			info.exchangeKeysByDataOwnerTo.forEach { (delegate, encryptedEntries) ->
				encryptedData
					.getOrPut(info.dataOwnerId) { mutableMapOf() }
					.getOrPut(delegate) { mutableListOf() }
					.addAll(encryptedEntries)
			}
			info.exchangeKeysToDataOwnerFrom.forEach { (delegator, encryptedEntries) ->
				encryptedData
					.getOrPut(delegator) { mutableMapOf() }
					.getOrPut(info.dataOwnerId) { mutableListOf() }
					.addAll(encryptedEntries)
			}
		}
		val keys = userKeysManager.getDecryptionKeys(true)
		encryptedData.mapValues { (_, keysByDelegate) ->
			keysByDelegate.mapValues { (_, encryptedKeys) ->
				sdkScope.async(start = CoroutineStart.LAZY) {
					base.tryDecryptExchangeKeys(
						encryptedKeys,
						keys
					).successfulDecryptions
				}
			}
		}
	}
}