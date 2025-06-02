# auto-generated file
import json
from typing import Optional
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import Code, BooleanResponse
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class CodeApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def list_codes_by_region_type_code_version_async(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_codes_by_region_type_code_version_blocking(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None) -> list[Code]:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_code_types_by_async(self, region: Optional[str] = None, type: Optional[str] = None) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"region": region,
			"type": type,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodeTypesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_code_types_by_blocking(self, region: Optional[str] = None, type: Optional[str] = None) -> list[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodeTypesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def list_tag_types_by_async(self, region: Optional[str] = None, type: Optional[str] = None) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"region": region,
			"type": type,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listTagTypesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_tag_types_by_blocking(self, region: Optional[str] = None, type: Optional[str] = None) -> list[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listTagTypesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_code_async(self, c: Code) -> Code:
		def do_decode(raw_result):
			return Code._deserialize(raw_result)
		payload = {
			"c": c.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_code_blocking(self, c: Code) -> Code:
		payload = {
			"c": c.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Code._deserialize(result_info.success)
			return return_value

	async def create_codes_async(self, code_batch: list[Code]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_codes_blocking(self, code_batch: list[Code]) -> list[Code]:
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_codes_in_group_async(self, group_id: str, code_batch: list[Code]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_codes_in_group_blocking(self, group_id: str, code_batch: list[Code]) -> list[Code]:
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def is_code_valid_async(self, type: str, code: str, version: Optional[str]) -> BooleanResponse:
		def do_decode(raw_result):
			return BooleanResponse._deserialize(raw_result)
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.isCodeValidAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def is_code_valid_blocking(self, type: str, code: str, version: Optional[str]) -> BooleanResponse:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.isCodeValidBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = BooleanResponse._deserialize(result_info.success)
			return return_value

	async def get_code_by_region_language_type_label_async(self, region: str, label: str, type: str, languages: Optional[str]) -> Optional[Code]:
		def do_decode(raw_result):
			return Code._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_code_by_region_language_type_label_blocking(self, region: str, label: str, type: str, languages: Optional[str]) -> Optional[Code]:
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Code._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_codes_async(self, code_ids: list[str]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"codeIds": [x0 for x0 in code_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_codes_blocking(self, code_ids: list[str]) -> list[Code]:
		payload = {
			"codeIds": [x0 for x0 in code_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_codes_in_group_async(self, group_id: str, code_ids: list[str]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"codeIds": [x0 for x0 in code_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_codes_in_group_blocking(self, group_id: str, code_ids: list[str]) -> list[Code]:
		payload = {
			"groupId": group_id,
			"codeIds": [x0 for x0 in code_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_code_async(self, code_id: str) -> Optional[Code]:
		def do_decode(raw_result):
			return Code._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"codeId": code_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_code_blocking(self, code_id: str) -> Optional[Code]:
		payload = {
			"codeId": code_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Code._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_code_with_parts_async(self, type: str, code: str, version: str) -> Optional[Code]:
		def do_decode(raw_result):
			return Code._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeWithPartsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_code_with_parts_blocking(self, type: str, code: str, version: str) -> Optional[Code]:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeWithPartsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Code._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def modify_code_async(self, code_dto: Code) -> Code:
		def do_decode(raw_result):
			return Code._deserialize(raw_result)
		payload = {
			"codeDto": code_dto.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_code_blocking(self, code_dto: Code) -> Code:
		payload = {
			"codeDto": code_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Code._deserialize(result_info.success)
			return return_value

	async def modify_codes_async(self, code_batch: list[Code]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_codes_blocking(self, code_batch: list[Code]) -> list[Code]:
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_codes_in_group_async(self, group_id: str, code_batch: list[Code]) -> list[Code]:
		def do_decode(raw_result):
			return [Code._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_codes_in_group_blocking(self, group_id: str, code_batch: list[Code]) -> list[Code]:
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def filter_codes_by_async(self, filter: BaseFilterOptions[Code]) -> PaginatedListIterator[Code]:
		def do_decode(raw_result):
			return PaginatedListIterator[Code](
				producer = raw_result,
				deserializer = lambda x: Code._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_codes_by_blocking(self, filter: BaseFilterOptions[Code]) -> PaginatedListIterator[Code]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Code](
				producer = class_pointer,
				deserializer = lambda x: Code._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_codes_by_sorted_async(self, filter: BaseSortableFilterOptions[Code]) -> PaginatedListIterator[Code]:
		def do_decode(raw_result):
			return PaginatedListIterator[Code](
				producer = raw_result,
				deserializer = lambda x: Code._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_codes_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Code]) -> PaginatedListIterator[Code]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[Code](
				producer = class_pointer,
				deserializer = lambda x: Code._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_codes_by_async(self, filter: BaseFilterOptions[Code]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_codes_by_blocking(self, filter: BaseFilterOptions[Code]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_codes_by_sorted_async(self, filter: BaseSortableFilterOptions[Code]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_codes_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Code]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def import_codes_async(self, code_type: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"codeType": code_type,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.importCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def import_codes_blocking(self, code_type: str) -> None:
		payload = {
			"codeType": code_type,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.importCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
