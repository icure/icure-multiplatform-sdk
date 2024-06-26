import json
from model.filter.predicate.Predicate import Predicate, serialize_predicate, deserialize_predicate
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class NotPredicate:
	predicate: 'Predicate'

	def __serialize__(self) -> object:
		return {
			"predicate": serialize_predicate(self.predicate),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'NotPredicate':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			predicate = deserialize_predicate(deserialized_dict["predicate"]),
		)

__all__ = ['NotPredicate']