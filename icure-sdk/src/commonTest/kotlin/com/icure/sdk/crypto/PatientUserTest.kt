package com.icure.sdk.crypto

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createUserFromExistingPatient
import com.icure.sdk.test.initializeTestEnvironment
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class PatientUserTest : StringSpec({
	beforeAny {
		initializeTestEnvironment()
	}

	"A new user created from an existing patient should be able to create data for himself" {
		val hcpApi = createHcpUser().api()
		val patientDetails = createUserFromExistingPatient(
			hcpApi.patient.createPatient(
				hcpApi.patient.withEncryptionMetadata(
					DecryptedPatient(
						id = defaultCryptoService.strongRandom.randomUUID(),
						firstName = "John",
						lastName = "Doe",
						note = "This note will not be visible to the patient"
					)
				)
			).shouldNotBeNull()
		)
		val patientApi = patientDetails.api()
		// Data owner api does not decrypt, so we can use that since the current patient can't decrypt his own info
		val encryptedPatient = patientApi.dataOwner.getCurrentDataOwner().shouldBeInstanceOf<DataOwnerWithType.PatientDataOwner>().dataOwner
		val createdData = patientApi.healthElement.createHealthElement(
			patientApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = "Some note"
				),
				encryptedPatient,
				patientApi.user.getCurrentUser(),
			)
		).shouldNotBeNull()
		val retrievedData = patientApi.healthElement.findHealthElementsByHcPartyPatient(
			encryptedPatient.id,
			encryptedPatient,
		).next()
		retrievedData.note.shouldNotBeNull() shouldBe createdData.note
	}
})