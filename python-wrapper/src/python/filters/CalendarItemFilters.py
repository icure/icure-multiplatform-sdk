# auto-generated file
import json
from List import typing
from cardinal_sdk.model import Patient, CalendarItem
from Optional import typing
from serialize_patient import cardinal_sdk.model
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import SortableFilterOptions, BaseSortableFilterOptions, BaseFilterOptions, FilterOptions


class CalendarItemFilters:

	@classmethod
	def by_patients_start_time_for_data_owner(cls, data_owner_id: str, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"dataOwnerId": data_owner_id,
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientsStartTimeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patients_start_time_for_self(cls, patients: typing[Patient], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"patients": [cardinal_sdk.model(x0) for x0 in patients],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientsStartTimeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = SortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_start_time_for_data_owner(cls, data_owner_id: str, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[CalendarItem]:
		payload = {
			"dataOwnerId": data_owner_id,
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_patient_secret_ids_start_time_for_self(cls, secret_ids: typing[str], from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> SortableFilterOptions[CalendarItem]:
		payload = {
			"secretIds": [x0 for x0 in secret_ids],
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPatientSecretIdsStartTimeForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
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
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodAndAgenda(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
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
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodForDataOwner(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_period_for_self(cls, from_: int, to: int) -> FilterOptions[CalendarItem]:
		payload = {
			"from": from_,
			"to": to,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byPeriodForSelf(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_recurrence_id(cls, recurrence_id: str) -> FilterOptions[CalendarItem]:
		payload = {
			"recurrenceId": recurrence_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CalendarItemFilters.byRecurrenceId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = FilterOptions(result_info.success)
			return return_value
