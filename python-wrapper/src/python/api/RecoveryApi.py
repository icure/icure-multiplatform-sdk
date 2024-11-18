# auto-generated file
import asyncio
import json
from cardinal_sdk.model import RecoveryDataKey
from cardinal_sdk.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class RecoveryApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def purge_recovery_info_async(self, recovery_key: RecoveryDataKey) -> None:
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
			"recoveryKey": recovery_key.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeRecoveryInfoAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_recovery_info_blocking(self, recovery_key: RecoveryDataKey) -> None:
		payload = {
			"recoveryKey": recovery_key.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeRecoveryInfoBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def purge_all_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_all_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllRecoveryInfoForBlocking(
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

	async def purge_all_key_pair_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllKeyPairRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_all_key_pair_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllKeyPairRecoveryInfoForBlocking(
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

	async def purge_all_exchange_data_recovery_info_for_async(self, data_owner_id: str) -> int:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.cardinal_sdk._executor,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllExchangeDataRecoveryInfoForAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def purge_all_exchange_data_recovery_info_for_blocking(self, data_owner_id: str) -> int:
		payload = {
			"dataOwnerId": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.RecoveryApi.purgeAllExchangeDataRecoveryInfoForBlocking(
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
