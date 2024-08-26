# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from icure.model import Group

class GroupFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Group]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.GroupFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_super_group(cls, super_group_id: str) -> BaseFilterOptions[Group]:
		payload = {
			"superGroupId": super_group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.GroupFilters.bySuperGroup(
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
	def with_content(cls, super_group_id: str, search_string: str) -> BaseSortableFilterOptions[Group]:
		payload = {
			"superGroupId": super_group_id,
			"searchString": search_string,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.GroupFilters.withContent(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value
