import json
from model.security.Operation import Operation
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class OperationToken:
	token_hash: str
	creation_time: int
	validity: int
	operation: 'Operation'
	description: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"tokenHash": self.token_hash,
			"creationTime": self.creation_time,
			"validity": self.validity,
			"operation": self.operation.__serialize__(),
			"description": self.description,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'OperationToken':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			token_hash = deserialized_dict["tokenHash"],
			creation_time = deserialized_dict["creationTime"],
			validity = deserialized_dict["validity"],
			operation = Operation._deserialize(deserialized_dict["operation"]),
			description = deserialized_dict.get("description"),
		)

__all__ = ['OperationToken']