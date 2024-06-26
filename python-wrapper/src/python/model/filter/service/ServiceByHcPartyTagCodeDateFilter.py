import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ServiceByHcPartyTagCodeDateFilter:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	patient_secret_foreign_key: Optional[str] = None
	tag_type: Optional[str] = None
	tag_code: Optional[str] = None
	code_type: Optional[str] = None
	code_code: Optional[str] = None
	start_value_date: Optional[int] = None
	end_value_date: Optional[int] = None
	descending: bool = False

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"patientSecretForeignKey": self.patient_secret_foreign_key,
			"tagType": self.tag_type,
			"tagCode": self.tag_code,
			"codeType": self.code_type,
			"codeCode": self.code_code,
			"startValueDate": self.start_value_date,
			"endValueDate": self.end_value_date,
			"descending": self.descending,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceByHcPartyTagCodeDateFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			patient_secret_foreign_key = deserialized_dict.get("patientSecretForeignKey"),
			tag_type = deserialized_dict.get("tagType"),
			tag_code = deserialized_dict.get("tagCode"),
			code_type = deserialized_dict.get("codeType"),
			code_code = deserialized_dict.get("codeCode"),
			start_value_date = deserialized_dict.get("startValueDate"),
			end_value_date = deserialized_dict.get("endValueDate"),
			descending = deserialized_dict["descending"],
		)

__all__ = ['ServiceByHcPartyTagCodeDateFilter']