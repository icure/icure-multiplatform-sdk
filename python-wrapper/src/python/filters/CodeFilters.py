# auto-generated file
import json
from icure.kotlin_types import symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from icure.model import Code
from typing import List, Optional

class CodeFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Code]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.CodeFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_ids(cls, ids: List[str]) -> BaseSortableFilterOptions[Code]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.CodeFilters.byIds(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseSortableFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_language_type_label_region(cls, language: str, type: str, label: Optional[str] = None, region: Optional[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"language": language,
			"type": type,
			"label": label,
			"region": region,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.filters.CodeFilters.byLanguageTypeLabelRegion(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
