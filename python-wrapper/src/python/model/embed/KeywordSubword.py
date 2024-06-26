import json
from typing import Optional, List, Union, Dict
from dataclasses import dataclass

@dataclass
class KeywordSubword:
	value: Optional[str] = None
	sub_words: Optional[List['KeywordSubword']] = None

	def __serialize__(self) -> object:
		return {
			"value": self.value,
			"subWords": [x0.__serialize__() for x0 in self.sub_words] if self.sub_words is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeywordSubword':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			value = deserialized_dict.get("value"),
			sub_words = [KeywordSubword._deserialize(x0) for x0 in deserialized_dict.get("subWords")] if deserialized_dict.get("subWords") is not None else None,
		)

__all__ = ['KeywordSubword']