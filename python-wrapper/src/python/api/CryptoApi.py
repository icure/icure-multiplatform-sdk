# auto-generated file
import asyncio
import base64
import json
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from Dict import typing
from KeypairFingerprintV1String import cardinal_sdk.model.specializations


class CryptoApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def force_reload_async(self) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def force_reload_blocking(self) -> None:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def current_data_owner_keys_async(self, filter_trusted_keys: bool = True) -> typing[str, typing[cardinal_sdk.model.specializations, bytearray]]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], bytearray(base64.b64decode(kv2[1]))), kv1[1].items()))), json.loads(success.decode('utf-8')).items()))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filterTrustedKeys": filter_trusted_keys,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def current_data_owner_keys_blocking(self, filter_trusted_keys: bool = True) -> typing[str, typing[cardinal_sdk.model.specializations, bytearray]]:
		payload = {
			"filterTrustedKeys": filter_trusted_keys,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], bytearray(base64.b64decode(kv2[1]))), kv1[1].items()))), result_info.success.items()))
			return return_value
