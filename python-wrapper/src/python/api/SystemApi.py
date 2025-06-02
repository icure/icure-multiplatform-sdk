# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model import IndexingInfo, ReplicationInfo, IdWithRev, ReplicatorDocument
from typing import Optional


class SystemApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_version_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getVersionAsync,
			self.cardinal_sdk._native,
		)

	def get_version_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getVersionBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def is_ready_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.isReadyAsync,
			self.cardinal_sdk._native,
		)

	def is_ready_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.isReadyBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_process_info_async(self) -> str:
		def do_decode(raw_result):
			return raw_result
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getProcessInfoAsync,
			self.cardinal_sdk._native,
		)

	def get_process_info_blocking(self) -> str:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getProcessInfoBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_indexing_info_async(self) -> IndexingInfo:
		def do_decode(raw_result):
			return IndexingInfo._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getIndexingInfoAsync,
			self.cardinal_sdk._native,
		)

	def get_indexing_info_blocking(self) -> IndexingInfo:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getIndexingInfoBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = IndexingInfo._deserialize(result_info.success)
			return return_value

	async def get_replication_info_async(self) -> ReplicationInfo:
		def do_decode(raw_result):
			return ReplicationInfo._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getReplicationInfoAsync,
			self.cardinal_sdk._native,
		)

	def get_replication_info_blocking(self) -> ReplicationInfo:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getReplicationInfoBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = ReplicationInfo._deserialize(result_info.success)
			return return_value

	async def update_design_doc_async(self, entity_name: str, warmup: Optional[bool] = None) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entityName": entity_name,
			"warmup": warmup,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.updateDesignDocAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def update_design_doc_blocking(self, entity_name: str, warmup: Optional[bool] = None) -> bool:
		payload = {
			"entityName": entity_name,
			"warmup": warmup,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.updateDesignDocBlocking(
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

	async def resolve_patients_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolvePatientsConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_patients_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolvePatientsConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_contacts_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveContactsConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_contacts_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveContactsConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_forms_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveFormsConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_forms_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveFormsConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_health_elements_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveHealthElementsConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_health_elements_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveHealthElementsConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_invoices_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveInvoicesConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_invoices_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveInvoicesConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_messages_conflicts_async(self, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveMessagesConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_messages_conflicts_blocking(self, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveMessagesConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def resolve_documents_conflicts_async(self, ids: Optional[str] = None, limit: Optional[int] = None) -> list[IdWithRev]:
		def do_decode(raw_result):
			return [IdWithRev._deserialize(x1) for x1 in raw_result]
		payload = {
			"ids": ids,
			"limit": limit,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveDocumentsConflictsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def resolve_documents_conflicts_blocking(self, ids: Optional[str] = None, limit: Optional[int] = None) -> list[IdWithRev]:
		payload = {
			"ids": ids,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.resolveDocumentsConflictsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_indexing_info_by_group_async(self, group_id: str) -> IndexingInfo:
		def do_decode(raw_result):
			return IndexingInfo._deserialize(raw_result)
		payload = {
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getIndexingInfoByGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_indexing_info_by_group_blocking(self, group_id: str) -> IndexingInfo:
		payload = {
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getIndexingInfoByGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = IndexingInfo._deserialize(result_info.success)
			return return_value

	async def get_replicator_info_async(self, id: str) -> ReplicatorDocument:
		def do_decode(raw_result):
			return ReplicatorDocument._deserialize(raw_result)
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getReplicatorInfoAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_replicator_info_blocking(self, id: str) -> ReplicatorDocument:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.getReplicatorInfoBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = ReplicatorDocument._deserialize(result_info.success)
			return return_value

	async def evict_all_from_map_async(self, map_name: str) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"mapName": map_name,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.evictAllFromMapAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def evict_all_from_map_blocking(self, map_name: str) -> str:
		payload = {
			"mapName": map_name,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.SystemApi.evictAllFromMapBlocking(
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
