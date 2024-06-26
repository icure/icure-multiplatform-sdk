import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class CodeIdsByTypeCodeVersionIntervalFilter:
	desc: Optional[str] = None
	start_type: Optional[str] = None
	start_code: Optional[str] = None
	start_version: Optional[str] = None
	end_type: Optional[str] = None
	end_code: Optional[str] = None
	end_version: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"startType": self.start_type,
			"startCode": self.start_code,
			"startVersion": self.start_version,
			"endType": self.end_type,
			"endCode": self.end_code,
			"endVersion": self.end_version,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CodeIdsByTypeCodeVersionIntervalFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			start_type = deserialized_dict.get("startType"),
			start_code = deserialized_dict.get("startCode"),
			start_version = deserialized_dict.get("startVersion"),
			end_type = deserialized_dict.get("endType"),
			end_code = deserialized_dict.get("endCode"),
			end_version = deserialized_dict.get("endVersion"),
		)

__all__ = ['CodeIdsByTypeCodeVersionIntervalFilter']