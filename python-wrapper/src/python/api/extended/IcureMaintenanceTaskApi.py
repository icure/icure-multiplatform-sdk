import asyncio
import json
from icure.model import KeyPairUpdateNotification, DataOwnerType
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from icure.model.specializations import SpkiHexString
from typing import Optional, List

class IcureMaintenanceTaskApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def apply_key_pair_update_async(self, update_request: KeyPairUpdateNotification) -> None:
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
			"updateRequest": update_request.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.applyKeyPairUpdateAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def apply_key_pair_update_blocking(self, update_request: KeyPairUpdateNotification) -> None:
		payload = {
			"updateRequest": update_request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.applyKeyPairUpdateBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def create_key_pair_update_notifications_to_all_delegation_counterparts_async(self, key: SpkiHexString, request_to_owner_types: Optional[List[DataOwnerType]] = None) -> None:
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
			"key": key,
			"requestToOwnerTypes": [x0.__serialize__() for x0 in request_to_owner_types] if request_to_owner_types is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterpartsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_key_pair_update_notifications_to_all_delegation_counterparts_blocking(self, key: SpkiHexString, request_to_owner_types: Optional[List[DataOwnerType]] = None) -> None:
		payload = {
			"key": key,
			"requestToOwnerTypes": [x0.__serialize__() for x0 in request_to_owner_types] if request_to_owner_types is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterpartsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def create_key_pair_update_notification_to_async(self, data_owner_id: str, key: SpkiHexString) -> None:
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
			"dataOwnerId": data_owner_id,
			"key": key,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationToAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_key_pair_update_notification_to_blocking(self, data_owner_id: str, key: SpkiHexString) -> None:
		payload = {
			"dataOwnerId": data_owner_id,
			"key": key,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationToBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
