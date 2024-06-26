import json
from typing import Dict, Union
from model.embed.AccessLevel import AccessLevel
from dataclasses import dataclass

@dataclass
class EntityAccessInformation:
	permissions_by_data_owner_id: Dict[str, 'AccessLevel']
	has_unknown_anonymous_data_owners: bool

	def __serialize__(self) -> object:
		return {
			"permissionsByDataOwnerId": {k0: v0.__serialize__() for k0, v0 in self.permissions_by_data_owner_id.items()},
			"hasUnknownAnonymousDataOwners": self.has_unknown_anonymous_data_owners,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EntityAccessInformation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			permissions_by_data_owner_id = dict(map(lambda kv0: (kv0[0], AccessLevel._deserialize(kv0[1])), deserialized_dict["permissionsByDataOwnerId"].items())),
			has_unknown_anonymous_data_owners = deserialized_dict["hasUnknownAnonymousDataOwners"],
		)

__all__ = ['EntityAccessInformation']