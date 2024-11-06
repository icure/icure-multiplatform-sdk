# auto-generated file
import json
import asyncio
from CryptoActor import cardinal_sdk.model
from serialize_crypto_actor import cardinal_sdk.model
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from Dict import typing
from KeypairFingerprintV1String import cardinal_sdk.model.specializations
from List import typing
from ShamirUpdateRequest import cardinal_sdk.model
from CryptoActorStubWithType import cardinal_sdk.model
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types


class ShamirKeysManagerApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	def get_existing_splits_info(self, data_owner: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations, typing[str]]:
		payload = {
			"dataOwner": cardinal_sdk.model(data_owner),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.getExistingSplitsInfo(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], [x2 for x2 in kv1[1]]), result_info.success.items()))
			return return_value

	async def update_self_splits_async(self, key_splits_to_update: typing[cardinal_sdk.model.specializations, cardinal_sdk.model], key_splits_to_delete: typing[cardinal_sdk.model.specializations]) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"keySplitsToUpdate": {k0: v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"keySplitsToDelete": [x0 for x0 in key_splits_to_delete],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def update_self_splits_blocking(self, key_splits_to_update: typing[cardinal_sdk.model.specializations, cardinal_sdk.model], key_splits_to_delete: typing[cardinal_sdk.model.specializations]) -> cardinal_sdk.model:
		payload = {
			"keySplitsToUpdate": {k0: v0.__serialize__() for k0, v0 in key_splits_to_update.items()},
			"keySplitsToDelete": [x0 for x0 in key_splits_to_delete],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ShamirKeysManagerApi.updateSelfSplitsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value
