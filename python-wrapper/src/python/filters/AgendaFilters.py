# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions
from cardinal_sdk.model import Agenda

class AgendaFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Agenda]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_user(cls, user_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.byUser(
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
	def readable_by_user(cls, user_id: str) -> BaseFilterOptions[Agenda]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.AgendaFilters.readableByUser(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
