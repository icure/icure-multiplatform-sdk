import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.Insurance import Insurance
from ctypes import c_char_p
from typing import List, Optional
from model.couchdb.DocIdentifier import DocIdentifier
from model.PaginatedList import PaginatedList

class InsuranceApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createInsuranceApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_insurance_async(self, insurance_id: str) -> Insurance:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Insurance._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance_id": insurance_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getInsuranceAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_insurance_blocking(self, insurance_id: str) -> Insurance:
		payload = {
			"insurance_id": insurance_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getInsuranceBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Insurance._deserialize(result_info["success"])
			return return_value

	async def get_insurances_async(self, insurance_ids: List[str]) -> List[Insurance]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Insurance._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance_ids": [x0 for x0 in insurance_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getInsurancesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_insurances_blocking(self, insurance_ids: List[str]) -> List[Insurance]:
		payload = {
			"insurance_ids": [x0 for x0 in insurance_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getInsurancesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def create_insurance_async(self, insurance: Insurance) -> Insurance:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Insurance._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance": insurance.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.createInsuranceAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_insurance_blocking(self, insurance: Insurance) -> Insurance:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.createInsuranceBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Insurance._deserialize(result_info["success"])
			return return_value

	async def delete_insurance_async(self, insurance_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocIdentifier._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance_id": insurance_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.deleteInsuranceAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_insurance_blocking(self, insurance_id: str) -> DocIdentifier:
		payload = {
			"insurance_id": insurance_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.deleteInsuranceBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def get_all_insurances_async(self, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Insurance._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getAllInsurancesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_all_insurances_blocking(self, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.getAllInsurancesBlocking(
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
				rows = [Insurance._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_insurances_by_code_async(self, insurance_code: str) -> List[Insurance]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Insurance._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance_code": insurance_code,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.listInsurancesByCodeAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_insurances_by_code_blocking(self, insurance_code: str) -> List[Insurance]:
		payload = {
			"insurance_code": insurance_code,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.listInsurancesByCodeBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_insurances_by_name_async(self, insurance_name: str) -> List[Insurance]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Insurance._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance_name": insurance_name,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.listInsurancesByNameAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_insurances_by_name_blocking(self, insurance_name: str) -> List[Insurance]:
		payload = {
			"insurance_name": insurance_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.listInsurancesByNameBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Insurance._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_insurance_async(self, insurance: Insurance) -> Insurance:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Insurance._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"insurance": insurance.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.modifyInsuranceAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_insurance_blocking(self, insurance: Insurance) -> Insurance:
		payload = {
			"insurance": insurance.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InsuranceApi.modifyInsuranceBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Insurance._deserialize(result_info["success"])
			return return_value

__all__ = ['InsuranceApi']