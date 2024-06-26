from typing import Union, Dict
from enum import Enum

class InvoiceInterventionType(Enum):
	Total = "total"
	Userfees = "userfees"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'InvoiceInterventionType':
		if data == "total":
			return InvoiceInterventionType.Total
		elif data == "userfees":
			return InvoiceInterventionType.Userfees
		else:
			raise Exception(f"{data} is not a valid value for InvoiceInterventionType enum.")

__all__ = ['InvoiceInterventionType']