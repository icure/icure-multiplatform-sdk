import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class CodeByRegionTypeLabelLanguageFilter:
	type: str
	language: str
	desc: Optional[str] = None
	region: Optional[str] = None
	label: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"region": self.region,
			"type": self.type,
			"language": self.language,
			"label": self.label,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeByRegionTypeLabelLanguageFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			region = deserialized_dict.get("region"),
			type = deserialized_dict["type"],
			language = deserialized_dict["language"],
			label = deserialized_dict.get("label"),
		)

__all__ = ['CodeByRegionTypeLabelLanguageFilter']