import json
from typing import Optional, List, Union, Dict
from model.specializations.HexString import HexString
from dataclasses import field, dataclass

@dataclass
class Delegation:
	owner: Optional[str] = None
	delegated_to: Optional[str] = None
	key: Optional['HexString'] = None
	tags: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"owner": self.owner,
			"delegatedTo": self.delegated_to,
			"key": self.key,
			"tags": [x0 for x0 in self.tags],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Delegation':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			owner = deserialized_dict.get("owner"),
			delegated_to = deserialized_dict.get("delegatedTo"),
			key = deserialized_dict.get("key"),
			tags = [x0 for x0 in deserialized_dict["tags"]],
		)

__all__ = ['Delegation']