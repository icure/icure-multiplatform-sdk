// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/document_type.dart';
import 'package:cardinal_sdk/model/base/report_version.dart';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class DocumentTemplate implements StoredDocument, ICureDocument<String> {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	Uint8List? attachment = null;
	DocumentType? documentType = null;
	String? mainUti = null;
	String? name = null;
	Set<String> otherUtis = {};
	String? attachmentId = null;
	ReportVersion? version = null;
	String? owner = null;
	String? guid = null;
	DocumentGroup? group = null;
	String? descr = null;
	String? disabled = null;
	CodeStub? specialty = null;
	DocumentTemplate(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			Uint8List? attachment,
			DocumentType? documentType,
			String? mainUti,
			String? name,
			Set<String>? otherUtis,
			String? attachmentId,
			ReportVersion? version,
			String? owner,
			String? guid,
			DocumentGroup? group,
			String? descr,
			String? disabled,
			CodeStub? specialty
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		attachment = attachment ?? null,
		documentType = documentType ?? null,
		mainUti = mainUti ?? null,
		name = name ?? null,
		otherUtis = otherUtis ?? {},
		attachmentId = attachmentId ?? null,
		version = version ?? null,
		owner = owner ?? null,
		guid = guid ?? null,
		group = group ?? null,
		descr = descr ?? null,
		disabled = disabled ?? null,
		specialty = specialty ?? null;

	factory DocumentTemplate.fromJSON(Map<String, dynamic> data) {
		return DocumentTemplate(
			(data["id"] as String),
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
}