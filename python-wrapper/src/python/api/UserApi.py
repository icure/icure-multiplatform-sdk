# auto-generated file
import json
from cardinal_sdk.model import User, EncryptedPropertyStub, UserGroup, ListOfIds, TokenWithGroup, Enable2faRequest, DocIdentifier, SubscriptionEventType, EntitySubscriptionConfiguration
from cardinal_sdk.async_utils import execute_async_method_job
from cardinal_sdk.kotlin_types import symbols
from cardinal_sdk.model.CallResult import create_result_from_json, interpret_kt_error
from ctypes import cast, c_char_p
from typing import List, Optional
from cardinal_sdk.filters.FilterOptions import BaseFilterOptions, BaseSortableFilterOptions, FilterOptions
from cardinal_sdk.pagination.PaginatedListIterator import PaginatedListIterator
from cardinal_sdk.subscription.EntitySubscription import EntitySubscription


class UserApi:

	def __init__(self, cardinal_sdk):
		self.cardinal_sdk = cardinal_sdk

	async def get_current_user_async(self) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getCurrentUserAsync,
			self.cardinal_sdk._native,
		)

	def get_current_user_blocking(self) -> User:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getCurrentUserBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def create_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_user_async(self, user_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_blocking(self, user_id: str) -> User:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_users_async(self, user_ids: List[str]) -> List[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_users_blocking(self, user_ids: List[str]) -> List[User]:
		payload = {
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_user_by_email_async(self, email: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"email": email,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByEmailAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_by_email_blocking(self, email: str) -> User:
		payload = {
			"email": email,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByEmailBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_user_by_phone_number_async(self, phone_number: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"phoneNumber": phone_number,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByPhoneNumberAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_user_by_phone_number_blocking(self, phone_number: str) -> User:
		payload = {
			"phoneNumber": phone_number,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUserByPhoneNumberBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def find_by_hcparty_id_async(self, id: str) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByHcpartyIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def find_by_hcparty_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByHcpartyIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def find_by_patient_id_async(self, id: str) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"id": id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByPatientIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def find_by_patient_id_blocking(self, id: str) -> List[str]:
		payload = {
			"id": id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.findByPatientIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def modify_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def assign_healthcare_party_async(self, healthcare_party_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.assignHealthcarePartyAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def assign_healthcare_party_blocking(self, healthcare_party_id: str) -> User:
		payload = {
			"healthcarePartyId": healthcare_party_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.assignHealthcarePartyBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_properties_async(self, user_id: str, properties: Optional[List[EncryptedPropertyStub]]) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyPropertiesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_properties_blocking(self, user_id: str, properties: Optional[List[EncryptedPropertyStub]]) -> User:
		payload = {
			"userId": user_id,
			"properties": [x0.__serialize__() for x0 in properties] if properties is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyPropertiesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_token_async(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"key": key,
			"tokenValidity": token_validity,
			"token": token,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_blocking(self, user_id: str, key: str, token_validity: Optional[int] = None, token: Optional[str] = None) -> str:
		payload = {
			"userId": user_id,
			"key": key,
			"tokenValidity": token_validity,
			"token": token,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def filter_users_by_async(self, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_blocking(self, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_async(self, filter: BaseFilterOptions[User]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_blocking(self, filter: BaseFilterOptions[User]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def filter_users_by_sorted_async(self, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_by_sorted_blocking(self, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_by_sorted_async(self, filter: BaseSortableFilterOptions[User]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_by_sorted_blocking(self, filter: BaseSortableFilterOptions[User]) -> List[str]:
		payload = {
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def get_matching_users_async(self) -> List[UserGroup]:
		def do_decode(raw_result):
			return [UserGroup._deserialize(x1) for x1 in raw_result]
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getMatchingUsersAsync,
			self.cardinal_sdk._native,
		)

	def get_matching_users_blocking(self) -> List[UserGroup]:
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getMatchingUsersBlocking(
			self.cardinal_sdk._native,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [UserGroup._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_users_in_group_async(self, group_id: str, user_ids: List[str]) -> List[User]:
		def do_decode(raw_result):
			return [User._deserialize(x1) for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"userIds": [x0 for x0 in user_ids],
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_users_in_group_blocking(self, group_id: str, user_ids: List[str]) -> List[User]:
		payload = {
			"groupId": group_id,
			"userIds": [x0 for x0 in user_ids],
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getUsersInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [User._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def create_user_in_group_async(self, group_id: str, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createUserInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def modify_user_in_group_async(self, group_id: str, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def modify_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.modifyUserInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def set_user_roles_async(self, user_id: str, roles_id: ListOfIds) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"rolesId": roles_id.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_user_roles_blocking(self, user_id: str, roles_id: ListOfIds) -> User:
		payload = {
			"userId": user_id,
			"rolesId": roles_id.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def set_user_roles_in_group_async(self, user_id: str, group_id: str, roles_id: ListOfIds) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"groupId": group_id,
			"rolesId": roles_id.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def set_user_roles_in_group_blocking(self, user_id: str, group_id: str, roles_id: ListOfIds) -> User:
		payload = {
			"userId": user_id,
			"groupId": group_id,
			"rolesId": roles_id.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.setUserRolesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def reset_user_roles_async(self, user_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reset_user_roles_blocking(self, user_id: str) -> User:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def reset_user_roles_in_group_async(self, user_id: str, group_id: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"userId": user_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def reset_user_roles_in_group_blocking(self, user_id: str, group_id: str) -> User:
		payload = {
			"userId": user_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.resetUserRolesInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def get_token_in_group_async(self, group_id: str, user_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_in_group_blocking(self, group_id: str, user_id: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> str:
		payload = {
			"groupId": group_id,
			"userId": user_id,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_token_in_all_groups_async(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> List[TokenWithGroup]:
		def do_decode(raw_result):
			return [TokenWithGroup._deserialize(x1) for x1 in raw_result]
		payload = {
			"userIdentifier": user_identifier,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenInAllGroupsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def get_token_in_all_groups_blocking(self, user_identifier: str, key: str, token: Optional[str] = None, token_validity: Optional[int] = None) -> List[TokenWithGroup]:
		payload = {
			"userIdentifier": user_identifier,
			"key": key,
			"token": token,
			"tokenValidity": token_validity,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.getTokenInAllGroupsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [TokenWithGroup._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def filter_users_in_group_by_async(self, group_id: str, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersInGroupByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_in_group_by_blocking(self, group_id: str, filter: BaseFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersInGroupByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_in_group_by_async(self, group_id: str, filter: BaseFilterOptions[User]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersInGroupByAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_in_group_by_blocking(self, group_id: str, filter: BaseFilterOptions[User]) -> List[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersInGroupByBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def filter_users_in_group_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		def do_decode(raw_result):
			return PaginatedListIterator[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersInGroupBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def filter_users_in_group_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> PaginatedListIterator[User]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.filterUsersInGroupBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)

	async def match_users_in_group_by_sorted_async(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> List[str]:
		def do_decode(raw_result):
			return [x1 for x1 in raw_result]
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersInGroupBySortedAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def match_users_in_group_by_sorted_blocking(self, group_id: str, filter: BaseSortableFilterOptions[User]) -> List[str]:
		payload = {
			"groupId": group_id,
			"filter": filter.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.matchUsersInGroupBySortedBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def enable2fa_for_user_with_group_async(self, user_id: str, group_id: str, request: Enable2faRequest) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"groupId": group_id,
			"request": request.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserWithGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def enable2fa_for_user_with_group_blocking(self, user_id: str, group_id: str, request: Enable2faRequest) -> None:
		payload = {
			"userId": user_id,
			"groupId": group_id,
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserWithGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def enable2fa_for_user_async(self, user_id: str, request: Enable2faRequest) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"request": request.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def enable2fa_for_user_blocking(self, user_id: str, request: Enable2faRequest) -> None:
		payload = {
			"userId": user_id,
			"request": request.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.enable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def disable2fa_for_user_with_group_async(self, user_id: str, group_id: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
			"groupId": group_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserWithGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def disable2fa_for_user_with_group_blocking(self, user_id: str, group_id: str) -> None:
		payload = {
			"userId": user_id,
			"groupId": group_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserWithGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def disable2fa_for_user_async(self, user_id: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"userId": user_id,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def disable2fa_for_user_blocking(self, user_id: str) -> None:
		payload = {
			"userId": user_id,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.disable2faForUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def create_admin_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_admin_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def create_admin_user_in_group_async(self, group_id: str, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def create_admin_user_in_group_blocking(self, group_id: str, user: User) -> User:
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.createAdminUserInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def delete_user_by_id_async(self, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_by_id_blocking(self, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_user_in_group_by_id_async(self, group_id: str, entity_id: str, rev: str) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserInGroupByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_in_group_by_id_blocking(self, group_id: str, entity_id: str, rev: str) -> DocIdentifier:
		payload = {
			"groupId": group_id,
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserInGroupByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def purge_user_by_id_async(self, id: str, rev: str) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_by_id_blocking(self, id: str, rev: str) -> None:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def undelete_user_by_id_async(self, id: str, rev: str) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"id": id,
			"rev": rev,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserByIdAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_by_id_blocking(self, id: str, rev: str) -> User:
		payload = {
			"id": id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserByIdBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def delete_user_async(self, user: User) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_blocking(self, user: User) -> DocIdentifier:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_user_in_group_async(self, group_id: str, user: User) -> DocIdentifier:
		def do_decode(raw_result):
			return DocIdentifier._deserialize(raw_result)
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserInGroupAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def delete_user_in_group_blocking(self, group_id: str, user: User) -> DocIdentifier:
		payload = {
			"groupId": group_id,
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.deleteUserInGroupBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def purge_user_async(self, user: User) -> None:
		def do_decode(raw_result):
			return raw_result
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def purge_user_blocking(self, user: User) -> None:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.purgeUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)

	async def undelete_user_async(self, user: User) -> User:
		def do_decode(raw_result):
			return User._deserialize(raw_result)
		payload = {
			"user": user.__serialize__(),
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			True,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def undelete_user_blocking(self, user: User) -> User:
		payload = {
			"user": user.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.undeleteUserBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise interpret_kt_error(result_info.failure)
		else:
			return_value = User._deserialize(result_info.success)
			return return_value

	async def subscribe_to_events_async(self, events: List[SubscriptionEventType], filter: FilterOptions[User], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[User]:
		def do_decode(raw_result):
			return EntitySubscription[User](
				producer = raw_result,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		return await execute_async_method_job(
			self.cardinal_sdk._executor,
			False,
			do_decode,
			symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.subscribeToEventsAsync,
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)

	def subscribe_to_events_blocking(self, events: List[SubscriptionEventType], filter: FilterOptions[User], subscription_config: Optional[EntitySubscriptionConfiguration] = None) -> EntitySubscription[User]:
		payload = {
			"events": [x0.__serialize__() for x0 in events],
			"filter": filter.__serialize__(),
			"subscriptionConfig": subscription_config.__serialize__() if subscription_config is not None else None,
		}
		call_result = symbols.kotlin.root.com.icure.cardinal.sdk.py.api.UserApi.subscribeToEventsBlocking(
			self.cardinal_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_data_str = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise interpret_kt_error(json.loads(error_data_str))
		else:
			class_pointer = symbols.kotlin.root.com.icure.cardinal.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return EntitySubscription[User](
				producer = class_pointer,
				deserializer = lambda x: User._deserialize(x),
				executor = self.cardinal_sdk._executor
			)
