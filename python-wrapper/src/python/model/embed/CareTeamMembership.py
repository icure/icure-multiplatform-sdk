import json
from typing import Union, Dict, Optional
from model.embed.MembershipType import MembershipType
from model.specializations.Base64String import Base64String
from dataclasses import dataclass

CareTeamMembership = Union['DecryptedCareTeamMembership', 'EncryptedCareTeamMembership']

def serialize_care_team_membership(care_team_membership: CareTeamMembership) -> object:
	if instanceof(care_team_membership, DecryptedCareTeamMembership):
		return {
			"type": "com.icure.sdk.model.embed.DecryptedCareTeamMembership",
			"entity": care_team_membership.__serialize__()
		}
	elif instanceof(care_team_membership, EncryptedCareTeamMembership):
		return {
			"type": "com.icure.sdk.model.embed.EncryptedCareTeamMembership",
			"entity": care_team_membership.__serialize__()
		}
	else:
		raise Exception(f"{type(care_team_membership)} is not a known subclass of CareTeamMembership")

def deserialize_care_team_membership(data: Union[str, Dict[str, object]]) -> 'CareTeamMembership':
	deserialized_dict: dict[str, object]
	if isinstance(data, str):
		deserialized_dict = json.loads(data)
	else:
		deserialized_dict = data
	qualifier = deserialized_dict.get("type")
	if qualifier is None:
		raise Exception("Missing qualifier: type")
	if qualifier == "com.icure.sdk.model.embed.DecryptedCareTeamMembership":
		DecryptedCareTeamMembership._deserialize(deserialized_dict["entity"])
	elif qualifier == "com.icure.sdk.model.embed.EncryptedCareTeamMembership":
		EncryptedCareTeamMembership._deserialize(deserialized_dict["entity"])
	else:
		raise Exception(f"{qualifier} is not a known subclass of CareTeamMembership")

@dataclass
class DecryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DecryptedCareTeamMembership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			care_team_member_id = deserialized_dict.get("careTeamMemberId"),
			membership_type = MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

@dataclass
class EncryptedCareTeamMembership:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	care_team_member_id: Optional[str] = None
	membership_type: Optional['MembershipType'] = None
	encrypted_self: Optional['Base64String'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"careTeamMemberId": self.care_team_member_id,
			"membershipType": self.membership_type.__serialize__() if self.membership_type is not None else None,
			"encryptedSelf": self.encrypted_self,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EncryptedCareTeamMembership':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			care_team_member_id = deserialized_dict.get("careTeamMemberId"),
			membership_type = MembershipType._deserialize(deserialized_dict.get("membershipType")) if deserialized_dict.get("membershipType") is not None else None,
			encrypted_self = deserialized_dict.get("encryptedSelf"),
		)

__all__ = ['CareTeamMembership','serialize_care_team_membership','deserialize_care_team_membership','DecryptedCareTeamMembership','EncryptedCareTeamMembership']