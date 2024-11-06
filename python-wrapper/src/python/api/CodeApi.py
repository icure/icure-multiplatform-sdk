# auto-generated file
import asyncio
import json
from Optional import typing
from Code import cardinal_sdk.model
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from symbols import cardinal_sdk.kotlin_types
from List import typing
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from BooleanResponse import cardinal_sdk.model
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from PaginatedListIterator import cardinal_sdk.pagination.PaginatedListIterator
from PTR_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types


class CodeApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def list_codes_by_region_type_code_version_async(self, region: str, type: typing[str] = None, code: typing[str] = None, version: typing[str] = None) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_codes_by_region_type_code_version_blocking(self, region: str, type: typing[str] = None, code: typing[str] = None, version: typing[str] = None) -> typing[cardinal_sdk.model]:
		payload = {
			"region": region,
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodesByRegionTypeCodeVersionBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_code_types_by_async(self, region: typing[str] = None, type: typing[str] = None) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodeTypesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_code_types_by_blocking(self, region: typing[str] = None, type: typing[str] = None) -> typing[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listCodeTypesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def list_tag_types_by_async(self, region: typing[str] = None, type: typing[str] = None) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listTagTypesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_tag_types_by_blocking(self, region: typing[str] = None, type: typing[str] = None) -> typing[str]:
		payload = {
			"region": region,
			"type": type,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.listTagTypesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_code_async(self, c: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"c": c.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_code_blocking(self, c: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"c": c.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def create_codes_async(self, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_codes_blocking(self, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_codes_in_group_async(self, group_id: str, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_codes_in_group_blocking(self, group_id: str, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.createCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def is_code_valid_async(self, type: str, code: str, version: typing[str]) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.isCodeValidAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def is_code_valid_blocking(self, type: str, code: str, version: typing[str]) -> cardinal_sdk.model:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.isCodeValidBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_code_by_region_language_type_label_async(self, region: str, label: str, type: str, languages: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8'))) if json.loads(success.decode('utf-8')) is not None else None
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_code_by_region_language_type_label_blocking(self, region: str, label: str, type: str, languages: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"region": region,
			"label": label,
			"type": type,
			"languages": languages,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeByRegionLanguageTypeLabelBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_codes_async(self, code_ids: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeIds": [x0 for x0 in code_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_codes_blocking(self, code_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"codeIds": [x0 for x0 in code_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_codes_in_group_async(self, group_id: str, code_ids: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"groupId": group_id,
			"codeIds": [x0 for x0 in code_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_codes_in_group_blocking(self, group_id: str, code_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"groupId": group_id,
			"codeIds": [x0 for x0 in code_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_code_async(self, code_id: str) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeId": code_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_code_blocking(self, code_id: str) -> cardinal_sdk.model:
		payload = {
			"codeId": code_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_code_with_parts_async(self, type: str, code: str, version: str) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeWithPartsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_code_with_parts_blocking(self, type: str, code: str, version: str) -> cardinal_sdk.model:
		payload = {
			"type": type,
			"code": code,
			"version": version,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.getCodeWithPartsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def modify_code_async(self, code_dto: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeDto": code_dto.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_code_blocking(self, code_dto: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"codeDto": code_dto.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def modify_codes_async(self, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_codes_blocking(self, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_codes_in_group_async(self, group_id: str, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_codes_in_group_blocking(self, group_id: str, code_batch: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"groupId": group_id,
			"codeBatch": [x0.__serialize__() for x0 in code_batch],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.modifyCodesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def filter_codes_by_async(self, filter: BaseFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_codes_by_blocking(self, filter: BaseFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_codes_by_sorted_async(self, filter: BaseSortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_codes_by_sorted_blocking(self, filter: BaseSortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.filterCodesBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_codes_by_async(self, filter: BaseFilterOptions[cardinal_sdk.model]) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_codes_by_blocking(self, filter: BaseFilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_codes_by_sorted_async(self, filter: BaseSortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_codes_by_sorted_blocking(self, filter: BaseSortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.matchCodesBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def import_codes_async(self, code_type: str) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeType": code_type,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.importCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def import_codes_blocking(self, code_type: str) -> None:
		payload = {
			"codeType": code_type,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.CodeApi.importCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
