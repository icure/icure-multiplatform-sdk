from typing import Union, Dict
from enum import Enum

class TopicRole(Enum):
	Participant = "PARTICIPANT"
	Admin = "ADMIN"
	Owner = "OWNER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'TopicRole':
		if data == "PARTICIPANT":
			return TopicRole.Participant
		elif data == "ADMIN":
			return TopicRole.Admin
		elif data == "OWNER":
			return TopicRole.Owner
		else:
			raise Exception(f"{data} is not a valid value for TopicRole enum.")

__all__ = ['TopicRole']