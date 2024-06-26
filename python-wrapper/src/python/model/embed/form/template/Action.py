import json
from typing import Optional, List, Union, Dict
from model.embed.form.template.Launcher import Launcher
from dataclasses import field, dataclass
from model.embed.form.template.State import State

@dataclass
class Action:
	launchers: Optional[List['Launcher']] = field(default_factory=list)
	expression: Optional[str] = None
	states: Optional[List['State']] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"launchers": [x0.__serialize__() for x0 in self.launchers] if self.launchers is not None else None,
			"expression": self.expression,
			"states": [x0.__serialize__() for x0 in self.states] if self.states is not None else None,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Action':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			launchers = [Launcher._deserialize(x0) for x0 in deserialized_dict.get("launchers")] if deserialized_dict.get("launchers") is not None else None,
			expression = deserialized_dict.get("expression"),
			states = [State._deserialize(x0) for x0 in deserialized_dict.get("states")] if deserialized_dict.get("states") is not None else None,
		)

__all__ = ['Action']