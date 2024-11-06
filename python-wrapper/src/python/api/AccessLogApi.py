# auto-generated file
import asyncio
import json
from DecryptedAccessLog import cardinal_sdk.model
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from Optional import typing
from Patient import cardinal_sdk.model
from User import cardinal_sdk.model
from Dict import typing
from AccessLevel import cardinal_sdk.model
from SecretIdUseOption import cardinal_sdk.model
from SecretIdUseOptionUseAnySharedWithParent import cardinal_sdk.model
from serialize_patient import cardinal_sdk.model
from serialize_secret_id_use_option import cardinal_sdk.model
from AccessLog import cardinal_sdk.model
from serialize_access_log import cardinal_sdk.model
from List import typing
from HexString import cardinal_sdk.model.specializations
from EncryptedAccessLog import cardinal_sdk.model
from deserialize_cardinal_sdk.model import AccessLog
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from DocIdentifier import cardinal_sdk.model
from IdWithMandatoryRev import cardinal_sdk.model
from AccessLogShareOptions import cardinal_sdk.model
from PaginatedListIterator import cardinal_sdk.pagination.PaginatedListIterator
from PTR_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types


class AccessLogApi:

	class AccessLogFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
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
				"delegateId": delegate_id,
				"accessLog": access_log.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"accessLog": access_log.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithBlocking(
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

		async def share_with_many_async(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
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
				"accessLog": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"accessLog": access_log.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.shareWithManyBlocking(
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

		async def filter_access_logs_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: cardinal_sdk.model._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_access_logs_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: cardinal_sdk.model._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.filterAccessLogsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_access_log_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
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
				"id": id,
				"rev": rev,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogByIdBlocking(
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

		async def undelete_access_log_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
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
				"accessLog": cardinal_sdk.model(access_log),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_access_log_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"accessLog": cardinal_sdk.model(access_log),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.undeleteAccessLogBlocking(
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

		async def modify_access_log_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
				"entity": entity.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_access_log_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.modifyAccessLogBlocking(
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

		async def get_access_log_async(self, entity_id: str) -> cardinal_sdk.model:
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
				"entityId": entity_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_access_log_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogBlocking(
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

		async def get_access_logs_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_access_logs_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.encrypted.getAccessLogsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
				return return_value

	class AccessLogFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"accessLog": cardinal_sdk.model(access_log),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"accessLog": cardinal_sdk.model(access_log),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def share_with_many_async(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"accessLog": cardinal_sdk.model(access_log),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"accessLog": cardinal_sdk.model(access_log),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def filter_access_logs_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: AccessLog(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_access_logs_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: AccessLog(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: AccessLog(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.filterAccessLogsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: AccessLog(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_access_log_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"id": id,
				"rev": rev,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def undelete_access_log_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"accessLog": cardinal_sdk.model(access_log),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_access_log_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"accessLog": cardinal_sdk.model(access_log),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.undeleteAccessLogBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def modify_access_log_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_access_log_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.modifyAccessLogBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def get_access_log_async(self, entity_id: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = AccessLog(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_access_log_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = AccessLog(result_info.success)
				return return_value

		async def get_access_logs_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [AccessLog(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_access_logs_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryAndRecover.getAccessLogsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [AccessLog(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = AccessLogApi.AccessLogFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = AccessLogApi.AccessLogFlavouredApi(self.cardinal_sdk)

	async def create_access_log_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"entity": entity.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_access_log_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createAccessLogBlocking(
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

	async def with_encryption_metadata_async(self, base: typing[cardinal_sdk.model], patient: cardinal_sdk.model, user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
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
			"base": base.__serialize__() if base is not None else None,
			"patient": cardinal_sdk.model(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: typing[cardinal_sdk.model], patient: cardinal_sdk.model, user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": cardinal_sdk.model(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.withEncryptionMetadataBlocking(
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

	async def get_encryption_keys_of_async(self, access_log: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
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
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, access_log: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, access_log: cardinal_sdk.model) -> bool:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, access_log: cardinal_sdk.model) -> bool:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, access_log: cardinal_sdk.model) -> typing[str]:
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
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, access_log: cardinal_sdk.model) -> typing[str]:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: cardinal_sdk.model, delegates: typing[str]) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": cardinal_sdk.model(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: cardinal_sdk.model, delegates: typing[str]) -> None:
		payload = {
			"entity": cardinal_sdk.model(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def decrypt_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"accessLog": access_log.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.decryptBlocking(
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

	async def try_decrypt_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = AccessLog(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"accessLog": access_log.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = AccessLog(result_info.success)
			return return_value

	async def match_access_logs_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
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
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_access_logs_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsByBlocking(
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

	async def match_access_logs_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
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
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.matchAccessLogsBySortedBlocking(
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

	async def delete_access_log_by_id_async(self, entity_id: str, rev: str) -> cardinal_sdk.model:
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
			"entityId": entity_id,
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_access_log_by_id_blocking(self, entity_id: str, rev: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogByIdBlocking(
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

	async def delete_access_logs_by_ids_async(self, entity_ids: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_access_logs_by_ids_blocking(self, entity_ids: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_access_log_by_id_async(self, id: str, rev: str) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_access_log_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def delete_access_log_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_access_log_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogBlocking(
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

	async def delete_access_logs_async(self, access_logs: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"accessLogs": [cardinal_sdk.model(x0) for x0 in access_logs],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_access_logs_blocking(self, access_logs: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"accessLogs": [cardinal_sdk.model(x0) for x0 in access_logs],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.deleteAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_access_log_async(self, access_log: cardinal_sdk.model) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_access_log_blocking(self, access_log: cardinal_sdk.model) -> None:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.purgeAccessLogBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def share_with_async(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
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
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, access_log: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
		payload = {
			"delegateId": delegate_id,
			"accessLog": access_log.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithBlocking(
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

	async def share_with_many_async(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
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
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, access_log: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
		payload = {
			"accessLog": access_log.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.shareWithManyBlocking(
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

	async def filter_access_logs_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_access_logs_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_access_logs_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_access_logs_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.filterAccessLogsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def undelete_access_log_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
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
			"id": id,
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_access_log_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogByIdBlocking(
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

	async def undelete_access_log_async(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"accessLog": cardinal_sdk.model(access_log),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_access_log_blocking(self, access_log: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"accessLog": cardinal_sdk.model(access_log),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.undeleteAccessLogBlocking(
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

	async def modify_access_log_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"entity": entity.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_access_log_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.modifyAccessLogBlocking(
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

	async def get_access_log_async(self, entity_id: str) -> cardinal_sdk.model:
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
			"entityId": entity_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_access_log_blocking(self, entity_id: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogBlocking(
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

	async def get_access_logs_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_access_logs_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.AccessLogApi.getAccessLogsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value
