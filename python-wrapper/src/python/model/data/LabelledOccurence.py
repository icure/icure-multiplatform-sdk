import json
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class LabelledOccurence:
	label: str
	occurence: int

	def __serialize__(self) -> object:
		return {
			"label": self.label,
			"occurence": self.occurence,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'LabelledOccurence':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			label = deserialized_dict["label"],
			occurence = deserialized_dict["occurence"],
		)

__all__ = ['LabelledOccurence']