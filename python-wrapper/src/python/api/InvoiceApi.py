# auto-generated file
import asyncio
import json
from cardinal_sdk.model import DecryptedInvoice, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Invoice, serialize_invoice, EncryptedInvoice, deserialize_invoice, DocIdentifier, IcureStub, LabelledOccurence, InvoiceShareOptions, deserialize_simple_share_result_decrypted_invoice, SimpleShareResultDecryptedInvoice, EncryptedInvoicingCode, PaginatedList, MediumType, InvoiceType, deserialize_simple_share_result_encrypted_invoice, SimpleShareResultEncryptedInvoice, deserialize_simple_share_result_invoice, SimpleShareResultInvoice
from typing import Optional, List, Dict
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.model.specializations import HexString

class InvoiceApi:

	class InvoiceFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, invoice: EncryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultEncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_encrypted_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"invoice": invoice.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, invoice: EncryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultEncryptedInvoice:
			payload = {
				"delegateId": delegate_id,
				"invoice": invoice.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_encrypted_invoice(result_info.success)
				return return_value

		async def try_share_with_many_async(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultEncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_encrypted_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.tryShareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultEncryptedInvoice:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.tryShareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_encrypted_invoice(result_info.success)
				return return_value

		async def share_with_many_async(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, invoice: EncryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> EncryptedInvoice:
			payload = {
				"invoice": invoice.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def modify_invoice_async(self, entity: EncryptedInvoice) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_invoice_blocking(self, entity: EncryptedInvoice) -> EncryptedInvoice:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def modify_invoices_async(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_invoices_blocking(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.modifyInvoicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_invoice_async(self, entity_id: str) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_invoice_blocking(self, entity_id: str) -> EncryptedInvoice:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def get_invoices_async(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_invoices_blocking(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.getInvoicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.findInvoicesByHcPartyPatientForeignKeysAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.findInvoicesByHcPartyPatientForeignKeysBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def reassign_invoice_async(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": invoice.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.reassignInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def reassign_invoice_blocking(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
			payload = {
				"invoice": invoice.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.reassignInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def merge_to_async(self, invoice_id: str, ids: List[str]) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoiceId": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.mergeToAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> EncryptedInvoice:
			payload = {
				"invoiceId": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.mergeToBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoiceId": invoice_id,
				"scheme": scheme,
				"forcedValue": forced_value,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.validateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
			payload = {
				"invoiceId": invoice_id,
				"scheme": scheme,
				"forcedValue": forced_value,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.validateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedInvoice._deserialize(result_info.success)
				return return_value

		async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userId": user_id,
				"type": type,
				"sentMediumType": sent_medium_type,
				"secretFKeys": secret_fkeys,
				"insuranceId": insurance_id,
				"invoiceId": invoice_id,
				"gracePeriod": grace_period,
				"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.appendCodesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[EncryptedInvoice]:
			payload = {
				"userId": user_id,
				"type": type,
				"sentMediumType": sent_medium_type,
				"secretFKeys": secret_fkeys,
				"insuranceId": insurance_id,
				"invoiceId": invoice_id,
				"gracePeriod": grace_period,
				"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.appendCodesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userId": user_id,
				"serviceId": service_id,
				"secretFKeys": secret_fkeys,
				"tarificationIds": [x0 for x0 in tarification_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.removeCodesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"userId": user_id,
				"serviceId": service_id,
				"secretFKeys": secret_fkeys,
				"tarificationIds": [x0 for x0 in tarification_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.removeCodesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [EncryptedInvoice._deserialize(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"fromDate": from_date,
				"toDate": to_date,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.findInvoicesByAuthorAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"fromDate": from_date,
				"toDate": to_date,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.findInvoicesByAuthorBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
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
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHCPartyAndPatientForeignKeysAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"groupId": group_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"groupId": group_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartyAndGroupIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sentMediumType": sent_medium_type.__serialize__(),
				"invoiceType": invoice_type.__serialize__(),
				"sent": sent,
				"from": from_,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"sentMediumType": sent_medium_type.__serialize__(),
				"invoiceType": invoice_type.__serialize__(),
				"sent": sent,
				"from": from_,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contactIds": [x0 for x0 in contact_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByContactIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"contactIds": [x0 for x0 in contact_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByContactIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recipientsIds": [x0 for x0 in recipients_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByRecipientsIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"recipientsIds": [x0 for x0 in recipients_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByRecipientsIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_to_insurances_async(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_insurances_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesUnsentAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToInsurancesUnsentBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_to_patients_async(self, hc_party_id: str) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_patients_blocking(self, hc_party_id: str) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsUnsentAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listToPatientsUnsentBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_ids_async(self, ids: List[str]) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[EncryptedInvoice]:
			payload = {
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[EncryptedInvoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sendingMode": sending_mode,
				"status": status,
				"from": from_,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[EncryptedInvoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"sendingMode": sending_mode,
				"status": status,
				"from": from_,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedInvoice._deserialize(x1) for x1 in result_info.success]
				return return_value

	class InvoiceFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, invoice: Invoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"invoice": serialize_invoice(invoice),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, invoice: Invoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultInvoice:
			payload = {
				"delegateId": delegate_id,
				"invoice": serialize_invoice(invoice),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_invoice(result_info.success)
				return return_value

		async def try_share_with_many_async(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultInvoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": serialize_invoice(invoice),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.tryShareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultInvoice:
			payload = {
				"invoice": serialize_invoice(invoice),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.tryShareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_simple_share_result_invoice(result_info.success)
				return return_value

		async def share_with_many_async(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": serialize_invoice(invoice),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, invoice: Invoice, delegates: Dict[str, InvoiceShareOptions]) -> Invoice:
			payload = {
				"invoice": serialize_invoice(invoice),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def modify_invoice_async(self, entity: Invoice) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": serialize_invoice(entity),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_invoice_blocking(self, entity: Invoice) -> Invoice:
			payload = {
				"entity": serialize_invoice(entity),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def modify_invoices_async(self, entities: List[Invoice]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [serialize_invoice(x0) for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_invoices_blocking(self, entities: List[Invoice]) -> List[Invoice]:
			payload = {
				"entities": [serialize_invoice(x0) for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.modifyInvoicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def get_invoice_async(self, entity_id: str) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_invoice_blocking(self, entity_id: str) -> Invoice:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def get_invoices_async(self, entity_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoicesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_invoices_blocking(self, entity_ids: List[str]) -> List[Invoice]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.getInvoicesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.findInvoicesByHcPartyPatientForeignKeysAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.findInvoicesByHcPartyPatientForeignKeysBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def reassign_invoice_async(self, invoice: Invoice) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoice": serialize_invoice(invoice),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.reassignInvoiceAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def reassign_invoice_blocking(self, invoice: Invoice) -> Invoice:
			payload = {
				"invoice": serialize_invoice(invoice),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.reassignInvoiceBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def merge_to_async(self, invoice_id: str, ids: List[str]) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoiceId": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.mergeToAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> Invoice:
			payload = {
				"invoiceId": invoice_id,
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.mergeToBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_invoice(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"invoiceId": invoice_id,
				"scheme": scheme,
				"forcedValue": forced_value,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.validateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> Invoice:
			payload = {
				"invoiceId": invoice_id,
				"scheme": scheme,
				"forcedValue": forced_value,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.validateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_invoice(result_info.success)
				return return_value

		async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userId": user_id,
				"type": type,
				"sentMediumType": sent_medium_type,
				"secretFKeys": secret_fkeys,
				"insuranceId": insurance_id,
				"invoiceId": invoice_id,
				"gracePeriod": grace_period,
				"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.appendCodesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[Invoice]:
			payload = {
				"userId": user_id,
				"type": type,
				"sentMediumType": sent_medium_type,
				"secretFKeys": secret_fkeys,
				"insuranceId": insurance_id,
				"invoiceId": invoice_id,
				"gracePeriod": grace_period,
				"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.appendCodesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userId": user_id,
				"serviceId": service_id,
				"secretFKeys": secret_fkeys,
				"tarificationIds": [x0 for x0 in tarification_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.removeCodesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[Invoice]:
			payload = {
				"userId": user_id,
				"serviceId": service_id,
				"secretFKeys": secret_fkeys,
				"tarificationIds": [x0 for x0 in tarification_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.removeCodesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
					result = PaginatedList(
						rows = [deserialize_invoice(item) for item in result.rows],
						next_key_pair = result.next_key_pair,
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"fromDate": from_date,
				"toDate": to_date,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.findInvoicesByAuthorAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"hcPartyId": hc_party_id,
				"fromDate": from_date,
				"toDate": to_date,
				"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
				"startDocumentId": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.findInvoicesByAuthorBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = PaginatedList._deserialize(result_info.success)
				return_value = PaginatedList(
					rows = [deserialize_invoice(item) for item in return_value.rows],
					next_key_pair = return_value.next_key_pair,
				)
				return return_value

		async def list_invoices_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeysAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"secretPatientKeys": [x0 for x0 in secret_patient_keys],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"groupId": group_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"groupId": group_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sentMediumType": sent_medium_type.__serialize__(),
				"invoiceType": invoice_type.__serialize__(),
				"sent": sent,
				"from": from_,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"sentMediumType": sent_medium_type.__serialize__(),
				"invoiceType": invoice_type.__serialize__(),
				"sent": sent,
				"from": from_,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"contactIds": [x0 for x0 in contact_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByContactIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[Invoice]:
			payload = {
				"contactIds": [x0 for x0 in contact_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByContactIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recipientsIds": [x0 for x0 in recipients_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByRecipientsIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[Invoice]:
			payload = {
				"recipientsIds": [x0 for x0 in recipients_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByRecipientsIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_to_insurances_async(self, user_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_insurances_blocking(self, user_ids: List[str]) -> List[Invoice]:
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesUnsentAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[Invoice]:
			payload = {
				"userIds": [x0 for x0 in user_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToInsurancesUnsentBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_to_patients_async(self, hc_party_id: str) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_patients_blocking(self, hc_party_id: str) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsUnsentAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listToPatientsUnsentBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_ids_async(self, ids: List[str]) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"ids": [x0 for x0 in ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByIdsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[Invoice]:
			payload = {
				"ids": [x0 for x0 in ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByIdsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

		async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[Invoice]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_invoice(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"sendingMode": sending_mode,
				"status": status,
				"from": from_,
				"to": to,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDateAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[Invoice]:
			payload = {
				"hcPartyId": hc_party_id,
				"sendingMode": sending_mode,
				"status": status,
				"from": from_,
				"to": to,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDateBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_invoice(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = InvoiceApi.InvoiceFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = InvoiceApi.InvoiceFlavouredApi(self.cardinal_sdk)

	async def create_invoice_async(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_invoice_blocking(self, entity: DecryptedInvoice, prefix: Optional[str]) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def create_invoices_async(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_invoices_blocking(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedInvoice], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedInvoice:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, invoice: Invoice) -> List[HexString]:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, invoice: Invoice) -> List[HexString]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, invoice: Invoice) -> bool:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, invoice: Invoice) -> bool:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, invoice: Invoice) -> List[str]:
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
			"invoice": serialize_invoice(invoice),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, invoice: Invoice) -> List[str]:
		payload = {
			"invoice": serialize_invoice(invoice),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Invoice, delegates: List[str]) -> None:
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
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Invoice, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_invoice(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, invoice: EncryptedInvoice) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, invoice: EncryptedInvoice) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, invoice: EncryptedInvoice) -> Invoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_invoice(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, invoice: EncryptedInvoice) -> Invoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_invoice(result_info.success)
			return return_value

	async def delete_invoice_async(self, entity_id: str) -> DocIdentifier:
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.deleteInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_invoice_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.deleteInvoiceBlocking(
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

	async def find_invoices_delegations_stubs_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
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
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_invoices_delegations_stubs_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[IcureStub]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [IcureStub._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_tarifications_codes_occurrences_async(self, min_occurrence: int) -> List[LabelledOccurence]:
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
			"minOccurrence": min_occurrence,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getTarificationsCodesOccurrencesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_tarifications_codes_occurrences_blocking(self, min_occurrence: int) -> List[LabelledOccurence]:
		payload = {
			"minOccurrence": min_occurrence,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getTarificationsCodesOccurrencesBlocking(
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

	async def share_with_async(self, delegate_id: str, invoice: DecryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultDecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result_decrypted_invoice(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, invoice: DecryptedInvoice, options: Optional[InvoiceShareOptions] = None) -> SimpleShareResultDecryptedInvoice:
		payload = {
			"delegateId": delegate_id,
			"invoice": invoice.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_simple_share_result_decrypted_invoice(result_info.success)
			return return_value

	async def try_share_with_many_async(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultDecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result_decrypted_invoice(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryShareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> SimpleShareResultDecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.tryShareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_simple_share_result_decrypted_invoice(result_info.success)
			return return_value

	async def share_with_many_async(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, invoice: DecryptedInvoice, delegates: Dict[str, InvoiceShareOptions]) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoice_async(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_invoice_blocking(self, entity: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def modify_invoices_async(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_invoices_blocking(self, entities: List[DecryptedInvoice]) -> List[DecryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.modifyInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_invoice_async(self, entity_id: str) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_invoice_blocking(self, entity_id: str) -> DecryptedInvoice:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def get_invoices_async(self, entity_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_invoices_blocking(self, entity_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.getInvoicesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_invoices_by_hc_party_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesByHcPartyPatientForeignKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_invoices_by_hc_party_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesByHcPartyPatientForeignKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def reassign_invoice_async(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoice": invoice.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.reassignInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def reassign_invoice_blocking(self, invoice: DecryptedInvoice) -> DecryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.reassignInvoiceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def merge_to_async(self, invoice_id: str, ids: List[str]) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.mergeToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> DecryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.mergeToBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def validate_async(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedInvoice._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.validateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> DecryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.validateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedInvoice._deserialize(result_info.success)
			return return_value

	async def append_codes_async(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.appendCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def append_codes_blocking(self, user_id: str, type: str, sent_medium_type: str, secret_fkeys: str, invoicing_codes: List[EncryptedInvoicingCode], insurance_id: Optional[str] = None, invoice_id: Optional[str] = None, grace_period: Optional[int] = None) -> List[DecryptedInvoice]:
		payload = {
			"userId": user_id,
			"type": type,
			"sentMediumType": sent_medium_type,
			"secretFKeys": secret_fkeys,
			"insuranceId": insurance_id,
			"invoiceId": invoice_id,
			"gracePeriod": grace_period,
			"invoicingCodes": [x0.__serialize__() for x0 in invoicing_codes],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.appendCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def remove_codes_async(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.removeCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.removeCodesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_invoices_by_author_async(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedList._deserialize(json.loads(success.decode('utf-8')))
				result = PaginatedList(
					rows = [DecryptedInvoice._deserialize(item) for item in result.rows],
					next_key_pair = result.next_key_pair,
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"fromDate": from_date,
			"toDate": to_date,
			"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesByAuthorAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_invoices_by_author_blocking(self, hc_party_id: str, from_date: Optional[int] = None, to_date: Optional[int] = None, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"hcPartyId": hc_party_id,
			"fromDate": from_date,
			"toDate": to_date,
			"startKey": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"startDocumentId": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.findInvoicesByAuthorBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = PaginatedList._deserialize(result_info.success)
			return_value = PaginatedList(
				rows = [DecryptedInvoice._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def list_invoices_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHCPartyAndPatientForeignKeysAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_patient_keys: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"secretPatientKeys": [x0 for x0 in secret_patient_keys],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHCPartyAndPatientForeignKeysBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_and_group_id_async(self, hc_party_id: str, group_id: str) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartyAndGroupIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartyAndGroupIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_async(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_contact_ids_async(self, contact_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByContactIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByContactIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_recipients_ids_async(self, recipients_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByRecipientsIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByRecipientsIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_async(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_to_insurances_blocking(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_insurances_unsent_async(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToInsurancesUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_async(self, hc_party_id: str) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_to_patients_blocking(self, hc_party_id: str) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_to_patients_unsent_async(self, hc_party_id: Optional[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listToPatientsUnsentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_ids_async(self, ids: List[str]) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"ids": [x0 for x0 in ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[DecryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByIdsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_invoices_by_hcparty_sending_mode_status_date_async(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[DecryptedInvoice]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedInvoice._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[DecryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedInvoice._deserialize(x1) for x1 in result_info.success]
			return return_value
