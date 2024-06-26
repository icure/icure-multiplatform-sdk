import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from typing import List
from model.Role import Role
from ctypes import c_char_p

class RoleApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createRoleApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_all_roles_async(self) -> List[Role]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Role._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.RoleApi.getAllRolesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_all_roles_blocking(self) -> List[Role]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.RoleApi.getAllRolesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Role._deserialize(x1) for x1 in result_info["success"]]
			return return_value

__all__ = ['RoleApi']