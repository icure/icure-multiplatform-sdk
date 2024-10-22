// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/form_template_layout.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class FormTemplate implements StoredDocument {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	FormTemplateLayout? templateLayout;
	Uint8List? rawTemplateLayout;
	String? name;
	String? guid;
	DocumentGroup? group;
	String? descr;
	String? disabled;
	CodeStub? specialty;
	String? author;
	String? formInstancePreferredLocation;
	String? keyboardShortcut;
	String? shortReport;
	String? mediumReport;
	String? longReport;
	Set<String> reports = {};
	Set<CodeStub> tags = {};
	String? layoutAttachmentId;
	String? templateLayoutAttachmentId;
	FormTemplate(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.templateLayout,
			this.rawTemplateLayout,
			this.name,
			this.guid,
			this.group,
			this.descr,
			this.disabled,
			this.specialty,
			this.author,
			this.formInstancePreferredLocation,
			this.keyboardShortcut,
			this.shortReport,
			this.mediumReport,
			this.longReport,
			this.layoutAttachmentId,
			this.templateLayoutAttachmentId,
			Set<String>? reports,
			Set<CodeStub>? tags
		}) : reports = reports ?? {},
		tags = tags ?? {};

	factory FormTemplate.fromJSON(Map<String, dynamic> data) {
		return FormTemplate(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			templateLayout: data["templateLayout"] == null ? null : FormTemplateLayout.fromJSON(data["templateLayout"]),
			rawTemplateLayout: data["rawTemplateLayout"] == null ? null : base64Decode(data["rawTemplateLayout"] as String),
			name: data["name"],
			guid: data["guid"],
			group: data["group"] == null ? null : DocumentGroup.fromJSON(data["group"]),
			descr: data["descr"],
			disabled: data["disabled"],
			specialty: data["specialty"] == null ? null : CodeStub.fromJSON(data["specialty"]),
			author: data["author"],
			formInstancePreferredLocation: data["formInstancePreferredLocation"],
			keyboardShortcut: data["keyboardShortcut"],
			shortReport: data["shortReport"],
			mediumReport: data["mediumReport"],
			longReport: data["longReport"],
			reports: data["reports"].map((x0) => x0 ),
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			layoutAttachmentId: data["layoutAttachmentId"],
			templateLayoutAttachmentId: data["templateLayoutAttachmentId"],
		);
	}

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
			"reports" : value.reports.map((x0) => x0),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"layoutAttachmentId" : value.layoutAttachmentId,
			"templateLayoutAttachmentId" : value.templateLayoutAttachmentId
		};
		return entityAsMap;
	}
}