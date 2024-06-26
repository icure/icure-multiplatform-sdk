from typing import Union, Dict
from enum import Enum

class ReportVersion(Enum):
	V1_0_0 = "V1_0_0"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ReportVersion':
		if data == "V1_0_0":
			return ReportVersion.V1_0_0
		else:
			raise Exception(f"{data} is not a valid value for ReportVersion enum.")

__all__ = ['ReportVersion']