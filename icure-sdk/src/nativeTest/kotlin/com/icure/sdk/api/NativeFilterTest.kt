package com.icure.sdk.api

import com.icure.sdk.filters.PatientFilters
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initializeTestEnvironment
import com.icure.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class NativeFilterTest : StringSpec({

	beforeAny {
		initializeTestEnvironment()
	}

	"Can filter using a patient filter" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()
		val hcpUser = api.user.getCurrentUser()

		val patient = api.patient.createPatient(
			api.patient.withEncryptionMetadata(DecryptedPatient(
				id = uuid(),
				firstName = "Giovanni",
				lastName = "Giorgio",
				dateOfBirth = 19960707
			))
		)

		patient.dateOfBirth shouldBe 19960707

		val iterator = api.patient.filterPatientsBy(
			PatientFilters.byDateOfBirthBetweenForDataOwner(
				dataOwnerId = hcpUser.healthcarePartyId.shouldNotBeNull(),
				fromDate = 19950101,
				toDate = 19970101
			)
		)
		val result = mutableListOf<DecryptedPatient>()
		while(iterator.hasNext()) {
			result += iterator.next(100)
		}
		result.size shouldBe 1
		result.first() shouldBe patient
	}

})
