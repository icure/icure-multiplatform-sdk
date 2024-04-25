@file:OptIn(InternalIcureApi::class)

package com.icure.sdk.test

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.ApiOptions
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawGroupApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.test.setup.ICureTestSetup
import io.kotest.common.runBlocking
import java.util.UUID

val baseUrl = "http://localhost:16044"
private val testGroupName = "testgroup"
private val testGroupId = testGroupName
private val testGroupAdmin = "admin-${UUID.randomUUID()}@icure.com"
private val testGroupAdminPassword = "admin-${UUID.randomUUID()}"
val testGroupAdminAuth = JwtAuthService(
	RawAnonymousAuthApi(baseUrl, IcureSdk.sharedHttpClient),
	UsernamePassword(testGroupAdmin, testGroupAdminPassword),
)
private val superadminAuth = JwtAuthService(
	RawAnonymousAuthApi(baseUrl, IcureSdk.sharedHttpClient),
	UsernamePassword("john", "LetMeIn"),
)
private val defaultRoles = mapOf(
	"PATIENT" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"HCP" to "BASIC_USER\", \"BASIC_DATA_OWNER\", \"PATIENT_USER_MANAGER\", \"LEGACY_MESSAGE_MANAGER\", \"HIERARCHICAL_DATA_OWNER",
	"DEVICE" to "BASIC_USER\", \"BASIC_DATA_OWNER",
	"USER" to "BASIC_USER"
)
private var initialised = false

@OptIn(InternalIcureApi::class)
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
	val groupApi = RawGroupApi(baseUrl, superadminAuth, IcureSdk.sharedHttpClient)
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
	RawUserApi(baseUrl, superadminAuth, IcureSdk.sharedHttpClient).createAdminUserInGroup(
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
	val publicKeySpki = runBlocking { SpkiHexString(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString()) }

	/**
	 * Creates a new api with access to the original key of the user and his parents.
	 */
	suspend fun api(cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): IcureSdk =
		initApi(cryptoStrategies) { addInitialKeysToStorage(it) }

	/**
	 * Creates a new api with access to the provided keys.
	 * All the keys must be keys of the data owner and not of parents.
	 */
	suspend fun apiWithKeys(
		vararg keys: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
		cryptoStrategies: CryptoStrategies = BasicCryptoStrategies
	): IcureSdk =
		initApi(cryptoStrategies) { storage ->
			keys.forEach { key ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					key,
					true
				)
			}
		}

	/**
	 * Creates an api simulating the loss of all keys for the user, prompting the creation of a new key.
	 * @return the api and the new key
 	 */
	suspend fun apiWithLostKeys(cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): Pair<IcureSdk, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		val newKey = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
		return Pair(
			initApi(
				object : CryptoStrategies by cryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						val customResult = kotlin.runCatching {
							cryptoStrategies.generateNewKeyForDataOwner(self, cryptoPrimitives)
						}
						require(
							customResult.isSuccess
								&& customResult.getOrThrow() !is CryptoStrategies.KeyGenerationRequestResult.Use
						) {
							"`apiWithLostKeys` overrides the key generation strategy, so it should not provide a custom key or throw an exception."
						}
						return CryptoStrategies.KeyGenerationRequestResult.Use(newKey)
					}

				}
			) { storage ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					newKey,
					true
				)
			},
			newKey
		)
	}

	fun authService() =
		JwtAuthService(RawAnonymousAuthApi(baseUrl, IcureSdk.sharedHttpClient), UsernamePassword(username, password))

	@OptIn(InternalIcureApi::class)
	private suspend fun initApi(
		cryptoStrategies: CryptoStrategies,
		fillStorage: suspend (storage: IcureStorageFacade) -> Unit
	): IcureSdk =
		IcureSdk.initialise(
			baseUrl,
			UsernamePassword(username, password),
			VolatileStorageFacade().also {
				IcureStorageFacade(
					JsonAndBase64KeyStorage(it),
					it,
					DefaultStorageEntryKeysFactory,
					defaultCryptoService,
					false
				).also { fillStorage(it) }
			},
			cryptoStrategies,
			ApiOptions(
				disableParentKeysInitialisation = false
			)
		)

	private suspend fun addInitialKeysToStorage(storage: IcureStorageFacade) {
		storage.saveEncryptionKeypair(
			dataOwnerId,
			keypair,
			true
		)
		parent?.addInitialKeysToStorage(storage)
	}

	fun hierarchy(): List<String> = parent?.hierarchy().orEmpty() + dataOwnerId
}

/**
 * @param parent if not null, specifies the direct parent of this data owner. If that parent has a parent then the
 * latter will be the grandparent of this data owner, and so on. If null the data owner will not have any parent.
 */
suspend fun createHcpUser(parent: DataOwnerDetails? = null, useLegacyKey: Boolean = false): DataOwnerDetails {
	val hcpRawApi = RawHealthcarePartyApi(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient)
	val hcpId = UUID.randomUUID().toString()
	val login = "hcp-${UUID.randomUUID()}"
	val password = UUID.randomUUID().toString()
	val keypair = defaultCryptoService.rsa.generateKeyPair(
		if (useLegacyKey)
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		else
			RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256

	)
	val exportedPublic = defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) }
	val hcp = hcpRawApi.createHealthcareParty(
		HealthcareParty(
			hcpId,
			firstName = "Hcp-$hcpId",
			lastName = "Hcp-$hcpId",
			publicKeysForOaepWithSha256 = if (useLegacyKey) emptySet() else setOf(exportedPublic),
			publicKey = if (useLegacyKey) exportedPublic else null,
			parentId = parent?.dataOwnerId
		)
	).successBody()
	userRawApi.createUser(
		User(
			UUID.randomUUID().toString(),
			login = login,
			email = login,
			passwordHash = password,
			healthcarePartyId = hcp.id,
			autoDelegations = mapOf(DelegationTag.All to parent?.hierarchy()?.toSet().orEmpty())
		)
	).successBody()
	return DataOwnerDetails(hcpId, login, password, keypair, parent).also { println("Created hcp $it") }
}

suspend fun createPatientUser(existingPatientId: String? = null): DataOwnerDetails {
	val patientRawApi = RawPatientApi(baseUrl, testGroupAdminAuth, null, IcureSdk.sharedHttpClient)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient)
	val patientId = existingPatientId ?: UUID.randomUUID().toString()
	val login = "patient-${UUID.randomUUID()}"
	val password = UUID.randomUUID().toString()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val patientToCreateOrModify = (existingPatientId?.let { patientRawApi.getPatient(it).successBody() } ?: EncryptedPatient(
		patientId,
		firstName = "Patient-$patientId",
		lastName = "Patient-$patientId",
	)).copy(
		publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) })
	)
	val patient = if (patientToCreateOrModify.rev != null) {
		patientRawApi.modifyPatient(patientToCreateOrModify).successBody()
	} else {
		patientRawApi.createPatient(patientToCreateOrModify).successBody()
	}
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
	val patientRawApi = RawPatientApi(baseUrl, testGroupAdminAuth, NoAccessControlKeysHeadersProvider, IcureSdk.sharedHttpClient)
	val userRawApi = RawUserApi(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient)
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
