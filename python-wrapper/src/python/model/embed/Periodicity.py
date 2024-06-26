import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class Periodicity:
	related_code: Optional['CodeStub'] = None
	related_periodicity: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"relatedCode": self.related_code.__serialize__() if self.related_code is not None else None,
			"relatedPeriodicity": self.related_periodicity.__serialize__() if self.related_periodicity is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Periodicity':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			related_code = CodeStub._deserialize(deserialized_dict.get("relatedCode")) if deserialized_dict.get("relatedCode") is not None else None,
			related_periodicity = CodeStub._deserialize(deserialized_dict.get("relatedPeriodicity")) if deserialized_dict.get("relatedPeriodicity") is not None else None,
		)

__all__ = ['Periodicity']