import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CalendarItem import DecryptedCalendarItem, CalendarItem
from model.CallResult import CallResult, create_result_from_json
from ctypes import c_char_p, c_void_p
from typing import Optional, Dict, List
from model.Patient import Patient
from model.User import User
from model.embed.AccessLevel import AccessLevel
from dataclasses import field
from crypto.entities.SecretIdOption import SecretIdOption
from model.specializations.HexString import HexString
from model.couchdb.DocIdentifier import DocIdentifier
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.SimpleShareResult import SimpleShareResult
from crypto.entities.CalendarItemShareOptions import CalendarItemShareOptions
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult
from model.PaginatedList import PaginatedList

class CalendarItemApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createCalendarItemApi()
		self.icure_sdk = icure_sdk
		self.executor = executor
		self.encrypted = CalendarItemFlavouredEncryptedApi(executor)
		self.tryAndRecover = CalendarItemFlavouredApi(executor)

	async def create_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createCalendarItemAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createCalendarItemBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedCalendarItem], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.withEncryptionMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedCalendarItem], patient: Patient, user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedCalendarItem:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient),
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.withEncryptionMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def get_encryption_keys_of_async(self, calendar_item: CalendarItem) -> List[HexString]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getEncryptionKeysOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, calendar_item: CalendarItem) -> List[HexString]:
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.getEncryptionKeysOfBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def has_write_access_async(self, calendar_item: CalendarItem) -> bool:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.hasWriteAccessAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, calendar_item: CalendarItem) -> bool:
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.hasWriteAccessBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def decrypt_patient_id_of_async(self, calendar_item: CalendarItem) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptPatientIdOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, calendar_item: CalendarItem) -> List[str]:
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.decryptPatientIdOfBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: CalendarItem, delegates: List[str]) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: CalendarItem, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_calendar_item(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemApi.createDelegationDeAnonymizationMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def delete_calendar_item_async(self, entity_id: str) -> DocIdentifier:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavourlessApi.deleteCalendarItemAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_calendar_item_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavourlessApi.deleteCalendarItemBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def delete_calendar_items_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavourlessApi.deleteCalendarItemsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_calendar_items_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavourlessApi.deleteCalendarItemsBlocking(
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

	async def share_with_async(self, delegate_id: str, calendar_item: DecryptedCalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"calendar_item": calendar_item.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, calendar_item: DecryptedCalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"calendar_item": calendar_item.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def try_share_with_many_async(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
		payload = {
			"calendar_item": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def share_with_many_async(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, calendar_item: DecryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> DecryptedCalendarItem:
		payload = {
			"calendar_item": calendar_item.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def find_calendar_items_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedCalendarItem](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedCalendarItem._deserialize(x)
				)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_calendar_items_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedCalendarItem]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientBlocking(
			self.native_api,
			json.dumps(payload)
		)
		error_str_pointer = PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result)
			raise Exception(error_msg)
		else:
			class_pointer = PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result)
			return PaginatedListIterator[DecryptedCalendarItem](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedCalendarItem._deserialize(x)
			)

	async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> DecryptedCalendarItem:
		payload = {
			"calendar_item": serialize_calendar_item(calendar_item),
			"patient": serialize_patient(patient),
			"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def modify_calendar_item_async(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_calendar_item_blocking(self, entity: DecryptedCalendarItem) -> DecryptedCalendarItem:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def get_calendar_item_async(self, entity_id: str) -> DecryptedCalendarItem:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedCalendarItem._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_calendar_item_blocking(self, entity_id: str) -> DecryptedCalendarItem:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedCalendarItem._deserialize(result_info["success"])
			return return_value

	async def get_calendar_items_async(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_calendar_items_by_period_and_hc_party_id_async(self, start_date: int, end_date: int, hc_party_id: str) -> List[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"hc_party_id": hc_party_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_calendar_items_by_period_and_hc_party_id_blocking(self, start_date: int, end_date: int, hc_party_id: str) -> List[DecryptedCalendarItem]:
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"hc_party_id": hc_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_calendars_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"agenda_id": agenda_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_calendars_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[DecryptedCalendarItem]:
		payload = {
			"start_date": start_date,
			"end_date": end_date,
			"agenda_id": agenda_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_calendar_items_with_ids_async(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_calendar_items_with_ids_blocking(self, entity_ids: List[str]) -> List[DecryptedCalendarItem]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_calendar_items_by_recurrence_id_async(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedCalendarItem._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"recurrence_id": recurrence_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_calendar_items_by_recurrence_id_blocking(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
		payload = {
			"recurrence_id": recurrence_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [DecryptedCalendarItem._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	class CalendarItemFlavouredEncryptedApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createCalendarItemFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, calendar_item: EncryptedCalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"calendar_item": calendar_item.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, calendar_item: EncryptedCalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"calendar_item": calendar_item.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedCalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, calendar_item: EncryptedCalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> EncryptedCalendarItem:
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info["success"])
				return return_value

		async def find_calendar_items_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedCalendarItem](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedCalendarItem._deserialize(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_calendar_items_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedCalendarItem]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientBlocking(
				self.native_api,
				json.dumps(payload)
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[EncryptedCalendarItem](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedCalendarItem._deserialize(x)
				)

		async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedCalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> EncryptedCalendarItem:
			payload = {
				"calendar_item": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info["success"])
				return return_value

		async def modify_calendar_item_async(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedCalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_calendar_item_blocking(self, entity: EncryptedCalendarItem) -> EncryptedCalendarItem:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info["success"])
				return return_value

		async def get_calendar_item_async(self, entity_id: str) -> EncryptedCalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedCalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_item_blocking(self, entity_id: str) -> EncryptedCalendarItem:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedCalendarItem._deserialize(result_info["success"])
				return return_value

		async def get_calendar_items_async(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendar_items_by_period_and_hc_party_id_async(self, start_date: int, end_date: int, hc_party_id: str) -> List[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_by_period_and_hc_party_id_blocking(self, start_date: int, end_date: int, hc_party_id: str) -> List[EncryptedCalendarItem]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendars_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendars_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[EncryptedCalendarItem]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendar_items_with_ids_async(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedCalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_with_ids_blocking(self, entity_ids: List[str]) -> List[EncryptedCalendarItem]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedCalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_calendar_items_by_recurrence_id_async(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [EncryptedCalendarItem._deserialize(item) for item in success.rows]
						next_key_pair = return_value.next_key_pair
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recurrence_id": recurrence_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_calendar_items_by_recurrence_id_blocking(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
			payload = {
				"recurrence_id": recurrence_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = PaginatedList._deserialize(result_info["success"])
				return_value = PaginatedList(
					rows = [EncryptedCalendarItem._deserialize(item) for item in return_value.rows]
					next_key_pair = return_value.next_key_pair
				)
				return return_value

	class CalendarItemFlavouredApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createCalendarItemFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, calendar_item: CalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"calendar_item": calendar_item.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, calendar_item: CalendarItem, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"calendar_item": calendar_item.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> SimpleShareResult:
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = CalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, calendar_item: CalendarItem, delegates: Dict[str, CalendarItemShareOptions]) -> CalendarItem:
			payload = {
				"calendar_item": calendar_item.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.shareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = CalendarItem._deserialize(result_info["success"])
				return return_value

		async def find_calendar_items_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[CalendarItem](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_calendar_item(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_calendar_items_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[CalendarItem]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.findCalendarItemsByHcPartyPatientBlocking(
				self.native_api,
				json.dumps(payload)
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[CalendarItem](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_calendar_item(x)
				)

		async def link_to_patient_async(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = CalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"calendar_item": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def link_to_patient_blocking(self, calendar_item: CalendarItem, patient: Patient, share_link_with_delegates: List[str]) -> CalendarItem:
			payload = {
				"calendar_item": serialize_calendar_item(calendar_item),
				"patient": serialize_patient(patient),
				"share_link_with_delegates": [x0 for x0 in share_link_with_delegates],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemFlavouredApi.linkToPatientBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = CalendarItem._deserialize(result_info["success"])
				return return_value

		async def modify_calendar_item_async(self, entity: CalendarItem) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = CalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_calendar_item_blocking(self, entity: CalendarItem) -> CalendarItem:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.modifyCalendarItemBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = CalendarItem._deserialize(result_info["success"])
				return return_value

		async def get_calendar_item_async(self, entity_id: str) -> CalendarItem:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = CalendarItem._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_item_blocking(self, entity_id: str) -> CalendarItem:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = CalendarItem._deserialize(result_info["success"])
				return return_value

		async def get_calendar_items_async(self, entity_ids: List[str]) -> List[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [CalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_blocking(self, entity_ids: List[str]) -> List[CalendarItem]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [CalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendar_items_by_period_and_hc_party_id_async(self, start_date: int, end_date: int, hc_party_id: str) -> List[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [CalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_by_period_and_hc_party_id_blocking(self, start_date: int, end_date: int, hc_party_id: str) -> List[CalendarItem]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"hc_party_id": hc_party_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsByPeriodAndHcPartyIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [CalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendars_by_period_and_agenda_id_async(self, start_date: int, end_date: int, agenda_id: str) -> List[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [CalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendars_by_period_and_agenda_id_blocking(self, start_date: int, end_date: int, agenda_id: str) -> List[CalendarItem]:
			payload = {
				"start_date": start_date,
				"end_date": end_date,
				"agenda_id": agenda_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarsByPeriodAndAgendaIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [CalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def get_calendar_items_with_ids_async(self, entity_ids: List[str]) -> List[CalendarItem]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [CalendarItem._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_calendar_items_with_ids_blocking(self, entity_ids: List[str]) -> List[CalendarItem]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.getCalendarItemsWithIdsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [CalendarItem._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def find_calendar_items_by_recurrence_id_async(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [deserialize_calendar_item(item) for item in success.rows]
						next_key_pair = return_value.next_key_pair
					)
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"recurrence_id": recurrence_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def find_calendar_items_by_recurrence_id_blocking(self, recurrence_id: str, start_key: Optional[str], start_document_id: Optional[str], limit: int) -> PaginatedList:
			payload = {
				"recurrence_id": recurrence_id,
				"start_key": start_key,
				"start_document_id": start_document_id,
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.CalendarItemBasicFlavouredApi.findCalendarItemsByRecurrenceIdBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = PaginatedList._deserialize(result_info["success"])
				return_value = PaginatedList(
					rows = [deserialize_calendar_item(item) for item in return_value.rows]
					next_key_pair = return_value.next_key_pair
				)
				return return_value

__all__ = ['CalendarItemApi']