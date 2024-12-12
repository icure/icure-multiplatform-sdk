package com.icure.cardinal.sdk.dart.crypto

import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey
import com.icure.cardinal.sdk.crypto.entities.RecoveryResult
import com.icure.cardinal.sdk.crypto.entities.map
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.dart.utils.toPkcs8Bytes
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.serialization.Pkcs8BytesAsBase64Serializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import com.icure.cardinal.sdk.crypto.KeyPairRecoverer as IKeyPairRecoverer

@OptIn(InternalIcureApi::class)
object KeyPairRecoverer {
	suspend fun recoverWithRecoveryKey(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		referenceId: String,
		recoveryKeyString: String,
		autoDeleteString: String,
	) {
		val recoveryKey = fullLanguageInteropJson.decodeFromString(
			RecoveryDataKey.serializer(),
			recoveryKeyString
		)
		val autoDelete = fullLanguageInteropJson.decodeFromString(
			Boolean.serializer(),
			autoDeleteString
		)
		ApiScope.execute(
			dartResultCallback,
			RecoveryResult.serializer(
				MapSerializer(
					String.serializer(),
					MapSerializer(
						SpkiHexString.serializer(),
						Pkcs8BytesAsBase64Serializer
					)
				)
			)
		) {
			val res = NativeReferences.get<IKeyPairRecoverer>(referenceId).recoverWithRecoveryKey(
				recoveryKey,
				autoDelete,
			)
			res.map { x0 ->
				x0.mapKeys { (k1, _) ->
					k1
				}.mapValues { (_, v1) ->
					v1.mapKeys { (k2, _) ->
						k2
					}.mapValues { (_, v2) ->
						v2.toPkcs8Bytes()
					}
				}
			}
		}
	}

	suspend fun waitForRecoveryKey(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		cancellationToken: Long,
		referenceId: String,
		recoveryKeyString: String,
		autoDeleteString: String,
		waitSecondsString: String,
	) {
		val recoveryKey = fullLanguageInteropJson.decodeFromString(
			RecoveryDataKey.serializer(),
			recoveryKeyString
		)
		val autoDelete = fullLanguageInteropJson.decodeFromString(
			Boolean.serializer(),
			autoDeleteString
		)
		val waitSeconds = fullLanguageInteropJson.decodeFromString(
			Int.serializer(),
			waitSecondsString
		)
		ApiScope.executeCancellable(
			dartResultCallback,
			cancellationToken,
			RecoveryResult.serializer(
				MapSerializer(
					String.serializer(),
					MapSerializer(
						SpkiHexString.serializer(),
						Pkcs8BytesAsBase64Serializer
					)
				)
			)
		) {
			val res =
				NativeReferences.get<IKeyPairRecoverer>(referenceId).waitForRecoveryKey(
					recoveryKey,
					autoDelete,
					waitSeconds,
				)
			res.map { x0 ->
				x0.mapKeys { (k1, _) ->
					k1
				}.mapValues { (_, v1) ->
					v1.mapKeys { (k2, _) ->
						k2
					}.mapValues { (_, v2) ->
						v2.toPkcs8Bytes()
					}
				}
			}
		}
	}
}