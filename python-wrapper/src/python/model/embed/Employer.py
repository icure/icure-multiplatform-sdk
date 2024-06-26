import json
from typing import Optional, Union, Dict
from model.embed.Address import DecryptedAddress
from dataclasses import dataclass

@dataclass
class Employer:
	name: Optional[str] = None
	addresse: Optional['DecryptedAddress'] = None

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"addresse": self.addresse.__serialize__() if self.addresse is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Employer':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name = deserialized_dict.get("name"),
			addresse = DecryptedAddress._deserialize(deserialized_dict.get("addresse")) if deserialized_dict.get("addresse") is not None else None,
		)

__all__ = ['Employer']