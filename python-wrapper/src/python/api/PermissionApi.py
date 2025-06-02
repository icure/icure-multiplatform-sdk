# auto-generated file
import json
from cardinal_sdk.model import Permission
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p


class PermissionApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def modify_user_permissions_async(self, user_id: str, permissions: Permission) -> list[Permission]:
		def do_decode(raw_result):
			return [Permission._deserialize(x1) for x1 in raw_result]
		payload = {
			"userId": user_id,
			"permissions": permissions.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PermissionApi.modifyUserPermissionsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_permissions_blocking(self, user_id: str, permissions: Permission) -> list[Permission]:
		payload = {
			"userId": user_id,
			"permissions": permissions.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.PermissionApi.modifyUserPermissionsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [Permission._deserialize(x1) for x1 in result_info.success]
			return return_value
