import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from ctypes import c_char_p
from model.IndexingInfo import IndexingInfo
from model.ReplicationInfo import ReplicationInfo
from typing import Optional, List
from model.IdWithRev import IdWithRev
from model.couchdb.ReplicatorDocument import ReplicatorDocument

class ICureApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createICureApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_version_async(self) -> str:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getVersionAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_version_blocking(self) -> str:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getVersionBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def is_ready_async(self) -> str:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.isReadyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def is_ready_blocking(self) -> str:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.isReadyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def get_process_info_async(self) -> str:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getProcessInfoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_process_info_blocking(self) -> str:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getProcessInfoBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def get_indexing_info_async(self) -> IndexingInfo:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = IndexingInfo._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getIndexingInfoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_indexing_info_blocking(self) -> IndexingInfo:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getIndexingInfoBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = IndexingInfo._deserialize(result_info["success"])
			return return_value

	async def get_replication_info_async(self) -> ReplicationInfo:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = ReplicationInfo._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getReplicationInfoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_replication_info_blocking(self) -> ReplicationInfo:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getReplicationInfoBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = ReplicationInfo._deserialize(result_info["success"])
			return return_value

	async def update_design_doc_async(self, entity_name: str, warmup: Optional[bool] = None) -> bool:
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
			"entity_name": entity_name,
			"warmup": warmup,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.updateDesignDocAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def update_design_doc_blocking(self, entity_name: str, warmup: Optional[bool] = None) -> bool:
		payload = {
			"entity_name": entity_name,
			"warmup": warmup,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.updateDesignDocBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def resolve_patients_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolvePatientsConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_patients_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolvePatientsConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_contacts_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveContactsConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_contacts_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveContactsConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_forms_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveFormsConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_forms_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveFormsConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_health_elements_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveHealthElementsConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_health_elements_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveHealthElementsConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_invoices_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveInvoicesConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_invoices_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveInvoicesConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_messages_conflicts_async(self, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveMessagesConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_messages_conflicts_blocking(self, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveMessagesConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def resolve_documents_conflicts_async(self, ids: Optional[str] = None, limit: Optional[int] = None) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ids": ids,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveDocumentsConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def resolve_documents_conflicts_blocking(self, ids: Optional[str] = None, limit: Optional[int] = None) -> List[IdWithRev]:
		payload = {
			"ids": ids,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.resolveDocumentsConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_indexing_info_by_group_async(self, group_id: str) -> IndexingInfo:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = IndexingInfo._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getIndexingInfoByGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_indexing_info_by_group_blocking(self, group_id: str) -> IndexingInfo:
		payload = {
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getIndexingInfoByGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = IndexingInfo._deserialize(result_info["success"])
			return return_value

	async def get_replicator_info_async(self, id: str) -> ReplicatorDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = ReplicatorDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getReplicatorInfoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_replicator_info_blocking(self, id: str) -> ReplicatorDocument:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.getReplicatorInfoBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = ReplicatorDocument._deserialize(result_info["success"])
			return return_value

	async def evict_all_from_map_async(self, map_name: str) -> str:
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
			"map_name": map_name,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.evictAllFromMapAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def evict_all_from_map_blocking(self, map_name: str) -> str:
		payload = {
			"map_name": map_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ICureApi.evictAllFromMapBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

__all__ = ['ICureApi']