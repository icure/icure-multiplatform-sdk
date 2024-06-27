import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p

class CryptoApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def force_reload_async(self) -> None:
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
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.CryptoApi.forceReloadAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def force_reload_blocking(self) -> None:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.CryptoApi.forceReloadBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
