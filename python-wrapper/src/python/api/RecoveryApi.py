import asyncio
import json
from typing import Optional
from model.CallResult import CallResult, create_result_from_json
from crypto.entities.RecoveryDataKey import RecoveryDataKey
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from crypto.entities.RecoveryResult import deserialize_recovery_result, RecoveryResult
from crypto.entities.RecoveryDataUseFailureReason import RecoveryDataUseFailureReason

class RecoveryApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def create_recovery_info_for_available_key_pairs_async(self, include_parents_keys: bool = False, lifetime_seconds: Optional[int] = None) -> RecoveryDataKey:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = RecoveryDataKey._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"include_parents_keys": include_parents_keys,
			"lifetime_seconds": lifetime_seconds,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.createRecoveryInfoForAvailableKeyPairsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_recovery_info_for_available_key_pairs_blocking(self, include_parents_keys: bool = False, lifetime_seconds: Optional[int] = None) -> RecoveryDataKey:
		payload = {
			"include_parents_keys": include_parents_keys,
			"lifetime_seconds": lifetime_seconds,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.createRecoveryInfoForAvailableKeyPairsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = RecoveryDataKey._deserialize(result_info["success"])
			return return_value

	async def recover_key_pairs_async(self, recovery_key: RecoveryDataKey, auto_delete: bool) -> RecoveryResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_recovery_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"recovery_key": recovery_key.__serialize__(),
			"auto_delete": auto_delete,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.recoverKeyPairsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def recover_key_pairs_blocking(self, recovery_key: RecoveryDataKey, auto_delete: bool) -> RecoveryResult:
		payload = {
			"recovery_key": recovery_key.__serialize__(),
			"auto_delete": auto_delete,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.recoverKeyPairsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_recovery_result(result_info["success"])
			return return_value

	async def create_exchange_data_recovery_info_async(self, delegate_id: str, lifetime_seconds: Optional[int] = None) -> RecoveryDataKey:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = RecoveryDataKey._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"lifetime_seconds": lifetime_seconds,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.createExchangeDataRecoveryInfoAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_exchange_data_recovery_info_blocking(self, delegate_id: str, lifetime_seconds: Optional[int] = None) -> RecoveryDataKey:
		payload = {
			"delegate_id": delegate_id,
			"lifetime_seconds": lifetime_seconds,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.createExchangeDataRecoveryInfoBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = RecoveryDataKey._deserialize(result_info["success"])
			return return_value

	async def recover_exchange_data_async(self, recovery_key: RecoveryDataKey) -> Optional[RecoveryDataUseFailureReason]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = RecoveryDataUseFailureReason._deserialize(success.decode('utf-8')) if success.decode('utf-8') is not None else None
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"recovery_key": recovery_key.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.recoverExchangeDataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def recover_exchange_data_blocking(self, recovery_key: RecoveryDataKey) -> Optional[RecoveryDataUseFailureReason]:
		payload = {
			"recovery_key": recovery_key.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.recoverExchangeDataBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = RecoveryDataUseFailureReason._deserialize(result_info["success"]) if result_info["success"] is not None else None
			return return_value

	async def delete_recovery_info_async(self, recovery_key: RecoveryDataKey) -> None:
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
			"recovery_key": recovery_key.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteRecoveryInfoAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_recovery_info_blocking(self, recovery_key: RecoveryDataKey) -> None:
		payload = {
			"recovery_key": recovery_key.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteRecoveryInfoBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def delete_all_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllRecoveryInfoForAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_all_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"data_owner_id": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllRecoveryInfoForBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def delete_all_key_pair_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllKeyPairRecoveryInfoForAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_all_key_pair_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"data_owner_id": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllKeyPairRecoveryInfoForBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def delete_all_exchange_data_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllExchangeDataRecoveryInfoForAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_all_exchange_data_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"data_owner_id": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RecoveryApi.deleteAllExchangeDataRecoveryInfoForBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

__all__ = ['RecoveryApi']