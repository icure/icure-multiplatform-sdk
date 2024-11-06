# auto-generated file
import json
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions
from cardinal_sdk.model import MedicalLocation


class MedicalLocationFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[MedicalLocation]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.MedicalLocationFilters.all(
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_post_code(cls, post_code: str) -> BaseFilterOptions[MedicalLocation]:
		payload = {
			"postCode": post_code,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.MedicalLocationFilters.byPostCode(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
