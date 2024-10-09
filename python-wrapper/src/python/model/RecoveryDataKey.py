from typing import Union, Dict
import json
import base64

class RecoveryDataKey:
	__hex: str

	def __init__(self, internal):
		"""
		Don't use the init method, as it may change in the future. Use the factory methods instead.
		:param internal: May change in the future
		"""
		self.__hex = internal

	def as_base_32(self) -> str:
		return base64.b32encode(self.as_raw_bytes()).decode('utf-8')

	def as_hex(self) -> str:
		return self.__hex

	def as_raw_bytes(self) -> bytearray:
		return bytearray.fromhex(self.__hex)

	@classmethod
	def from_raw_bytes(cls, raw_bytes: bytearray) -> 'RecoveryDataKey':
		return RecoveryDataKey(internal=raw_bytes.hex())

	@classmethod
	def from_hex(cls, hex_str: str) -> 'RecoveryDataKey':
		return RecoveryDataKey(internal=hex_str)

	@classmethod
	def from_base_32(cls, base32: str) -> 'RecoveryDataKey':
		return RecoveryDataKey(internal=base64.b32decode(base32).hex())

	def __serialize__(self) -> object:
		return { "_hex": self.__hex }

	@classmethod
	def _deserialize(cls, data: Union[str, Dict[str, object]]) -> 'RecoveryDataKey':
		deserialized_dict: dict[str, any]
		if isinstance(data, str):
			deserialized_dict = json.loads(data)
		else:
			deserialized_dict = data
		return RecoveryDataKey(internal=deserialized_dict["_hex"])
