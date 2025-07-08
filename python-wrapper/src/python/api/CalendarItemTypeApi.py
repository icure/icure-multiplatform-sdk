# auto-generated file
import json
from cardinal_sdk.model import CalendarItemType, ListOfIds, DocIdentifier
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional


class CalendarItemTypeApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_calendar_item_type_async(self, calendar_item_type_dto: CalendarItemType) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"calendarItemTypeDto": calendar_item_type_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_calendar_item_type_blocking(self, calendar_item_type_dto: CalendarItemType) -> CalendarItemType:
		payload = {
			"calendarItemTypeDto": calendar_item_type_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.createCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def delete_calendar_item_types_async(self, calendar_item_type_ids: ListOfIds) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"calendarItemTypeIds": calendar_item_type_ids.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_calendar_item_types_blocking(self, calendar_item_type_ids: ListOfIds) -> list[DocIdentifier]:
		payload = {
			"calendarItemTypeIds": calendar_item_type_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.deleteCalendarItemTypesBlocking(
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

	async def get_calendar_item_type_async(self, calendar_item_type_id: str) -> Optional[CalendarItemType]:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"calendarItemTypeId": calendar_item_type_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_calendar_item_type_blocking(self, calendar_item_type_id: str) -> Optional[CalendarItemType]:
		payload = {
			"calendarItemTypeId": calendar_item_type_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.getCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def modify_calendar_item_type_async(self, calendar_item_type_dto: CalendarItemType) -> CalendarItemType:
		def do_decode(raw_result):
			return CalendarItemType._deserialize(raw_result)
		payload = {
			"calendarItemTypeDto": calendar_item_type_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_calendar_item_type_blocking(self, calendar_item_type_dto: CalendarItemType) -> CalendarItemType:
		payload = {
			"calendarItemTypeDto": calendar_item_type_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.modifyCalendarItemTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = CalendarItemType._deserialize(result_info.success)
			return return_value

	async def list_calendar_item_types_by_agenda_id_async(self, agenda_id: str) -> list[CalendarItemType]:
		def do_decode(raw_result):
			return [CalendarItemType._deserialize(x1) for x1 in raw_result]
		payload = {
			"agendaId": agenda_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.listCalendarItemTypesByAgendaIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_calendar_item_types_by_agenda_id_blocking(self, agenda_id: str) -> list[CalendarItemType]:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CalendarItemTypeApi.listCalendarItemTypesByAgendaIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [CalendarItemType._deserialize(x1) for x1 in result_info.success]
			return return_value
