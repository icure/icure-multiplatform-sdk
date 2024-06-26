from typing import Union, Dict
from enum import Enum

class TelecomType(Enum):
	Mobile = "mobile"
	Phone = "phone"
	Email = "email"
	Fax = "fax"
	Skype = "skype"
	Im = "im"
	Medibridge = "medibridge"
	Ehealthbox = "ehealthbox"
	Apicrypt = "apicrypt"
	Web = "web"
	Print = "print"
	Disk = "disk"
	Other = "other"
	Pager = "pager"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TelecomType':
		if data == "mobile":
			return TelecomType.Mobile
		elif data == "phone":
			return TelecomType.Phone
		elif data == "email":
			return TelecomType.Email
		elif data == "fax":
			return TelecomType.Fax
		elif data == "skype":
			return TelecomType.Skype
		elif data == "im":
			return TelecomType.Im
		elif data == "medibridge":
			return TelecomType.Medibridge
		elif data == "ehealthbox":
			return TelecomType.Ehealthbox
		elif data == "apicrypt":
			return TelecomType.Apicrypt
		elif data == "web":
			return TelecomType.Web
		elif data == "print":
			return TelecomType.Print
		elif data == "disk":
			return TelecomType.Disk
		elif data == "other":
			return TelecomType.Other
		elif data == "pager":
			return TelecomType.Pager
		else:
			raise Exception(f"{data} is not a valid value for TelecomType enum.")

__all__ = ['TelecomType']