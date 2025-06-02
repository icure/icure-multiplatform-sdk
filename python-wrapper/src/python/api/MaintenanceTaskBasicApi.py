# auto-generated file
import json
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import MaintenanceTask, EncryptedMaintenanceTask, DocIdentifier, StoredDocumentIdentifier, serialize_maintenance_task, deserialize_maintenance_task, SubscriptionEventType, EntitySubscriptionConfiguration
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from typing import Optional
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class MaintenanceTaskBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def match_maintenance_tasks_by_async(self, filter: BaseFilterOptions[MaintenanceTask]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_maintenance_tasks_by_blocking(self, filter: BaseFilterOptions[MaintenanceTask]) -> list[str]:
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

	async def match_maintenance_tasks_by_sorted_async(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.matchMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_maintenance_tasks_by_sorted_blocking(self, filter: BaseSortableFilterOptions[MaintenanceTask]) -> list[str]:
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
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.filterMaintenanceTasksBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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

	async def delete_maintenance_tasks_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_tasks_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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

	async def delete_maintenance_tasks_async(self, maintenance_tasks: list[MaintenanceTask]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"maintenanceTasks": [serialize_maintenance_task(x0) for x0 in maintenance_tasks],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.deleteMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_maintenance_tasks_blocking(self, maintenance_tasks: list[MaintenanceTask]) -> list[DocIdentifier]:
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
		def do_decode(raw_result):
			return raw_result
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.purgeMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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

	async def create_maintenance_task_async(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.createMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_maintenance_task_blocking(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.createMaintenanceTaskBlocking(
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

	async def undelete_maintenance_task_async(self, maintenance_task: MaintenanceTask) -> MaintenanceTask:
		def do_decode(raw_result):
			return deserialize_maintenance_task(raw_result)
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.undeleteMaintenanceTaskByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.modifyMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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

	async def get_maintenance_task_async(self, entity_id: str) -> Optional[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return EncryptedMaintenanceTask._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTaskAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_task_blocking(self, entity_id: str) -> Optional[EncryptedMaintenanceTask]:
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
			return_value = EncryptedMaintenanceTask._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_maintenance_tasks_async(self, entity_ids: list[str]) -> list[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return [EncryptedMaintenanceTask._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.getMaintenanceTasksAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_maintenance_tasks_blocking(self, entity_ids: list[str]) -> list[EncryptedMaintenanceTask]:
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

	async def subscribe_to_events_async(self, events: set[SubscriptionEventType], filter: BaseFilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedMaintenanceTask](
				producer = raw_result,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MaintenanceTaskBasicApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: set[SubscriptionEventType], filter: BaseFilterOptions[MaintenanceTask], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
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
