import json
from typing import List, Union, Dict
from dataclasses import dataclass

@dataclass
class ShamirUpdateRequest:
	notaries_ids: List[str]
	min_shares: int

	def __serialize__(self) -> object:
		return {
			"notariesIds": [x0 for x0 in self.notaries_ids],
			"minShares": self.min_shares,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'ShamirUpdateRequest':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			notaries_ids = [x0 for x0 in deserialized_dict["notariesIds"]],
			min_shares = deserialized_dict["minShares"],
		)

__all__ = ['ShamirUpdateRequest']