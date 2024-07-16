package com.icure.sdk.api

import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NativeFilterTest : StringSpec({

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

		val result = api.patient.filterPatientsBy(
			FilterChain(
				filter = PatientByHcPartyDateOfBirthBetweenFilter(
					healthcarePartyId = hcpUser.healthcarePartyId,
					minDateOfBirth = 19950101,
					maxDateOfBirth = 19970101
				)
			)
		)
		result.rows.size shouldBe 1
		result.rows.first() shouldBe patient
	}

})
