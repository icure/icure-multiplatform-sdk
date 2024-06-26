import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class ServiceLink:
	service_id: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"serviceId": self.service_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ServiceLink':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			service_id = deserialized_dict.get("serviceId"),
		)

__all__ = ['ServiceLink']