import asyncio
import json
from model import Patient, serialize_patient, DecryptedPatient, User, AccessLevel, IdWithRev, DataOwnerRegistrationSuccess, AbstractFilter, serialize_abstract_filter, DocIdentifier, RequestedPermission, RequestedPermission.MaxWrite, FilterChain, PaginatedList, SortDirection, SortDirection.Asc, EncryptedContent, ListOfIds, EncryptedPatient, deserialize_patient
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from typing import List, Optional, Dict
from ctypes import cast, c_char_p
from model.specializations import HexString
from crypto import Tag, Result, EntityWithTypeInfo, EntityAccessInformation, ShareMetadataBehaviour, ShareMetadataBehaviour.IfAvailable, deserialize_simple_share_result, SimpleShareResult, PatientShareOptions

class PatientApi:

	class PatientFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, patient: EncryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"patient": patient.__serialize__(),
				"share_secret_ids": [x0 for x0 in share_secret_ids],
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, patient: EncryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"patient": patient.__serialize__(),
				"share_secret_ids": [x0 for x0 in share_secret_ids],
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> EncryptedPatient:
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
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> EncryptedPatient:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
				return return_value

		async def initialise_confidential_secret_id_async(self, patient: EncryptedPatient) -> EncryptedPatient:
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
				"patient": patient.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def initialise_confidential_secret_id_blocking(self, patient: EncryptedPatient) -> EncryptedPatient:
			payload = {
				"patient": patient.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_patient_blocking(self, entity: EncryptedPatient) -> EncryptedPatient:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_blocking(self, entity_id: str) -> EncryptedPatient:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_of_merges_after_blocking(self, date: int) -> List[EncryptedPatient]:
			payload = {
				"date": date,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info.success]
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
			payload = {
				"patient_id": patient_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items()))
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedContent._deserialize(result_info.success)
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [item for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [item for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_by_external_id_blocking(self, external_id: str) -> EncryptedPatient:
			payload = {
				"external_id": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info.success]
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[EncryptedPatient]:
			payload = {
				"first_name": first_name,
				"last_name": last_name,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info.success]
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patients_blocking(self, patient_ids: ListOfIds) -> List[EncryptedPatient]:
			payload = {
				"patient_ids": patient_ids.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedPatient._deserialize(x1) for x1 in result_info.success]
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
			payload = {
				"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [EncryptedPatient._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [EncryptedPatient._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedPatient._deserialize(result_info.success)
				return return_value

	class PatientFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, patient: Patient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"patient": patient.__serialize__(),
				"share_secret_ids": [x0 for x0 in share_secret_ids],
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, patient: Patient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"patient": patient.__serialize__(),
				"share_secret_ids": [x0 for x0 in share_secret_ids],
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> Patient:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
				return return_value

		async def initialise_confidential_secret_id_async(self, patient: Patient) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def initialise_confidential_secret_id_blocking(self, patient: Patient) -> Patient:
			payload = {
				"patient": patient.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
				return return_value

		async def modify_patient_async(self, entity: Patient) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_patient_blocking(self, entity: Patient) -> Patient:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
				return return_value

		async def get_patient_async(self, entity_id: str) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_blocking(self, entity_id: str) -> Patient:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_of_merges_after_async(self, date: int) -> List[Patient]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Patient._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_of_merges_after_blocking(self, date: int) -> List[Patient]:
			payload = {
				"date": date,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Patient._deserialize(x1) for x1 in result_info.success]
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
			payload = {
				"patient_id": patient_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items()))
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedContent._deserialize(result_info.success)
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [item for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [item for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def get_patient_by_external_id_async(self, external_id: str) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"external_id": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_by_external_id_blocking(self, external_id: str) -> Patient:
			payload = {
				"external_id": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
				return return_value

		async def fuzzy_search_async(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[Patient]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Patient._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"first_name": first_name,
				"last_name": last_name,
				"date_of_birth": date_of_birth,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[Patient]:
			payload = {
				"first_name": first_name,
				"last_name": last_name,
				"date_of_birth": date_of_birth,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Patient._deserialize(x1) for x1 in result_info.success]
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_deleted_patients_by_name_async(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[Patient]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Patient._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"first_name": first_name,
				"last_name": last_name,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[Patient]:
			payload = {
				"first_name": first_name,
				"last_name": last_name,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Patient._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_patients_async(self, patient_ids: ListOfIds) -> List[Patient]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Patient._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient_ids": patient_ids.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patients_blocking(self, patient_ids: ListOfIds) -> List[Patient]:
			payload = {
				"patient_ids": patient_ids.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Patient._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_patient_by_healthcare_party_and_identifier_async(self, hc_party_id: str, id: str, system: Optional[str] = None) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"id": id,
				"system": system,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> Patient:
			payload = {
				"hc_party_id": hc_party_id,
				"id": id,
				"system": system,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
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
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
			payload = {
				"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def modify_patient_referral_async(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient_id": patient_id,
				"referral_id": referral_id,
				"start": start,
				"end": end,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> Patient:
			payload = {
				"patient_id": patient_id,
				"referral_id": referral_id,
				"start": start,
				"end": end,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
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
						rows = [deserialize_patient(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameAsync,
				self.icure_sdk.native,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_patient(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def merge_patients_async(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> Patient:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Patient._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"into_id": into_id,
				"from_id": from_id,
				"expected_from_rev": expected_from_rev,
				"updated_into": updated_into.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> Patient:
			payload = {
				"into_id": into_id,
				"from_id": from_id,
				"expected_from_rev": expected_from_rev,
				"updated_into": updated_into.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Patient._deserialize(result_info.success)
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = PatientApi.PatientFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = PatientApi.PatientFlavouredApi(self.icure_sdk)

	async def get_secret_ids_of_async(self, patient: Patient) -> List[str]:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getSecretIdsOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_secret_ids_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getSecretIdsOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_encryption_keys_of_async(self, patient: Patient) -> List[HexString]:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, patient: Patient) -> List[HexString]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getEncryptionKeysOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_patient_async(self, patient: DecryptedPatient) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_patient_blocking(self, patient: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedPatient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedPatient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}) -> DecryptedPatient:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def create_delegations_de_anonymization_metadata_async(self, patient: Patient, data_owner_ids: List[str]) -> None:
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
			"patient": serialize_patient(patient),
			"data_owner_ids": [x0 for x0 in data_owner_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationsDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegations_de_anonymization_metadata_blocking(self, patient: Patient, data_owner_ids: List[str]) -> None:
		payload = {
			"patient": serialize_patient(patient),
			"data_owner_ids": [x0 for x0 in data_owner_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationsDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def has_write_access_async(self, patient: Patient) -> bool:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, patient: Patient) -> bool:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.hasWriteAccessBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, patient: Patient) -> List[str]:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptPatientIdOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Patient, delegates: List[str]) -> None:
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
			"entity": serialize_patient(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Patient, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_patient(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def create_patients_async(self, patient_dtos: List[DecryptedPatient]) -> List[IdWithRev]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_patients_blocking(self, patient_dtos: List[DecryptedPatient]) -> List[IdWithRev]:
		payload = {
			"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def register_patient_async(self, hc_party_id: str, group_id: str, token: Optional[str], use_short_token: Optional[bool], create_auto_delegation: bool, patient: DecryptedPatient) -> DataOwnerRegistrationSuccess:
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
			"hc_party_id": hc_party_id,
			"group_id": group_id,
			"token": token,
			"use_short_token": use_short_token,
			"create_auto_delegation": create_auto_delegation,
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.registerPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def register_patient_blocking(self, hc_party_id: str, group_id: str, token: Optional[str], use_short_token: Optional[bool], create_auto_delegation: bool, patient: DecryptedPatient) -> DataOwnerRegistrationSuccess:
		payload = {
			"hc_party_id": hc_party_id,
			"group_id": group_id,
			"token": token,
			"use_short_token": use_short_token,
			"create_auto_delegation": create_auto_delegation,
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.registerPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DataOwnerRegistrationSuccess._deserialize(result_info.success)
			return return_value

	async def share_all_data_of_patient_async(self, user: User, patient_id: str, data_owner_id: str, delegates_with_share_type: Dict[str, List[Tag]]) -> Result:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Result._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user": user.__serialize__(),
			"patient_id": patient_id,
			"data_owner_id": data_owner_id,
			"delegates_with_share_type": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in delegates_with_share_type.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareAllDataOfPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_all_data_of_patient_blocking(self, user: User, patient_id: str, data_owner_id: str, delegates_with_share_type: Dict[str, List[Tag]]) -> Result:
		payload = {
			"user": user.__serialize__(),
			"patient_id": patient_id,
			"data_owner_id": data_owner_id,
			"delegates_with_share_type": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in delegates_with_share_type.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareAllDataOfPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = Result._deserialize(result_info.success)
			return return_value

	async def get_patient_id_of_child_document_for_hcp_and_hcp_parents_async(self, child_document: EntityWithTypeInfo, healthcare_party_id: str) -> str:
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
			"child_document": child_document.__serialize__(),
			"healthcare_party_id": healthcare_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientIdOfChildDocumentForHcpAndHcpParentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_id_of_child_document_for_hcp_and_hcp_parents_blocking(self, child_document: EntityWithTypeInfo, healthcare_party_id: str) -> str:
		payload = {
			"child_document": child_document.__serialize__(),
			"healthcare_party_id": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientIdOfChildDocumentForHcpAndHcpParentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_confidential_secret_ids_of_async(self, patient: Patient) -> List[str]:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getConfidentialSecretIdsOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_confidential_secret_ids_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getConfidentialSecretIdsOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def force_initialise_exchange_data_to_newly_invited_patient_async(self, patient_id: str) -> bool:
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
			"patient_id": patient_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.forceInitialiseExchangeDataToNewlyInvitedPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def force_initialise_exchange_data_to_newly_invited_patient_blocking(self, patient_id: str) -> bool:
		payload = {
			"patient_id": patient_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.forceInitialiseExchangeDataToNewlyInvitedPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.matchPatientsByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_patients_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.matchPatientsByBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.deletePatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_patient_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.deletePatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.deletePatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_patients_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.deletePatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.undeletePatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def undelete_patient_blocking(self, patient_ids: str) -> List[DocIdentifier]:
		payload = {
			"patient_ids": patient_ids,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.undeletePatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.getDataOwnersWithAccessToAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_data_owners_with_access_to_blocking(self, patient: Patient) -> EntityAccessInformation:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavourlessApi.getDataOwnersWithAccessToBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EntityAccessInformation._deserialize(result_info.success)
			return return_value

	async def share_with_async(self, delegate_id: str, patient: DecryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"patient": patient.__serialize__(),
			"share_secret_ids": [x0 for x0 in share_secret_ids],
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, patient: DecryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"patient": patient.__serialize__(),
			"share_secret_ids": [x0 for x0 in share_secret_ids],
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def try_share_with_many_async(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.tryShareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def share_with_many_async(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def initialise_confidential_secret_id_async(self, patient: DecryptedPatient) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def initialise_confidential_secret_id_blocking(self, patient: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientFlavouredApi.initialiseConfidentialSecretIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def modify_patient_async(self, entity: DecryptedPatient) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patient_blocking(self, entity: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def get_patient_async(self, entity_id: str) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_blocking(self, entity_id: str) -> DecryptedPatient:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.filterPatientsByBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByNameBirthSsinAutoBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsOfHcPartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_of_merges_after_async(self, date: int) -> List[DecryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_of_merges_after_blocking(self, date: int) -> List[DecryptedPatient]:
		payload = {
			"date": date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listOfMergesAfterBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedPatient._deserialize(x1) for x1 in result_info.success]
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsModifiedAfterBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listPatientsByHcPartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
		payload = {
			"patient_id": patient_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientHcPartyKeysForDelegateBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items()))
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.countOfPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedContent._deserialize(result_info.success)
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsByHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
					rows = [item for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findPatientsIdsByHealthcarePartyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [item for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def get_patient_by_external_id_async(self, external_id: str) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_id": external_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_by_external_id_blocking(self, external_id: str) -> DecryptedPatient:
		payload = {
			"external_id": external_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByExternalIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def fuzzy_search_async(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[DecryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"first_name": first_name,
			"last_name": last_name,
			"date_of_birth": date_of_birth,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[DecryptedPatient]:
		payload = {
			"first_name": first_name,
			"last_name": last_name,
			"date_of_birth": date_of_birth,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.fuzzySearchBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedPatient._deserialize(x1) for x1 in result_info.success]
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDeletedPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_deleted_patients_by_name_async(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[DecryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"first_name": first_name,
			"last_name": last_name,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[DecryptedPatient]:
		payload = {
			"first_name": first_name,
			"last_name": last_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.listDeletedPatientsByNameBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedPatient._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_patients_async(self, patient_ids: ListOfIds) -> List[DecryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedPatient._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_ids": patient_ids.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patients_blocking(self, patient_ids: ListOfIds) -> List[DecryptedPatient]:
		payload = {
			"patient_ids": patient_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedPatient._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_patient_by_healthcare_party_and_identifier_async(self, hc_party_id: str, id: str, system: Optional[str] = None) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"id": id,
			"system": system,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> DecryptedPatient:
		payload = {
			"hc_party_id": hc_party_id,
			"id": id,
			"system": system,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.getPatientByHealthcarePartyAndIdentifierBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
		payload = {
			"patient_dtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_patient_referral_async(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient_id": patient_id,
			"referral_id": referral_id,
			"start": start,
			"end": end,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> DecryptedPatient:
		payload = {
			"patient_id": patient_id,
			"referral_id": referral_id,
			"start": start,
			"end": end,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.modifyPatientReferralBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesBySsinBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
					rows = [DecryptedPatient._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameAsync,
			self.icure_sdk.native,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.findDuplicatesByNameBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedPatient._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def merge_patients_async(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedPatient._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"into_id": into_id,
			"from_id": from_id,
			"expected_from_rev": expected_from_rev,
			"updated_into": updated_into.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> DecryptedPatient:
		payload = {
			"into_id": into_id,
			"from_id": from_id,
			"expected_from_rev": expected_from_rev,
			"updated_into": updated_into.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientBasicFlavouredApi.mergePatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value
