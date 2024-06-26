import json
from model.embed.form.template.Trigger import Trigger
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class Launcher:
	name: str
	triggerer: 'Trigger'
	should_pass_value: bool = False

	def __serialize__(self) -> object:
		return {
			"name": self.name,
			"triggerer": self.triggerer.__serialize__(),
			"shouldPassValue": self.should_pass_value,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Launcher':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			name = deserialized_dict["name"],
			triggerer = Trigger._deserialize(deserialized_dict["triggerer"]),
			should_pass_value = deserialized_dict["shouldPassValue"],
		)

__all__ = ['Launcher']