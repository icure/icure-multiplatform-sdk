// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/embed/document_type.dart';
import 'package:cardinal_sdk/model/base/report_version.dart';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'dart:typed_data';
part "document_template.freezed.dart";


@freezed
abstract class DocumentTemplate with _$DocumentTemplate implements StoredDocument, ICureDocument<String> {
	const factory DocumentTemplate({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) Uint8List? attachment,
		@Default(null) DocumentType? documentType,
		@Default(null) String? mainUti,
		@Default(null) String? name,
		@Default({}) Set<String> otherUtis,
		@Default(null) String? attachmentId,
		@Default(null) ReportVersion? version,
		@Default(null) String? owner,
		@Default(null) String? guid,
		@Default(null) DocumentGroup? group,
		@Default(null) String? descr,
		@Default(null) String? disabled,
		@Default(null) CodeStub? specialty,
	}) = _DocumentTemplate;


	static Map<String, dynamic> encode(DocumentTemplate value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"attachment" : value.attachment == null ? null : base64Encode(value.attachment as List<int>),
			"documentType" : value.documentType == null ? null : DocumentType.encode(value.documentType!),
			"mainUti" : value.mainUti,
			"name" : value.name,
			"otherUtis" : value.otherUtis.map((x0) => x0).toList(),
			"attachmentId" : value.attachmentId,
			"version" : value.version == null ? null : ReportVersion.encode(value.version!),
			"owner" : value.owner,
			"guid" : value.guid,
			"group" : value.group == null ? null : DocumentGroup.encode(value.group!),
			"descr" : value.descr,
			"disabled" : value.disabled,
			"specialty" : value.specialty == null ? null : CodeStub.encode(value.specialty!)
		};
		return entityAsMap;
	}

	static DocumentTemplate fromJSON(Map<String, dynamic> data) {
		return DocumentTemplate(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			attachment: data["attachment"] == null ? null : base64Decode(data["attachment"] as String),
			documentType: data["documentType"] == null ? null : DocumentType.fromJSON(data["documentType"]),
			mainUti: (data["mainUti"] as String?),
			name: (data["name"] as String?),
			otherUtis: (data["otherUtis"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			attachmentId: (data["attachmentId"] as String?),
			version: data["version"] == null ? null : ReportVersion.fromJSON(data["version"]),
			owner: (data["owner"] as String?),
			guid: (data["guid"] as String?),
			group: data["group"] == null ? null : DocumentGroup.fromJSON(data["group"]),
			descr: (data["descr"] as String?),
			disabled: (data["disabled"] as String?),
			specialty: data["specialty"] == null ? null : CodeStub.fromJSON(data["specialty"]),
		);
	}
}