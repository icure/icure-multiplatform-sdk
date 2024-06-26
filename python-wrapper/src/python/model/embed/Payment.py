import json
from typing import Optional, Union, Dict
from model.embed.PaymentType import PaymentType
from dataclasses import dataclass

@dataclass
class Payment:
	payment_date: int = 0
	payment_type: Optional['PaymentType'] = None
	paid: Optional[float] = None

	def __serialize__(self) -> object:
		return {
			"paymentDate": self.payment_date,
			"paymentType": self.payment_type.__serialize__() if self.payment_type is not None else None,
			"paid": self.paid,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Payment':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			payment_date = deserialized_dict["paymentDate"],
			payment_type = PaymentType._deserialize(deserialized_dict.get("paymentType")) if deserialized_dict.get("paymentType") is not None else None,
			paid = deserialized_dict.get("paid"),
		)

__all__ = ['Payment']