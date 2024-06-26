from typing import Union, Dict
from enum import Enum

class UsersType(Enum):
	Database = "database"
	Ldap = "ldap"
	Token = "token"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'UsersType':
		if data == "database":
			return UsersType.Database
		elif data == "ldap":
			return UsersType.Ldap
		elif data == "token":
			return UsersType.Token
		else:
			raise Exception(f"{data} is not a valid value for UsersType enum.")

__all__ = ['UsersType']