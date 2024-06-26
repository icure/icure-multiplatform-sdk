import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.EntityTemplate import EntityTemplate
from ctypes import c_char_p
from typing import Optional, List
from model.couchdb.DocIdentifier import DocIdentifier

class EntityTemplateApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createEntityTemplateApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_entity_template_async(self, document_template_id: str) -> EntityTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template_id": document_template_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.getEntityTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_entity_template_blocking(self, document_template_id: str) -> EntityTemplate:
		payload = {
			"document_template_id": document_template_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.getEntityTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityTemplate._deserialize(result_info["success"])
			return return_value

	async def create_entity_template_async(self, application_settings: EntityTemplate) -> EntityTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"application_settings": application_settings.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.createEntityTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_entity_template_blocking(self, application_settings: EntityTemplate) -> EntityTemplate:
		payload = {
			"application_settings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.createEntityTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityTemplate._deserialize(result_info["success"])
			return return_value

	async def modify_entity_template_async(self, document_template: EntityTemplate) -> EntityTemplate:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityTemplate._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_template": document_template.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.modifyEntityTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_entity_template_blocking(self, document_template: EntityTemplate) -> EntityTemplate:
		payload = {
			"document_template": document_template.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.modifyEntityTemplateBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityTemplate._deserialize(result_info["success"])
			return return_value

	async def list_entity_templates_by_async(self, user_id: str, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"type": type,
			"search_string": search_string,
			"include_entities": include_entities,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listEntityTemplatesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_entity_templates_by_blocking(self, user_id: str, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"user_id": user_id,
			"type": type,
			"search_string": search_string,
			"include_entities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listEntityTemplatesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_all_entity_templates_by_async(self, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"search_string": search_string,
			"include_entities": include_entities,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listAllEntityTemplatesByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_all_entity_templates_by_blocking(self, type: str, search_string: Optional[str] = None, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"type": type,
			"search_string": search_string,
			"include_entities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listAllEntityTemplatesByBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_entity_templates_by_keyword_async(self, user_id: str, type: str, keyword: str, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"type": type,
			"keyword": keyword,
			"include_entities": include_entities,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listEntityTemplatesByKeywordAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_entity_templates_by_keyword_blocking(self, user_id: str, type: str, keyword: str, include_entities: Optional[bool] = None) -> List[EntityTemplate]:
		payload = {
			"user_id": user_id,
			"type": type,
			"keyword": keyword,
			"include_entities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.listEntityTemplatesByKeywordBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_all_entity_templates_by_keyword_async(self, type: str, keyword: str, include_entities: Optional[bool]) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type,
			"keyword": keyword,
			"include_entities": include_entities,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.findAllEntityTemplatesByKeywordAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_all_entity_templates_by_keyword_blocking(self, type: str, keyword: str, include_entities: Optional[bool]) -> List[EntityTemplate]:
		payload = {
			"type": type,
			"keyword": keyword,
			"include_entities": include_entities,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.findAllEntityTemplatesByKeywordBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_entity_templates_async(self, entity_template_ids: List[str]) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_template_ids": [x0 for x0 in entity_template_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.getEntityTemplatesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_entity_templates_blocking(self, entity_template_ids: List[str]) -> List[EntityTemplate]:
		payload = {
			"entity_template_ids": [x0 for x0 in entity_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.getEntityTemplatesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_entity_templates_async(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_templates": [x0.__serialize__() for x0 in entity_templates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.modifyEntityTemplatesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_entity_templates_blocking(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		payload = {
			"entity_templates": [x0.__serialize__() for x0 in entity_templates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.modifyEntityTemplatesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def create_entity_templates_async(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EntityTemplate._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_templates": [x0.__serialize__() for x0 in entity_templates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.createEntityTemplatesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_entity_templates_blocking(self, entity_templates: List[EntityTemplate]) -> List[EntityTemplate]:
		payload = {
			"entity_templates": [x0.__serialize__() for x0 in entity_templates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.createEntityTemplatesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EntityTemplate._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def delete_entity_template_async(self, entity_template_ids: List[str]) -> List[DocIdentifier]:
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
			"entity_template_ids": [x0 for x0 in entity_template_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.deleteEntityTemplateAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_entity_template_blocking(self, entity_template_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_template_ids": [x0 for x0 in entity_template_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityTemplateApi.deleteEntityTemplateBlocking(
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

__all__ = ['EntityTemplateApi']