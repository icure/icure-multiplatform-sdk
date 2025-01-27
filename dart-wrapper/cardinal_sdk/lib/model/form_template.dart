// auto-generated file
import 'package:cardinal_sdk/model/embed/form/template/form_template_layout.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class FormTemplate implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	FormTemplateLayout? templateLayout = null;
	Uint8List? rawTemplateLayout = null;
	String? name = null;
	String? guid = null;
	DocumentGroup? group = null;
	String? descr = null;
	String? disabled = null;
	CodeStub? specialty = null;
	String? author = null;
	String? formInstancePreferredLocation = null;
	String? keyboardShortcut = null;
	String? shortReport = null;
	String? mediumReport = null;
	String? longReport = null;
	Set<String> reports = {};
	Set<CodeStub> tags = {};
	String? layoutAttachmentId = null;
	String? templateLayoutAttachmentId = null;
	FormTemplate(
		this.id,
		{
			String? rev,
			int? deletionDate,
			FormTemplateLayout? templateLayout,
			Uint8List? rawTemplateLayout,
			String? name,
			String? guid,
			DocumentGroup? group,
			String? descr,
			String? disabled,
			CodeStub? specialty,
			String? author,
			String? formInstancePreferredLocation,
			String? keyboardShortcut,
			String? shortReport,
			String? mediumReport,
			String? longReport,
			Set<String>? reports,
			Set<CodeStub>? tags,
			String? layoutAttachmentId,
			String? templateLayoutAttachmentId
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		templateLayout = templateLayout ?? null,
		rawTemplateLayout = rawTemplateLayout ?? null,
		name = name ?? null,
		guid = guid ?? null,
		group = group ?? null,
		descr = descr ?? null,
		disabled = disabled ?? null,
		specialty = specialty ?? null,
		author = author ?? null,
		formInstancePreferredLocation = formInstancePreferredLocation ?? null,
		keyboardShortcut = keyboardShortcut ?? null,
		shortReport = shortReport ?? null,
		mediumReport = mediumReport ?? null,
		longReport = longReport ?? null,
		reports = reports ?? {},
		tags = tags ?? {},
		layoutAttachmentId = layoutAttachmentId ?? null,
		templateLayoutAttachmentId = templateLayoutAttachmentId ?? null;

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
			(data["id"] as String),
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