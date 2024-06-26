from typing import Union, Dict
from enum import Enum

class GroupType(Enum):
	Root = "root"
	App = "app"
	Database = "database"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'GroupType':
		if data == "root":
			return GroupType.Root
		elif data == "app":
			return GroupType.App
		elif data == "database":
			return GroupType.Database
		else:
			raise Exception(f"{data} is not a valid value for GroupType enum.")

__all__ = ['GroupType']