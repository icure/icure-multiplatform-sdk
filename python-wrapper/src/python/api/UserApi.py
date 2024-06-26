import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.CallResult import CallResult, create_result_from_json
from model.User import User
from ctypes import c_char_p
from typing import Optional, List
from model.PaginatedList import PaginatedList
from model.couchdb.DocIdentifier import DocIdentifier
from model.PropertyStub import EncryptedPropertyStub
from model.filter.chain.FilterChain import FilterChain
from model.filter.AbstractFilter import AbstractFilter
from model.UserGroup import UserGroup
from model.ListOfIds import ListOfIds
from model.security.TokenWithGroup import TokenWithGroup
from model.security.Enable2faRequest import Enable2faRequest

class UserApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createUserApi()
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def get_current_user_async(self) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getCurrentUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_user_blocking(self) -> User:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getCurrentUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def list_users_by_async(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip_patients: Optional[bool] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [User._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip_patients": skip_patients,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_users_by_blocking(self, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None, skip_patients: Optional[bool] = None) -> PaginatedList:
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip_patients": skip_patients,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersByBlocking(
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
				rows = [User._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def create_user_async(self, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def get_user_async(self, user_id: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_blocking(self, user_id: str) -> User:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def get_user_by_email_async(self, email: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"email": email,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByEmailAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_by_email_blocking(self, email: str) -> User:
		payload = {
			"email": email,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByEmailBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def get_user_by_phone_number_async(self, phone_number: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"phone_number": phone_number,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByPhoneNumberAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_by_phone_number_blocking(self, phone_number: str) -> User:
		payload = {
			"phone_number": phone_number,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByPhoneNumberBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def find_by_hcparty_id_async(self, id: str) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByHcpartyIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_by_hcparty_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByHcpartyIdBlocking(
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

	async def find_by_patient_id_async(self, id: str) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByPatientIdAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def find_by_patient_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByPatientIdBlocking(
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

	async def delete_user_async(self, user_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocIdentifier._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_user_blocking(self, user_id: str) -> DocIdentifier:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def modify_user_async(self, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def assign_healthcare_party_async(self, healthcare_party_id: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"healthcare_party_id": healthcare_party_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.assignHealthcarePartyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def assign_healthcare_party_blocking(self, healthcare_party_id: str) -> User:
		payload = {
			"healthcare_party_id": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.assignHealthcarePartyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def modify_properties_async(self, user_id: str, properties: Optional[List[EncryptedPropertyStub]]) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyPropertiesAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_properties_blocking(self, user_id: str, properties: Optional[List[EncryptedPropertyStub]]) -> User:
		payload = {
			"user_id": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyPropertiesBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def get_token_async(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
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
			"user_id": user_id,
			"key": key,
			"token_validity": token_validity,
			"token": token,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_token_blocking(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
		payload = {
			"user_id": user_id,
			"key": key,
			"token_validity": token_validity,
			"token": token,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenBlocking(
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

	async def filter_users_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [User._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_users_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersByBlocking(
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
				rows = [User._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def match_users_by_async(self, filter: AbstractFilter) -> List[str]:
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
			"filter": serialize_abstract_filter(filter),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.matchUsersByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def match_users_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.matchUsersByBlocking(
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

	async def get_matching_users_async(self) -> List[UserGroup]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [UserGroup._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getMatchingUsersAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_matching_users_blocking(self) -> List[UserGroup]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getMatchingUsersBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [UserGroup._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_users_in_group_async(self, group_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [User._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def list_users_in_group_blocking(self, group_id: str, start_key: Optional[str] = None, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"group_id": group_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersInGroupBlocking(
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
				rows = [User._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def create_user_in_group_async(self, group_id: str, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def modify_user_in_group_async(self, group_id: str, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def delete_user_in_group_async(self, group_id: str, user_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DocIdentifier._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"user_id": user_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_user_in_group_blocking(self, group_id: str, user_id: str) -> DocIdentifier:
		payload = {
			"group_id": group_id,
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DocIdentifier._deserialize(result_info["success"])
			return return_value

	async def add_roles_to_user_async(self, user_id: str, roles_id: ListOfIds) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"roles_id": roles_id.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def add_roles_to_user_blocking(self, user_id: str, roles_id: ListOfIds) -> User:
		payload = {
			"user_id": user_id,
			"roles_id": roles_id.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def add_roles_to_user_in_group_async(self, user_id: str, group_id: str, roles_id: ListOfIds) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"group_id": group_id,
			"roles_id": roles_id.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def add_roles_to_user_in_group_blocking(self, user_id: str, group_id: str, roles_id: ListOfIds) -> User:
		payload = {
			"user_id": user_id,
			"group_id": group_id,
			"roles_id": roles_id.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def remove_roles_from_user_async(self, user_id: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def remove_roles_from_user_blocking(self, user_id: str) -> User:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def remove_roles_from_user_in_group_async(self, user_id: str, group_id: str) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_id": user_id,
			"group_id": group_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def remove_roles_from_user_in_group_blocking(self, user_id: str, group_id: str) -> User:
		payload = {
			"user_id": user_id,
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def get_token_in_group_async(self, group_id: str, user_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
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
			"group_id": group_id,
			"user_id": user_id,
			"key": key,
			"token": token,
			"token_validity": token_validity,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_token_in_group_blocking(self, group_id: str, user_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
		payload = {
			"group_id": group_id,
			"user_id": user_id,
			"key": key,
			"token": token,
			"token_validity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInGroupBlocking(
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

	async def get_token_in_all_groups_async(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> List[TokenWithGroup]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [TokenWithGroup._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user_identifier": user_identifier,
			"key": key,
			"token": token,
			"token_validity": token_validity,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInAllGroupsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_token_in_all_groups_blocking(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> List[TokenWithGroup]:
		payload = {
			"user_identifier": user_identifier,
			"key": key,
			"token": token,
			"token_validity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInAllGroupsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [TokenWithGroup._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_users_in_group_by_async(self, group_id: str, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [User._deserialize(item) for item in success.rows]
					next_key_pair = return_value.next_key_pair
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersInGroupByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_users_in_group_by_blocking(self, group_id: str, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"group_id": group_id,
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersInGroupByBlocking(
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
				rows = [User._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def enable2fa_for_user_async(self, user_id: str, group_id: str, request: Enable2faRequest) -> None:
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
			"user_id": user_id,
			"group_id": group_id,
			"request": request.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def enable2fa_for_user_blocking(self, user_id: str, group_id: str, request: Enable2faRequest) -> None:
		payload = {
			"user_id": user_id,
			"group_id": group_id,
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def enable2fa_for_user_async(self, user_id: str, request: Enable2faRequest) -> None:
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
			"user_id": user_id,
			"request": request.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def enable2fa_for_user_blocking(self, user_id: str, request: Enable2faRequest) -> None:
		payload = {
			"user_id": user_id,
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def disable2fa_for_user_async(self, user_id: str, group_id: str) -> None:
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
			"user_id": user_id,
			"group_id": group_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def disable2fa_for_user_blocking(self, user_id: str, group_id: str) -> None:
		payload = {
			"user_id": user_id,
			"group_id": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def disable2fa_for_user_async(self, user_id: str) -> None:
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
			"user_id": user_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def disable2fa_for_user_blocking(self, user_id: str) -> None:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def create_admin_user_async(self, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_admin_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

	async def create_admin_user_in_group_async(self, group_id: str, user: User) -> User:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = User._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserInGroupAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_admin_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"group_id": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserInGroupBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value

__all__ = ['UserApi']