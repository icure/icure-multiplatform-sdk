import json
from typing import Union, Dict, Optional, List
from dataclasses import field, dataclass
from model.specializations.Base64String import Base64String

Valorisation = Union['EncryptedValorisation', 'DecryptedValorisation']

def serialize_valorisation(valorisation: Valorisation) -> object:
	if instanceof(valorisation, EncryptedValorisation):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedValorisation",
			"entity": valorisation.__serialize__()
		}
	elif instanceof(valorisation, DecryptedValorisation):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedValorisation",
			"entity": valorisation.__serialize__()
		}
	else:
		raise Exception(f"{type(valorisation)} is not a known subclass of Valorisation")

def deserialize_valorisation(data: Union[str, Dict[str, object]]) -> 'Valorisation':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedValorisation":
		EncryptedValorisation._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedValorisation":
		DecryptedValorisation._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of Valorisation")

@dataclass
class EncryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[List[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[Dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedValorisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity = deserialized_dict.get("startOfValidity"),
			end_of_validity = deserialized_dict.get("endOfValidity"),
			predicate = deserialized_dict.get("predicate"),
			reference = [x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount = deserialized_dict.get("totalAmount"),
			reimbursement = deserialized_dict.get("reimbursement"),
			patient_intervention = deserialized_dict.get("patientIntervention"),
			doctor_supplement = deserialized_dict.get("doctorSupplement"),
			vat = deserialized_dict.get("vat"),
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedValorisation:
	start_of_validity: Optional[int] = None
	end_of_validity: Optional[int] = None
	predicate: Optional[str] = None
	reference: Optional[List[int]] = None
	total_amount: Optional[float] = None
	reimbursement: Optional[float] = None
	patient_intervention: Optional[float] = None
	doctor_supplement: Optional[float] = None
	vat: Optional[float] = None
	label: Optional[Dict[str, str]] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startOfValidity": self.start_of_validity,
			"endOfValidity": self.end_of_validity,
			"predicate": self.predicate,
			"reference": [x0 for x0 in self.reference] if self.reference is not None else None,
			"totalAmount": self.total_amount,
			"reimbursement": self.reimbursement,
			"patientIntervention": self.patient_intervention,
			"doctorSupplement": self.doctor_supplement,
			"vat": self.vat,
			"label": {k0: v0 for k0, v0 in self.label.items()} if self.label is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedValorisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_of_validity = deserialized_dict.get("startOfValidity"),
			end_of_validity = deserialized_dict.get("endOfValidity"),
			predicate = deserialized_dict.get("predicate"),
			reference = [x0 for x0 in deserialized_dict.get("reference")] if deserialized_dict.get("reference") is not None else None,
			total_amount = deserialized_dict.get("totalAmount"),
			reimbursement = deserialized_dict.get("reimbursement"),
			patient_intervention = deserialized_dict.get("patientIntervention"),
			doctor_supplement = deserialized_dict.get("doctorSupplement"),
			vat = deserialized_dict.get("vat"),
			label = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict.get("label").items())) if deserialized_dict.get("label") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['Valorisation','serialize_valorisation','deserialize_valorisation','EncryptedValorisation','DecryptedValorisation']