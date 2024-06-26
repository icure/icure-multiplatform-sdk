import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class HealthElementByHcPartyTagCodeFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	status: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"status": self.status,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'HealthElementByHcPartyTagCodeFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			code_type = deserialized_dict.get("codeType"),
			code_code = deserialized_dict.get("codeCode"),
			tag_type = deserialized_dict.get("tagType"),
			tag_code = deserialized_dict.get("tagCode"),
			status = deserialized_dict.get("status"),
		)

__all__ = ['HealthElementByHcPartyTagCodeFilter']