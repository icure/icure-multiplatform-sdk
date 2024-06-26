import json
from model.embed.Source import Source
from typing import List, Union, Dict
from dataclasses import field, dataclass

@dataclass
class RoleConfiguration:
	source: 'Source'
	roles: List[str] = field(default_factory=list)

	def __serialize__(self) -> object:
		return {
			"source": self.source.__serialize__(),
			"roles": [x0 for x0 in self.roles],
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RoleConfiguration':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			source = Source._deserialize(deserialized_dict["source"]),
			roles = [x0 for x0 in deserialized_dict["roles"]],
		)

	class Source(Enum):
		Configuration = "CONFIGURATION"
		Inherited = "INHERITED"
		Default = "DEFAULT"

		def __serialize__(self) -> object:
			return self.value

		@classmethod
		def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'Source':
			if data == "CONFIGURATION":
				return Source.Configuration
			elif data == "INHERITED":
				return Source.Inherited
			elif data == "DEFAULT":
				return Source.Default
			else:
				raise Exception(f"{data} is not a valid value for Source enum.")

__all__ = ['RoleConfiguration']