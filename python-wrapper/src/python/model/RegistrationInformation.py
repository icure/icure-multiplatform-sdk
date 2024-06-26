import json
from typing import Optional, List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class RegistrationInformation:
	first_name: str
	last_name: str
	email_address: str
	user_options: Optional[str] = None
	user_roles: List[str] = field(default_factory=list)
	minimum_kraken_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"firstName": self.first_name,
			"lastName": self.last_name,
			"emailAddress": self.email_address,
			"userOptions": self.user_options,
			"userRoles": [x0 for x0 in self.user_roles],
			"minimumKrakenVersion": self.minimum_kraken_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RegistrationInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			first_name = deserialized_dict["firstName"],
			last_name = deserialized_dict["lastName"],
			email_address = deserialized_dict["emailAddress"],
			user_options = deserialized_dict.get("userOptions"),
			user_roles = [x0 for x0 in deserialized_dict["userRoles"]],
			minimum_kraken_version = deserialized_dict.get("minimumKrakenVersion"),
		)

__all__ = ['RegistrationInformation']