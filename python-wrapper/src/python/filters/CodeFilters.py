# auto-generated file
import json
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Code
from typing import List, Optional


class CodeFilters:

	@classmethod
	def all(cls) -> BaseFilterOptions[Code]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.all(
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value

	@classmethod
	def by_ids(cls, ids: List[str]) -> BaseSortableFilterOptions[Code]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byIds(
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
	def by_qualified_link(cls, link_type: str, linked_id: Optional[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"linkType": link_type,
			"linkedId": linked_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byQualifiedLink(
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
	def by_region_type_code_version(cls, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byRegionTypeCodeVersion(
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
	def by_language_type_label_region(cls, language: str, type: str, label: Optional[str] = None, region: Optional[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"language": language,
			"type": type,
			"label": label,
			"region": region,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byLanguageTypeLabelRegion(
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
	def by_language_types_label_region_version(cls, language: str, types: List[str], label: str, region: Optional[str] = None, version: Optional[str] = None) -> BaseFilterOptions[Code]:
		payload = {
			"language": language,
			"types": [x0 for x0 in types],
			"label": label,
			"region": region,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.filters.CodeFilters.byLanguageTypesLabelRegionVersion(
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BaseFilterOptions(result_info.success)
			return return_value
