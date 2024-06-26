import asyncio
import json
from kotlin_types import symbols, GENERAL_RESULT_CALLBACK
from model.Topic import DecryptedTopic, Topic
from model.CallResult import CallResult, create_result_from_json
from ctypes import c_char_p
from typing import Optional, Dict, List
from model.Patient import Patient
from model.User import User
from model.embed.AccessLevel import AccessLevel
from dataclasses import field
from crypto.entities.SecretIdOption import SecretIdOption
from model.specializations.HexString import HexString
from model.couchdb.DocIdentifier import DocIdentifier
from model.filter.AbstractFilter import AbstractFilter
from crypto.entities.ShareMetadataBehaviour import ShareMetadataBehaviour
from model.requests.RequestedPermission import RequestedPermission
from crypto.entities.SimpleShareResult import SimpleShareResult
from crypto.entities.TopicShareOptions import TopicShareOptions
from model.filter.chain.FilterChain import FilterChain
from model.PaginatedList import PaginatedList
from model.TopicRole import TopicRole

class TopicApi:

	def __init__(self, icure_sdk, executor):
		self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createTopicApi()
		self.icure_sdk = icure_sdk
		self.executor = executor
		self.encrypted = TopicFlavouredEncryptedApi(executor)
		self.tryAndRecover = TopicFlavouredApi(executor)

	async def create_topic_async(self, entity: DecryptedTopic) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.createTopicAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_topic_blocking(self, entity: DecryptedTopic) -> DecryptedTopic:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.createTopicBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedTopic], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.withEncryptionMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedTopic], patient: Optional[Patient], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = field(default_factory=dict), secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedTopic:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"patient": serialize_patient(patient) if patient is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.withEncryptionMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def get_encryption_keys_of_async(self, topic: Topic) -> List[HexString]:
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
			"topic": serialize_topic(topic),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.getEncryptionKeysOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, topic: Topic) -> List[HexString]:
		payload = {
			"topic": serialize_topic(topic),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.getEncryptionKeysOfBlocking(
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

	async def has_write_access_async(self, topic: Topic) -> bool:
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
			"topic": serialize_topic(topic),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.hasWriteAccessAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, topic: Topic) -> bool:
		payload = {
			"topic": serialize_topic(topic),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.hasWriteAccessBlocking(
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

	async def decrypt_patient_id_of_async(self, topic: Topic) -> List[str]:
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
			"topic": serialize_topic(topic),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.decryptPatientIdOfAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, topic: Topic) -> List[str]:
		payload = {
			"topic": serialize_topic(topic),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.decryptPatientIdOfBlocking(
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

	async def create_delegation_de_anonymization_metadata_async(self, entity: Topic, delegates: List[str]) -> None:
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
			"entity": serialize_topic(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.createDelegationDeAnonymizationMetadataAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Topic, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_topic(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicApi.createDelegationDeAnonymizationMetadataBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])

	async def delete_topic_async(self, entity_id: str) -> DocIdentifier:
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
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.deleteTopicAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_topic_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.deleteTopicBlocking(
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

	async def delete_topics_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.deleteTopicsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_topics_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.deleteTopicsBlocking(
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

	async def match_topics_by_async(self, filter: AbstractFilter) -> List[str]:
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
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.matchTopicsByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def match_topics_by_blocking(self, filter: AbstractFilter) -> List[str]:
		payload = {
			"filter": serialize_abstract_filter(filter),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavourlessApi.matchTopicsByBlocking(
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

	async def share_with_async(self, delegate_id: str, topic: DecryptedTopic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"topic": topic.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, topic: DecryptedTopic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"topic": topic.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def try_share_with_many_async(self, topic: DecryptedTopic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"topic": topic.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, topic: DecryptedTopic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
		payload = {
			"topic": topic.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = deserialize_simple_share_result(result_info["success"])
			return return_value

	async def share_with_many_async(self, topic: DecryptedTopic, delegates: Dict[str, TopicShareOptions]) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"topic": topic.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, topic: DecryptedTopic, delegates: Dict[str, TopicShareOptions]) -> DecryptedTopic:
		payload = {
			"topic": topic.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def modify_topic_async(self, entity: DecryptedTopic) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_topic_blocking(self, entity: DecryptedTopic) -> DecryptedTopic:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def get_topic_async(self, entity_id: str) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_topic_blocking(self, entity_id: str) -> DecryptedTopic:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def get_topics_async(self, entity_ids: List[str]) -> List[DecryptedTopic]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedTopic._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def get_topics_blocking(self, entity_ids: List[str]) -> List[DecryptedTopic]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DecryptedTopic._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def filter_topics_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = PaginatedList._deserialize(success.decode('utf-8'))
				success = PaginatedList(
					rows = [DecryptedTopic._deserialize(item) for item in success.rows]
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
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def filter_topics_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
		payload = {
			"start_document_id": start_document_id,
			"limit": limit,
			"filter_chain": filter_chain.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByBlocking(
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
				rows = [DecryptedTopic._deserialize(item) for item in return_value.rows]
				next_key_pair = return_value.next_key_pair
			)
			return return_value

	async def add_participant_async(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
			"data_owner_id": data_owner_id,
			"topic_role": topic_role.__serialize__(),
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def add_participant_blocking(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> DecryptedTopic:
		payload = {
			"entity_id": entity_id,
			"data_owner_id": data_owner_id,
			"topic_role": topic_role.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	async def remove_participant_async(self, entity_id: str, data_owner_id: str) -> DecryptedTopic:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedTopic._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
			"data_owner_id": data_owner_id,
		}
		callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantAsync,
			self.native_api,
			json.dumps(payload),
			callback
		)
		return await future

	def remove_participant_blocking(self, entity_id: str, data_owner_id: str) -> DecryptedTopic:
		payload = {
			"entity_id": entity_id,
			"data_owner_id": data_owner_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantBlocking(
			self.native_api,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = DecryptedTopic._deserialize(result_info["success"])
			return return_value

	class TopicFlavouredEncryptedApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createTopicFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, topic: EncryptedTopic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"topic": topic.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, topic: EncryptedTopic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"topic": topic.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, topic: EncryptedTopic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, topic: EncryptedTopic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, topic: EncryptedTopic, delegates: Dict[str, TopicShareOptions]) -> EncryptedTopic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTopic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, topic: EncryptedTopic, delegates: Dict[str, TopicShareOptions]) -> EncryptedTopic:
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedTopic._deserialize(result_info["success"])
				return return_value

		async def modify_topic_async(self, entity: EncryptedTopic) -> EncryptedTopic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTopic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_topic_blocking(self, entity: EncryptedTopic) -> EncryptedTopic:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedTopic._deserialize(result_info["success"])
				return return_value

		async def get_topic_async(self, entity_id: str) -> EncryptedTopic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTopic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_topic_blocking(self, entity_id: str) -> EncryptedTopic:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedTopic._deserialize(result_info["success"])
				return return_value

		async def get_topics_async(self, entity_ids: List[str]) -> List[EncryptedTopic]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [EncryptedTopic._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_topics_blocking(self, entity_ids: List[str]) -> List[EncryptedTopic]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [EncryptedTopic._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_topics_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [EncryptedTopic._deserialize(item) for item in success.rows]
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
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_topics_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"start_document_id": start_document_id,
				"limit": limit,
				"filter_chain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByBlocking(
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
					rows = [EncryptedTopic._deserialize(item) for item in return_value.rows]
					next_key_pair = return_value.next_key_pair
				)
				return return_value

		async def add_participant_async(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> EncryptedTopic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTopic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
				"topic_role": topic_role.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def add_participant_blocking(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> EncryptedTopic:
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
				"topic_role": topic_role.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedTopic._deserialize(result_info["success"])
				return return_value

		async def remove_participant_async(self, entity_id: str, data_owner_id: str) -> EncryptedTopic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedTopic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def remove_participant_blocking(self, entity_id: str, data_owner_id: str) -> EncryptedTopic:
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = EncryptedTopic._deserialize(result_info["success"])
				return return_value

	class TopicFlavouredApi:

		def __init__(self, executor):
			self.native_api = symbols.kotlin.root.com.icure.sdk.py.api.createTopicFlavouredApi()
			self.executor = executor

		async def share_with_async(self, delegate_id: str, topic: Topic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"topic": topic.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, topic: Topic, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"topic": topic.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def try_share_with_many_async(self, topic: Topic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, topic: Topic, delegates: Dict[str, TopicShareOptions]) -> SimpleShareResult:
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.tryShareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = deserialize_simple_share_result(result_info["success"])
				return return_value

		async def share_with_many_async(self, topic: Topic, delegates: Dict[str, TopicShareOptions]) -> Topic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Topic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, topic: Topic, delegates: Dict[str, TopicShareOptions]) -> Topic:
			payload = {
				"topic": topic.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicFlavouredApi.shareWithManyBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Topic._deserialize(result_info["success"])
				return return_value

		async def modify_topic_async(self, entity: Topic) -> Topic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Topic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_topic_blocking(self, entity: Topic) -> Topic:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.modifyTopicBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Topic._deserialize(result_info["success"])
				return return_value

		async def get_topic_async(self, entity_id: str) -> Topic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Topic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_topic_blocking(self, entity_id: str) -> Topic:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Topic._deserialize(result_info["success"])
				return return_value

		async def get_topics_async(self, entity_ids: List[str]) -> List[Topic]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Topic._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def get_topics_blocking(self, entity_ids: List[str]) -> List[Topic]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.getTopicsBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = [Topic._deserialize(x1) for x1 in result_info["success"]]
				return return_value

		async def filter_topics_by_async(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = PaginatedList._deserialize(success.decode('utf-8'))
					success = PaginatedList(
						rows = [deserialize_topic(item) for item in success.rows]
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
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def filter_topics_by_blocking(self, filter_chain: FilterChain, start_document_id: Optional[str] = None, limit: Optional[int] = None) -> PaginatedList:
			payload = {
				"start_document_id": start_document_id,
				"limit": limit,
				"filter_chain": filter_chain.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.filterTopicsByBlocking(
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
					rows = [deserialize_topic(item) for item in return_value.rows]
					next_key_pair = return_value.next_key_pair
				)
				return return_value

		async def add_participant_async(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> Topic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Topic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
				"topic_role": topic_role.__serialize__(),
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def add_participant_blocking(self, entity_id: str, data_owner_id: str, topic_role: TopicRole) -> Topic:
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
				"topic_role": topic_role.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.addParticipantBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Topic._deserialize(result_info["success"])
				return return_value

		async def remove_participant_async(self, entity_id: str, data_owner_id: str) -> Topic:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Topic._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
			}
			callback = GENERAL_RESULT_CALLBACK(make_result_and_complete)
			loop.run_in_executor(
				self.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantAsync,
				self.native_api,
				json.dumps(payload),
				callback
			)
			return await future

		def remove_participant_blocking(self, entity_id: str, data_owner_id: str) -> Topic:
			payload = {
				"entity_id": entity_id,
				"data_owner_id": data_owner_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.TopicBasicFlavouredApi.removeParticipantBlocking(
				self.native_api,
				json.dumps(payload)
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if "failure" in result_info and result_info.get("failure") is not None:
				raise Exception(result_info["failure"])
			else:
				return_value = Topic._deserialize(result_info["success"])
				return return_value

__all__ = ['TopicApi']