// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.`external`.XRsaKeypair
import com.icure.kryptom.crypto.`external`.toExternal
import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.sdk.js.crypto.entities.recoveryDataKey_fromJs
import com.icure.sdk.js.crypto.entities.recoveryDataKey_toJs
import com.icure.sdk.js.crypto.entities.recoveryResult_toJs
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.Boolean
import kotlin.Double
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
	override fun createRecoveryInfoForAvailableKeyPairs(includeParentsKeys: Boolean,
			lifetimeSeconds: Double?): Promise<String> = GlobalScope.promise {
		recoveryDataKey_toJs(recoveryApi.createRecoveryInfoForAvailableKeyPairs(includeParentsKeys,
				com.icure.sdk.js.model.CheckedConverters.numberToInt(lifetimeSeconds, "lifetimeSeconds")))}


	override fun recoverKeyPairs(recoveryKey: String, autoDelete: Boolean):
			Promise<RecoveryResultJs<dynamic>> = GlobalScope.promise {
		recoveryResult_toJs(
			recoveryApi.recoverKeyPairs(com.icure.sdk.js.crypto.entities.recoveryDataKey_fromJs(recoveryKey),
					autoDelete),
			{ x1: Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>> ->
				mapToObject<_, _, dynamic>(
					x1,
					{ x2: String ->
						x2
					},
					{ x2: Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> ->
						mapToObject<_, _, XRsaKeypair>(
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
		)}


	override fun createExchangeDataRecoveryInfo(delegateId: String, lifetimeSeconds: Double?):
			Promise<String> = GlobalScope.promise {
		recoveryDataKey_toJs(recoveryApi.createExchangeDataRecoveryInfo(delegateId,
				com.icure.sdk.js.model.CheckedConverters.numberToInt(lifetimeSeconds, "lifetimeSeconds")))}


	override fun recoverExchangeData(recoveryKey: String): Promise<String?> = GlobalScope.promise {
		recoveryApi.recoverExchangeData(com.icure.sdk.js.crypto.entities.recoveryDataKey_fromJs(recoveryKey))?.let {
				nonNull1 ->
			recoveryApi.recoverExchangeData(recoveryDataKey_fromJs(recoveryKey))?.name
		}}


	override fun deleteRecoveryInfo(recoveryKey: String): Promise<Unit> = GlobalScope.promise {
		recoveryApi.deleteRecoveryInfo(recoveryDataKey_fromJs(recoveryKey))}


	override fun deleteAllRecoveryInfoFor(dataOwnerId: String): Promise<Double> = GlobalScope.promise {
		intToNumber(recoveryApi.deleteAllRecoveryInfoFor(dataOwnerId))}


	override fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		intToNumber(recoveryApi.deleteAllKeyPairRecoveryInfoFor(dataOwnerId))}


	override fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double> =
			GlobalScope.promise {
		intToNumber(recoveryApi.deleteAllExchangeDataRecoveryInfoFor(dataOwnerId))}

}
