package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.IdentifierJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.js.model.base.identifier_fromJs
import com.icure.sdk.js.model.base.identifier_toJs
import com.icure.sdk.js.model.embed.AnnotationJs
import com.icure.sdk.js.model.embed.DecryptedAddressJs
import com.icure.sdk.js.model.embed.DecryptedFinancialInstitutionInformationJs
import com.icure.sdk.js.model.embed.DecryptedInsurabilityJs
import com.icure.sdk.js.model.embed.DecryptedMedicalHouseContractJs
import com.icure.sdk.js.model.embed.DecryptedPatientHealthCarePartyJs
import com.icure.sdk.js.model.embed.DelegationJs
import com.icure.sdk.js.model.embed.EmploymentInfoJs
import com.icure.sdk.js.model.embed.EncryptedAddressJs
import com.icure.sdk.js.model.embed.EncryptedFinancialInstitutionInformationJs
import com.icure.sdk.js.model.embed.EncryptedInsurabilityJs
import com.icure.sdk.js.model.embed.EncryptedMedicalHouseContractJs
import com.icure.sdk.js.model.embed.EncryptedPatientHealthCarePartyJs
import com.icure.sdk.js.model.embed.PartnershipJs
import com.icure.sdk.js.model.embed.PersonNameJs
import com.icure.sdk.js.model.embed.SchoolingInfoJs
import com.icure.sdk.js.model.embed.address_fromJs
import com.icure.sdk.js.model.embed.address_toJs
import com.icure.sdk.js.model.embed.annotation_fromJs
import com.icure.sdk.js.model.embed.annotation_toJs
import com.icure.sdk.js.model.embed.deactivationReason_fromJs
import com.icure.sdk.js.model.embed.deactivationReason_toJs
import com.icure.sdk.js.model.embed.delegation_fromJs
import com.icure.sdk.js.model.embed.delegation_toJs
import com.icure.sdk.js.model.embed.employmentInfo_fromJs
import com.icure.sdk.js.model.embed.employmentInfo_toJs
import com.icure.sdk.js.model.embed.financialInstitutionInformation_fromJs
import com.icure.sdk.js.model.embed.financialInstitutionInformation_toJs
import com.icure.sdk.js.model.embed.gender_fromJs
import com.icure.sdk.js.model.embed.gender_toJs
import com.icure.sdk.js.model.embed.insurability_fromJs
import com.icure.sdk.js.model.embed.insurability_toJs
import com.icure.sdk.js.model.embed.medicalHouseContract_fromJs
import com.icure.sdk.js.model.embed.medicalHouseContract_toJs
import com.icure.sdk.js.model.embed.partnership_fromJs
import com.icure.sdk.js.model.embed.partnership_toJs
import com.icure.sdk.js.model.embed.patientHealthCareParty_fromJs
import com.icure.sdk.js.model.embed.patientHealthCareParty_toJs
import com.icure.sdk.js.model.embed.personName_fromJs
import com.icure.sdk.js.model.embed.personName_toJs
import com.icure.sdk.js.model.embed.personalStatus_fromJs
import com.icure.sdk.js.model.embed.personalStatus_toJs
import com.icure.sdk.js.model.embed.schoolingInfo_fromJs
import com.icure.sdk.js.model.embed.schoolingInfo_toJs
import com.icure.sdk.js.model.embed.securityMetadata_fromJs
import com.icure.sdk.js.model.embed.securityMetadata_toJs
import com.icure.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_fromJs
import com.icure.sdk.js.model.specializations.aesExchangeKeyEncryptionKeypairIdentifier_toJs
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.js.model.specializations.hexString_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.sdk.js.model.specializations.spkiHexString_toJs
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Annotation
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.DecryptedInsurability
import com.icure.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.EmploymentInfo
import com.icure.sdk.model.embed.EncryptedAddress
import com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation
import com.icure.sdk.model.embed.EncryptedInsurability
import com.icure.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.sdk.model.embed.Partnership
import com.icure.sdk.model.embed.PersonName
import com.icure.sdk.model.embed.SchoolingInfo
import com.icure.sdk.model.specializations.AesExchangeKeyEncryptionKeypairIdentifier
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.Array
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

public fun patient_toJs(obj: DecryptedPatient): DecryptedPatientJs {
	val id = obj.id
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val firstName = obj.firstName
	val lastName = obj.lastName
	val names = listToArray(
		obj.names,
		{ x1: PersonName ->
			personName_toJs(x1)
		},
	)
	val companyName = obj.companyName
	val languages = listToArray(
		obj.languages,
		{ x1: String ->
			x1
		},
	)
	val addresses = listToArray(
		obj.addresses,
		{ x1: DecryptedAddress ->
			address_toJs(x1)
		},
	)
	val civility = obj.civility
	val gender = obj.gender?.let { nonNull1 ->
		gender_toJs(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		gender_toJs(nonNull1)
	}
	val mergeToPatientId = obj.mergeToPatientId
	val mergedIds = setToArray(
		obj.mergedIds,
		{ x1: String ->
			x1
		},
	)
	val alias = obj.alias
	val active = obj.active
	val deactivationReason = deactivationReason_toJs(obj.deactivationReason)
	val deactivationDate = intToNumber(obj.deactivationDate)
	val ssin = obj.ssin
	val maidenName = obj.maidenName
	val spouseName = obj.spouseName
	val partnerName = obj.partnerName
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		personalStatus_toJs(nonNull1)
	}
	val dateOfBirth = intToNumber(obj.dateOfBirth)
	val dateOfDeath = intToNumber(obj.dateOfDeath)
	val timestampOfLatestEidReading = longToNumber(obj.timestampOfLatestEidReading)
	val placeOfBirth = obj.placeOfBirth
	val placeOfDeath = obj.placeOfDeath
	val deceased = obj.deceased
	val education = obj.education
	val profession = obj.profession
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val note = obj.note
	val administrativeNote = obj.administrativeNote
	val nationality = obj.nationality
	val race = obj.race
	val ethnicity = obj.ethnicity
	val preferredUserId = obj.preferredUserId
	val picture = obj.picture
	val externalId = obj.externalId
	val insurabilities = listToArray(
		obj.insurabilities,
		{ x1: DecryptedInsurability ->
			insurability_toJs(x1)
		},
	)
	val partnerships = listToArray(
		obj.partnerships,
		{ x1: Partnership ->
			partnership_toJs(x1)
		},
	)
	val patientHealthCareParties = listToArray(
		obj.patientHealthCareParties,
		{ x1: DecryptedPatientHealthCareParty ->
			patientHealthCareParty_toJs(x1)
		},
	)
	val financialInstitutionInformation = listToArray(
		obj.financialInstitutionInformation,
		{ x1: DecryptedFinancialInstitutionInformation ->
			financialInstitutionInformation_toJs(x1)
		},
	)
	val medicalHouseContracts = listToArray(
		obj.medicalHouseContracts,
		{ x1: DecryptedMedicalHouseContract ->
			medicalHouseContract_toJs(x1)
		},
	)
	val patientProfessions = listToArray(
		obj.patientProfessions,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_toJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	val medicalLocationId = obj.medicalLocationId
	val nonDuplicateIds = setToArray(
		obj.nonDuplicateIds,
		{ x1: String ->
			x1
		},
	)
	val encryptedAdministrativesDocuments = setToArray(
		obj.encryptedAdministrativesDocuments,
		{ x1: String ->
			x1
		},
	)
	val comment = obj.comment
	val warning = obj.warning
	val fatherBirthCountry = obj.fatherBirthCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val birthCountry = obj.birthCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val nativeCountry = obj.nativeCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val socialStatus = obj.socialStatus?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val mainSourceOfIncome = obj.mainSourceOfIncome?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val schoolingInfos = listToArray(
		obj.schoolingInfos,
		{ x1: SchoolingInfo ->
			schoolingInfo_toJs(x1)
		},
	)
	val employementInfos = listToArray(
		obj.employementInfos,
		{ x1: EmploymentInfo ->
			employmentInfo_toJs(x1)
		},
	)
	return DecryptedPatientJs(js("{" +
		"id:id," +
		"identifier:identifier," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"firstName:firstName," +
		"lastName:lastName," +
		"names:names," +
		"companyName:companyName," +
		"languages:languages," +
		"addresses:addresses," +
		"civility:civility," +
		"gender:gender," +
		"birthSex:birthSex," +
		"mergeToPatientId:mergeToPatientId," +
		"mergedIds:mergedIds," +
		"alias:alias," +
		"active:active," +
		"deactivationReason:deactivationReason," +
		"deactivationDate:deactivationDate," +
		"ssin:ssin," +
		"maidenName:maidenName," +
		"spouseName:spouseName," +
		"partnerName:partnerName," +
		"personalStatus:personalStatus," +
		"dateOfBirth:dateOfBirth," +
		"dateOfDeath:dateOfDeath," +
		"timestampOfLatestEidReading:timestampOfLatestEidReading," +
		"placeOfBirth:placeOfBirth," +
		"placeOfDeath:placeOfDeath," +
		"deceased:deceased," +
		"education:education," +
		"profession:profession," +
		"notes:notes," +
		"note:note," +
		"administrativeNote:administrativeNote," +
		"nationality:nationality," +
		"race:race," +
		"ethnicity:ethnicity," +
		"preferredUserId:preferredUserId," +
		"picture:picture," +
		"externalId:externalId," +
		"insurabilities:insurabilities," +
		"partnerships:partnerships," +
		"patientHealthCareParties:patientHealthCareParties," +
		"financialInstitutionInformation:financialInstitutionInformation," +
		"medicalHouseContracts:medicalHouseContracts," +
		"patientProfessions:patientProfessions," +
		"parameters:parameters," +
		"properties:properties," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"medicalLocationId:medicalLocationId," +
		"nonDuplicateIds:nonDuplicateIds," +
		"encryptedAdministrativesDocuments:encryptedAdministrativesDocuments," +
		"comment:comment," +
		"warning:warning," +
		"fatherBirthCountry:fatherBirthCountry," +
		"birthCountry:birthCountry," +
		"nativeCountry:nativeCountry," +
		"socialStatus:socialStatus," +
		"mainSourceOfIncome:mainSourceOfIncome," +
		"schoolingInfos:schoolingInfos," +
		"employementInfos:employementInfos" +
	"}"))
}

public fun patient_fromJs(obj: DecryptedPatientJs): DecryptedPatient {
	val id = obj.id
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val firstName = obj.firstName
	val lastName = obj.lastName
	val names = arrayToList(
		obj.names,
		"obj.names",
		{ x1: PersonNameJs ->
			personName_fromJs(x1)
		},
	)
	val companyName = obj.companyName
	val languages = arrayToList(
		obj.languages,
		"obj.languages",
		{ x1: String ->
			x1
		},
	)
	val addresses = arrayToList(
		obj.addresses,
		"obj.addresses",
		{ x1: DecryptedAddressJs ->
			address_fromJs(x1)
		},
	)
	val civility = obj.civility
	val gender = obj.gender?.let { nonNull1 ->
		gender_fromJs(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		gender_fromJs(nonNull1)
	}
	val mergeToPatientId = obj.mergeToPatientId
	val mergedIds = arrayToSet(
		obj.mergedIds,
		"obj.mergedIds",
		{ x1: String ->
			x1
		},
	)
	val alias = obj.alias
	val active = obj.active
	val deactivationReason = deactivationReason_fromJs(obj.deactivationReason)
	val deactivationDate = numberToInt(obj.deactivationDate, "obj.deactivationDate")
	val ssin = obj.ssin
	val maidenName = obj.maidenName
	val spouseName = obj.spouseName
	val partnerName = obj.partnerName
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		personalStatus_fromJs(nonNull1)
	}
	val dateOfBirth = numberToInt(obj.dateOfBirth, "obj.dateOfBirth")
	val dateOfDeath = numberToInt(obj.dateOfDeath, "obj.dateOfDeath")
	val timestampOfLatestEidReading = numberToLong(obj.timestampOfLatestEidReading,
			"obj.timestampOfLatestEidReading")
	val placeOfBirth = obj.placeOfBirth
	val placeOfDeath = obj.placeOfDeath
	val deceased = obj.deceased
	val education = obj.education
	val profession = obj.profession
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val note = obj.note
	val administrativeNote = obj.administrativeNote
	val nationality = obj.nationality
	val race = obj.race
	val ethnicity = obj.ethnicity
	val preferredUserId = obj.preferredUserId
	val picture = obj.picture
	val externalId = obj.externalId
	val insurabilities = arrayToList(
		obj.insurabilities,
		"obj.insurabilities",
		{ x1: DecryptedInsurabilityJs ->
			insurability_fromJs(x1)
		},
	)
	val partnerships = arrayToList(
		obj.partnerships,
		"obj.partnerships",
		{ x1: PartnershipJs ->
			partnership_fromJs(x1)
		},
	)
	val patientHealthCareParties = arrayToList(
		obj.patientHealthCareParties,
		"obj.patientHealthCareParties",
		{ x1: DecryptedPatientHealthCarePartyJs ->
			patientHealthCareParty_fromJs(x1)
		},
	)
	val financialInstitutionInformation = arrayToList(
		obj.financialInstitutionInformation,
		"obj.financialInstitutionInformation",
		{ x1: DecryptedFinancialInstitutionInformationJs ->
			financialInstitutionInformation_fromJs(x1)
		},
	)
	val medicalHouseContracts = arrayToList(
		obj.medicalHouseContracts,
		"obj.medicalHouseContracts",
		{ x1: DecryptedMedicalHouseContractJs ->
			medicalHouseContract_fromJs(x1)
		},
	)
	val patientProfessions = arrayToList(
		obj.patientProfessions,
		"obj.patientProfessions",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
		{ x1: dynamic ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: dynamic ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: dynamic ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val medicalLocationId = obj.medicalLocationId
	val nonDuplicateIds = arrayToSet(
		obj.nonDuplicateIds,
		"obj.nonDuplicateIds",
		{ x1: String ->
			x1
		},
	)
	val encryptedAdministrativesDocuments = arrayToSet(
		obj.encryptedAdministrativesDocuments,
		"obj.encryptedAdministrativesDocuments",
		{ x1: String ->
			x1
		},
	)
	val comment = obj.comment
	val warning = obj.warning
	val fatherBirthCountry = obj.fatherBirthCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val birthCountry = obj.birthCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val nativeCountry = obj.nativeCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val socialStatus = obj.socialStatus?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val mainSourceOfIncome = obj.mainSourceOfIncome?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val schoolingInfos = arrayToList(
		obj.schoolingInfos,
		"obj.schoolingInfos",
		{ x1: SchoolingInfoJs ->
			schoolingInfo_fromJs(x1)
		},
	)
	val employementInfos = arrayToList(
		obj.employementInfos,
		"obj.employementInfos",
		{ x1: EmploymentInfoJs ->
			employmentInfo_fromJs(x1)
		},
	)
	return DecryptedPatient(
		id = id,
		identifier = identifier,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		firstName = firstName,
		lastName = lastName,
		names = names,
		companyName = companyName,
		languages = languages,
		addresses = addresses,
		civility = civility,
		gender = gender,
		birthSex = birthSex,
		mergeToPatientId = mergeToPatientId,
		mergedIds = mergedIds,
		alias = alias,
		active = active,
		deactivationReason = deactivationReason,
		deactivationDate = deactivationDate,
		ssin = ssin,
		maidenName = maidenName,
		spouseName = spouseName,
		partnerName = partnerName,
		personalStatus = personalStatus,
		dateOfBirth = dateOfBirth,
		dateOfDeath = dateOfDeath,
		timestampOfLatestEidReading = timestampOfLatestEidReading,
		placeOfBirth = placeOfBirth,
		placeOfDeath = placeOfDeath,
		deceased = deceased,
		education = education,
		profession = profession,
		notes = notes,
		note = note,
		administrativeNote = administrativeNote,
		nationality = nationality,
		race = race,
		ethnicity = ethnicity,
		preferredUserId = preferredUserId,
		picture = picture,
		externalId = externalId,
		insurabilities = insurabilities,
		partnerships = partnerships,
		patientHealthCareParties = patientHealthCareParties,
		financialInstitutionInformation = financialInstitutionInformation,
		medicalHouseContracts = medicalHouseContracts,
		patientProfessions = patientProfessions,
		parameters = parameters,
		properties = properties,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		medicalLocationId = medicalLocationId,
		nonDuplicateIds = nonDuplicateIds,
		encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
		comment = comment,
		warning = warning,
		fatherBirthCountry = fatherBirthCountry,
		birthCountry = birthCountry,
		nativeCountry = nativeCountry,
		socialStatus = socialStatus,
		mainSourceOfIncome = mainSourceOfIncome,
		schoolingInfos = schoolingInfos,
		employementInfos = employementInfos,
	)
}

public fun patient_toJs(obj: EncryptedPatient): EncryptedPatientJs {
	val id = obj.id
	val identifier = listToArray(
		obj.identifier,
		{ x1: Identifier ->
			identifier_toJs(x1)
		},
	)
	val rev = obj.rev
	val created = longToNumber(obj.created)
	val modified = longToNumber(obj.modified)
	val author = obj.author
	val responsible = obj.responsible
	val tags = setToArray(
		obj.tags,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val codes = setToArray(
		obj.codes,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val endOfLife = longToNumber(obj.endOfLife)
	val deletionDate = longToNumber(obj.deletionDate)
	val firstName = obj.firstName
	val lastName = obj.lastName
	val names = listToArray(
		obj.names,
		{ x1: PersonName ->
			personName_toJs(x1)
		},
	)
	val companyName = obj.companyName
	val languages = listToArray(
		obj.languages,
		{ x1: String ->
			x1
		},
	)
	val addresses = listToArray(
		obj.addresses,
		{ x1: EncryptedAddress ->
			address_toJs(x1)
		},
	)
	val civility = obj.civility
	val gender = obj.gender?.let { nonNull1 ->
		gender_toJs(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		gender_toJs(nonNull1)
	}
	val mergeToPatientId = obj.mergeToPatientId
	val mergedIds = setToArray(
		obj.mergedIds,
		{ x1: String ->
			x1
		},
	)
	val alias = obj.alias
	val active = obj.active
	val deactivationReason = deactivationReason_toJs(obj.deactivationReason)
	val deactivationDate = intToNumber(obj.deactivationDate)
	val ssin = obj.ssin
	val maidenName = obj.maidenName
	val spouseName = obj.spouseName
	val partnerName = obj.partnerName
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		personalStatus_toJs(nonNull1)
	}
	val dateOfBirth = intToNumber(obj.dateOfBirth)
	val dateOfDeath = intToNumber(obj.dateOfDeath)
	val timestampOfLatestEidReading = longToNumber(obj.timestampOfLatestEidReading)
	val placeOfBirth = obj.placeOfBirth
	val placeOfDeath = obj.placeOfDeath
	val deceased = obj.deceased
	val education = obj.education
	val profession = obj.profession
	val notes = listToArray(
		obj.notes,
		{ x1: Annotation ->
			annotation_toJs(x1)
		},
	)
	val note = obj.note
	val administrativeNote = obj.administrativeNote
	val nationality = obj.nationality
	val race = obj.race
	val ethnicity = obj.ethnicity
	val preferredUserId = obj.preferredUserId
	val picture = obj.picture
	val externalId = obj.externalId
	val insurabilities = listToArray(
		obj.insurabilities,
		{ x1: EncryptedInsurability ->
			insurability_toJs(x1)
		},
	)
	val partnerships = listToArray(
		obj.partnerships,
		{ x1: Partnership ->
			partnership_toJs(x1)
		},
	)
	val patientHealthCareParties = listToArray(
		obj.patientHealthCareParties,
		{ x1: EncryptedPatientHealthCareParty ->
			patientHealthCareParty_toJs(x1)
		},
	)
	val financialInstitutionInformation = listToArray(
		obj.financialInstitutionInformation,
		{ x1: EncryptedFinancialInstitutionInformation ->
			financialInstitutionInformation_toJs(x1)
		},
	)
	val medicalHouseContracts = listToArray(
		obj.medicalHouseContracts,
		{ x1: EncryptedMedicalHouseContract ->
			medicalHouseContract_toJs(x1)
		},
	)
	val patientProfessions = listToArray(
		obj.patientProfessions,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val parameters = mapToObject(
		obj.parameters,
		{ x1: String ->
			x1
		},
		{ x1: List<String> ->
			listToArray(
				x1,
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = setToArray(
		obj.properties,
		{ x1: EncryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	val hcPartyKeys = mapToObject(
		obj.hcPartyKeys,
		{ x1: String ->
			x1
		},
		{ x1: List<HexString> ->
			listToArray(
				x1,
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = mapToObject(
		obj.aesExchangeKeys,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
		{ x1: Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> ->
			mapToObject(
				x1,
				{ x2: String ->
					x2
				},
				{ x2: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
					mapToObject(
						x2,
						{ x3: AesExchangeKeyEncryptionKeypairIdentifier ->
							aesExchangeKeyEncryptionKeypairIdentifier_toJs(x3)
						},
						{ x3: HexString ->
							hexString_toJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = mapToObject(
		obj.transferKeys,
		{ x1: AesExchangeKeyEncryptionKeypairIdentifier ->
			aesExchangeKeyEncryptionKeypairIdentifier_toJs(x1)
		},
		{ x1: Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString> ->
			mapToObject(
				x1,
				{ x2: AesExchangeKeyEncryptionKeypairIdentifier ->
					aesExchangeKeyEncryptionKeypairIdentifier_toJs(x2)
				},
				{ x2: HexString ->
					hexString_toJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = mapToObject(
		obj.privateKeyShamirPartitions,
		{ x1: String ->
			x1
		},
		{ x1: HexString ->
			hexString_toJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_toJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = setToArray(
		obj.publicKeysForOaepWithSha256,
		{ x1: SpkiHexString ->
			spkiHexString_toJs(x1)
		},
	)
	val secretForeignKeys = setToArray(
		obj.secretForeignKeys,
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = mapToObject(
		obj.cryptedForeignKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val delegations = mapToObject(
		obj.delegations,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptionKeys = mapToObject(
		obj.encryptionKeys,
		{ x1: String ->
			x1
		},
		{ x1: Set<Delegation> ->
			setToArray(
				x1,
				{ x2: Delegation ->
					delegation_toJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_toJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_toJs(nonNull1)
	}
	val medicalLocationId = obj.medicalLocationId
	val nonDuplicateIds = setToArray(
		obj.nonDuplicateIds,
		{ x1: String ->
			x1
		},
	)
	val encryptedAdministrativesDocuments = setToArray(
		obj.encryptedAdministrativesDocuments,
		{ x1: String ->
			x1
		},
	)
	val comment = obj.comment
	val warning = obj.warning
	val fatherBirthCountry = obj.fatherBirthCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val birthCountry = obj.birthCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val nativeCountry = obj.nativeCountry?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val socialStatus = obj.socialStatus?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val mainSourceOfIncome = obj.mainSourceOfIncome?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val schoolingInfos = listToArray(
		obj.schoolingInfos,
		{ x1: SchoolingInfo ->
			schoolingInfo_toJs(x1)
		},
	)
	val employementInfos = listToArray(
		obj.employementInfos,
		{ x1: EmploymentInfo ->
			employmentInfo_toJs(x1)
		},
	)
	return EncryptedPatientJs(js("{" +
		"id:id," +
		"identifier:identifier," +
		"rev:rev," +
		"created:created," +
		"modified:modified," +
		"author:author," +
		"responsible:responsible," +
		"tags:tags," +
		"codes:codes," +
		"endOfLife:endOfLife," +
		"deletionDate:deletionDate," +
		"firstName:firstName," +
		"lastName:lastName," +
		"names:names," +
		"companyName:companyName," +
		"languages:languages," +
		"addresses:addresses," +
		"civility:civility," +
		"gender:gender," +
		"birthSex:birthSex," +
		"mergeToPatientId:mergeToPatientId," +
		"mergedIds:mergedIds," +
		"alias:alias," +
		"active:active," +
		"deactivationReason:deactivationReason," +
		"deactivationDate:deactivationDate," +
		"ssin:ssin," +
		"maidenName:maidenName," +
		"spouseName:spouseName," +
		"partnerName:partnerName," +
		"personalStatus:personalStatus," +
		"dateOfBirth:dateOfBirth," +
		"dateOfDeath:dateOfDeath," +
		"timestampOfLatestEidReading:timestampOfLatestEidReading," +
		"placeOfBirth:placeOfBirth," +
		"placeOfDeath:placeOfDeath," +
		"deceased:deceased," +
		"education:education," +
		"profession:profession," +
		"notes:notes," +
		"note:note," +
		"administrativeNote:administrativeNote," +
		"nationality:nationality," +
		"race:race," +
		"ethnicity:ethnicity," +
		"preferredUserId:preferredUserId," +
		"picture:picture," +
		"externalId:externalId," +
		"insurabilities:insurabilities," +
		"partnerships:partnerships," +
		"patientHealthCareParties:patientHealthCareParties," +
		"financialInstitutionInformation:financialInstitutionInformation," +
		"medicalHouseContracts:medicalHouseContracts," +
		"patientProfessions:patientProfessions," +
		"parameters:parameters," +
		"properties:properties," +
		"hcPartyKeys:hcPartyKeys," +
		"aesExchangeKeys:aesExchangeKeys," +
		"transferKeys:transferKeys," +
		"privateKeyShamirPartitions:privateKeyShamirPartitions," +
		"publicKey:publicKey," +
		"publicKeysForOaepWithSha256:publicKeysForOaepWithSha256," +
		"secretForeignKeys:secretForeignKeys," +
		"cryptedForeignKeys:cryptedForeignKeys," +
		"delegations:delegations," +
		"encryptionKeys:encryptionKeys," +
		"encryptedSelf:encryptedSelf," +
		"securityMetadata:securityMetadata," +
		"medicalLocationId:medicalLocationId," +
		"nonDuplicateIds:nonDuplicateIds," +
		"encryptedAdministrativesDocuments:encryptedAdministrativesDocuments," +
		"comment:comment," +
		"warning:warning," +
		"fatherBirthCountry:fatherBirthCountry," +
		"birthCountry:birthCountry," +
		"nativeCountry:nativeCountry," +
		"socialStatus:socialStatus," +
		"mainSourceOfIncome:mainSourceOfIncome," +
		"schoolingInfos:schoolingInfos," +
		"employementInfos:employementInfos" +
	"}"))
}

public fun patient_fromJs(obj: EncryptedPatientJs): EncryptedPatient {
	val id = obj.id
	val identifier = arrayToList(
		obj.identifier,
		"obj.identifier",
		{ x1: IdentifierJs ->
			identifier_fromJs(x1)
		},
	)
	val rev = obj.rev
	val created = numberToLong(obj.created, "obj.created")
	val modified = numberToLong(obj.modified, "obj.modified")
	val author = obj.author
	val responsible = obj.responsible
	val tags = arrayToSet(
		obj.tags,
		"obj.tags",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val codes = arrayToSet(
		obj.codes,
		"obj.codes",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val endOfLife = numberToLong(obj.endOfLife, "obj.endOfLife")
	val deletionDate = numberToLong(obj.deletionDate, "obj.deletionDate")
	val firstName = obj.firstName
	val lastName = obj.lastName
	val names = arrayToList(
		obj.names,
		"obj.names",
		{ x1: PersonNameJs ->
			personName_fromJs(x1)
		},
	)
	val companyName = obj.companyName
	val languages = arrayToList(
		obj.languages,
		"obj.languages",
		{ x1: String ->
			x1
		},
	)
	val addresses = arrayToList(
		obj.addresses,
		"obj.addresses",
		{ x1: EncryptedAddressJs ->
			address_fromJs(x1)
		},
	)
	val civility = obj.civility
	val gender = obj.gender?.let { nonNull1 ->
		gender_fromJs(nonNull1)
	}
	val birthSex = obj.birthSex?.let { nonNull1 ->
		gender_fromJs(nonNull1)
	}
	val mergeToPatientId = obj.mergeToPatientId
	val mergedIds = arrayToSet(
		obj.mergedIds,
		"obj.mergedIds",
		{ x1: String ->
			x1
		},
	)
	val alias = obj.alias
	val active = obj.active
	val deactivationReason = deactivationReason_fromJs(obj.deactivationReason)
	val deactivationDate = numberToInt(obj.deactivationDate, "obj.deactivationDate")
	val ssin = obj.ssin
	val maidenName = obj.maidenName
	val spouseName = obj.spouseName
	val partnerName = obj.partnerName
	val personalStatus = obj.personalStatus?.let { nonNull1 ->
		personalStatus_fromJs(nonNull1)
	}
	val dateOfBirth = numberToInt(obj.dateOfBirth, "obj.dateOfBirth")
	val dateOfDeath = numberToInt(obj.dateOfDeath, "obj.dateOfDeath")
	val timestampOfLatestEidReading = numberToLong(obj.timestampOfLatestEidReading,
			"obj.timestampOfLatestEidReading")
	val placeOfBirth = obj.placeOfBirth
	val placeOfDeath = obj.placeOfDeath
	val deceased = obj.deceased
	val education = obj.education
	val profession = obj.profession
	val notes = arrayToList(
		obj.notes,
		"obj.notes",
		{ x1: AnnotationJs ->
			annotation_fromJs(x1)
		},
	)
	val note = obj.note
	val administrativeNote = obj.administrativeNote
	val nationality = obj.nationality
	val race = obj.race
	val ethnicity = obj.ethnicity
	val preferredUserId = obj.preferredUserId
	val picture = obj.picture
	val externalId = obj.externalId
	val insurabilities = arrayToList(
		obj.insurabilities,
		"obj.insurabilities",
		{ x1: EncryptedInsurabilityJs ->
			insurability_fromJs(x1)
		},
	)
	val partnerships = arrayToList(
		obj.partnerships,
		"obj.partnerships",
		{ x1: PartnershipJs ->
			partnership_fromJs(x1)
		},
	)
	val patientHealthCareParties = arrayToList(
		obj.patientHealthCareParties,
		"obj.patientHealthCareParties",
		{ x1: EncryptedPatientHealthCarePartyJs ->
			patientHealthCareParty_fromJs(x1)
		},
	)
	val financialInstitutionInformation = arrayToList(
		obj.financialInstitutionInformation,
		"obj.financialInstitutionInformation",
		{ x1: EncryptedFinancialInstitutionInformationJs ->
			financialInstitutionInformation_fromJs(x1)
		},
	)
	val medicalHouseContracts = arrayToList(
		obj.medicalHouseContracts,
		"obj.medicalHouseContracts",
		{ x1: EncryptedMedicalHouseContractJs ->
			medicalHouseContract_fromJs(x1)
		},
	)
	val patientProfessions = arrayToList(
		obj.patientProfessions,
		"obj.patientProfessions",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val parameters = objectToMap(
		obj.parameters,
		"obj.parameters",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
			)
		},
	)
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: EncryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	val hcPartyKeys = objectToMap(
		obj.hcPartyKeys,
		"obj.hcPartyKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<String> ->
			arrayToList(
				x1,
				"x1",
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val aesExchangeKeys = objectToMap(
		obj.aesExchangeKeys,
		"obj.aesExchangeKeys",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
		{ x1: dynamic ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					x2
				},
				{ x2: dynamic ->
					objectToMap(
						x2,
						"x2",
						{ x3: String ->
							aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x3)
						},
						{ x3: String ->
							hexString_fromJs(x3)
						},
					)
				},
			)
		},
	)
	val transferKeys = objectToMap(
		obj.transferKeys,
		"obj.transferKeys",
		{ x1: String ->
			aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x1)
		},
		{ x1: dynamic ->
			objectToMap(
				x1,
				"x1",
				{ x2: String ->
					aesExchangeKeyEncryptionKeypairIdentifier_fromJs(x2)
				},
				{ x2: String ->
					hexString_fromJs(x2)
				},
			)
		},
	)
	val privateKeyShamirPartitions = objectToMap(
		obj.privateKeyShamirPartitions,
		"obj.privateKeyShamirPartitions",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			hexString_fromJs(x1)
		},
	)
	val publicKey = obj.publicKey?.let { nonNull1 ->
		spkiHexString_fromJs(nonNull1)
	}
	val publicKeysForOaepWithSha256 = arrayToSet(
		obj.publicKeysForOaepWithSha256,
		"obj.publicKeysForOaepWithSha256",
		{ x1: String ->
			spkiHexString_fromJs(x1)
		},
	)
	val secretForeignKeys = arrayToSet(
		obj.secretForeignKeys,
		"obj.secretForeignKeys",
		{ x1: String ->
			x1
		},
	)
	val cryptedForeignKeys = objectToMap(
		obj.cryptedForeignKeys,
		"obj.cryptedForeignKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val delegations = objectToMap(
		obj.delegations,
		"obj.delegations",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptionKeys = objectToMap(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			x1
		},
		{ x1: Array<DelegationJs> ->
			arrayToSet(
				x1,
				"x1",
				{ x2: DelegationJs ->
					delegation_fromJs(x2)
				},
			)
		},
	)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	val securityMetadata = obj.securityMetadata?.let { nonNull1 ->
		securityMetadata_fromJs(nonNull1)
	}
	val medicalLocationId = obj.medicalLocationId
	val nonDuplicateIds = arrayToSet(
		obj.nonDuplicateIds,
		"obj.nonDuplicateIds",
		{ x1: String ->
			x1
		},
	)
	val encryptedAdministrativesDocuments = arrayToSet(
		obj.encryptedAdministrativesDocuments,
		"obj.encryptedAdministrativesDocuments",
		{ x1: String ->
			x1
		},
	)
	val comment = obj.comment
	val warning = obj.warning
	val fatherBirthCountry = obj.fatherBirthCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val birthCountry = obj.birthCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val nativeCountry = obj.nativeCountry?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val socialStatus = obj.socialStatus?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val mainSourceOfIncome = obj.mainSourceOfIncome?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val schoolingInfos = arrayToList(
		obj.schoolingInfos,
		"obj.schoolingInfos",
		{ x1: SchoolingInfoJs ->
			schoolingInfo_fromJs(x1)
		},
	)
	val employementInfos = arrayToList(
		obj.employementInfos,
		"obj.employementInfos",
		{ x1: EmploymentInfoJs ->
			employmentInfo_fromJs(x1)
		},
	)
	return EncryptedPatient(
		id = id,
		identifier = identifier,
		rev = rev,
		created = created,
		modified = modified,
		author = author,
		responsible = responsible,
		tags = tags,
		codes = codes,
		endOfLife = endOfLife,
		deletionDate = deletionDate,
		firstName = firstName,
		lastName = lastName,
		names = names,
		companyName = companyName,
		languages = languages,
		addresses = addresses,
		civility = civility,
		gender = gender,
		birthSex = birthSex,
		mergeToPatientId = mergeToPatientId,
		mergedIds = mergedIds,
		alias = alias,
		active = active,
		deactivationReason = deactivationReason,
		deactivationDate = deactivationDate,
		ssin = ssin,
		maidenName = maidenName,
		spouseName = spouseName,
		partnerName = partnerName,
		personalStatus = personalStatus,
		dateOfBirth = dateOfBirth,
		dateOfDeath = dateOfDeath,
		timestampOfLatestEidReading = timestampOfLatestEidReading,
		placeOfBirth = placeOfBirth,
		placeOfDeath = placeOfDeath,
		deceased = deceased,
		education = education,
		profession = profession,
		notes = notes,
		note = note,
		administrativeNote = administrativeNote,
		nationality = nationality,
		race = race,
		ethnicity = ethnicity,
		preferredUserId = preferredUserId,
		picture = picture,
		externalId = externalId,
		insurabilities = insurabilities,
		partnerships = partnerships,
		patientHealthCareParties = patientHealthCareParties,
		financialInstitutionInformation = financialInstitutionInformation,
		medicalHouseContracts = medicalHouseContracts,
		patientProfessions = patientProfessions,
		parameters = parameters,
		properties = properties,
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		secretForeignKeys = secretForeignKeys,
		cryptedForeignKeys = cryptedForeignKeys,
		delegations = delegations,
		encryptionKeys = encryptionKeys,
		encryptedSelf = encryptedSelf,
		securityMetadata = securityMetadata,
		medicalLocationId = medicalLocationId,
		nonDuplicateIds = nonDuplicateIds,
		encryptedAdministrativesDocuments = encryptedAdministrativesDocuments,
		comment = comment,
		warning = warning,
		fatherBirthCountry = fatherBirthCountry,
		birthCountry = birthCountry,
		nativeCountry = nativeCountry,
		socialStatus = socialStatus,
		mainSourceOfIncome = mainSourceOfIncome,
		schoolingInfos = schoolingInfos,
		employementInfos = employementInfos,
	)
}

public fun patient_toJs(obj: Patient): PatientJs = when (obj) {
	is EncryptedPatient -> patient_toJs(obj)
	is DecryptedPatient -> patient_toJs(obj)
}

public fun patient_fromJs(obj: PatientJs): Patient = if (obj.isEncrypted) {
	patient_fromJs(obj as EncryptedPatientJs)
} else {
	patient_fromJs(obj as DecryptedPatientJs)
}
