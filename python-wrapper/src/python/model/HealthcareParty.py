import base64
import json
from typing import Optional, List, Dict, Union
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.base.CodeStub import CodeStub
from model.embed.PersonName import PersonName
from model.embed.Gender import Gender
from model.embed.Address import DecryptedAddress
from model.embed.HealthcarePartyStatus import HealthcarePartyStatus
from model.embed.HealthcarePartyHistoryStatus import HealthcarePartyHistoryStatus
from model.embed.TelecomType import TelecomType
from model.embed.FinancialInstitutionInformation import DecryptedFinancialInstitutionInformation
from model.embed.FlatRateTarification import DecryptedFlatRateTarification
from model.PropertyStub import DecryptedPropertyStub
from model.specializations.HexString import HexString
from model.specializations.SpkiHexString import SpkiHexString
from model.specializations.AesExchangeKeyEncryptionKeypairIdentifier import AesExchangeKeyEncryptionKeypairIdentifier

@dataclass
class HealthcareParty:
	id: str
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	deletion_date: Optional[int] = None
	identifier: List['Identifier'] = field(default_factory=list)
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	name: Optional[str] = None
	last_name: Optional[str] = None
	first_name: Optional[str] = None
	names: List['PersonName'] = field(default_factory=list)
	gender: Optional['Gender'] = None
	civility: Optional[str] = None
	company_name: Optional[str] = None
	speciality: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	invoice_header: Optional[str] = None
	cbe: Optional[str] = None
	ehp: Optional[str] = None
	user_id: Optional[str] = None
	parent_id: Optional[str] = None
	convention: Optional[int] = None
	nihii: Optional[str] = None
	nihii_spec_code: Optional[str] = None
	ssin: Optional[str] = None
	addresses: List['DecryptedAddress'] = field(default_factory=list)
	languages: List[str] = field(default_factory=list)
	picture: Optional[bytearray] = None
	statuses: List['HealthcarePartyStatus'] = field(default_factory=list)
	status_history: List['HealthcarePartyHistoryStatus'] = field(default_factory=list)
	speciality_codes: List['CodeStub'] = field(default_factory=list)
	send_formats: Dict['TelecomType', str] = field(default_factory=dict)
	notes: Optional[str] = None
	financial_institution_information: List['DecryptedFinancialInstitutionInformation'] = field(default_factory=list)
	descr: Optional[Dict[str, str]] = field(default_factory=dict)
	billing_type: Optional[str] = None
	type: Optional[str] = None
	contact_person: Optional[str] = None
	contact_person_hcp_id: Optional[str] = None
	supervisor_id: Optional[str] = None
	flat_rate_tarifications: List['DecryptedFlatRateTarification'] = field(default_factory=list)
	imported_data: Dict[str, str] = field(default_factory=dict)
	options: Dict[str, str] = field(default_factory=dict)
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)
	hc_party_keys: Dict[str, List['HexString']] = field(default_factory=dict)
	aes_exchange_keys: Dict['SpkiHexString', Dict[str, Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']]] = field(default_factory=dict)
	transfer_keys: Dict['AesExchangeKeyEncryptionKeypairIdentifier', Dict['AesExchangeKeyEncryptionKeypairIdentifier', 'HexString']] = field(default_factory=dict)
	private_key_shamir_partitions: Dict[str, 'HexString'] = field(default_factory=dict)
	public_key: Optional['SpkiHexString'] = None
	public_keys_for_oaep_with_sha256: List['SpkiHexString'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"deletionDate": self.deletion_date,
			"identifier": [x0.__serialize__() for x0 in self.identifier],
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"name": self.name,
			"lastName": self.last_name,
			"firstName": self.first_name,
			"names": [x0.__serialize__() for x0 in self.names],
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"civility": self.civility,
			"companyName": self.company_name,
			"speciality": self.speciality,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"invoiceHeader": self.invoice_header,
			"cbe": self.cbe,
			"ehp": self.ehp,
			"userId": self.user_id,
			"parentId": self.parent_id,
			"convention": self.convention,
			"nihii": self.nihii,
			"nihiiSpecCode": self.nihii_spec_code,
			"ssin": self.ssin,
			"addresses": [x0.__serialize__() for x0 in self.addresses],
			"languages": [x0 for x0 in self.languages],
			"picture": base64.b64encode(self.picture).decode('utf-8') if self.picture is not None else None,
			"statuses": [x0.__serialize__() for x0 in self.statuses],
			"statusHistory": [x0.__serialize__() for x0 in self.status_history],
			"specialityCodes": [x0.__serialize__() for x0 in self.speciality_codes],
			"sendFormats": {k0.__serialize__(): v0 for k0, v0 in self.send_formats.items()},
			"notes": self.notes,
			"financialInstitutionInformation": [x0.__serialize__() for x0 in self.financial_institution_information],
			"descr": {k0: v0 for k0, v0 in self.descr.items()} if self.descr is not None else None,
			"billingType": self.billing_type,
			"type": self.type,
			"contactPerson": self.contact_person,
			"contactPersonHcpId": self.contact_person_hcp_id,
			"supervisorId": self.supervisor_id,
			"flatRateTarifications": [x0.__serialize__() for x0 in self.flat_rate_tarifications],
			"importedData": {k0: v0 for k0, v0 in self.imported_data.items()},
			"options": {k0: v0 for k0, v0 in self.options.items()},
			"properties": [x0.__serialize__() for x0 in self.properties],
			"hcPartyKeys": {k0: [x1 for x1 in v0] for k0, v0 in self.hc_party_keys.items()},
			"aesExchangeKeys": {k0: {k1: {k2: v2 for k2, v2 in v1.items()} for k1, v1 in v0.items()} for k0, v0 in self.aes_exchange_keys.items()},
			"transferKeys": {k0: {k1: v1 for k1, v1 in v0.items()} for k0, v0 in self.transfer_keys.items()},
			"privateKeyShamirPartitions": {k0: v0 for k0, v0 in self.private_key_shamir_partitions.items()},
			"publicKey": self.public_key,
			"publicKeysForOaepWithSha256": [x0 for x0 in self.public_keys_for_oaep_with_sha256],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcareParty':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			deletion_date = deserialized_dict.get("deletionDate"),
			identifier = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifier"]],
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			name = deserialized_dict.get("name"),
			last_name = deserialized_dict.get("lastName"),
			first_name = deserialized_dict.get("firstName"),
			names = [PersonName._deserialize(x0) for x0 in deserialized_dict["names"]],
			gender = Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			civility = deserialized_dict.get("civility"),
			company_name = deserialized_dict.get("companyName"),
			speciality = deserialized_dict.get("speciality"),
			bank_account = deserialized_dict.get("bankAccount"),
			bic = deserialized_dict.get("bic"),
			proxy_bank_account = deserialized_dict.get("proxyBankAccount"),
			proxy_bic = deserialized_dict.get("proxyBic"),
			invoice_header = deserialized_dict.get("invoiceHeader"),
			cbe = deserialized_dict.get("cbe"),
			ehp = deserialized_dict.get("ehp"),
			user_id = deserialized_dict.get("userId"),
			parent_id = deserialized_dict.get("parentId"),
			convention = deserialized_dict.get("convention"),
			nihii = deserialized_dict.get("nihii"),
			nihii_spec_code = deserialized_dict.get("nihiiSpecCode"),
			ssin = deserialized_dict.get("ssin"),
			addresses = [DecryptedAddress._deserialize(x0) for x0 in deserialized_dict["addresses"]],
			languages = [x0 for x0 in deserialized_dict["languages"]],
			picture = bytearray(base64.b64decode(deserialized_dict.get("picture"))) if deserialized_dict.get("picture") is not None else None,
			statuses = [HealthcarePartyStatus._deserialize(x0) for x0 in deserialized_dict["statuses"]],
			status_history = [HealthcarePartyHistoryStatus._deserialize(x0) for x0 in deserialized_dict["statusHistory"]],
			speciality_codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["specialityCodes"]],
			send_formats = dict(map(lambda kv0: (TelecomType._deserialize(kv0[0]), kv0[1]), deserialized_dict["sendFormats"].items())),
			notes = deserialized_dict.get("notes"),
			financial_institution_information = [DecryptedFinancialInstitutionInformation._deserialize(x0) for x0 in deserialized_dict["financialInstitutionInformation"]],
			descr = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("descr").items())) if deserialized_dict.get("descr") is not None else None,
			billing_type = deserialized_dict.get("billingType"),
			type = deserialized_dict.get("type"),
			contact_person = deserialized_dict.get("contactPerson"),
			contact_person_hcp_id = deserialized_dict.get("contactPersonHcpId"),
			supervisor_id = deserialized_dict.get("supervisorId"),
			flat_rate_tarifications = [DecryptedFlatRateTarification._deserialize(x0) for x0 in deserialized_dict["flatRateTarifications"]],
			imported_data = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["importedData"].items())),
			options = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["options"].items())),
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
			hc_party_keys = dict(map(lambda kv0: (kv0[0], [x1 for x1 in kv0[1]]), deserialized_dict["hcPartyKeys"].items())),
			aes_exchange_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], kv2[1]), kv1[1].items()))), kv0[1].items()))), deserialized_dict["aesExchangeKeys"].items())),
			transfer_keys = dict(map(lambda kv0: (kv0[0], dict(map(lambda kv1: (kv1[0], kv1[1]), kv0[1].items()))), deserialized_dict["transferKeys"].items())),
			private_key_shamir_partitions = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["privateKeyShamirPartitions"].items())),
			public_key = deserialized_dict.get("publicKey"),
			public_keys_for_oaep_with_sha256 = [x0 for x0 in deserialized_dict["publicKeysForOaepWithSha256"]],
		)

__all__ = ['HealthcareParty']