package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.Person
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DeactivationReason
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.DecryptedInsurability
import com.icure.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EmploymentInfo
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedAddress
import com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.EncryptedInsurability
import com.icure.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.sdk.model.embed.FinancialInstitutionInformation
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.Insurability
import com.icure.sdk.model.embed.MedicalHouseContract
import com.icure.sdk.model.embed.Partnership
import com.icure.sdk.model.embed.PatientHealthCareParty
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.PersonalStatus
import com.icure.sdk.model.embed.SchoolingInfo
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Patient :
	StoredDocument,
	ICureDocument<String>,
	Person,
	HasEncryptionMetadata,
	Encryptable,
	CryptoActor {
	override val id: String

	public val identifier: List<Identifier>

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	override val firstName: String?

	override val lastName: String?

	override val names: List<PersonName>

	override val companyName: String?

	override val languages: List<String>

	override val addresses: List<Address>

	override val civility: String?

	override val gender: Gender?

	public val birthSex: Gender?

	public val mergeToPatientId: String?

	public val mergedIds: Set<String>

	public val alias: String?

	public val active: Boolean

	public val deactivationReason: DeactivationReason

	public val deactivationDate: Int?

	public val ssin: String?

	public val maidenName: String?

	public val spouseName: String?

	public val partnerName: String?

	public val personalStatus: PersonalStatus?

	public val dateOfBirth: Int?

	public val dateOfDeath: Int?

	public val timestampOfLatestEidReading: Long?

	public val placeOfBirth: String?

	public val placeOfDeath: String?

	public val deceased: Boolean?

	public val education: String?

	public val profession: String?

	public val notes: List<Annotation>

	public val note: String?

	public val administrativeNote: String?

	public val nationality: String?

	public val race: String?

	public val ethnicity: String?

	public val preferredUserId: String?

	public val picture: ByteArray?

	public val externalId: String?

	public val insurabilities: List<Insurability>

	public val partnerships: List<Partnership>

	public val patientHealthCareParties: List<PatientHealthCareParty>

	public val financialInstitutionInformation: List<FinancialInstitutionInformation>

	public val medicalHouseContracts: List<MedicalHouseContract>

	public val patientProfessions: List<CodeStub>

	public val parameters: Map<String, List<String>>

	public val properties: Set<PropertyStub>

	override val hcPartyKeys: Map<String, List<HexString>>

	override val aesExchangeKeys:
		Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>

	override val transferKeys:
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>

	override val privateKeyShamirPartitions: Map<String, HexString>

	override val publicKey: SpkiHexString?

	override val publicKeysForOaepWithSha256: Set<SpkiHexString>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?

	override val medicalLocationId: String?

	public val nonDuplicateIds: Set<String>

	public val encryptedAdministrativesDocuments: Set<String>

	public val comment: String?

	public val warning: String?

	public val fatherBirthCountry: CodeStub?

	public val birthCountry: CodeStub?

	public val nativeCountry: CodeStub?

	public val socialStatus: CodeStub?

	public val mainSourceOfIncome: CodeStub?

	public val schoolingInfos: List<SchoolingInfo>

	public val employementInfos: List<EmploymentInfo>
	// region Patient-Patient

	// endregion
}

@Serializable
data class DecryptedPatient(
	override val id: String,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val firstName: String? = null,
	override val lastName: String? = null,
	@DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	override val companyName: String? = null,
	@DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@DefaultValue("emptyList()")
	override val addresses: List<DecryptedAddress> = emptyList(),
	override val civility: String? = null,
	@DefaultValue("com.icure.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	@DefaultValue("com.icure.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	override val mergeToPatientId: String? = null,
	@DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	override val alias: String? = null,
	@DefaultValue("true")
	override val active: Boolean = true,
	@DefaultValue("com.icure.sdk.model.embed.DeactivationReason.None")
	override val deactivationReason: DeactivationReason = DeactivationReason.None,
	override val deactivationDate: Int? = null,
	override val ssin: String? = null,
	override val maidenName: String? = null,
	override val spouseName: String? = null,
	override val partnerName: String? = null,
	@DefaultValue("com.icure.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	override val dateOfBirth: Int? = null,
	override val dateOfDeath: Int? = null,
	override val timestampOfLatestEidReading: Long? = null,
	override val placeOfBirth: String? = null,
	override val placeOfDeath: String? = null,
	override val deceased: Boolean? = null,
	override val education: String? = null,
	override val profession: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	override val note: String? = null,
	override val administrativeNote: String? = null,
	override val nationality: String? = null,
	override val race: String? = null,
	override val ethnicity: String? = null,
	override val preferredUserId: String? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val picture: ByteArray? = null,
	override val externalId: String? = null,
	@DefaultValue("emptyList()")
	override val insurabilities: List<DecryptedInsurability> = emptyList(),
	@DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	@DefaultValue("emptyList()")
	override val patientHealthCareParties: List<DecryptedPatientHealthCareParty> = emptyList(),
	@DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
		emptyList(),
	@DefaultValue("emptyList()")
	override val medicalHouseContracts: List<DecryptedMedicalHouseContract> = emptyList(),
	@DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	@DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	@DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val nonDuplicateIds: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val encryptedAdministrativesDocuments: Set<String> = emptySet(),
	override val comment: String? = null,
	override val warning: String? = null,
	override val fatherBirthCountry: CodeStub? = null,
	override val birthCountry: CodeStub? = null,
	override val nativeCountry: CodeStub? = null,
	override val socialStatus: CodeStub? = null,
	override val mainSourceOfIncome: CodeStub? = null,
	@DefaultValue("emptyList()")
	override val schoolingInfos: List<SchoolingInfo> = emptyList(),
	@DefaultValue("emptyList()")
	override val employementInfos: List<EmploymentInfo> = emptyList(),
) : Patient {
	// region Patient-DecryptedPatient
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedPatient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedPatient(
	override val id: String,
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val firstName: String? = null,
	override val lastName: String? = null,
	@DefaultValue("emptyList()")
	override val names: List<PersonName> = emptyList(),
	override val companyName: String? = null,
	@DefaultValue("emptyList()")
	override val languages: List<String> = emptyList(),
	@DefaultValue("emptyList()")
	override val addresses: List<EncryptedAddress> = emptyList(),
	override val civility: String? = null,
	@DefaultValue("com.icure.sdk.model.embed.Gender.Unknown")
	override val gender: Gender? = Gender.Unknown,
	@DefaultValue("com.icure.sdk.model.embed.Gender.Unknown")
	override val birthSex: Gender? = Gender.Unknown,
	override val mergeToPatientId: String? = null,
	@DefaultValue("emptySet()")
	override val mergedIds: Set<String> = emptySet(),
	override val alias: String? = null,
	@DefaultValue("true")
	override val active: Boolean = true,
	@DefaultValue("com.icure.sdk.model.embed.DeactivationReason.None")
	override val deactivationReason: DeactivationReason = DeactivationReason.None,
	override val deactivationDate: Int? = null,
	override val ssin: String? = null,
	override val maidenName: String? = null,
	override val spouseName: String? = null,
	override val partnerName: String? = null,
	@DefaultValue("com.icure.sdk.model.embed.PersonalStatus.Unknown")
	override val personalStatus: PersonalStatus? = PersonalStatus.Unknown,
	override val dateOfBirth: Int? = null,
	override val dateOfDeath: Int? = null,
	override val timestampOfLatestEidReading: Long? = null,
	override val placeOfBirth: String? = null,
	override val placeOfDeath: String? = null,
	override val deceased: Boolean? = null,
	override val education: String? = null,
	override val profession: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	override val note: String? = null,
	override val administrativeNote: String? = null,
	override val nationality: String? = null,
	override val race: String? = null,
	override val ethnicity: String? = null,
	override val preferredUserId: String? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val picture: ByteArray? = null,
	override val externalId: String? = null,
	@DefaultValue("emptyList()")
	override val insurabilities: List<EncryptedInsurability> = emptyList(),
	@DefaultValue("emptyList()")
	override val partnerships: List<Partnership> = emptyList(),
	@DefaultValue("emptyList()")
	override val patientHealthCareParties: List<EncryptedPatientHealthCareParty> = emptyList(),
	@DefaultValue("emptyList()")
	override val financialInstitutionInformation: List<EncryptedFinancialInstitutionInformation> =
		emptyList(),
	@DefaultValue("emptyList()")
	override val medicalHouseContracts: List<EncryptedMedicalHouseContract> = emptyList(),
	@DefaultValue("emptyList()")
	override val patientProfessions: List<CodeStub> = emptyList(),
	@DefaultValue("emptyMap()")
	override val parameters: Map<String, List<String>> = emptyMap(),
	@DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	@DefaultValue("emptyMap()")
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val transferKeys: Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> =
		emptyMap(),
	@DefaultValue("emptyMap()")
	override val privateKeyShamirPartitions: Map<String, HexString> = emptyMap(),
	override val publicKey: SpkiHexString? = null,
	@DefaultValue("emptySet()")
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val nonDuplicateIds: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val encryptedAdministrativesDocuments: Set<String> = emptySet(),
	override val comment: String? = null,
	override val warning: String? = null,
	override val fatherBirthCountry: CodeStub? = null,
	override val birthCountry: CodeStub? = null,
	override val nativeCountry: CodeStub? = null,
	override val socialStatus: CodeStub? = null,
	override val mainSourceOfIncome: CodeStub? = null,
	@DefaultValue("emptyList()")
	override val schoolingInfos: List<SchoolingInfo> = emptyList(),
	@DefaultValue("emptyList()")
	override val employementInfos: List<EmploymentInfo> = emptyList(),
) : Patient {
	// region Patient-EncryptedPatient
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedPatient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
