// This file is auto-generated
import 'package:cardinal_sdk/model/embed/form/template/form_template_layout.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/document_group.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class FormTemplate implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
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

	FormTemplate({
		required this.id,
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