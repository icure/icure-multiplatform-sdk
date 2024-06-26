import json
import base64
from typing import Union, Dict, List, Optional
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.base.CodeStub import CodeStub
from model.embed.PersonName import PersonName
from model.embed.Address import EncryptedAddress, DecryptedAddress
from model.embed.Gender import Gender
from model.embed.DeactivationReason import DeactivationReason
from model.embed.PersonalStatus import PersonalStatus
from model.embed.Annotation import Annotation
from model.embed.Insurability import EncryptedInsurability, DecryptedInsurability
from model.embed.Partnership import Partnership
from model.embed.PatientHealthCareParty import EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty
from model.embed.FinancialInstitutionInformation import EncryptedFinancialInstitutionInformation, DecryptedFinancialInstitutionInformation
from model.embed.MedicalHouseContract import EncryptedMedicalHouseContract, DecryptedMedicalHouseContract
from model.PropertyStub import EncryptedPropertyStub, DecryptedPropertyStub
from model.specializations.HexString import HexString
from model.specializations.SpkiHexString import SpkiHexString
from model.specializations.AesExchangeKeyEncryptionKeypairIdentifier import AesExchangeKeyEncryptionKeypairIdentifier
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata
from model.embed.SchoolingInfo import SchoolingInfo
from model.embed.EmploymentInfo import EmploymentInfo

Patient = Union['EncryptedPatient', 'DecryptedPatient']

def serialize_patient(patient: Patient) -> object:
	if instanceof(patient, EncryptedPatient):
		return {
			"type": "com.icure.sdk.model.EncryptedPatient",
			"entity": patient.__serialize__()
		}
	elif instanceof(patient, DecryptedPatient):
		return {
			"type": "com.icure.sdk.model.DecryptedPatient",
			"entity": patient.__serialize__()
		}
	else:
		raise Exception(f"{type(patient)} is not a known subclass of Patient")

def deserialize_patient(data: Union[str, Dict[str, object]]) -> 'Patient':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedPatient":
		EncryptedPatient._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedPatient":
		DecryptedPatient._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Patient")

@dataclass
class EncryptedPatient:
	id: str
	identifier: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: List[str] = field(default_factory=list)
	addresses: List['EncryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = Gender.Unknown
	birth_sex: Optional['Gender'] = Gender.Unknown
	merge_to_patient_id: Optional[str] = None
	merged_ids: List[str] = field(default_factory=list)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = DeactivationReason.Nothing
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = PersonalStatus.Unknown
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: List['EncryptedInsurability'] = field(default_factory=list)
	partnerships: List['Partnership'] = field(default_factory=list)
	patient_health_care_parties: List['EncryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: List['EncryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: List['EncryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: List['CodeStub'] = field(default_factory=list)
	parameters: Dict[str, List[str]] = field(default_factory=dict)
	properties: List['EncryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: List[str] = field(default_factory=list)
	encrypted_administratives_documents: List[str] = field(default_factory=list)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: List['SchoolingInfo'] = field(default_factory=list)
	employement_infos: List['EmploymentInfo'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPatient':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			first_name = deserialized_dict.get("firstName"),
			last_name = deserialized_dict.get("lastName"),
			names = [PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name = deserialized_dict.get("companyName"),
			languages = [x0 for x0 in deserialized_dict["languages"]],
			addresses = [EncryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility = deserialized_dict.get("civility"),
			gender = Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex = Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id = deserialized_dict.get("mergeToPatientId"),
			merged_ids = [x0 for x0 in deserialized_dict["mergedIds"]],
			alias = deserialized_dict.get("alias"),
			active = deserialized_dict["active"],
			deactivation_reason = DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date = deserialized_dict.get("deactivationDate"),
			ssin = deserialized_dict.get("ssin"),
			maiden_name = deserialized_dict.get("maidenName"),
			spouse_name = deserialized_dict.get("spouseName"),
			partner_name = deserialized_dict.get("partnerName"),
			personal_status = PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth = deserialized_dict.get("dateOfBirth"),
			date_of_death = deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading = deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth = deserialized_dict.get("placeOfBirth"),
			place_of_death = deserialized_dict.get("placeOfDeath"),
			deceased = deserialized_dict.get("deceased"),
			education = deserialized_dict.get("education"),
			profession = deserialized_dict.get("profession"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note = deserialized_dict.get("note"),
			administrative_note = deserialized_dict.get("administrativeNote"),
			nationality = deserialized_dict.get("nationality"),
			race = deserialized_dict.get("race"),
			ethnicity = deserialized_dict.get("ethnicity"),
			preferred_user_id = deserialized_dict.get("preferredUserId"),
			picture = bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id = deserialized_dict.get("externalId"),
			insurabilities = [EncryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships = [Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties = [EncryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information = [EncryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts = [EncryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions = [CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties = [EncryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key = deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256 = [x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids = [x0 for x0 in deserialized_dict["nonDuplicateIds"]],
			encrypted_administratives_documents = [x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]],
			comment = deserialized_dict.get("comment"),
			warning = deserialized_dict.get("warning"),
			father_birth_country = CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country = CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country = CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status = CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income = CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos = [SchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos = [EmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
		)

@dataclass
class DecryptedPatient:
	id: str
	identifier: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	first_name: Optional[str] = None
	last_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	company_name: Optional[str] = None
	languages: List[str] = field(default_factory=list)
	addresses: List['DecryptedAddress'] = field(default_factory=list)
	civility: Optional[str] = None
	gender: Optional['Gender'] = Gender.Unknown
	birth_sex: Optional['Gender'] = Gender.Unknown
	merge_to_patient_id: Optional[str] = None
	merged_ids: List[str] = field(default_factory=list)
	alias: Optional[str] = None
	active: bool = True
	deactivation_reason: 'DeactivationReason' = DeactivationReason.Nothing
	deactivation_date: Optional[int] = None
	ssin: Optional[str] = None
	maiden_name: Optional[str] = None
	spouse_name: Optional[str] = None
	partner_name: Optional[str] = None
	personal_status: Optional['PersonalStatus'] = PersonalStatus.Unknown
	date_of_birth: Optional[int] = None
	date_of_death: Optional[int] = None
	timestamp_of_latest_eid_reading: Optional[int] = None
	place_of_birth: Optional[str] = None
	place_of_death: Optional[str] = None
	deceased: Optional[bool] = None
	education: Optional[str] = None
	profession: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	note: Optional[str] = None
	administrative_note: Optional[str] = None
	nationality: Optional[str] = None
	race: Optional[str] = None
	ethnicity: Optional[str] = None
	preferred_user_id: Optional[str] = None
	picture: Optional[bytearray] = None
	external_id: Optional[str] = None
	insurabilities: List['DecryptedInsurability'] = field(default_factory=list)
	partnerships: List['Partnership'] = field(default_factory=list)
	patient_health_care_parties: List['DecryptedPatientHealthCareParty'] = field(default_factory=list)
	financial_institution_information: List['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	medical_house_contracts: List['DecryptedMedicalHouseContract'] = field(default_factory=list)
	patient_professions: List['CodeStub'] = field(default_factory=list)
	parameters: Dict[str, List[str]] = field(default_factory=dict)
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None
	medical_location_id: Optional[str] = None
	non_duplicate_ids: List[str] = field(default_factory=list)
	encrypted_administratives_documents: List[str] = field(default_factory=list)
	comment: Optional[str] = None
	warning: Optional[str] = None
	father_birth_country: Optional['CodeStub'] = None
	birth_country: Optional['CodeStub'] = None
	native_country: Optional['CodeStub'] = None
	social_status: Optional['CodeStub'] = None
	main_source_of_income: Optional['CodeStub'] = None
	schooling_infos: List['SchoolingInfo'] = field(default_factory=list)
	employement_infos: List['EmploymentInfo'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"firstName": self.first_name,
			"lastName": self.last_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"companyName": self.company_name,
			"languages": [x0 for x0 in self.languages],
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"civility": self.civility,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"birthSex": self.birth_sex.__serialize__() if self.birth_sex is not None else None,
			"mergeToPatientId": self.merge_to_patient_id,
			"mergedIds": [x0 for x0 in self.merged_ids],
			"alias": self.alias,
			"active": self.active,
			"deactivationReason": self.deactivation_reason.__serialize__(),
			"deactivationDate": self.deactivation_date,
			"ssin": self.ssin,
			"maidenName": self.maiden_name,
			"spouseName": self.spouse_name,
			"partnerName": self.partner_name,
			"personalStatus": self.personal_status.__serialize__() if self.personal_status is not None else None,
			"dateOfBirth": self.date_of_birth,
			"dateOfDeath": self.date_of_death,
			"timestampOfLatestEidReading": self.timestamp_of_latest_eid_reading,
			"placeOfBirth": self.place_of_birth,
			"placeOfDeath": self.place_of_death,
			"deceased": self.deceased,
			"education": self.education,
			"profession": self.profession,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"note": self.note,
			"administrativeNote": self.administrative_note,
			"nationality": self.nationality,
			"race": self.race,
			"ethnicity": self.ethnicity,
			"preferredUserId": self.preferred_user_id,
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"externalId": self.external_id,
			"insurabilities": [x0.__serialize__() for x0 in self.insurabilities],
			"partnerships": [x0.__serialize__() for x0 in self.partnerships],
			"patientHealthCareParties": [x0.__serialize__() for x0 in self.patient_health_care_parties],
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"medicalHouseContracts": [x0.__serialize__() for x0 in self.medical_house_contracts],
			"patientProfessions": [x0.__serialize__() for x0 in self.patient_professions],
			"parameters": {k0: [x1 for x1 in v0] for k0, v0 in self.parameters.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
			"medicalLocationId": self.medical_location_id,
			"nonDuplicateIds": [x0 for x0 in self.non_duplicate_ids],
			"encryptedAdministrativesDocuments": [x0 for x0 in self.encrypted_administratives_documents],
			"comment": self.comment,
			"warning": self.warning,
			"fatherBirthCountry": self.father_birth_country.__serialize__() if self.father_birth_country is not None else None,
			"birthCountry": self.birth_country.__serialize__() if self.birth_country is not None else None,
			"nativeCountry": self.native_country.__serialize__() if self.native_country is not None else None,
			"socialStatus": self.social_status.__serialize__() if self.social_status is not None else None,
			"mainSourceOfIncome": self.main_source_of_income.__serialize__() if self.main_source_of_income is not None else None,
			"schoolingInfos": [x0.__serialize__() for x0 in self.schooling_infos],
			"employementInfos": [x0.__serialize__() for x0 in self.employement_infos],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPatient':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			first_name = deserialized_dict.get("firstName"),
			last_name = deserialized_dict.get("lastName"),
			names = [PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			company_name = deserialized_dict.get("companyName"),
			languages = [x0 for x0 in deserialized_dict["languages"]],
			addresses = [DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			civility = deserialized_dict.get("civility"),
			gender = Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			birth_sex = Gender._deserialize(deserialized_dict.get("birthSex")) if deserialized_dict.get("birthSex") is not None else None,
			merge_to_patient_id = deserialized_dict.get("mergeToPatientId"),
			merged_ids = [x0 for x0 in deserialized_dict["mergedIds"]],
			alias = deserialized_dict.get("alias"),
			active = deserialized_dict["active"],
			deactivation_reason = DeactivationReason._deserialize(deserialized_dict["deactivationReason"]),
			deactivation_date = deserialized_dict.get("deactivationDate"),
			ssin = deserialized_dict.get("ssin"),
			maiden_name = deserialized_dict.get("maidenName"),
			spouse_name = deserialized_dict.get("spouseName"),
			partner_name = deserialized_dict.get("partnerName"),
			personal_status = PersonalStatus._deserialize(deserialized_dict.get("personalStatus")) if deserialized_dict.get("personalStatus") is not None else None,
			date_of_birth = deserialized_dict.get("dateOfBirth"),
			date_of_death = deserialized_dict.get("dateOfDeath"),
			timestamp_of_latest_eid_reading = deserialized_dict.get("timestampOfLatestEidReading"),
			place_of_birth = deserialized_dict.get("placeOfBirth"),
			place_of_death = deserialized_dict.get("placeOfDeath"),
			deceased = deserialized_dict.get("deceased"),
			education = deserialized_dict.get("education"),
			profession = deserialized_dict.get("profession"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			note = deserialized_dict.get("note"),
			administrative_note = deserialized_dict.get("administrativeNote"),
			nationality = deserialized_dict.get("nationality"),
			race = deserialized_dict.get("race"),
			ethnicity = deserialized_dict.get("ethnicity"),
			preferred_user_id = deserialized_dict.get("preferredUserId"),
			picture = bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			external_id = deserialized_dict.get("externalId"),
			insurabilities = [DecryptedInsurability._deserialize(x0) for x0 in deserialized_dict["insurabilities"]],
			partnerships = [Partnership._deserialize(x0) for x0 in deserialized_dict["partnerships"]],
			patient_health_care_parties = [DecryptedPatientHealthCareParty._deserialize(x0) for x0 in deserialized_dict["patientHealthCareParties"]],
			financial_institution_information = [DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			medical_house_contracts = [DecryptedMedicalHouseContract._deserialize(x0) for x0 in deserialized_dict["medicalHouseContracts"]],
			patient_professions = [CodeStub._deserialize(x0) for x0 in deserialized_dict["patientProfessions"]],
			parameters = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["parameters"].items())),
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key = deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256 = [x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			non_duplicate_ids = [x0 for x0 in deserialized_dict["nonDuplicateIds"]],
			encrypted_administratives_documents = [x0 for x0 in deserialized_dict["encryptedAdministrativesDocuments"]],
			comment = deserialized_dict.get("comment"),
			warning = deserialized_dict.get("warning"),
			father_birth_country = CodeStub._deserialize(deserialized_dict.get("fatherBirthCountry")) if deserialized_dict.get("fatherBirthCountry") is not None else None,
			birth_country = CodeStub._deserialize(deserialized_dict.get("birthCountry")) if deserialized_dict.get("birthCountry") is not None else None,
			native_country = CodeStub._deserialize(deserialized_dict.get("nativeCountry")) if deserialized_dict.get("nativeCountry") is not None else None,
			social_status = CodeStub._deserialize(deserialized_dict.get("socialStatus")) if deserialized_dict.get("socialStatus") is not None else None,
			main_source_of_income = CodeStub._deserialize(deserialized_dict.get("mainSourceOfIncome")) if deserialized_dict.get("mainSourceOfIncome") is not None else None,
			schooling_infos = [SchoolingInfo._deserialize(x0) for x0 in deserialized_dict["schoolingInfos"]],
			employement_infos = [EmploymentInfo._deserialize(x0) for x0 in deserialized_dict["employementInfos"]],
		)

__all__ = ['Patient','serialize_patient','deserialize_patient','EncryptedPatient','DecryptedPatient']