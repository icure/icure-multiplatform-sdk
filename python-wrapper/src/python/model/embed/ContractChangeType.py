from typing import Union, Dict
from enum import Enum

class ContractChangeType(Enum):
	InscriptionStart = "inscriptionStart"
	InscriptionEnd = "inscriptionEnd"
	Suspension = "suspension"
	CoverageChange = "coverageChange"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ContractChangeType':
		if data == "inscriptionStart":
			return ContractChangeType.InscriptionStart
		elif data == "inscriptionEnd":
			return ContractChangeType.InscriptionEnd
		elif data == "suspension":
			return ContractChangeType.Suspension
		elif data == "coverageChange":
			return ContractChangeType.CoverageChange
		else:
			raise Exception(f"{data} is not a valid value for ContractChangeType enum.")

__all__ = ['ContractChangeType']