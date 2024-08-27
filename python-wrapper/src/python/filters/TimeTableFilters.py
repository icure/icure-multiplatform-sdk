# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from icure.model import TimeTable
from typing import Optional

class TimeTableFilters:

	@classmethod
	def by_agenda_id(cls, agenda_id: str) -> BaseFilterOptions[TimeTable]:
		payload = {
			"agendaId": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.TimeTableFilters.byAgendaId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_period_and_agenda_id(cls, agenda_id: str, from_: Optional[int] = None, to: Optional[int] = None, descending: bool = False) -> BaseSortableFilterOptions[TimeTable]:
		payload = {
			"agendaId": agenda_id,
			"from": from_,
			"to": to,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.TimeTableFilters.byPeriodAndAgendaId(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
