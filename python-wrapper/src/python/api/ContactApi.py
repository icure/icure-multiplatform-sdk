# auto-generated file
import json
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.model import Contact, Service, DecryptedContact, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, serialize_contact, EncryptedContact, deserialize_contact, EncryptedService, DecryptedService, deserialize_service, EntitySubscriptionConfiguration, DocIdentifier, IdWithMandatoryRev, LabelledOccurence, ContactShareOptions, SubscriptionEventType
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import List, Optional, Dict
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class ContactApi:

	class ContactFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, contact: EncryptedContact, options: Optional[ContactShareOptions] = None) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"delegateId": delegate_id,
				"contact": contact.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_blocking(self, delegate_id: str, contact: EncryptedContact, options: Optional[ContactShareOptions] = None) -> EncryptedContact:
			payload = {
				"delegateId": delegate_id,
				"contact": contact.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def share_with_many_async(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_many_blocking(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def filter_contacts_by_async(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[EncryptedContact]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedContact](
					producer = raw_result,
					deserializer = lambda x: EncryptedContact._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterContactsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_contacts_by_blocking(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[EncryptedContact]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterContactsByBlocking(
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
				return PaginatedListIterator[EncryptedContact](
					producer = class_pointer,
					deserializer = lambda x: EncryptedContact._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_services_by_async(self, filter: FilterOptions[Service]) -> PaginatedListIterator[EncryptedService]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedService](
					producer = raw_result,
					deserializer = lambda x: EncryptedService._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterServicesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_services_by_blocking(self, filter: FilterOptions[Service]) -> PaginatedListIterator[EncryptedService]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterServicesByBlocking(
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
				return PaginatedListIterator[EncryptedService](
					producer = class_pointer,
					deserializer = lambda x: EncryptedService._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_contacts_by_sorted_async(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[EncryptedContact]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedContact](
					producer = raw_result,
					deserializer = lambda x: EncryptedContact._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterContactsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_contacts_by_sorted_blocking(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[EncryptedContact]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterContactsBySortedBlocking(
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
				return PaginatedListIterator[EncryptedContact](
					producer = class_pointer,
					deserializer = lambda x: EncryptedContact._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_services_by_sorted_async(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[EncryptedService]:
			def do_decode(raw_result):
				return PaginatedListIterator[EncryptedService](
					producer = raw_result,
					deserializer = lambda x: EncryptedService._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterServicesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_services_by_sorted_blocking(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[EncryptedService]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.filterServicesBySortedBlocking(
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
				return PaginatedListIterator[EncryptedService](
					producer = class_pointer,
					deserializer = lambda x: EncryptedService._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_contact_by_id_async(self, id: str, rev: str) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"id": id,
				"rev": rev,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.undeleteContactByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_contact_by_id_blocking(self, id: str, rev: str) -> EncryptedContact:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.undeleteContactByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def undelete_contact_async(self, contact: Contact) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"contact": serialize_contact(contact),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.undeleteContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_contact_blocking(self, contact: Contact) -> EncryptedContact:
			payload = {
				"contact": serialize_contact(contact),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.undeleteContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def modify_contact_async(self, entity: EncryptedContact) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"entity": entity.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.modifyContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_contact_blocking(self, entity: EncryptedContact) -> EncryptedContact:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.modifyContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def modify_contacts_async(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			def do_decode(raw_result):
				return [EncryptedContact._deserialize(x1) for x1 in raw_result]
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.modifyContactsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_contacts_blocking(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.modifyContactsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_contact_async(self, entity_id: str) -> EncryptedContact:
			def do_decode(raw_result):
				return EncryptedContact._deserialize(raw_result)
			payload = {
				"entityId": entity_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_contact_blocking(self, entity_id: str) -> EncryptedContact:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedContact._deserialize(result_info.success)
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[EncryptedContact]:
			def do_decode(raw_result):
				return [EncryptedContact._deserialize(x1) for x1 in raw_result]
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getContactsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[EncryptedContact]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getContactsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_service_async(self, service_id: str) -> EncryptedService:
			def do_decode(raw_result):
				return EncryptedService._deserialize(raw_result)
			payload = {
				"serviceId": service_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getServiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_service_blocking(self, service_id: str) -> EncryptedService:
			payload = {
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getServiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedService._deserialize(result_info.success)
				return return_value

		async def get_services_async(self, entity_ids: List[str]) -> List[EncryptedService]:
			def do_decode(raw_result):
				return [EncryptedService._deserialize(x1) for x1 in raw_result]
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getServicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_services_blocking(self, entity_ids: List[str]) -> List[EncryptedService]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.encrypted.getServicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedService._deserialize(x1) for x1 in result_info.success]
				return return_value

	class ContactFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, contact: Contact, options: Optional[ContactShareOptions] = None) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"delegateId": delegate_id,
				"contact": serialize_contact(contact),
				"options": options.__serialize__() if options is not None else None,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_blocking(self, delegate_id: str, contact: Contact, options: Optional[ContactShareOptions] = None) -> Contact:
			payload = {
				"delegateId": delegate_id,
				"contact": serialize_contact(contact),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def share_with_many_async(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"contact": serialize_contact(contact),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def share_with_many_blocking(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			payload = {
				"contact": serialize_contact(contact),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def filter_contacts_by_async(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[Contact]:
			def do_decode(raw_result):
				return PaginatedListIterator[Contact](
					producer = raw_result,
					deserializer = lambda x: deserialize_contact(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterContactsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_contacts_by_blocking(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[Contact]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterContactsByBlocking(
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
				return PaginatedListIterator[Contact](
					producer = class_pointer,
					deserializer = lambda x: deserialize_contact(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_services_by_async(self, filter: FilterOptions[Service]) -> PaginatedListIterator[Service]:
			def do_decode(raw_result):
				return PaginatedListIterator[Service](
					producer = raw_result,
					deserializer = lambda x: deserialize_service(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterServicesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_services_by_blocking(self, filter: FilterOptions[Service]) -> PaginatedListIterator[Service]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterServicesByBlocking(
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
				return PaginatedListIterator[Service](
					producer = class_pointer,
					deserializer = lambda x: deserialize_service(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_contacts_by_sorted_async(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[Contact]:
			def do_decode(raw_result):
				return PaginatedListIterator[Contact](
					producer = raw_result,
					deserializer = lambda x: deserialize_contact(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterContactsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_contacts_by_sorted_blocking(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[Contact]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterContactsBySortedBlocking(
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
				return PaginatedListIterator[Contact](
					producer = class_pointer,
					deserializer = lambda x: deserialize_contact(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_services_by_sorted_async(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[Service]:
			def do_decode(raw_result):
				return PaginatedListIterator[Service](
					producer = raw_result,
					deserializer = lambda x: deserialize_service(x),
					executor = self.cardinal_sdk._executor
				)
			payload = {
				"filter": filter.__serialize__(),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				False,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterServicesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def filter_services_by_sorted_blocking(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[Service]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.filterServicesBySortedBlocking(
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
				return PaginatedListIterator[Service](
					producer = class_pointer,
					deserializer = lambda x: deserialize_service(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_contact_by_id_async(self, id: str, rev: str) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"id": id,
				"rev": rev,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.undeleteContactByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_contact_by_id_blocking(self, id: str, rev: str) -> Contact:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.undeleteContactByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def undelete_contact_async(self, contact: Contact) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"contact": serialize_contact(contact),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.undeleteContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def undelete_contact_blocking(self, contact: Contact) -> Contact:
			payload = {
				"contact": serialize_contact(contact),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.undeleteContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def modify_contact_async(self, entity: Contact) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"entity": serialize_contact(entity),
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.modifyContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_contact_blocking(self, entity: Contact) -> Contact:
			payload = {
				"entity": serialize_contact(entity),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.modifyContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def modify_contacts_async(self, entities: List[Contact]) -> List[Contact]:
			def do_decode(raw_result):
				return [deserialize_contact(x1) for x1 in raw_result]
			payload = {
				"entities": [serialize_contact(x0) for x0 in entities],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.modifyContactsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def modify_contacts_blocking(self, entities: List[Contact]) -> List[Contact]:
			payload = {
				"entities": [serialize_contact(x0) for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.modifyContactsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_contact(x1) for x1 in result_info.success]
				return return_value

		async def get_contact_async(self, entity_id: str) -> Contact:
			def do_decode(raw_result):
				return deserialize_contact(raw_result)
			payload = {
				"entityId": entity_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getContactAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_contact_blocking(self, entity_id: str) -> Contact:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getContactBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_contact(result_info.success)
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[Contact]:
			def do_decode(raw_result):
				return [deserialize_contact(x1) for x1 in raw_result]
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getContactsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[Contact]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getContactsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_contact(x1) for x1 in result_info.success]
				return return_value

		async def get_service_async(self, service_id: str) -> Service:
			def do_decode(raw_result):
				return deserialize_service(raw_result)
			payload = {
				"serviceId": service_id,
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getServiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_service_blocking(self, service_id: str) -> Service:
			payload = {
				"serviceId": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getServiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_service(result_info.success)
				return return_value

		async def get_services_async(self, entity_ids: List[str]) -> List[Service]:
			def do_decode(raw_result):
				return [deserialize_service(x1) for x1 in raw_result]
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			return await execute_async_method_job(
				self.cardinal_sdk._executor,
				True,
				do_decode,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getServicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)

		def get_services_blocking(self, entity_ids: List[str]) -> List[Service]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryAndRecover.getServicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_service(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = ContactApi.ContactFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = ContactApi.ContactFlavouredApi(self.cardinal_sdk)

	async def match_contacts_by_async(self, filter: FilterOptions[Contact]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchContactsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_contacts_by_blocking(self, filter: FilterOptions[Contact]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchContactsByBlocking(
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

	async def match_services_by_async(self, filter: FilterOptions[Service]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchServicesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_services_by_blocking(self, filter: FilterOptions[Service]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchServicesByBlocking(
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

	async def match_contacts_by_sorted_async(self, filter: SortableFilterOptions[Contact]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchContactsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_contacts_by_sorted_blocking(self, filter: SortableFilterOptions[Contact]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchContactsBySortedBlocking(
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

	async def match_services_by_sorted_async(self, filter: SortableFilterOptions[Service]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchServicesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_services_by_sorted_blocking(self, filter: SortableFilterOptions[Service]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.matchServicesBySortedBlocking(
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

	async def create_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def create_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		def do_decode(raw_result):
			return [DecryptedContact._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createContactsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createContactsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedContact:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, contact: Contact) -> List[HexString]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_encryption_keys_of_blocking(self, contact: Contact) -> List[HexString]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, contact: Contact) -> bool:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def has_write_access_blocking(self, contact: Contact) -> bool:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, contact: Contact) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_patient_id_of_blocking(self, contact: Contact) -> List[str]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Contact, delegates: List[str]) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Contact, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, contact: EncryptedContact) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"contact": contact.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_blocking(self, contact: EncryptedContact) -> DecryptedContact:
		payload = {
			"contact": contact.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, contact: EncryptedContact) -> Contact:
		def do_decode(raw_result):
			return deserialize_contact(raw_result)
		payload = {
			"contact": contact.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_blocking(self, contact: EncryptedContact) -> Contact:
		payload = {
			"contact": contact.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_contact(result_info.success)
			return return_value

	async def decrypt_service_async(self, service: EncryptedService) -> DecryptedService:
		def do_decode(raw_result):
			return DecryptedService._deserialize(raw_result)
		payload = {
			"service": service.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptServiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def decrypt_service_blocking(self, service: EncryptedService) -> DecryptedService:
		payload = {
			"service": service.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.decryptServiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedService._deserialize(result_info.success)
			return return_value

	async def try_decrypt_service_async(self, service: EncryptedService) -> Service:
		def do_decode(raw_result):
			return deserialize_service(raw_result)
		payload = {
			"service": service.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryDecryptServiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def try_decrypt_service_blocking(self, service: EncryptedService) -> Service:
		payload = {
			"service": service.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.tryDecryptServiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_service(result_info.success)
			return return_value

	async def subscribe_to_service_create_or_update_events_async(self, filter: FilterOptions[Service], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedService]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedService](
				producer = raw_result,
				deserializer = lambda x: EncryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.subscribeToServiceCreateOrUpdateEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_service_create_or_update_events_blocking(self, filter: FilterOptions[Service], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedService]:
		payload = {
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.subscribeToServiceCreateOrUpdateEventsBlocking(
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
			return EntitySubscription[EncryptedService](
				producer = class_pointer,
				deserializer = lambda x: EncryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def delete_contact_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_contact_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_contacts_by_ids_async(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_contacts_by_ids_blocking(self, entity_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactsByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_contact_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.purgeContactByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_contact_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.purgeContactByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_contact_async(self, contact: Contact) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_contact_blocking(self, contact: Contact) -> DocIdentifier:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_contacts_async(self, contacts: List[Contact]) -> List[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"contacts": [serialize_contact(x0) for x0 in contacts],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_contacts_blocking(self, contacts: List[Contact]) -> List[DocIdentifier]:
		payload = {
			"contacts": [serialize_contact(x0) for x0 in contacts],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.deleteContactsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def purge_contact_async(self, contact: Contact) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.purgeContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_contact_blocking(self, contact: Contact) -> None:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.purgeContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def get_service_codes_occurrences_async(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		def do_decode(raw_result):
			return [LabelledOccurence._deserialize(x1) for x1 in raw_result]
		payload = {
			"codeType": code_type,
			"minOccurrences": min_occurrences,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServiceCodesOccurrencesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_service_codes_occurrences_blocking(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		payload = {
			"codeType": code_type,
			"minOccurrences": min_occurrences,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServiceCodesOccurrencesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [LabelledOccurence._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate_id: str, contact: DecryptedContact, options: Optional[ContactShareOptions] = None) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"delegateId": delegate_id,
			"contact": contact.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_blocking(self, delegate_id: str, contact: DecryptedContact, options: Optional[ContactShareOptions] = None) -> DecryptedContact:
		payload = {
			"delegateId": delegate_id,
			"contact": contact.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def share_with_many_blocking(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def filter_contacts_by_async(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[DecryptedContact]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedContact](
				producer = raw_result,
				deserializer = lambda x: DecryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterContactsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_contacts_by_blocking(self, filter: FilterOptions[Contact]) -> PaginatedListIterator[DecryptedContact]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterContactsByBlocking(
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
			return PaginatedListIterator[DecryptedContact](
				producer = class_pointer,
				deserializer = lambda x: DecryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_services_by_async(self, filter: FilterOptions[Service]) -> PaginatedListIterator[DecryptedService]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedService](
				producer = raw_result,
				deserializer = lambda x: DecryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterServicesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_services_by_blocking(self, filter: FilterOptions[Service]) -> PaginatedListIterator[DecryptedService]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterServicesByBlocking(
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
			return PaginatedListIterator[DecryptedService](
				producer = class_pointer,
				deserializer = lambda x: DecryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_contacts_by_sorted_async(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[DecryptedContact]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedContact](
				producer = raw_result,
				deserializer = lambda x: DecryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterContactsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_contacts_by_sorted_blocking(self, filter: SortableFilterOptions[Contact]) -> PaginatedListIterator[DecryptedContact]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterContactsBySortedBlocking(
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
			return PaginatedListIterator[DecryptedContact](
				producer = class_pointer,
				deserializer = lambda x: DecryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_services_by_sorted_async(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[DecryptedService]:
		def do_decode(raw_result):
			return PaginatedListIterator[DecryptedService](
				producer = raw_result,
				deserializer = lambda x: DecryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterServicesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_services_by_sorted_blocking(self, filter: SortableFilterOptions[Service]) -> PaginatedListIterator[DecryptedService]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.filterServicesBySortedBlocking(
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
			return PaginatedListIterator[DecryptedService](
				producer = class_pointer,
				deserializer = lambda x: DecryptedService._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def undelete_contact_by_id_async(self, id: str, rev: str) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.undeleteContactByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_contact_by_id_blocking(self, id: str, rev: str) -> DecryptedContact:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.undeleteContactByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def undelete_contact_async(self, contact: Contact) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"contact": serialize_contact(contact),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.undeleteContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_contact_blocking(self, contact: Contact) -> DecryptedContact:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.undeleteContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def modify_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.modifyContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.modifyContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def modify_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		def do_decode(raw_result):
			return [DecryptedContact._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.modifyContactsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.modifyContactsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_contact_async(self, entity_id: str) -> DecryptedContact:
		def do_decode(raw_result):
			return DecryptedContact._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getContactAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_contact_blocking(self, entity_id: str) -> DecryptedContact:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getContactBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedContact._deserialize(result_info.success)
			return return_value

	async def get_contacts_async(self, entity_ids: List[str]) -> List[DecryptedContact]:
		def do_decode(raw_result):
			return [DecryptedContact._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getContactsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_contacts_blocking(self, entity_ids: List[str]) -> List[DecryptedContact]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getContactsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_service_async(self, service_id: str) -> DecryptedService:
		def do_decode(raw_result):
			return DecryptedService._deserialize(raw_result)
		payload = {
			"serviceId": service_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_service_blocking(self, service_id: str) -> DecryptedService:
		payload = {
			"serviceId": service_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedService._deserialize(result_info.success)
			return return_value

	async def get_services_async(self, entity_ids: List[str]) -> List[DecryptedService]:
		def do_decode(raw_result):
			return [DecryptedService._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_services_blocking(self, entity_ids: List[str]) -> List[DecryptedService]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.getServicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: FilterOptions[Contact], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedContact]:
		def do_decode(raw_result):
			return EntitySubscription[EncryptedContact](
				producer = raw_result,
				deserializer = lambda x: EncryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: FilterOptions[Contact], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[EncryptedContact]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ContactApi.subscribeToEventsBlocking(
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
			return EntitySubscription[EncryptedContact](
				producer = class_pointer,
				deserializer = lambda x: EncryptedContact._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
