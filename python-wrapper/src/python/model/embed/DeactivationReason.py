from typing import Union, Dict
from enum import Enum

class DeactivationReason(Enum):
	Deceased = "deceased"
	Moved = "moved"
	OtherDoctor = "other_doctor"
	Retired = "retired"
	NoContact = "no_contact"
	Unknown = "unknown"
	Nothing = "none"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DeactivationReason':
		if data == "deceased":
			return DeactivationReason.Deceased
		elif data == "moved":
			return DeactivationReason.Moved
		elif data == "other_doctor":
			return DeactivationReason.OtherDoctor
		elif data == "retired":
			return DeactivationReason.Retired
		elif data == "no_contact":
			return DeactivationReason.NoContact
		elif data == "unknown":
			return DeactivationReason.Unknown
		elif data == "none":
			return DeactivationReason.Nothing
		else:
			raise Exception(f"{data} is not a valid value for DeactivationReason enum.")

__all__ = ['DeactivationReason']