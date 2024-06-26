import json
from model.filter.AbstractFilter import AbstractFilter, serialize_abstract_filter, deserialize_abstract_filter
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ComplementFilter:
	super_set: 'AbstractFilter'
	sub_set: 'AbstractFilter'
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"superSet": serialize_abstract_filter(self.super_set),
			"subSet": serialize_abstract_filter(self.sub_set),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ComplementFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			super_set = deserialize_abstract_filter(deserialized_dict["superSet"]),
			sub_set = deserialize_abstract_filter(deserialized_dict["subSet"]),
		)

__all__ = ['ComplementFilter']