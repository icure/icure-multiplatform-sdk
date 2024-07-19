import asyncio
import json
from icure.model import ApplicationSettings
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from typing import List
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p

class ApplicationSettingsApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def get_application_settings_async(self) -> List[ApplicationSettings]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [ApplicationSettings._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.getApplicationSettingsAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_application_settings_blocking(self) -> List[ApplicationSettings]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.getApplicationSettingsBlocking(
			self.icure_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [ApplicationSettings._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_application_settings_async(self, application_settings: ApplicationSettings) -> ApplicationSettings:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = ApplicationSettings._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.createApplicationSettingsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_application_settings_blocking(self, application_settings: ApplicationSettings) -> ApplicationSettings:
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.createApplicationSettingsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = ApplicationSettings._deserialize(result_info.success)
			return return_value

	async def update_application_settings_async(self, application_settings: ApplicationSettings) -> ApplicationSettings:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = ApplicationSettings._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.updateApplicationSettingsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def update_application_settings_blocking(self, application_settings: ApplicationSettings) -> ApplicationSettings:
		payload = {
			"applicationSettings": application_settings.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.ApplicationSettingsApi.updateApplicationSettingsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = ApplicationSettings._deserialize(result_info.success)
			return return_value
