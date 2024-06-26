from typing import Union, Dict
from enum import Enum

class SubscriptionEventType(Enum):
	Create = "CREATE"
	Update = "UPDATE"
	Delete = "DELETE"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'SubscriptionEventType':
		if data == "CREATE":
			return SubscriptionEventType.Create
		elif data == "UPDATE":
			return SubscriptionEventType.Update
		elif data == "DELETE":
			return SubscriptionEventType.Delete
		else:
			raise Exception(f"{data} is not a valid value for SubscriptionEventType enum.")

__all__ = ['SubscriptionEventType']