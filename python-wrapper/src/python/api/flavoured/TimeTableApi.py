import asyncio
import json
from model import DecryptedTimeTable, Patient, User, AccessLevel, serialize_patient, serialize_secret_id_option, TimeTable, serialize_time_table, DocIdentifier, RequestedPermission
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from crypto import SecretIdOption, ShareMetadataBehaviour, deserialize_simple_share_result, SimpleShareResult, TimeTableShareOptions
from model.specializations import HexString

class TimeTableApi:

	class TimeTableFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, time_table: EncryptedTimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"time_table": time_table.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, time_table: EncryptedTimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"time_table": time_table.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithBlocking(
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

		async def try_share_with_many_async(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
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
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> EncryptedTimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, time_table: EncryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> EncryptedTimeTable:
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def modify_time_table_async(self, entity: EncryptedTimeTable) -> EncryptedTimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_time_table_blocking(self, entity: EncryptedTimeTable) -> EncryptedTimeTable:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_table_async(self, entity_id: str) -> EncryptedTimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_table_blocking(self, entity_id: str) -> EncryptedTimeTable:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedTimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_tables_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[EncryptedTimeTable]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedTimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_tables_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[EncryptedTimeTable]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedTimeTable._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_time_tables_by_agenda_id_async(self, agenda_id: str) -> List[EncryptedTimeTable]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedTimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"agenda_id": agenda_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_tables_by_agenda_id_blocking(self, agenda_id: str) -> List[EncryptedTimeTable]:
			payload = {
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedTimeTable._deserialize(x1) for x1 in result_info.success]
				return return_value

	class TimeTableFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, time_table: TimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"time_table": time_table.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, time_table: TimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"time_table": time_table.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithBlocking(
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

		async def try_share_with_many_async(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
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
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> TimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = TimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, time_table: TimeTable, delegates: Dict[str, TimeTableShareOptions]) -> TimeTable:
			payload = {
				"time_table": time_table.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = TimeTable._deserialize(result_info.success)
				return return_value

		async def modify_time_table_async(self, entity: TimeTable) -> TimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = TimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_time_table_blocking(self, entity: TimeTable) -> TimeTable:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = TimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_table_async(self, entity_id: str) -> TimeTable:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = TimeTable._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_table_blocking(self, entity_id: str) -> TimeTable:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = TimeTable._deserialize(result_info.success)
				return return_value

		async def get_time_tables_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[TimeTable]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [TimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_tables_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[TimeTable]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [TimeTable._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_time_tables_by_agenda_id_async(self, agenda_id: str) -> List[TimeTable]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [TimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"agenda_id": agenda_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_time_tables_by_agenda_id_blocking(self, agenda_id: str) -> List[TimeTable]:
			payload = {
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [TimeTable._deserialize(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = TimeTableApi.TimeTableFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = TimeTableApi.TimeTableFlavouredApi(self.icure_sdk)

	async def create_time_table_async(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTimeTable._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.createTimeTableAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_time_table_blocking(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.createTimeTableBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedTimeTable], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedTimeTable:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTimeTable._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedTimeTable], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedTimeTable:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, time_table: TimeTable) -> List[HexString]:
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
			"time_table": serialize_time_table(time_table),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, time_table: TimeTable) -> List[HexString]:
		payload = {
			"time_table": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, time_table: TimeTable) -> bool:
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
			"time_table": serialize_time_table(time_table),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, time_table: TimeTable) -> bool:
		payload = {
			"time_table": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, time_table: TimeTable) -> List[str]:
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
			"time_table": serialize_time_table(time_table),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, time_table: TimeTable) -> List[str]:
		payload = {
			"time_table": serialize_time_table(time_table),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: TimeTable, delegates: List[str]) -> None:
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
			"entity": serialize_time_table(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: TimeTable, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_time_table(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def delete_time_table_async(self, entity_id: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavourlessApi.deleteTimeTableAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_time_table_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavourlessApi.deleteTimeTableBlocking(
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

	async def delete_time_tables_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavourlessApi.deleteTimeTablesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_time_tables_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavourlessApi.deleteTimeTablesBlocking(
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

	async def share_with_async(self, delegate_id: str, time_table: DecryptedTimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
			"time_table": time_table.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, time_table: DecryptedTimeTable, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"time_table": time_table.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithBlocking(
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

	async def try_share_with_many_async(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
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
			"time_table": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> SimpleShareResult:
		payload = {
			"time_table": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.tryShareWithManyBlocking(
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

	async def share_with_many_async(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> DecryptedTimeTable:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTimeTable._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"time_table": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, time_table: DecryptedTimeTable, delegates: Dict[str, TimeTableShareOptions]) -> DecryptedTimeTable:
		payload = {
			"time_table": time_table.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def modify_time_table_async(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTimeTable._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_time_table_blocking(self, entity: DecryptedTimeTable) -> DecryptedTimeTable:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.modifyTimeTableBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_time_table_async(self, entity_id: str) -> DecryptedTimeTable:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTimeTable._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_time_table_blocking(self, entity_id: str) -> DecryptedTimeTable:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTableBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedTimeTable._deserialize(result_info.success)
			return return_value

	async def get_time_tables_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[DecryptedTimeTable]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedTimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"agenda_id": agenda_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_time_tables_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[DecryptedTimeTable]:
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"agenda_id": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByPeriodAndAgendaIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedTimeTable._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_time_tables_by_agenda_id_async(self, agenda_id: str) -> List[DecryptedTimeTable]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedTimeTable._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"agenda_id": agenda_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_time_tables_by_agenda_id_blocking(self, agenda_id: str) -> List[DecryptedTimeTable]:
		payload = {
			"agenda_id": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.TimeTableBasicFlavouredApi.getTimeTablesByAgendaIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedTimeTable._deserialize(x1) for x1 in result_info.success]
			return return_value
