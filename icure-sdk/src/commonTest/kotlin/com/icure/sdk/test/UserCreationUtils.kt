package com.icure.sdk.test

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.test.DataOwnerDetails
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization

fun uuid() = defaultCryptoService.strongRandom.randomUUID()

@OptIn(InternalIcureApi::class)
suspend fun createUserInMultipleGroups(): Map<String, DataOwnerDetails> {
	val groupId1 = uuid()
	val groupId2 = uuid()
	val groupId3 = uuid()
	val userLogin = "edmond.dantes+${uuid()}@montecristo.fr"
	val userPw12 = uuid()
	val userPw3 = uuid()
	val userId1 = uuid()
	val userId2 = uuid()
	val userId3 = uuid()
	val groupRawApi = RawGroupApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	val userRawApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	groupRawApi.createGroup(
		id = groupId1,
		name = "test-group-1-${groupId1}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	groupRawApi.createGroup(
		id = groupId2,
		name = "test-group-2-${groupId2}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	groupRawApi.createGroup(
		id = groupId3,
		name = "test-group-3-${groupId3}",
		type = null,
		password = uuid(),
		server = null,
		q = null,
		n = null,
		superGroup = null,
		initialisationData = DatabaseInitialisation()
	).successBody()
	val user1 = userRawApi.createUserInGroup(
		groupId1,
		User(
			id = userId1,
			login = userLogin,
			name = userLogin,
			email = userLogin,
			passwordHash = userPw12
		)
	).successBody()
	val user2 = userRawApi.createUserInGroup(
		groupId2,
		User(
			id = userId2,
			login = userLogin,
			name = userLogin,
			email = userLogin,
			passwordHash = userPw12
		)
	).successBody()
	val user3 = userRawApi.createUserInGroup(
		groupId3,
		User(
			id = userId3,
			login = userLogin,
			name = userLogin,
			email = userLogin,
			passwordHash = userPw3
		)
	).successBody()
	return mapOf(
		groupId1 to DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw12,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null
		),
		groupId2 to DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw12,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null
		),
		groupId3 to DataOwnerDetails(
			dataOwnerId = "",
			username = userLogin,
			password = userPw3,
			keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256),
			parent = null
		),
	)
}

/**
 * @param parent if not null, specifies the direct parent of this data owner. If that parent has a parent then the
 * latter will be the grandparent of this data owner, and so on. If null the data owner will not have any parent.
 */
@OptIn(InternalIcureApi::class)
suspend fun createHcpUser(parent: DataOwnerDetails? = null, useLegacyKey: Boolean = false): DataOwnerDetails {
	val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	val userRawApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	val hcpId = uuid()
	val login = "hcp-${uuid()}"
	val password = uuid()
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
			uuid(),
			login = login,
			email = login,
			passwordHash = password,
			healthcarePartyId = hcp.id,
			autoDelegations = mapOf(DelegationTag.All to parent?.hierarchy()?.toSet().orEmpty())
		)
	).successBody()
	return DataOwnerDetails(hcpId, login, password, keypair, parent).also { println("Created hcp $it") }
}

@OptIn(InternalIcureApi::class)
suspend fun createPatientUser(existingPatientId: String? = null): DataOwnerDetails {
	val patientRawApi = RawPatientApiImpl(baseUrl, testGroupAdminAuth, null, IcureSdk.sharedHttpClient, json = Serialization.json)
	val userRawApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	val patientId = existingPatientId ?: uuid()
	val login = "patient-${uuid()}"
	val password = uuid()
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
			uuid(),
			login = login,
			email = login,
			passwordHash = password,
			patientId = patient.id
		)
	).successBody()
	return DataOwnerDetails(patientId, login, password, keypair, null).also { println("Created patient $it") }
}

@OptIn(InternalIcureApi::class)
suspend fun createUserFromExistingPatient(patient: Patient): DataOwnerDetails {
	val patientRawApi = RawPatientApiImpl(baseUrl, testGroupAdminAuth, NoAccessControlKeysHeadersProvider, IcureSdk.sharedHttpClient, json = Serialization.json)
	val userRawApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
	val login = "patient-${uuid()}"
	val password = uuid()
	val keypair = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
	val updatedPatient = patientRawApi.modifyPatient(
		patientRawApi.getPatient(patient.id).successBody().copy(
			publicKeysForOaepWithSha256 = setOf(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString().let { SpkiHexString(it) })
		)
	).successBody()
	userRawApi.createUser(
		User(
			uuid(),
			login = login,
			email = login,
			passwordHash = password,
			patientId = updatedPatient.id
		)
	).successBody()
	return DataOwnerDetails(patient.id, login, password, keypair, null).also { println("Created user for patient $it") }
}
