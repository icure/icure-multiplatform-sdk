import asyncio
import json
from icure.model import DecryptedMaintenanceTask, User, AccessLevel, MaintenanceTask, serialize_maintenance_task, EncryptedMaintenanceTask, deserialize_maintenance_task, DocIdentifier, SubscriptionEventType, MaintenanceTaskAbstractFilter, EntitySubscriptionConfiguration, serialize_abstract_filter, ShareMetadataBehaviour, RequestedPermission, deserialize_simple_share_result, SimpleShareResult, MaintenanceTaskShareOptions, FilterChain, PaginatedList
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from icure.model.specializations import HexString
from icure.subscription.EntitySubscription import EntitySubscription

class MaintenanceTaskApi:

	class MaintenanceTaskFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, maintenance_task: EncryptedMaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"maintenanceTask": maintenance_task.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, maintenance_task: EncryptedMaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"maintenanceTask": maintenance_task.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, maintenance_task: EncryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, maintenance_task: EncryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, maintenance_task: EncryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> EncryptedMaintenanceTask:
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
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, maintenance_task: EncryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> EncryptedMaintenanceTask:
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
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
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.modifyMaintenanceTaskAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_maintenance_task_blocking(self, entity: EncryptedMaintenanceTask) -> EncryptedMaintenanceTask:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.modifyMaintenanceTaskBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
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
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.getMaintenanceTaskAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_maintenance_task_blocking(self, entity_id: str) -> EncryptedMaintenanceTask:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.getMaintenanceTaskBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedMaintenanceTask._deserialize(result_info.success)
				return return_value

		async def filter_maintenance_tasks_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedMaintenanceTask._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDocumentId": start_document_id,
				"limit": limit,
				"filterChain": filter_chain.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.filterMaintenanceTasksByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_maintenance_tasks_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDocumentId": start_document_id,
				"limit": limit,
				"filterChain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.encrypted.filterMaintenanceTasksByBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedMaintenanceTask._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

	class MaintenanceTaskFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, maintenance_task: MaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"maintenanceTask": maintenance_task.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, maintenance_task: MaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"maintenanceTask": maintenance_task.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, maintenance_task: MaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, maintenance_task: MaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, maintenance_task: MaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> MaintenanceTask:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = MaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, maintenance_task: MaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> MaintenanceTask:
			payload = {
				"maintenanceTask": maintenance_task.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = MaintenanceTask._deserialize(result_info.success)
				return return_value

		async def modify_maintenance_task_async(self, entity: MaintenanceTask) -> MaintenanceTask:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = MaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTaskAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_maintenance_task_blocking(self, entity: MaintenanceTask) -> MaintenanceTask:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.modifyMaintenanceTaskBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = MaintenanceTask._deserialize(result_info.success)
				return return_value

		async def get_maintenance_task_async(self, entity_id: str) -> MaintenanceTask:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = MaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.getMaintenanceTaskAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_maintenance_task_blocking(self, entity_id: str) -> MaintenanceTask:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.getMaintenanceTaskBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = MaintenanceTask._deserialize(result_info.success)
				return return_value

		async def filter_maintenance_tasks_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_maintenance_task(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDocumentId": start_document_id,
				"limit": limit,
				"filterChain": filter_chain.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_maintenance_tasks_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDocumentId": start_document_id,
				"limit": limit,
				"filterChain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryAndRecover.filterMaintenanceTasksByBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_maintenance_task(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = MaintenanceTaskApi.MaintenanceTaskFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = MaintenanceTaskApi.MaintenanceTaskFlavouredApi(self.icure_sdk)

	async def create_maintenance_task_async(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.createMaintenanceTaskAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_maintenance_task_blocking(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.createMaintenanceTaskBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, maintenance_task: Optional[DecryptedMaintenanceTask], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": maintenance_task.__serialize__() if maintenance_task is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.withEncryptionMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, maintenance_task: Optional[DecryptedMaintenanceTask], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__() if maintenance_task is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.withEncryptionMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, maintenance_task: MaintenanceTask) -> List[HexString]:
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
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.getEncryptionKeysOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, maintenance_task: MaintenanceTask) -> List[HexString]:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, maintenance_task: MaintenanceTask) -> bool:
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.hasWriteAccessAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, maintenance_task: MaintenanceTask) -> bool:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.hasWriteAccessBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, maintenance_task: MaintenanceTask) -> List[str]:
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
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.decryptPatientIdOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, maintenance_task: MaintenanceTask) -> List[str]:
		payload = {
			"maintenanceTask": serialize_maintenance_task(maintenance_task),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: MaintenanceTask, delegates: List[str]) -> None:
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
			"entity": serialize_maintenance_task(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: MaintenanceTask, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_maintenance_task(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def decrypt_async(self, maintenance_task: EncryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.decryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, maintenance_task: EncryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.decryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, maintenance_task: EncryptedMaintenanceTask) -> MaintenanceTask:
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
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryDecryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, maintenance_task: EncryptedMaintenanceTask) -> MaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryDecryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_maintenance_task(result_info.success)
			return return_value

	async def delete_maintenance_task_async(self, entity_id: str) -> DocIdentifier:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.deleteMaintenanceTaskAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_task_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.deleteMaintenanceTaskBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_maintenance_tasks_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.deleteMaintenanceTasksAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_maintenance_tasks_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.deleteMaintenanceTasksBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: MaintenanceTaskAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
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
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.subscribeToEventsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: MaintenanceTaskAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedMaintenanceTask]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.subscribeToEventsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise Exception(error_msg)
		else:
			class_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return EntitySubscription[EncryptedMaintenanceTask](
				producer = class_pointer,
				deserializer = lambda x: EncryptedMaintenanceTask._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def share_with_async(self, delegate_id: str, maintenance_task: DecryptedMaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.shareWithAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, maintenance_task: DecryptedMaintenanceTask, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegateId": delegate_id,
			"maintenanceTask": maintenance_task.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.shareWithBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def try_share_with_many_async(self, maintenance_task: DecryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryShareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, maintenance_task: DecryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> SimpleShareResult:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.tryShareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def share_with_many_async(self, maintenance_task: DecryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.shareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, maintenance_task: DecryptedMaintenanceTask, delegates: Dict[str, MaintenanceTaskShareOptions]) -> DecryptedMaintenanceTask:
		payload = {
			"maintenanceTask": maintenance_task.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.shareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def modify_maintenance_task_async(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.modifyMaintenanceTaskAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_maintenance_task_blocking(self, entity: DecryptedMaintenanceTask) -> DecryptedMaintenanceTask:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.modifyMaintenanceTaskBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def get_maintenance_task_async(self, entity_id: str) -> DecryptedMaintenanceTask:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedMaintenanceTask._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.getMaintenanceTaskAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_maintenance_task_blocking(self, entity_id: str) -> DecryptedMaintenanceTask:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.getMaintenanceTaskBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedMaintenanceTask._deserialize(result_info.success)
			return return_value

	async def filter_maintenance_tasks_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedMaintenanceTask._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"startDocumentId": start_document_id,
			"limit": limit,
			"filterChain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.filterMaintenanceTasksByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_maintenance_tasks_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"startDocumentId": start_document_id,
			"limit": limit,
			"filterChain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.MaintenanceTaskApi.filterMaintenanceTasksByBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedMaintenanceTask._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value
