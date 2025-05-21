// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'dart:typed_data';


class DocumentBasicPlatformApi {
	MethodChannel _methodChannel;
	DocumentBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchDocumentsBy(String sdkId, BaseFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.matchDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchDocumentsBySorted(String sdkId, BaseSortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.matchDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(String sdkId, BaseFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.filterDocumentsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(String sdkId, BaseSortableFilterOptions<Document> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.filterDocumentsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterDocumentsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedDocument.fromJSON(x0));
	}

	Future<DocIdentifier> deleteDocumentById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteDocumentById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteDocumentsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.purgeDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocument");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocuments(String sdkId, List<Document> documents) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteDocuments',
			{
				"sdkId": sdkId,
				"documents": jsonEncode(documents.map((x0) => Document.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.purgeDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
	}

	Future<Uint8List> getRawMainAttachment(String sdkId, String documentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.getRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<Uint8List> getRawSecondaryAttachment(String sdkId, String documentId, String key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.getRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Decode(parsedResJson as String);
	}

	Future<EncryptedDocument> setRawMainAttachment(String sdkId, String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.setRawMainAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setRawMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String sdkId, String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.setRawSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
				"utis": jsonEncode(utis?.map((x0) => x0).toList()),
				"attachment": jsonEncode(base64Encode(attachment as List<int>)),
				"encrypted": jsonEncode(encrypted),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setRawSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteMainAttachment(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteMainAttachment',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMainAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String sdkId, String documentId, String key, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.deleteSecondaryAttachment',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"key": jsonEncode(key),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteSecondaryAttachment");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> createDocument(String sdkId, EncryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.createDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> undeleteDocumentById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.undeleteDocumentById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocumentById");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> undeleteDocument(String sdkId, Document document) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.undeleteDocument',
			{
				"sdkId": sdkId,
				"document": jsonEncode(Document.encode(document)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument> modifyDocument(String sdkId, EncryptedDocument entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.modifyDocument',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedDocument.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocument");
		final parsedResJson = jsonDecode(res);
		return EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<EncryptedDocument?> getDocument(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.getDocument',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocument");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedDocument.fromJSON(parsedResJson);
	}

	Future<List<EncryptedDocument>> getDocuments(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.getDocuments',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedDocument.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedDocument>> modifyDocuments(String sdkId, List<EncryptedDocument> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentBasicApi.modifyDocuments',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedDocument.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyDocuments");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedDocument.fromJSON(x1) ).toList();
	}
}