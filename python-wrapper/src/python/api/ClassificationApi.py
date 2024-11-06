# auto-generated file
import asyncio
import json
from DecryptedClassification import cardinal_sdk.model
from DATA_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from symbols import cardinal_sdk.kotlin_types
from create_result_from_json import cardinal_sdk.model.CallResult
from cast import ctypes
from c_char_p import ctypes
from interpret_kt_error import cardinal_sdk.model.CallResult
from Optional import typing
from Patient import cardinal_sdk.model
from User import cardinal_sdk.model
from Dict import typing
from AccessLevel import cardinal_sdk.model
from SecretIdUseOption import cardinal_sdk.model
from SecretIdUseOptionUseAnySharedWithParent import cardinal_sdk.model
from serialize_patient import cardinal_sdk.model
from serialize_secret_id_use_option import cardinal_sdk.model
from Classification import cardinal_sdk.model
from serialize_classification import cardinal_sdk.model
from List import typing
from HexString import cardinal_sdk.model.specializations
from EncryptedClassification import cardinal_sdk.model
from deserialize_cardinal_sdk.model import Classification
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from DocIdentifier import cardinal_sdk.model
from ClassificationShareOptions import cardinal_sdk.model
from PaginatedListIterator import cardinal_sdk.pagination.PaginatedListIterator
from PTR_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types


class ClassificationApi:

	class ClassificationFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"classification": classification.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"classification": classification.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = cardinal_sdk.model._deserialize(result_info.success)
				return return_value

		async def share_with_many_async(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"classification": classification.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"classification": classification.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = cardinal_sdk.model._deserialize(result_info.success)
				return return_value

		async def filter_classifications_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: cardinal_sdk.model._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: cardinal_sdk.model._deserialize(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.filterClassificationsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)

		async def modify_classification_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.modifyClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_classification_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.modifyClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = cardinal_sdk.model._deserialize(result_info.success)
				return return_value

		async def get_classification_async(self, entity_id: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classification_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = cardinal_sdk.model._deserialize(result_info.success)
				return return_value

		async def get_classifications_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classifications_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted.getClassificationsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
				return return_value

	class ClassificationFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"classification": cardinal_sdk.model(classification),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"classification": cardinal_sdk.model(classification),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Classification(result_info.success)
				return return_value

		async def share_with_many_async(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"classification": cardinal_sdk.model(classification),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"classification": cardinal_sdk.model(classification),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Classification(result_info.success)
				return return_value

		async def filter_classifications_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: Classification(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsByBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: Classification(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: Classification(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.filterClassificationsBySortedBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
				cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
			else:
				class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
				cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
				return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = class_pointer,
					deserializer = lambda x: Classification(x),
					executor = self.cardinal_sdk._executor
				)

		async def modify_classification_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.modifyClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_classification_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.modifyClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Classification(result_info.success)
				return return_value

		async def get_classification_async(self, entity_id: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Classification(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classification_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Classification(result_info.success)
				return return_value

		async def get_classifications_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Classification(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationsAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_classifications_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryAndRecover.getClassificationsBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [Classification(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = ClassificationApi.ClassificationFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = ClassificationApi.ClassificationFlavouredApi(self.cardinal_sdk)

	async def create_classification_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_classification_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: typing[cardinal_sdk.model], patient: cardinal_sdk.model, user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": cardinal_sdk.model(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: typing[cardinal_sdk.model], patient: cardinal_sdk.model, user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": cardinal_sdk.model(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.withEncryptionMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, classification: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
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
			"classification": cardinal_sdk.model(classification),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, classification: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
		payload = {
			"classification": cardinal_sdk.model(classification),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getEncryptionKeysOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def has_write_access_async(self, classification: cardinal_sdk.model) -> bool:
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
			"classification": cardinal_sdk.model(classification),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, classification: cardinal_sdk.model) -> bool:
		payload = {
			"classification": cardinal_sdk.model(classification),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.hasWriteAccessBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, classification: cardinal_sdk.model) -> typing[str]:
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
			"classification": cardinal_sdk.model(classification),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, classification: cardinal_sdk.model) -> typing[str]:
		payload = {
			"classification": cardinal_sdk.model(classification),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptPatientIdOfBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: cardinal_sdk.model, delegates: typing[str]) -> None:
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
			"entity": cardinal_sdk.model(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createDelegationDeAnonymizationMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: cardinal_sdk.model, delegates: typing[str]) -> None:
		payload = {
			"entity": cardinal_sdk.model(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def decrypt_async(self, classification: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, classification: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"classification": classification.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.decryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, classification: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Classification(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, classification: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"classification": classification.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = Classification(result_info.success)
			return return_value

	async def match_classifications_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
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
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_classifications_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def match_classifications_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
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
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.matchClassificationsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def delete_classification_async(self, entity_id: str) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_classification_blocking(self, entity_id: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def delete_classifications_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_classifications_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.deleteClassificationsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def share_with_async(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"classification": classification.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, classification: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
		payload = {
			"delegateId": delegate_id,
			"classification": classification.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def share_with_many_async(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"classification": classification.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, classification: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
		payload = {
			"classification": classification.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.shareWithManyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def filter_classifications_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_classifications_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def filter_classifications_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"filter": filter.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_classifications_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.filterClassificationsBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = ctypes(error_str_pointer, ctypes).value.decode('utf_8')
			cardinal_sdk.kotlin_types.DisposeString(error_str_pointer)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			raise cardinal_sdk.model.CallResult(json.loads(error_data_str))
		else:
			class_pointer = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			cardinal_sdk.kotlin_types.DisposeStablePointer(call_result.pinned)
			return cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def modify_classification_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.modifyClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_classification_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.modifyClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_classification_async(self, entity_id: str) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.model._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_classification_blocking(self, entity_id: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = cardinal_sdk.model._deserialize(result_info.success)
			return return_value

	async def get_classifications_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [cardinal_sdk.model._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_classifications_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.ClassificationApi.getClassificationsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = [cardinal_sdk.model._deserialize(x1) for x1 in result_info.success]
			return return_value
