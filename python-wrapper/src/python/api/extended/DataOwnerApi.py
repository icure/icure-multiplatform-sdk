import asyncio
import json
from icure.model import deserialize_data_owner_with_type, DataOwnerWithType, CryptoActorStubWithType, DataOwnerType
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import List

class DataOwnerApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_blocking(self) -> DataOwnerWithType:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerStubAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_stub_blocking(self) -> CryptoActorStubWithType:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerStubBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerIdAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_id_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerIdBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyIdsAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_blocking(self) -> List[str]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyIdsBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getDataOwnerAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_data_owner_blocking(self, owner_id: str) -> DataOwnerWithType:
		payload = {
			"ownerId": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getDataOwnerBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_data_owner_with_type(result_info.success)
			return return_value

	async def get_data_owner_stub_async(self, owner_id: str) -> CryptoActorStubWithType:
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getDataOwnerStubAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_data_owner_stub_blocking(self, owner_id: str) -> CryptoActorStubWithType:
		payload = {
			"ownerId": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getDataOwnerStubBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_from_blocking(self, parent_id: str) -> List[str]:
		payload = {
			"parentId": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_blocking(self) -> List[DataOwnerWithType]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerHierarchyBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.modifyDataOwnerStubAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_data_owner_stub_blocking(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
		payload = {
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.modifyDataOwnerStubBlocking(
			self.icure_sdk._native,
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerTypeAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_current_data_owner_type_blocking(self) -> DataOwnerType:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCurrentDataOwnerTypeBlocking(
			self.icure_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DataOwnerType._deserialize(result_info.success)
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCryptoActorStubAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_crypto_actor_stub_blocking(self, owner_id: str) -> CryptoActorStubWithType:
		payload = {
			"ownerId": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.getCryptoActorStubBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	def clear_current_data_owner_ids_cache(self) -> None:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.DataOwnerApi.clearCurrentDataOwnerIdsCache(
			self.icure_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
