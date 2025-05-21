// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/form_template_layout.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'dart:typed_data';
part "form_template.freezed.dart";


@freezed
abstract class FormTemplate with _$FormTemplate implements StoredDocument {
	const factory FormTemplate({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) FormTemplateLayout? templateLayout,
		@Default(null) Uint8List? rawTemplateLayout,
		@Default(null) String? name,
		@Default(null) String? guid,
		@Default(null) DocumentGroup? group,
		@Default(null) String? descr,
		@Default(null) String? disabled,
		@Default(null) CodeStub? specialty,
		@Default(null) String? author,
		@Default(null) String? formInstancePreferredLocation,
		@Default(null) String? keyboardShortcut,
		@Default(null) String? shortReport,
		@Default(null) String? mediumReport,
		@Default(null) String? longReport,
		@Default({}) Set<String> reports,
		@Default({}) Set<CodeStub> tags,
		@Default(null) String? layoutAttachmentId,
		@Default(null) String? templateLayoutAttachmentId,
	}) = _FormTemplate;


	static Map<String, dynamic> encode(FormTemplate value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"templateLayout" : value.templateLayout == null ? null : FormTemplateLayout.encode(value.templateLayout!),
			"rawTemplateLayout" : value.rawTemplateLayout == null ? null : base64Encode(value.rawTemplateLayout as List<int>),
			"name" : value.name,
			"guid" : value.guid,
			"group" : value.group == null ? null : DocumentGroup.encode(value.group!),
			"descr" : value.descr,
			"disabled" : value.disabled,
			"specialty" : value.specialty == null ? null : CodeStub.encode(value.specialty!),
			"author" : value.author,
			"formInstancePreferredLocation" : value.formInstancePreferredLocation,
			"keyboardShortcut" : value.keyboardShortcut,
			"shortReport" : value.shortReport,
			"mediumReport" : value.mediumReport,
			"longReport" : value.longReport,
			"reports" : value.reports.map((x0) => x0).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"layoutAttachmentId" : value.layoutAttachmentId,
			"templateLayoutAttachmentId" : value.templateLayoutAttachmentId
		};
		return entityAsMap;
	}

	static FormTemplate fromJSON(Map<String, dynamic> data) {
		return FormTemplate(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			templateLayout: data["templateLayout"] == null ? null : FormTemplateLayout.fromJSON(data["templateLayout"]),
			rawTemplateLayout: data["rawTemplateLayout"] == null ? null : base64Decode(data["rawTemplateLayout"] as String),
			name: (data["name"] as String?),
			guid: (data["guid"] as String?),
			group: data["group"] == null ? null : DocumentGroup.fromJSON(data["group"]),
			descr: (data["descr"] as String?),
			disabled: (data["disabled"] as String?),
			specialty: data["specialty"] == null ? null : CodeStub.fromJSON(data["specialty"]),
			author: (data["author"] as String?),
			formInstancePreferredLocation: (data["formInstancePreferredLocation"] as String?),
			keyboardShortcut: (data["keyboardShortcut"] as String?),
			shortReport: (data["shortReport"] as String?),
			mediumReport: (data["mediumReport"] as String?),
			longReport: (data["longReport"] as String?),
			reports: (data["reports"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			layoutAttachmentId: (data["layoutAttachmentId"] as String?),
			templateLayoutAttachmentId: (data["templateLayoutAttachmentId"] as String?),
		);
	}
}