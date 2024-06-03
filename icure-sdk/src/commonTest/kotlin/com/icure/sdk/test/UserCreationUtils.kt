import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
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
