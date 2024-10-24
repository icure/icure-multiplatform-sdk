// auto-generated file
import 'package:cardinal_sdk/model/embed/periodicity.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/code_flag.dart';
import 'package:cardinal_sdk/model/base/appendix_type.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/code_identification.dart';


class Code implements StoredDocument, CodeIdentification<String> {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	@override String? context;
	@override String? type;
	@override String? code;
	@override String? version;
	@override Map<String, String>? label;
	String? author;
	Set<String> regions = {};
	Set<Periodicity> periodicity = {};
	int? _level;
	@ActualInt32() int? get level => _level;
	@ActualInt32() set level(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('level value cannot exceed 2147483647');
		}
		_level = value;
	}
	Set<String> links = {};
	Map<String, List<String>> qualifiedLinks = {};
	Set<CodeFlag> flags = {};
	Map<String, Set<String>> searchTerms = {};
	String? data;
	Map<AppendixType, String> appendices = {};
	bool disabled = false;
	Code(
		this.id,
		{
			int? level,
			this.rev,
			this.deletionDate,
			this.context,
			this.type,
			this.code,
			this.version,
			this.label,
			this.author,
			this.data,
			Set<String>? regions,
			Set<Periodicity>? periodicity,
			Set<String>? links,
			Map<String, List<String>>? qualifiedLinks,
			Set<CodeFlag>? flags,
			Map<String, Set<String>>? searchTerms,
			Map<AppendixType, String>? appendices,
			bool? disabled
		}) : regions = regions ?? {},
		periodicity = periodicity ?? {},
		links = links ?? {},
		qualifiedLinks = qualifiedLinks ?? {},
		flags = flags ?? {},
		searchTerms = searchTerms ?? {},
		appendices = appendices ?? {},
		disabled = disabled ?? false,
		_level = level;

	factory Code.fromJSON(Map<String, dynamic> data) {
		return Code(
			data["id"],
			level: data["level"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			context: data["context"],
			type: data["type"],
			code: data["code"],
			version: data["version"],
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0)),
			author: data["author"],
			regions: data["regions"].map((x0) => x0 ).toList(),
			periodicity: data["periodicity"].map((x0) => Periodicity.fromJSON(x0) ).toList(),
			links: data["links"].map((x0) => x0 ).toList(),
			qualifiedLinks: data["qualifiedLinks"].map((k0, v0) => MapEntry(k0, v0.map((x1) => x1 ).toList())),
			flags: data["flags"].map((x0) => CodeFlag.fromJSON(x0) ).toList(),
			searchTerms: data["searchTerms"].map((k0, v0) => MapEntry(k0, v0.map((x1) => x1 ).toList())),
			data: data["data"],
			appendices: data["appendices"].map((k0, v0) => MapEntry(AppendixType.fromJSON(k0), v0)),
			disabled: data["disabled"],
		);
	}

	static Map<String, dynamic> encode(Code value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"context" : value.context,
			"type" : value.type,
			"code" : value.code,
			"version" : value.version,
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"author" : value.author,
			"regions" : value.regions.map((x0) => x0).toList(),
			"periodicity" : value.periodicity.map((x0) => Periodicity.encode(x0)).toList(),
			"level" : value.level,
			"links" : value.links.map((x0) => x0).toList(),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"flags" : value.flags.map((x0) => CodeFlag.encode(x0)).toList(),
			"searchTerms" : value.searchTerms.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"data" : value.data,
			"appendices" : value.appendices.map((k0, v0) => MapEntry(AppendixType.encode(k0), v0)),
			"disabled" : value.disabled
		};
		return entityAsMap;
	}
}