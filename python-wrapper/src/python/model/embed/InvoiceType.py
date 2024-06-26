from typing import Union, Dict
from enum import Enum

class InvoiceType(Enum):
	Patient = "patient"
	Mutualfund = "mutualfund"
	Payingagency = "payingagency"
	Insurance = "insurance"
	Efact = "efact"
	Other = "other"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceType':
		if data == "patient":
			return InvoiceType.Patient
		elif data == "mutualfund":
			return InvoiceType.Mutualfund
		elif data == "payingagency":
			return InvoiceType.Payingagency
		elif data == "insurance":
			return InvoiceType.Insurance
		elif data == "efact":
			return InvoiceType.Efact
		elif data == "other":
			return InvoiceType.Other
		else:
			raise Exception(f"{data} is not a valid value for InvoiceType enum.")

__all__ = ['InvoiceType']