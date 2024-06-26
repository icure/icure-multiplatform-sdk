from typing import Union, Dict
from enum import Enum

class Trigger(Enum):
	Init = "INIT"
	Change = "CHANGE"
	Click = "CLICK"
	Visible = "VISIBLE"
	Error = "ERROR"
	Valid = "VALID"
	Event = "EVENT"

	def __serialize__(self) -> object:
		return self.value

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Trigger':
		if data == "INIT":
			return Trigger.Init
		elif data == "CHANGE":
			return Trigger.Change
		elif data == "CLICK":
			return Trigger.Click
		elif data == "VISIBLE":
			return Trigger.Visible
		elif data == "ERROR":
			return Trigger.Error
		elif data == "VALID":
			return Trigger.Valid
		elif data == "EVENT":
			return Trigger.Event
		else:
			raise Exception(f"{data} is not a valid value for Trigger enum.")

__all__ = ['Trigger']