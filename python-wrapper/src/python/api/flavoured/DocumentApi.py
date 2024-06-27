import asyncio
import json
import base64
from model import DecryptedDocument, Message, User, AccessLevel, serialize_message, serialize_secret_id_option, Document, EncryptedDocument, serialize_document, DocIdentifier, RequestedPermission, Patient, serialize_patient
from model.CallResult import CallResult, create_result_from_json
from kotlin_types import DATA_RESULT_CALLBACK_FUNC, symbols, PTR_RESULT_CALLBACK_FUNC
from ctypes import cast, c_char_p, c_void_p
from typing import Optional, Dict, List
from crypto import SecretIdOption, ShareMetadataBehaviour, deserialize_simple_share_result, SimpleShareResult, DocumentShareOptions
from model.specializations import HexString
from pagination.PaginatedListIterator import PaginatedListIterator
from KotlinTypes import PyResult

class DocumentApi:

	class DocumentFlavouredEncryptedApi:

		def __init__(self, icure_sdk):
			self.icure_sdk = icure_sdk

		async def share_with_async(self, delegate_id: str, document: EncryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
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
				"document": document.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, document: EncryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"document": document.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = EncryptedDocument._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, document: EncryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> EncryptedDocument:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[EncryptedDocument](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: EncryptedDocument._deserialize(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[EncryptedDocument]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[EncryptedDocument](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: EncryptedDocument._deserialize(x)
				)

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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_document_blocking(self, entity: EncryptedDocument) -> EncryptedDocument:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_document_blocking(self, entity_id: str) -> EncryptedDocument:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_document_by_external_uuid_blocking(self, external_uuid: str) -> EncryptedDocument:
			payload = {
				"external_uuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[EncryptedDocument]:
			payload = {
				"external_uuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_documents_blocking(self, entity_ids: List[str]) -> List[EncryptedDocument]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_documents_blocking(self, entities: List[EncryptedDocument]) -> List[EncryptedDocument]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_without_delegation_blocking(self, limit: Optional[int]) -> List[EncryptedDocument]:
			payload = {
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = EncryptedDocument._deserialize(result_info.success)
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"delegate_id": delegate_id,
				"document": document.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_blocking(self, delegate_id: str, document: Document, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
			payload = {
				"delegate_id": delegate_id,
				"document": document.__serialize__(),
				"share_encryption_keys": share_encryption_keys.__serialize__(),
				"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
				"requested_permission": requested_permission.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = deserialize_simple_share_result(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def try_share_with_many_blocking(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def share_with_many_blocking(self, document: Document, delegates: Dict[str, DocumentShareOptions]) -> Document:
			payload = {
				"document": document.__serialize__(),
				"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					result = PaginatedListIterator[Document](
						producer = cast(class_pointer, c_void_p),
						deserializer = lambda x: deserialize_document(x)
					)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[Document]:
			payload = {
				"hc_party_id": hc_party_id,
				"patient": serialize_patient(patient),
				"start_date": start_date,
				"end_date": end_date,
				"descending": descending,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			error_str_pointer = PyResult.get_failure(call_result)
			if error_str_pointer is not None:
				error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
				symbols.DisposeString(error_str_pointer)
				symbols.DisposeStablePointer(call_result)
				raise Exception(error_msg)
			else:
				class_pointer = PyResult.get_success(call_result)
				symbols.DisposeStablePointer(call_result)
				return PaginatedListIterator[Document](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: deserialize_document(x)
				)

		async def modify_document_async(self, entity: Document) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity": entity.__serialize__(),
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_document_blocking(self, entity: Document) -> Document:
			payload = {
				"entity": entity.__serialize__(),
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_document_blocking(self, entity_id: str) -> Document:
			payload = {
				"entity_id": entity_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"external_uuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_document_by_external_uuid_blocking(self, external_uuid: str) -> Document:
			payload = {
				"external_uuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Document._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"external_uuid": external_uuid,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[Document]:
			payload = {
				"external_uuid": external_uuid,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Document._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def get_documents_blocking(self, entity_ids: List[str]) -> List[Document]:
			payload = {
				"entity_ids": [x0 for x0 in entity_ids],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Document._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def modify_documents_blocking(self, entities: List[Document]) -> List[Document]:
			payload = {
				"entities": [x0.__serialize__() for x0 in entities],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Document._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"hc_party_id": hc_party_id,
				"document_type_code": document_type_code,
				"secret_message_keys": [x0 for x0 in secret_message_keys],
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[Document]:
			payload = {
				"hc_party_id": hc_party_id,
				"document_type_code": document_type_code,
				"secret_message_keys": [x0 for x0 in secret_message_keys],
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = [Document._deserialize(x1) for x1 in success.decode('utf-8')]
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"limit": limit,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def find_without_delegation_blocking(self, limit: Optional[int]) -> List[Document]:
			payload = {
				"limit": limit,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentAsync,
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
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"entity_id": entity_id,
				"rev": rev,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> Document:
			payload = {
				"entity_id": entity_id,
				"rev": rev,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
			)
			result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
			symbols.DisposeString(call_result)
			if result_info.failure is not None:
				raise Exception(result_info.failure)
			else:
				return_value = Document._deserialize(result_info.success)
				return return_value

		async def delete_secondary_attachment_async(self, document_id: str, key: str, attachment_id: str) -> Document:
			loop = asyncio.get_running_loop()
			future = loop.create_future()
			def make_result_and_complete(success, failure):
				result = None
				if failure is not None:
					result = CallResult(failure=failure.decode('utf-8'))
				else:
					success = Document._deserialize(success.decode('utf-8'))
					result = CallResult(success=success)
				loop.call_soon_threadsafe(lambda: future.set_result(result))
			payload = {
				"document_id": document_id,
				"key": key,
				"attachment_id": attachment_id,
			}
			callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
			loop.run_in_executor(
				self.icure_sdk.executor,
				symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentAsync,
				self.icure_sdk.native,
				json.dumps(payload),
				callback
			)
			return await future

		def delete_secondary_attachment_blocking(self, document_id: str, key: str, attachment_id: str) -> Document:
			payload = {
				"document_id": document_id,
				"key": key,
				"attachment_id": attachment_id,
			}
			call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentBlocking(
				self.icure_sdk.native,
				json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def with_encryption_metadata_async(self, base: Optional[DecryptedDocument], message: Optional[Message], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message) if message is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.withEncryptionMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def with_encryption_metadata_blocking(self, base: Optional[DecryptedDocument], message: Optional[Message], user: Optional[User] = None, delegates: Dict[str, AccessLevel] = {}, secret_id: SecretIdOption = SecretIdOption.UseAnySharedWithParent) -> DecryptedDocument:
		payload = {
			"base": base.__serialize__() if base is not None else None,
			"message": serialize_message(message) if message is not None else None,
			"user": user.__serialize__() if user is not None else None,
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
			"secret_id": serialize_secret_id_option(secret_id),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.withEncryptionMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def encrypt_and_set_main_attachment_async(self, document: Document, utis: List[str], attachment: bytearray) -> EncryptedDocument:
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
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis],
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetMainAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def encrypt_and_set_main_attachment_blocking(self, document: Document, utis: List[str], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"utis": [x0 for x0 in utis],
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = EncryptedDocument._deserialize(result_info.success)
			return return_value

	async def encrypt_and_set_secondary_attachment_async(self, document: Document, key: str, utis: List[str], attachment: bytearray) -> EncryptedDocument:
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
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis],
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetSecondaryAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def encrypt_and_set_secondary_attachment_blocking(self, document: Document, key: str, utis: List[str], attachment: bytearray) -> EncryptedDocument:
		payload = {
			"document": serialize_document(document),
			"key": key,
			"utis": [x0 for x0 in utis],
			"attachment": base64.b64encode(attachment).decode('utf-8'),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.encryptAndSetSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getEncryptionKeysOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_encryption_keys_of_blocking(self, document: Document) -> List[HexString]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.getEncryptionKeysOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.hasWriteAccessAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def has_write_access_blocking(self, document: Document) -> bool:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.hasWriteAccessBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [x1 for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": serialize_document(document),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptPatientIdOfAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def decrypt_patient_id_of_blocking(self, document: Document) -> List[str]:
		payload = {
			"document": serialize_document(document),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.decryptPatientIdOfBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = success.decode('utf-8')
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDelegationDeAnonymizationMetadataAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def create_delegation_de_anonymization_metadata_blocking(self, entity: Document, delegates: List[str]) -> None:
		payload = {
			"entity": serialize_document(entity),
			"delegates": [x0 for x0 in delegates],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentApi.createDelegationDeAnonymizationMetadataBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)

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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.deleteDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_document_blocking(self, entity_id: str) -> DocIdentifier:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.deleteDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.deleteDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_documents_blocking(self, entity_ids: List[str]) -> List[DocIdentifier]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.deleteDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = [DocIdentifier._deserialize(x1) for x1 in result_info.success]
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getRawMainAttachmentAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getRawMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = bytearray(base64.b64decode(result_info.success))
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getMainAttachmentAsPlainTextAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getMainAttachmentAsPlainTextBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = result_info.success
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getMainAttachmentAsJsonAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getMainAttachmentAsJsonBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = dict(map(lambda kv1: (kv1[0], kv1[1]), result_info.success.items()))
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getRawSecondaryAttachmentAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavourlessApi.getRawSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"delegate_id": delegate_id,
			"document": document.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_blocking(self, delegate_id: str, document: DecryptedDocument, share_encryption_keys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, share_owning_entity_ids: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable, requested_permission: RequestedPermission = RequestedPermission.MaxWrite) -> SimpleShareResult:
		payload = {
			"delegate_id": delegate_id,
			"document": document.__serialize__(),
			"share_encryption_keys": share_encryption_keys.__serialize__(),
			"share_owning_entity_ids": share_owning_entity_ids.__serialize__(),
			"requested_permission": requested_permission.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = deserialize_simple_share_result(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def try_share_with_many_blocking(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> SimpleShareResult:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.tryShareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def share_with_many_blocking(self, document: DecryptedDocument, delegates: Dict[str, DocumentShareOptions]) -> DecryptedDocument:
		payload = {
			"document": document.__serialize__(),
			"delegates": {k0: v0.__serialize__() for k0, v0 in delegates.items()},
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.shareWithManyBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				result = PaginatedListIterator[DecryptedDocument](
					producer = cast(class_pointer, c_void_p),
					deserializer = lambda x: DecryptedDocument._deserialize(x)
				)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		callback = PTR_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_documents_by_hc_party_patient_blocking(self, hc_party_id: str, patient: Patient, start_date: Optional[int] = None, end_date: Optional[int] = None, descending: Optional[bool] = None) -> PaginatedListIterator[DecryptedDocument]:
		payload = {
			"hc_party_id": hc_party_id,
			"patient": serialize_patient(patient),
			"start_date": start_date,
			"end_date": end_date,
			"descending": descending,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentFlavouredApi.findDocumentsByHcPartyPatientBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		error_str_pointer = PyResult.get_failure(call_result)
		if error_str_pointer is not None:
			error_msg = cast(error_str_pointer, c_char_p).value.decode('utf_8')
			symbols.DisposeString(error_str_pointer)
			symbols.DisposeStablePointer(call_result)
			raise Exception(error_msg)
		else:
			class_pointer = PyResult.get_success(call_result)
			symbols.DisposeStablePointer(call_result)
			return PaginatedListIterator[DecryptedDocument](
				producer = cast(class_pointer, c_void_p),
				deserializer = lambda x: DecryptedDocument._deserialize(x)
			)

	async def modify_document_async(self, entity: DecryptedDocument) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity": entity.__serialize__(),
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_document_blocking(self, entity: DecryptedDocument) -> DecryptedDocument:
		payload = {
			"entity": entity.__serialize__(),
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_blocking(self, entity_id: str) -> DecryptedDocument:
		payload = {
			"entity_id": entity_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_uuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_document_by_external_uuid_blocking(self, external_uuid: str) -> DecryptedDocument:
		payload = {
			"external_uuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentByExternalUuidBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"external_uuid": external_uuid,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_documents_by_external_uuid_blocking(self, external_uuid: str) -> List[DecryptedDocument]:
		payload = {
			"external_uuid": external_uuid,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsByExternalUuidBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def get_documents_blocking(self, entity_ids: List[str]) -> List[DecryptedDocument]:
		payload = {
			"entity_ids": [x0 for x0 in entity_ids],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.getDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def modify_documents_blocking(self, entities: List[DecryptedDocument]) -> List[DecryptedDocument]:
		payload = {
			"entities": [x0.__serialize__() for x0 in entities],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.modifyDocumentsBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"hc_party_id": hc_party_id,
			"document_type_code": document_type_code,
			"secret_message_keys": [x0 for x0 in secret_message_keys],
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def list_documents_by_hc_party_message_foreign_keys_blocking(self, hc_party_id: str, document_type_code: Optional[str], secret_message_keys: List[str]) -> List[DecryptedDocument]:
		payload = {
			"hc_party_id": hc_party_id,
			"document_type_code": document_type_code,
			"secret_message_keys": [x0 for x0 in secret_message_keys],
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.listDocumentsByHcPartyMessageForeignKeysBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = [DecryptedDocument._deserialize(x1) for x1 in success.decode('utf-8')]
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"limit": limit,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def find_without_delegation_blocking(self, limit: Optional[int]) -> List[DecryptedDocument]:
		payload = {
			"limit": limit,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.findWithoutDelegationBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentAsync,
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
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.setRawSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
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
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"entity_id": entity_id,
			"rev": rev,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_main_attachment_blocking(self, entity_id: str, rev: str) -> DecryptedDocument:
		payload = {
			"entity_id": entity_id,
			"rev": rev,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteMainAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value

	async def delete_secondary_attachment_async(self, document_id: str, key: str, attachment_id: str) -> DecryptedDocument:
		loop = asyncio.get_running_loop()
		future = loop.create_future()
		def make_result_and_complete(success, failure):
			result = None
			if failure is not None:
				result = CallResult(failure=failure.decode('utf-8'))
			else:
				success = DecryptedDocument._deserialize(success.decode('utf-8'))
				result = CallResult(success=success)
			loop.call_soon_threadsafe(lambda: future.set_result(result))
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		callback = DATA_RESULT_CALLBACK_FUNC(make_result_and_complete)
		loop.run_in_executor(
			self.icure_sdk.executor,
			symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentAsync,
			self.icure_sdk.native,
			json.dumps(payload),
			callback
		)
		return await future

	def delete_secondary_attachment_blocking(self, document_id: str, key: str, attachment_id: str) -> DecryptedDocument:
		payload = {
			"document_id": document_id,
			"key": key,
			"attachment_id": attachment_id,
		}
		call_result = symbols.kotlin.root.com.icure.sdk.py.api.flavoured.DocumentBasicFlavouredApi.deleteSecondaryAttachmentBlocking(
			self.icure_sdk.native,
			json.dumps(payload).encode('utf-8')
		)
		result_info = create_result_from_json(cast(call_result, c_char_p).value.decode('utf-8'))
		symbols.DisposeString(call_result)
		if result_info.failure is not None:
			raise Exception(result_info.failure)
		else:
			return_value = DecryptedDocument._deserialize(result_info.success)
			return return_value
