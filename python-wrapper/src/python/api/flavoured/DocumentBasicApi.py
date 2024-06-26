import asyncio
import json
import base64
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols
from model.couchdb.DocIdentifier import DocIdentifier
from ctypes import cast, c_char_p
from typing import List, Dict, Optional
from model.Document import EncryptedDocument

class DocumentBasicApi:

	def __init__(self, icure_sdk, executor):
		self.icure_sdk = icure_sdk
		self.executor = executor

	async def delete_document_async(self, entity_id: str) -> DocIdentifier:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.deleteDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_document_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.deleteDocumentBlocking(
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

	async def delete_documents_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
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
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.deleteDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_documents_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.deleteDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_raw_main_attachment_async(self, document_id: str, attachment_id: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = bytearray(base64.b64decode(success.decode('utf-8')))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getRawMainAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_raw_main_attachment_blocking(self, document_id: str, attachment_id: str) -> bytearray:
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getRawMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = bytearray(base64.b64decode(result_info["success"]))
			return return_value

	async def get_main_attachment_as_plain_text_async(self, document_id: str, attachment_id: str) -> str:
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
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getMainAttachmentAsPlainTextAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_main_attachment_as_plain_text_blocking(self, document_id: str, attachment_id: str) -> str:
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getMainAttachmentAsPlainTextBlocking(
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

	async def get_main_attachment_as_json_async(self, document_id: str, attachment_id: str) -> Dict[str, object]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = dict(map(lambda kv1: (kv1[0], kv1[1]), success.decode('utf-8').items()))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getMainAttachmentAsJsonAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_main_attachment_as_json_blocking(self, document_id: str, attachment_id: str) -> Dict[str, object]:
		payload = {
			"document_id": document_id,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getMainAttachmentAsJsonBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info["success"].items()))
			return return_value

	async def get_raw_secondary_attachment_async(self, document_id: str, key: str, attachment_id: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = bytearray(base64.b64decode(success.decode('utf-8')))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getRawSecondaryAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_raw_secondary_attachment_blocking(self, document_id: str, key: str, attachment_id: str) -> bytearray:
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavourlessApi.getRawSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = bytearray(base64.b64decode(result_info["success"]))
			return return_value

	async def modify_document_async(self, entity: EncryptedDocument) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.modifyDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_document_blocking(self, entity: EncryptedDocument) -> EncryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.modifyDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def get_document_async(self, entity_id: str) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_blocking(self, entity_id: str) -> EncryptedDocument:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def get_document_by_external_uuid_async(self, external_uuid: str) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_uuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentByExternalUuidAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_by_external_uuid_blocking(self, external_uuid: str) -> EncryptedDocument:
		payload = {
			"external_uuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentByExternalUuidBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def get_documents_by_external_uuid_async(self, external_uuid: str) -> List[EncryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_uuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentsByExternalUuidAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[EncryptedDocument]:
		payload = {
			"external_uuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentsByExternalUuidBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def get_documents_async(self, entity_ids: List[str]) -> List[EncryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_documents_blocking(self, entity_ids: List[str]) -> List[EncryptedDocument]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.getDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def modify_documents_async(self, entities: List[EncryptedDocument]) -> List[EncryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.modifyDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_documents_blocking(self, entities: List[EncryptedDocument]) -> List[EncryptedDocument]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.modifyDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def list_documents_by_hc_party_message_foreign_keys_async(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[EncryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"document_type_code": document_type_code,
			"secret_message_keys": [x0 for x0 in secret_message_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[EncryptedDocument]:
		payload = {
			"hc_party_id": hc_party_id,
			"document_type_code": document_type_code,
			"secret_message_keys": [x0 for x0 in secret_message_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def find_without_delegation_async(self, limit: Optional[int]) -> List[EncryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [EncryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.findWithoutDelegationAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_without_delegation_blocking(self, limit: Optional[int]) -> List[EncryptedDocument]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.findWithoutDelegationBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info["success"]]
			return return_value

	async def set_raw_main_attachment_async(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blob_type": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.setRawMainAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def set_raw_main_attachment_blocking(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"document_id": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blob_type": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.setRawMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def set_raw_secondary_attachment_async(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blob_type": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.setRawSecondaryAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def set_raw_secondary_attachment_blocking(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"document_id": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blob_type": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.setRawSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def delete_main_attachment_async(self, entity_id: str, rev: str) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.deleteMainAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> EncryptedDocument:
		payload = {
			"entity_id": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.deleteMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

	async def delete_secondary_attachment_async(self, document_id: str, key: str, attachment_id: str) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = EncryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.deleteSecondaryAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_secondary_attachment_blocking(self, document_id: str, key: str, attachment_id: str) -> EncryptedDocument:
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.DocumentBasicFlavouredApi.deleteSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload)
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if "failure" in result_info and result_info.get("failure") is not None:
			raise Exception(result_info["failure"])
		else:
			return_value = EncryptedDocument._deserialize(result_info["success"])
			return return_value

__all__ = ['DocumentBasicApi']