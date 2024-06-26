import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from model.embed.Employer import Employer
from dataclasses import dataclass

@dataclass
class EmploymentInfo:
	start_date: Optional[int] = None
	end_date: Optional[int] = None
	profession_type: Optional['CodeStub'] = None
	employer: Optional['Employer'] = None

	def __serialize__(self) -> object:
		return {
			"startDate": self.start_date,
			"endDate": self.end_date,
			"professionType": self.profession_type.__serialize__() if self.profession_type is not None else None,
			"employer": self.employer.__serialize__() if self.employer is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'EmploymentInfo':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			start_date = deserialized_dict.get("startDate"),
			end_date = deserialized_dict.get("endDate"),
			profession_type = CodeStub._deserialize(deserialized_dict.get("professionType")) if deserialized_dict.get("professionType") is not None else None,
			employer = Employer._deserialize(deserialized_dict.get("employer")) if deserialized_dict.get("employer") is not None else None,
		)

__all__ = ['EmploymentInfo']