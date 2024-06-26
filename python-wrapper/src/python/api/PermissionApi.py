import asyncio
import json
from model.security.Permission import Permission
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from typing import List
from ctypes import cast, c_char_p

class PermissionApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.PermissionApi.modifyUserPermissionsAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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