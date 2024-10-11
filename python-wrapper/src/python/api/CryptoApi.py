# auto-generated file
import asyncio
import base64
import json
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Dict
from cardinal_sdk.model.specializations import KeypairFingerprintV1String

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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def force_reload_blocking(self) -> None:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.forceReloadBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def current_data_owner_keys_async(self, filter_trusted_keys: bool = True) -> Dict[str, Dict[KeypairFingerprintV1String, bytearray]]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def current_data_owner_keys_blocking(self, filter_trusted_keys: bool = True) -> Dict[str, Dict[KeypairFingerprintV1String, bytearray]]:
		payload = {
			"filterTrustedKeys": filter_trusted_keys,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CryptoApi.currentDataOwnerKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], dict(map(lambda kv2: (kv2[0], bytearray(base64.b64decode(kv2[1]))), kv1[1].items()))), result_info.success.items()))
			return return_value
