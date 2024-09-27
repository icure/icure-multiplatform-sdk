// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RecoveryApi
import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.RecoveryApiJs
import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryDataKey_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryDataKey_toJs
import com.icure.cardinal.sdk.js.crypto.entities.recoveryResult_toJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.`external`.XRsaKeypair
import com.icure.kryptom.crypto.`external`.toExternal
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class RecoveryApiImplJs(
	private val recoveryApi: RecoveryApi,
) : RecoveryApiJs {
	override fun createRecoveryInfoForAvailableKeyPairs(options: dynamic): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val includeParentsKeysConverted: Boolean = convertingOptionOrDefaultNonNull(
				_options,
				"includeParentsKeys",
				false
			) { includeParentsKeys: Boolean ->
				includeParentsKeys
			}
			val lifetimeSecondsConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"lifetimeSeconds",
				null
			) { lifetimeSeconds: Double? ->
				numberToInt(lifetimeSeconds, "lifetimeSeconds")
			}
			val result = recoveryApi.createRecoveryInfoForAvailableKeyPairs(
				includeParentsKeysConverted,
				lifetimeSecondsConverted,
			)
			recoveryDataKey_toJs(result)
		}
	}

	override fun recoverKeyPairs(recoveryKey: String, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>> = GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val autoDeleteConverted: Boolean = autoDelete
		val result = recoveryApi.recoverKeyPairs(
			recoveryKeyConverted,
			autoDeleteConverted,
		)
		recoveryResult_toJs(
			result,
			{ x1: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> ->
				mapToObject(
					x1,
					{ x2: String ->
						x2
					},
					{ x2: Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> ->
						mapToObject(
							x2,
							{ x3: SpkiHexString ->
								spkiHexString_toJs(x3)
							},
							{ x3: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm> ->
								x3.toExternal()
							},
						)
					},
				)
			},
		)
	}

	override fun createExchangeDataRecoveryInfo(delegateId: String, options: dynamic):
			Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val lifetimeSecondsConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"lifetimeSeconds",
				null
			) { lifetimeSeconds: Double? ->
				numberToInt(lifetimeSeconds, "lifetimeSeconds")
			}
			val result = recoveryApi.createExchangeDataRecoveryInfo(
				delegateIdConverted,
				lifetimeSecondsConverted,
			)
			recoveryDataKey_toJs(result)
		}
	}

	override fun recoverExchangeData(recoveryKey: String): Promise<String?> = GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		val result = recoveryApi.recoverExchangeData(
			recoveryKeyConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				nonNull1.name
			}
		)
	}

	override fun deleteRecoveryInfo(recoveryKey: String): Promise<Unit> = GlobalScope.promise {
		val recoveryKeyConverted: RecoveryDataKey = recoveryDataKey_fromJs(recoveryKey)
		recoveryApi.purgeRecoveryInfo(
			recoveryKeyConverted,
		)

	}

	override fun deleteAllRecoveryInfoFor(dataOwnerId: String): Promise<Double> = GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.deleteAllRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}

	override fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.deleteAllKeyPairRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}

	override fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = recoveryApi.deleteAllExchangeDataRecoveryInfoFor(
			dataOwnerIdConverted,
		)
		intToNumber(result)
	}
}
