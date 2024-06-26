from typing import Union, Dict
from enum import Enum

class RequestedPermission(Enum):
	MaxRead = "MAX_READ"
	FullRead = "FULL_READ"
	MaxWrite = "MAX_WRITE"
	FullWrite = "FULL_WRITE"
	Root = "ROOT"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RequestedPermission':
		if data == "MAX_READ":
			return RequestedPermission.MaxRead
		elif data == "FULL_READ":
			return RequestedPermission.FullRead
		elif data == "MAX_WRITE":
			return RequestedPermission.MaxWrite
		elif data == "FULL_WRITE":
			return RequestedPermission.FullWrite
		elif data == "ROOT":
			return RequestedPermission.Root
		else:
			raise Exception(f"{data} is not a valid value for RequestedPermission enum.")

__all__ = ['RequestedPermission']