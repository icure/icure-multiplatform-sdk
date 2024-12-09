// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/document_template.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'dart:typed_data';


class DocumentTemplateApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	DocumentTemplateApi(
		this._sdkId,
		this._dartSdk
		);

	Future<DocumentTemplate> getDocumentTemplate(String documentTemplateId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.getDocumentTemplate(
			_sdkId,
			documentTemplateId,
		);
	}

	Future<DocumentTemplate> createDocumentTemplate(DocumentTemplate documentTemplate) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.createDocumentTemplate(
			_sdkId,
			documentTemplate,
		);
	}

	Future<DocumentTemplate> modifyDocumentTemplate(DocumentTemplate documentTemplate) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.modifyDocumentTemplate(
			_sdkId,
			documentTemplate,
		);
	}

	Future<List<DocIdentifier>> deleteDocumentTemplates(List<String> documentTemplateIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.deleteDocumentTemplates(
			_sdkId,
			documentTemplateIds,
		);
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesBySpeciality(String specialityCode) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.listDocumentTemplatesBySpeciality(
			_sdkId,
			specialityCode,
		);
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesByDocumentType(String documentTypeCode) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.listDocumentTemplatesByDocumentType(
			_sdkId,
			documentTypeCode,
		);
	}

	Future<List<DocumentTemplate>> listDocumentTemplatesByDocumentTypeForCurrentUser(String documentTypeCode) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.listDocumentTemplatesByDocumentTypeForCurrentUser(
			_sdkId,
			documentTypeCode,
		);
	}

	Future<List<DocumentTemplate>> listDocumentTemplates() async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.listDocumentTemplates(
			_sdkId,
		);
	}

	Future<Uint8List> getDocumentTemplateAttachment(String documentTemplateId, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.getDocumentTemplateAttachment(
			_sdkId,
			documentTemplateId,
			attachmentId,
		);
	}

	Future<Uint8List> getAttachmentText(String documentTemplateId, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.getAttachmentText(
			_sdkId,
			documentTemplateId,
			attachmentId,
		);
	}

	Future<DocumentTemplate> setDocumentTemplateAttachment(String documentTemplateId, Uint8List payload) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.setDocumentTemplateAttachment(
			_sdkId,
			documentTemplateId,
			payload,
		);
	}

	Future<String> getAttachmentUrl(String documentId, String attachmentId) async {
		return await CardinalSdkPlatformInterface.instance.apis.documentTemplate.getAttachmentUrl(
			_sdkId,
			documentId,
			attachmentId,
		);
	}
}