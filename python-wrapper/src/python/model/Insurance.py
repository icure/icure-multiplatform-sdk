import json
from model.embed.Address import DecryptedAddress
from typing import Optional, Dict, Union
from dataclasses import field, dataclass

@dataclass
class Insurance:
	id: str
	address: 'DecryptedAddress'
	rev: Optional[str] = None
	deletion_date: Optional[int] = None
	name: Dict[str, str] = field(default_factory=dict)
	private_insurance: bool = False
	hospitalisation_insurance: bool = False
	ambulatory_insurance: bool = False
	code: Optional[str] = None
	agreement_number: Optional[str] = None
	parent: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"id": self.id,
			"rev": self.rev,
			"deletionDate": self.deletion_date,
			"name": {k0: v0 for k0, v0 in self.name.items()},
			"privateInsurance": self.private_insurance,
			"hospitalisationInsurance": self.hospitalisation_insurance,
			"ambulatoryInsurance": self.ambulatory_insurance,
			"code": self.code,
			"agreementNumber": self.agreement_number,
			"parent": self.parent,
			"address": self.address.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Insurance':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			id = deserialized_dict["id"],
			rev = deserialized_dict.get("rev"),
			deletion_date = deserialized_dict.get("deletionDate"),
			name = dict(map(lambda kv0: (kv0[0], kv0[1]), deserialized_dict["name"].items())),
			private_insurance = deserialized_dict["privateInsurance"],
			hospitalisation_insurance = deserialized_dict["hospitalisationInsurance"],
			ambulatory_insurance = deserialized_dict["ambulatoryInsurance"],
			code = deserialized_dict.get("code"),
			agreement_number = deserialized_dict.get("agreementNumber"),
			parent = deserialized_dict.get("parent"),
			address = DecryptedAddress._deserialize(deserialized_dict["address"]),
		)

__all__ = ['Insurance']