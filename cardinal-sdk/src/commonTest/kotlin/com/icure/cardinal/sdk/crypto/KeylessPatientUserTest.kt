package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.entities.RawDecryptedExchangeData
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.extensions.dataOwnerId
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createUserFromExistingPatient
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class KeylessPatientUserTest : StringSpec({
	val specJob = autoCancelJob()

	lateinit var hcp: DataOwnerDetails
	lateinit var hcpApi: CardinalSdk
	lateinit var patientDetails: DataOwnerDetails
	lateinit var exchangeData: RawDecryptedExchangeData

	beforeSpec {
		initializeTestEnvironment()

		hcp = createHcpUser()
		hcpApi = hcp.api(specJob)
		patientDetails = createUserFromExistingPatient(
			hcpApi.patient.createPatient(
				hcpApi.patient.withEncryptionMetadata(
					DecryptedPatient(
						id = defaultCryptoService.strongRandom.randomUUID(),
						firstName = "John",
						lastName = "Doe",
						note = "This note will not be visible to the patient"
					)
				)
			).shouldNotBeNull(), true
		)

		val patientApi = patientDetails.api(specJob, object:CryptoStrategies {
			override suspend fun generateNewKeyForDataOwner(
				self: DataOwnerWithType,
				cryptoPrimitives: CryptoService
			): CryptoStrategies.KeyGenerationRequestResult {
				return CryptoStrategies.KeyGenerationRequestResult.Keyless
			}
		})
		exchangeData = patientApi.crypto.keylessCreateExchangeDataTo(hcp.dataOwnerId).shouldNotBeNull()
	}

	suspend fun getPatientApi(): CardinalSdk = patientDetails.api(
		specJob,
		object : CryptoStrategies {
			override suspend fun generateNewKeyForDataOwner(
				self: DataOwnerWithType,
				cryptoPrimitives: CryptoService,
			): CryptoStrategies.KeyGenerationRequestResult {
				return CryptoStrategies.KeyGenerationRequestResult.Keyless
			}
		},
	)

	suspend fun createCalendarItem(patientApi: CardinalSdk, patient: Patient, patientUser: User): DecryptedCalendarItem {
		val startTime = currentEpochMs() + Math.random().toInt()
		return patientApi.calendarItem.createCalendarItem(patientApi.calendarItem.withEncryptionMetadata(
			base = DecryptedCalendarItem(
				id = defaultCryptoService.strongRandom.randomUUID(),
				title = "My appointment",
				startTime = startTime,
				endTime = startTime + 3600000, // 1 hour later
				details = "This note will not be visible to the patient"
			),
			patient = patient,
			user = patientUser,
			secretId = SecretIdUseOption.UseNone,
			alternateRootDataOwnerReference = EntityReferenceInGroup(hcp.dataOwnerId)
		))

	}

	"A keyless API should allow creation of data and retrieval by delegator and delegate" {
		val patientApi = getPatientApi()

		// Arrange: initialize test data
		val patientUser = patientApi.user.getCurrentUser()
		val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()

		val ci = createCalendarItem(patientApi, patient, patientUser)

		// Patient retrieves the calendar item
		val retrievedByPatient = patientApi.calendarItem.getCalendarItem(ci.id)!!
		retrievedByPatient.title shouldBe ci.title
		patientApi.calendarItem.decryptPatientIdOf(retrievedByPatient).map { it.entityId } shouldBe listOf(patient.id)

		// HCP retrieves the calendar item
		val retrievedByHcp = hcpApi.calendarItem.getCalendarItem(ci.id)!!
		retrievedByHcp.title shouldBe ci.title
		hcpApi.calendarItem.decryptPatientIdOf(retrievedByHcp).map { it.entityId } shouldBe listOf(patient.id)
	}

	"A keyless API should allow retrieval in new instance after exchange data injection" {
		// Arrange: initialize test data
		val patientApi = getPatientApi()
		val patientUser = patientApi.user.getCurrentUser()
		val patient = patientApi.patient.encrypted.getPatient(patientUser.dataOwnerId).shouldNotBeNull()

		val ci = createCalendarItem(patientApi, patient, patientUser)

		// Simulate a new API instance (new session)
		val newPatientApi = patientDetails.api(
			specJob,
			object : CryptoStrategies {
				override suspend fun generateNewKeyForDataOwner(
					self: DataOwnerWithType,
					cryptoPrimitives: CryptoService,
				): CryptoStrategies.KeyGenerationRequestResult {
					return CryptoStrategies.KeyGenerationRequestResult.Keyless
				}
			},
		)

		// Before injecting exchange data, retrieval should fail
		runCatching {
			newPatientApi.calendarItem.getCalendarItemWithUser(patientUser, ci.id)
		}.isFailure shouldBe true

		// Inject exchange data (simulate what the TS test does)
		newPatientApi.crypto.injectExchangeData(listOf(exchangeData.copy(verified = false)), false)

		// After injection, retrieval should succeed
		val retrievedByNewApi = newPatientApi.calendarItem.getCalendarItemWithUser(patientUser, ci.id)
		retrievedByNewApi.shouldNotBeNull()
		retrievedByNewApi.title shouldBe ci.title
		newPatientApi.calendarItem.decryptPatientIdOf(retrievedByNewApi).map { it.entityId } shouldBe listOf(patient.id)
	}


})
