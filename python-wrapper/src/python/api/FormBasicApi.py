# auto-generated file
import json
import base64
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions
from cardinal_sdk.model import Form, EncryptedForm, DocIdentifier, StoredDocumentIdentifier, serialize_form, FormTemplate
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from typing import Optional


class FormBasicApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def match_forms_by_async(self, filter: BaseFilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.matchFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_blocking(self, filter: BaseFilterOptions[Form]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.matchFormsByBlocking(
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

	async def match_forms_by_sorted_async(self, filter: BaseSortableFilterOptions[Form]) -> list[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.matchFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_forms_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Form]) -> list[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.matchFormsBySortedBlocking(
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

	async def filter_forms_by_async(self, filter: BaseFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedForm](
				producer = raw_result,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.filterFormsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_blocking(self, filter: BaseFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.filterFormsByBlocking(
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
			return PaginatedListIterator[EncryptedForm](
				producer = class_pointer,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_forms_by_sorted_async(self, filter: BaseSortableFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		def do_decode(raw_result):
			return PaginatedListIterator[EncryptedForm](
				producer = raw_result,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.filterFormsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_forms_by_sorted_blocking(self, filter: BaseSortableFilterOptions[Form]) -> PaginatedListIterator[EncryptedForm]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.filterFormsBySortedBlocking(
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
			return PaginatedListIterator[EncryptedForm](
				producer = class_pointer,
				deserializer = lambda x: EncryptedForm._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def delete_form_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormByIdBlocking(
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

	async def delete_forms_by_ids_async(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormsByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_by_ids_blocking(self, entity_ids: list[StoredDocumentIdentifier]) -> list[DocIdentifier]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormsByIdsBlocking(
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

	async def purge_form_by_id_async(self, id: str, rev: str) -> None:
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
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.purgeFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.purgeFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def delete_form_async(self, form: Form) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_blocking(self, form: Form) -> DocIdentifier:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormBlocking(
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

	async def delete_forms_async(self, forms: list[Form]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_forms_blocking(self, forms: list[Form]) -> list[DocIdentifier]:
		payload = {
			"forms": [serialize_form(x0) for x0 in forms],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormsBlocking(
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

	async def purge_form_async(self, form: Form) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.purgeFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_form_blocking(self, form: Form) -> None:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.purgeFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def get_form_template_async(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplateId": form_template_id,
			"raw": raw,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_template_blocking(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		payload = {
			"formTemplateId": form_template_id,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def create_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def delete_form_template_async(self, form_template_id: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"formTemplateId": form_template_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_form_template_blocking(self, form_template_id: str) -> DocIdentifier:
		payload = {
			"formTemplateId": form_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.deleteFormTemplateBlocking(
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

	async def update_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		def do_decode(raw_result):
			return FormTemplate._deserialize(raw_result)
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.updateFormTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def update_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"formTemplate": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.updateFormTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = FormTemplate._deserialize(result_info.success)
			return return_value

	async def set_template_attachment_async(self, form_template_id: str, payload: bytearray) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"formTemplateId": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.setTemplateAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_template_attachment_blocking(self, form_template_id: str, payload: bytearray) -> str:
		payload = {
			"formTemplateId": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.setTemplateAttachmentBlocking(
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

	async def create_form_async(self, entity: EncryptedForm) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_form_blocking(self, entity: EncryptedForm) -> EncryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def create_forms_async(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_forms_blocking(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.createFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_form_async(self, entity: EncryptedForm) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"entity": entity.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.modifyFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_form_blocking(self, entity: EncryptedForm) -> EncryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.modifyFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_form_by_id_async(self, id: str, rev: str) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.undeleteFormByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_by_id_blocking(self, id: str, rev: str) -> EncryptedForm:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.undeleteFormByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def undelete_form_async(self, form: Form) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"form": serialize_form(form),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.undeleteFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_form_blocking(self, form: Form) -> EncryptedForm:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.undeleteFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def modify_forms_async(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.modifyFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_forms_blocking(self, entities: list[EncryptedForm]) -> list[EncryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.modifyFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_form_async(self, entity_id: str) -> Optional[EncryptedForm]:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"entityId": entity_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_form_blocking(self, entity_id: str) -> Optional[EncryptedForm]:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def get_forms_async(self, entity_ids: list[str]) -> list[EncryptedForm]:
		def do_decode(raw_result):
			return [EncryptedForm._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_forms_blocking(self, entity_ids: list[str]) -> list[EncryptedForm]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getFormsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_latest_form_by_logical_uuid_async(self, logical_uuid: str) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"logicalUuid": logical_uuid,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getLatestFormByLogicalUuidAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_form_by_logical_uuid_blocking(self, logical_uuid: str) -> EncryptedForm:
		payload = {
			"logicalUuid": logical_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getLatestFormByLogicalUuidBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value

	async def get_latest_form_by_unique_id_async(self, unique_id: str) -> EncryptedForm:
		def do_decode(raw_result):
			return EncryptedForm._deserialize(raw_result)
		payload = {
			"uniqueId": unique_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getLatestFormByUniqueIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_form_by_unique_id_blocking(self, unique_id: str) -> EncryptedForm:
		payload = {
			"uniqueId": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.FormBasicApi.getLatestFormByUniqueIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EncryptedForm._deserialize(result_info.success)
			return return_value
