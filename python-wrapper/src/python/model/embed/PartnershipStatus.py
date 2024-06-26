from typing import Union, Dict
from enum import Enum

class PartnershipStatus(Enum):
	Active = "active"
	Complicated = "complicated"
	Past = "past"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PartnershipStatus':
		if data == "active":
			return PartnershipStatus.Active
		elif data == "complicated":
			return PartnershipStatus.Complicated
		elif data == "past":
			return PartnershipStatus.Past
		else:
			raise Exception(f"{data} is not a valid value for PartnershipStatus enum.")

__all__ = ['PartnershipStatus']