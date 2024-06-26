import asyncio
import json
import base64
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.couchdb.DocIdentifier import DocIdentifier
from ctypes import c_char_p
from typing import List, Optional
from model.FormTemplate import FormTemplate
from model.Form import EncryptedForm

class FormBasicApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createFormBasicApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def delete_form_async(self, entity_id: str) -> DocIdentifier:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_form_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def delete_forms_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_forms_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_template_async(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FormTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"form_template_id": form_template_id,
			"raw": raw,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_template_blocking(self, form_template_id: str, raw: Optional[bool] = None) -> FormTemplate:
		payload = {
			"form_template_id": form_template_id,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FormTemplate._deserialize(result_info["success"])
			return return_value

	async def get_form_templates_by_guid_async(self, form_template_guid: str, speciality_code: str, raw: Optional[bool]) -> List[FormTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [FormTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"form_template_guid": form_template_guid,
			"speciality_code": speciality_code,
			"raw": raw,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplatesByGuidAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_templates_by_guid_blocking(self, form_template_guid: str, speciality_code: str, raw: Optional[bool]) -> List[FormTemplate]:
		payload = {
			"form_template_guid": form_template_guid,
			"speciality_code": speciality_code,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplatesByGuidBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_form_templates_by_speciality_async(self, speciality_code: str, raw: Optional[bool] = None) -> List[FormTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [FormTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"speciality_code": speciality_code,
			"raw": raw,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.listFormTemplatesBySpecialityAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_form_templates_by_speciality_blocking(self, speciality_code: str, raw: Optional[bool] = None) -> List[FormTemplate]:
		payload = {
			"speciality_code": speciality_code,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.listFormTemplatesBySpecialityBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_templates_async(self, load_layout: Optional[bool] = None, raw: Optional[bool] = None) -> List[FormTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [FormTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"load_layout": load_layout,
			"raw": raw,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplatesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_templates_blocking(self, load_layout: Optional[bool] = None, raw: Optional[bool] = None) -> List[FormTemplate]:
		payload = {
			"load_layout": load_layout,
			"raw": raw,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.getFormTemplatesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [FormTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def create_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FormTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"form_template": form_template.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.createFormTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"form_template": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.createFormTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FormTemplate._deserialize(result_info["success"])
			return return_value

	async def delete_form_template_async(self, form_template_id: str) -> DocIdentifier:
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
			"form_template_id": form_template_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_form_template_blocking(self, form_template_id: str) -> DocIdentifier:
		payload = {
			"form_template_id": form_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.deleteFormTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def update_form_template_async(self, form_template: FormTemplate) -> FormTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = FormTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"form_template": form_template.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.updateFormTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def update_form_template_blocking(self, form_template: FormTemplate) -> FormTemplate:
		payload = {
			"form_template": form_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.updateFormTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = FormTemplate._deserialize(result_info["success"])
			return return_value

	async def set_template_attachment_async(self, form_template_id: str, payload: bytearray) -> str:
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
			"form_template_id": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.setTemplateAttachmentAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def set_template_attachment_blocking(self, form_template_id: str, payload: bytearray) -> str:
		payload = {
			"form_template_id": form_template_id,
			"payload": base64.b64encode(payload).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavourlessApi.setTemplateAttachmentBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def modify_form_async(self, entity: EncryptedForm) -> EncryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.modifyFormAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_form_blocking(self, entity: EncryptedForm) -> EncryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.modifyFormBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedForm._deserialize(result_info["success"])
			return return_value

	async def modify_forms_async(self, entities: List[EncryptedForm]) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.modifyFormsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_forms_blocking(self, entities: List[EncryptedForm]) -> List[EncryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.modifyFormsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_async(self, entity_id: str) -> EncryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_blocking(self, entity_id: str) -> EncryptedForm:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_forms_async(self, entity_ids: List[str]) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_forms_blocking(self, entity_ids: List[str]) -> List[EncryptedForm]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_by_logical_uuid_async(self, logical_uuid: str) -> EncryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"logical_uuid": logical_uuid,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormByLogicalUuidAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_by_logical_uuid_blocking(self, logical_uuid: str) -> EncryptedForm:
		payload = {
			"logical_uuid": logical_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormByLogicalUuidBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_forms_by_logical_uuid_async(self, logical_uuid: str) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"logical_uuid": logical_uuid,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsByLogicalUuidAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_forms_by_logical_uuid_blocking(self, logical_uuid: str) -> List[EncryptedForm]:
		payload = {
			"logical_uuid": logical_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsByLogicalUuidBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_forms_by_unique_id_async(self, unique_id: str) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"unique_id": unique_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsByUniqueIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_forms_by_unique_id_blocking(self, unique_id: str) -> List[EncryptedForm]:
		payload = {
			"unique_id": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormsByUniqueIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_by_unique_id_async(self, unique_id: str) -> EncryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"unique_id": unique_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormByUniqueIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_form_by_unique_id_blocking(self, unique_id: str) -> EncryptedForm:
		payload = {
			"unique_id": unique_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getFormByUniqueIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_children_forms_async(self, hc_party_id: str, parent_id: str) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"parent_id": parent_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getChildrenFormsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_children_forms_blocking(self, hc_party_id: str, parent_id: str) -> List[EncryptedForm]:
		payload = {
			"hc_party_id": hc_party_id,
			"parent_id": parent_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.getChildrenFormsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_forms_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[EncryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"secret_fkeys": secret_fkeys,
			"health_element_id": health_element_id,
			"plan_of_action_id": plan_of_action_id,
			"form_template_id": form_template_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.listFormsByHCPartyAndPatientForeignKeysAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_forms_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[EncryptedForm]:
		payload = {
			"hc_party_id": hc_party_id,
			"secret_fkeys": secret_fkeys,
			"health_element_id": health_element_id,
			"plan_of_action_id": plan_of_action_id,
			"form_template_id": form_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormBasicFlavouredApi.listFormsByHCPartyAndPatientForeignKeysBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

__all__ = ['FormBasicApi']