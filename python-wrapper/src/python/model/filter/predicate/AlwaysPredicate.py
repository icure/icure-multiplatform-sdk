import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class AlwaysPredicate:

	def __serialize__(self) -> object:
		return {
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AlwaysPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
		)

__all__ = ['AlwaysPredicate']