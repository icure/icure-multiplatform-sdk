import json
from typing import Union, Dict, Optional
from model.embed.CareTeamMemberType import CareTeamMemberType
from model.base.CodeStub import CodeStub
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

CareTeamMember = Union['EncryptedCareTeamMember', 'DecryptedCareTeamMember']

def serialize_care_team_member(care_team_member: CareTeamMember) -> object:
	if isinstance(care_team_member, EncryptedCareTeamMember):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedCareTeamMember",
			"entity": care_team_member.__serialize__()
		}
	elif isinstance(care_team_member, DecryptedCareTeamMember):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedCareTeamMember",
			"entity": care_team_member.__serialize__()
		}
	else:
		raise Exception(f"{type(care_team_member)} is not a known subclass of CareTeamMember")

def deserialize_care_team_member(data: Union[str, Dict[str, object]]) -> 'CareTeamMember':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.EncryptedCareTeamMember":
		EncryptedCareTeamMember._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.DecryptedCareTeamMember":
		DecryptedCareTeamMember._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMember")

@dataclass
class EncryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCareTeamMember':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			care_team_member_type = CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			quality = CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class DecryptedCareTeamMember:
	id: str
	care_team_member_type: Optional['CareTeamMemberType'] = None
	healthcare_party_id: Optional[str] = None
	quality: Optional['CodeStub'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"careTeamMemberType": self.care_team_member_type.__serialize__() if self.care_team_member_type is not None else None,
			"healthcarePartyId": self.healthcare_party_id,
			"quality": self.quality.__serialize__() if self.quality is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCareTeamMember':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			care_team_member_type = CareTeamMemberType._deserialize(deserialized_dict.get("careTeamMemberType")) if deserialized_dict.get("careTeamMemberType") is not None else None,
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			quality = CodeStub._deserialize(deserialized_dict.get("quality")) if deserialized_dict.get("quality") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['CareTeamMember','serialize_care_team_member','deserialize_care_team_member','EncryptedCareTeamMember','DecryptedCareTeamMember']