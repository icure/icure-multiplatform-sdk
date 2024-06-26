import asyncio
import json
import base64
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.Form import DecryptedForm, Form
from model.CallResult import CallResult, create_result_from_json
from ctypes import c_char_p, c_void_p
from typing import List, Optional, Dict
from model.Patient import Patient
from model.User import User
from model.embed.AccessLevel import AccessLevel
from dataclasses import field
from crypto.entities.SecretIdOption import SecretIdOption
from model.specializations.HexString import HexString
from model.couchdb.DocIdentifier import DocIdentifier
from model.FormTemplate import FormTemplate
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.SimpleShareResult import SimpleShareResult
from crypto.entities.FormShareOptions import FormShareOptions
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult

class FormApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createFormApi()
		self.icure_sdk = icure_sdk
		self.executor = executor
		self.encrypted = FormFlavouredEncryptedApi(executor)
		self.tryAndRecover = FormFlavouredApi(executor)

	async def create_form_async(self, entity: DecryptedForm) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createFormAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_form_blocking(self, entity: DecryptedForm) -> DecryptedForm:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createFormBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def create_forms_async(self, entities: List[DecryptedForm]) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createFormsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_forms_blocking(self, entities: List[DecryptedForm]) -> List[DecryptedForm]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createFormsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedForm], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.withEncryptionMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedForm], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedForm:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.withEncryptionMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_encryption_keys_of_async(self, form: Form) -> List[HexString]:
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
			"form": serialize_form(form),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.getEncryptionKeysOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, form: Form) -> List[HexString]:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.getEncryptionKeysOfBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def has_write_access_async(self, form: Form) -> bool:
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
			"form": serialize_form(form),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.hasWriteAccessAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, form: Form) -> bool:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, form: Form) -> List[str]:
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
			"form": serialize_form(form),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.decryptPatientIdOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, form: Form) -> List[str]:
		payload = {
			"form": serialize_form(form),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.decryptPatientIdOfBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Form, delegates: List[str]) -> None:
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
			"entity": serialize_form(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createDelegationDeAnonymizationMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Form, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_form(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormApi.createDelegationDeAnonymizationMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

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

	async def share_with_async(self, delegate_id: str, form: DecryptedForm, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
			"form": form.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, form: DecryptedForm, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"form": form.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def try_share_with_many_async(self, form: DecryptedForm, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
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
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, form: DecryptedForm, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def share_with_many_async(self, form: DecryptedForm, delegates: Dict[str, FormShareOptions]) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, form: DecryptedForm, delegates: Dict[str, FormShareOptions]) -> DecryptedForm:
		payload = {
			"form": form.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def find_forms_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedForm](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedForm._deserialize(x)
				)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_forms_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedForm]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientBlocking(
			self.native_api,
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
			return PaginatedListIterator[DecryptedForm](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedForm._deserialize(x)
			)

	async def modify_form_async(self, entity: DecryptedForm) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
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

	def modify_form_blocking(self, entity: DecryptedForm) -> DecryptedForm:
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
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def modify_forms_async(self, entities: List[DecryptedForm]) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def modify_forms_blocking(self, entities: List[DecryptedForm]) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_async(self, entity_id: str) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
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

	def get_form_blocking(self, entity_id: str) -> DecryptedForm:
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
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_forms_async(self, entity_ids: List[str]) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_forms_blocking(self, entity_ids: List[str]) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_by_logical_uuid_async(self, logical_uuid: str) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
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

	def get_form_by_logical_uuid_blocking(self, logical_uuid: str) -> DecryptedForm:
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
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_forms_by_logical_uuid_async(self, logical_uuid: str) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_forms_by_logical_uuid_blocking(self, logical_uuid: str) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_forms_by_unique_id_async(self, unique_id: str) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_forms_by_unique_id_blocking(self, unique_id: str) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_form_by_unique_id_async(self, unique_id: str) -> DecryptedForm:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedForm._deserialize(success.decode('utf-8'))
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

	def get_form_by_unique_id_blocking(self, unique_id: str) -> DecryptedForm:
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
			return_value = DecryptedForm._deserialize(result_info["success"])
			return return_value

	async def get_children_forms_async(self, hc_party_id: str, parent_id: str) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def get_children_forms_blocking(self, hc_party_id: str, parent_id: str) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_forms_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[DecryptedForm]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedForm._deserialize(x1) for x1 in success.decode('utf-8')]
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

	def list_forms_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[DecryptedForm]:
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
			return_value = [DecryptedForm._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	class FormFlavouredEncryptedApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createFormFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, form: EncryptedForm, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"form": form.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, form: EncryptedForm, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"form": form.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, form: EncryptedForm, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
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
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, form: EncryptedForm, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
			payload = {
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, form: EncryptedForm, delegates: Dict[str, FormShareOptions]) -> EncryptedForm:
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
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, form: EncryptedForm, delegates: Dict[str, FormShareOptions]) -> EncryptedForm:
			payload = {
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyBlocking(
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

		async def find_forms_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedForm]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedForm](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedForm._deserialize(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_forms_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedForm]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientBlocking(
				self.native_api,
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
				return PaginatedListIterator[EncryptedForm](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedForm._deserialize(x)
				)

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

	class FormFlavouredApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createFormFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, form: Form, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"form": form.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, form: Form, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"form": form.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, form: Form, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
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
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, form: Form, delegates: Dict[str, FormShareOptions]) -> SimpleShareResult:
			payload = {
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, form: Form, delegates: Dict[str, FormShareOptions]) -> Form:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Form._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, form: Form, delegates: Dict[str, FormShareOptions]) -> Form:
			payload = {
				"form": form.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.shareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Form._deserialize(result_info["success"])
				return return_value

		async def find_forms_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[Form](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_form(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_forms_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Form]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.FormFlavouredApi.findFormsByHcPartyPatientBlocking(
				self.native_api,
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
				return PaginatedListIterator[Form](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_form(x)
				)

		async def modify_form_async(self, entity: Form) -> Form:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Form._deserialize(success.decode('utf-8'))
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

		def modify_form_blocking(self, entity: Form) -> Form:
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
				return_value = Form._deserialize(result_info["success"])
				return return_value

		async def modify_forms_async(self, entities: List[Form]) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def modify_forms_blocking(self, entities: List[Form]) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_form_async(self, entity_id: str) -> Form:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Form._deserialize(success.decode('utf-8'))
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

		def get_form_blocking(self, entity_id: str) -> Form:
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
				return_value = Form._deserialize(result_info["success"])
				return return_value

		async def get_forms_async(self, entity_ids: List[str]) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def get_forms_blocking(self, entity_ids: List[str]) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_form_by_logical_uuid_async(self, logical_uuid: str) -> Form:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Form._deserialize(success.decode('utf-8'))
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

		def get_form_by_logical_uuid_blocking(self, logical_uuid: str) -> Form:
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
				return_value = Form._deserialize(result_info["success"])
				return return_value

		async def get_forms_by_logical_uuid_async(self, logical_uuid: str) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def get_forms_by_logical_uuid_blocking(self, logical_uuid: str) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_forms_by_unique_id_async(self, unique_id: str) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def get_forms_by_unique_id_blocking(self, unique_id: str) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_form_by_unique_id_async(self, unique_id: str) -> Form:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Form._deserialize(success.decode('utf-8'))
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

		def get_form_by_unique_id_blocking(self, unique_id: str) -> Form:
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
				return_value = Form._deserialize(result_info["success"])
				return return_value

		async def get_children_forms_async(self, hc_party_id: str, parent_id: str) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def get_children_forms_blocking(self, hc_party_id: str, parent_id: str) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def list_forms_by_hcparty_and_patient_foreign_keys_async(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[Form]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Form._deserialize(x1) for x1 in success.decode('utf-8')]
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

		def list_forms_by_hcparty_and_patient_foreign_keys_blocking(self, hc_party_id: str, secret_fkeys: str, health_element_id: Optional[str] = None, plan_of_action_id: Optional[str] = None, form_template_id: Optional[str] = None) -> List[Form]:
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
				return_value = [Form._deserialize(x1) for x1 in result_info["success"]]
				return return_value

__all__ = ['FormApi']