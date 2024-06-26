import json
from typing import Optional, Union, Dict
from model.embed.Gender import Gender
from dataclasses import dataclass

@dataclass
class PatientByHcPartyGenderEducationProfession:
	desc: Optional[str] = None
	healthcare_party_id: Optional[str] = None
	gender: Optional['Gender'] = None
	education: Optional[str] = None
	profession: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"desc": self.desc,
			"healthcarePartyId": self.healthcare_party_id,
			"gender": self.gender.__serialize__() if self.gender is not None else None,
			"education": self.education,
			"profession": self.profession,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PatientByHcPartyGenderEducationProfession':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			desc = deserialized_dict.get("desc"),
			healthcare_party_id = deserialized_dict.get("healthcarePartyId"),
			gender = Gender._deserialize(deserialized_dict.get("gender")) if deserialized_dict.get("gender") is not None else None,
			education = deserialized_dict.get("education"),
			profession = deserialized_dict.get("profession"),
		)

__all__ = ['PatientByHcPartyGenderEducationProfession']