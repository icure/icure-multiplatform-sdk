import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.EntityReference import EntityReference
from ctypes import c_char_p

class EntityReferenceApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createEntityReferenceApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_latest_async(self, prefix: str) -> EntityReference:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityReference._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"prefix": prefix,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.getLatestAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_latest_blocking(self, prefix: str) -> EntityReference:
		payload = {
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.getLatestBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityReference._deserialize(result_info["success"])
			return return_value

	async def create_entity_reference_async(self, entity_reference: EntityReference) -> EntityReference:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EntityReference._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_reference": entity_reference.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.createEntityReferenceAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_entity_reference_blocking(self, entity_reference: EntityReference) -> EntityReference:
		payload = {
			"entity_reference": entity_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.createEntityReferenceBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityReference._deserialize(result_info["success"])
			return return_value

__all__ = ['EntityReferenceApi']