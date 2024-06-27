import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model import DocIdentifier, IcureStub, LabelledOccurence, EncryptedInvoice, FilterChain, EncryptedInvoicingCode, PaginatedList, MediumType, InvoiceType
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import List, Optional, Dict

class InvoiceBasicApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.deleteInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_invoice_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.deleteInvoiceBlocking(
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [IcureStub._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.getTarificationsCodesOccurrencesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_tarifications_codes_occurrences_blocking(self, min_occurrence: int) -> List[LabelledOccurence]:
		payload = {
			"min_occurrence": min_occurrence,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavourlessApi.getTarificationsCodesOccurrencesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [LabelledOccurence._deserialize(x1) for x1 in result_info.success]
			return return_value

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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.modifyInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_invoice_blocking(self, entity: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.modifyInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.modifyInvoicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_invoices_blocking(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.modifyInvoicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.getInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_invoice_blocking(self, entity_id: str) -> EncryptedInvoice:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.getInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.getInvoicesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_invoices_blocking(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.getInvoicesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.filterInvoicesByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_invoices_by_blocking(self, filter_chain: FilterChain) -> List[EncryptedInvoice]:
		payload = {
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.filterInvoicesByBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.findInvoicesByHcPartyPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.reassignInvoiceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def reassign_invoice_blocking(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.reassignInvoiceBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.mergeToAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.mergeToBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.validateAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.validateBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedInvoice._deserialize(result_info.success)
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.appendCodesAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.appendCodesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.removeCodesAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.removeCodesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.findInvoicesByAuthorAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.findInvoicesByAuthorBlocking(
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcPartyAndGroupIdBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
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
			"from": from_,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"sent_medium_type": sent_medium_type.__serialize__(),
			"invoice_type": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByContactIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"contact_ids": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByContactIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"recipients_ids": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByRecipientsIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToInsurancesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_insurances_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToInsurancesBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToInsurancesUnsentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"user_ids": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToInsurancesUnsentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToPatientsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_patients_blocking(self, hc_party_id: str) -> List[EncryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToPatientsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToPatientsUnsentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listToPatientsUnsentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[EncryptedInvoice]:
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
			"from": from_,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[EncryptedInvoice]:
		payload = {
			"hc_party_id": hc_party_id,
			"sending_mode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_invoices_by_service_ids_blocking(self, service_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"service_ids": [x0 for x0 in service_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listInvoicesByServiceIdsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_all_hcps_by_status_async(self, status: str, hcp_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
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
			"from": from_,
			"to": to,
			"hcp_ids": [x0 for x0 in hcp_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listAllHcpsByStatusAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_all_hcps_by_status_blocking(self, status: str, hcp_ids: List[str], from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
		payload = {
			"status": status,
			"from": from_,
			"to": to,
			"hcp_ids": [x0 for x0 in hcp_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.InvoiceBasicFlavouredApi.listAllHcpsByStatusBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value
