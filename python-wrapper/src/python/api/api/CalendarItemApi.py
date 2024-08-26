# auto-generated file
import asyncio
import json
from icure.model import DecryptedCalendarItem, Patient, User, AccessLevel, SecretIdOption, SecretIdOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_option, CalendarItem, serialize_calendar_item, EncryptedCalendarItem, deserialize_calendar_item, DocIdentifier, CalendarItemShareOptions, deserialize_simple_share_result_decrypted_calendar_item, SimpleShareResultDecryptedCalendarItem, deserialize_simple_share_result_encrypted_calendar_item, SimpleShareResultEncryptedCalendarItem, deserialize_simple_share_result_calendar_item, SimpleShareResultCalendarItem
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from icure.model.specializations import HexString
from icure.filters.FilterOptions import FilterOptions, SortableFilterOptions
from icure.pagination.PaginatedListIterator import PaginatedListIterator

class CalendarItemApi:

	class CalendarItemFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, calendar_item: EncryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultEncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_encrypted_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"calendarItem": calendar_item.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, calendar_item: EncryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultEncryptedCalendarItem:
			payload = {
				"delegateId": delegate_id,
				"calendarItem": calendar_item.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_encrypted_calendar_item(result_info.success)
				return return_value

		async def try_share_with_many_async(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultEncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_encrypted_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultEncryptedCalendarItem:
			payload = {
				"calendarItem": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_encrypted_calendar_item(result_info.success)
				return return_value

		async def share_with_many_async(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
			payload = {
				"calendarItem": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info.success)
				return return_value

		async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.linkToPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> EncryptedCalendarItem:
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.linkToPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info.success)
				return return_value

		async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedCalendarItem](
						producer = success,
						deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsByBlocking(
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
				return PaginatedListIterator[EncryptedCalendarItem](
					producer = class_pointer,
					deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
					executor = self.icure_sdk._executor
				)

		async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedCalendarItem](
						producer = success,
						deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsBySortedAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[EncryptedCalendarItem]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.filterCalendarItemsBySortedBlocking(
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
				return PaginatedListIterator[EncryptedCalendarItem](
					producer = class_pointer,
					deserializer = lambda x: EncryptedCalendarItem._deserialize(x),
					executor = self.icure_sdk._executor
				)

		async def modify_calendar_item_async(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.modifyCalendarItemAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.modifyCalendarItemBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info.success)
				return return_value

		async def get_calendar_item_async(self, entity_id: str) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_calendar_item_blocking(self, entity_id: str) -> EncryptedCalendarItem:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info.success)
				return return_value

		async def get_calendar_items_async(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedCalendarItem._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.encrypted.getCalendarItemsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
				return return_value

	class CalendarItemFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, calendar_item: CalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"calendarItem": serialize_calendar_item(calendar_item),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, calendar_item: CalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultCalendarItem:
			payload = {
				"delegateId": delegate_id,
				"calendarItem": serialize_calendar_item(calendar_item),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_calendar_item(result_info.success)
				return return_value

		async def try_share_with_many_async(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultCalendarItem:
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_calendar_item(result_info.success)
				return return_value

		async def share_with_many_async(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> CalendarItem:
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_calendar_item(result_info.success)
				return return_value

		async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.linkToPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> CalendarItem:
			payload = {
				"calendarItem": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.linkToPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_calendar_item(result_info.success)
				return return_value

		async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[CalendarItem](
						producer = success,
						deserializer = lambda x: deserialize_calendar_item(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsByBlocking(
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
				return PaginatedListIterator[CalendarItem](
					producer = class_pointer,
					deserializer = lambda x: deserialize_calendar_item(x),
					executor = self.icure_sdk._executor
				)

		async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[CalendarItem](
						producer = success,
						deserializer = lambda x: deserialize_calendar_item(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsBySortedAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[CalendarItem]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.filterCalendarItemsBySortedBlocking(
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
				return PaginatedListIterator[CalendarItem](
					producer = class_pointer,
					deserializer = lambda x: deserialize_calendar_item(x),
					executor = self.icure_sdk._executor
				)

		async def modify_calendar_item_async(self, entity: CalendarItem) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": serialize_calendar_item(entity),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.modifyCalendarItemAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_calendar_item_blocking(self, entity: CalendarItem) -> CalendarItem:
			payload = {
				"entity": serialize_calendar_item(entity),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.modifyCalendarItemBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_calendar_item(result_info.success)
				return return_value

		async def get_calendar_item_async(self, entity_id: str) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_calendar_item(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_calendar_item_blocking(self, entity_id: str) -> CalendarItem:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_calendar_item(result_info.success)
				return return_value

		async def get_calendar_items_async(self, entity_ids: List[str]) -> List[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_calendar_item(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[CalendarItem]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryAndRecover.getCalendarItemsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [deserialize_calendar_item(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = CalendarItemApi.CalendarItemFlavouredEncryptedApi(self.icure_sdk)
		self.try_and_recover = CalendarItemApi.CalendarItemFlavouredApi(self.icure_sdk)

	async def create_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createCalendarItemAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createCalendarItemBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedCalendarItem], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.withEncryptionMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedCalendarItem], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedCalendarItem:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.withEncryptionMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, calendar_item: CalendarItem) -> List[HexString]:
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
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getEncryptionKeysOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, calendar_item: CalendarItem) -> List[HexString]:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, calendar_item: CalendarItem) -> bool:
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
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.hasWriteAccessAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, calendar_item: CalendarItem) -> bool:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, calendar_item: CalendarItem) -> List[str]:
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
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptPatientIdOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, calendar_item: CalendarItem) -> List[str]:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: CalendarItem, delegates: List[str]) -> None:
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
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: CalendarItem, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def decrypt_async(self, calendar_item: EncryptedCalendarItem) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendarItem": calendar_item.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, calendar_item: EncryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, calendar_item: EncryptedCalendarItem) -> CalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_calendar_item(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendarItem": calendar_item.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryDecryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, calendar_item: EncryptedCalendarItem) -> CalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryDecryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_calendar_item(result_info.success)
			return return_value

	async def match_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> List[str]:
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.matchCalendarItemsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.matchCalendarItemsByBlocking(
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

	async def match_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> List[str]:
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
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.matchCalendarItemsBySortedAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.matchCalendarItemsBySortedBlocking(
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

	async def delete_calendar_item_async(self, entity_id: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.deleteCalendarItemAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_calendar_item_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.deleteCalendarItemBlocking(
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

	async def delete_calendar_items_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.deleteCalendarItemsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_calendar_items_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.deleteCalendarItemsBlocking(
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

	async def share_with_async(self, delegate_id: str, calendar_item: DecryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultDecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result_decrypted_calendar_item(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.shareWithAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, calendar_item: DecryptedCalendarItem, options: Optional[CalendarItemShareOptions] = None) -> SimpleShareResultDecryptedCalendarItem:
		payload = {
			"delegateId": delegate_id,
			"calendarItem": calendar_item.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.shareWithBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result_decrypted_calendar_item(result_info.success)
			return return_value

	async def try_share_with_many_async(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultDecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result_decrypted_calendar_item(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryShareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResultDecryptedCalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.tryShareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result_decrypted_calendar_item(result_info.success)
			return return_value

	async def share_with_many_async(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.shareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.shareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.linkToPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> DecryptedCalendarItem:
		payload = {
			"calendarItem": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"shareLinkWithDelegates": [x0 for x0 in share_link_with_delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.linkToPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def filter_calendar_items_by_async(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedCalendarItem](
					producer = success,
					deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.filterCalendarItemsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_calendar_items_by_blocking(self, filter: FilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.filterCalendarItemsByBlocking(
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
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def filter_calendar_items_by_sorted_async(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedCalendarItem](
					producer = success,
					deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.filterCalendarItemsBySortedAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_calendar_items_by_sorted_blocking(self, filter: SortableFilterOptions[CalendarItem]) -> PaginatedListIterator[DecryptedCalendarItem]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.filterCalendarItemsBySortedBlocking(
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
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = class_pointer,
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def modify_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.modifyCalendarItemAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.modifyCalendarItemBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_calendar_item_async(self, entity_id: str) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedCalendarItem._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getCalendarItemAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_calendar_item_blocking(self, entity_id: str) -> DecryptedCalendarItem:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getCalendarItemBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info.success)
			return return_value

	async def get_calendar_items_async(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedCalendarItem._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getCalendarItemsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getCalendarItemsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info.success]
			return return_value
