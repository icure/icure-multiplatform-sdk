from typing import Union, Dict
from enum import Enum

class AddressType(Enum):
	Home = "home"
	Work = "work"
	Vacation = "vacation"
	Hospital = "hospital"
	Clinic = "clinic"
	Hq = "hq"
	Other = "other"
	Temporary = "temporary"
	Postal = "postal"
	Diplomatic = "diplomatic"
	Reference = "reference"
	Careaddress = "careaddress"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AddressType':
		if data == "home":
			return AddressType.Home
		elif data == "work":
			return AddressType.Work
		elif data == "vacation":
			return AddressType.Vacation
		elif data == "hospital":
			return AddressType.Hospital
		elif data == "clinic":
			return AddressType.Clinic
		elif data == "hq":
			return AddressType.Hq
		elif data == "other":
			return AddressType.Other
		elif data == "temporary":
			return AddressType.Temporary
		elif data == "postal":
			return AddressType.Postal
		elif data == "diplomatic":
			return AddressType.Diplomatic
		elif data == "reference":
			return AddressType.Reference
		elif data == "careaddress":
			return AddressType.Careaddress
		else:
			raise Exception(f"{data} is not a valid value for AddressType enum.")

__all__ = ['AddressType']