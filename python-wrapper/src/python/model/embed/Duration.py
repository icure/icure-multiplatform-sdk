import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class Duration:
	value: Optional[float] = None
	unit: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"unit": self.unit.__serialize__() if self.unit is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Duration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value = deserialized_dict.get("value"),
			unit = CodeStub._deserialize(deserialized_dict.get("unit")) if deserialized_dict.get("unit") is not None else None,
		)

__all__ = ['Duration']