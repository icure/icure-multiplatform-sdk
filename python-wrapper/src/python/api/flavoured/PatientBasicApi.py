import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.filter.AbstractFilter import AbstractFilter
from model.CallResult import CallResult, create_result_from_json
from typing import List, Optional, Dict
from ctypes import c_char_p
from model.couchdb.DocIdentifier import DocIdentifier
from model.Patient import Patient, EncryptedPatient
from crypto.entities.EntityAccessInformation import EntityAccessInformation
from model.filter.chain.FilterChain import FilterChain
from model.PaginatedList import PaginatedList
from model.couchdb.SortDirection import SortDirection
from model.embed.Content import EncryptedContent
from model.ListOfIds import ListOfIds
from model.IdWithRev import IdWithRev

class PatientBasicApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createPatientBasicApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def match_patients_by_async(self, filter: AbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.matchPatientsByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def match_patients_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.matchPatientsByBlocking(
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

	async def delete_patient_async(self, entity_id: str) -> DocIdentifier:
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
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.deletePatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_patient_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.deletePatientBlocking(
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

	async def delete_patients_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.deletePatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_patients_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.deletePatientsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def undelete_patient_async(self, patient_ids: str) -> List[DocIdentifier]:
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
			"patient_ids": patient_ids,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.undeletePatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def undelete_patient_blocking(self, patient_ids: str) -> List[DocIdentifier]:
		payload = {
			"patient_ids": patient_ids,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.undeletePatientBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_data_owners_with_access_to_async(self, patient: Patient) -> EntityAccessInformation:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityAccessInformation._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.getDataOwnersWithAccessToAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_data_owners_with_access_to_blocking(self, patient: Patient) -> EntityAccessInformation:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavourlessApi.getDataOwnersWithAccessToBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityAccessInformation._deserialize(result_info["success"])
			return return_value

	async def modify_patient_async(self, entity: EncryptedPatient) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patient_blocking(self, entity: EncryptedPatient) -> EncryptedPatient:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

	async def get_patient_async(self, entity_id: str) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_blocking(self, entity_id: str) -> EncryptedPatient:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

	async def filter_patients_by_async(self, filter_chain: FilterChain, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.filterPatientsByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_patients_by_blocking(self, filter_chain: FilterChain, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.filterPatientsByBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_patients_by_name_birth_ssin_auto_async(self, filter_value: str, healthcare_party_id: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_id": healthcare_party_id,
			"filter_value": filter_value,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_patients_by_name_birth_ssin_auto_blocking(self, filter_value: str, healthcare_party_id: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"healthcare_party_id": healthcare_party_id,
			"filter_value": filter_value,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_patients_of_hc_party_async(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listPatientsOfHcPartyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_patients_of_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listPatientsOfHcPartyBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_of_merges_after_async(self, date: int) -> List[EncryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listOfMergesAfterAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_of_merges_after_blocking(self, date: int) -> List[EncryptedPatient]:
		payload = {
			"date": date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listOfMergesAfterBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_patients_modified_after_async(self, date: int, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsModifiedAfterAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_patients_modified_after_blocking(self, date: int, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"date": date,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsModifiedAfterBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_patients_by_hc_party_async(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listPatientsByHcPartyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_patients_by_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listPatientsByHcPartyBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def get_patient_hc_party_keys_for_delegate_async(self, patient_id: str) -> Dict[str, str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = dict(map(lambda kv1: (kv1[0], kv1[1]), success.decode('utf-8').items()))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_id": patient_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
		payload = {
			"patient_id": patient_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info["success"].items()))
			return return_value

	async def count_of_patients_async(self, hc_party_id: str) -> EncryptedContent:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedContent._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.countOfPatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.countOfPatientsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedContent._deserialize(result_info["success"])
			return return_value

	async def find_patients_by_healthcare_party_async(self, hc_party_id: Optional[str] = None, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsByHealthcarePartyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_patients_by_healthcare_party_blocking(self, hc_party_id: Optional[str] = None, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"sort_field": sort_field,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"sort_direction": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsByHealthcarePartyBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_patients_ids_by_healthcare_party_async(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [item for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_patients_ids_by_healthcare_party_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyBlocking(
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
				rows = [item for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def get_patient_by_external_id_async(self, external_id: str) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_id": external_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientByExternalIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_by_external_id_blocking(self, external_id: str) -> EncryptedPatient:
		payload = {
			"external_id": external_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientByExternalIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

	async def fuzzy_search_async(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[EncryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"first_name": first_name,
			"last_name": last_name,
			"date_of_birth": date_of_birth,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.fuzzySearchAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[EncryptedPatient]:
		payload = {
			"first_name": first_name,
			"last_name": last_name,
			"date_of_birth": date_of_birth,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.fuzzySearchBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_deleted_patients_async(self, start_date: int, end_date: Optional[int] = None, desc: Optional[bool] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"desc": desc,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDeletedPatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_deleted_patients_blocking(self, start_date: int, end_date: Optional[int] = None, desc: Optional[bool] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"desc": desc,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDeletedPatientsBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def list_deleted_patients_by_name_async(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[EncryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"first_name": first_name,
			"last_name": last_name,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listDeletedPatientsByNameAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[EncryptedPatient]:
		payload = {
			"first_name": first_name,
			"last_name": last_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.listDeletedPatientsByNameBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_patients_async(self, patient_ids: ListOfIds) -> List[EncryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_ids": patient_ids.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patients_blocking(self, patient_ids: ListOfIds) -> List[EncryptedPatient]:
		payload = {
			"patient_ids": patient_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_patient_by_healthcare_party_and_identifier_async(self, hc_party_id: str, id: str, system: Optional[str] = None) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"id": id,
			"system": system,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> EncryptedPatient:
		payload = {
			"hc_party_id": hc_party_id,
			"id": id,
			"system": system,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

	async def modify_patients_async(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
		payload = {
			"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_patient_referral_async(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_id": patient_id,
			"referral_id": referral_id,
			"start": start,
			"end": end,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientReferralAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> EncryptedPatient:
		payload = {
			"patient_id": patient_id,
			"referral_id": referral_id,
			"start": start,
			"end": end,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.modifyPatientReferralBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

	async def find_duplicates_by_ssin_async(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDuplicatesBySsinAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_duplicates_by_ssin_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDuplicatesBySsinBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_duplicates_by_name_async(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDuplicatesByNameAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_duplicates_by_name_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.findDuplicatesByNameBlocking(
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
				rows = [EncryptedPatient._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def merge_patients_async(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> EncryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"into_id": into_id,
			"from_id": from_id,
			"expected_from_rev": expected_from_rev,
			"updated_into": updated_into.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.mergePatientsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> EncryptedPatient:
		payload = {
			"into_id": into_id,
			"from_id": from_id,
			"expected_from_rev": expected_from_rev,
			"updated_into": updated_into.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PatientBasicFlavouredApi.mergePatientsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedPatient._deserialize(result_info["success"])
			return return_value

__all__ = ['PatientBasicApi']