from typing import Union, Dict
from enum import Enum

class TaskStatus(Enum):
	Pending = "pending"
	Ongoing = "ongoing"
	Cancelled = "cancelled"
	Completed = "completed"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TaskStatus':
		if data == "pending":
			return TaskStatus.Pending
		elif data == "ongoing":
			return TaskStatus.Ongoing
		elif data == "cancelled":
			return TaskStatus.Cancelled
		elif data == "completed":
			return TaskStatus.Completed
		else:
			raise Exception(f"{data} is not a valid value for TaskStatus enum.")

__all__ = ['TaskStatus']