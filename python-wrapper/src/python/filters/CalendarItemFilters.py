# auto-generated file
import json
from typing import List, Optional
from cardinal_sdk.model import Patient, serialize_patient, CalendarItem
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions, BaseFilterOptions, FilterOptions


class CalendarItemFilters:

	@classmethod
	def by_patients_start_time_for_data_owner(cls, data_owner_id: str, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientsStartTimeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_start_time_for_self(cls, patients: List[Patient], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"patients": [serialize_patient(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientsStartTimeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_start_time_for_data_owner(cls, data_owner_id: str, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[CalendarItem]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_start_time_for_self(cls, secret_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_period_and_agenda(cls, agenda_id: str, from_: int, to: int, descending: bool = False) -> BaseSortableFilterOptions[CalendarItem]:
		payload = {
			"agendaId": agenda_id,
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodAndAgenda(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_period_for_data_owner(cls, data_owner_id: str, from_: int, to: int) -> BaseFilterOptions[CalendarItem]:
		payload = {
			"dataOwnerId": data_owner_id,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_period_for_self(cls, from_: int, to: int) -> FilterOptions[CalendarItem]:
		payload = {
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_recurrence_id(cls, recurrence_id: str) -> FilterOptions[CalendarItem]:
		payload = {
			"recurrenceId": recurrence_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byRecurrenceId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
