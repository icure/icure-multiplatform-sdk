# auto-generated file
import json
from cardinal_sdk.model import CryptoActor, serialize_crypto_actor, ShamirUpdateRequest, CryptoActorStubWithType
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Dict, List
from cardinal_sdk.model.specializations import KeypairFingerprintV1String
from cardinal_sdk.async_utils import execute_async_method_job


class ShamirKeysManagerApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	def get_existing_splits_info(self, data_owner: CryptoActor) -> Dict[KeypairFingerprintV1String, List[str]]:
		payload = {
			"dataOwner": serialize_crypto_actor(data_owner),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.getExistingSplitsInfo(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], [x2 for x2 in kv1[1]]), result_info.success.items()))
			return return_value

	async def update_self_splits_async(self, key_splits_to_update: Dict[KeypairFingerprintV1String, ShamirUpdateRequest], key_splits_to_delete: List[KeypairFingerprintV1String]) -> CryptoActorStubWithType:
		def do_decode(raw_result):
			return CryptoActorStubWithType._deserialize(raw_result)
		payload = {
			"keySplitsToUpdate": {k0: v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"keySplitsToDelete": [x0 for x0 in key_splits_to_delete],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def update_self_splits_blocking(self, key_splits_to_update: Dict[KeypairFingerprintV1String, ShamirUpdateRequest], key_splits_to_delete: List[KeypairFingerprintV1String]) -> CryptoActorStubWithType:
		payload = {
			"keySplitsToUpdate": {k0: v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"keySplitsToDelete": [x0 for x0 in key_splits_to_delete],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value
