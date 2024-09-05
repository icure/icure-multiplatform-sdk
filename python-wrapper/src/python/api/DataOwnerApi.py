# auto-generated file
import asyncio
import json
from cardinal_sdk.model import deserialize_data_owner_with_type, DataOwnerWithType, CryptoActorStubWithType, DataOwnerType
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import List

class DataOwnerApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_current_data_owner_async(self) -> DataOwnerWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_data_owner_with_type(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_blocking(self) -> DataOwnerWithType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_data_owner_with_type(result_info.success)
			return return_value

	async def get_current_data_owner_stub_async(self) -> CryptoActorStubWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = CryptoActorStubWithType._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_stub_blocking(self) -> CryptoActorStubWithType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_id_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_current_data_owner_hierarchy_ids_async(self) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_blocking(self) -> List[str]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_data_owner_async(self, owner_id: str) -> DataOwnerWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_data_owner_with_type(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ownerId": owner_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getDataOwnerAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_data_owner_blocking(self, owner_id: str) -> DataOwnerWithType:
		payload = {
			"ownerId": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getDataOwnerBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_data_owner_with_type(result_info.success)
			return return_value

	async def get_crypto_actor_stub_async(self, owner_id: str) -> CryptoActorStubWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = CryptoActorStubWithType._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ownerId": owner_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCryptoActorStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_crypto_actor_stub_blocking(self, owner_id: str) -> CryptoActorStubWithType:
		payload = {
			"ownerId": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCryptoActorStubBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_hierarchy_ids_from_async(self, parent_id: str) -> List[str]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_from_blocking(self, parent_id: str) -> List[str]:
		payload = {
			"parentId": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_current_data_owner_hierarchy_async(self) -> List[DataOwnerWithType]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [deserialize_data_owner_with_type(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_blocking(self) -> List[DataOwnerWithType]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [deserialize_data_owner_with_type(x1) for x1 in result_info.success]
			return return_value

	async def modify_data_owner_stub_async(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = CryptoActorStubWithType._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.modifyDataOwnerStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_data_owner_stub_blocking(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
		payload = {
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.modifyDataOwnerStubBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_type_async(self) -> DataOwnerType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DataOwnerType._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeAsync,
			self.cardinal_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_type_blocking(self) -> DataOwnerType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DataOwnerType._deserialize(result_info.success)
			return return_value

	def clear_current_data_owner_ids_cache(self) -> None:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.clearCurrentDataOwnerIdsCache(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
