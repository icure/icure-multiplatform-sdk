// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'dart:typed_data';


class DocumentBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	DocumentBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchDocumentsBy(BaseFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.matchDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchDocumentsBySorted(BaseSortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.matchDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBy(BaseFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.filterDocumentsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedDocument>> filterDocumentsBySorted(BaseSortableFilterOptions<Document> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.filterDocumentsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteDocumentById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteDocumentById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteDocumentsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteDocumentsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.purgeDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteDocument(
			_sdkId,
			document,
		);
	}

	Future<List<DocIdentifier>> deleteDocuments(List<Document> documents) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteDocuments(
			_sdkId,
			documents,
		);
	}

	Future<void> purgeDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.purgeDocument(
			_sdkId,
			document,
		);
	}

	Future<Uint8List> getRawMainAttachment(String documentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.getRawMainAttachment(
			_sdkId,
			documentId,
		);
	}

	Future<Uint8List> getRawSecondaryAttachment(String documentId, String key) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.getRawSecondaryAttachment(
			_sdkId,
			documentId,
			key,
		);
	}

	Future<EncryptedDocument> setRawMainAttachment(String documentId, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.setRawMainAttachment(
			_sdkId,
			documentId,
			rev,
			utis,
			attachment,
			encrypted,
		);
	}

	Future<EncryptedDocument> setRawSecondaryAttachment(String documentId, String key, String rev, List<String>? utis, Uint8List attachment, bool encrypted) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.setRawSecondaryAttachment(
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
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteMainAttachment(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<EncryptedDocument> deleteSecondaryAttachment(String documentId, String key, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.deleteSecondaryAttachment(
			_sdkId,
			documentId,
			key,
			rev,
		);
	}

	Future<EncryptedDocument> createDocument(EncryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.createDocument(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedDocument> undeleteDocumentById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.undeleteDocumentById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedDocument> undeleteDocument(Document document) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.undeleteDocument(
			_sdkId,
			document,
		);
	}

	Future<EncryptedDocument> modifyDocument(EncryptedDocument entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.modifyDocument(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedDocument?> getDocument(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.getDocument(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedDocument>> getDocuments(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.getDocuments(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedDocument>> modifyDocuments(List<EncryptedDocument> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentBasic.modifyDocuments(
			_sdkId,
			entities,
		);
	}
}