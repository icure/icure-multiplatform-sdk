import asyncio
import json
from model.CallResult import CallResult, create_result_from_json
from model import User, PaginatedList, DocIdentifier, EncryptedPropertyStub, FilterChain, AbstractFilter, serialize_abstract_filter, UserGroup, ListOfIds, TokenWithGroup, Enable2faRequest
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from ctypes import cast, c_char_p
from typing import Optional, List

class UserApi:

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk

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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getCurrentUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_current_user_blocking(self) -> User:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getCurrentUserBlocking(
			self.icure_sdk.native,
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
					rows = [User._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
			"skip_patients": skip_patients,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersByAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [User._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_blocking(self, user_id: str) -> User:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByEmailAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_by_email_blocking(self, email: str) -> User:
		payload = {
			"email": email,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByEmailBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByPhoneNumberAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_user_by_phone_number_blocking(self, phone_number: str) -> User:
		payload = {
			"phone_number": phone_number,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getUserByPhoneNumberBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByHcpartyIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_by_hcparty_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByHcpartyIdBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByPatientIdAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_by_patient_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.findByPatientIdBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_user_blocking(self, user_id: str) -> DocIdentifier:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.assignHealthcarePartyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def assign_healthcare_party_blocking(self, healthcare_party_id: str) -> User:
		payload = {
			"healthcare_party_id": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.assignHealthcarePartyBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyPropertiesAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
					rows = [User._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersByAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [User._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.matchUsersByAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def match_users_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.matchUsersByBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getMatchingUsersAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_matching_users_blocking(self) -> List[UserGroup]:
		payload = {
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getMatchingUsersBlocking(
			self.icure_sdk.native,
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
					rows = [User._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"start_key": start_key,
			"start_document_id": start_document_id,
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.listUsersInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [User._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.modifyUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.deleteUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.addRolesToUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def remove_roles_from_user_blocking(self, user_id: str) -> User:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.removeRolesFromUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.getTokenInAllGroupsAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
					rows = [User._deserialize(item) for item in success.rows],
					next_key_pair = success.next_key_pair,
				)
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"group_id": group_id,
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.filterUsersInGroupByAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = PaginatedList._deserialize(result_info["success"])
			return_value = PaginatedList(
				rows = [User._deserialize(item) for item in return_value.rows],
				next_key_pair = return_value.next_key_pair,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.enable2faForUserAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def disable2fa_for_user_blocking(self, user_id: str) -> None:
		payload = {
			"user_id": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.disable2faForUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_admin_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserBlocking(
			self.icure_sdk.native,
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.UserApi.createAdminUserInGroupAsync,
			self.icure_sdk.native,
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
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = User._deserialize(result_info["success"])
			return return_value