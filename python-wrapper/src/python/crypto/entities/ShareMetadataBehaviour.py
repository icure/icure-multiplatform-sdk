from typing import Union, Dict
from enum import Enum

class ShareMetadataBehaviour(Enum):
	Required = "REQUIRED"
	IfAvailable = "IF_AVAILABLE"
	Never = "NEVER"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShareMetadataBehaviour':
		if data == "REQUIRED":
			return ShareMetadataBehaviour.Required
		elif data == "IF_AVAILABLE":
			return ShareMetadataBehaviour.IfAvailable
		elif data == "NEVER":
			return ShareMetadataBehaviour.Never
		else:
			raise Exception(f"{data} is not a valid value for ShareMetadataBehaviour enum.")

__all__ = ['ShareMetadataBehaviour']