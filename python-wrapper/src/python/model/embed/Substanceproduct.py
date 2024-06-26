import json
from typing import List, Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import field, dataclass

@dataclass
class Substanceproduct:
	intendedcds: List['CodeStub'] = field(default_factory=list)
	deliveredcds: List['CodeStub'] = field(default_factory=list)
	intendedname: Optional[str] = None
	deliveredname: Optional[str] = None
	product_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"intendedcds": [x0.__serialize__() for x0 in self.intendedcds],
			"deliveredcds": [x0.__serialize__() for x0 in self.deliveredcds],
			"intendedname": self.intendedname,
			"deliveredname": self.deliveredname,
			"productId": self.product_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Substanceproduct':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			intendedcds = [CodeStub._deserialize(x0) for x0 in deserialized_dict["intendedcds"]],
			deliveredcds = [CodeStub._deserialize(x0) for x0 in deserialized_dict["deliveredcds"]],
			intendedname = deserialized_dict.get("intendedname"),
			deliveredname = deserialized_dict.get("deliveredname"),
			product_id = deserialized_dict.get("productId"),
		)

__all__ = ['Substanceproduct']