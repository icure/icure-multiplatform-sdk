# auto-generated file
import json
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import TimeTable
from Optional import typing


class TimeTableFilters:

	@classmethod
	def by_agenda_id(cls, agenda_id: str) -> BaseFilterOptions[TimeTable]:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.TimeTableFilters.byAgendaId(
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
	def by_period_and_agenda_id(cls, agenda_id: str, from_: typing[int] = None, to: typing[int] = None, descending: bool = False) -> BaseSortableFilterOptions[TimeTable]:
		payload = {
			"agendaId": agenda_id,
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.TimeTableFilters.byPeriodAndAgendaId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
