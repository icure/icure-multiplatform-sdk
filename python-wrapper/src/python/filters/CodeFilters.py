# auto-generated file
import json
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Code
from List import typing
from Optional import typing


class CodeFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Code]:
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.all(
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_ids(cls, ids: typing[str]) -> BaseSortableFilterOptions[Code]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byIds(
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
	def by_qualified_link(cls, link_type: str, linked_id: typing[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"linkType": link_type,
			"linkedId": linked_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byQualifiedLink(
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
	def by_region_type_code_version(cls, region: str, type: typing[str] = None, code: typing[str] = None, version: typing[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byRegionTypeCodeVersion(
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
	def by_language_type_label_region(cls, language: str, type: str, label: typing[str] = None, region: typing[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"language": language,
			"type": type,
			"label": label,
			"region": region,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byLanguageTypeLabelRegion(
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
	def by_language_types_label_region_version(cls, language: str, types: typing[str], label: str, region: typing[str] = None, version: typing[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"language": language,
			"types": [x0 for x0 in types],
			"label": label,
			"region": region,
			"version": version,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byLanguageTypesLabelRegionVersion(
			json.dumps(payload).encode('utf-8')
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
