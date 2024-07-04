import asyncio
from icure.model import Role
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from typing import List
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p

class RoleApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

	async def get_all_roles_async(self) -> List[Role]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [Role._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RoleApi.getAllRolesAsync,
			self.icure_sdk._native,
			callback
		)
		return await future

	def get_all_roles_blocking(self) -> List[Role]:
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RoleApi.getAllRolesBlocking(
			self.icure_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [Role._deserialize(x1) for x1 in result_info.success]
			return return_value
