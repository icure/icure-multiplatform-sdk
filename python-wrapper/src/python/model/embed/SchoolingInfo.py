import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class SchoolingInfo:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	school: Optional[str] = None
	type_of_education: Optional['CodeStub'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"school": self.school,
			"typeOfEducation": self.type_of_education.__serialize__() if self.type_of_education is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SchoolingInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			school = deserialized_dict.get("school"),
			type_of_education = CodeStub._deserialize(deserialized_dict.get("typeOfEducation")) if deserialized_dict.get("typeOfEducation") is not None else None,
		)

__all__ = ['SchoolingInfo']