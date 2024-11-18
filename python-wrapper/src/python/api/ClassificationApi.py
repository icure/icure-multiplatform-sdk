# auto-generated file
import asyncio
import json
from cardinal_sdk.model import DecryptedClassification, Patient, User, AccessLevel, SecretIdUseOption, SecretIdUseOptionUseAnySharedWithParent, serialize_patient, serialize_secret_id_use_option, Classification, serialize_classification, EncryptedClassification, deserialize_classification, DocIdentifier, ClassificationShareOptions
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from cardinal_sdk.model.specializations import HexString
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator


class ClassificationApi:

	class ClassificationFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, classification: EncryptedClassification, options: Optional[ClassificationShareOptions] = None) -> EncryptedClassification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedClassification._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"classification": classification.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, classification: EncryptedClassification, options: Optional[ClassificationShareOptions] = None) -> EncryptedClassification:
			payload = {
				"delegateId": delegate_id,
				"classification": classification.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedClassification._deserialize(result_info.success)
				return return_value

		async def share_with_many_async(self, classification: EncryptedClassification, delegates: Dict[str, ClassificationShareOptions]) -> EncryptedClassification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedClassification._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"classification": classification.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, classification: EncryptedClassification, delegates: Dict[str, ClassificationShareOptions]) -> EncryptedClassification:
			payload = {
				"classification": classification.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedClassification._deserialize(result_info.success)
				return return_value

		async def filter_classifications_by_async(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[EncryptedClassification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedClassification](
						producer = success,
						deserializer = lambda x: EncryptedClassification._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_blocking(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[EncryptedClassification]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[EncryptedClassification](
					producer = class_pointer,
					deserializer = lambda x: EncryptedClassification._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[EncryptedClassification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedClassification](
						producer = success,
						deserializer = lambda x: EncryptedClassification._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[EncryptedClassification]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[EncryptedClassification](
					producer = class_pointer,
					deserializer = lambda x: EncryptedClassification._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def modify_classification_async(self, entity: EncryptedClassification) -> EncryptedClassification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedClassification._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.modifyClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_classification_blocking(self, entity: EncryptedClassification) -> EncryptedClassification:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.modifyClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedClassification._deserialize(result_info.success)
				return return_value

		async def get_classification_async(self, entity_id: str) -> EncryptedClassification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedClassification._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classification_blocking(self, entity_id: str) -> EncryptedClassification:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = EncryptedClassification._deserialize(result_info.success)
				return return_value

		async def get_classifications_async(self, entity_ids: List[str]) -> List[EncryptedClassification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedClassification._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classifications_blocking(self, entity_ids: List[str]) -> List[EncryptedClassification]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [EncryptedClassification._deserialize(x1) for x1 in result_info.success]
				return return_value

	class ClassificationFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, classification: Classification, options: Optional[ClassificationShareOptions] = None) -> Classification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"classification": serialize_classification(classification),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, classification: Classification, options: Optional[ClassificationShareOptions] = None) -> Classification:
			payload = {
				"delegateId": delegate_id,
				"classification": serialize_classification(classification),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_classification(result_info.success)
				return return_value

		async def share_with_many_async(self, classification: Classification, delegates: Dict[str, ClassificationShareOptions]) -> Classification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"classification": serialize_classification(classification),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, classification: Classification, delegates: Dict[str, ClassificationShareOptions]) -> Classification:
			payload = {
				"classification": serialize_classification(classification),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_classification(result_info.success)
				return return_value

		async def filter_classifications_by_async(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[Classification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[Classification](
						producer = success,
						deserializer = lambda x: deserialize_classification(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_blocking(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[Classification]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[Classification](
					producer = class_pointer,
					deserializer = lambda x: deserialize_classification(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[Classification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[Classification](
						producer = success,
						deserializer = lambda x: deserialize_classification(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[Classification]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise interpret_kt_error(json.loads(error_data_str))
			else:
				class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[Classification](
					producer = class_pointer,
					deserializer = lambda x: deserialize_classification(x),
					executor = self.cardinal_sdk._executor
				)

		async def modify_classification_async(self, entity: Classification) -> Classification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": serialize_classification(entity),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.modifyClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_classification_blocking(self, entity: Classification) -> Classification:
			payload = {
				"entity": serialize_classification(entity),
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.modifyClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_classification(result_info.success)
				return return_value

		async def get_classification_async(self, entity_id: str) -> Classification:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classification_blocking(self, entity_id: str) -> Classification:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = deserialize_classification(result_info.success)
				return return_value

		async def get_classifications_async(self, entity_ids: List[str]) -> List[Classification]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [deserialize_classification(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classifications_blocking(self, entity_ids: List[str]) -> List[Classification]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise interpret_kt_error(result_info.failure)
			else:
				return_value = [deserialize_classification(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = ClassificationApi.ClassificationFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = ClassificationApi.ClassificationFlavouredApi(self.cardinal_sdk)

	async def create_classification_async(self, entity: DecryptedClassification) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_classification_blocking(self, entity: DecryptedClassification) -> DecryptedClassification:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedClassification], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedClassification], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdUseOption = SecretIdUseOptionUseAnySharedWithParent()) -> DecryptedClassification:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_use_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, classification: Classification) -> List[HexString]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": serialize_classification(classification),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, classification: Classification) -> List[HexString]:
		payload = {
			"classification": serialize_classification(classification),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def has_write_access_async(self, classification: Classification) -> bool:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": serialize_classification(classification),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, classification: Classification) -> bool:
		payload = {
			"classification": serialize_classification(classification),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, classification: Classification) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": serialize_classification(classification),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, classification: Classification) -> List[str]:
		payload = {
			"classification": serialize_classification(classification),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Classification, delegates: List[str]) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": serialize_classification(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Classification, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_classification(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def decrypt_async(self, classification: EncryptedClassification) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, classification: EncryptedClassification) -> DecryptedClassification:
		payload = {
			"classification": classification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, classification: EncryptedClassification) -> Classification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_classification(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, classification: EncryptedClassification) -> Classification:
		payload = {
			"classification": classification.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = deserialize_classification(result_info.success)
			return return_value

	async def match_classifications_by_async(self, filter: FilterOptions[Classification]) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_classifications_by_blocking(self, filter: FilterOptions[Classification]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_classifications_by_sorted_async(self, filter: SortableFilterOptions[Classification]) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[Classification]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_classification_async(self, entity_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_classification_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_classifications_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_classifications_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationsBlocking(
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

	async def share_with_async(self, delegate_id: str, classification: DecryptedClassification, options: Optional[ClassificationShareOptions] = None) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"classification": classification.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, classification: DecryptedClassification, options: Optional[ClassificationShareOptions] = None) -> DecryptedClassification:
		payload = {
			"delegateId": delegate_id,
			"classification": classification.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, classification: DecryptedClassification, delegates: Dict[str, ClassificationShareOptions]) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, classification: DecryptedClassification, delegates: Dict[str, ClassificationShareOptions]) -> DecryptedClassification:
		payload = {
			"classification": classification.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def filter_classifications_by_async(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[DecryptedClassification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedClassification](
					producer = success,
					deserializer = lambda x: DecryptedClassification._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_classifications_by_blocking(self, filter: FilterOptions[Classification]) -> PaginatedListIterator[DecryptedClassification]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedClassification](
				producer = class_pointer,
				deserializer = lambda x: DecryptedClassification._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[DecryptedClassification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedClassification](
					producer = success,
					deserializer = lambda x: DecryptedClassification._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[Classification]) -> PaginatedListIterator[DecryptedClassification]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedClassification](
				producer = class_pointer,
				deserializer = lambda x: DecryptedClassification._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def modify_classification_async(self, entity: DecryptedClassification) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.modifyClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_classification_blocking(self, entity: DecryptedClassification) -> DecryptedClassification:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.modifyClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def get_classification_async(self, entity_id: str) -> DecryptedClassification:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedClassification._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_classification_blocking(self, entity_id: str) -> DecryptedClassification:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DecryptedClassification._deserialize(result_info.success)
			return return_value

	async def get_classifications_async(self, entity_ids: List[str]) -> List[DecryptedClassification]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedClassification._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_classifications_blocking(self, entity_ids: List[str]) -> List[DecryptedClassification]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [DecryptedClassification._deserialize(x1) for x1 in result_info.success]
			return return_value
