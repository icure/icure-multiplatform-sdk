import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class HealthcarePartyByTagCodeFilter:
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthcarePartyByTagCodeFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			tag_type = deserialized_dict.get("tagType"),
			tag_code = deserialized_dict.get("tagCode"),
			code_type = deserialized_dict.get("codeType"),
			code_code = deserialized_dict.get("codeCode"),
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['HealthcarePartyByTagCodeFilter']