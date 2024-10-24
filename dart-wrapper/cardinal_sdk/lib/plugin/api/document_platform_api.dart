// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'dart:convert';
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
	MethodChannel _methodChannel;
	TryAndRecoverDocumentPlatformApi tryAndRecover;
	EncryptedDocumentPlatformApi encrypted;
	DocumentPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverDocumentPlatformApi(_methodChannel),
		encrypted = EncryptedDocumentPlatformApi(_methodChannel);

	Future<DecryptedDocument> createDocument(String sdkId, DecryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.createDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedDocument.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> withEncryptionMetadata(String sdkId, DecryptedDocument? base, Message? message, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedDocument.encode(base!)),
				"message": jsonEncode(message == null ? null : Message.encode(message!)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<Uint8List?> getAndTryDecryptMainAttachment(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getAndTryDecryptMainAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAndTryDecryptMainAttachment");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : base64Decode(parsedResJson as String);
	}

	Future<Uint8List> getAndDecryptMainAttachment(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getAndDecryptMainAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAndDecryptMainAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedDocument> encryptAndSetMainAttachment(String sdkId, Document document, List<String>? utis, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encryptAndSetMainAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"utis": jsonEncode(utis?.map((x0) => x0)),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method encryptAndSetMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<Uint8List> getAndDecryptSecondaryAttachment(String sdkId, Document document, String key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getAndDecryptSecondaryAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"key": jsonEncode(key),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAndDecryptSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedDocument> encryptAndSetSecondaryAttachment(String sdkId, Document document, String key, List<String>? utis, Uint8List attachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encryptAndSetSecondaryAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"key": jsonEncode(key),
				"utis": jsonEncode(utis?.map((x0) => x0)),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method encryptAndSetSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<bool> hasWriteAccess(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return parsedResJson;
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, Document entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Document.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0)),
			}
		);
	}

	Future<DecryptedDocument> decrypt(String sdkId, EncryptedDocument document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.decrypt',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<Document> tryDecrypt(String sdkId, EncryptedDocument document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Uint8List?> tryDecryptAttachment(String sdkId, Document document, Uint8List encryptedAttachment) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryDecryptAttachment',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"encryptedAttachment": jsonEncode(base64Encode(encryptedAttachment as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecryptAttachment");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : base64Decode(parsedResJson as String);
	}

	Future<List<String>> matchDocumentsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.matchDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchDocumentsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.matchDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<DocIdentifier> deleteDocumentById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocumentById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocumentsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentsByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.purgeDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDocument");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocuments(String sdkId, List<Document> documents) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteDocuments',
			{
				"sdkId": sdkId,
				"documents": jsonEncode(documents.map((x0) => Document.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.purgeDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
	}

	Future<Uint8List> getRawMainAttachment(String sdkId, String documentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<Uint8List> getRawSecondaryAttachment(String sdkId, String documentId, String key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedDocument> setRawMainAttachment(String sdkId, String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.setRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0)),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String sdkId, String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.setRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0)),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteMainAttachment(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteMainAttachment',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String sdkId, String documentId, String key, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.deleteSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> shareWith(String sdkId, String delegateId, DecryptedDocument document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(DecryptedDocument.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> shareWithMany(String sdkId, DecryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(DecryptedDocument.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedDocument.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedDocument>> filterDocumentsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedDocument.fromJSON(x0));
	}

	Future<DecryptedDocument> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> modifyDocument(String sdkId, DecryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedDocument.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<DecryptedDocument> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return DecryptedDocument.fromJSON(parsedResJson);
	}

	Future<List<DecryptedDocument>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DecryptedDocument.fromJSON(x1) );
	}

	Future<List<DecryptedDocument>> modifyDocuments(String sdkId, List<DecryptedDocument> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => DecryptedDocument.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DecryptedDocument.fromJSON(x1) );
	}
}

class TryAndRecoverDocumentPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverDocumentPlatformApi(this._methodChannel);

	Future<Document> shareWith(String sdkId, String delegateId, Document document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(Document.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> shareWithMany(String sdkId, Document document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Document.fromJSON(x0));
	}

	Future<PaginatedListIterator<Document>> filterDocumentsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Document.fromJSON(x0));
	}

	Future<Document> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> modifyDocument(String sdkId, Document entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(Document.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<Document> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return Document.fromJSON(parsedResJson);
	}

	Future<List<Document>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Document.fromJSON(x1) );
	}

	Future<List<Document>> modifyDocuments(String sdkId, List<Document> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.tryAndRecover.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => Document.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Document.fromJSON(x1) );
	}
}

class EncryptedDocumentPlatformApi {
	MethodChannel _methodChannel;
	EncryptedDocumentPlatformApi(this._methodChannel);

	Future<EncryptedDocument> shareWith(String sdkId, String delegateId, EncryptedDocument document, DocumentShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"document": jsonEncode(EncryptedDocument.encode(document)),
				"options": jsonEncode(options == null ? null : DocumentShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> shareWithMany(String sdkId, EncryptedDocument document, Map<String, DocumentShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"document": jsonEncode(EncryptedDocument.encode(document)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, DocumentShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(FilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(SortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<EncryptedDocument> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> modifyDocument(String sdkId, EncryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedDocument.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<List<EncryptedDocument>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedDocument.fromJSON(x1) );
	}

	Future<List<EncryptedDocument>> modifyDocuments(String sdkId, List<EncryptedDocument> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentApi.encrypted.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedDocument.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedDocument.fromJSON(x1) );
	}
}