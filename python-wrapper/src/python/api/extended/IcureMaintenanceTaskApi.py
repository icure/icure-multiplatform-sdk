import asyncio
import json
from model.sdk.KeyPairUpdateNotification import KeyPairUpdateNotification
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from model.specializations.SpkiHexString import SpkiHexString
from typing import Optional, List
from model.DataOwnerType import DataOwnerType

class IcureMaintenanceTaskApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def apply_key_pair_update_async(self, update_request: KeyPairUpdateNotification) -> None:
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
			"update_request": update_request.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.applyKeyPairUpdateAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def apply_key_pair_update_blocking(self, update_request: KeyPairUpdateNotification) -> None:
		payload = {
			"update_request": update_request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.applyKeyPairUpdateBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def create_key_pair_update_notifications_to_all_delegation_counterparts_async(self, key: SpkiHexString, request_to_owner_types: Optional[List[DataOwnerType]] = None) -> None:
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
			"key": key,
			"request_to_owner_types": [x0.__serialize__() for x0 in request_to_owner_types] if request_to_owner_types is not None else None,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterpartsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_key_pair_update_notifications_to_all_delegation_counterparts_blocking(self, key: SpkiHexString, request_to_owner_types: Optional[List[DataOwnerType]] = None) -> None:
		payload = {
			"key": key,
			"request_to_owner_types": [x0.__serialize__() for x0 in request_to_owner_types] if request_to_owner_types is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterpartsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def create_key_pair_update_notification_to_async(self, data_owner_id: str, key: SpkiHexString) -> None:
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
			"data_owner_id": data_owner_id,
			"key": key,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationToAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_key_pair_update_notification_to_blocking(self, data_owner_id: str, key: SpkiHexString) -> None:
		payload = {
			"data_owner_id": data_owner_id,
			"key": key,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.IcureMaintenanceTaskApi.createKeyPairUpdateNotificationToBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

__all__ = ['IcureMaintenanceTaskApi']