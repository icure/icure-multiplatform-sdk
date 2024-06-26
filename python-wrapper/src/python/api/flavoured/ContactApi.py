import asyncio
import json
from model.Contact import DecryptedContact, Contact, serialize_contact
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from ctypes import cast, c_char_p, c_void_p
from typing import List, Optional, Dict
from model.Patient import Patient, serialize_patient
from model.User import User
from model.embed.AccessLevel import AccessLevel
from dataclasses import field
from crypto.entities.SecretIdOption import SecretIdOption, serialize_secret_id_option
from model.specializations.HexString import HexString
from model.filter.AbstractFilter import AbstractFilter, serialize_abstract_filter
from model.couchdb.DocIdentifier import DocIdentifier
from model.IcureStub import IcureStub
from model.data.LabelledOccurence import LabelledOccurence
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.SimpleShareResult import deserialize_simple_share_result, SimpleShareResult
from crypto.entities.ContactShareOptions import ContactShareOptions
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult
from model.filter.chain.FilterChain import FilterChain
from model.PaginatedList import PaginatedList
from model.embed.Service import DecryptedService

class ContactApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = ContactFlavouredEncryptedApi(executor)
		self.tryAndRecover = ContactFlavouredApi(executor)

	async def create_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedContact._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createContactAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createContactBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedContact._deserialize(result_info["success"])
			return return_value

	async def create_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createContactsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createContactsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedContact._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedContact], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedContact:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedContact._deserialize(result_info["success"])
			return return_value

	async def get_encryption_keys_of_async(self, contact: Contact) -> List[HexString]:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, contact: Contact) -> List[HexString]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, contact: Contact) -> bool:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, contact: Contact) -> bool:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.hasWriteAccessBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def decrypt_patient_id_of_async(self, contact: Contact) -> List[str]:
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
			"contact": serialize_contact(contact),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, contact: Contact) -> List[str]:
		payload = {
			"contact": serialize_contact(contact),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Contact, delegates: List[str]) -> None:
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
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Contact, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_contact(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def match_contacts_by_async(self, filter: AbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.matchContactsByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_contacts_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.matchContactsByBlocking(
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

	async def match_services_by_async(self, filter: AbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.matchServicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_services_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.matchServicesByBlocking(
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

	async def delete_contact_async(self, entity_id: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.deleteContactAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_contact_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.deleteContactBlocking(
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

	async def delete_contacts_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.deleteContactsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_contacts_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.deleteContactsBlocking(
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

	async def find_contacts_delegations_stubs_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IcureStub._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.findContactsDelegationsStubsByHcPartyPatientForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_contacts_delegations_stubs_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.findContactsDelegationsStubsByHcPartyPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IcureStub._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_service_codes_occurrences_async(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [LabelledOccurence._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"code_type": code_type,
			"min_occurrences": min_occurrences,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.getServiceCodesOccurrencesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_service_codes_occurrences_blocking(self, code_type: str, min_occurrences: int) -> List[LabelledOccurence]:
		payload = {
			"code_type": code_type,
			"min_occurrences": min_occurrences,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavourlessApi.getServiceCodesOccurrencesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [LabelledOccurence._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def share_with_async(self, delegate_id: str, contact: DecryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
			"contact": contact.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, contact: DecryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"contact": contact.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def try_share_with_many_async(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def share_with_many_async(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedContact._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, contact: DecryptedContact, delegates: Dict[str, ContactShareOptions]) -> DecryptedContact:
		payload = {
			"contact": contact.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedContact._deserialize(result_info["success"])
			return return_value

	async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedContact](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedContact._deserialize(x)
				)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		error_str_pointer = PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result)
			raise Exception(error_msg)
		else:
			class_pointer = PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result)
			return PaginatedListIterator[DecryptedContact](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedContact._deserialize(x)
			)

	async def modify_contact_async(self, entity: DecryptedContact) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedContact._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_contact_blocking(self, entity: DecryptedContact) -> DecryptedContact:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedContact._deserialize(result_info["success"])
			return return_value

	async def modify_contacts_async(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_contacts_blocking(self, entities: List[DecryptedContact]) -> List[DecryptedContact]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_contact_async(self, entity_id: str) -> DecryptedContact:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedContact._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_contact_blocking(self, entity_id: str) -> DecryptedContact:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedContact._deserialize(result_info["success"])
			return return_value

	async def get_contacts_async(self, entity_ids: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_contacts_blocking(self, entity_ids: List[str]) -> List[DecryptedContact]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedContact._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByBlocking(
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
				rows = [DecryptedContact._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"service_id": service_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"service_id": service_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_contacts_by_external_id_async(self, external_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_id": external_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_contacts_by_external_id_blocking(self, external_id: str) -> List[DecryptedContact]:
		payload = {
			"external_id": external_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"form_id": form_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"form_id": form_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"form_ids": [x0 for x0 in form_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"form_ids": [x0 for x0 in form_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			"plan_of_actions_ids": plan_of_actions_ids,
			"skip_closed_contacts": skip_closed_contacts,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			"plan_of_actions_ids": plan_of_actions_ids,
			"skip_closed_contacts": skip_closed_contacts,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedContact]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedContact]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedContact._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_service_async(self, service_id: str) -> DecryptedService:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedService._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"service_id": service_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_service_blocking(self, service_id: str) -> DecryptedService:
		payload = {
			"service_id": service_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedService._deserialize(result_info["success"])
			return return_value

	async def get_services_async(self, entity_ids: List[str]) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_services_blocking(self, entity_ids: List[str]) -> List[DecryptedService]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"link_type": link_type,
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[DecryptedService]:
		payload = {
			"link_type": link_type,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_services_by_association_id_async(self, association_id: str) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"association_id": association_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_services_by_association_id_blocking(self, association_id: str) -> List[DecryptedService]:
		payload = {
			"association_id": association_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[DecryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"health_element_id": health_element_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[DecryptedService]:
		payload = {
			"hc_party_id": hc_party_id,
			"health_element_id": health_element_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedContact._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"hc_party_id": hc_party_id,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"hc_party_id": hc_party_id,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateBlocking(
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
				rows = [DecryptedContact._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedService._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
		payload = {
			"filter_chain": filter_chain.__serialize__(),
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByBlocking(
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
				rows = [DecryptedService._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	class ContactFlavouredEncryptedApi:

		def __init__(self):


		async def share_with_async(self, delegate_id: str, contact: EncryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, contact: EncryptedContact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"contact": contact.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedContact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, contact: EncryptedContact, delegates: Dict[str, ContactShareOptions]) -> EncryptedContact:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedContact._deserialize(result_info["success"])
				return return_value

		async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedContact](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedContact._deserialize(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[EncryptedContact](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedContact._deserialize(x)
				)

		async def modify_contact_async(self, entity: EncryptedContact) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedContact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_contact_blocking(self, entity: EncryptedContact) -> EncryptedContact:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedContact._deserialize(result_info["success"])
				return return_value

		async def modify_contacts_async(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_contacts_blocking(self, entities: List[EncryptedContact]) -> List[EncryptedContact]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_contact_async(self, entity_id: str) -> EncryptedContact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedContact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_contact_blocking(self, entity_id: str) -> EncryptedContact:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedContact._deserialize(result_info["success"])
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[EncryptedContact]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [EncryptedContact._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByBlocking(
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
					rows = [EncryptedContact._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"service_id": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"service_id": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_external_id_async(self, external_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"external_id": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_external_id_blocking(self, external_id: str) -> List[EncryptedContact]:
			payload = {
				"external_id": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"form_id": form_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"form_id": form_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"form_ids": [x0 for x0 in form_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"form_ids": [x0 for x0 in form_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
				"plan_of_actions_ids": plan_of_actions_ids,
				"skip_closed_contacts": skip_closed_contacts,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
				"plan_of_actions_ids": plan_of_actions_ids,
				"skip_closed_contacts": skip_closed_contacts,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedContact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedContact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedContact]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedContact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_service_async(self, service_id: str) -> object:
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
				"service_id": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_service_blocking(self, service_id: str) -> object:
			payload = {
				"service_id": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = result_info["success"]
				return return_value

		async def get_services_async(self, entity_ids: List[str]) -> List[object]:
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
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_services_blocking(self, entity_ids: List[str]) -> List[object]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesBlocking(
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

		async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[object]:
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
				"link_type": link_type,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[object]:
			payload = {
				"link_type": link_type,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToBlocking(
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

		async def list_services_by_association_id_async(self, association_id: str) -> List[object]:
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
				"association_id": association_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_services_by_association_id_blocking(self, association_id: str) -> List[object]:
			payload = {
				"association_id": association_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdBlocking(
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

		async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[object]:
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
				"hc_party_id": hc_party_id,
				"health_element_id": health_element_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[object]:
			payload = {
				"hc_party_id": hc_party_id,
				"health_element_id": health_element_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdBlocking(
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

		async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [EncryptedContact._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateBlocking(
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
					rows = [EncryptedContact._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
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
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByBlocking(
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
					rows = [item for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

	class ContactFlavouredApi:

		def __init__(self):


		async def share_with_async(self, delegate_id: str, contact: Contact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, contact: Contact, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"contact": contact.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
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
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> SimpleShareResult:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Contact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, contact: Contact, delegates: Dict[str, ContactShareOptions]) -> Contact:
			payload = {
				"contact": contact.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Contact._deserialize(result_info["success"])
				return return_value

		async def find_contacts_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[Contact](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_contact(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_contacts_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactFlavouredApi.findContactsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[Contact](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_contact(x)
				)

		async def modify_contact_async(self, entity: Contact) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Contact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_contact_blocking(self, entity: Contact) -> Contact:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Contact._deserialize(result_info["success"])
				return return_value

		async def modify_contacts_async(self, entities: List[Contact]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_contacts_blocking(self, entities: List[Contact]) -> List[Contact]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.modifyContactsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_contact_async(self, entity_id: str) -> Contact:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Contact._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_contact_blocking(self, entity_id: str) -> Contact:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Contact._deserialize(result_info["success"])
				return return_value

		async def get_contacts_async(self, entity_ids: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_contacts_blocking(self, entity_ids: List[str]) -> List[Contact]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getContactsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_contacts_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [deserialize_contact(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_contacts_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterContactsByBlocking(
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
					rows = [deserialize_contact(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_contact_by_hcparty_service_id_async(self, hc_party_id: str, service_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"service_id": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contact_by_hcparty_service_id_blocking(self, hc_party_id: str, service_id: str) -> List[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"service_id": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactByHCPartyServiceIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_external_id_async(self, external_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"external_id": external_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_external_id_blocking(self, external_id: str) -> List[Contact]:
			payload = {
				"external_id": external_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByExternalIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_form_id_async(self, hc_party_id: str, form_id: str) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"form_id": form_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_id_blocking(self, hc_party_id: str, form_id: str) -> List[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"form_id": form_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_form_ids_async(self, hc_party_id: str, form_ids: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"form_ids": [x0 for x0 in form_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_form_ids_blocking(self, hc_party_id: str, form_ids: List[str]) -> List[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"form_ids": [x0 for x0 in form_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndFormIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_contacts_by_hcparty_and_patient_secret_fkeys_async(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
				"plan_of_actions_ids": plan_of_actions_ids,
				"skip_closed_contacts": skip_closed_contacts,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_contacts_by_hcparty_and_patient_secret_fkeys_blocking(self, hc_party_id: str, secret_patient_keys: List[str], plan_of_actions_ids: Optional[str] = None, skip_closed_contacts: Optional[bool] = None) -> List[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
				"plan_of_actions_ids": plan_of_actions_ids,
				"skip_closed_contacts": skip_closed_contacts,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listContactsByHCPartyAndPatientSecretFKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def close_for_hcparty_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Contact]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Contact._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def close_for_hcparty_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Contact]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.closeForHCPartyPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Contact._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_service_async(self, service_id: str) -> object:
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
				"service_id": service_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_service_blocking(self, service_id: str) -> object:
			payload = {
				"service_id": service_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = result_info["success"]
				return return_value

		async def get_services_async(self, entity_ids: List[str]) -> List[object]:
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
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_services_blocking(self, entity_ids: List[str]) -> List[object]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesBlocking(
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

		async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[object]:
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
				"link_type": link_type,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[object]:
			payload = {
				"link_type": link_type,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.getServicesLinkedToBlocking(
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

		async def list_services_by_association_id_async(self, association_id: str) -> List[object]:
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
				"association_id": association_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_services_by_association_id_blocking(self, association_id: str) -> List[object]:
			payload = {
				"association_id": association_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByAssociationIdBlocking(
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

		async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[object]:
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
				"hc_party_id": hc_party_id,
				"health_element_id": health_element_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[object]:
			payload = {
				"hc_party_id": hc_party_id,
				"health_element_id": health_element_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.listServicesByHealthElementIdBlocking(
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

		async def find_contacts_by_opening_date_async(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [deserialize_contact(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_contacts_by_opening_date_blocking(self, start_date: int, end_date: int, hc_party_id: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.findContactsByOpeningDateBlocking(
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
					rows = [deserialize_contact(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def filter_services_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
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
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_services_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str], limit: Optional[int]) -> PaginatedList:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.ContactBasicFlavouredApi.filterServicesByBlocking(
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
					rows = [item for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

__all__ = ['ContactApi']