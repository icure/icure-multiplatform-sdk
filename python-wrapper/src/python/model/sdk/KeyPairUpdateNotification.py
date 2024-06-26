import json
from model.specializations.SpkiHexString import SpkiHexString
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class KeyPairUpdateNotification:
	new_public_key: 'SpkiHexString'
	concerned_data_owner_id: str

	def __serialize__(self) -> object:
		return {
			"newPublicKey": self.new_public_key,
			"concernedDataOwnerId": self.concerned_data_owner_id,
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'KeyPairUpdateNotification':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			new_public_key = deserialized_dict["newPublicKey"],
			concerned_data_owner_id = deserialized_dict["concernedDataOwnerId"],
		)

__all__ = ['KeyPairUpdateNotification']