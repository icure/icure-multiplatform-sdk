import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.security.Permission import Permission
from model.CallResult import CallResult, create_result_from_json
from typing import List
from ctypes import c_char_p

class PermissionApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createPermissionApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def modify_user_permissions_async(self, user_id: str, permissions: Permission) -> List[Permission]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Permission._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"permissions": permissions.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PermissionApi.modifyUserPermissionsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_user_permissions_blocking(self, user_id: str, permissions: Permission) -> List[Permission]:
		payload = {
			"user_id": user_id,
			"permissions": permissions.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.PermissionApi.modifyUserPermissionsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Permission._deserialize(x1) for x1 in result_info["success"]]
			return return_value

__all__ = ['PermissionApi']