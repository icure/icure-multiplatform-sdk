import asyncio
import json
from icure.model import DecryptedContact, Patient, User, AccessLevel, SecretIdOption, SecretIdOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_option, Contact, serialize_contact, EncryptedContact, deserialize_contact, EncryptedService, DecryptedService, deserialize_service, Service, ContactAbstractFilter, serialize_abstract_filter, ServiceAbstractFilter, DocIdentifier, IcureStub, LabelledOccurence, SubscriptionEventType, EntitySubscriptionConfiguration, ShareMetadataBehaviour, RequestedPermission, deserialize_simple_share_result, SimpleShareResult, ContactShareOptions, FilterChain, PaginatedList
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import List, Optional, Dict
from icure.model.specializations import HexString
from icure.subscription.EntitySubscription import EntitySubscription
from icure.pagination.PaginatedListIterator import PaginatedListIterator

class ContactApi:

	class ContactFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, contact: EncryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, contact: EncryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"contact": contact.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.shareWithBlocking(
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

		async def try_share_with_many_async(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedContact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedContact](
						producer = success,
						deserializer = lambda x: EncryptedContact._deserialize(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.findContactsByHcPartyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.findContactsByHcPartyPatientBlocking(
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
				return PaginatedListIterator[EncryptedContact](
					producer = class_pointer,
					deserializer = lambda x: EncryptedContact._deserialize(x),
					executor = self.icure_sdk._executor
				)

		async def modify_contact_async(self, entity: EncryptedContact) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedContact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.modifyContactAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_contact_blocking(self, entity: EncryptedContact) -> EncryptedContact:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.modifyContactBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def modify_contacts_async(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.modifyContactsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_contacts_blocking(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.modifyContactsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_contact_async(self, entity_id: str) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedContact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getContactAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_contact_blocking(self, entity_id: str) -> EncryptedContact:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getContactBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getContactsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[EncryptedContact]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getContactsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedContact._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.filterContactsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.filterContactsByBlocking(
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
					rows = [EncryptedContact._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"serviceId": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactByHCPartyServiceIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactByHCPartyServiceIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_external_id_async(self, external_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalId": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByExternalIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_external_id_blocking(self, external_id: str) -> List[EncryptedContact]:
			payload = {
				"externalId": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByExternalIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"formId": form_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndFormIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"formId": form_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndFormIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"formIds": [x0 for x0 in form_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndFormIdsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"formIds": [x0 for x0 in form_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndFormIdsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
				"planOfActionsIds": plan_of_actions_ids,
				"skipClosedContacts": skip_closed_contacts,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndPatientSecretFKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
				"planOfActionsIds": plan_of_actions_ids,
				"skipClosedContacts": skip_closed_contacts,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listContactsByHCPartyAndPatientSecretFKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.closeForHCPartyPatientForeignKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedContact]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.closeForHCPartyPatientForeignKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_service_async(self, service_id: str) -> object:
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
				"serviceId": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServiceAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_service_blocking(self, service_id: str) -> object:
			payload = {
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServiceBlocking(
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

		async def get_services_async(self, entity_ids: List[str]) -> List[object]:
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
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServicesAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_services_blocking(self, entity_ids: List[str]) -> List[object]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServicesBlocking(
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

		async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[object]:
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
				"linkType": link_type,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServicesLinkedToAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[object]:
			payload = {
				"linkType": link_type,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.getServicesLinkedToBlocking(
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

		async def list_services_by_association_id_async(self, association_id: str) -> List[object]:
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
				"associationId": association_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listServicesByAssociationIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_services_by_association_id_blocking(self, association_id: str) -> List[object]:
			payload = {
				"associationId": association_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listServicesByAssociationIdBlocking(
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

		async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[object]:
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
				"hcPartyId": hc_party_id,
				"healthElementId": health_element_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listServicesByHealthElementIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[object]:
			payload = {
				"hcPartyId": hc_party_id,
				"healthElementId": health_element_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.listServicesByHealthElementIdBlocking(
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

		async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedContact._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"hcPartyId": hc_party_id,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.findContactsByOpeningDateAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"hcPartyId": hc_party_id,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.findContactsByOpeningDateBlocking(
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
					rows = [EncryptedContact._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
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
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.filterServicesByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.encrypted.filterServicesByBlocking(
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

	class ContactFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, contact: Contact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, contact: Contact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"contact": contact.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.shareWithBlocking(
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

		async def try_share_with_many_async(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Contact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Contact._deserialize(result_info.success)
				return return_value

		async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[Contact](
						producer = success,
						deserializer = lambda x: deserialize_contact(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.findContactsByHcPartyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.findContactsByHcPartyPatientBlocking(
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
				return PaginatedListIterator[Contact](
					producer = class_pointer,
					deserializer = lambda x: deserialize_contact(x),
					executor = self.icure_sdk._executor
				)

		async def modify_contact_async(self, entity: Contact) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Contact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.modifyContactAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_contact_blocking(self, entity: Contact) -> Contact:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.modifyContactBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Contact._deserialize(result_info.success)
				return return_value

		async def modify_contacts_async(self, entities: List[Contact]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.modifyContactsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_contacts_blocking(self, entities: List[Contact]) -> List[Contact]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.modifyContactsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_contact_async(self, entity_id: str) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Contact._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getContactAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_contact_blocking(self, entity_id: str) -> Contact:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getContactBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Contact._deserialize(result_info.success)
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getContactsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[Contact]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getContactsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_contact(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.filterContactsByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.filterContactsByBlocking(
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
					rows = [deserialize_contact(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"serviceId": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactByHCPartyServiceIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactByHCPartyServiceIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_external_id_async(self, external_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalId": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByExternalIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_external_id_blocking(self, external_id: str) -> List[Contact]:
			payload = {
				"externalId": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByExternalIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"formId": form_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndFormIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"formId": form_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndFormIdBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"formIds": [x0 for x0 in form_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndFormIdsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"formIds": [x0 for x0 in form_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndFormIdsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
				"planOfActionsIds": plan_of_actions_ids,
				"skipClosedContacts": skip_closed_contacts,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
				"planOfActionsIds": plan_of_actions_ids,
				"skipClosedContacts": skip_closed_contacts,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Contact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.closeForHCPartyPatientForeignKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Contact]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.closeForHCPartyPatientForeignKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_service_async(self, service_id: str) -> object:
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
				"serviceId": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServiceAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_service_blocking(self, service_id: str) -> object:
			payload = {
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServiceBlocking(
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

		async def get_services_async(self, entity_ids: List[str]) -> List[object]:
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
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServicesAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_services_blocking(self, entity_ids: List[str]) -> List[object]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServicesBlocking(
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

		async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[object]:
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
				"linkType": link_type,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServicesLinkedToAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[object]:
			payload = {
				"linkType": link_type,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.getServicesLinkedToBlocking(
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

		async def list_services_by_association_id_async(self, association_id: str) -> List[object]:
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
				"associationId": association_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listServicesByAssociationIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_services_by_association_id_blocking(self, association_id: str) -> List[object]:
			payload = {
				"associationId": association_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listServicesByAssociationIdBlocking(
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

		async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[object]:
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
				"hcPartyId": hc_party_id,
				"healthElementId": health_element_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listServicesByHealthElementIdAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[object]:
			payload = {
				"hcPartyId": hc_party_id,
				"healthElementId": health_element_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.listServicesByHealthElementIdBlocking(
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

		async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_contact(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"hcPartyId": hc_party_id,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.findContactsByOpeningDateAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"startDate": start_date,
				"endDate": end_date,
				"hcPartyId": hc_party_id,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.findContactsByOpeningDateBlocking(
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
					rows = [deserialize_contact(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
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
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.filterServicesByAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filterChain": filter_chain.__serialize__(),
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryAndRecover.filterServicesByBlocking(
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

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = ContactApi.ContactFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = ContactApi.ContactFlavouredApi(self.icure_sdk)

	async def create_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createContactAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createContactBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def create_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createContactsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createContactsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.withEncryptionMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedContact:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.withEncryptionMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, contact: Contact) -> List[HexString]:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getEncryptionKeysOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, contact: Contact) -> List[HexString]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, contact: Contact) -> bool:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.hasWriteAccessAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, contact: Contact) -> bool:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, contact: Contact) -> List[str]:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptPatientIdOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, contact: Contact) -> List[str]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Contact, delegates: List[str]) -> None:
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
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Contact, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def decrypt_async(self, contact: EncryptedContact) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contact": contact.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, contact: EncryptedContact) -> DecryptedContact:
		payload = {
			"contact": contact.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, contact: EncryptedContact) -> Contact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_contact(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contact": contact.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryDecryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, contact: EncryptedContact) -> Contact:
		payload = {
			"contact": contact.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryDecryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_contact(result_info.success)
			return return_value

	async def decrypt_service_async(self, service: EncryptedService) -> DecryptedService:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedService._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"service": service.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptServiceAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_service_blocking(self, service: EncryptedService) -> DecryptedService:
		payload = {
			"service": service.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.decryptServiceBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedService._deserialize(result_info.success)
			return return_value

	async def try_decrypt_service_async(self, service: EncryptedService) -> Service:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_service(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"service": service.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryDecryptServiceAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_service_blocking(self, service: EncryptedService) -> Service:
		payload = {
			"service": service.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryDecryptServiceBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_service(result_info.success)
			return return_value

	async def match_contacts_by_async(self, filter: ContactAbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.matchContactsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_contacts_by_blocking(self, filter: ContactAbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.matchContactsByBlocking(
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

	async def match_services_by_async(self, filter: ServiceAbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.matchServicesByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_services_by_blocking(self, filter: ServiceAbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.matchServicesByBlocking(
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

	async def delete_contact_async(self, entity_id: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.deleteContactAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_contact_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.deleteContactBlocking(
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

	async def delete_contacts_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.deleteContactsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_contacts_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.deleteContactsBlocking(
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

	async def find_contacts_delegations_stubs_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [IcureStub._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsDelegationsStubsByHcPartyPatientForeignKeysAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_contacts_delegations_stubs_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsDelegationsStubsByHcPartyPatientForeignKeysBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [IcureStub._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_service_codes_occurrences_async(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [LabelledOccurence._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"codeType": code_type,
			"minOccurrences": min_occurrences,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServiceCodesOccurrencesAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_service_codes_occurrences_blocking(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		payload = {
			"codeType": code_type,
			"minOccurrences": min_occurrences,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServiceCodesOccurrencesBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [LabelledOccurence._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_service_events_async(self, events: List[SubscriptionEventType], filter: ServiceAbstractFilter, subscription_config: EntitySubscriptionConfiguration) -> EntitySubscription[EncryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntitySubscription[EncryptedService](
					producer = success,
					deserializer = lambda x: EncryptedService._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.subscribeToServiceEventsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_service_events_blocking(self, events: List[SubscriptionEventType], filter: ServiceAbstractFilter, subscription_config: EntitySubscriptionConfiguration) -> EntitySubscription[EncryptedService]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.subscribeToServiceEventsBlocking(
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
			return EntitySubscription[EncryptedService](
				producer = class_pointer,
				deserializer = lambda x: EncryptedService._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: ContactAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntitySubscription[EncryptedContact](
					producer = success,
					deserializer = lambda x: EncryptedContact._deserialize(x),
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
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.subscribeToEventsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: ContactAbstractFilter, subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedContact]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": serialize_abstract_filter(filter),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedContact](
				producer = class_pointer,
				deserializer = lambda x: EncryptedContact._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def share_with_async(self, delegate_id: str, contact: DecryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
			"contact": contact.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.shareWithAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, contact: DecryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegateId": delegate_id,
			"contact": contact.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.shareWithBlocking(
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

	async def try_share_with_many_async(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryShareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.tryShareWithManyBlocking(
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

	async def share_with_many_async(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.shareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.shareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedContact](
					producer = success,
					deserializer = lambda x: DecryptedContact._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"patient": serialize_patient(patient),
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsByHcPartyPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"patient": serialize_patient(patient),
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsByHcPartyPatientBlocking(
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
			return PaginatedListIterator[DecryptedContact](
				producer = class_pointer,
				deserializer = lambda x: DecryptedContact._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def modify_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.modifyContactAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.modifyContactBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def modify_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.modifyContactsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.modifyContactsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_contact_async(self, entity_id: str) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedContact._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getContactAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_contact_blocking(self, entity_id: str) -> DecryptedContact:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getContactBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def get_contacts_async(self, entity_ids: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getContactsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_contacts_blocking(self, entity_ids: List[str]) -> List[DecryptedContact]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getContactsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedContact._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.filterContactsByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.filterContactsByBlocking(
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
				rows = [DecryptedContact._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"serviceId": service_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactByHCPartyServiceIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"serviceId": service_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactByHCPartyServiceIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_contacts_by_external_id_async(self, external_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"externalId": external_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByExternalIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_contacts_by_external_id_blocking(self, external_id: str) -> List[DecryptedContact]:
		payload = {
			"externalId": external_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByExternalIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"formId": form_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndFormIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"formId": form_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndFormIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"formIds": [x0 for x0 in form_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndFormIdsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"formIds": [x0 for x0 in form_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndFormIdsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			"planOfActionsIds": plan_of_actions_ids,
			"skipClosedContacts": skip_closed_contacts,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndPatientSecretFKeysAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			"planOfActionsIds": plan_of_actions_ids,
			"skipClosedContacts": skip_closed_contacts,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listContactsByHCPartyAndPatientSecretFKeysBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedContact._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.closeForHCPartyPatientForeignKeysAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedContact]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.closeForHCPartyPatientForeignKeysBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_service_async(self, service_id: str) -> DecryptedService:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedService._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"serviceId": service_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServiceAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_service_blocking(self, service_id: str) -> DecryptedService:
		payload = {
			"serviceId": service_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServiceBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedService._deserialize(result_info.success)
			return return_value

	async def get_services_async(self, entity_ids: List[str]) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedService._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServicesAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_services_blocking(self, entity_ids: List[str]) -> List[DecryptedService]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServicesBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedService._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"linkType": link_type,
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServicesLinkedToAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[DecryptedService]:
		payload = {
			"linkType": link_type,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.getServicesLinkedToBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_services_by_association_id_async(self, association_id: str) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedService._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"associationId": association_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listServicesByAssociationIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_services_by_association_id_blocking(self, association_id: str) -> List[DecryptedService]:
		payload = {
			"associationId": association_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listServicesByAssociationIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedService._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"healthElementId": health_element_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listServicesByHealthElementIdAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[DecryptedService]:
		payload = {
			"hcPartyId": hc_party_id,
			"healthElementId": health_element_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.listServicesByHealthElementIdBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedContact._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"hcPartyId": hc_party_id,
			"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsByOpeningDateAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"startDate": start_date,
			"endDate": end_date,
			"hcPartyId": hc_party_id,
			"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.findContactsByOpeningDateBlocking(
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
				rows = [DecryptedContact._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedService._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.filterServicesByAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		payload = {
			"filterChain": filter_chain.__serialize__(),
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.ContactApi.filterServicesByBlocking(
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
				rows = [DecryptedService._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value
