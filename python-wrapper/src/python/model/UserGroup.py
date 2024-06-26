import json
from typing import Optional, List, Union, Dict
from model.Group import Group
from dataclasses import field, dataclass

@dataclass
class UserGroup:
	group_id: Optional[str] = None
	group_name: Optional[str] = None
	groups_hierarchy: List['Group'] = field(default_factory=list)
	user_id: Optional[str] = None
	login: Optional[str] = None
	name: Optional[str] = None
	email: Optional[str] = None
	phone: Optional[str] = None
	patient_id: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	device_id: Optional[str] = None
	name_of_parent_of_topmost_group_in_hierarchy: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"groupId": self.group_id,
			"groupName": self.group_name,
			"groupsHierarchy": [x0.__serialize__() for x0 in self.groups_hierarchy],
			"userId": self.user_id,
			"login": self.login,
			"name": self.name,
			"email": self.email,
			"phone": self.phone,
			"patientId": self.patient_id,
			"healthcarePartyId": self.healthcare_party_id,
			"deviceId": self.device_id,
			"nameOfParentOfTopmostGroupInHierarchy": self.name_of_parent_of_topmost_group_in_hierarchy,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UserGroup':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			group_id = deserialized_dict.get("groupId"),
			group_name = deserialized_dict.get("groupName"),
			groups_hierarchy = [Group._deserialize(x0) for x0 in deserialized_dict["groupsHierarchy"]],
			user_id = deserialized_dict.get("userId"),
			login = deserialized_dict.get("login"),
			name = deserialized_dict.get("name"),
			email = deserialized_dict.get("email"),
			phone = deserialized_dict.get("phone"),
			patient_id = deserialized_dict.get("patientId"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			device_id = deserialized_dict.get("deviceId"),
			name_of_parent_of_topmost_group_in_hierarchy = deserialized_dict.get("nameOfParentOfTopmostGroupInHierarchy"),
		)

__all__ = ['UserGroup']