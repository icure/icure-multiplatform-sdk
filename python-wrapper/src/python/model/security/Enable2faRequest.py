import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class Enable2faRequest:
	secret: str

	def __serialize__(self) -> object:
		return {
			"secret": self.secret,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Enable2faRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			secret = deserialized_dict["secret"],
		)

__all__ = ['Enable2faRequest']