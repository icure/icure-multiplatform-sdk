import json
from typing import Optional, Union, Dict
from model.filter.predicate.Operator import Operator
from dataclasses import dataclass

@dataclass
class KeyValuePredicate:
	key: Optional[str] = None
	operator: Optional['Operator'] = None
	value: Optional[object] = None

	def __serialize__(self) -> object:
		return {
			"key": self.key,
			"operator": self.operator.__serialize__() if self.operator is not None else None,
			"value": self.value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyValuePredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			key = deserialized_dict.get("key"),
			operator = Operator._deserialize(deserialized_dict.get("operator")) if deserialized_dict.get("operator") is not None else None,
			value = deserialized_dict.get("value"),
		)

__all__ = ['KeyValuePredicate']