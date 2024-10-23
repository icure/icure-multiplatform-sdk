// auto-generated file
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/document_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class DocumentPlatformApi {
	String _sdkId;
	TryAndRecoverDocumentPlatformApi tryAndRecover;
	EncryptedDocumentPlatformApi encrypted;
	DocumentPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverDocumentPlatformApi(_sdkId),
		encrypted = EncryptedDocumentPlatformApi(_sdkId);

	Future<DecryptedDocument> createDocument(DecryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.document.createDocument(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedDocument> withEncryptionMetadata(DecryptedDocument? base, Message? message, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.document.withEncryptionMetadata(
			_sdkId,
			base,
			message,
			user,
			delegates,
			secretId,
		);
	}

	Future<Uint8List?> getAndTryDecryptMainAttachment(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.getAndTryDecryptMainAttachment(
			_sdkId,
			document,
		);
	}

	Future<Uint8List> getAndDecryptMainAttachment(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.getAndDecryptMainAttachment(
			_sdkId,
			document,
		);
	}

	Future<EncryptedDocument> encryptAndSetMainAttachment(Document document, List<String>? utis, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.document.encryptAndSetMainAttachment(
			_sdkId,
			document,
			utis,
			attachment,
		);
	}

	Future<Uint8List> getAndDecryptSecondaryAttachment(Document document, String key) async {
		return await CardinalSdkPlatformInterface.instance.document.getAndDecryptSecondaryAttachment(
			_sdkId,
			document,
			key,
		);
	}

	Future<EncryptedDocument> encryptAndSetSecondaryAttachment(Document document, String key, List<String>? utis, Uint8List attachment) async {
		return await CardinalSdkPlatformInterface.instance.document.encryptAndSetSecondaryAttachment(
			_sdkId,
			document,
			key,
			utis,
			attachment,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.getEncryptionKeysOf(
			_sdkId,
			document,
		);
	}

	Future<bool> hasWriteAccess(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.hasWriteAccess(
			_sdkId,
			document,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.decryptPatientIdOf(
			_sdkId,
			document,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Document entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.document.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedDocument> decrypt(EncryptedDocument document) async {
		return await CardinalSdkPlatformInterface.instance.document.decrypt(
			_sdkId,
			document,
		);
	}

	Future<Document> tryDecrypt(EncryptedDocument document) async {
		return await CardinalSdkPlatformInterface.instance.document.tryDecrypt(
			_sdkId,
			document,
		);
	}

	Future<Uint8List?> tryDecryptAttachment(Document document, Uint8List encryptedAttachment) async {
		return await CardinalSdkPlatformInterface.instance.document.tryDecryptAttachment(
			_sdkId,
			document,
			encryptedAttachment,
		);
	}

	Future<List<String>> matchDocumentsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.matchDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchDocumentsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.matchDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteDocumentById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteDocumentById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteDocumentsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.purgeDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteDocument(
			_sdkId,
			document,
		);
	}

	Future<List<DocIdentifier>> deleteDocuments(List<Document> documents) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteDocuments(
			_sdkId,
			documents,
		);
	}

	Future<void> purgeDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.purgeDocument(
			_sdkId,
			document,
		);
	}

	Future<Uint8List> getRawMainAttachment(String documentId) async {
		return await CardinalSdkPlatformInterface.instance.document.getRawMainAttachment(
			_sdkId,
			documentId,
		);
	}

	Future<Uint8List> getRawSecondaryAttachment(String documentId, String key) async {
		return await CardinalSdkPlatformInterface.instance.document.getRawSecondaryAttachment(
			_sdkId,
			documentId,
			key,
		);
	}

	Future<EncryptedDocument> setRawMainAttachment(String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.document.setRawMainAttachment(
			_sdkId,
			documentId,
			rev,
			utis,
			attachment,
			encrypted,
		);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.document.setRawSecondaryAttachment(
			_sdkId,
			documentId,
			key,
			rev,
			utis,
			attachment,
			encrypted,
		);
	}

	Future<EncryptedDocument> deleteMainAttachment(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteMainAttachment(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String documentId, String key, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.deleteSecondaryAttachment(
			_sdkId,
			documentId,
			key,
			rev,
		);
	}

	Future<DecryptedDocument> shareWith(String delegateId, DecryptedDocument document, DocumentShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.document.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<DecryptedDocument> shareWithMany(DecryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.document.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedDocument> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedDocument> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<DecryptedDocument> modifyDocument(DecryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.document.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedDocument> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.document.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedDocument>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.document.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<DecryptedDocument>> modifyDocuments(List<DecryptedDocument> entities) async {
		return await CardinalSdkPlatformInterface.instance.document.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}

class TryAndRecoverDocumentPlatformApi {
	String _sdkId;
	TryAndRecoverDocumentPlatformApi(this._sdkId);

	Future<Document> shareWith(String delegateId, Document document, DocumentShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<Document> shareWithMany(Document document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Document> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Document> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<Document> modifyDocument(Document entity) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<Document> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<Document>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<Document>> modifyDocuments(List<Document> entities) async {
		return await CardinalSdkPlatformInterface.instance.document.tryAndRecover.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}

class EncryptedDocumentPlatformApi {
	String _sdkId;
	EncryptedDocumentPlatformApi(this._sdkId);

	Future<EncryptedDocument> shareWith(String delegateId, EncryptedDocument document, DocumentShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.shareWith(
			_sdkId,
			delegateId,
			document,
			options,
		);
	}

	Future<EncryptedDocument> shareWithMany(EncryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.shareWithMany(
			_sdkId,
			document,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedDocument> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedDocument> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<EncryptedDocument> modifyDocument(EncryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedDocument> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedDocument>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedDocument>> modifyDocuments(List<EncryptedDocument> entities) async {
		return await CardinalSdkPlatformInterface.instance.document.encrypted.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}