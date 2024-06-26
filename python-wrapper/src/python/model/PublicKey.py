import json
from typing import Optional, Union, Dict
from dataclasses import dataclass

@dataclass
class PublicKey:
	hc_party_id: Optional[str] = None
	hex_string: Optional[str] = None

	def __serialize__(self) -> object:
		return {
			"hcPartyId": self.hc_party_id,
			"hexString": self.hex_string,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'PublicKey':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			hc_party_id = deserialized_dict.get("hcPartyId"),
			hex_string = deserialized_dict.get("hexString"),
		)

__all__ = ['PublicKey']