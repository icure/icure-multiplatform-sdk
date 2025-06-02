# auto-generated file
import json
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from typing import Optional
from cardinal_sdk.model import Keyword, DocIdentifier
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class KeywordApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_keyword_async(self, keyword_id: str) -> Optional[Keyword]:
		def do_decode(raw_result):
			return Keyword._deserialize(raw_result) if raw_result is not None else None
		payload = {
			"keywordId": keyword_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.getKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_keyword_blocking(self, keyword_id: str) -> Optional[Keyword]:
		payload = {
			"keywordId": keyword_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.getKeywordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Keyword._deserialize(result_info.success) if result_info.success is not None else None
			return return_value

	async def create_keyword_async(self, keyword: Keyword) -> Keyword:
		def do_decode(raw_result):
			return Keyword._deserialize(raw_result)
		payload = {
			"keyword": keyword.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.createKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_keyword_blocking(self, keyword: Keyword) -> Keyword:
		payload = {
			"keyword": keyword.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.createKeywordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Keyword._deserialize(result_info.success)
			return return_value

	async def modify_keyword_async(self, keyword: Keyword) -> Keyword:
		def do_decode(raw_result):
			return Keyword._deserialize(raw_result)
		payload = {
			"keyword": keyword.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.modifyKeywordAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_keyword_blocking(self, keyword: Keyword) -> Keyword:
		payload = {
			"keyword": keyword.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.modifyKeywordBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = Keyword._deserialize(result_info.success)
			return return_value

	async def get_keywords_by_user_async(self, user_id: str) -> list[Keyword]:
		def do_decode(raw_result):
			return [Keyword._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.getKeywordsByUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_keywords_by_user_blocking(self, user_id: str) -> list[Keyword]:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.getKeywordsByUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Keyword._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def delete_keywords_async(self, keyword_ids: list[str]) -> list[DocIdentifier]:
		def do_decode(raw_result):
			return [DocIdentifier._deserialize(x1) for x1 in raw_result]
		payload = {
			"keywordIds": [x0 for x0 in keyword_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.deleteKeywordsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_keywords_blocking(self, keyword_ids: list[str]) -> list[DocIdentifier]:
		payload = {
			"keywordIds": [x0 for x0 in keyword_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.KeywordApi.deleteKeywordsBlocking(
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
