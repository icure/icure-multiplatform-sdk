# auto-generated file
import json
from cardinal_sdk.model import DecryptedTimeTable, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, TimeTable, serialize_time_table, EncryptedTimeTable, deserialize_time_table, DocIdentifier, IdWithMandatoryRev, TimeTableShareOptions
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class TimeTableApi:

	class TimeTableFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, time_table: EncryptedTimeTable, options: Optional[TimeTableShareOptions] = None) -> EncryptedTimeTable:
			def do_decode(raw_result):
				return EncryptedTimeTable._deserialize(raw_result)
			payload = {
				"delegateId": delegate_id,
				"timeTable": time_table.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_blocking(self, delegate_id: str, time_table: EncryptedTimeTable, options: Optional[TimeTableShareOptions] = None) -> EncryptedTimeTable:
			payload = {
				"delegateId": delegate_id,
				"timeTable": time_table.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def share_with_many_async(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> EncryptedTimeTable:
			def do_decode(raw_result):
				return EncryptedTimeTable._deserialize(raw_result)
			payload = {
				"timeTable": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_many_blocking(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> EncryptedTimeTable:
			payload = {
				"timeTable": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def filter_time_tables_by_async(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[EncryptedTimeTable]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedTimeTable](
					producer = raw_result,
					deserializer = lambda x: EncryptedTimeTable._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.filterTimeTablesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_time_tables_by_blocking(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[EncryptedTimeTable]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.filterTimeTablesByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[EncryptedTimeTable](
					producer = class_pointer,
					deserializer = lambda x: EncryptedTimeTable._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_time_tables_by_sorted_async(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[EncryptedTimeTable]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedTimeTable](
					producer = raw_result,
					deserializer = lambda x: EncryptedTimeTable._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.filterTimeTablesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_time_tables_by_sorted_blocking(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[EncryptedTimeTable]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.filterTimeTablesBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[EncryptedTimeTable](
					producer = class_pointer,
					deserializer = lambda x: EncryptedTimeTable._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_time_table_async(self, time_table: TimeTable) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"timeTable": serialize_time_table(time_table),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.undeleteTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_time_table_blocking(self, time_table: TimeTable) -> TimeTable:
			payload = {
				"timeTable": serialize_time_table(time_table),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.undeleteTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def modify_time_table_async(self, entity: EncryptedTimeTable) -> EncryptedTimeTable:
			def do_decode(raw_result):
				return EncryptedTimeTable._deserialize(raw_result)
			payload = {
				"entity": entity.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.modifyTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_time_table_blocking(self, entity: EncryptedTimeTable) -> EncryptedTimeTable:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.modifyTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def undelete_time_table_by_id_async(self, id: str, rev: str) -> EncryptedTimeTable:
			def do_decode(raw_result):
				return EncryptedTimeTable._deserialize(raw_result)
			payload = {
				"id": id,
				"rev": rev,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.undeleteTimeTableByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_time_table_by_id_blocking(self, id: str, rev: str) -> EncryptedTimeTable:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.undeleteTimeTableByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_table_async(self, entity_id: str) -> EncryptedTimeTable:
			def do_decode(raw_result):
				return EncryptedTimeTable._deserialize(raw_result)
			payload = {
				"entityId": entity_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.getTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_time_table_blocking(self, entity_id: str) -> EncryptedTimeTable:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.getTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_tables_async(self, time_table_ids: List[str]) -> List[EncryptedTimeTable]:
			def do_decode(raw_result):
				return [EncryptedTimeTable._deserialize(x1) for x1 in raw_result]
			payload = {
				"timeTableIds": [x0 for x0 in time_table_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.getTimeTablesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_time_tables_blocking(self, time_table_ids: List[str]) -> List[EncryptedTimeTable]:
			payload = {
				"timeTableIds": [x0 for x0 in time_table_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.encrypted.getTimeTablesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedTimeTable._deserialize(x1) for x1 in result_info.success]
				return return_value

	class TimeTableFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, time_table: TimeTable, options: Optional[TimeTableShareOptions] = None) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"delegateId": delegate_id,
				"timeTable": serialize_time_table(time_table),
				"options": options.__serialize__() if options is not None else None,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_blocking(self, delegate_id: str, time_table: TimeTable, options: Optional[TimeTableShareOptions] = None) -> TimeTable:
			payload = {
				"delegateId": delegate_id,
				"timeTable": serialize_time_table(time_table),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def share_with_many_async(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"timeTable": serialize_time_table(time_table),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_many_blocking(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> TimeTable:
			payload = {
				"timeTable": serialize_time_table(time_table),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def filter_time_tables_by_async(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[TimeTable]:
			def do_decode(raw_result):
				return PaginatedListIterator[TimeTable](
					producer = raw_result,
					deserializer = lambda x: deserialize_time_table(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.filterTimeTablesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_time_tables_by_blocking(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[TimeTable]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.filterTimeTablesByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[TimeTable](
					producer = class_pointer,
					deserializer = lambda x: deserialize_time_table(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_time_tables_by_sorted_async(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[TimeTable]:
			def do_decode(raw_result):
				return PaginatedListIterator[TimeTable](
					producer = raw_result,
					deserializer = lambda x: deserialize_time_table(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.filterTimeTablesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_time_tables_by_sorted_blocking(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[TimeTable]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.filterTimeTablesBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[TimeTable](
					producer = class_pointer,
					deserializer = lambda x: deserialize_time_table(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_time_table_async(self, time_table: TimeTable) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"timeTable": serialize_time_table(time_table),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.undeleteTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_time_table_blocking(self, time_table: TimeTable) -> TimeTable:
			payload = {
				"timeTable": serialize_time_table(time_table),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.undeleteTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def modify_time_table_async(self, entity: TimeTable) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"entity": serialize_time_table(entity),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.modifyTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_time_table_blocking(self, entity: TimeTable) -> TimeTable:
			payload = {
				"entity": serialize_time_table(entity),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.modifyTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def undelete_time_table_by_id_async(self, id: str, rev: str) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"id": id,
				"rev": rev,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.undeleteTimeTableByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_time_table_by_id_blocking(self, id: str, rev: str) -> TimeTable:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.undeleteTimeTableByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def get_time_table_async(self, entity_id: str) -> TimeTable:
			def do_decode(raw_result):
				return deserialize_time_table(raw_result)
			payload = {
				"entityId": entity_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.getTimeTableAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_time_table_blocking(self, entity_id: str) -> TimeTable:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.getTimeTableBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_time_table(result_info.success)
				return return_value

		async def get_time_tables_async(self, time_table_ids: List[str]) -> List[TimeTable]:
			def do_decode(raw_result):
				return [deserialize_time_table(x1) for x1 in raw_result]
			payload = {
				"timeTableIds": [x0 for x0 in time_table_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.getTimeTablesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_time_tables_blocking(self, time_table_ids: List[str]) -> List[TimeTable]:
			payload = {
				"timeTableIds": [x0 for x0 in time_table_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryAndRecover.getTimeTablesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_time_table(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = TimeTableApi.TimeTableFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = TimeTableApi.TimeTableFlavouredApi(self.cardinal_sdk)

	async def create_time_table_async(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.createTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_time_table_blocking(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.createTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedTimeTable], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedTimeTable], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedTimeTable:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, time_table: TimeTable) -> List[HexString]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, time_table: TimeTable) -> List[HexString]:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, time_table: TimeTable) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, time_table: TimeTable) -> bool:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, time_table: TimeTable) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, time_table: TimeTable) -> List[str]:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: TimeTable, delegates: List[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_time_table(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: TimeTable, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_time_table(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, time_table: EncryptedTimeTable) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"timeTable": time_table.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, time_table: EncryptedTimeTable) -> DecryptedTimeTable:
		payload = {
			"timeTable": time_table.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, time_table: EncryptedTimeTable) -> TimeTable:
		def do_decode(raw_result):
			return deserialize_time_table(raw_result)
		payload = {
			"timeTable": time_table.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, time_table: EncryptedTimeTable) -> TimeTable:
		payload = {
			"timeTable": time_table.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_time_table(result_info.success)
			return return_value

	async def match_time_tables_by_async(self, filter: FilterOptions[TimeTable]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.matchTimeTablesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_time_tables_by_blocking(self, filter: FilterOptions[TimeTable]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.matchTimeTablesByBlocking(
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

	async def match_time_tables_by_sorted_async(self, filter: SortableFilterOptions[TimeTable]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.matchTimeTablesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_time_tables_by_sorted_blocking(self, filter: SortableFilterOptions[TimeTable]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.matchTimeTablesBySortedBlocking(
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

	async def delete_time_table_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTableByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_time_table_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTableByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_time_tables_by_ids_async(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTablesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_time_tables_by_ids_blocking(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTablesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_time_table_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.purgeTimeTableByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_time_table_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.purgeTimeTableByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_time_table_async(self, time_table: TimeTable) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_time_table_blocking(self, time_table: TimeTable) -> DocIdentifier:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_time_tables_async(self, time_tables: List[TimeTable]) -> List[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"timeTables": [serialize_time_table(x0) for x0 in time_tables],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTablesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_time_tables_blocking(self, time_tables: List[TimeTable]) -> List[DocIdentifier]:
		payload = {
			"timeTables": [serialize_time_table(x0) for x0 in time_tables],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.deleteTimeTablesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_time_table_async(self, time_table: TimeTable) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.purgeTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_time_table_blocking(self, time_table: TimeTable) -> None:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.purgeTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def share_with_async(self, delegate_id: str, time_table: DecryptedTimeTable, options: Optional[TimeTableShareOptions] = None) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"timeTable": time_table.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, time_table: DecryptedTimeTable, options: Optional[TimeTableShareOptions] = None) -> DecryptedTimeTable:
		payload = {
			"delegateId": delegate_id,
			"timeTable": time_table.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"timeTable": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> DecryptedTimeTable:
		payload = {
			"timeTable": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def filter_time_tables_by_async(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[DecryptedTimeTable]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedTimeTable](
				producer = raw_result,
				deserializer = lambda x: DecryptedTimeTable._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.filterTimeTablesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_time_tables_by_blocking(self, filter: FilterOptions[TimeTable]) -> PaginatedListIterator[DecryptedTimeTable]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.filterTimeTablesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedTimeTable](
				producer = class_pointer,
				deserializer = lambda x: DecryptedTimeTable._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_time_tables_by_sorted_async(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[DecryptedTimeTable]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedTimeTable](
				producer = raw_result,
				deserializer = lambda x: DecryptedTimeTable._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.filterTimeTablesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_time_tables_by_sorted_blocking(self, filter: SortableFilterOptions[TimeTable]) -> PaginatedListIterator[DecryptedTimeTable]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.filterTimeTablesBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedTimeTable](
				producer = class_pointer,
				deserializer = lambda x: DecryptedTimeTable._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def undelete_time_table_async(self, time_table: TimeTable) -> TimeTable:
		def do_decode(raw_result):
			return deserialize_time_table(raw_result)
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.undeleteTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_time_table_blocking(self, time_table: TimeTable) -> TimeTable:
		payload = {
			"timeTable": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.undeleteTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_time_table(result_info.success)
			return return_value

	async def modify_time_table_async(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.modifyTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_time_table_blocking(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.modifyTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def undelete_time_table_by_id_async(self, id: str, rev: str) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.undeleteTimeTableByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_time_table_by_id_blocking(self, id: str, rev: str) -> DecryptedTimeTable:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.undeleteTimeTableByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_time_table_async(self, entity_id: str) -> DecryptedTimeTable:
		def do_decode(raw_result):
			return DecryptedTimeTable._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getTimeTableAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_time_table_blocking(self, entity_id: str) -> DecryptedTimeTable:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getTimeTableBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_time_tables_async(self, time_table_ids: List[str]) -> List[DecryptedTimeTable]:
		def do_decode(raw_result):
			return [DecryptedTimeTable._deserialize(x1) for x1 in raw_result]
		payload = {
			"timeTableIds": [x0 for x0 in time_table_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getTimeTablesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_time_tables_blocking(self, time_table_ids: List[str]) -> List[DecryptedTimeTable]:
		payload = {
			"timeTableIds": [x0 for x0 in time_table_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.TimeTableApi.getTimeTablesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedTimeTable._deserialize(x1) for x1 in result_info.success]
			return return_value
