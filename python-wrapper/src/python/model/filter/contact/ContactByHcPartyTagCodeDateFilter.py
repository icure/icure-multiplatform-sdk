import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ContactByHcPartyTagCodeDateFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	start_of_contact_opening_date: Optional[int] = None
	end_of_contact_opening_date: Optional[int] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"startOfContactOpeningDate": self.start_of_contact_opening_date,
			"endOfContactOpeningDate": self.end_of_contact_opening_date,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContactByHcPartyTagCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			tag_type = deserialized_dict.get("tagType"),
			tag_code = deserialized_dict.get("tagCode"),
			code_type = deserialized_dict.get("codeType"),
			code_code = deserialized_dict.get("codeCode"),
			start_of_contact_opening_date = deserialized_dict.get("startOfContactOpeningDate"),
			end_of_contact_opening_date = deserialized_dict.get("endOfContactOpeningDate"),
		)

__all__ = ['ContactByHcPartyTagCodeDateFilter']