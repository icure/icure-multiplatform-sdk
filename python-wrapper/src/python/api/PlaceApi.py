# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import Optional
from cardinal_sdk.model import Place, DocIdentifier
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class PlaceApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_place_async(self, place_id: str) -> Optional[Place]:
		def do_decode(raw_result):
			return Place._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"placeId": place_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.getPlaceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_place_blocking(self, place_id: str) -> Optional[Place]:
		payload = {
			"placeId": place_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.getPlaceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Place._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def create_place_async(self, place: Place) -> Place:
		def do_decode(raw_result):
			return Place._deserialize(raw_result)
		payload = {
			"place": place.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.createPlaceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_place_blocking(self, place: Place) -> Place:
		payload = {
			"place": place.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.createPlaceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Place._deserialize(result_info.success)
			return return_value

	async def modify_place_async(self, place: Place) -> Place:
		def do_decode(raw_result):
			return Place._deserialize(raw_result)
		payload = {
			"place": place.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.modifyPlaceAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_place_blocking(self, place: Place) -> Place:
		payload = {
			"place": place.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.modifyPlaceBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Place._deserialize(result_info.success)
			return return_value

	async def delete_places_async(self, place_ids: list[str]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"placeIds": [x0 for x0 in place_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.deletePlacesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_places_blocking(self, place_ids: list[str]) -> list[DocIdentifier]:
		payload = {
			"placeIds": [x0 for x0 in place_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PlaceApi.deletePlacesBlocking(
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
