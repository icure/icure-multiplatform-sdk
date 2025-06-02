# auto-generated file
import json
from cardinal_sdk.model import MedicalLocation, ListOfIds, DocIdentifier
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class MedicalLocationApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def create_medical_location_async(self, medical_location_dto: MedicalLocation) -> MedicalLocation:
		def do_decode(raw_result):
			return MedicalLocation._deserialize(raw_result)
		payload = {
			"medicalLocationDto": medical_location_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.createMedicalLocationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_medical_location_blocking(self, medical_location_dto: MedicalLocation) -> MedicalLocation:
		payload = {
			"medicalLocationDto": medical_location_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.createMedicalLocationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = MedicalLocation._deserialize(result_info.success)
			return return_value

	async def delete_medical_locations_async(self, location_ids: ListOfIds) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"locationIds": location_ids.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.deleteMedicalLocationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_medical_locations_blocking(self, location_ids: ListOfIds) -> list[DocIdentifier]:
		payload = {
			"locationIds": location_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.deleteMedicalLocationsBlocking(
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

	async def get_medical_location_async(self, location_id: str) -> Optional[MedicalLocation]:
		def do_decode(raw_result):
			return MedicalLocation._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"locationId": location_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.getMedicalLocationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_medical_location_blocking(self, location_id: str) -> Optional[MedicalLocation]:
		payload = {
			"locationId": location_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.getMedicalLocationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = MedicalLocation._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def modify_medical_location_async(self, medical_location_dto: MedicalLocation) -> MedicalLocation:
		def do_decode(raw_result):
			return MedicalLocation._deserialize(raw_result)
		payload = {
			"medicalLocationDto": medical_location_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.modifyMedicalLocationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_medical_location_blocking(self, medical_location_dto: MedicalLocation) -> MedicalLocation:
		payload = {
			"medicalLocationDto": medical_location_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.modifyMedicalLocationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = MedicalLocation._deserialize(result_info.success)
			return return_value

	async def get_medical_locations_async(self, medical_location_ids: list[str]) -> list[MedicalLocation]:
		def do_decode(raw_result):
			return [MedicalLocation._deserialize(x1) for x1 in raw_result]
		payload = {
			"medicalLocationIds": [x0 for x0 in medical_location_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.getMedicalLocationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_medical_locations_blocking(self, medical_location_ids: list[str]) -> list[MedicalLocation]:
		payload = {
			"medicalLocationIds": [x0 for x0 in medical_location_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.getMedicalLocationsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [MedicalLocation._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def match_medical_locations_by_async(self, filter: BaseFilterOptions[MedicalLocation]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.matchMedicalLocationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_medical_locations_by_blocking(self, filter: BaseFilterOptions[MedicalLocation]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.matchMedicalLocationsByBlocking(
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

	async def match_medical_locations_by_sorted_async(self, filter: BaseSortableFilterOptions[MedicalLocation]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.matchMedicalLocationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_medical_locations_by_sorted_blocking(self, filter: BaseSortableFilterOptions[MedicalLocation]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.matchMedicalLocationsBySortedBlocking(
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

	async def filter_medical_locations_by_async(self, filter: BaseFilterOptions[MedicalLocation]) -> PaginatedListIterator[MedicalLocation]:
		def do_decode(raw_result):
			return PaginatedListIterator[MedicalLocation](
				producer = raw_result,
				deserializer = lambda x: MedicalLocation._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.filterMedicalLocationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_medical_locations_by_blocking(self, filter: BaseFilterOptions[MedicalLocation]) -> PaginatedListIterator[MedicalLocation]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.filterMedicalLocationsByBlocking(
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
			return PaginatedListIterator[MedicalLocation](
				producer = class_pointer,
				deserializer = lambda x: MedicalLocation._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_medical_locations_by_sorted_async(self, filter: BaseSortableFilterOptions[MedicalLocation]) -> PaginatedListIterator[MedicalLocation]:
		def do_decode(raw_result):
			return PaginatedListIterator[MedicalLocation](
				producer = raw_result,
				deserializer = lambda x: MedicalLocation._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.filterMedicalLocationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_medical_locations_by_sorted_blocking(self, filter: BaseSortableFilterOptions[MedicalLocation]) -> PaginatedListIterator[MedicalLocation]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.MedicalLocationApi.filterMedicalLocationsBySortedBlocking(
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
			return PaginatedListIterator[MedicalLocation](
				producer = class_pointer,
				deserializer = lambda x: MedicalLocation._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
