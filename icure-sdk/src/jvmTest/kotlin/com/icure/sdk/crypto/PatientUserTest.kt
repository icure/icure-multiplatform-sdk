package com.icure.sdk.crypto

import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createUserFromExistingPatient
import com.icure.sdk.test.initialiseTestEnvironment
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import java.util.UUID

class PatientUserTest : StringSpec({
	beforeAny {
		initialiseTestEnvironment()
	}

	"A new user created from an existing patient should be able to create data for himself" {
		val hcpApi = createHcpUser().api()
		val patientDetails = createUserFromExistingPatient(
			hcpApi.patient.encryptAndCreate(
				hcpApi.patient.initialiseEncryptionMetadata(
					DecryptedPatient(
						id = UUID.randomUUID().toString(),
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
		val createdData = patientApi.healthcareElement.createHealthcareElement(
			patientApi.healthcareElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = UUID.randomUUID().toString(),
					note = "Some note"
				),
				encryptedPatient,
				patientApi.user.getCurrentUser(),
			)
		).shouldNotBeNull()
		val retrievedData = patientApi.healthcareElement.findHealthcareElementsByHcPartyPatient(
			encryptedPatient.id,
			encryptedPatient,
			limit = 100
		).single()
		retrievedData.note.shouldNotBeNull() shouldBe createdData.note
	}
})
