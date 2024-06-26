from typing import Union, Dict
from enum import Enum

class FrontEndMigrationStatus(Enum):
	Started = "STARTED"
	Paused = "PAUSED"
	Error = "ERROR"
	Success = "SUCCESS"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'FrontEndMigrationStatus':
		if data == "STARTED":
			return FrontEndMigrationStatus.Started
		elif data == "PAUSED":
			return FrontEndMigrationStatus.Paused
		elif data == "ERROR":
			return FrontEndMigrationStatus.Error
		elif data == "SUCCESS":
			return FrontEndMigrationStatus.Success
		else:
			raise Exception(f"{data} is not a valid value for FrontEndMigrationStatus enum.")

__all__ = ['FrontEndMigrationStatus']