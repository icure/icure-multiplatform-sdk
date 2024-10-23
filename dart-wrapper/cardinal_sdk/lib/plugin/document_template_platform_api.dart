// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/document_template.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/paginated_list.dart';
import 'dart:typed_data';


class DocumentTemplatePlatformApi {
	MethodChannel _methodChannel;
	DocumentTemplatePlatformApi(this._methodChannel);

	Future<DocumentTemplate> getDocumentTemplate(String sdkId, String documentTemplateId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.getDocumentTemplate',
			{
				"sdkId": sdkId,
				"documentTemplateId": jsonEncode(documentTemplateId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocumentTemplate");
		final parsedResJson = jsonDecode(res);
		return DocumentTemplate.fromJSON(parsedResJson);
	}

	Future<DocumentTemplate> createDocumentTemplate(String sdkId, DocumentTemplate documentTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.createDocumentTemplate',
			{
				"sdkId": sdkId,
				"documentTemplate": jsonEncode(DocumentTemplate.encode(documentTemplate)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createDocumentTemplate");
		final parsedResJson = jsonDecode(res);
		return DocumentTemplate.fromJSON(parsedResJson);
	}

	Future<DocumentTemplate> modifyDocumentTemplate(String sdkId, DocumentTemplate documentTemplate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.modifyDocumentTemplate',
			{
				"sdkId": sdkId,
				"documentTemplate": jsonEncode(DocumentTemplate.encode(documentTemplate)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDocumentTemplate");
		final parsedResJson = jsonDecode(res);
		return DocumentTemplate.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDocumentTemplates(String sdkId, List<String> documentTemplateIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.deleteDocumentTemplates',
			{
				"sdkId": sdkId,
				"documentTemplateIds": jsonEncode(documentTemplateIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDocumentTemplates");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesBySpeciality(String sdkId, String specialityCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.listDocumentTemplatesBySpeciality',
			{
				"sdkId": sdkId,
				"specialityCode": jsonEncode(specialityCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listDocumentTemplatesBySpeciality");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocumentTemplate.fromJSON(x1) );
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesByDocumentType(String sdkId, String documentTypeCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.listDocumentTemplatesByDocumentType',
			{
				"sdkId": sdkId,
				"documentTypeCode": jsonEncode(documentTypeCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listDocumentTemplatesByDocumentType");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocumentTemplate.fromJSON(x1) );
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesByDocumentTypeForCurrentUser(String sdkId, String documentTypeCode) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.listDocumentTemplatesByDocumentTypeForCurrentUser',
			{
				"sdkId": sdkId,
				"documentTypeCode": jsonEncode(documentTypeCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listDocumentTemplatesByDocumentTypeForCurrentUser");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocumentTemplate.fromJSON(x1) );
	}

	Future<List<DocumentTemplate>> listDocumentTemplates(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.listDocumentTemplates',
			{
				"sdkId": sdkId,
			}
		);
		if (res == null) throw AssertionError("received null result from platform method listDocumentTemplates");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocumentTemplate.fromJSON(x1) );
	}

	Future<PaginatedList<DocumentTemplate>> findAllDocumentTemplates(String sdkId, String? startKey, String? startDocumentId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.findAllDocumentTemplates',
			{
				"sdkId": sdkId,
				"startKey": jsonEncode(startKey),
				"startDocumentId": jsonEncode(startDocumentId),
				"limit": jsonEncode(limit),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findAllDocumentTemplates");
		final parsedResJson = jsonDecode(res);
		return PaginatedList.fromJSON(parsedResJson);
	}

	Future<Uint8List> getDocumentTemplateAttachment(String sdkId, String documentTemplateId, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.getDocumentTemplateAttachment',
			{
				"sdkId": sdkId,
				"documentTemplateId": jsonEncode(documentTemplateId),
				"attachmentId": jsonEncode(attachmentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDocumentTemplateAttachment");
		final parsedResJson = jsonDecode(res);
		return base64Encode(parsedResJson as String);
	}

	Future<Uint8List> getAttachmentText(String sdkId, String documentTemplateId, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.getAttachmentText',
			{
				"sdkId": sdkId,
				"documentTemplateId": jsonEncode(documentTemplateId),
				"attachmentId": jsonEncode(attachmentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAttachmentText");
		final parsedResJson = jsonDecode(res);
		return base64Encode(parsedResJson as String);
	}

	Future<DocumentTemplate> setDocumentTemplateAttachment(String sdkId, String documentTemplateId, Uint8List payload) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.setDocumentTemplateAttachment',
			{
				"sdkId": sdkId,
				"documentTemplateId": jsonEncode(documentTemplateId),
				"payload": jsonEncode(base64Encode(payload as List<int>)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method setDocumentTemplateAttachment");
		final parsedResJson = jsonDecode(res);
		return DocumentTemplate.fromJSON(parsedResJson);
	}

	Future<String> getAttachmentUrl(String sdkId, String documentId, String attachmentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DocumentTemplateApi.getAttachmentUrl',
			{
				"sdkId": sdkId,
				"documentId": jsonEncode(documentId),
				"attachmentId": jsonEncode(attachmentId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAttachmentUrl");
		final parsedResJson = jsonDecode(res);
		return parsedResJson;
	}
}