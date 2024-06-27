import asyncio
import json
from model import AbstractFilter, serialize_abstract_filter, DocIdentifier, IcureStub, LabelledOccurence, EncryptedContact, FilterChain, PaginatedList, EncryptedService
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from typing import List, Optional, Dict
from ctypes import cast, c_char_p

class ContactBasicApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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

	async def get_service_async(self, service_id: str) -> EncryptedService:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedService._deserialize(success.decode('utf-8'))
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

	def get_service_blocking(self, service_id: str) -> EncryptedService:
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
			return_value = EncryptedService._deserialize(result_info["success"])
			return return_value

	async def get_services_async(self, entity_ids: List[str]) -> List[EncryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_services_blocking(self, entity_ids: List[str]) -> List[EncryptedService]:
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
			return_value = [EncryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_services_linked_to_async(self, link_type: str, ids: List[str]) -> List[EncryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_services_linked_to_blocking(self, link_type: str, ids: List[str]) -> List[EncryptedService]:
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
			return_value = [EncryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_services_by_association_id_async(self, association_id: str) -> List[EncryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def list_services_by_association_id_blocking(self, association_id: str) -> List[EncryptedService]:
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
			return_value = [EncryptedService._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_services_by_health_element_id_async(self, hc_party_id: str, health_element_id: str) -> List[EncryptedService]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedService._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def list_services_by_health_element_id_blocking(self, hc_party_id: str, health_element_id: str) -> List[EncryptedService]:
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
			return_value = [EncryptedService._deserialize(x1) for x1 in result_info["success"]]
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
					rows = [EncryptedService._deserialize(item) for item in success.rows],
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
				rows = [EncryptedService._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value
