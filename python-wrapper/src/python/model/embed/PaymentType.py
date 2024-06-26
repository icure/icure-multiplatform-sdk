from typing import Union, Dict
from enum import Enum

class PaymentType(Enum):
	Cash = "cash"
	Wired = "wired"
	Insurance = "insurance"
	Creditcard = "creditcard"
	Debitcard = "debitcard"
	Paypal = "paypal"
	Bitcoin = "bitcoin"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PaymentType':
		if data == "cash":
			return PaymentType.Cash
		elif data == "wired":
			return PaymentType.Wired
		elif data == "insurance":
			return PaymentType.Insurance
		elif data == "creditcard":
			return PaymentType.Creditcard
		elif data == "debitcard":
			return PaymentType.Debitcard
		elif data == "paypal":
			return PaymentType.Paypal
		elif data == "bitcoin":
			return PaymentType.Bitcoin
		elif data == "other":
			return PaymentType.Other
		else:
			raise Exception(f"{data} is not a valid value for PaymentType enum.")

__all__ = ['PaymentType']