import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model.DataOwnerWithType import deserialize_data_owner_with_type, DataOwnerWithType
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from model.CryptoActorStubWithType import CryptoActorStubWithType
from typing import List
from model.DataOwnerType import DataOwnerType

class DataOwnerApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def get_current_data_owner_async(self) -> DataOwnerWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_data_owner_with_type(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_blocking(self) -> DataOwnerWithType:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_data_owner_with_type(result_info["success"])
			return return_value

	async def get_current_data_owner_stub_async(self) -> CryptoActorStubWithType:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_stub_blocking(self) -> CryptoActorStubWithType:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubBlocking(
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

	async def get_current_data_owner_id_async(self) -> str:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_id_blocking(self) -> str:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def get_current_data_owner_hierarchy_ids_async(self) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_blocking(self) -> List[str]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def get_data_owner_async(self, owner_id: str) -> DataOwnerWithType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_data_owner_with_type(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"owner_id": owner_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getDataOwnerAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_data_owner_blocking(self, owner_id: str) -> DataOwnerWithType:
		payload = {
			"owner_id": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getDataOwnerBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_data_owner_with_type(result_info["success"])
			return return_value

	async def get_data_owner_stub_async(self, owner_id: str) -> CryptoActorStubWithType:
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
			"owner_id": owner_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getDataOwnerStubAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_data_owner_stub_blocking(self, owner_id: str) -> CryptoActorStubWithType:
		payload = {
			"owner_id": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getDataOwnerStubBlocking(
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

	async def get_current_data_owner_hierarchy_ids_from_async(self, parent_id: str) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"parent_id": parent_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_ids_from_blocking(self, parent_id: str) -> List[str]:
		payload = {
			"parent_id": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def get_current_data_owner_hierarchy_async(self) -> List[DataOwnerWithType]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [deserialize_data_owner_with_type(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_hierarchy_blocking(self) -> List[DataOwnerWithType]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [deserialize_data_owner_with_type(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_data_owner_stub_async(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
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
			"crypto_actor_stub_with_type_dto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.modifyDataOwnerStubAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_data_owner_stub_blocking(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
		payload = {
			"crypto_actor_stub_with_type_dto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.modifyDataOwnerStubBlocking(
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

	async def get_current_data_owner_type_async(self) -> DataOwnerType:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DataOwnerType._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_data_owner_type_blocking(self) -> DataOwnerType:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DataOwnerType._deserialize(result_info["success"])
			return return_value

	async def get_crypto_actor_stub_async(self, owner_id: str) -> CryptoActorStubWithType:
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
			"owner_id": owner_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCryptoActorStubAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_crypto_actor_stub_blocking(self, owner_id: str) -> CryptoActorStubWithType:
		payload = {
			"owner_id": owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.getCryptoActorStubBlocking(
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

	def clear_current_data_owner_ids_cache(self) -> None:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DataOwnerApi.clearCurrentDataOwnerIdsCache(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

__all__ = ['DataOwnerApi']