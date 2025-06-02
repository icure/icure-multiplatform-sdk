# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model import EntityReference
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class EntityReferenceApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_latest_async(self, prefix: str) -> EntityReference:
		def do_decode(raw_result):
			return EntityReference._deserialize(raw_result)
		payload = {
			"prefix": prefix,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityReferenceApi.getLatestAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_latest_blocking(self, prefix: str) -> EntityReference:
		payload = {
			"prefix": prefix,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityReferenceApi.getLatestBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EntityReference._deserialize(result_info.success)
			return return_value

	async def create_entity_reference_async(self, entity_reference: EntityReference) -> EntityReference:
		def do_decode(raw_result):
			return EntityReference._deserialize(raw_result)
		payload = {
			"entityReference": entity_reference.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityReferenceApi.createEntityReferenceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_entity_reference_blocking(self, entity_reference: EntityReference) -> EntityReference:
		payload = {
			"entityReference": entity_reference.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.EntityReferenceApi.createEntityReferenceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = EntityReference._deserialize(result_info.success)
			return return_value
