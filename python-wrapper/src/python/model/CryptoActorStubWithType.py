import json
from model.DataOwnerType import DataOwnerType
from model.CryptoActorStub import CryptoActorStub
from typing import Union, Dict
from dataclasses import dataclass

@dataclass
class CryptoActorStubWithType:
	type: 'DataOwnerType'
	stub: 'CryptoActorStub'

	def __serialize__(self) -> object:
		return {
			"type": self.type.__serialize__(),
			"stub": self.stub.__serialize__(),
		}

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'CryptoActorStubWithType':
		deserialized_dict: dict[str, object]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return cls(
			type = DataOwnerType._deserialize(deserialized_dict["type"]),
			stub = CryptoActorStub._deserialize(deserialized_dict["stub"]),
		)

__all__ = ['CryptoActorStubWithType']