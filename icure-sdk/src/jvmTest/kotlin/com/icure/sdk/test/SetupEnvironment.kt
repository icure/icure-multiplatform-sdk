@file:OptIn(InternalIcureApi::class)

package com.icure.sdk.test

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.IcureApi
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawGroupApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.model.User
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.test.setup.ICureTestSetup
import java.util.UUID

val baseUrl = "http://localhost:16044"
private val testGroupName = "testgroup"
private val testGroupId = testGroupName
private val testGroupAdmin = "admin-${UUID.randomUUID()}@icure.com"
private val testGroupAdminPassword = "admin-${UUID.randomUUID()}"
val testGroupAdminAuth = JwtAuthService(
	RawAnonymousAuthApi(baseUrl),
	UsernamePassword(testGroupAdmin, testGroupAdminPassword),
)
private val superadminAuth = JwtAuthService(
	RawAnonymousAuthApi(baseUrl),
	UsernamePassword("john", "LetMeIn"),
)
private val defaultRoles = mapOf(
	"PATIENT" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"HCP" to "BASIC_USER\", \"BASIC_DATA_OWNER\", \"PATIENT_USER_MANAGER\", \"LEGACY_MESSAGE_MANAGER\", \"HIERARCHICAL_DATA_OWNER",
	"DEVICE" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"USER" to "BASIC_USER"
)
private var initialised = false

suspend fun initialiseTestEnvironment() {
	if (initialised) {
		return
	}
	initialised = true
	println("Starting kraken")
	ICureTestSetup.startKrakenEnvironment(
		"file:///Users/trema/icure-typescript-sdk/test/scratch/docker-compose-cloud-debuggable.yaml",
		listOf("mock"),
		"/Users/trema/icure-typescript-sdk/test/scratch"
	)
	println("Bootstrap cloud")
	ICureTestSetup.bootstrapCloud(
		"xx",
		"xx",
		UUID.randomUUID().toString(),
		"john",
		couchDbUser = "icure",
		couchDbPassword = "icure",
		rootUserRoles = defaultRoles
	)
	println("Creating test group")
	val groupApi = RawGroupApi(baseUrl, superadminAuth)
	if (groupApi.getGroup(testGroupId).status.value == 200) {
		println("Group already exist")
	} else  {
		println("Creating group")
		groupApi.createGroup(
			testGroupId,
			testGroupName,
			password = UUID.randomUUID().toString(),
			initialisationData = DatabaseInitialisation(
				users = emptyList(),
				healthcareParties = emptyList(),
			)
		)
	}
	println("Creating admin user - $testGroupAdmin:$testGroupAdminPassword")
	RawUserApi(baseUrl, superadminAuth).createAdminUserInGroup(
		testGroupId,
		User(
			UUID.randomUUID().toString(),
			login = testGroupAdmin,
			email = testGroupAdmin,
			passwordHash = testGroupAdminPassword,
		)
	).successBody()
	println("Environment initialisation successful")
}

data class DataOwnerDetails(
	val dataOwnerId: String,
	val username: String,
	val password: String,
	val keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	val parent: DataOwnerDetails?
) {
	suspend fun api(): IcureApi {
		return IcureApi.initialise(
			baseUrl,
			UsernamePassword(username, password),
			VolatileStorageFacade().also {
				addKeyToStorage(IcureStorageFacade(
					JsonAndBase64KeyStorage(it),
					it,
					DefaultStorageEntryKeysFactory,
					defaultCryptoService,
					false
				))
			},
			true
		)
	}

	private suspend fun addKeyToStorage(storage: IcureStorageFacade) {
		storage.saveEncryptionKeypair(
			dataOwnerId,
			keypair,
			true
		)
		parent?.addKeyToStorage(storage)
	}
}

/**
 * @param parent if not null, specifies the direct parent of this data owner. If that parent has a parent then the
 * latter will be the grandparent of this data owner, and so on. If null the data owner will not have any parent.
 */
suspend fun createHcpUser(parent: DataOwnerDetails? = null): DataOwnerDetails {
	val hcpRawApi = RawHealthcarePartyApi(baseUrl, testGroupAdminAuth)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth)
	val hcpId = UUID.randomUUID().toString()
	val login = "hcp-${UUID.randomUUID()}"
	val password = UUID.randomUUID().toString()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val hcp = hcpRawApi.createHealthcareParty(
		HealthcareParty(
			hcpId,
			firstName = "Hcp-$hcpId",
			lastName = "Hcp-$hcpId",
			publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) }),
			parentId = parent?.dataOwnerId
		)
	).successBody()
	userRawApi.createUser(
		User(
			UUID.randomUUID().toString(),
			login = login,
			email = login,
			passwordHash = password,
			healthcarePartyId = hcp.id
		)
	).successBody()
	return DataOwnerDetails(hcpId, login, password, keypair, parent).also { println("Created hcp $it") }
}

suspend fun createPatientUser(): DataOwnerDetails {
	val patientRawApi = RawPatientApi(baseUrl, testGroupAdminAuth, null)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth)
	val patientId = UUID.randomUUID().toString()
	val login = "patient-${UUID.randomUUID()}"
	val password = UUID.randomUUID().toString()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val patient = patientRawApi.createPatient(
		DecryptedPatient(
			patientId,
			firstName = "Patient-$patientId",
			lastName = "Patient-$patientId",
			publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) })
		)
	).successBody()
	userRawApi.createUser(
		User(
			UUID.randomUUID().toString(),
			login = login,
			email = login,
			passwordHash = password,
			patientId = patient.id
		)
	).successBody()
	return DataOwnerDetails(patientId, login, password, keypair, null).also { println("Created patient $it") }
}

suspend fun createUserFromExistingPatient(patient: Patient): DataOwnerDetails {
	val patientRawApi = RawPatientApi(baseUrl, testGroupAdminAuth, NoAccessControlKeysHeadersProvider)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth)
	val login = "patient-${UUID.randomUUID()}"
	val password = UUID.randomUUID().toString()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val updatedPatient = patientRawApi.modifyPatient(
		patientRawApi.getPatient(patient.id).successBody().copy(
			publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) })
		)
	).successBody()
	userRawApi.createUser(
		User(
			UUID.randomUUID().toString(),
			login = login,
			email = login,
			passwordHash = password,
			patientId = updatedPatient.id
		)
	).successBody()
	return DataOwnerDetails(patient.id, login, password, keypair, null).also { println("Created user for patient $it") }
}