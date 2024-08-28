# auto-generated file
import asyncio
import json
from icure.model import Agenda, ListOfIds, DocIdentifier
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import List
from icure.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from icure.pagination.PaginatedListIterator import PaginatedListIterator

class AgendaApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def create_agenda_async(self, agenda_dto: Agenda) -> Agenda:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Agenda._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.createAgendaAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_agenda_blocking(self, agenda_dto: Agenda) -> Agenda:
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.createAgendaBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
			return return_value

	async def delete_agendas_async(self, agenda_ids: ListOfIds) -> List[DocIdentifier]:
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
			"agendaIds": agenda_ids.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.deleteAgendasAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agendas_blocking(self, agenda_ids: ListOfIds) -> List[DocIdentifier]:
		payload = {
			"agendaIds": agenda_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.deleteAgendasBlocking(
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

	async def delete_agenda_async(self, agenda_id: str) -> DocIdentifier:
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
			"agendaId": agenda_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.deleteAgendaAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agenda_blocking(self, agenda_id: str) -> DocIdentifier:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.deleteAgendaBlocking(
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

	async def get_agenda_async(self, agenda_id: str) -> Agenda:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Agenda._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"agendaId": agenda_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.getAgendaAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_agenda_blocking(self, agenda_id: str) -> Agenda:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.getAgendaBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
			return return_value

	async def get_agendas_async(self, agenda_ids: List[str]) -> List[Agenda]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [Agenda._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"agendaIds": [x0 for x0 in agenda_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.getAgendasAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_agendas_blocking(self, agenda_ids: List[str]) -> List[Agenda]:
		payload = {
			"agendaIds": [x0 for x0 in agenda_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.getAgendasBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [Agenda._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_agenda_async(self, agenda_dto: Agenda) -> Agenda:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Agenda._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.modifyAgendaAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_agenda_blocking(self, agenda_dto: Agenda) -> Agenda:
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.modifyAgendaBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
			return return_value

	async def match_agendas_by_async(self, filter: BaseFilterOptions[Agenda]) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.matchAgendasByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_agendas_by_blocking(self, filter: BaseFilterOptions[Agenda]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.matchAgendasByBlocking(
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

	async def match_agendas_by_sorted_async(self, filter: BaseSortableFilterOptions[Agenda]) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.matchAgendasBySortedAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_agendas_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Agenda]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.matchAgendasBySortedBlocking(
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

	async def filter_agendas_by_async(self, filter: BaseFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[Agenda](
					producer = success,
					deserializer = lambda x: Agenda._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.filterAgendasByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_agendas_by_blocking(self, filter: BaseFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.filterAgendasByBlocking(
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
			return PaginatedListIterator[Agenda](
				producer = class_pointer,
				deserializer = lambda x: Agenda._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def filter_agendas_by_sorted_async(self, filter: BaseSortableFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[Agenda](
					producer = success,
					deserializer = lambda x: Agenda._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.filterAgendasBySortedAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_agendas_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.AgendaApi.filterAgendasBySortedBlocking(
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
			return PaginatedListIterator[Agenda](
				producer = class_pointer,
				deserializer = lambda x: Agenda._deserialize(x),
				executor = self.icure_sdk._executor
			)
