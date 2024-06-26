import json
from typing import Optional, Union, Dict
from model.embed.Address import DecryptedAddress
from dataclasses import dataclass

@dataclass
class Place:
	id: str
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Optional[str] = None
	address: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": self.name,
			"address": self.address.__serialize__() if self.address is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Place':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			name = deserialized_dict.get("name"),
			address = DecryptedAddress._deserialize(deserialized_dict.get("address")) if deserialized_dict.get("address") is not None else None,
		)

__all__ = ['Place']