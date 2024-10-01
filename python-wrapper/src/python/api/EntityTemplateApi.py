# auto-generated file
import asyncio
import json
from cardinal_sdk.model import EntityTemplate, IdWithMandatoryRev, DocIdentifier
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional, List

class EntityTemplateApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_entity_template_async(self, document_template_id: str) -> EntityTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntityTemplate._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentTemplateId": document_template_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntityTemplate._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EntityTemplate._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentTemplate": document_template.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplateAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userId": user_id,
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"searchString": search_string,
			"includeEntities": include_entities,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listAllEntityTemplatesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"userId": user_id,
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.listEntityTemplatesByKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"keyword": keyword,
			"includeEntities": include_entities,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.findAllEntityTemplatesByKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityTemplateIds": [x0 for x0 in entity_template_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.getEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.modifyEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [EntityTemplate._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityTemplates": [x0.__serialize__() for x0 in entity_templates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.createEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityTemplateIds": [x0.__serialize__() for x0 in entity_template_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityTemplateApi.deleteEntityTemplatesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

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
