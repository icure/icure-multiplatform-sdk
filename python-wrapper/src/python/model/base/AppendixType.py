from typing import Union, Dict
from enum import Enum

class AppendixType(Enum):
	ExternalLink = "externalLink"
	Video = "video"
	Description = "description"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'AppendixType':
		if data == "externalLink":
			return AppendixType.ExternalLink
		elif data == "video":
			return AppendixType.Video
		elif data == "description":
			return AppendixType.Description
		else:
			raise Exception(f"{data} is not a valid value for AppendixType enum.")

__all__ = ['AppendixType']