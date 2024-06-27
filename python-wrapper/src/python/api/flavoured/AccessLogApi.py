import asyncio
import json
from model import DecryptedAccessLog, Patient, User, AccessLevel, serialize_patient, AccessLog, serialize_access_log, DocIdentifier, RequestedPermission, RequestedPermission.MaxWrite, PaginatedList, EncryptedAccessLog, deserialize_access_log
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from ctypes import cast, c_char_p, c_void_p
from typing import Optional, Dict, List
from crypto import SecretIdOption, SecretIdOptionUseAnySharedWithParent, serialize_secret_id_option, ShareMetadataBehaviour, ShareMetadataBehaviour.IfAvailable, deserialize_simple_share_result, SimpleShareResult, AccessLogShareOptions
from model.specializations import HexString
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult

class AccessLogApi:

	class AccessLogFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, access_log: EncryptedAccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"access_log": access_log.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, access_log: EncryptedAccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"access_log": access_log.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, access_log: EncryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, access_log: EncryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, access_log: EncryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> EncryptedAccessLog:
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
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, access_log: EncryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> EncryptedAccessLog:
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyBlocking(
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

		async def find_access_logs_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedAccessLog]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedAccessLog](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedAccessLog._deserialize(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_access_logs_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedAccessLog]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[EncryptedAccessLog](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedAccessLog._deserialize(x)
				)

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

	class AccessLogFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, access_log: AccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"access_log": access_log.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, access_log: AccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"access_log": access_log.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, access_log: AccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, access_log: AccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, access_log: AccessLog, delegates: Dict[str, AccessLogShareOptions]) -> AccessLog:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = AccessLog._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, access_log: AccessLog, delegates: Dict[str, AccessLogShareOptions]) -> AccessLog:
			payload = {
				"access_log": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = AccessLog._deserialize(result_info.success)
				return return_value

		async def find_access_logs_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[AccessLog]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[AccessLog](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_access_log(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_access_logs_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[AccessLog]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[AccessLog](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_access_log(x)
				)

		async def modify_access_log_async(self, entity: AccessLog) -> AccessLog:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = AccessLog._deserialize(success.decode('utf-8'))
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

		def modify_access_log_blocking(self, entity: AccessLog) -> AccessLog:
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
				return_value = AccessLog._deserialize(result_info.success)
				return return_value

		async def get_access_log_async(self, entity_id: str) -> AccessLog:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = AccessLog._deserialize(success.decode('utf-8'))
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

		def get_access_log_blocking(self, entity_id: str) -> AccessLog:
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
				return_value = AccessLog._deserialize(result_info.success)
				return return_value

		async def get_access_logs_async(self, entity_ids: List[str]) -> List[AccessLog]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [AccessLog._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def get_access_logs_blocking(self, entity_ids: List[str]) -> List[AccessLog]:
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
				return_value = [AccessLog._deserialize(x1) for x1 in result_info.success]
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
						rows = [deserialize_access_log(item) for item in success.rows],
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
					rows = [deserialize_access_log(item) for item in return_value.rows],
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
						rows = [deserialize_access_log(item) for item in success.rows],
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
					rows = [deserialize_access_log(item) for item in return_value.rows],
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
						rows = [deserialize_access_log(item) for item in success.rows],
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
					rows = [deserialize_access_log(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = AccessLogApi.AccessLogFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = AccessLogApi.AccessLogFlavouredApi(self.icure_sdk)

	async def create_access_log_async(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedAccessLog._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.createAccessLogAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_access_log_blocking(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.createAccessLogBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedAccessLog], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent) -> DecryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedAccessLog._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedAccessLog], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent) -> DecryptedAccessLog:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, access_log: AccessLog) -> List[HexString]:
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
			"access_log": serialize_access_log(access_log),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, access_log: AccessLog) -> List[HexString]:
		payload = {
			"access_log": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.getEncryptionKeysOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def has_write_access_async(self, access_log: AccessLog) -> bool:
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
			"access_log": serialize_access_log(access_log),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, access_log: AccessLog) -> bool:
		payload = {
			"access_log": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.hasWriteAccessBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, access_log: AccessLog) -> List[str]:
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
			"access_log": serialize_access_log(access_log),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, access_log: AccessLog) -> List[str]:
		payload = {
			"access_log": serialize_access_log(access_log),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.decryptPatientIdOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: AccessLog, delegates: List[str]) -> None:
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
			"entity": serialize_access_log(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: AccessLog, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_access_log(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

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

	async def share_with_async(self, delegate_id: str, access_log: DecryptedAccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"access_log": access_log.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, access_log: DecryptedAccessLog, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"access_log": access_log.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def try_share_with_many_async(self, access_log: DecryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"access_log": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, access_log: DecryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> SimpleShareResult:
		payload = {
			"access_log": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.tryShareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def share_with_many_async(self, access_log: DecryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> DecryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedAccessLog._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"access_log": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, access_log: DecryptedAccessLog, delegates: Dict[str, AccessLogShareOptions]) -> DecryptedAccessLog:
		payload = {
			"access_log": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def find_access_logs_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedAccessLog]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedAccessLog](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedAccessLog._deserialize(x)
				)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_access_logs_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedAccessLog]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.AccessLogFlavouredApi.findAccessLogsByHcPartyPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		error_str_pointer = PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result)
			raise Exception(error_msg)
		else:
			class_pointer = PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result)
			return PaginatedListIterator[DecryptedAccessLog](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedAccessLog._deserialize(x)
			)

	async def modify_access_log_async(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedAccessLog._deserialize(success.decode('utf-8'))
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

	def modify_access_log_blocking(self, entity: DecryptedAccessLog) -> DecryptedAccessLog:
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
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_access_log_async(self, entity_id: str) -> DecryptedAccessLog:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedAccessLog._deserialize(success.decode('utf-8'))
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

	def get_access_log_blocking(self, entity_id: str) -> DecryptedAccessLog:
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
			return_value = DecryptedAccessLog._deserialize(result_info.success)
			return return_value

	async def get_access_logs_async(self, entity_ids: List[str]) -> List[DecryptedAccessLog]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedAccessLog._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_access_logs_blocking(self, entity_ids: List[str]) -> List[DecryptedAccessLog]:
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
			return_value = [DecryptedAccessLog._deserialize(x1) for x1 in result_info.success]
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
					rows = [DecryptedAccessLog._deserialize(item) for item in success.rows],
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
				rows = [DecryptedAccessLog._deserialize(item) for item in return_value.rows],
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
					rows = [DecryptedAccessLog._deserialize(item) for item in success.rows],
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
				rows = [DecryptedAccessLog._deserialize(item) for item in return_value.rows],
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
					rows = [DecryptedAccessLog._deserialize(item) for item in success.rows],
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
				rows = [DecryptedAccessLog._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value
