import json
from typing import List, Union, Dict
from model.PropertyStub import DecryptedPropertyStub
from dataclasses import field, dataclass

@dataclass
class ListOfProperties:
	properties: List['DecryptedPropertyStub'] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"properties": [x0.__serialize__() for x0 in self.properties],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ListOfProperties':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			properties = [DecryptedPropertyStub._deserialize(x0) for x0 in deserialized_dict["properties"]],
		)

__all__ = ['ListOfProperties']