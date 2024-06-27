import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model import DocIdentifier, EncryptedAccessLog, PaginatedList
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import List, Optional

class AccessLogBasicApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def delete_access_log_async(self, entity_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocIdentifier._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavourlessApi.deleteAccessLogAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_access_log_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavourlessApi.deleteAccessLogBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_access_logs_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavourlessApi.deleteAccessLogsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_access_logs_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavourlessApi.deleteAccessLogsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_access_log_async(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedAccessLog._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.modifyAccessLogAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_access_log_blocking(self, entity: EncryptedAccessLog) -> EncryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.modifyAccessLogBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_access_log_async(self, entity_id: str) -> EncryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedAccessLog._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.getAccessLogAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_access_log_blocking(self, entity_id: str) -> EncryptedAccessLog:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.getAccessLogBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_access_logs_async(self, entity_ids: List[str]) -> List[EncryptedAccessLog]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedAccessLog._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.getAccessLogsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_access_logs_blocking(self, entity_ids: List[str]) -> List[EncryptedAccessLog]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.getAccessLogsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedAccessLog._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_access_logs_by_async(self, from_epoch: Optional[int], to_epoch: Optional[int], start_key: Optional[int], start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedAccessLog._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"from_epoch": from_epoch,
			"to_epoch": to_epoch,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_access_logs_by_blocking(self, from_epoch: Optional[int], to_epoch: Optional[int], start_key: Optional[int], start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		payload = {
			"from_epoch": from_epoch,
			"to_epoch": to_epoch,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsByBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [EncryptedAccessLog._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def find_access_logs_by_user_after_date_async(self, user_id: str, access_type: Optional[str] = None, start_date: Optional[int] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedAccessLog._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"access_type": access_type,
			"start_date": start_date,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"descending": descending,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsByUserAfterDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_access_logs_by_user_after_date_blocking(self, user_id: str, access_type: Optional[str] = None, start_date: Optional[int] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedList:
		payload = {
			"user_id": user_id,
			"access_type": access_type,
			"start_date": start_date,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsByUserAfterDateBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [EncryptedAccessLog._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def find_access_logs_in_group_async(self, group_id: str, from_epoch: Optional[int] = None, to_epoch: Optional[int] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedAccessLog._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"from_epoch": from_epoch,
			"to_epoch": to_epoch,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_access_logs_in_group_blocking(self, group_id: str, from_epoch: Optional[int] = None, to_epoch: Optional[int] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"group_id": group_id,
			"from_epoch": from_epoch,
			"to_epoch": to_epoch,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogBasicFlavouredApi.findAccessLogsInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [EncryptedAccessLog._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value
