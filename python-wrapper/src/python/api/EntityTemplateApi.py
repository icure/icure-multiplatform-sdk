# auto-generated file
import json
from cardinal_sdk.model import EntityTemplate, IdWithMandatoryRev, DocIdentifier
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional, List


class EntityTemplateApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_entity_template_async(self, document_template_id: str) -> EntityTemplate:
		def do_decode(raw_result):
			return EntityTemplate._deserialize(raw_result)
		payload = {
			"documentTemplateId": document_template_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_entity_template_blocking(self, document_template_id: str) -> EntityTemplate:
		payload = {
			"documentTemplateId": document_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EntityTemplate._deserialize(result_info.success)
			return return_value

	async def create_entity_template_async(self, application_settings: EntityTemplate) -> EntityTemplate:
		def do_decode(raw_result):
			return EntityTemplate._deserialize(raw_result)
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_entity_template_blocking(self, application_settings: EntityTemplate) -> EntityTemplate:
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EntityTemplate._deserialize(result_info.success)
			return return_value

	async def modify_entity_template_async(self, document_template: EntityTemplate) -> EntityTemplate:
		def do_decode(raw_result):
			return EntityTemplate._deserialize(raw_result)
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_entity_template_blocking(self, document_template: EntityTemplate) -> EntityTemplate:
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplateBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EntityTemplate._deserialize(result_info.success)
			return return_value

	async def list_entity_templates_by_async(self, user_id: str, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_entity_templates_by_blocking(self, user_id: str, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"userId": user_id,
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_all_entity_templates_by_async(self, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listAllEntityTemplatesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_all_entity_templates_by_blocking(self, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listAllEntityTemplatesByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_entity_templates_by_keyword_async(self, user_id: str, type: str, keyword: str, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def list_entity_templates_by_keyword_blocking(self, user_id: str, type: str, keyword: str, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"userId": user_id,
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByKeywordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_all_entity_templates_by_keyword_async(self, type: str, keyword: str, include_entities: Optional[bool]) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.findAllEntityTemplatesByKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def find_all_entity_templates_by_keyword_blocking(self, type: str, keyword: str, include_entities: Optional[bool]) -> List[EntityTemplate]:
		payload = {
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.findAllEntityTemplatesByKeywordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_entity_templates_async(self, entity_template_ids: List[str]) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityTemplateIds": [x0 for x0 in entity_template_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_entity_templates_blocking(self, entity_template_ids: List[str]) -> List[EntityTemplate]:
		payload = {
			"entityTemplateIds": [x0 for x0 in entity_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_entity_templates_async(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_entity_templates_blocking(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_entity_templates_async(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		def do_decode(raw_result):
			return [EntityTemplate._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_entity_templates_blocking(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplatesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_entity_templates_async(self, entity_template_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"entityTemplateIds": [x0.__serialize__() for x0 in entity_template_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.deleteEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_entity_templates_blocking(self, entity_template_ids: List[IdWithMandatoryRev]) -> List[DocIdentifier]:
		payload = {
			"entityTemplateIds": [x0.__serialize__() for x0 in entity_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.deleteEntityTemplatesBlocking(
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
