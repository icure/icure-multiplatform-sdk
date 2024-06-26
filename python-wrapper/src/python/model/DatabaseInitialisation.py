import json
from typing import Optional, List, Union, Dict
from model.User import User
from dataclasses import field, dataclass
from model.HealthcareParty import HealthcareParty
from model.Replication import Replication

@dataclass
class DatabaseInitialisation:
	users: Optional[List['User']] = field(default_factory=list)
	healthcare_parties: Optional[List['HealthcareParty']] = field(default_factory=list)
	replication: Optional['Replication'] = None
	minimum_kraken_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"users": [x0.__serialize__() for x0 in self.users] if self.users is not None else None,
			"healthcareParties": [x0.__serialize__() for x0 in self.healthcare_parties] if self.healthcare_parties is not None else None,
			"replication": self.replication.__serialize__() if self.replication is not None else None,
			"minimumKrakenVersion": self.minimum_kraken_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseInitialisation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			users = [User._deserialize(x0) for x0 in deserialized_dict.get("users")] if deserialized_dict.get("users") is not None else None,
			healthcare_parties = [HealthcareParty._deserialize(x0) for x0 in deserialized_dict.get("healthcareParties")] if deserialized_dict.get("healthcareParties") is not None else None,
			replication = Replication._deserialize(deserialized_dict.get("replication")) if deserialized_dict.get("replication") is not None else None,
			minimum_kraken_version = deserialized_dict.get("minimumKrakenVersion"),
		)

__all__ = ['DatabaseInitialisation']