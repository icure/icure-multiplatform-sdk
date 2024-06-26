import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model.HealthcareParty import HealthcareParty
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from model.couchdb.DocIdentifier import DocIdentifier
from typing import Optional, List
from model.PaginatedList import PaginatedList
from model.PublicKey import PublicKey
from model.filter.AbstractFilter import AbstractFilter, serialize_abstract_filter
from model.filter.chain.FilterChain import FilterChain
from model.DataOwnerRegistrationSuccess import DataOwnerRegistrationSuccess

class HealthcarePartyApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_healthcare_party_async(self, device_id: str) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"device_id": device_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_healthcare_party_blocking(self, device_id: str) -> HealthcareParty:
		payload = {
			"device_id": device_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def create_healthcare_party_async(self, p: HealthcareParty) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"p": p.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.createHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_healthcare_party_blocking(self, p: HealthcareParty) -> HealthcareParty:
		payload = {
			"p": p.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.createHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def delete_healthcare_party_async(self, device_id: str) -> DocIdentifier:
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
			"device_id": device_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_healthcare_party_blocking(self, device_id: str) -> DocIdentifier:
		payload = {
			"device_id": device_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def modify_healthcare_party_in_group_async(self, group_id: str, device: HealthcareParty) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_healthcare_party_in_group_blocking(self, group_id: str, device: HealthcareParty) -> HealthcareParty:
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def create_healthcare_party_in_group_async(self, group_id: str, device: HealthcareParty) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.createHealthcarePartyInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_healthcare_party_in_group_blocking(self, group_id: str, device: HealthcareParty) -> HealthcareParty:
		payload = {
			"group_id": group_id,
			"device": device.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.createHealthcarePartyInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def get_current_healthcare_party_async(self) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getCurrentHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_healthcare_party_blocking(self) -> HealthcareParty:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getCurrentHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def find_healthcare_parties_by_async(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [HealthcareParty._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_healthcare_parties_by_blocking(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: Optional[bool] = None) -> PaginatedList:
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [HealthcareParty._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def find_healthcare_parties_by_name_async(self, name: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [HealthcareParty._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"name": name,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesByNameAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_healthcare_parties_by_name_blocking(self, name: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: Optional[bool] = None) -> PaginatedList:
		payload = {
			"name": name,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesByNameBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [HealthcareParty._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def find_healthcare_parties_by_ssin_or_nihii_async(self, search_value: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: bool = False) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [HealthcareParty._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"search_value": search_value,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesBySsinOrNihiiAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_healthcare_parties_by_ssin_or_nihii_blocking(self, search_value: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, desc: bool = False) -> PaginatedList:
		payload = {
			"search_value": search_value,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"desc": desc,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesBySsinOrNihiiBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [HealthcareParty._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_healthcare_parties_by_name_async(self, name: str) -> List[HealthcareParty]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [HealthcareParty._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"name": name,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.listHealthcarePartiesByNameAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_healthcare_parties_by_name_blocking(self, name: str) -> List[HealthcareParty]:
		payload = {
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.listHealthcarePartiesByNameBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_healthcare_parties_by_speciality_and_post_code_async(self, type: str, spec: str, first_code: str, last_code: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [HealthcareParty._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"spec": spec,
			"first_code": first_code,
			"last_code": last_code,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesBySpecialityAndPostCodeAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_healthcare_parties_by_speciality_and_post_code_blocking(self, type: str, spec: str, first_code: str, last_code: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"type": type,
			"spec": spec,
			"first_code": first_code,
			"last_code": last_code,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.findHealthcarePartiesBySpecialityAndPostCodeBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [HealthcareParty._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def get_healthcare_parties_async(self, healthcare_party_ids: List[str]) -> List[HealthcareParty]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [HealthcareParty._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_healthcare_parties_blocking(self, healthcare_party_ids: List[str]) -> List[HealthcareParty]:
		payload = {
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_healthcare_parties_by_parent_id_async(self, parent_id: str) -> List[HealthcareParty]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [HealthcareParty._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"parent_id": parent_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.listHealthcarePartiesByParentIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_healthcare_parties_by_parent_id_blocking(self, parent_id: str) -> List[HealthcareParty]:
		payload = {
			"parent_id": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.listHealthcarePartiesByParentIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_public_key_async(self, healthcare_party_id: str) -> PublicKey:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PublicKey._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_id": healthcare_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getPublicKeyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_public_key_blocking(self, healthcare_party_id: str) -> PublicKey:
		payload = {
			"healthcare_party_id": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getPublicKeyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PublicKey._deserialize(result_info["success"])
			return return_value

	async def delete_healthcare_parties_async(self, healthcare_party_ids: List[str]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_healthcare_parties_blocking(self, healthcare_party_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_healthcare_party_async(self, healthcare_party_dto: HealthcareParty) -> HealthcareParty:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = HealthcareParty._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_dto": healthcare_party_dto.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_healthcare_party_blocking(self, healthcare_party_dto: HealthcareParty) -> HealthcareParty:
		payload = {
			"healthcare_party_dto": healthcare_party_dto.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.modifyHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = HealthcareParty._deserialize(result_info["success"])
			return return_value

	async def match_healthcare_parties_by_async(self, filter: AbstractFilter) -> List[str]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_healthcare_parties_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.matchHealthcarePartiesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def filter_health_parties_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [HealthcareParty._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.filterHealthPartiesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_health_parties_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.filterHealthPartiesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [HealthcareParty._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def get_healthcare_parties_in_group_async(self, group_id: str, healthcare_party_ids: Optional[List[str]] = None) -> List[HealthcareParty]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [HealthcareParty._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids] if healthcare_party_ids is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_healthcare_parties_in_group_blocking(self, group_id: str, healthcare_party_ids: Optional[List[str]] = None) -> List[HealthcareParty]:
		payload = {
			"group_id": group_id,
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids] if healthcare_party_ids is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.getHealthcarePartiesInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [HealthcareParty._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def delete_healthcare_parties_in_group_async(self, group_id: str, healthcare_party_ids: List[str]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_healthcare_parties_in_group_blocking(self, group_id: str, healthcare_party_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"group_id": group_id,
			"healthcare_party_ids": [x0 for x0 in healthcare_party_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartiesInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def delete_healthcare_party_in_group_async(self, healthcare_party_id: str, group_id: str) -> DocIdentifier:
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
			"healthcare_party_id": healthcare_party_id,
			"group_id": group_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyInGroupAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_healthcare_party_in_group_blocking(self, healthcare_party_id: str, group_id: str) -> DocIdentifier:
		payload = {
			"healthcare_party_id": healthcare_party_id,
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.deleteHealthcarePartyInGroupBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def register_patient_async(self, group_id: str, hcp: HealthcareParty, parent_hc_party_id: Optional[str] = None, token: Optional[str] = None, use_short_token: Optional[bool] = None) -> DataOwnerRegistrationSuccess:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DataOwnerRegistrationSuccess._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"parent_hc_party_id": parent_hc_party_id,
			"token": token,
			"use_short_token": use_short_token,
			"hcp": hcp.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.registerPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def register_patient_blocking(self, group_id: str, hcp: HealthcareParty, parent_hc_party_id: Optional[str] = None, token: Optional[str] = None, use_short_token: Optional[bool] = None) -> DataOwnerRegistrationSuccess:
		payload = {
			"group_id": group_id,
			"parent_hc_party_id": parent_hc_party_id,
			"token": token,
			"use_short_token": use_short_token,
			"hcp": hcp.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.HealthcarePartyApi.registerPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DataOwnerRegistrationSuccess._deserialize(result_info["success"])
			return return_value

__all__ = ['HealthcarePartyApi']