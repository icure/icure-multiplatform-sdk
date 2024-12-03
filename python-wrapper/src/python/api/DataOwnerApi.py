# auto-generated file
import json
from cardinal_sdk.model import deserialize_data_owner_with_type, DataOwnerWithType, CryptoActorStubWithType, DataOwnerType
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import List


class DataOwnerApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_current_data_owner_async(self) -> DataOwnerWithType:
		def do_decode(raw_result):
			return deserialize_data_owner_with_type(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_blocking(self) -> DataOwnerWithType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_data_owner_with_type(result_info.success)
			return return_value

	async def get_current_data_owner_stub_async(self) -> CryptoActorStubWithType:
		def do_decode(raw_result):
			return CryptoActorStubWithType._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_stub_blocking(self) -> CryptoActorStubWithType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerStubBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_id_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_id_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerIdBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_current_data_owner_hierarchy_ids_async(self) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_hierarchy_ids_blocking(self) -> List[str]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_data_owner_async(self, owner_id: str) -> DataOwnerWithType:
		def do_decode(raw_result):
			return deserialize_data_owner_with_type(raw_result)
		payload = {
			"ownerId": owner_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getDataOwnerAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_data_owner_with_type(result_info.success)
			return return_value

	async def get_crypto_actor_stub_async(self, owner_id: str) -> CryptoActorStubWithType:
		def do_decode(raw_result):
			return CryptoActorStubWithType._deserialize(raw_result)
		payload = {
			"ownerId": owner_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCryptoActorStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_hierarchy_ids_from_async(self, parent_id: str) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"parentId": parent_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyIdsFromAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_current_data_owner_hierarchy_async(self) -> List[DataOwnerWithType]:
		def do_decode(raw_result):
			return [deserialize_data_owner_with_type(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_hierarchy_blocking(self) -> List[DataOwnerWithType]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerHierarchyBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [deserialize_data_owner_with_type(x1) for x1 in result_info.success]
			return return_value

	async def modify_data_owner_stub_async(self, crypto_actor_stub_with_type_dto: CryptoActorStubWithType) -> CryptoActorStubWithType:
		def do_decode(raw_result):
			return CryptoActorStubWithType._deserialize(raw_result)
		payload = {
			"cryptoActorStubWithTypeDto": crypto_actor_stub_with_type_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.modifyDataOwnerStubAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CryptoActorStubWithType._deserialize(result_info.success)
			return return_value

	async def get_current_data_owner_type_async(self) -> DataOwnerType:
		def do_decode(raw_result):
			return DataOwnerType._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeAsync,
			self.cardinal_sdk._native,
		)

	def get_current_data_owner_type_blocking(self) -> DataOwnerType:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DataOwnerApi.getCurrentDataOwnerTypeBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
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
			raise interpret_kt_error(result_info.failure)
