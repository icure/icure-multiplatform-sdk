package com.icure.sdk.crypto

import com.icure.sdk.IcureSdk
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.embed.AccessLevel
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
	val patientNote = "This will be encrypted - patient"
	val heNote = "This will be encrypted - he"

	beforeAny {
		initialiseTestEnvironment()
	}

	suspend fun testCreateSharedData(delegator: DataOwnerDetails, delegate: DataOwnerDetails) {
		val delegatorApi: IcureSdk = delegator.api()
		val patient = delegatorApi.patient.createPatient(
			delegatorApi.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = UUID.randomUUID().toString(),
					firstName = "John",
					lastName = "Doe",
					note = patientNote
				),
				delegates = mapOf(delegate.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val he = delegatorApi.healthcareElement.createHealthcareElement(
			delegatorApi.healthcareElement.withEncryptionMetadata(
				base = DecryptedHealthElement(
					id = UUID.randomUUID().toString(),
					note = heNote,
				),
				patient = patient,
				user = delegatorApi.user.getCurrentUser(),
				delegates = mapOf(delegate.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		val delegateApi: IcureSdk = delegate.api()
		delegateApi.patient.getPatient(patient.id).run {
			note shouldBe patientNote
		}
		delegateApi.healthcareElement.getHealthcareElement(he.id).run {
			note shouldBe heNote
		}
		delegatorApi.patient.getPatient(patient.id).run {
			note shouldBe patientNote
		}
		delegatorApi.healthcareElement.getHealthcareElement(he.id).run {
			note shouldBe heNote
		}
	}

	suspend fun testShareExistingData(delegator: DataOwnerDetails, delegate: DataOwnerDetails) {
		val delegatorApi: IcureSdk =  delegator.api()
		val patient = delegatorApi.patient.createPatient(
			delegatorApi.patient.withEncryptionMetadata(DecryptedPatient(
				id = UUID.randomUUID().toString(),
				firstName = "John",
				lastName = "Doe",
				note = patientNote
			))
		).shouldNotBeNull()
		val sfk = delegatorApi.patient.getSecretIdsOf(patient).also { it shouldHaveSize 1 }
		val he = delegatorApi.healthcareElement.createHealthcareElement(
			delegatorApi.healthcareElement.withEncryptionMetadata(
				base = DecryptedHealthElement(
					id = UUID.randomUUID().toString(),
					note = heNote,
				),
				user = delegatorApi.user.getCurrentUser(),
				patient = patient
			)
		).shouldNotBeNull()
		delegatorApi.patient.shareWith(
			delegate.dataOwnerId,
			patient,
			sfk
		).shouldNotBeNull()
		delegatorApi.healthcareElement.shareWith(
			delegate.dataOwnerId,
			he
		).shouldNotBeNull()
		val delegateApi: IcureSdk = delegate.api()
		delegateApi.patient.getPatient(patient.id).run {
			note shouldBe patientNote
		}
		delegateApi.healthcareElement.getHealthcareElement(he.id).run {
			note shouldBe heNote
		}
		delegatorApi.patient.getPatient(patient.id).run {
			note shouldBe patientNote
		}
		delegatorApi.healthcareElement.getHealthcareElement(he.id).run {
			note shouldBe heNote
		}
	}

	"Test create shared data explicit->explicit" {
		testCreateSharedData(createHcpUser(), createHcpUser())
	}

	"Test create shared data explicit->anonymous" {
		testCreateSharedData(createHcpUser(), createPatientUser())
	}

	"Test create shared data anonymous->explicit" {
		testCreateSharedData(createHcpUser(), createPatientUser())
	}

	"Test create shared data anonymous->anonymous" {
		testCreateSharedData(createPatientUser(), createPatientUser())
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
