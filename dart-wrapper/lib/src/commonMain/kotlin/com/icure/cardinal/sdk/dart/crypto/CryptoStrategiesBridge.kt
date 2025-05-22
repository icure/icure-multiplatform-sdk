package com.icure.cardinal.sdk.dart.crypto

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer
import com.icure.cardinal.sdk.dart.utils.DartCallbacksHandler
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.dart.utils.toPkcs8Bytes
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.specializations.Pkcs8Bytes
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.decode
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive

@OptIn(InternalIcureApi::class)
class CryptoStrategiesBridge(
	private val recoverAndVerifySelfHierarchyKeysCallback: String?,
	private val generateNewKeyForDataOwnerCallback: String?,
	private val verifyDelegatePublicKeysCallback: String?,
	private val dataOwnerRequiresAnonymousDelegationCallback: String?,
	private val notifyNewKeyCreatedCallback: String?,
): CryptoStrategies {
	override suspend fun dataOwnerRequiresAnonymousDelegation(
		dataOwner: CryptoActorStubWithType,
		groupId: String?
	): Boolean {
		if (dataOwnerRequiresAnonymousDelegationCallback == null) {
			return super.dataOwnerRequiresAnonymousDelegation(dataOwner, groupId)
		} else {
			val res = DartCallbacksHandler.registered.invoke(
				dataOwnerRequiresAnonymousDelegationCallback,
				JsonObject(mapOf(
					"dataOwner" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						CryptoActorStubWithType.serializer(),
						dataOwner
					),
					"groupId" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						String.serializer().nullable,
						groupId
					)
				))
			)
			return Serialization.fullLanguageInteropJson.decodeFromString(Boolean.serializer(), res)
		}
	}

	override suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): CryptoStrategies.KeyGenerationRequestResult {
		if (generateNewKeyForDataOwnerCallback == null) {
			return super.generateNewKeyForDataOwner(self, cryptoPrimitives)
		} else {
			val dartResultString = DartCallbacksHandler.registered.invoke(
				generateNewKeyForDataOwnerCallback,
				JsonObject(mapOf(
					"self" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						DataOwnerWithType.serializer(),
						self
					)
				))
			)
			val dartResult = Serialization.fullLanguageInteropJson.decodeFromString(
				DartKeyGenerationRequestResult.serializer(),
				dartResultString
			)
			return when (dartResult) {
				DartKeyGenerationRequestResult.Allow -> CryptoStrategies.KeyGenerationRequestResult.Allow
				DartKeyGenerationRequestResult.Deny -> CryptoStrategies.KeyGenerationRequestResult.Deny
				is DartKeyGenerationRequestResult.Use -> CryptoStrategies.KeyGenerationRequestResult.Use(
					cryptoPrimitives.rsa.loadKeyPairPkcs8(
						RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256,
						dartResult.key.decode()
					)
				)
			}
		}
	}

	override suspend fun notifyNewKeyCreated(
		apis: CardinalApis,
		key: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256>,
		cryptoPrimitives: CryptoService
	) {
		if (notifyNewKeyCreatedCallback == null) {
			super.notifyNewKeyCreated(apis, key, cryptoPrimitives)
		} else {
			DartCallbacksHandler.registered.invoke(
				notifyNewKeyCreatedCallback,
				JsonObject(mapOf(
					"apis" to JsonPrimitive(NativeReferences.create(apis)),
					"key" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						Pkcs8Bytes.serializer(),
						key.toPkcs8Bytes()
					)
				))
			)
		}
	}

	override suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, CryptoStrategies.RecoveredKeyData> {
		if (recoverAndVerifySelfHierarchyKeysCallback == null) {
			return super.recoverAndVerifySelfHierarchyKeys(keysData, cryptoPrimitives, keyPairRecoverer)
		} else {
			val dartResultString = DartCallbacksHandler.registered.invoke(
				recoverAndVerifySelfHierarchyKeysCallback,
				JsonObject(mapOf(
					"keyPairRecoverer" to JsonPrimitive(NativeReferences.create(keyPairRecoverer)),
					"keysData" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						ListSerializer(CryptoStrategies.KeyDataRecoveryRequest.serializer()),
						keysData
					)
				))
			)
			val dartResult = Serialization.fullLanguageInteropJson.decodeFromString(
				MapSerializer(
					String.serializer(),
					DartRecoveredKeyData.serializer()
				),
				dartResultString
			)
			return dartResult.mapValues { (dataOwnerId, recoveredKeysData) ->
				val currDataOwnerRequest = keysData.first { it.dataOwnerDetails.dataOwner.id == dataOwnerId }
				CryptoStrategies.RecoveredKeyData(
					recoveredKeys = recoveredKeysData.recoveredKeys.mapValues { (fp, k) ->
						val keyInfo = requireNotNull(currDataOwnerRequest.unavailableKeys.firstOrNull{
							it.publicKey.fingerprintV1() == fp
						}) {
							"Recovery function should return entries only for the requested keys: got unexpected entry ${fp.s}"
						}
						cryptoPrimitives.rsa.loadKeyPairPkcs8(keyInfo.keyAlgorithm, k.decode())
					},
					keyAuthenticity = recoveredKeysData.keyAuthenticity
				)
			}
		}
	}

	override suspend fun verifyDelegatePublicKeys(
		delegate: CryptoActorStubWithType,
		publicKeys: List<SpkiHexString>,
		cryptoPrimitives: CryptoService,
		groupId: String?
	): List<SpkiHexString> {
		if (verifyDelegatePublicKeysCallback == null) {
			return super.verifyDelegatePublicKeys(delegate, publicKeys, cryptoPrimitives, groupId)
		} else {
			val res = DartCallbacksHandler.registered.invoke(
				verifyDelegatePublicKeysCallback,
				JsonObject(mapOf(
					"delegate" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						CryptoActorStubWithType.serializer(),
						delegate
					),
					"publicKeys" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						ListSerializer(SpkiHexString.serializer()),
						publicKeys
					),
					"groupId" to Serialization.fullLanguageInteropJson.encodeToJsonElement(
						String.serializer().nullable,
						groupId
					)
				))
			)
			return Serialization.fullLanguageInteropJson.decodeFromString(
				ListSerializer(SpkiHexString.serializer()),
				res
			)
		}
	}
}