# auto-generated file
import asyncio
import json
from cardinal_sdk.model import Agenda, DocIdentifier, IdWithMandatoryRev
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import List
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class AgendaApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.createAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_agenda_blocking(self, agenda_dto: Agenda) -> Agenda:
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.createAgendaBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
			return return_value

	async def delete_agenda_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendaByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agenda_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendaByIdBlocking(
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

	async def delete_agendas_by_ids_async(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendasByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agendas_by_ids_blocking(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendasByIdsBlocking(
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

	async def purge_agenda_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.purgeAgendaByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_agenda_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.purgeAgendaByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def undelete_agenda_by_id_async(self, id: str, rev: str) -> Agenda:
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
			"id": id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.undeleteAgendaByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_agenda_by_id_blocking(self, id: str, rev: str) -> Agenda:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.undeleteAgendaByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
			return return_value

	async def delete_agenda_async(self, agenda: Agenda) -> DocIdentifier:
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
			"agenda": agenda.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agenda_blocking(self, agenda: Agenda) -> DocIdentifier:
		payload = {
			"agenda": agenda.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendaBlocking(
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

	async def delete_agendas_async(self, agendas: List[Agenda]) -> List[DocIdentifier]:
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
			"agendas": [x0.__serialize__() for x0 in agendas],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendasAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_agendas_blocking(self, agendas: List[Agenda]) -> List[DocIdentifier]:
		payload = {
			"agendas": [x0.__serialize__() for x0 in agendas],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.deleteAgendasBlocking(
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

	async def purge_agenda_async(self, agenda: Agenda) -> None:
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
			"agenda": agenda.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.purgeAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_agenda_blocking(self, agenda: Agenda) -> None:
		payload = {
			"agenda": agenda.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.purgeAgendaBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def undelete_agenda_async(self, agenda: Agenda) -> Agenda:
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
			"agenda": agenda.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.undeleteAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_agenda_blocking(self, agenda: Agenda) -> Agenda:
		payload = {
			"agenda": agenda.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.undeleteAgendaBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Agenda._deserialize(result_info.success)
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.getAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_agenda_blocking(self, agenda_id: str) -> Agenda:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.getAgendaBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.getAgendasAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_agendas_blocking(self, agenda_ids: List[str]) -> List[Agenda]:
		payload = {
			"agendaIds": [x0 for x0 in agenda_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.getAgendasBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.modifyAgendaAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_agenda_blocking(self, agenda_dto: Agenda) -> Agenda:
		payload = {
			"agendaDto": agenda_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.modifyAgendaBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.matchAgendasByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_agendas_by_blocking(self, filter: BaseFilterOptions[Agenda]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.matchAgendasByBlocking(
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.matchAgendasBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_agendas_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Agenda]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.matchAgendasBySortedBlocking(
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
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.filterAgendasByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_agendas_by_blocking(self, filter: BaseFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.filterAgendasByBlocking(
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
			return PaginatedListIterator[Agenda](
				producer = class_pointer,
				deserializer = lambda x: Agenda._deserialize(x),
				executor = self.cardinal_sdk._executor
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
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.filterAgendasBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_agendas_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Agenda]) -> PaginatedListIterator[Agenda]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.AgendaApi.filterAgendasBySortedBlocking(
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
			return PaginatedListIterator[Agenda](
				producer = class_pointer,
				deserializer = lambda x: Agenda._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
