import json
from typing import Union, Dict, List, Optional
from model.base.Identifier import Identifier
from dataclasses import field, dataclass
from model.base.CodeStub import CodeStub
from model.embed.Annotation import Annotation
from model.embed.Laterality import Laterality
from model.embed.PlanOfAction import EncryptedPlanOfAction, DecryptedPlanOfAction
from model.embed.Episode import EncryptedEpisode, DecryptedEpisode
from model.embed.CareTeamMember import EncryptedCareTeamMember, DecryptedCareTeamMember
from model.embed.Delegation import Delegation
from model.specializations.Base64String import Base64String
from model.embed.SecurityMetadata import SecurityMetadata

HealthElement = Union['EncryptedHealthElement', 'DecryptedHealthElement']

def serialize_health_element(health_element: HealthElement) -> object:
	if instanceof(health_element, EncryptedHealthElement):
		return {
			"type": "com.icure.sdk.model.EncryptedHealthElement",
			"entity": health_element.__serialize__()
		}
	elif instanceof(health_element, DecryptedHealthElement):
		return {
			"type": "com.icure.sdk.model.DecryptedHealthElement",
			"entity": health_element.__serialize__()
		}
	else:
		raise Exception(f"{type(health_element)} is not a known subclass of HealthElement")

def deserialize_health_element(data: Union[str, Dict[str, object]]) -> 'HealthElement':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.EncryptedHealthElement":
		EncryptedHealthElement._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.DecryptedHealthElement":
		DecryptedHealthElement._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of HealthElement")

@dataclass
class EncryptedHealthElement:
	id: str
	identifiers: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: List['EncryptedPlanOfAction'] = field(default_factory=list)
	episodes: List['EncryptedEpisode'] = field(default_factory=list)
	care_team: List['EncryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedHealthElement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			health_element_id = deserialized_dict.get("healthElementId"),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			descr = deserialized_dict.get("descr"),
			note = deserialized_dict.get("note"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant = deserialized_dict["relevant"],
			id_opening_contact = deserialized_dict.get("idOpeningContact"),
			id_closing_contact = deserialized_dict.get("idClosingContact"),
			id_service = deserialized_dict.get("idService"),
			status = deserialized_dict["status"],
			laterality = Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action = [EncryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes = [EncryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team = [EncryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

@dataclass
class DecryptedHealthElement:
	id: str
	identifiers: List['Identifier'] = field(default_factory=list)
	rev: Optional[str] = None
	created: Optional[int] = None
	modified: Optional[int] = None
	author: Optional[str] = None
	responsible: Optional[str] = None
	medical_location_id: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	end_of_life: Optional[int] = None
	deletion_date: Optional[int] = None
	health_element_id: Optional[str] = None
	value_date: Optional[int] = None
	opening_date: Optional[int] = None
	closing_date: Optional[int] = None
	descr: Optional[str] = None
	note: Optional[str] = None
	notes: List['Annotation'] = field(default_factory=list)
	relevant: bool = True
	id_opening_contact: Optional[str] = None
	id_closing_contact: Optional[str] = None
	id_service: Optional[str] = None
	status: int = 0
	laterality: Optional['Laterality'] = None
	plans_of_action: List['DecryptedPlanOfAction'] = field(default_factory=list)
	episodes: List['DecryptedEpisode'] = field(default_factory=list)
	care_team: List['DecryptedCareTeamMember'] = field(default_factory=list)
	secret_foreign_keys: List[str] = field(default_factory=list)
	crypted_foreign_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	delegations: Dict[str, List['Delegation']] = field(default_factory=dict)
	encryption_keys: Dict[str, List['Delegation']] = field(default_factory=dict)
	encrypted_self: Optional['Base64String'] = None
	security_metadata: Optional['SecurityMetadata'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"identifiers": [x0.__serialize__() for x0 in self.identifiers],
			"rev": self.rev,
			"created": self.created,
			"modified": self.modified,
			"author": self.author,
			"responsible": self.responsible,
			"medicalLocationId": self.medical_location_id,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"endOfLife": self.end_of_life,
			"deletionDate": self.deletion_date,
			"healthElementId": self.health_element_id,
			"valueDate": self.value_date,
			"openingDate": self.opening_date,
			"closingDate": self.closing_date,
			"descr": self.descr,
			"note": self.note,
			"notes": [x0.__serialize__() for x0 in self.notes],
			"relevant": self.relevant,
			"idOpeningContact": self.id_opening_contact,
			"idClosingContact": self.id_closing_contact,
			"idService": self.id_service,
			"status": self.status,
			"laterality": self.laterality.__serialize__() if self.laterality is not None else None,
			"plansOfAction": [x0.__serialize__() for x0 in self.plans_of_action],
			"episodes": [x0.__serialize__() for x0 in self.episodes],
			"careTeam": [x0.__serialize__() for x0 in self.care_team],
			"secretForeignKeys": [x0 for x0 in self.secret_foreign_keys],
			"cryptedForeignKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.crypted_foreign_keys.items()},
			"delegations": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.delegations.items()},
			"encryptionKeys": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in self.encryption_keys.items()},
			"encryptedSelf": self.encrypted_self,
			"securityMetadata": self.security_metadata.__serialize__() if self.security_metadata is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedHealthElement':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			identifiers = [Identifier._deserialize(x0) for x0 in deserialized_dict["identifiers"]],
			rev = deserialized_dict.get("rev"),
			created = deserialized_dict.get("created"),
			modified = deserialized_dict.get("modified"),
			author = deserialized_dict.get("author"),
			responsible = deserialized_dict.get("responsible"),
			medical_location_id = deserialized_dict.get("medicalLocationId"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			end_of_life = deserialized_dict.get("endOfLife"),
			deletion_date = deserialized_dict.get("deletionDate"),
			health_element_id = deserialized_dict.get("healthElementId"),
			value_date = deserialized_dict.get("valueDate"),
			opening_date = deserialized_dict.get("openingDate"),
			closing_date = deserialized_dict.get("closingDate"),
			descr = deserialized_dict.get("descr"),
			note = deserialized_dict.get("note"),
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			relevant = deserialized_dict["relevant"],
			id_opening_contact = deserialized_dict.get("idOpeningContact"),
			id_closing_contact = deserialized_dict.get("idClosingContact"),
			id_service = deserialized_dict.get("idService"),
			status = deserialized_dict["status"],
			laterality = Laterality._deserialize(deserialized_dict.get("laterality")) if deserialized_dict.get("laterality") is not None else None,
			plans_of_action = [DecryptedPlanOfAction._deserialize(x0) for x0 in deserialized_dict["plansOfAction"]],
			episodes = [DecryptedEpisode._deserialize(x0) for x0 in deserialized_dict["episodes"]],
			care_team = [DecryptedCareTeamMember._deserialize(x0) for x0 in deserialized_dict["careTeam"]],
			secret_foreign_keys = [x0 for x0 in deserialized_dict["secretForeignKeys"]],
			crypted_foreign_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["cryptedForeignKeys"].items())),
			delegations = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["delegations"].items())),
			encryption_keys = dict(map(lambda kv0: (kv0[0], [Delegation._deserialize(x1) for x1 in kv0[1]]), deserialized_dict["encryptionKeys"].items())),
			encrypted_self = deserialized_dict.get("encryptedSelf"),
			security_metadata = SecurityMetadata._deserialize(deserialized_dict.get("securityMetadata")) if deserialized_dict.get("securityMetadata") is not None else None,
		)

__all__ = ['HealthElement','serialize_health_element','deserialize_health_element','EncryptedHealthElement','DecryptedHealthElement']