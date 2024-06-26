import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.ServiceLink import ServiceLink
from model.specializations.Base64String import Base64String

SubContact = Union['EncryptedSubContact', 'DecryptedSubContact']

def serialize_sub_contact(sub_contact: SubContact) -> object:
	if instanceof(sub_contact, EncryptedSubContact):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedSubContact",
			"entity": sub_contact.__serialize__()
		}
	elif instanceof(sub_contact, DecryptedSubContact):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedSubContact",
			"entity": sub_contact.__serialize__()
		}
	else:
		raise Exception(f"{type(sub_contact)} is not a known subclass of SubContact")

def deserialize_sub_contact(data: Union[str, Dict[str, object]]) -> 'SubContact':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedSubContact":
		EncryptedSubContact._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedSubContact":
		DecryptedSubContact._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of SubContact")

@dataclass
class EncryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: List['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedSubContact':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			descr = deserialized_dict.get("descr"),
			protocol = deserialized_dict.get("protocol"),
			status = deserialized_dict.get("status"),
			form_id = deserialized_dict.get("formId"),
			plan_of_action_id = deserialized_dict.get("planOfActionId"),
			health_element_id = deserialized_dict.get("healthElementId"),
			classification_id = deserialized_dict.get("classificationId"),
			services = [ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedSubContact:
	id: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	descr: Optional[str] = None
	protocol: Optional[str] = None
	status: Optional[int] = None
	form_id: Optional[str] = None
	plan_of_action_id: Optional[str] = None
	health_element_id: Optional[str] = None
	classification_id: Optional[str] = None
	services: List['ServiceLink'] = field(default_factory=list)
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"descr": self.descr,
			"protocol": self.protocol,
			"status": self.status,
			"formId": self.form_id,
			"planOfActionId": self.plan_of_action_id,
			"healthElementId": self.health_element_id,
			"classificationId": self.classification_id,
			"services": [x0.__serialize__() for x0 in self.services],
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedSubContact':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict.get("id"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			descr = deserialized_dict.get("descr"),
			protocol = deserialized_dict.get("protocol"),
			status = deserialized_dict.get("status"),
			form_id = deserialized_dict.get("formId"),
			plan_of_action_id = deserialized_dict.get("planOfActionId"),
			health_element_id = deserialized_dict.get("healthElementId"),
			classification_id = deserialized_dict.get("classificationId"),
			services = [ServiceLink._deserialize(x0) for x0 in deserialized_dict["services"]],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['SubContact','serialize_sub_contact','deserialize_sub_contact','EncryptedSubContact','DecryptedSubContact']