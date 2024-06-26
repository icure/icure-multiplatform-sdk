import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.Tarification import Tarification
from ctypes import c_char_p
from typing import List, Optional
from model.PaginatedList import PaginatedList

class TarificationApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createTarificationApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_tarification_async(self, tarification_id: str) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Tarification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification_id": tarification_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_tarification_blocking(self, tarification_id: str) -> Tarification:
		payload = {
			"tarification_id": tarification_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Tarification._deserialize(result_info["success"])
			return return_value

	async def create_tarification_async(self, tarification: Tarification) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Tarification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification": tarification.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.createTarificationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_tarification_blocking(self, tarification: Tarification) -> Tarification:
		payload = {
			"tarification": tarification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.createTarificationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Tarification._deserialize(result_info["success"])
			return return_value

	async def get_tarifications_async(self, tarification_ids: List[str]) -> List[Tarification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Tarification._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification_ids": [x0 for x0 in tarification_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_tarifications_blocking(self, tarification_ids: List[str]) -> List[Tarification]:
		payload = {
			"tarification_ids": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Tarification._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_tarification_async(self, tarification: Tarification) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Tarification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"tarification": tarification.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.modifyTarificationAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_tarification_blocking(self, tarification: Tarification) -> Tarification:
		payload = {
			"tarification": tarification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.modifyTarificationBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Tarification._deserialize(result_info["success"])
			return return_value

	async def find_tarifications_by_label_async(self, region: Optional[str] = None, types: Optional[str] = None, language: Optional[str] = None, label: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Tarification._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"types": types,
			"language": language,
			"label": label,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.findTarificationsByLabelAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_tarifications_by_label_blocking(self, region: Optional[str] = None, types: Optional[str] = None, language: Optional[str] = None, label: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"region": region,
			"types": types,
			"language": language,
			"label": label,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.findTarificationsByLabelBlocking(
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
				rows = [Tarification._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_tarifications_by_async(self, region: Optional[str] = None, type: Optional[str] = None, tarification: Optional[str] = None, version: Optional[str] = None, start_document_id: Optional[str] = None, start_key: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Tarification._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"region": region,
			"type": type,
			"tarification": tarification,
			"version": version,
			"start_document_id": start_document_id,
			"start_key": start_key,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.findTarificationsByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_tarifications_by_blocking(self, region: Optional[str] = None, type: Optional[str] = None, tarification: Optional[str] = None, version: Optional[str] = None, start_document_id: Optional[str] = None, start_key: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"region": region,
			"type": type,
			"tarification": tarification,
			"version": version,
			"start_document_id": start_document_id,
			"start_key": start_key,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.findTarificationsByBlocking(
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
				rows = [Tarification._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def get_tarification_with_parts_async(self, type: str, tarification: str, version: str) -> Tarification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Tarification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"tarification": tarification,
			"version": version,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationWithPartsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_tarification_with_parts_blocking(self, type: str, tarification: str, version: str) -> Tarification:
		payload = {
			"type": type,
			"tarification": tarification,
			"version": version,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TarificationApi.getTarificationWithPartsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Tarification._deserialize(result_info["success"])
			return return_value

__all__ = ['TarificationApi']