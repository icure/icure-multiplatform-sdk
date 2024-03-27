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
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Patient : StoredDocument, ICureDocument<String>, Person,
    HasEncryptionMetadata, Encryptable, CryptoActor {
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

  override val transferKeys: Map<String, Map<String, String>>

  override val privateKeyShamirPartitions: Map<String, String>

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
  override val identifier: List<Identifier> = emptyList(),
  override val rev: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val firstName: String? = null,
  override val lastName: String? = null,
  override val names: List<PersonName> = emptyList(),
  override val companyName: String? = null,
  override val languages: List<String> = emptyList(),
  override val addresses: List<DecryptedAddress> = emptyList(),
  override val civility: String? = null,
  override val gender: Gender? = null,
  override val birthSex: Gender? = null,
  override val mergeToPatientId: String? = null,
  override val mergedIds: Set<String> = emptySet(),
  override val alias: String? = null,
  override val active: Boolean = true,
  override val deactivationReason: DeactivationReason = DeactivationReason.None,
  override val deactivationDate: Int? = null,
  override val ssin: String? = null,
  override val maidenName: String? = null,
  override val spouseName: String? = null,
  override val partnerName: String? = null,
  override val personalStatus: PersonalStatus? = null,
  override val dateOfBirth: Int? = null,
  override val dateOfDeath: Int? = null,
  override val timestampOfLatestEidReading: Long? = null,
  override val placeOfBirth: String? = null,
  override val placeOfDeath: String? = null,
  override val deceased: Boolean? = null,
  override val education: String? = null,
  override val profession: String? = null,
  override val notes: List<Annotation> = emptyList(),
  override val note: String? = null,
  override val administrativeNote: String? = null,
  override val nationality: String? = null,
  override val race: String? = null,
  override val ethnicity: String? = null,
  override val preferredUserId: String? = null,
  override val picture: ByteArray? = null,
  override val externalId: String? = null,
  override val insurabilities: List<DecryptedInsurability> = emptyList(),
  override val partnerships: List<Partnership> = emptyList(),
  override val patientHealthCareParties: List<DecryptedPatientHealthCareParty> = emptyList(),
  override val financialInstitutionInformation: List<DecryptedFinancialInstitutionInformation> =
      emptyList(),
  override val medicalHouseContracts: List<DecryptedMedicalHouseContract> = emptyList(),
  override val patientProfessions: List<CodeStub> = emptyList(),
  override val parameters: Map<String, List<String>> = emptyMap(),
  override val properties: Set<DecryptedPropertyStub> = emptySet(),
  override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
  override val aesExchangeKeys:
      Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
      emptyMap(),
  override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
  override val privateKeyShamirPartitions: Map<String, String> = emptyMap(),
  override val publicKey: SpkiHexString? = null,
  override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val medicalLocationId: String? = null,
  override val nonDuplicateIds: Set<String> = emptySet(),
  override val encryptedAdministrativesDocuments: Set<String> = emptySet(),
  override val comment: String? = null,
  override val warning: String? = null,
  override val fatherBirthCountry: CodeStub? = null,
  override val birthCountry: CodeStub? = null,
  override val nativeCountry: CodeStub? = null,
  override val socialStatus: CodeStub? = null,
  override val mainSourceOfIncome: CodeStub? = null,
  override val schoolingInfos: List<SchoolingInfo> = emptyList(),
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
  override val identifier: List<Identifier> = emptyList(),
  override val rev: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  override val firstName: String? = null,
  override val lastName: String? = null,
  override val names: List<PersonName> = emptyList(),
  override val companyName: String? = null,
  override val languages: List<String> = emptyList(),
  override val addresses: List<EncryptedAddress> = emptyList(),
  override val civility: String? = null,
  override val gender: Gender? = null,
  override val birthSex: Gender? = null,
  override val mergeToPatientId: String? = null,
  override val mergedIds: Set<String> = emptySet(),
  override val alias: String? = null,
  override val active: Boolean = true,
  override val deactivationReason: DeactivationReason = DeactivationReason.None,
  override val deactivationDate: Int? = null,
  override val ssin: String? = null,
  override val maidenName: String? = null,
  override val spouseName: String? = null,
  override val partnerName: String? = null,
  override val personalStatus: PersonalStatus? = null,
  override val dateOfBirth: Int? = null,
  override val dateOfDeath: Int? = null,
  override val timestampOfLatestEidReading: Long? = null,
  override val placeOfBirth: String? = null,
  override val placeOfDeath: String? = null,
  override val deceased: Boolean? = null,
  override val education: String? = null,
  override val profession: String? = null,
  override val notes: List<Annotation> = emptyList(),
  override val note: String? = null,
  override val administrativeNote: String? = null,
  override val nationality: String? = null,
  override val race: String? = null,
  override val ethnicity: String? = null,
  override val preferredUserId: String? = null,
  override val picture: ByteArray? = null,
  override val externalId: String? = null,
  override val insurabilities: List<EncryptedInsurability> = emptyList(),
  override val partnerships: List<Partnership> = emptyList(),
  override val patientHealthCareParties: List<EncryptedPatientHealthCareParty> = emptyList(),
  override val financialInstitutionInformation: List<EncryptedFinancialInstitutionInformation> =
      emptyList(),
  override val medicalHouseContracts: List<EncryptedMedicalHouseContract> = emptyList(),
  override val patientProfessions: List<CodeStub> = emptyList(),
  override val parameters: Map<String, List<String>> = emptyMap(),
  override val properties: Set<EncryptedPropertyStub> = emptySet(),
  override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
  override val aesExchangeKeys:
      Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> =
      emptyMap(),
  override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
  override val privateKeyShamirPartitions: Map<String, String> = emptyMap(),
  override val publicKey: SpkiHexString? = null,
  override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val medicalLocationId: String? = null,
  override val nonDuplicateIds: Set<String> = emptySet(),
  override val encryptedAdministrativesDocuments: Set<String> = emptySet(),
  override val comment: String? = null,
  override val warning: String? = null,
  override val fatherBirthCountry: CodeStub? = null,
  override val birthCountry: CodeStub? = null,
  override val nativeCountry: CodeStub? = null,
  override val socialStatus: CodeStub? = null,
  override val mainSourceOfIncome: CodeStub? = null,
  override val schoolingInfos: List<SchoolingInfo> = emptyList(),
  override val employementInfos: List<EmploymentInfo> = emptyList(),
) : Patient {
	// region Patient-EncryptedPatient
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedPatient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun Patient.copy(
  id: String = this.id,
  identifier: List<Identifier> = this.identifier,
  rev: String? = this.rev,
  created: Long? = this.created,
  modified: Long? = this.modified,
  author: String? = this.author,
  responsible: String? = this.responsible,
  tags: Set<CodeStub> = this.tags,
  codes: Set<CodeStub> = this.codes,
  endOfLife: Long? = this.endOfLife,
  deletionDate: Long? = this.deletionDate,
  firstName: String? = this.firstName,
  lastName: String? = this.lastName,
  names: List<PersonName> = this.names,
  companyName: String? = this.companyName,
  languages: List<String> = this.languages,
  addresses: List<Address> = this.addresses,
  civility: String? = this.civility,
  gender: Gender? = this.gender,
  birthSex: Gender? = this.birthSex,
  mergeToPatientId: String? = this.mergeToPatientId,
  mergedIds: Set<String> = this.mergedIds,
  alias: String? = this.alias,
  active: Boolean = this.active,
  deactivationReason: DeactivationReason = this.deactivationReason,
  deactivationDate: Int? = this.deactivationDate,
  ssin: String? = this.ssin,
  maidenName: String? = this.maidenName,
  spouseName: String? = this.spouseName,
  partnerName: String? = this.partnerName,
  personalStatus: PersonalStatus? = this.personalStatus,
  dateOfBirth: Int? = this.dateOfBirth,
  dateOfDeath: Int? = this.dateOfDeath,
  timestampOfLatestEidReading: Long? = this.timestampOfLatestEidReading,
  placeOfBirth: String? = this.placeOfBirth,
  placeOfDeath: String? = this.placeOfDeath,
  deceased: Boolean? = this.deceased,
  education: String? = this.education,
  profession: String? = this.profession,
  notes: List<Annotation> = this.notes,
  note: String? = this.note,
  administrativeNote: String? = this.administrativeNote,
  nationality: String? = this.nationality,
  race: String? = this.race,
  ethnicity: String? = this.ethnicity,
  preferredUserId: String? = this.preferredUserId,
  picture: ByteArray? = this.picture,
  externalId: String? = this.externalId,
  insurabilities: List<Insurability> = this.insurabilities,
  partnerships: List<Partnership> = this.partnerships,
  patientHealthCareParties: List<PatientHealthCareParty> = this.patientHealthCareParties,
  financialInstitutionInformation: List<FinancialInstitutionInformation> =
      this.financialInstitutionInformation,
  medicalHouseContracts: List<MedicalHouseContract> = this.medicalHouseContracts,
  patientProfessions: List<CodeStub> = this.patientProfessions,
  parameters: Map<String, List<String>> = this.parameters,
  properties: Set<PropertyStub> = this.properties,
  hcPartyKeys: Map<String, List<HexString>> = this.hcPartyKeys,
  aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
      = this.aesExchangeKeys,
  transferKeys: Map<String, Map<String, String>> = this.transferKeys,
  privateKeyShamirPartitions: Map<String, String> = this.privateKeyShamirPartitions,
  publicKey: SpkiHexString? = this.publicKey,
  publicKeysForOaepWithSha256: Set<SpkiHexString> = this.publicKeysForOaepWithSha256,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
  medicalLocationId: String? = this.medicalLocationId,
  nonDuplicateIds: Set<String> = this.nonDuplicateIds,
  encryptedAdministrativesDocuments: Set<String> = this.encryptedAdministrativesDocuments,
  comment: String? = this.comment,
  warning: String? = this.warning,
  fatherBirthCountry: CodeStub? = this.fatherBirthCountry,
  birthCountry: CodeStub? = this.birthCountry,
  nativeCountry: CodeStub? = this.nativeCountry,
  socialStatus: CodeStub? = this.socialStatus,
  mainSourceOfIncome: CodeStub? = this.mainSourceOfIncome,
  schoolingInfos: List<SchoolingInfo> = this.schoolingInfos,
  employementInfos: List<EmploymentInfo> = this.employementInfos,
): Patient {
                                      return when(this) {
                                          is DecryptedPatient -> copy(id = id, identifier =
          identifier, rev = rev, created = created, modified = modified, author = author,
          responsible = responsible, tags = tags, codes = codes, endOfLife = endOfLife, deletionDate
          = deletionDate, firstName = firstName, lastName = lastName, names = names, companyName =
          companyName, languages = languages, addresses = addresses, civility = civility, gender =
          gender, birthSex = birthSex, mergeToPatientId = mergeToPatientId, mergedIds = mergedIds,
          alias = alias, active = active, deactivationReason = deactivationReason, deactivationDate
          = deactivationDate, ssin = ssin, maidenName = maidenName, spouseName = spouseName,
          partnerName = partnerName, personalStatus = personalStatus, dateOfBirth = dateOfBirth,
          dateOfDeath = dateOfDeath, timestampOfLatestEidReading = timestampOfLatestEidReading,
          placeOfBirth = placeOfBirth, placeOfDeath = placeOfDeath, deceased = deceased, education =
          education, profession = profession, notes = notes, note = note, administrativeNote =
          administrativeNote, nationality = nationality, race = race, ethnicity = ethnicity,
          preferredUserId = preferredUserId, picture = picture, externalId = externalId,
          insurabilities = insurabilities, partnerships = partnerships, patientHealthCareParties =
          patientHealthCareParties, financialInstitutionInformation =
          financialInstitutionInformation, medicalHouseContracts = medicalHouseContracts,
          patientProfessions = patientProfessions, parameters = parameters, properties = properties,
          hcPartyKeys = hcPartyKeys, aesExchangeKeys = aesExchangeKeys, transferKeys = transferKeys,
          privateKeyShamirPartitions = privateKeyShamirPartitions, publicKey = publicKey,
          publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256, secretForeignKeys =
          secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata, medicalLocationId = medicalLocationId, nonDuplicateIds =
          nonDuplicateIds, encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
          comment = comment, warning = warning, fatherBirthCountry = fatherBirthCountry,
          birthCountry = birthCountry, nativeCountry = nativeCountry, socialStatus = socialStatus,
          mainSourceOfIncome = mainSourceOfIncome, schoolingInfos = schoolingInfos, employementInfos
          = employementInfos)
      is EncryptedPatient -> copy(id = id, identifier = identifier, rev = rev, created = created,
          modified = modified, author = author, responsible = responsible, tags = tags, codes =
          codes, endOfLife = endOfLife, deletionDate = deletionDate, firstName = firstName, lastName
          = lastName, names = names, companyName = companyName, languages = languages, addresses =
          addresses, civility = civility, gender = gender, birthSex = birthSex, mergeToPatientId =
          mergeToPatientId, mergedIds = mergedIds, alias = alias, active = active,
          deactivationReason = deactivationReason, deactivationDate = deactivationDate, ssin = ssin,
          maidenName = maidenName, spouseName = spouseName, partnerName = partnerName,
          personalStatus = personalStatus, dateOfBirth = dateOfBirth, dateOfDeath = dateOfDeath,
          timestampOfLatestEidReading = timestampOfLatestEidReading, placeOfBirth = placeOfBirth,
          placeOfDeath = placeOfDeath, deceased = deceased, education = education, profession =
          profession, notes = notes, note = note, administrativeNote = administrativeNote,
          nationality = nationality, race = race, ethnicity = ethnicity, preferredUserId =
          preferredUserId, picture = picture, externalId = externalId, insurabilities =
          insurabilities, partnerships = partnerships, patientHealthCareParties =
          patientHealthCareParties, financialInstitutionInformation =
          financialInstitutionInformation, medicalHouseContracts = medicalHouseContracts,
          patientProfessions = patientProfessions, parameters = parameters, properties = properties,
          hcPartyKeys = hcPartyKeys, aesExchangeKeys = aesExchangeKeys, transferKeys = transferKeys,
          privateKeyShamirPartitions = privateKeyShamirPartitions, publicKey = publicKey,
          publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256, secretForeignKeys =
          secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys, delegations = delegations,
          encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata =
          securityMetadata, medicalLocationId = medicalLocationId, nonDuplicateIds =
          nonDuplicateIds, encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
          comment = comment, warning = warning, fatherBirthCountry = fatherBirthCountry,
          birthCountry = birthCountry, nativeCountry = nativeCountry, socialStatus = socialStatus,
          mainSourceOfIncome = mainSourceOfIncome, schoolingInfos = schoolingInfos, employementInfos
          = employementInfos)
                                          }

}
