package com.icure.sdk.crypto

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.crypto.impl.exportSpkiHex
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class TransferKeyRecoveryTest : StringSpec({
	beforeAny {
		initialiseTestEnvironment()
	}

	class VerifyEverythingStrategy(
		private val expectMissingKeys: Boolean
	) : CryptoStrategies {
		override suspend fun recoverAndVerifySelfHierarchyKeys(
			keysData: List<CryptoStrategies.KeyDataRecoveryRequest>,
			cryptoPrimitives: CryptoService,
			keyPairRecoverer: KeyPairRecoverer
		): Map<String, CryptoStrategies.RecoveredKeyData> =
			keysData.associate {
				if (expectMissingKeys) {
					it.unavailableKeys.shouldNotBeEmpty()
				} else {
					it.unavailableKeys.shouldBeEmpty()
				}
				it.dataOwnerDetails.dataOwner.id to CryptoStrategies.RecoveredKeyData(
					recoveredKeys = emptyMap(),
					keyAuthenticity = it.unknownKeys.associate { k -> k.fingerprintV1() to true }
				)
			}

		override suspend fun generateNewKeyForDataOwner(
			self: DataOwnerWithType,
			cryptoPrimitives: CryptoService
		): CryptoStrategies.KeyGenerationRequestResult =
			CryptoStrategies.KeyGenerationRequestResult.Allow

		override suspend fun verifyDelegatePublicKeys(
			delegate: CryptoActorStubWithType,
			publicKeys: List<SpkiHexString>,
			cryptoPrimitives: CryptoService
		): List<SpkiHexString> =
			publicKeys

		override suspend fun dataOwnerRequiresAnonymousDelegation(dataOwner: CryptoActorStubWithType): Boolean =
			dataOwner.type == DataOwnerType.Patient
	}

	"Api should automatically create needed transfer keys and use them to recover missing keys" {
		val hcp = createHcpUser()
		val originalKeyIdentifier = hcp.publicKeySpki.fingerprintV1().asAmbiguousIdentifier()
		val originalApi = hcp.api(VerifyEverythingStrategy(false))
		val (secondApi, secondKey) = hcp.apiWithLostKeys(VerifyEverythingStrategy(true))
		// Automatically creates the transfer key original->second
		val secondKeyIdentifier = defaultCryptoService.rsa.exportSpkiHex(secondKey.public).fingerprintV1().asAmbiguousIdentifier()
		secondApi.dataOwner.getCurrentDataOwner().dataOwner.transferKeys.also { transferKeys ->
			transferKeys shouldHaveSize 1
			val originalToSecond = transferKeys[originalKeyIdentifier].shouldNotBeNull()
			originalToSecond.keys shouldBe setOf(secondKeyIdentifier)
		}
		secondApi.crypto.internal.userEncryptionKeysManager.getDecryptionKeys().allKeys shouldHaveSize 1
		// Automatically creates the transfer key second->original
		val originalApiWithRecoveredSecond = hcp.api(VerifyEverythingStrategy(false))
		originalApiWithRecoveredSecond.crypto.internal.userEncryptionKeysManager.getDecryptionKeys().allKeys shouldHaveSize 2
		originalApiWithRecoveredSecond.dataOwner.getCurrentDataOwner().dataOwner.transferKeys.also { transferKeys ->
			transferKeys shouldHaveSize 2
			val originalToSecond = transferKeys[originalKeyIdentifier].shouldNotBeNull()
			originalToSecond.keys shouldBe setOf(secondKeyIdentifier)
			val secondToOriginal = transferKeys[secondKeyIdentifier].shouldNotBeNull()
			secondToOriginal.keys shouldBe setOf(originalKeyIdentifier)
		}
		val secondApiWithRecoveredOriginal = hcp.apiWithKeys(secondKey, cryptoStrategies = VerifyEverythingStrategy(false))
		secondApiWithRecoveredOriginal.crypto.internal.userEncryptionKeysManager.getDecryptionKeys().allKeys shouldHaveSize 2
	}
})
