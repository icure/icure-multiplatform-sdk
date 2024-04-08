package com.icure.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.crypto.impl.exportSpkiHex
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class ShamirKeyRecovery : StringSpec({
	beforeAny { initialiseTestEnvironment() }

	suspend fun doTest(
		userDetails: DataOwnerDetails,
		shareWith: Set<DataOwnerDetails>,
		askAccessBackTo: Set<DataOwnerDetails>
	) {
		val api = userDetails.api()
		val note = "Secret note"
		val createdPatient = api.patient.encryptAndCreate(
			api.patient.initialiseEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				)
			)
		)
		api.crypto.shamirKeysManager.updateSelfSplits(
			mapOf(userDetails.publicKeySpki.fingerprintV1() to ShamirKeysManager.ShamirUpdateRequest(
				notariesIds = shareWith.mapTo(mutableSetOf()) { it.dataOwnerId },
				minShares = askAccessBackTo.size
			)),
			emptySet()
		)
		val (lostKeyApi, newKey) = userDetails.apiWithLostKeys()
		lostKeyApi.patient.getAndDecrypt(patientId = createdPatient!!.id).shouldBeNull() // TODO Should not be able to decrypt note, will throw exception in actual implementation
		askAccessBackTo.forEach { giveAccessBackDataOwner ->
			giveAccessBackDataOwner.api().icureMaintenanceTask.applyKeyPairUpdate(
				KeyPairUpdateNotification(
					concernedDataOwnerId = userDetails.dataOwnerId,
					newPublicKey = defaultCryptoService.rsa.exportSpkiHex(newKey.public)
				)
			)
		}
		val recoveredThroughShamirApi = userDetails.apiWithKeys(newKey)
		recoveredThroughShamirApi.patient.getAndDecrypt(patientId = createdPatient.id).shouldNotBeNull().note shouldBe note
	}

	"Api should automatically load keys recoverable through shamir split on startup (true secret share)" {
		val hcpLosingKey = createHcpUser(useLegacyKey = true)
		val friend1 = createHcpUser(useLegacyKey = true)
		val friend2 = createHcpUser(useLegacyKey = true)
		val friend3 = createHcpUser(useLegacyKey = false)
		val friend4 = createHcpUser(useLegacyKey = false)
		doTest(hcpLosingKey, setOf(friend1, friend2, friend3, friend4), setOf(friend2, friend3))
	}

	"Api should automatically load keys recoverable through shamir split on startup (share with single user)" {
		val hcpLosingKey = createHcpUser(useLegacyKey = true)
		val friend = createHcpUser()
		doTest(hcpLosingKey, setOf(friend), setOf(friend))
	}
})
