import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from typing import Optional, Dict, List
from model.CallResult import CallResult, create_result_from_json
from model.PaginatedList import PaginatedList
from ctypes import c_char_p
from model.Code import Code
from model.BooleanResponse import BooleanResponse
from model.filter.chain.FilterChain import FilterChain
from model.filter.AbstractFilter import AbstractFilter

class CodeApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createCodeApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def find_codes_by_label_async(self, region: Optional[str], types: str, language: str, label: str, version: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Code._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"types": types,
			"language": language,
			"label": label,
			"version": version,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByLabelAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_codes_by_label_blocking(self, region: Optional[str], types: str, language: str, label: str, version: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"region": region,
			"types": types,
			"language": language,
			"label": label,
			"version": version,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByLabelBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Code._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_codes_by_type_async(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Code._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByTypeAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_codes_by_type_blocking(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByTypeBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Code._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_codes_by_link_async(self, link_type: str, linked_id: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Code._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"link_type": link_type,
			"linked_id": linked_id,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByLinkAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_codes_by_link_blocking(self, link_type: str, linked_id: Optional[str] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"link_type": link_type,
			"linked_id": linked_id,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.findCodesByLinkBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Code._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_codes_by_region_type_code_version_async(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None) -> List[Code]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Code._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_codes_by_region_type_code_version_blocking(self, region: str, type: Optional[str] = None, code: Optional[str] = None, version: Optional[str] = None) -> List[Code]:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_code_types_by_async(self, region: Optional[str] = None, type: Optional[str] = None) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listCodeTypesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_code_types_by_blocking(self, region: Optional[str] = None, type: Optional[str] = None) -> List[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listCodeTypesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def list_tag_types_by_async(self, region: Optional[str] = None, type: Optional[str] = None) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listTagTypesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_tag_types_by_blocking(self, region: Optional[str] = None, type: Optional[str] = None) -> List[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.listTagTypesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def create_code_async(self, c: Code) -> Code:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Code._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"c": c.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.createCodeAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_code_blocking(self, c: Code) -> Code:
		payload = {
			"c": c.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.createCodeBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Code._deserialize(result_info["success"])
			return return_value

	async def create_codes_async(self, code_batch: List[Code]) -> List[Code]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Code._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_batch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.createCodesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_codes_blocking(self, code_batch: List[Code]) -> List[Code]:
		payload = {
			"code_batch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.createCodesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def is_code_valid_async(self, type: str, code: str, version: Optional[str]) -> BooleanResponse:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = BooleanResponse._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.isCodeValidAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def is_code_valid_blocking(self, type: str, code: str, version: Optional[str]) -> BooleanResponse:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.isCodeValidBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = BooleanResponse._deserialize(result_info["success"])
			return return_value

	async def get_code_by_region_language_type_label_async(self, region: str, label: str, type: str, languages: Optional[str]) -> Code:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Code._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_code_by_region_language_type_label_blocking(self, region: str, label: str, type: str, languages: Optional[str]) -> Code:
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Code._deserialize(result_info["success"])
			return return_value

	async def get_codes_async(self, code_ids: List[str]) -> List[Code]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Code._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_ids": [x0 for x0 in code_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_codes_blocking(self, code_ids: List[str]) -> List[Code]:
		payload = {
			"code_ids": [x0 for x0 in code_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_code_async(self, code_id: str) -> Code:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Code._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_id": code_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_code_blocking(self, code_id: str) -> Code:
		payload = {
			"code_id": code_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Code._deserialize(result_info["success"])
			return return_value

	async def get_code_with_parts_async(self, type: str, code: str, version: str) -> Code:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Code._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeWithPartsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_code_with_parts_blocking(self, type: str, code: str, version: str) -> Code:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.getCodeWithPartsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Code._deserialize(result_info["success"])
			return return_value

	async def modify_code_async(self, code_dto: Code) -> Code:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Code._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_dto": code_dto.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.modifyCodeAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_code_blocking(self, code_dto: Code) -> Code:
		payload = {
			"code_dto": code_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.modifyCodeBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Code._deserialize(result_info["success"])
			return return_value

	async def modify_codes_async(self, code_batch: List[Code]) -> List[Code]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Code._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_batch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.modifyCodesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_codes_blocking(self, code_batch: List[Code]) -> List[Code]:
		payload = {
			"code_batch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.modifyCodesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Code._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_codes_by_async(self, filter_chain: FilterChain, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Code._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.filterCodesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_codes_by_blocking(self, filter_chain: FilterChain, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
		payload = {
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.filterCodesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Code._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def match_codes_by_async(self, filter: AbstractFilter) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.matchCodesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def match_codes_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.matchCodesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def import_codes_async(self, code_type: str) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_type": code_type,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.importCodesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def import_codes_blocking(self, code_type: str) -> None:
		payload = {
			"code_type": code_type,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CodeApi.importCodesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

__all__ = ['CodeApi']