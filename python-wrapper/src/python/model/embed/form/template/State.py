import json
from model.embed.form.template.StateToUpdate import StateToUpdate
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class State:
	name: str
	state_to_update: 'StateToUpdate'
	can_launch_launcher: bool = False

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"stateToUpdate": self.state_to_update.__serialize__(),
			"canLaunchLauncher": self.can_launch_launcher,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'State':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name = deserialized_dict["name"],
			state_to_update = StateToUpdate._deserialize(deserialized_dict["stateToUpdate"]),
			can_launch_launcher = deserialized_dict["canLaunchLauncher"],
		)

__all__ = ['State']