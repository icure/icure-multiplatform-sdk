package com.icure.sdk.crypto

import com.icure.sdk.api.IcureApi
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createPatientUser
import com.icure.sdk.test.initialiseTestEnvironment
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import java.util.UUID

class ExplicitAndAnonymousDelegatorsShareTests : StringSpec({
	beforeAny {
		initialiseTestEnvironment()
	}

	suspend fun testShareExistingData(delegator: DataOwnerDetails, delegate: DataOwnerDetails) {
		val delegatorApi: IcureApi =  delegator.api()
		val patientNote = "This will be encrypted - patient"
		val heNote = "This will be encrypted - he"
		val patient = delegatorApi.patient.encryptAndCreate(
			delegatorApi.patient.initialiseEncryptionMetadata(Patient(
				id = UUID.randomUUID().toString(),
				firstName = "John",
				lastName = "Doe",
				note = patientNote
			))
		).shouldNotBeNull()
		val sfk = delegatorApi.patient.getSecretIdsOf(patient).also { it shouldHaveSize 1 }
		val he = delegatorApi.healthElement.encryptAndCreate(
			delegatorApi.healthElement.initialiseEncryptionMetadata(
				he = HealthElement(
					id = UUID.randomUUID().toString(),
					note = heNote,
				),
				patient = patient
			)
		).shouldNotBeNull()
		delegatorApi.patient.shareWith(
			delegate.dataOwnerId,
			patient,
			sfk
		).shouldNotBeNull()
		delegatorApi.healthElement.shareWith(
			delegate.dataOwnerId,
			he
		).shouldNotBeNull()
		val delegateApi: IcureApi = delegate.api()
		delegateApi.patient.getAndDecrypt(patient.id).shouldNotBeNull().run {
			note shouldBe patientNote
		}
		delegateApi.healthElement.getAndDecrypt(he.id).shouldNotBeNull().run {
			note shouldBe heNote
		}
		delegatorApi.patient.getAndDecrypt(patient.id).shouldNotBeNull().run {
			note shouldBe patientNote
		}
		delegatorApi.healthElement.getAndDecrypt(he.id).shouldNotBeNull().run {
			note shouldBe heNote
		}
	}

	"Test share existing data explicit->explicit" {
		testShareExistingData(createHcpUser(), createHcpUser())
	}

	"Test share existing data explicit->anonymous" {
		testShareExistingData(createHcpUser(), createPatientUser())
	}

	"Test share existing data anonymous->explicit" {
		testShareExistingData(createHcpUser(), createPatientUser())
	}

	"Test share existing data anonymous->anonymous" {
		testShareExistingData(createPatientUser(), createPatientUser())
	}
})