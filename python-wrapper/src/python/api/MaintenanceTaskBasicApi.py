# auto-generated file
import asyncio
import json
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import MaintenanceTask, EncryptedMaintenanceTask, DocIdentifier, IdWithMandatoryRev, serialize_maintenance_task, deserialize_maintenance_task, SubscriptionEventType, EntitySubscriptionConfiguration
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from typing import List, Optional
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class MaintenanceTaskBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def match_maintenance_tasks_by_async(self, filter: BaseFilterOptions[MaintenanceTask]) -> List[str]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_maintenance_tasks_by_blocking(self, filter: BaseFilterOptions[MaintenanceTask]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksByBlocking(
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

	async def match_maintenance_tasks_by_sorted_async(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> List[str]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_maintenance_tasks_by_sorted_blocking(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksBySortedBlocking(
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

	async def filter_maintenance_tasks_by_async(self, filter: BaseFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[EncryptedMaintenanceTask](
					producer = success,
					deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_maintenance_tasks_by_blocking(self, filter: BaseFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksByBlocking(
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
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_maintenance_tasks_by_sorted_async(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[EncryptedMaintenanceTask](
					producer = success,
					deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_maintenance_tasks_by_sorted_blocking(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> PaginatedListIterator[EncryptedMaintenanceTask]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksBySortedBlocking(
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
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def delete_maintenance_task_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_task_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskByIdBlocking(
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

	async def delete_maintenance_tasks_by_ids_async(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_tasks_by_ids_blocking(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksByIdsBlocking(
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

	async def purge_maintenance_task_by_id_async(self, id: str, rev: str) -> None:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_maintenance_task_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> DocIdentifier:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskBlocking(
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

	async def delete_maintenance_tasks_async(self, maintenance_tasks: List[MaintenanceTask]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTasks": [serialize_maintenance_task(x0) for x0 in maintenance_tasks],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_tasks_blocking(self, maintenance_tasks: List[MaintenanceTask]) -> List[DocIdentifier]:
		payload = {
			"maintenanceTasks": [serialize_maintenance_task(x0) for x0 in maintenance_tasks],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksBlocking(
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

	async def purge_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> None:
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
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> None:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def undelete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_maintenance_task(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_maintenance_task_blocking(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def undelete_maintenance_task_by_id_async(self, id: str, rev: str) -> EncryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_maintenance_task_by_id_blocking(self, id: str, rev: str) -> EncryptedMaintenanceTask:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def modify_maintenance_task_async(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.modifyMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_maintenance_task_blocking(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.modifyMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_maintenance_task_async(self, entity_id: str) -> EncryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_maintenance_task_blocking(self, entity_id: str) -> EncryptedMaintenanceTask:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTaskBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_maintenance_tasks_async(self, entity_ids: List[str]) -> List[EncryptedMaintenanceTask]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EncryptedMaintenanceTask._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_maintenance_tasks_blocking(self, entity_ids: List[str]) -> List[EncryptedMaintenanceTask]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTasksBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedMaintenanceTask._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: BaseFilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntitySubscription[EncryptedMaintenanceTask](
					producer = success,
					deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: BaseFilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
