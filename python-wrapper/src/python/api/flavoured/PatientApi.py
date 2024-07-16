import asyncio
import json
from icure.model import Patient, serialize_patient, DecryptedPatient, User, AccessLevel, EncryptedPatient, deserialize_patient, IdWithRev, DataOwnerRegistrationSuccess, ShareAllPatientDataOptions, EntityWithTypeInfo, PatientAbstractFilter, serialize_abstract_filter, DocIdentifier, EntityAccessInformation, SubscriptionEventType, EntitySubscriptionConfiguration, ShareMetadataBehaviour, RequestedPermission, deserialize_simple_share_result, SimpleShareResult, PatientShareOptions, FilterChain, PaginatedList, SortDirection, EncryptedContent, ListOfIds
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from typing import List, Optional, Dict
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.model.specializations import HexString
from icure.subscription.EntitySubscription import EntitySubscription

class PatientApi:

	class PatientFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, patient: EncryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"patient": patient.__serialize__(),
				"shareSecretIds": [x0 for x0 in share_secret_ids],
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, patient: EncryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"patient": patient.__serialize__(),
				"shareSecretIds": [x0 for x0 in share_secret_ids],
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, patient: EncryptedPatient, delegates: Dict[str, PatientShareOptions]) -> EncryptedPatient:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.initialiseConfidentialSecretIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def initialise_confidential_secret_id_blocking(self, patient: EncryptedPatient) -> EncryptedPatient:
			payload = {
				"patient": patient.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.initialiseConfidentialSecretIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patient_blocking(self, entity: EncryptedPatient) -> EncryptedPatient:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_blocking(self, entity_id: str) -> EncryptedPatient:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"skip": skip,
				"sort": sort,
				"desc": desc,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.filterPatientsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_patients_by_blocking(self, filter_chain: FilterChain, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"skip": skip,
				"sort": sort,
				"desc": desc,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.filterPatientsByBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"healthcarePartyId": healthcare_party_id,
				"filterValue": filter_value,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsByNameBirthSsinAutoAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_by_name_birth_ssin_auto_blocking(self, filter_value: str, healthcare_party_id: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"healthcarePartyId": healthcare_party_id,
				"filterValue": filter_value,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsByNameBirthSsinAutoBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listPatientsOfHcPartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_patients_of_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listPatientsOfHcPartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listOfMergesAfterAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_of_merges_after_blocking(self, date: int) -> List[EncryptedPatient]:
			payload = {
				"date": date,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listOfMergesAfterBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsModifiedAfterAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_modified_after_blocking(self, date: int, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"date": date,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsModifiedAfterBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listPatientsByHcPartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_patients_by_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listPatientsByHcPartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = dict(map(lambda kv1: (kv1[0], kv1[1]), json.loads(success.decode('utf-8')).items()))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientId": patient_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientHcPartyKeysForDelegateAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
			payload = {
				"patientId": patient_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientHcPartyKeysForDelegateBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedContent._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.countOfPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.countOfPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsByHealthcarePartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_by_healthcare_party_blocking(self, hc_party_id: Optional[str] = None, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsByHealthcarePartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [item for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsIdsByHealthcarePartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_ids_by_healthcare_party_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findPatientsIdsByHealthcarePartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalId": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientByExternalIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_by_external_id_blocking(self, external_id: str) -> EncryptedPatient:
			payload = {
				"externalId": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientByExternalIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"firstName": first_name,
				"lastName": last_name,
				"dateOfBirth": date_of_birth,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.fuzzySearchAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[EncryptedPatient]:
			payload = {
				"firstName": first_name,
				"lastName": last_name,
				"dateOfBirth": date_of_birth,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.fuzzySearchBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"desc": desc,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDeletedPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_deleted_patients_blocking(self, start_date: int, end_date: Optional[int] = None, desc: Optional[bool] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"desc": desc,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDeletedPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"firstName": first_name,
				"lastName": last_name,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listDeletedPatientsByNameAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[EncryptedPatient]:
			payload = {
				"firstName": first_name,
				"lastName": last_name,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.listDeletedPatientsByNameBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientIds": patient_ids.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patients_blocking(self, patient_ids: ListOfIds) -> List[EncryptedPatient]:
			payload = {
				"patientIds": patient_ids.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"id": id,
				"system": system,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientByHealthcarePartyAndIdentifierAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> EncryptedPatient:
			payload = {
				"hcPartyId": hc_party_id,
				"id": id,
				"system": system,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.getPatientByHealthcarePartyAndIdentifierBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [IdWithRev._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
			payload = {
				"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientId": patient_id,
				"referralId": referral_id,
				"start": start,
				"end": end,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientReferralAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> EncryptedPatient:
			payload = {
				"patientId": patient_id,
				"referralId": referral_id,
				"start": start,
				"end": end,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.modifyPatientReferralBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDuplicatesBySsinAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_duplicates_by_ssin_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDuplicatesBySsinBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedPatient._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDuplicatesByNameAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_duplicates_by_name_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.findDuplicatesByNameBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedPatient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"intoId": into_id,
				"fromId": from_id,
				"expectedFromRev": expected_from_rev,
				"updatedInto": updated_into.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.mergePatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> EncryptedPatient:
			payload = {
				"intoId": into_id,
				"fromId": from_id,
				"expectedFromRev": expected_from_rev,
				"updatedInto": updated_into.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.encrypted.mergePatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"patient": patient.__serialize__(),
				"shareSecretIds": [x0 for x0 in share_secret_ids],
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, patient: Patient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"patient": patient.__serialize__(),
				"shareSecretIds": [x0 for x0 in share_secret_ids],
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, patient: Patient, delegates: Dict[str, PatientShareOptions]) -> Patient:
			payload = {
				"patient": patient.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patient": patient.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.initialiseConfidentialSecretIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def initialise_confidential_secret_id_blocking(self, patient: Patient) -> Patient:
			payload = {
				"patient": patient.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.initialiseConfidentialSecretIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patient_blocking(self, entity: Patient) -> Patient:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_blocking(self, entity_id: str) -> Patient:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"skip": skip,
				"sort": sort,
				"desc": desc,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.filterPatientsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_patients_by_blocking(self, filter_chain: FilterChain, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"skip": skip,
				"sort": sort,
				"desc": desc,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.filterPatientsByBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"healthcarePartyId": healthcare_party_id,
				"filterValue": filter_value,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsByNameBirthSsinAutoAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_by_name_birth_ssin_auto_blocking(self, filter_value: str, healthcare_party_id: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"healthcarePartyId": healthcare_party_id,
				"filterValue": filter_value,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsByNameBirthSsinAutoBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listPatientsOfHcPartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_patients_of_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listPatientsOfHcPartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Patient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listOfMergesAfterAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_of_merges_after_blocking(self, date: int) -> List[Patient]:
			payload = {
				"date": date,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listOfMergesAfterBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"date": date,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsModifiedAfterAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_modified_after_blocking(self, date: int, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"date": date,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsModifiedAfterBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listPatientsByHcPartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_patients_by_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listPatientsByHcPartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = dict(map(lambda kv1: (kv1[0], kv1[1]), json.loads(success.decode('utf-8')).items()))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientId": patient_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientHcPartyKeysForDelegateAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
			payload = {
				"patientId": patient_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientHcPartyKeysForDelegateBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedContent._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.countOfPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.countOfPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsByHealthcarePartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_by_healthcare_party_blocking(self, hc_party_id: Optional[str] = None, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"sortField": sort_field,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
				"sortDirection": sort_direction.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsByHealthcarePartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [item for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsIdsByHealthcarePartyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_patients_ids_by_healthcare_party_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findPatientsIdsByHealthcarePartyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalId": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientByExternalIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_by_external_id_blocking(self, external_id: str) -> Patient:
			payload = {
				"externalId": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientByExternalIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Patient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"firstName": first_name,
				"lastName": last_name,
				"dateOfBirth": date_of_birth,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.fuzzySearchAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[Patient]:
			payload = {
				"firstName": first_name,
				"lastName": last_name,
				"dateOfBirth": date_of_birth,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.fuzzySearchBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"desc": desc,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDeletedPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_deleted_patients_blocking(self, start_date: int, end_date: Optional[int] = None, desc: Optional[bool] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"desc": desc,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDeletedPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Patient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"firstName": first_name,
				"lastName": last_name,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listDeletedPatientsByNameAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[Patient]:
			payload = {
				"firstName": first_name,
				"lastName": last_name,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.listDeletedPatientsByNameBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Patient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientIds": patient_ids.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patients_blocking(self, patient_ids: ListOfIds) -> List[Patient]:
			payload = {
				"patientIds": patient_ids.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"id": id,
				"system": system,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientByHealthcarePartyAndIdentifierAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> Patient:
			payload = {
				"hcPartyId": hc_party_id,
				"id": id,
				"system": system,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.getPatientByHealthcarePartyAndIdentifierBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [IdWithRev._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
			payload = {
				"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"patientId": patient_id,
				"referralId": referral_id,
				"start": start,
				"end": end,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientReferralAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> Patient:
			payload = {
				"patientId": patient_id,
				"referralId": referral_id,
				"start": start,
				"end": end,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.modifyPatientReferralBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDuplicatesBySsinAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_duplicates_by_ssin_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDuplicatesBySsinBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_patient(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDuplicatesByNameAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_duplicates_by_name_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"startKey": start_key,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.findDuplicatesByNameBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Patient._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"intoId": into_id,
				"fromId": from_id,
				"expectedFromRev": expected_from_rev,
				"updatedInto": updated_into.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.mergePatientsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> Patient:
			payload = {
				"intoId": into_id,
				"fromId": from_id,
				"expectedFromRev": expected_from_rev,
				"updatedInto": updated_into.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryAndRecover.mergePatientsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getSecretIdsOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_secret_ids_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getSecretIdsOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getEncryptionKeysOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, patient: Patient) -> List[HexString]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getEncryptionKeysOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_patient_blocking(self, patient: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.withEncryptionMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
			"dataOwnerIds": [x0 for x0 in data_owner_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationsDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegations_de_anonymization_metadata_blocking(self, patient: Patient, data_owner_ids: List[str]) -> None:
		payload = {
			"patient": serialize_patient(patient),
			"dataOwnerIds": [x0 for x0 in data_owner_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationsDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def has_write_access_async(self, patient: Patient) -> bool:
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
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.hasWriteAccessAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, patient: Patient) -> bool:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.hasWriteAccessBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptPatientIdOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptPatientIdOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": serialize_patient(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Patient, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_patient(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def decrypt_async(self, patient: EncryptedPatient) -> DecryptedPatient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, patient: EncryptedPatient) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.decryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, patient: EncryptedPatient) -> Patient:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_patient(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryDecryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, patient: EncryptedPatient) -> Patient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryDecryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_patient(result_info.success)
			return return_value

	async def create_patients_async(self, patient_dtos: List[DecryptedPatient]) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [IdWithRev._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_patients_blocking(self, patient_dtos: List[DecryptedPatient]) -> List[IdWithRev]:
		payload = {
			"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.createPatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DataOwnerRegistrationSuccess._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
			"token": token,
			"useShortToken": use_short_token,
			"createAutoDelegation": create_auto_delegation,
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.registerPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def register_patient_blocking(self, hc_party_id: str, group_id: str, token: Optional[str], use_short_token: Optional[bool], create_auto_delegation: bool, patient: DecryptedPatient) -> DataOwnerRegistrationSuccess:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
			"token": token,
			"useShortToken": use_short_token,
			"createAutoDelegation": create_auto_delegation,
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.registerPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DataOwnerRegistrationSuccess._deserialize(result_info.success)
			return return_value

	async def share_all_data_of_patient_async(self, user: User, patient_id: str, data_owner_id: str, delegates_with_share_type: Dict[str, List[ShareAllPatientDataOptions.Tag]]) -> ShareAllPatientDataOptions.Result:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = ShareAllPatientDataOptions.Result._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user": user.__serialize__(),
			"patientId": patient_id,
			"dataOwnerId": data_owner_id,
			"delegatesWithShareType": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in delegates_with_share_type.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareAllDataOfPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_all_data_of_patient_blocking(self, user: User, patient_id: str, data_owner_id: str, delegates_with_share_type: Dict[str, List[ShareAllPatientDataOptions.Tag]]) -> ShareAllPatientDataOptions.Result:
		payload = {
			"user": user.__serialize__(),
			"patientId": patient_id,
			"dataOwnerId": data_owner_id,
			"delegatesWithShareType": {k0: [x1.__serialize__() for x1 in v0] for k0, v0 in delegates_with_share_type.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareAllDataOfPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = ShareAllPatientDataOptions.Result._deserialize(result_info.success)
			return return_value

	async def get_patient_id_of_child_document_for_hcp_and_hcp_parents_async(self, child_document: EntityWithTypeInfo, healthcare_party_id: str) -> str:
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
			"childDocument": child_document.__serialize__(),
			"healthcarePartyId": healthcare_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientIdOfChildDocumentForHcpAndHcpParentsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patient_id_of_child_document_for_hcp_and_hcp_parents_blocking(self, child_document: EntityWithTypeInfo, healthcare_party_id: str) -> str:
		payload = {
			"childDocument": child_document.__serialize__(),
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientIdOfChildDocumentForHcpAndHcpParentsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getConfidentialSecretIdsOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_confidential_secret_ids_of_blocking(self, patient: Patient) -> List[str]:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getConfidentialSecretIdsOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientId": patient_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.forceInitialiseExchangeDataToNewlyInvitedPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def force_initialise_exchange_data_to_newly_invited_patient_blocking(self, patient_id: str) -> bool:
		payload = {
			"patientId": patient_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.forceInitialiseExchangeDataToNewlyInvitedPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def match_patients_by_async(self, filter: PatientAbstractFilter) -> List[str]:
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
			"filter": serialize_abstract_filter(filter),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.matchPatientsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_patients_by_blocking(self, filter: PatientAbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.matchPatientsByBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.deletePatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_patient_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.deletePatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.deletePatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_patients_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.deletePatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientIds": patient_ids,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.undeletePatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_patient_blocking(self, patient_ids: str) -> List[DocIdentifier]:
		payload = {
			"patientIds": patient_ids,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.undeletePatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntityAccessInformation._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": serialize_patient(patient),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getDataOwnersWithAccessToAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_data_owners_with_access_to_blocking(self, patient: Patient) -> EntityAccessInformation:
		payload = {
			"patient": serialize_patient(patient),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getDataOwnersWithAccessToBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EntityAccessInformation._deserialize(result_info.success)
			return return_value

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: PatientAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedPatient]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntitySubscription[EncryptedPatient](
					producer = success,
					deserializer = lambda x: EncryptedPatient._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.subscribeToEventsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: PatientAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedPatient]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.subscribeToEventsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise Exception(error_msg)
		else:
			class_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return EntitySubscription[EncryptedPatient](
				producer = class_pointer,
				deserializer = lambda x: EncryptedPatient._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def share_with_async(self, delegate_id: str, patient: DecryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"patient": patient.__serialize__(),
			"shareSecretIds": [x0 for x0 in share_secret_ids],
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareWithAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, patient: DecryptedPatient, share_secret_ids: List[str], share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegateId": delegate_id,
			"patient": patient.__serialize__(),
			"shareSecretIds": [x0 for x0 in share_secret_ids],
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareWithBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryShareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> SimpleShareResult:
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.tryShareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, patient: DecryptedPatient, delegates: Dict[str, PatientShareOptions]) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.shareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patient": patient.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.initialiseConfidentialSecretIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def initialise_confidential_secret_id_blocking(self, patient: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"patient": patient.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.initialiseConfidentialSecretIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_patient_blocking(self, entity: DecryptedPatient) -> DecryptedPatient:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patient_blocking(self, entity_id: str) -> DecryptedPatient:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.filterPatientsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_patients_by_blocking(self, filter_chain: FilterChain, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip: Optional[int] = None, sort: Optional[str] = None, desc: Optional[bool] = None) -> PaginatedList:
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"skip": skip,
			"sort": sort,
			"desc": desc,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.filterPatientsByBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcarePartyId": healthcare_party_id,
			"filterValue": filter_value,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsByNameBirthSsinAutoAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_patients_by_name_birth_ssin_auto_blocking(self, filter_value: str, healthcare_party_id: Optional[str] = None, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"healthcarePartyId": healthcare_party_id,
			"filterValue": filter_value,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsByNameBirthSsinAutoBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listPatientsOfHcPartyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_patients_of_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listPatientsOfHcPartyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listOfMergesAfterAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_of_merges_after_blocking(self, date: int) -> List[DecryptedPatient]:
		payload = {
			"date": date,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listOfMergesAfterBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"date": date,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsModifiedAfterAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_patients_modified_after_blocking(self, date: int, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"date": date,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsModifiedAfterBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listPatientsByHcPartyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_patients_by_hc_party_blocking(self, hc_party_id: str, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listPatientsByHcPartyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = dict(map(lambda kv1: (kv1[0], kv1[1]), json.loads(success.decode('utf-8')).items()))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientId": patient_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientHcPartyKeysForDelegateAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patient_hc_party_keys_for_delegate_blocking(self, patient_id: str) -> Dict[str, str]:
		payload = {
			"patientId": patient_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientHcPartyKeysForDelegateBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedContent._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.countOfPatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def count_of_patients_blocking(self, hc_party_id: str) -> EncryptedContent:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.countOfPatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsByHealthcarePartyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_patients_by_healthcare_party_blocking(self, hc_party_id: Optional[str] = None, sort_field: str = "name", start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, sort_direction: SortDirection = SortDirection.Asc) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"sortField": sort_field,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
			"sortDirection": sort_direction.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsByHealthcarePartyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [item for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsIdsByHealthcarePartyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_patients_ids_by_healthcare_party_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findPatientsIdsByHealthcarePartyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"externalId": external_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientByExternalIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patient_by_external_id_blocking(self, external_id: str) -> DecryptedPatient:
		payload = {
			"externalId": external_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientByExternalIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"firstName": first_name,
			"lastName": last_name,
			"dateOfBirth": date_of_birth,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.fuzzySearchAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def fuzzy_search_blocking(self, first_name: str, last_name: str, date_of_birth: Optional[int] = None) -> List[DecryptedPatient]:
		payload = {
			"firstName": first_name,
			"lastName": last_name,
			"dateOfBirth": date_of_birth,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.fuzzySearchBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"desc": desc,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDeletedPatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_deleted_patients_blocking(self, start_date: int, end_date: Optional[int] = None, desc: Optional[bool] = None, start_key: Optional[int] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"desc": desc,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDeletedPatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"firstName": first_name,
			"lastName": last_name,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listDeletedPatientsByNameAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_deleted_patients_by_name_blocking(self, first_name: Optional[str] = None, last_name: Optional[str] = None) -> List[DecryptedPatient]:
		payload = {
			"firstName": first_name,
			"lastName": last_name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.listDeletedPatientsByNameBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedPatient._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientIds": patient_ids.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patients_blocking(self, patient_ids: ListOfIds) -> List[DecryptedPatient]:
		payload = {
			"patientIds": patient_ids.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"id": id,
			"system": system,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientByHealthcarePartyAndIdentifierAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_patient_by_healthcare_party_and_identifier_blocking(self, hc_party_id: str, id: str, system: Optional[str] = None) -> DecryptedPatient:
		payload = {
			"hcPartyId": hc_party_id,
			"id": id,
			"system": system,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.getPatientByHealthcarePartyAndIdentifierBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [IdWithRev._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_patients_blocking(self, patient_dtos: List[EncryptedPatient]) -> List[IdWithRev]:
		payload = {
			"patientDtos": [x0.__serialize__() for x0 in patient_dtos],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"patientId": patient_id,
			"referralId": referral_id,
			"start": start,
			"end": end,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientReferralAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_patient_referral_blocking(self, patient_id: str, referral_id: str, start: Optional[int] = None, end: Optional[int] = None) -> DecryptedPatient:
		payload = {
			"patientId": patient_id,
			"referralId": referral_id,
			"start": start,
			"end": end,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.modifyPatientReferralBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDuplicatesBySsinAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_duplicates_by_ssin_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDuplicatesBySsinBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedPatient._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDuplicatesByNameAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_duplicates_by_name_blocking(self, hc_party_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"startKey": start_key,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.findDuplicatesByNameBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
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
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedPatient._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"intoId": into_id,
			"fromId": from_id,
			"expectedFromRev": expected_from_rev,
			"updatedInto": updated_into.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.mergePatientsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def merge_patients_blocking(self, into_id: str, from_id: str, expected_from_rev: str, updated_into: EncryptedPatient) -> DecryptedPatient:
		payload = {
			"intoId": into_id,
			"fromId": from_id,
			"expectedFromRev": expected_from_rev,
			"updatedInto": updated_into.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.PatientApi.mergePatientsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedPatient._deserialize(result_info.success)
			return return_value
