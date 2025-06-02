# auto-generated file
import json
import base64
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import Optional
from cardinal_sdk.model import DocumentTemplate, DocIdentifier
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class DocumentTemplateApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_document_template_async(self, document_template_id: str) -> Optional[DocumentTemplate]:
		def do_decode(raw_result):
			return DocumentTemplate._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"documentTemplateId": document_template_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_document_template_blocking(self, document_template_id: str) -> Optional[DocumentTemplate]:
		payload = {
			"documentTemplateId": document_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getDocumentTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocumentTemplate._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def create_document_template_async(self, document_template: DocumentTemplate) -> DocumentTemplate:
		def do_decode(raw_result):
			return DocumentTemplate._deserialize(raw_result)
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.createDocumentTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_document_template_blocking(self, document_template: DocumentTemplate) -> DocumentTemplate:
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.createDocumentTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocumentTemplate._deserialize(result_info.success)
			return return_value

	async def modify_document_template_async(self, document_template: DocumentTemplate) -> DocumentTemplate:
		def do_decode(raw_result):
			return DocumentTemplate._deserialize(raw_result)
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.modifyDocumentTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_document_template_blocking(self, document_template: DocumentTemplate) -> DocumentTemplate:
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.modifyDocumentTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocumentTemplate._deserialize(result_info.success)
			return return_value

	async def delete_document_templates_async(self, document_template_ids: list[str]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"documentTemplateIds": [x0 for x0 in document_template_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.deleteDocumentTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_document_templates_blocking(self, document_template_ids: list[str]) -> list[DocIdentifier]:
		payload = {
			"documentTemplateIds": [x0 for x0 in document_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.deleteDocumentTemplatesBlocking(
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

	async def list_document_templates_by_speciality_async(self, speciality_code: str) -> list[DocumentTemplate]:
		def do_decode(raw_result):
			return [DocumentTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"specialityCode": speciality_code,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBySpecialityAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_document_templates_by_speciality_blocking(self, speciality_code: str) -> list[DocumentTemplate]:
		payload = {
			"specialityCode": speciality_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBySpecialityBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_document_templates_by_document_type_async(self, document_type_code: str) -> list[DocumentTemplate]:
		def do_decode(raw_result):
			return [DocumentTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"documentTypeCode": document_type_code,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_document_templates_by_document_type_blocking(self, document_type_code: str) -> list[DocumentTemplate]:
		payload = {
			"documentTypeCode": document_type_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_document_templates_by_document_type_for_current_user_async(self, document_type_code: str) -> list[DocumentTemplate]:
		def do_decode(raw_result):
			return [DocumentTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"documentTypeCode": document_type_code,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_document_templates_by_document_type_for_current_user_blocking(self, document_type_code: str) -> list[DocumentTemplate]:
		payload = {
			"documentTypeCode": document_type_code,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_document_templates_async(self) -> list[DocumentTemplate]:
		def do_decode(raw_result):
			return [DocumentTemplate._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesAsync,
			self.cardinal_sdk._native,
		)

	def list_document_templates_blocking(self) -> list[DocumentTemplate]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_document_template_attachment_async(self, document_template_id: str, attachment_id: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"documentTemplateId": document_template_id,
			"attachmentId": attachment_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_document_template_attachment_blocking(self, document_template_id: str, attachment_id: str) -> bytearray:
		payload = {
			"documentTemplateId": document_template_id,
			"attachmentId": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def get_attachment_text_async(self, document_template_id: str, attachment_id: str) -> bytearray:
		def do_decode(raw_result):
			return bytearray(base64.b64decode(raw_result))
		payload = {
			"documentTemplateId": document_template_id,
			"attachmentId": attachment_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getAttachmentTextAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_attachment_text_blocking(self, document_template_id: str, attachment_id: str) -> bytearray:
		payload = {
			"documentTemplateId": document_template_id,
			"attachmentId": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getAttachmentTextBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def set_document_template_attachment_async(self, document_template_id: str, payload: bytearray) -> DocumentTemplate:
		def do_decode(raw_result):
			return DocumentTemplate._deserialize(raw_result)
		payload = {
			"documentTemplateId": document_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.setDocumentTemplateAttachmentAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_document_template_attachment_blocking(self, document_template_id: str, payload: bytearray) -> DocumentTemplate:
		payload = {
			"documentTemplateId": document_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.setDocumentTemplateAttachmentBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocumentTemplate._deserialize(result_info.success)
			return return_value

	def get_attachment_url(self, document_id: str, attachment_id: str) -> str:
		payload = {
			"documentId": document_id,
			"attachmentId": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.DocumentTemplateApi.getAttachmentUrl(
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
