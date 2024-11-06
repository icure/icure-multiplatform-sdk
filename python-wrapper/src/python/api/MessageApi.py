# auto-generated file
import asyncio
import json
from DecryptedMessage import cardinal_sdk.model
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
from Message import cardinal_sdk.model
from serialize_message import cardinal_sdk.model
from List import typing
from HexString import cardinal_sdk.model.specializations
from EncryptedMessage import cardinal_sdk.model
from deserialize_cardinal_sdk.model import Message
from cardinal_sdk.filters.FilterOptions import FilterOptions, SortableFilterOptions
from DocIdentifier import cardinal_sdk.model
from IdWithMandatoryRev import cardinal_sdk.model
from MessageShareOptions import cardinal_sdk.model
from PaginatedListIterator import cardinal_sdk.pagination.PaginatedListIterator
from PTR_RESULT_CALLBACK_FUNC import cardinal_sdk.kotlin_types
from SubscriptionEventType import cardinal_sdk.model
from EntitySubscriptionConfiguration import cardinal_sdk.model
from EntitySubscription import cardinal_sdk.subscription.EntitySubscription


class MessageApi:

	class MessageFlavouredEncryptedApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
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
				"message": message.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"message": message.__serialize__(),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithBlocking(
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

		async def share_with_many_async(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
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
				"message": message.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"message": message.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.shareWithManyBlocking(
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

		async def filter_messages_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
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
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_messages_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesByBlocking(
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

		async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
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
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.filterMessagesBySortedBlocking(
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

		async def undelete_message_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"message": cardinal_sdk.model(message),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_message_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"message": cardinal_sdk.model(message),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def modify_message_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.modifyMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_message_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.modifyMessageBlocking(
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

		async def undelete_message_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
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
				"id": id,
				"rev": rev,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_message_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.undeleteMessageByIdBlocking(
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

		async def get_message_async(self, entity_id: str) -> cardinal_sdk.model:
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
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_message_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessageBlocking(
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

		async def get_messages_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
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
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessagesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_messages_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.getMessagesBlocking(
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

		async def set_messages_read_status_async(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
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
				"time": time,
				"readStatus": read_status,
				"userId": user_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.setMessagesReadStatusAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_messages_read_status_blocking(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
				"time": time,
				"readStatus": read_status,
				"userId": user_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.encrypted.setMessagesReadStatusBlocking(
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

	class MessageFlavouredApi:

		def __init__(self, cardinal_sdk):
			self.cardinal_sdk = cardinal_sdk

		async def share_with_async(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"message": cardinal_sdk.model(message),
				"options": options.__serialize__() if options is not None else None,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
			payload = {
				"delegateId": delegate_id,
				"message": cardinal_sdk.model(message),
				"options": options.__serialize__() if options is not None else None,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def share_with_many_async(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"message": cardinal_sdk.model(message),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithManyAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
			payload = {
				"message": cardinal_sdk.model(message),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.shareWithManyBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def filter_messages_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: Message(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesByAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_messages_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesByBlocking(
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
					deserializer = lambda x: Message(x),
					executor = self.cardinal_sdk._executor
				)

		async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model](
						producer = success,
						deserializer = lambda x: Message(x),
						executor = self.cardinal_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"filter": filter.__serialize__(),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesBySortedAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
			payload = {
				"filter": filter.__serialize__(),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.filterMessagesBySortedBlocking(
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
					deserializer = lambda x: Message(x),
					executor = self.cardinal_sdk._executor
				)

		async def undelete_message_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"message": cardinal_sdk.model(message),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_message_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"message": cardinal_sdk.model(message),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def modify_message_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.modifyMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_message_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
			payload = {
				"entity": cardinal_sdk.model(entity),
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.modifyMessageBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def undelete_message_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"id": id,
				"rev": rev,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageByIdAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def undelete_message_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
			payload = {
				"id": id,
				"rev": rev,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.undeleteMessageByIdBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def get_message_async(self, entity_id: str) -> cardinal_sdk.model:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Message(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessageAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_message_blocking(self, entity_id: str) -> cardinal_sdk.model:
			payload = {
				"entityId": entity_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessageBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = Message(result_info.success)
				return return_value

		async def get_messages_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Message(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessagesAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_messages_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.getMessagesBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [Message(x1) for x1 in result_info.success]
				return return_value

		async def set_messages_read_status_async(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Message(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
				"time": time,
				"readStatus": read_status,
				"userId": user_id,
			}
			callback = cardinal_sdk.kotlin_types(make_result_and_complete)
			loop.run_in_executor(
				self.cardinal_sdk._executor,
				cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.setMessagesReadStatusAsync,
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_messages_read_status_blocking(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
				"time": time,
				"readStatus": read_status,
				"userId": user_id,
			}
			call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryAndRecover.setMessagesReadStatusBlocking(
				self.cardinal_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
			cardinal_sdk.kotlin_types.DisposeString(call_result)
			if result_info.failure is not None:
				raise cardinal_sdk.model.CallResult(result_info.failure)
			else:
				return_value = [Message(x1) for x1 in result_info.success]
				return return_value

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk
		self.encrypted = MessageApi.MessageFlavouredEncryptedApi(self.cardinal_sdk)
		self.try_and_recover = MessageApi.MessageFlavouredApi(self.cardinal_sdk)

	async def create_message_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_message_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageBlocking(
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

	async def create_message_in_topic_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageInTopicAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_message_in_topic_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createMessageInTopicBlocking(
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

	async def with_encryption_metadata_async(self, base: typing[cardinal_sdk.model], patient: typing[cardinal_sdk.model], user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
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
			"patient": cardinal_sdk.model(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.withEncryptionMetadataAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: typing[cardinal_sdk.model], patient: typing[cardinal_sdk.model], user: typing[cardinal_sdk.model] = None, delegates: typing[str, cardinal_sdk.model] = {}, secret_id: cardinal_sdk.model = cardinal_sdk.model()) -> cardinal_sdk.model:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": cardinal_sdk.model(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": cardinal_sdk.model(secret_id),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.withEncryptionMetadataBlocking(
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

	async def get_encryption_keys_of_async(self, message: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
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
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getEncryptionKeysOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, message: cardinal_sdk.model) -> typing[cardinal_sdk.model.specializations]:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, message: cardinal_sdk.model) -> bool:
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
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.hasWriteAccessAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, message: cardinal_sdk.model) -> bool:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, message: cardinal_sdk.model) -> typing[str]:
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
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptPatientIdOfAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, message: cardinal_sdk.model) -> typing[str]:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptPatientIdOfBlocking(
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createDelegationDeAnonymizationMetadataAsync,
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
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.createDelegationDeAnonymizationMetadataBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def decrypt_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"message": message.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"message": message.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.decryptBlocking(
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

	async def try_decrypt_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Message(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"message": message.__serialize__(),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryDecryptAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"message": message.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.tryDecryptBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = Message(result_info.success)
			return return_value

	async def match_messages_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_messages_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesByBlocking(
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

	async def match_messages_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def match_messages_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> typing[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.matchMessagesBySortedBlocking(
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

	async def delete_message_by_id_async(self, entity_id: str, rev: str) -> cardinal_sdk.model:
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
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_message_by_id_blocking(self, entity_id: str, rev: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageByIdBlocking(
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

	async def delete_messages_by_ids_async(self, entity_ids: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
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
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesByIdsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_messages_by_ids_blocking(self, entity_ids: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0.__serialize__() for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesByIdsBlocking(
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

	async def purge_message_by_id_async(self, id: str, rev: str) -> None:
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
			"id": id,
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_message_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def delete_message_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
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
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_message_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessageBlocking(
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

	async def delete_messages_async(self, messages: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
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
			"messages": [cardinal_sdk.model(x0) for x0 in messages],
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_messages_blocking(self, messages: typing[cardinal_sdk.model]) -> typing[cardinal_sdk.model]:
		payload = {
			"messages": [cardinal_sdk.model(x0) for x0 in messages],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.deleteMessagesBlocking(
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

	async def purge_message_async(self, message: cardinal_sdk.model) -> None:
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
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_message_blocking(self, message: cardinal_sdk.model) -> None:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.purgeMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)

	async def share_with_async(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
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
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, message: cardinal_sdk.model, options: typing[cardinal_sdk.model] = None) -> cardinal_sdk.model:
		payload = {
			"delegateId": delegate_id,
			"message": message.__serialize__(),
			"options": options.__serialize__() if options is not None else None,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithBlocking(
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

	async def share_with_many_async(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
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
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithManyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, message: cardinal_sdk.model, delegates: typing[str, cardinal_sdk.model]) -> cardinal_sdk.model:
		payload = {
			"message": message.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.shareWithManyBlocking(
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

	async def filter_messages_by_async(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_messages_by_blocking(self, filter: FilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesByBlocking(
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

	async def filter_messages_by_sorted_async(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def filter_messages_by_sorted_blocking(self, filter: SortableFilterOptions[cardinal_sdk.model]) -> cardinal_sdk.pagination.PaginatedListIterator[cardinal_sdk.model]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.filterMessagesBySortedBlocking(
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

	async def undelete_message_async(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = Message(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"message": cardinal_sdk.model(message),
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_message_blocking(self, message: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"message": cardinal_sdk.model(message),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = cardinal_sdk.model.CallResult(ctypes(call_result, ctypes).value.decode('utf-8'))
		cardinal_sdk.kotlin_types.DisposeString(call_result)
		if result_info.failure is not None:
			raise cardinal_sdk.model.CallResult(result_info.failure)
		else:
			return_value = Message(result_info.success)
			return return_value

	async def modify_message_async(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.modifyMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_message_blocking(self, entity: cardinal_sdk.model) -> cardinal_sdk.model:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.modifyMessageBlocking(
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

	async def undelete_message_by_id_async(self, id: str, rev: str) -> cardinal_sdk.model:
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
			"id": id,
			"rev": rev,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def undelete_message_by_id_blocking(self, id: str, rev: str) -> cardinal_sdk.model:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.undeleteMessageByIdBlocking(
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

	async def get_message_async(self, entity_id: str) -> cardinal_sdk.model:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessageAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_message_blocking(self, entity_id: str) -> cardinal_sdk.model:
		payload = {
			"entityId": entity_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessageBlocking(
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

	async def get_messages_async(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
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
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessagesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_messages_blocking(self, entity_ids: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.getMessagesBlocking(
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

	async def set_messages_read_status_async(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
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
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.setMessagesReadStatusAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def set_messages_read_status_blocking(self, entity_ids: typing[str], time: typing[int], read_status: bool, user_id: typing[str]) -> typing[cardinal_sdk.model]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
			"time": time,
			"readStatus": read_status,
			"userId": user_id,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.setMessagesReadStatusBlocking(
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

	async def subscribe_to_events_async(self, events: typing[cardinal_sdk.model], filter: FilterOptions[cardinal_sdk.model], subscription_config: typing[cardinal_sdk.model] = None) -> cardinal_sdk.subscription.EntitySubscription[cardinal_sdk.model]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = cardinal_sdk.subscription.EntitySubscription[cardinal_sdk.model](
					producer = success,
					deserializer = lambda x: cardinal_sdk.model._deserialize(x),
					executor = self.cardinal_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		callback = cardinal_sdk.kotlin_types(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def subscribe_to_events_blocking(self, events: typing[cardinal_sdk.model], filter: FilterOptions[cardinal_sdk.model], subscription_config: typing[cardinal_sdk.model] = None) -> cardinal_sdk.subscription.EntitySubscription[cardinal_sdk.model]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = cardinal_sdk.kotlin_types.kotlin.root.com.icure.cardinal.sdk.py.api.MessageApi.subscribeToEventsBlocking(
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
			return cardinal_sdk.subscription.EntitySubscription[cardinal_sdk.model](
				producer = class_pointer,
				deserializer = lambda x: cardinal_sdk.model._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
