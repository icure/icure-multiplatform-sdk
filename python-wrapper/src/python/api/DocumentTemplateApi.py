import asyncio
import json
import base64
from model.CallResult import CallResult, create_result_from_json
from model.DocumentTemplate import DocumentTemplate
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import List, Optional
from model.couchdb.DocIdentifier import DocIdentifier
from model.PaginatedList import PaginatedList

class DocumentTemplateApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_document_template_async(self, document_template_id: str) -> DocumentTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocumentTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template_id": document_template_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_template_blocking(self, document_template_id: str) -> DocumentTemplate:
		payload = {
			"document_template_id": document_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getDocumentTemplateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocumentTemplate._deserialize(result_info["success"])
			return return_value

	async def create_document_template_async(self, document_template: DocumentTemplate) -> DocumentTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocumentTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template": document_template.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.createDocumentTemplateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_document_template_blocking(self, document_template: DocumentTemplate) -> DocumentTemplate:
		payload = {
			"document_template": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.createDocumentTemplateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocumentTemplate._deserialize(result_info["success"])
			return return_value

	async def modify_document_template_async(self, document_template: DocumentTemplate) -> DocumentTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocumentTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template": document_template.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.modifyDocumentTemplateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_document_template_blocking(self, document_template: DocumentTemplate) -> DocumentTemplate:
		payload = {
			"document_template": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.modifyDocumentTemplateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocumentTemplate._deserialize(result_info["success"])
			return return_value

	async def delete_document_templates_async(self, document_template_ids: List[str]) -> List[DocIdentifier]:
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
			"document_template_ids": [x0 for x0 in document_template_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.deleteDocumentTemplatesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_document_templates_blocking(self, document_template_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"document_template_ids": [x0 for x0 in document_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.deleteDocumentTemplatesBlocking(
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

	async def list_document_templates_by_speciality_async(self, speciality_code: str) -> List[DocumentTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocumentTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"speciality_code": speciality_code,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBySpecialityAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_document_templates_by_speciality_blocking(self, speciality_code: str) -> List[DocumentTemplate]:
		payload = {
			"speciality_code": speciality_code,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBySpecialityBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_document_templates_by_document_type_async(self, document_type_code: str) -> List[DocumentTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocumentTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_type_code": document_type_code,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_document_templates_by_document_type_blocking(self, document_type_code: str) -> List[DocumentTemplate]:
		payload = {
			"document_type_code": document_type_code,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_document_templates_by_document_type_for_current_user_async(self, document_type_code: str) -> List[DocumentTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocumentTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_type_code": document_type_code,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_document_templates_by_document_type_for_current_user_blocking(self, document_type_code: str) -> List[DocumentTemplate]:
		payload = {
			"document_type_code": document_type_code,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUserBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_document_templates_async(self) -> List[DocumentTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocumentTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_document_templates_blocking(self) -> List[DocumentTemplate]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.listDocumentTemplatesBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocumentTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_all_document_templates_async(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DocumentTemplate._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.findAllDocumentTemplatesAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_all_document_templates_blocking(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.findAllDocumentTemplatesBlocking(
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
				rows = [DocumentTemplate._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
			)
			return return_value

	async def get_document_template_attachment_async(self, document_template_id: str, attachment_id: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = bytearray(base64.b64decode(success.decode('utf-8')))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template_id": document_template_id,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_template_attachment_blocking(self, document_template_id: str, attachment_id: str) -> bytearray:
		payload = {
			"document_template_id": document_template_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getDocumentTemplateAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = bytearray(base64.b64decode(result_info["success"]))
			return return_value

	async def get_attachment_text_async(self, document_template_id: str, attachment_id: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = bytearray(base64.b64decode(success.decode('utf-8')))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template_id": document_template_id,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getAttachmentTextAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_attachment_text_blocking(self, document_template_id: str, attachment_id: str) -> bytearray:
		payload = {
			"document_template_id": document_template_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getAttachmentTextBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = bytearray(base64.b64decode(result_info["success"]))
			return return_value

	async def set_document_template_attachment_async(self, document_template_id: str, payload: bytearray) -> DocumentTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocumentTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template_id": document_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.setDocumentTemplateAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def set_document_template_attachment_blocking(self, document_template_id: str, payload: bytearray) -> DocumentTemplate:
		payload = {
			"document_template_id": document_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.setDocumentTemplateAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocumentTemplate._deserialize(result_info["success"])
			return return_value

	def get_attachment_url(self, document_id: str, attachment_id: str) -> str:
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentTemplateApi.getAttachmentUrl(
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

__all__ = ['DocumentTemplateApi']