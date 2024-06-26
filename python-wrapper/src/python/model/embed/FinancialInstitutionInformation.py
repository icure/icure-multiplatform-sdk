import json
from typing import Union, Dict, Optional, List
from dataclasses import field, dataclass
from model.specializations.Base64String import Base64String

FinancialInstitutionInformation = Union['EncryptedFinancialInstitutionInformation', 'DecryptedFinancialInstitutionInformation']

def serialize_financial_institution_information(financial_institution_information: FinancialInstitutionInformation) -> object:
	if isinstance(financial_institution_information, EncryptedFinancialInstitutionInformation):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation",
			"entity": financial_institution_information.__serialize__()
		}
	elif isinstance(financial_institution_information, DecryptedFinancialInstitutionInformation):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation",
			"entity": financial_institution_information.__serialize__()
		}
	else:
		raise Exception(f"{type(financial_institution_information)} is not a known subclass of FinancialInstitutionInformation")

def deserialize_financial_institution_information(data: Union[str, Dict[str, object]]) -> 'FinancialInstitutionInformation':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedFinancialInstitutionInformation":
		EncryptedFinancialInstitutionInformation._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedFinancialInstitutionInformation":
		DecryptedFinancialInstitutionInformation._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of FinancialInstitutionInformation")

@dataclass
class EncryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: List[str] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name = deserialized_dict.get("name"),
			key = deserialized_dict.get("key"),
			bank_account = deserialized_dict.get("bankAccount"),
			bic = deserialized_dict.get("bic"),
			proxy_bank_account = deserialized_dict.get("proxyBankAccount"),
			proxy_bic = deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners = [x0 for x0 in deserialized_dict["preferredFiiForPartners"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedFinancialInstitutionInformation:
	name: Optional[str] = None
	key: Optional[str] = None
	bank_account: Optional[str] = None
	bic: Optional[str] = None
	proxy_bank_account: Optional[str] = None
	proxy_bic: Optional[str] = None
	preferred_fii_for_partners: List[str] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"key": self.key,
			"bankAccount": self.bank_account,
			"bic": self.bic,
			"proxyBankAccount": self.proxy_bank_account,
			"proxyBic": self.proxy_bic,
			"preferredFiiForPartners": [x0 for x0 in self.preferred_fii_for_partners],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedFinancialInstitutionInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name = deserialized_dict.get("name"),
			key = deserialized_dict.get("key"),
			bank_account = deserialized_dict.get("bankAccount"),
			bic = deserialized_dict.get("bic"),
			proxy_bank_account = deserialized_dict.get("proxyBankAccount"),
			proxy_bic = deserialized_dict.get("proxyBic"),
			preferred_fii_for_partners = [x0 for x0 in deserialized_dict["preferredFiiForPartners"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['FinancialInstitutionInformation','serialize_financial_institution_information','deserialize_financial_institution_information','EncryptedFinancialInstitutionInformation','DecryptedFinancialInstitutionInformation']