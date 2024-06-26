import json
from typing import Optional, Union, Dict
from model.base.CodeStub import CodeStub
from dataclasses import dataclass

@dataclass
class AdministrationQuantity:
	quantity: Optional[float] = None
	administration_unit: Optional['CodeStub'] = None
	unit: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"quantity": self.quantity,
			"administrationUnit": self.administration_unit.__serialize__() if self.administration_unit is not None else None,
			"unit": self.unit,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AdministrationQuantity':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			quantity = deserialized_dict.get("quantity"),
			administration_unit = CodeStub._deserialize(deserialized_dict.get("administrationUnit")) if deserialized_dict.get("administrationUnit") is not None else None,
			unit = deserialized_dict.get("unit"),
		)

__all__ = ['AdministrationQuantity']