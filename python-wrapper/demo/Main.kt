
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.KeyPairRecoverer
import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.storage.impl.FileStorageFacade
import kotlinx.coroutines.runBlocking

private object Diocane : CryptoStrategies by BasicCryptoStrategies {
	override suspend fun generateNewKeyForDataOwner(
		self: DataOwnerWithType,
		cryptoPrimitives: CryptoService
	): CryptoStrategies.KeyGenerationRequestResult {
		return CryptoStrategies.KeyGenerationRequestResult.Deny
	}

	override suspend fun recoverAndVerifySelfHierarchyKeys(
		keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
		cryptoPrimitives: CryptoService,
		keyPairRecoverer: KeyPairRecoverer
	): Map<String, CryptoStrategies.RecoveredKeyData> {
		val recoveredData = keyPairRecoverer.recoverWithRecoveryKey(RecoveryDataKey(HexString("882b0f6a8824a786e3046bd908fccfd6e83371afe5ba3142b33f743d0c6a0019")), false)
		val success = when (recoveredData) {
			is RecoveryResult.Failure -> TODO()
			is RecoveryResult.Success -> recoveredData.data
		}
		val recoveredKey = success.values.first().mapKeys { it.key.fingerprintV1() }
		return mapOf(
			keysData.first().dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
				recoveredKeys = recoveredKey,
				keyAuthenticity = emptyMap()
			)
		)
	}
}
val docId = "a3989c60-95b2-4c1c-9b6c-94ee610b6a03"
val docRev = "1-de0b61a766aca5a9059bd56916551b11"

fun main() {
	runBlocking {
		val sdk = com.icure.sdk.IcureSdk.initialise(
			"https://api.icure.cloud",
			AuthenticationMethod.UsingCredentials(UsernamePassword(
				"luca+ginopino@icure.com",
				"c891e717-cad5-4211-91ca-9ee07cf9376b",
			)),
			FileStorageFacade("/Users/trema/icure-multiplatform-sdk/python-wrapper/build/storage"),
			Diocane
		)
		val selfHcpId = sdk.healthcareParty.getCurrentHealthcareParty().id
//		val document = sdk.document.createDocument(
//			sdk.document.withEncryptionMetadata(
//				DecryptedDocument(
//					id= defaultCryptoService.strongRandom.randomUUID(),
//				),
//				null
//			)
//		)
		val document = sdk.document.getDocument(docId)
		println(document.id)
		println(document.rev)
		sdk.document.encryptAndSetMainAttachment(
			document=document,
			utis=null,
			attachment=(0 until 256).map { it.toByte() }.toByteArray()
		)
		println("DIOCANA")
		print(sdk.document.getAndDecryptMainAttachment(
			document=document,
		))
		println("DIOCANB")
		print(sdk.document.getAndDecryptMainAttachment(
			document=document,
			decryptedAttachmentValidator = {
				println("CUSTOM VALIDATIN ${it.toHexString()}")
				it[0] == 0.toByte()
			}
		))
		println("DIOCANC")
		print(sdk.document.getAndTryDecryptMainAttachment(
			document=document,
			decryptedAttachmentValidator = { it[0] == 1.toByte() }
		))
	}
}