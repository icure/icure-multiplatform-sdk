import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class MessageByHcPartyFilter:
	hcp_id: str
	desc: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcpId": self.hcp_id,
			"desc": self.desc,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'MessageByHcPartyFilter':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hcp_id = deserialized_dict["hcpId"],
			desc = deserialized_dict.get("desc"),
		)

__all__ = ['MessageByHcPartyFilter']