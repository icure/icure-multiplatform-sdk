# auto-generated file
import json
from cardinal_sdk.model import DocIdentifier, LabelledOccurence, EncryptedInvoice, EncryptedInvoicingCode, MediumType, InvoiceType
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import List, Optional


class InvoiceBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def delete_invoice_async(self, entity_id: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.deleteInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_invoice_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.deleteInvoiceBlocking(
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

	async def get_tarifications_codes_occurrences_async(self, min_occurrence: int) -> List[LabelledOccurence]:
		def do_decode(raw_result):
			return [LabelledOccurence._deserialize(x1) for x1 in raw_result]
		payload = {
			"minOccurrence": min_occurrence,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getTarificationsCodesOccurrencesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_tarifications_codes_occurrences_blocking(self, min_occurrence: int) -> List[LabelledOccurence]:
		payload = {
			"minOccurrence": min_occurrence,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getTarificationsCodesOccurrencesBlocking(
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

	async def modify_invoice_async(self, entity: EncryptedInvoice) -> EncryptedInvoice:
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.modifyInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoice_blocking(self, entity: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.modifyInvoiceBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.modifyInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_invoices_blocking(self, entities: List[EncryptedInvoice]) -> List[EncryptedInvoice]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.modifyInvoicesBlocking(
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
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoice_blocking(self, entity_id: str) -> EncryptedInvoice:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getInvoiceBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getInvoicesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_invoices_blocking(self, entity_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.getInvoicesBlocking(
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
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoice": invoice.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.reassignInvoiceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reassign_invoice_blocking(self, invoice: EncryptedInvoice) -> EncryptedInvoice:
		payload = {
			"invoice": invoice.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.reassignInvoiceBlocking(
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
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.mergeToAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def merge_to_blocking(self, invoice_id: str, ids: List[str]) -> EncryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.mergeToBlocking(
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
		def do_decode(raw_result):
			return EncryptedInvoice._deserialize(raw_result)
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.validateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def validate_blocking(self, invoice_id: str, scheme: str, forced_value: str) -> EncryptedInvoice:
		payload = {
			"invoiceId": invoice_id,
			"scheme": scheme,
			"forcedValue": forced_value,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.validateBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
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
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.appendCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

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
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.appendCodesBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.removeCodesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def remove_codes_blocking(self, user_id: str, service_id: str, secret_fkeys: str, tarification_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"userId": user_id,
			"serviceId": service_id,
			"secretFKeys": secret_fkeys,
			"tarificationIds": [x0 for x0 in tarification_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.removeCodesBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcPartyAndGroupIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_and_group_id_blocking(self, hc_party_id: str, group_id: str) -> List[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcPartyAndGroupIdBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hc_party_sent_medium_type_invoice_type_sent_date_blocking(self, hc_party_id: str, sent_medium_type: MediumType, invoice_type: InvoiceType, sent: bool, from_: Optional[int] = None, to: Optional[int] = None) -> List[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sentMediumType": sent_medium_type.__serialize__(),
			"invoiceType": invoice_type.__serialize__(),
			"sent": sent,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDateBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByContactIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_contact_ids_blocking(self, contact_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"contactIds": [x0 for x0 in contact_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByContactIdsBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByRecipientsIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_recipients_ids_blocking(self, recipients_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"recipientsIds": [x0 for x0 in recipients_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByRecipientsIdsBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToInsurancesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToInsurancesBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToInsurancesUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_insurances_unsent_blocking(self, user_ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToInsurancesUnsentBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToPatientsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_blocking(self, hc_party_id: str) -> List[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToPatientsBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToPatientsUnsentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_to_patients_unsent_blocking(self, hc_party_id: Optional[str]) -> List[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listToPatientsUnsentBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"ids": [x0 for x0 in ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_ids_blocking(self, ids: List[str]) -> List[EncryptedInvoice]:
		payload = {
			"ids": [x0 for x0 in ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByIdsBlocking(
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
		def do_decode(raw_result):
			return [EncryptedInvoice._deserialize(x1) for x1 in raw_result]
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcpartySendingModeStatusDateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_invoices_by_hcparty_sending_mode_status_date_blocking(self, hc_party_id: str, sending_mode: str, status: str, from_: int, to: int) -> List[EncryptedInvoice]:
		payload = {
			"hcPartyId": hc_party_id,
			"sendingMode": sending_mode,
			"status": status,
			"from": from_,
			"to": to,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.InvoiceBasicApi.listInvoicesByHcpartySendingModeStatusDateBlocking(
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
