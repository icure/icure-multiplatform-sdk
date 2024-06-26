import json
from typing import Optional, List, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass
from model.embed.Annotation import Annotation
from model.embed.Range import Range

@dataclass
class ReferenceRange:
	low: Optional[float] = None
	high: Optional[float] = None
	string_value: Optional[str] = None
	tags: List['CodeStub'] = field(default_factory=list)
	codes: List['CodeStub'] = field(default_factory=list)
	notes: List['Annotation'] = field(default_factory=list)
	age: Optional['Range'] = None

	def __serialize__(self) -> object:
		return {
			"low": self.low,
			"high": self.high,
			"stringValue": self.string_value,
			"tags": [x0.__serialize__() for x0 in self.tags],
			"codes": [x0.__serialize__() for x0 in self.codes],
			"notes": [x0.__serialize__() for x0 in self.notes],
			"age": self.age.__serialize__() if self.age is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReferenceRange':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			low = deserialized_dict.get("low"),
			high = deserialized_dict.get("high"),
			string_value = deserialized_dict.get("stringValue"),
			tags = [CodeStub._deserialize(x0) for x0 in deserialized_dict["tags"]],
			codes = [CodeStub._deserialize(x0) for x0 in deserialized_dict["codes"]],
			notes = [Annotation._deserialize(x0) for x0 in deserialized_dict["notes"]],
			age = Range._deserialize(deserialized_dict.get("age")) if deserialized_dict.get("age") is not None else None,
		)

__all__ = ['ReferenceRange']