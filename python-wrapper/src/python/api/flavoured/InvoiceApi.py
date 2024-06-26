import asyncio
import json
from model.Invoice import DecryptedInvoice, Invoice, serialize_invoice
from typing import Optional, List, Dict
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from ctypes import cast, c_char_p, c_void_p
from model.Patient import Patient, serialize_patient
from model.User import User
from model.embed.AccessLevel import AccessLevel
from dataclasses import field
from crypto.entities.SecretIdOption import SecretIdOption, serialize_secret_id_option
from model.specializations.HexString import HexString
from model.couchdb.DocIdentifier import DocIdentifier
from model.IcureStub import IcureStub
from model.data.LabelledOccurence import LabelledOccurence
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.SimpleShareResult import deserialize_simple_share_result, SimpleShareResult
from crypto.entities.InvoiceShareOptions import InvoiceShareOptions
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult
from model.filter.chain.FilterChain import FilterChain
from model.embed.InvoicingCode import EncryptedInvoicingCode
from model.PaginatedList import PaginatedList
from model.embed.MediumType import MediumType
from model.embed.InvoiceType import InvoiceType

class InvoiceApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor
		self.encrypted = InvoiceFlavouredEncryptedApi(executor)
		self.tryAndRecover = InvoiceFlavouredApi(executor)

	async def create_invoice_async(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_invoice_blocking(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def create_invoices_async(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createInvoicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_invoices_blocking(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createInvoicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedInvoice:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def get_encryption_keys_of_async(self, invoice: Invoice) -> List[HexString]:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, invoice: Invoice) -> List[HexString]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, invoice: Invoice) -> bool:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, invoice: Invoice) -> bool:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, invoice: Invoice) -> List[str]:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, invoice: Invoice) -> List[str]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Invoice, delegates: List[str]) -> None:
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
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Invoice, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def delete_invoice_async(self, entity_id: str) -> DocIdentifier:
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
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.deleteInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_invoice_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.deleteInvoiceBlocking(
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

	async def find_invoices_delegations_stubs_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
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
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_invoices_delegations_stubs_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysBlocking(
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

	async def get_tarifications_codes_occurrences_async(self, min_occurrence: int) -> List[LabelledOccurence]:
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
			"min_occurrence": min_occurrence,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.getTarificationsCodesOccurrencesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_tarifications_codes_occurrences_blocking(self, min_occurrence: int) -> List[LabelledOccurence]:
		payload = {
			"min_occurrence": min_occurrence,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavourlessApi.getTarificationsCodesOccurrencesBlocking(
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

	async def share_with_async(self, delegate_id: str, invoice: DecryptedInvoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
			"invoice": invoice.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, invoice: DecryptedInvoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"invoice": invoice.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithBlocking(
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

	async def try_share_with_many_async(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
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
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyBlocking(
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

	async def share_with_many_async(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def find_invoices_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedInvoice](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedInvoice._deserialize(x)
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
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_invoices_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientBlocking(
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
			return PaginatedListIterator[DecryptedInvoice](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedInvoice._deserialize(x)
			)

	async def modify_invoice_async(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_invoice_blocking(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def modify_invoices_async(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_invoices_blocking(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_invoice_async(self, entity_id: str) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_invoice_blocking(self, entity_id: str) -> DecryptedInvoice:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def get_invoices_async(self, entity_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_invoices_blocking(self, entity_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_invoices_by_async(self, filter_chain: FilterChain) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_invoices_by_blocking(self, filter_chain: FilterChain) -> List[DecryptedInvoice]:
		payload = {
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def reassign_invoice_async(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def reassign_invoice_blocking(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def merge_to_async(self, invoice_id: str, ids: List[str]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice_id": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> DecryptedInvoice:
		payload = {
			"invoice_id": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedInvoice._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice_id": invoice_id,
			"scheme": scheme,
			"forced_value": forced_value,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		payload = {
			"invoice_id": invoice_id,
			"scheme": scheme,
			"forced_value": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedInvoice._deserialize(result_info["success"])
			return return_value

	async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"type": type,
			"sent_medium_type": sent_medium_type,
			"secret_fkeys": secret_fkeys,
			"insurance_id": insurance_id,
			"invoice_id": invoice_id,
			"grace_period": grace_period,
			"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[DecryptedInvoice]:
		payload = {
			"user_id": user_id,
			"type": type,
			"sent_medium_type": sent_medium_type,
			"secret_fkeys": secret_fkeys,
			"insurance_id": insurance_id,
			"invoice_id": invoice_id,
			"grace_period": grace_period,
			"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"service_id": service_id,
			"secret_fkeys": secret_fkeys,
			"tarification_ids": [x0 for x0 in tarification_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"user_id": user_id,
			"service_id": service_id,
			"secret_fkeys": secret_fkeys,
			"tarification_ids": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedInvoice._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"from_date": from_date,
			"to_date": to_date,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hc_party_id": hc_party_id,
			"from_date": from_date,
			"to_date": to_date,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorBlocking(
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
				rows = [DecryptedInvoice._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_invoices_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_patient_keys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"group_id": group_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"sent_medium_type": sent_medium_type.__serialize__(),
			"invoice_type": invoice_type.__serialize__(),
			"sent": sent,
			"from": from,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"sent_medium_type": sent_medium_type.__serialize__(),
			"invoice_type": invoice_type.__serialize__(),
			"sent": sent,
			"from": from,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contact_ids": [x0 for x0 in contact_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"contact_ids": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"recipients_ids": [x0 for x0 in recipients_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"recipients_ids": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_to_insurances_async(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_insurances_blocking(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_to_patients_async(self, hc_party_id: str) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_patients_blocking(self, hc_party_id: str) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_ids_async(self, ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"sending_mode": sending_mode,
			"status": status,
			"from": from,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[DecryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"sending_mode": sending_mode,
			"status": status,
			"from": from,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_invoices_by_service_ids_async(self, service_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"service_ids": [x0 for x0 in service_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_service_ids_blocking(self, service_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"service_ids": [x0 for x0 in service_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_all_hcps_by_status_async(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"status": status,
			"from": from,
			"to": to,
			"hcp_ids": [x0 for x0 in hcp_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_all_hcps_by_status_blocking(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		payload = {
			"status": status,
			"from": from,
			"to": to,
			"hcp_ids": [x0 for x0 in hcp_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	class InvoiceFlavouredEncryptedApi:

		def __init__(self, executor):
			self.executor = executor

		async def share_with_async(self, delegate_id: str, invoice: EncryptedInvoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"invoice": invoice.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, invoice: EncryptedInvoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"invoice": invoice.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithBlocking(
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

		async def try_share_with_many_async(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
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
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def find_invoices_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedInvoice](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedInvoice._deserialize(x)
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
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientBlocking(
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
				return PaginatedListIterator[EncryptedInvoice](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedInvoice._deserialize(x)
				)

		async def modify_invoice_async(self, entity: EncryptedInvoice) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_invoice_blocking(self, entity: EncryptedInvoice) -> EncryptedInvoice:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def modify_invoices_async(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_invoices_blocking(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_invoice_async(self, entity_id: str) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_invoice_blocking(self, entity_id: str) -> EncryptedInvoice:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def get_invoices_async(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_invoices_blocking(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_invoices_by_async(self, filter_chain: FilterChain) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter_chain": filter_chain.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_invoices_by_blocking(self, filter_chain: FilterChain) -> List[EncryptedInvoice]:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def reassign_invoice_async(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def reassign_invoice_blocking(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
			payload = {
				"invoice": invoice.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def merge_to_async(self, invoice_id: str, ids: List[str]) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice_id": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> EncryptedInvoice:
			payload = {
				"invoice_id": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedInvoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice_id": invoice_id,
				"scheme": scheme,
				"forced_value": forced_value,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
			payload = {
				"invoice_id": invoice_id,
				"scheme": scheme,
				"forced_value": forced_value,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedInvoice._deserialize(result_info["success"])
				return return_value

		async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_id": user_id,
				"type": type,
				"sent_medium_type": sent_medium_type,
				"secret_fkeys": secret_fkeys,
				"insurance_id": insurance_id,
				"invoice_id": invoice_id,
				"grace_period": grace_period,
				"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[EncryptedInvoice]:
			payload = {
				"user_id": user_id,
				"type": type,
				"sent_medium_type": sent_medium_type,
				"secret_fkeys": secret_fkeys,
				"insurance_id": insurance_id,
				"invoice_id": invoice_id,
				"grace_period": grace_period,
				"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_id": user_id,
				"service_id": service_id,
				"secret_fkeys": secret_fkeys,
				"tarification_ids": [x0 for x0 in tarification_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"user_id": user_id,
				"service_id": service_id,
				"secret_fkeys": secret_fkeys,
				"tarification_ids": [x0 for x0 in tarification_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [EncryptedInvoice._deserialize(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"from_date": from_date,
				"to_date": to_date,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hc_party_id": hc_party_id,
				"from_date": from_date,
				"to_date": to_date,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorBlocking(
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
					rows = [EncryptedInvoice._deserialize(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_invoices_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"group_id": group_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"group_id": group_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"sent_medium_type": sent_medium_type.__serialize__(),
				"invoice_type": invoice_type.__serialize__(),
				"sent": sent,
				"from": from,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"sent_medium_type": sent_medium_type.__serialize__(),
				"invoice_type": invoice_type.__serialize__(),
				"sent": sent,
				"from": from,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact_ids": [x0 for x0 in contact_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"contact_ids": [x0 for x0 in contact_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recipients_ids": [x0 for x0 in recipients_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"recipients_ids": [x0 for x0 in recipients_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_insurances_async(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_insurances_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_patients_async(self, hc_party_id: str) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_patients_blocking(self, hc_party_id: str) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_ids_async(self, ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"sending_mode": sending_mode,
				"status": status,
				"from": from,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[EncryptedInvoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"sending_mode": sending_mode,
				"status": status,
				"from": from,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_service_ids_async(self, service_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"service_ids": [x0 for x0 in service_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_service_ids_blocking(self, service_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"service_ids": [x0 for x0 in service_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_all_hcps_by_status_async(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedInvoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"status": status,
				"from": from,
				"to": to,
				"hcp_ids": [x0 for x0 in hcp_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_all_hcps_by_status_blocking(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			payload = {
				"status": status,
				"from": from,
				"to": to,
				"hcp_ids": [x0 for x0 in hcp_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

	class InvoiceFlavouredApi:

		def __init__(self, executor):
			self.executor = executor

		async def share_with_async(self, delegate_id: str, invoice: Invoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"invoice": invoice.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, invoice: Invoice, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"invoice": invoice.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithBlocking(
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

		async def try_share_with_many_async(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
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
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResult:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.tryShareWithManyBlocking(
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

		async def share_with_many_async(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> Invoice:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def find_invoices_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[Invoice](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_invoice(x)
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
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceFlavouredApi.findInvoicesByHcPartyPatientBlocking(
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
				return PaginatedListIterator[Invoice](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_invoice(x)
				)

		async def modify_invoice_async(self, entity: Invoice) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_invoice_blocking(self, entity: Invoice) -> Invoice:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def modify_invoices_async(self, entities: List[Invoice]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_invoices_blocking(self, entities: List[Invoice]) -> List[Invoice]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.modifyInvoicesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_invoice_async(self, entity_id: str) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_invoice_blocking(self, entity_id: str) -> Invoice:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def get_invoices_async(self, entity_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_invoices_blocking(self, entity_ids: List[str]) -> List[Invoice]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.getInvoicesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_invoices_by_async(self, filter_chain: FilterChain) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter_chain": filter_chain.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_invoices_by_blocking(self, filter_chain: FilterChain) -> List[Invoice]:
			payload = {
				"filter_chain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.filterInvoicesByBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def reassign_invoice_async(self, invoice: Invoice) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def reassign_invoice_blocking(self, invoice: Invoice) -> Invoice:
			payload = {
				"invoice": invoice.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.reassignInvoiceBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def merge_to_async(self, invoice_id: str, ids: List[str]) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice_id": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> Invoice:
			payload = {
				"invoice_id": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.mergeToBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Invoice._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice_id": invoice_id,
				"scheme": scheme,
				"forced_value": forced_value,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
			payload = {
				"invoice_id": invoice_id,
				"scheme": scheme,
				"forced_value": forced_value,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.validateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Invoice._deserialize(result_info["success"])
				return return_value

		async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_id": user_id,
				"type": type,
				"sent_medium_type": sent_medium_type,
				"secret_fkeys": secret_fkeys,
				"insurance_id": insurance_id,
				"invoice_id": invoice_id,
				"grace_period": grace_period,
				"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[Invoice]:
			payload = {
				"user_id": user_id,
				"type": type,
				"sent_medium_type": sent_medium_type,
				"secret_fkeys": secret_fkeys,
				"insurance_id": insurance_id,
				"invoice_id": invoice_id,
				"grace_period": grace_period,
				"invoicing_codes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.appendCodesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_id": user_id,
				"service_id": service_id,
				"secret_fkeys": secret_fkeys,
				"tarification_ids": [x0 for x0 in tarification_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[Invoice]:
			payload = {
				"user_id": user_id,
				"service_id": service_id,
				"secret_fkeys": secret_fkeys,
				"tarification_ids": [x0 for x0 in tarification_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.removeCodesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [deserialize_invoice(item) for item in success.rows],
						next_key_pair = success.next_key_pair,
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"from_date": from_date,
				"to_date": to_date,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hc_party_id": hc_party_id,
				"from_date": from_date,
				"to_date": to_date,
				"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.findInvoicesByAuthorBlocking(
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
					rows = [deserialize_invoice(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_invoices_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"secret_patient_keys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"group_id": group_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"group_id": group_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"sent_medium_type": sent_medium_type.__serialize__(),
				"invoice_type": invoice_type.__serialize__(),
				"sent": sent,
				"from": from,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"sent_medium_type": sent_medium_type.__serialize__(),
				"invoice_type": invoice_type.__serialize__(),
				"sent": sent,
				"from": from,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contact_ids": [x0 for x0 in contact_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[Invoice]:
			payload = {
				"contact_ids": [x0 for x0 in contact_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByContactIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recipients_ids": [x0 for x0 in recipients_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[Invoice]:
			payload = {
				"recipients_ids": [x0 for x0 in recipients_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_insurances_async(self, user_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_insurances_blocking(self, user_ids: List[str]) -> List[Invoice]:
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[Invoice]:
			payload = {
				"user_ids": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToInsurancesUnsentBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_patients_async(self, hc_party_id: str) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_patients_blocking(self, hc_party_id: str) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listToPatientsUnsentBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_ids_async(self, ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[Invoice]:
			payload = {
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"sending_mode": sending_mode,
				"status": status,
				"from": from,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from: int, to: int) -> List[Invoice]:
			payload = {
				"hc_party_id": hc_party_id,
				"sending_mode": sending_mode,
				"status": status,
				"from": from,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_invoices_by_service_ids_async(self, service_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"service_ids": [x0 for x0 in service_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_invoices_by_service_ids_blocking(self, service_ids: List[str]) -> List[Invoice]:
			payload = {
				"service_ids": [x0 for x0 in service_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_all_hcps_by_status_async(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Invoice._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"status": status,
				"from": from,
				"to": to,
				"hcp_ids": [x0 for x0 in hcp_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_all_hcps_by_status_blocking(self, status: str, hcp_ids: List[str], from: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			payload = {
				"status": status,
				"from": from,
				"to": to,
				"hcp_ids": [x0 for x0 in hcp_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.InvoiceBasicFlavouredApi.listAllHcpsByStatusBlocking(
				self.icure_sdk.native,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Invoice._deserialize(x1) for x1 in result_info["success"]]
				return return_value

__all__ = ['InvoiceApi']