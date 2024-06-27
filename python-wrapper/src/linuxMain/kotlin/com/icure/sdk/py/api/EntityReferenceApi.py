import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model import EntityReference
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p

class EntityReferenceApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.getLatestAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_latest_blocking(self, prefix: str) -> EntityReference:
		payload = {
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.getLatestBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.createEntityReferenceAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_entity_reference_blocking(self, entity_reference: EntityReference) -> EntityReference:
		payload = {
			"entity_reference": entity_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.EntityReferenceApi.createEntityReferenceBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EntityReference._deserialize(result_info["success"])
			return return_value