import json
from typing import List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class ListOfIds:
	ids: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"ids": [x0 for x0 in self.ids],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ListOfIds':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			ids = [x0 for x0 in deserialized_dict["ids"]],
		)

__all__ = ['ListOfIds']