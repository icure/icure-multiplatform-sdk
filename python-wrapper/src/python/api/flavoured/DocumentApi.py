import asyncio
import json
import base64
import traceback
from icure.model import DecryptedDocument, Message, User, AccessLevel, SecretIdOption, SecretIdOptionUseAnySharedWithParent, serialize_message, serialize_secret_id_option, Document, serialize_document, EncryptedDocument, deserialize_document, DocIdentifier, ShareMetadataBehaviour, RequestedPermission, deserialize_simple_share_result, SimpleShareResult, DocumentShareOptions, Patient, serialize_patient
from icure.kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, CALLBACK_PARAM_DATA_INPUT, PTR_RESULT_CALLBACK_FUNC
from icure.model.CallResult import create_result_from_json
from ctypes import cast, c_char_p
from typing import Optional, Dict, List
from collections.abc import Callable
from icure.model.specializations import HexString
from icure.pagination.PaginatedListIterator import PaginatedListIterator

class DocumentApi:

	class DocumentFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, document: EncryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"document": document.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, document: EncryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"document": document.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> EncryptedDocument:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def find_documents_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[EncryptedDocument](
						producer = success,
						deserializer = lambda x: EncryptedDocument._deserialize(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.findDocumentsByHcPartyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedDocument]:
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.findDocumentsByHcPartyPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise Exception(error_msg)
			else:
				class_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[EncryptedDocument](
					producer = class_pointer,
					deserializer = lambda x: EncryptedDocument._deserialize(x),
					executor = self.icure_sdk._executor
				)

		async def modify_document_async(self, entity: EncryptedDocument) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.modifyDocumentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_document_blocking(self, entity: EncryptedDocument) -> EncryptedDocument:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.modifyDocumentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def get_document_async(self, entity_id: str) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_document_blocking(self, entity_id: str) -> EncryptedDocument:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def get_document_by_external_uuid_async(self, external_uuid: str) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalUuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentByExternalUuidAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_document_by_external_uuid_blocking(self, external_uuid: str) -> EncryptedDocument:
			payload = {
				"externalUuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentByExternalUuidBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def get_documents_by_external_uuid_async(self, external_uuid: str) -> List[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalUuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentsByExternalUuidAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[EncryptedDocument]:
			payload = {
				"externalUuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentsByExternalUuidBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_documents_async(self, entity_ids: List[str]) -> List[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_documents_blocking(self, entity_ids: List[str]) -> List[EncryptedDocument]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.getDocumentsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def modify_documents_async(self, entities: List[EncryptedDocument]) -> List[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.modifyDocumentsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_documents_blocking(self, entities: List[EncryptedDocument]) -> List[EncryptedDocument]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.modifyDocumentsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_documents_by_hc_party_message_foreign_keys_async(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"documentTypeCode": document_type_code,
				"secretMessageKeys": [x0 for x0 in secret_message_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.listDocumentsByHcPartyMessageForeignKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[EncryptedDocument]:
			payload = {
				"hcPartyId": hc_party_id,
				"documentTypeCode": document_type_code,
				"secretMessageKeys": [x0 for x0 in secret_message_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.listDocumentsByHcPartyMessageForeignKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def find_without_delegation_async(self, limit: Optional[int]) -> List[EncryptedDocument]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [EncryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.findWithoutDelegationAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_without_delegation_blocking(self, limit: Optional[int]) -> List[EncryptedDocument]:
			payload = {
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.findWithoutDelegationBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [EncryptedDocument._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def set_raw_main_attachment_async(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.setRawMainAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_raw_main_attachment_blocking(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			payload = {
				"documentId": document_id,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.setRawMainAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def set_raw_secondary_attachment_async(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.setRawSecondaryAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_raw_secondary_attachment_blocking(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.setRawSecondaryAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def delete_main_attachment_async(self, entity_id: str, rev: str) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
				"rev": rev,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.deleteMainAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> EncryptedDocument:
			payload = {
				"entityId": entity_id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.deleteMainAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def delete_secondary_attachment_async(self, document_id: str, key: str, rev: str) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.deleteSecondaryAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def delete_secondary_attachment_blocking(self, document_id: str, key: str, rev: str) -> EncryptedDocument:
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encrypted.deleteSecondaryAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

	class DocumentFlavouredApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, document: Document, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegateId": delegate_id,
				"document": document.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.shareWithAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, document: Document, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegateId": delegate_id,
				"document": document.__serialize__(),
				"shareEncryptionKeys": share_encryption_keys.__serialize__(),
				"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
				"requestedPermission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.shareWithBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def try_share_with_many_async(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.tryShareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.tryShareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = deserialize_simple_share_result(result_info.success)
				return return_value

		async def share_with_many_async(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.shareWithManyAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def share_with_many_blocking(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> Document:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.shareWithManyBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def find_documents_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = PaginatedListIterator[Document](
						producer = success,
						deserializer = lambda x: deserialize_document(x),
						executor = self.icure_sdk._executor
					)
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.findDocumentsByHcPartyPatientAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Document]:
			payload = {
				"hcPartyId": hc_party_id,
				"patient": serialize_patient(patient),
				"startDate": start_date,
				"endDate": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.findDocumentsByHcPartyPatientBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			error_str_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result.pinned)
				raise Exception(error_msg)
			else:
				class_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result.pinned)
				return PaginatedListIterator[Document](
					producer = class_pointer,
					deserializer = lambda x: deserialize_document(x),
					executor = self.icure_sdk._executor
				)

		async def modify_document_async(self, entity: Document) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.modifyDocumentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_document_blocking(self, entity: Document) -> Document:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.modifyDocumentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def get_document_async(self, entity_id: str) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_document_blocking(self, entity_id: str) -> Document:
			payload = {
				"entityId": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def get_document_by_external_uuid_async(self, external_uuid: str) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalUuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentByExternalUuidAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_document_by_external_uuid_blocking(self, external_uuid: str) -> Document:
			payload = {
				"externalUuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentByExternalUuidBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def get_documents_by_external_uuid_async(self, external_uuid: str) -> List[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Document._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"externalUuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentsByExternalUuidAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[Document]:
			payload = {
				"externalUuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentsByExternalUuidBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Document._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def get_documents_async(self, entity_ids: List[str]) -> List[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Document._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def get_documents_blocking(self, entity_ids: List[str]) -> List[Document]:
			payload = {
				"entityIds": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.getDocumentsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Document._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def modify_documents_async(self, entities: List[Document]) -> List[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Document._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.modifyDocumentsAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def modify_documents_blocking(self, entities: List[Document]) -> List[Document]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.modifyDocumentsBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Document._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def list_documents_by_hc_party_message_foreign_keys_async(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Document._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hcPartyId": hc_party_id,
				"documentTypeCode": document_type_code,
				"secretMessageKeys": [x0 for x0 in secret_message_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.listDocumentsByHcPartyMessageForeignKeysAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[Document]:
			payload = {
				"hcPartyId": hc_party_id,
				"documentTypeCode": document_type_code,
				"secretMessageKeys": [x0 for x0 in secret_message_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.listDocumentsByHcPartyMessageForeignKeysBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Document._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def find_without_delegation_async(self, limit: Optional[int]) -> List[Document]:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = [Document._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.findWithoutDelegationAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def find_without_delegation_blocking(self, limit: Optional[int]) -> List[Document]:
			payload = {
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.findWithoutDelegationBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = [Document._deserialize(x1) for x1 in result_info.success]
				return return_value

		async def set_raw_main_attachment_async(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.setRawMainAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_raw_main_attachment_blocking(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			payload = {
				"documentId": document_id,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.setRawMainAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def set_raw_secondary_attachment_async(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.setRawSecondaryAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def set_raw_secondary_attachment_blocking(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
				"utis": [x0 for x0 in utis],
				"blobType": blob_type,
				"attachment": base64.b64encode(attachment).decode('utf-8'),
				"encrypted": encrypted,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.setRawSecondaryAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
				return return_value

		async def delete_main_attachment_async(self, entity_id: str, rev: str) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entityId": entity_id,
				"rev": rev,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.deleteMainAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> Document:
			payload = {
				"entityId": entity_id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.deleteMainAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def delete_secondary_attachment_async(self, document_id: str, key: str, rev: str) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				if failure is not None:
					result = Exception(failure.decode('utf-8'))
					loop.call_soon_threadsafe(lambda: future.set_exception(result))
				else:
					result = Document._deserialize(json.loads(success.decode('utf-8')))
					loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk._executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.deleteSecondaryAttachmentAsync,
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
				callback
			)
			return await future

		def delete_secondary_attachment_blocking(self, document_id: str, key: str, rev: str) -> Document:
			payload = {
				"documentId": document_id,
				"key": key,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryAndRecover.deleteSecondaryAttachmentBlocking(
				self.icure_sdk._native,
				json.dumps(payload).encode('utf-8'),
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

	def __init__(self, icure_sdk):
		self.icure_sdk = icure_sdk
		self.encrypted = DocumentApi.DocumentFlavouredEncryptedApi(self.icure_sdk)
		self.tryAndRecover = DocumentApi.DocumentFlavouredApi(self.icure_sdk)

	async def create_document_async(self, entity: DecryptedDocument) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDocumentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDocumentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedDocument], message: Optional[Message], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message) if message is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.withEncryptionMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedDocument], message: Optional[Message], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOptionUseAnySharedWithParent()) -> DecryptedDocument:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message) if message is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secretId": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.withEncryptionMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_and_try_decrypt_main_attachment_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = bytearray(base64.b64decode(json.loads(success.decode('utf-8')))) if json.loads(success.decode('utf-8')) is not None else None
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
			callback
		)
		return await future

	def get_and_try_decrypt_main_attachment_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[bytearray]:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success)) if result_info.success is not None else None
			return return_value

	async def get_and_try_decrypt_main_attachment_as_plain_text_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentAsPlainTextAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
			callback
		)
		return await future

	def get_and_try_decrypt_main_attachment_as_plain_text_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[str]:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentAsPlainTextBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_and_try_decrypt_main_attachment_as_json_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[Dict[str, object]]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = dict(map(lambda kv1: (kv1[0], kv1[1]), json.loads(success.decode('utf-8')).items())) if json.loads(success.decode('utf-8')) is not None else None
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentAsJsonAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
			callback
		)
		return await future

	def get_and_try_decrypt_main_attachment_as_json_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> Optional[Dict[str, object]]:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndTryDecryptMainAttachmentAsJsonBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items())) if result_info.success is not None else None
			return return_value

	async def get_and_decrypt_main_attachment_async(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = bytearray(base64.b64decode(json.loads(success.decode('utf-8'))))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndDecryptMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
			callback
		)
		return await future

	def get_and_decrypt_main_attachment_blocking(self, document: Document, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		payload = {
			"document": serialize_document(document),
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndDecryptMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def encrypt_and_set_main_attachment_async(self, document: Document, utis: Optional[List[str]], attachment: bytearray) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def encrypt_and_set_main_attachment_blocking(self, document: Document, utis: Optional[List[str]], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_and_decrypt_secondary_attachment_async(self, document: Document, key: str, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = bytearray(base64.b64decode(json.loads(success.decode('utf-8'))))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
			"key": key,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndDecryptSecondaryAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
			callback
		)
		return await future

	def get_and_decrypt_secondary_attachment_blocking(self, document: Document, key: str, decrypted_attachment_validator: Optional[Callable[[bytearray], bool]] = None) -> bytearray:
		payload = {
			"document": serialize_document(document),
			"key": key,
		}
		def decryptedAttachmentValidator_fun(resultHolder, encodedInput):
			try:
				jsonInput = json.loads(encodedInput)
				result = decrypted_attachment_validator(
					bytearray(base64.b64decode(jsonInput[0])),
				)
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackResult(resultHolder, json.dumps(result).encode('utf-8'))
			except Exception:
				symbols.kotlin.root.com.icure.sdk.py.utils.setCallbackFailure(resultHolder, traceback.format_exc())
		decryptedAttachmentValidator_callback = CALLBACK_PARAM_DATA_INPUT(decryptedAttachmentValidator_fun) if decrypted_attachment_validator is not None else None
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getAndDecryptSecondaryAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			decryptedAttachmentValidator_callback,
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def encrypt_and_set_secondary_attachment_async(self, document: Document, key: str, utis: Optional[List[str]], attachment: bytearray) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetSecondaryAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def encrypt_and_set_secondary_attachment_blocking(self, document: Document, key: str, utis: Optional[List[str]], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis] if utis is not None else None,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetSecondaryAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_encryption_keys_of_async(self, document: Document) -> List[HexString]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getEncryptionKeysOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, document: Document) -> List[HexString]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getEncryptionKeysOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def has_write_access_async(self, document: Document) -> bool:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.hasWriteAccessAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def has_write_access_blocking(self, document: Document) -> bool:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.hasWriteAccessBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def decrypt_patient_id_of_async(self, document: Document) -> List[str]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [x1 for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptPatientIdOfAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, document: Document) -> List[str]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptPatientIdOfBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [x1 for x1 in result_info.success]
			return return_value

	async def create_delegation_de_anonymization_metadata_async(self, entity: Document, delegates: List[str]) -> None:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Document, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

	async def decrypt_async(self, document: EncryptedDocument) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def decrypt_blocking(self, document: EncryptedDocument) -> DecryptedDocument:
		payload = {
			"document": document.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def try_decrypt_async(self, document: EncryptedDocument) -> Document:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_document(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryDecryptAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_decrypt_blocking(self, document: EncryptedDocument) -> Document:
		payload = {
			"document": document.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryDecryptBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_document(result_info.success)
			return return_value

	async def delete_document_async(self, entity_id: str) -> DocIdentifier:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DocIdentifier._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteDocumentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_document_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteDocumentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DocIdentifier._deserialize(result_info.success)
			return return_value

	async def delete_documents_async(self, entity_ids: List[str]) -> List[DocIdentifier]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DocIdentifier._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteDocumentsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_documents_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteDocumentsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_raw_main_attachment_async(self, document_id: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = bytearray(base64.b64decode(json.loads(success.decode('utf-8'))))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getRawMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_raw_main_attachment_blocking(self, document_id: str) -> bytearray:
		payload = {
			"documentId": document_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getRawMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def get_main_attachment_as_plain_text_async(self, document_id: str) -> str:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = json.loads(success.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getMainAttachmentAsPlainTextAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_main_attachment_as_plain_text_blocking(self, document_id: str) -> str:
		payload = {
			"documentId": document_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getMainAttachmentAsPlainTextBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
			return return_value

	async def get_main_attachment_as_json_async(self, document_id: str) -> Dict[str, object]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = dict(map(lambda kv1: (kv1[0], kv1[1]), json.loads(success.decode('utf-8')).items()))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getMainAttachmentAsJsonAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_main_attachment_as_json_blocking(self, document_id: str) -> Dict[str, object]:
		payload = {
			"documentId": document_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getMainAttachmentAsJsonBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items()))
			return return_value

	async def get_raw_secondary_attachment_async(self, document_id: str, key: str) -> bytearray:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = bytearray(base64.b64decode(json.loads(success.decode('utf-8'))))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
			"key": key,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getRawSecondaryAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_raw_secondary_attachment_blocking(self, document_id: str, key: str) -> bytearray:
		payload = {
			"documentId": document_id,
			"key": key,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getRawSecondaryAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
			return return_value

	async def share_with_async(self, delegate_id: str, document: DecryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.shareWithAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, document: DecryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegateId": delegate_id,
			"document": document.__serialize__(),
			"shareEncryptionKeys": share_encryption_keys.__serialize__(),
			"shareOwningEntityIds": share_owning_entity_ids.__serialize__(),
			"requestedPermission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.shareWithBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def try_share_with_many_async(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = deserialize_simple_share_result(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryShareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.tryShareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = deserialize_simple_share_result(result_info.success)
			return return_value

	async def share_with_many_async(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.shareWithManyAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def share_with_many_blocking(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> DecryptedDocument:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.shareWithManyBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def find_documents_by_hc_party_patient_async(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = PaginatedListIterator[DecryptedDocument](
					producer = success,
					deserializer = lambda x: DecryptedDocument._deserialize(x),
					executor = self.icure_sdk._executor
				)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"patient": serialize_patient(patient),
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.findDocumentsByHcPartyPatientAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedDocument]:
		payload = {
			"hcPartyId": hc_party_id,
			"patient": serialize_patient(patient),
			"startDate": start_date,
			"endDate": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.findDocumentsByHcPartyPatientBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		error_str_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result.pinned)
			raise Exception(error_msg)
		else:
			class_pointer = symbols.kotlin.root.com.icure.sdk.py.utils.PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result.pinned)
			return PaginatedListIterator[DecryptedDocument](
				producer = class_pointer,
				deserializer = lambda x: DecryptedDocument._deserialize(x),
				executor = self.icure_sdk._executor
			)

	async def modify_document_async(self, entity: DecryptedDocument) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.modifyDocumentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.modifyDocumentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_document_async(self, entity_id: str) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_document_blocking(self, entity_id: str) -> DecryptedDocument:
		payload = {
			"entityId": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_document_by_external_uuid_async(self, external_uuid: str) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"externalUuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentByExternalUuidAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_document_by_external_uuid_blocking(self, external_uuid: str) -> DecryptedDocument:
		payload = {
			"externalUuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentByExternalUuidBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def get_documents_by_external_uuid_async(self, external_uuid: str) -> List[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"externalUuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentsByExternalUuidAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[DecryptedDocument]:
		payload = {
			"externalUuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentsByExternalUuidBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def get_documents_async(self, entity_ids: List[str]) -> List[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def get_documents_blocking(self, entity_ids: List[str]) -> List[DecryptedDocument]:
		payload = {
			"entityIds": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getDocumentsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def modify_documents_async(self, entities: List[DecryptedDocument]) -> List[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.modifyDocumentsAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def modify_documents_blocking(self, entities: List[DecryptedDocument]) -> List[DecryptedDocument]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.modifyDocumentsBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def list_documents_by_hc_party_message_foreign_keys_async(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hcPartyId": hc_party_id,
			"documentTypeCode": document_type_code,
			"secretMessageKeys": [x0 for x0 in secret_message_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.listDocumentsByHcPartyMessageForeignKeysAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[DecryptedDocument]:
		payload = {
			"hcPartyId": hc_party_id,
			"documentTypeCode": document_type_code,
			"secretMessageKeys": [x0 for x0 in secret_message_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.listDocumentsByHcPartyMessageForeignKeysBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def find_without_delegation_async(self, limit: Optional[int]) -> List[DecryptedDocument]:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = [DecryptedDocument._deserialize(x1) for x1 in json.loads(success.decode('utf-8'))]
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.findWithoutDelegationAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def find_without_delegation_blocking(self, limit: Optional[int]) -> List[DecryptedDocument]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.findWithoutDelegationBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DecryptedDocument._deserialize(x1) for x1 in result_info.success]
			return return_value

	async def set_raw_main_attachment_async(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.setRawMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def set_raw_main_attachment_blocking(self, document_id: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"documentId": document_id,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.setRawMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def set_raw_secondary_attachment_async(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = EncryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.setRawSecondaryAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def set_raw_secondary_attachment_blocking(self, document_id: str, key: str, rev: str, utis: List[str], blob_type: str, attachment: bytearray, encrypted: bool) -> EncryptedDocument:
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
			"utis": [x0 for x0 in utis],
			"blobType": blob_type,
			"attachment": base64.b64encode(attachment).decode('utf-8'),
			"encrypted": encrypted,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.setRawSecondaryAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def delete_main_attachment_async(self, entity_id: str, rev: str) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteMainAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> DecryptedDocument:
		payload = {
			"entityId": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteMainAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def delete_secondary_attachment_async(self, document_id: str, key: str, rev: str) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			if failure is not None:
				result = Exception(failure.decode('utf-8'))
				loop.call_soon_threadsafe(lambda: future.set_exception(result))
			else:
				result = DecryptedDocument._deserialize(json.loads(success.decode('utf-8')))
				loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk._executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteSecondaryAttachmentAsync,
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
			callback
		)
		return await future

	def delete_secondary_attachment_blocking(self, document_id: str, key: str, rev: str) -> DecryptedDocument:
		payload = {
			"documentId": document_id,
			"key": key,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.deleteSecondaryAttachmentBlocking(
			self.icure_sdk._native,
			json.dumps(payload).encode('utf-8'),
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value
