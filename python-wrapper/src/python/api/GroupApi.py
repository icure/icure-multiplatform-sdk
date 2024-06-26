import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from typing import List, Optional, Dict
from model.Group import Group
from ctypes import c_char_p
from model.DatabaseInitialisation import DatabaseInitialisation
from model.embed.GroupType import GroupType
from model.RegistrationInformation import RegistrationInformation
from model.security.PermissionType import PermissionType
from model.RegistrationSuccess import RegistrationSuccess
from model.PaginatedList import PaginatedList
from model.security.Operation import Operation
from model.embed.UserType import UserType
from model.embed.RoleConfiguration import RoleConfiguration
from model.GroupDeletionReport import GroupDeletionReport
from model.ListOfProperties import ListOfProperties
from model.couchdb.DesignDocument import DesignDocument
from model.IdWithRev import IdWithRev
from model.couchdb.GroupDatabasesInfo import GroupDatabasesInfo
from model.ReplicationInfo import ReplicationInfo
from model.couchdb.DocIdentifier import DocIdentifier

class GroupApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createGroupApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def list_groups_async(self) -> List[Group]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Group._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listGroupsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_groups_blocking(self) -> List[Group]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listGroupsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Group._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_group_async(self, id: str) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_group_blocking(self, id: str) -> Group:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def create_group_async(self, id: str, name: str, password: str, initialisation_data: DatabaseInitialisation, type: Optional[GroupType] = None, server: Optional[str] = None, q: Optional[int] = None, n: Optional[int] = None, super_group: Optional[str] = None) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"name": name,
			"type": type.__serialize__() if type is not None else None,
			"password": password,
			"server": server,
			"q": q,
			"n": n,
			"super_group": super_group,
			"initialisation_data": initialisation_data.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.createGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_group_blocking(self, id: str, name: str, password: str, initialisation_data: DatabaseInitialisation, type: Optional[GroupType] = None, server: Optional[str] = None, q: Optional[int] = None, n: Optional[int] = None, super_group: Optional[str] = None) -> Group:
		payload = {
			"id": id,
			"name": name,
			"type": type.__serialize__() if type is not None else None,
			"password": password,
			"server": server,
			"q": q,
			"n": n,
			"super_group": super_group,
			"initialisation_data": initialisation_data.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.createGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def register_new_group_administrator_async(self, registration_information: RegistrationInformation, type: Optional[GroupType] = None, role: Optional[PermissionType] = None) -> RegistrationSuccess:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = RegistrationSuccess._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"type": type.__serialize__() if type is not None else None,
			"role": role.__serialize__() if role is not None else None,
			"registration_information": registration_information.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.registerNewGroupAdministratorAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def register_new_group_administrator_blocking(self, registration_information: RegistrationInformation, type: Optional[GroupType] = None, role: Optional[PermissionType] = None) -> RegistrationSuccess:
		payload = {
			"type": type.__serialize__() if type is not None else None,
			"role": role.__serialize__() if role is not None else None,
			"registration_information": registration_information.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.registerNewGroupAdministratorBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = RegistrationSuccess._deserialize(result_info["success"])
			return return_value

	async def list_apps_async(self) -> List[Group]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [Group._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listAppsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_apps_blocking(self) -> List[Group]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listAppsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [Group._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_groups_async(self, id: str, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Group._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.findGroupsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_groups_blocking(self, id: str, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"id": id,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.findGroupsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Group._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def find_groups_with_content_async(self, id: str, search_string: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [Group._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"search_string": search_string,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.findGroupsWithContentAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_groups_with_content_blocking(self, id: str, search_string: str, start_key: Optional[Dict[str, object]] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"id": id,
			"search_string": search_string,
			"start_key": {k0: v0 for k0, v0 in start_key.items()} if start_key is not None else None,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.findGroupsWithContentBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [Group._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def get_name_of_group_parent_async(self, id: str) -> str:
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
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getNameOfGroupParentAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_name_of_group_parent_blocking(self, id: str) -> str:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getNameOfGroupParentBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def modify_group_name_async(self, id: str, name: str) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"name": name,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.modifyGroupNameAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_group_name_blocking(self, id: str, name: str) -> Group:
		payload = {
			"id": id,
			"name": name,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.modifyGroupNameBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def get_operation_token_async(self, operation: Operation, duration: Optional[int], description: Optional[str] = None) -> str:
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
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getOperationTokenAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_operation_token_blocking(self, operation: Operation, duration: Optional[int], description: Optional[str] = None) -> str:
		payload = {
			"operation": operation.__serialize__(),
			"duration": duration,
			"description": description,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getOperationTokenBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = result_info["success"]
			return return_value

	async def delete_operation_token_async(self, token_id: str) -> None:
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
			"token_id": token_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.deleteOperationTokenAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_operation_token_blocking(self, token_id: str) -> None:
		payload = {
			"token_id": token_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.deleteOperationTokenBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def set_default_roles_async(self, group_id: str, user_type: str, role_ids: List[str]) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"user_type": user_type,
			"role_ids": [x0 for x0 in role_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.setDefaultRolesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def set_default_roles_blocking(self, group_id: str, user_type: str, role_ids: List[str]) -> Group:
		payload = {
			"group_id": group_id,
			"user_type": user_type,
			"role_ids": [x0 for x0 in role_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.setDefaultRolesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def get_default_roles_async(self, group_id: str) -> Dict[UserType, List[RoleConfiguration]]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = dict(map(lambda kv1: (UserType._deserialize(kv1[0]), [RoleConfiguration._deserialize(x2) for x2 in kv1[1]]), success.decode('utf-8').items()))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getDefaultRolesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_default_roles_blocking(self, group_id: str) -> Dict[UserType, List[RoleConfiguration]]:
		payload = {
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getDefaultRolesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = dict(map(lambda kv1: (UserType._deserialize(kv1[0]), [RoleConfiguration._deserialize(x2) for x2 in kv1[1]]), result_info["success"].items()))
			return return_value

	async def delete_group_async(self, id: str) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.deleteGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_group_blocking(self, id: str) -> Group:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.deleteGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def change_super_group_async(self, child_group_id: str, operation_token: str) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"child_group_id": child_group_id,
			"operation_token": operation_token,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.changeSuperGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def change_super_group_blocking(self, child_group_id: str, operation_token: str) -> Group:
		payload = {
			"child_group_id": child_group_id,
			"operation_token": operation_token,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.changeSuperGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def hard_delete_group_async(self, id: str) -> List[GroupDeletionReport]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [GroupDeletionReport._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.hardDeleteGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def hard_delete_group_blocking(self, id: str) -> List[GroupDeletionReport]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.hardDeleteGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [GroupDeletionReport._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_group_properties_async(self, id: str, properties: ListOfProperties) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"properties": properties.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.modifyGroupPropertiesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_group_properties_blocking(self, id: str, properties: ListOfProperties) -> Group:
		payload = {
			"id": id,
			"properties": properties.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.modifyGroupPropertiesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def set_group_password_async(self, id: str, password: str) -> Group:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = Group._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"password": password,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.setGroupPasswordAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def set_group_password_blocking(self, id: str, password: str) -> Group:
		payload = {
			"id": id,
			"password": password,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.setGroupPasswordBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = Group._deserialize(result_info["success"])
			return return_value

	async def init_design_docs_async(self, id: str, warmup: Optional[bool], dry_run: Optional[bool], clazz: Optional[str] = None) -> List[DesignDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DesignDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"clazz": clazz,
			"warmup": warmup,
			"dry_run": dry_run,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.initDesignDocsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def init_design_docs_blocking(self, id: str, warmup: Optional[bool], dry_run: Optional[bool], clazz: Optional[str] = None) -> List[DesignDocument]:
		payload = {
			"id": id,
			"clazz": clazz,
			"warmup": warmup,
			"dry_run": dry_run,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.initDesignDocsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DesignDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def solve_conflicts_async(self, id: str, limit: Optional[int], warmup: Optional[bool]) -> List[IdWithRev]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [IdWithRev._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
			"limit": limit,
			"warmup": warmup,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.solveConflictsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def solve_conflicts_blocking(self, id: str, limit: Optional[int], warmup: Optional[bool]) -> List[IdWithRev]:
		payload = {
			"id": id,
			"limit": limit,
			"warmup": warmup,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.solveConflictsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [IdWithRev._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def reset_storage_async(self, id: str, databases: List[str], q: Optional[int] = None, n: Optional[int] = None) -> None:
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
			"id": id,
			"q": q,
			"n": n,
			"databases": [x0 for x0 in databases],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.resetStorageAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def reset_storage_blocking(self, id: str, databases: List[str], q: Optional[int] = None, n: Optional[int] = None) -> None:
		payload = {
			"id": id,
			"q": q,
			"n": n,
			"databases": [x0 for x0 in databases],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.resetStorageBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def get_groups_storage_infos_async(self, groups: List[str]) -> List[GroupDatabasesInfo]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [GroupDatabasesInfo._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"groups": [x0 for x0 in groups],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getGroupsStorageInfosAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_groups_storage_infos_blocking(self, groups: List[str]) -> List[GroupDatabasesInfo]:
		payload = {
			"groups": [x0 for x0 in groups],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getGroupsStorageInfosBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [GroupDatabasesInfo._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_replication_info_async(self, id: str) -> ReplicationInfo:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = ReplicationInfo._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getReplicationInfoAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_replication_info_blocking(self, id: str) -> ReplicationInfo:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getReplicationInfoBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = ReplicationInfo._deserialize(result_info["success"])
			return return_value

	async def get_hierarchy_async(self, id: str) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"id": id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getHierarchyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_hierarchy_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.getHierarchyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [x1 for x1 in result_info["success"]]
			return return_value

	async def list_all_groups_ids_async(self) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DocIdentifier._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listAllGroupsIdsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_all_groups_ids_blocking(self) -> List[DocIdentifier]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.GroupApi.listAllGroupsIdsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

__all__ = ['GroupApi']