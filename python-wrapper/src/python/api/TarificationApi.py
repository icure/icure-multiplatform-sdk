# auto-generated file
import asyncio
import json
from cardinal_sdk.model import Tarification
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import List


class TarificationApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_tarification_async(self, tarification_id: str) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Tarification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarificationId": tarification_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_tarification_blocking(self, tarification_id: str) -> Tarification:
		payload = {
			"tarificationId": tarification_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Tarification._deserialize(result_info.success)
			return return_value

	async def create_tarification_async(self, tarification: Tarification) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Tarification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification": tarification.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.createTarificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_tarification_blocking(self, tarification: Tarification) -> Tarification:
		payload = {
			"tarification": tarification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.createTarificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Tarification._deserialize(result_info.success)
			return return_value

	async def get_tarifications_async(self, tarification_ids: List[str]) -> List[Tarification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [Tarification._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_tarifications_blocking(self, tarification_ids: List[str]) -> List[Tarification]:
		payload = {
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Tarification._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_tarification_async(self, tarification: Tarification) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Tarification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification": tarification.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.modifyTarificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_tarification_blocking(self, tarification: Tarification) -> Tarification:
		payload = {
			"tarification": tarification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.modifyTarificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Tarification._deserialize(result_info.success)
			return return_value

	async def get_tarification_with_parts_async(self, type: str, tarification: str, version: str) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Tarification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"tarification": tarification,
			"version": version,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationWithPartsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_tarification_with_parts_blocking(self, type: str, tarification: str, version: str) -> Tarification:
		payload = {
			"type": type,
			"tarification": tarification,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TarificationApi.getTarificationWithPartsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Tarification._deserialize(result_info.success)
			return return_value
