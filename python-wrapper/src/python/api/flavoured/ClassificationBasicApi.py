import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model.couchdb.DocIdentifier import DocIdentifier
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import List
from model.Classification import EncryptedClassification

class ClassificationBasicApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def delete_classification_async(self, entity_id: str) -> DocIdentifier:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavourlessApi.deleteClassificationAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_classification_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavourlessApi.deleteClassificationBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def delete_classifications_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavourlessApi.deleteClassificationsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_classifications_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavourlessApi.deleteClassificationsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_classification_async(self, entity: EncryptedClassification) -> EncryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedClassification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.modifyClassificationAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_classification_blocking(self, entity: EncryptedClassification) -> EncryptedClassification:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.modifyClassificationBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedClassification._deserialize(result_info["success"])
			return return_value

	async def get_classification_async(self, entity_id: str) -> EncryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedClassification._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.getClassificationAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_classification_blocking(self, entity_id: str) -> EncryptedClassification:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.getClassificationBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedClassification._deserialize(result_info["success"])
			return return_value

	async def get_classifications_async(self, entity_ids: List[str]) -> List[EncryptedClassification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedClassification._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.getClassificationsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_classifications_blocking(self, entity_ids: List[str]) -> List[EncryptedClassification]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ClassificationBasicFlavouredApi.getClassificationsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedClassification._deserialize(x1) for x1 in result_info["success"]]
			return return_value

__all__ = ['ClassificationBasicApi']