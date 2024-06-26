import json
from typing import Union, Dict, Optional, List
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.CareTeamMembership import EncryptedCareTeamMembership, DecryptedCareTeamMembership
from model.specializations.Base64String import Base64String

PlanOfAction = Union['EncryptedPlanOfAction', 'DecryptedPlanOfAction']

def serialize_plan_of_action(plan_of_action: PlanOfAction) -> object:
	if instanceof(plan_of_action, EncryptedPlanOfAction):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedPlanOfAction",
			"entity": plan_of_action.__serialize__()
		}
	elif instanceof(plan_of_action, DecryptedPlanOfAction):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedPlanOfAction",
			"entity": plan_of_action.__serialize__()
		}
	else:
		raise Exception(f"{type(plan_of_action)} is not a known subclass of PlanOfAction")

def deserialize_plan_of_action(data: Union[str, Dict[str, object]]) -> 'PlanOfAction':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedPlanOfAction":
		EncryptedPlanOfAction._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedPlanOfAction":
		DecryptedPlanOfAction._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of PlanOfAction")

@dataclass
class EncryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: List[str] = field(default_factory=list)
	number_of_cares: Optional[int] = None
	care_team_memberships: List[Optional['EncryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
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
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedPlanOfAction':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			prescriber_id = deserialized_dict.get("prescriberId"),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			deadline_date = deserialized_dict.get("deadlineDate"),
			name = deserialized_dict.get("name"),
			descr = deserialized_dict.get("descr"),
			note = deserialized_dict.get("note"),
			id_opening_contact = deserialized_dict.get("idOpeningContact"),
			id_closing_contact = deserialized_dict.get("idClosingContact"),
			status = deserialized_dict["status"],
			document_ids = [x0 for x0 in deserialized_dict["documentIds"]],
			number_of_cares = deserialized_dict.get("numberOfCares"),
			care_team_memberships = [EncryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant = deserialized_dict["relevant"],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedPlanOfAction:
	id: str
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	prescriber_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	deadline_date: Optional[int] = None
	name: Optional[str] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	status: int = 0
	document_ids: List[str] = field(default_factory=list)
	number_of_cares: Optional[int] = None
	care_team_memberships: List[Optional['DecryptedCareTeamMembership']] = field(default_factory=list)
	relevant: bool = True
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
			"prescriberId": self.prescriber_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"deadlineDate": self.deadline_date,
			"name": self.name,
			"descr": self.descr,
			"note": self.note,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"status": self.status,
			"documentIds": [x0 for x0 in self.document_ids],
			"numberOfCares": self.number_of_cares,
			"careTeamMemberships": [x0.__serialize__() if x0 is not None else None for x0 in self.care_team_memberships],
			"relevant": self.relevant,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedPlanOfAction':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			prescriber_id = deserialized_dict.get("prescriberId"),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			deadline_date = deserialized_dict.get("deadlineDate"),
			name = deserialized_dict.get("name"),
			descr = deserialized_dict.get("descr"),
			note = deserialized_dict.get("note"),
			id_opening_contact = deserialized_dict.get("idOpeningContact"),
			id_closing_contact = deserialized_dict.get("idClosingContact"),
			status = deserialized_dict["status"],
			document_ids = [x0 for x0 in deserialized_dict["documentIds"]],
			number_of_cares = deserialized_dict.get("numberOfCares"),
			care_team_memberships = [DecryptedCareTeamMembership._deserialize(x0) if x0 is not None else None for x0 in deserialized_dict["careTeamMemberships"]],
			relevant = deserialized_dict["relevant"],
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['PlanOfAction','serialize_plan_of_action','deserialize_plan_of_action','EncryptedPlanOfAction','DecryptedPlanOfAction']