import json
import asyncio
from model import CryptoActor, serialize_crypto_actor, CryptoActorStubWithType
from kotlin_types import symbols, DATA_RESULT_CALLBACK_FUNC
from model.CallResult import create_result_from_json, CallResult
from ctypes import cast, c_char_p
from typing import Dict, List
from model.specializations import KeypairFingerprintV1String
from crypto import ShamirUpdateRequest

class ShamirKeysManagerApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	def get_existing_splits_info(self, data_owner: CryptoActor) -> Dict[KeypairFingerprintV1String, List[str]]:
		payload = {
			"data_owner": serialize_crypto_actor(data_owner),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ShamirKeysManagerApi.getExistingSplitsInfo(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = dict(map(lambda kv1: (kv1[0], [x2 for x2 in kv1[1]]), result_info["success"].items()))
			return return_value

	async def update_self_splits_async(self, key_splits_to_update: Dict[KeypairFingerprintV1String, ShamirUpdateRequest], key_splits_to_delete: List[KeypairFingerprintV1String]) -> CryptoActorStubWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = CryptoActorStubWithType._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"key_splits_to_update": {k0.__serialize__(): v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"key_splits_to_delete": [x0.__serialize__() for x0 in key_splits_to_delete],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def update_self_splits_blocking(self, key_splits_to_update: Dict[KeypairFingerprintV1String, ShamirUpdateRequest], key_splits_to_delete: List[KeypairFingerprintV1String]) -> CryptoActorStubWithType:
		payload = {
			"key_splits_to_update": {k0.__serialize__(): v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"key_splits_to_delete": [x0.__serialize__() for x0 in key_splits_to_delete],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info["success"])
			return return_value
