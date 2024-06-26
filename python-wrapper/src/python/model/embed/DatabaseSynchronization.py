import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class DatabaseSynchronization:
	source: Optional[str] = None
	target: Optional[str] = None
	filter: Optional[str] = None
	local_target: Optional['Target'] = None

	def __serialize__(self) -> object:
		return {
			"source": self.source,
			"target": self.target,
			"filter": self.filter,
			"localTarget": self.local_target.__serialize__() if self.local_target is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'DatabaseSynchronization':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source = deserialized_dict.get("source"),
			target = deserialized_dict.get("target"),
			filter = deserialized_dict.get("filter"),
			local_target = Target._deserialize(deserialized_dict.get("localTarget")) if deserialized_dict.get("localTarget") is not None else None,
		)

	class Target(Enum):
		Base = "base"
		Healthdata = "healthdata"
		Patient = "patient"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Target':
			if data == "base":
				return Target.Base
			elif data == "healthdata":
				return Target.Healthdata
			elif data == "patient":
				return Target.Patient
			else:
				raise Exception(f"{data} is not a valid value for Target enum.")

__all__ = ['DatabaseSynchronization']