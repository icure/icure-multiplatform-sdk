# auto-generated file
import asyncio
import json
from deserialize_cardinal_sdk.model import DataOwnerWithType
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from symbols import cardinal_sdk.kotlin_types
from DataOwnerWithType import cardinal_sdk.model
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from CryptoActorStubWithType import cardinal_sdk.model
from List import typing
from DataOwnerType import cardinal_sdk.model


class DataOwnerApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_current_data_owner_async(self) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DataOwnerWithType(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_blocking(self) -> cardinal_sdk.model:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = DataOwnerWithType(result_info.success)
			return return_value

	async def get_current_data_owner_stub_async(self) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_stub_blocking(self) -> cardinal_sdk.model:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_id_async(self) -> str:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_id_blocking(self) -> str:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_current_data_owner_hierarchy_ids_async(self) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_blocking(self) -> typing[str]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_data_owner_async(self, owner_id: str) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DataOwnerWithType(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ownerId": owner_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getDataOwnerAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_data_owner_blocking(self, owner_id: str) -> cardinal_sdk.model:
		payload = {
			"ownerId": owner_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getDataOwnerBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = DataOwnerWithType(result_info.success)
			return return_value

	async def get_crypto_actor_stub_async(self, owner_id: str) -> cardinal_sdk.model:
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
			"ownerId": owner_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCryptoActorStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_crypto_actor_stub_blocking(self, owner_id: str) -> cardinal_sdk.model:
		payload = {
			"ownerId": owner_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCryptoActorStubBlocking(
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

	async def get_current_data_owner_hierarchy_ids_from_async(self, parent_id: str) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"parentId": parent_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_from_blocking(self, parent_id: str) -> typing[str]:
		payload = {
			"parentId": parent_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_current_data_owner_hierarchy_async(self) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DataOwnerWithType(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_blocking(self) -> typing[cardinal_sdk.model]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [DataOwnerWithType(x1) for x1 in result_info.success]
			return return_value

	async def modify_data_owner_stub_async(self, crypto_actor_stub_with_type_dto: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.modifyDataOwnerStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_data_owner_stub_blocking(self, crypto_actor_stub_with_type_dto: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.modifyDataOwnerStubBlocking(
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

	async def get_current_data_owner_type_async(self) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_type_blocking(self) -> cardinal_sdk.model:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeBlocking(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	def clear_current_data_owner_ids_cache(self) -> None:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.clearCurrentDataOwnerIdsCache(
			self.cardinal_sdk._native,
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
