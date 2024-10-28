// auto-generated file
import 'package:cardinal_sdk/model/embed/periodicity.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/code_flag.dart';
import 'package:cardinal_sdk/model/base/appendix_type.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/code_identification.dart';


class Code implements StoredDocument, CodeIdentification<String> {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override String? context = null;
	@override String? type = null;
	@override String? code = null;
	@override String? version = null;
	@override Map<String, String>? label = null;
	String? author = null;
	Set<String> regions = {};
	Set<Periodicity> periodicity = {};
	int? _level = null;
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
	String? data = null;
	Map<AppendixType, String> appendices = {};
	bool disabled = false;
	Code(
		this.id,
		{
			int? level,
			String? rev,
			int? deletionDate,
			String? context,
			String? type,
			String? code,
			String? version,
			Map<String, String>? label,
			String? author,
			Set<String>? regions,
			Set<Periodicity>? periodicity,
			Set<String>? links,
			Map<String, List<String>>? qualifiedLinks,
			Set<CodeFlag>? flags,
			Map<String, Set<String>>? searchTerms,
			String? data,
			Map<AppendixType, String>? appendices,
			bool? disabled
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		context = context ?? null,
		type = type ?? null,
		code = code ?? null,
		version = version ?? null,
		label = label ?? null,
		author = author ?? null,
		regions = regions ?? {},
		periodicity = periodicity ?? {},
		links = links ?? {},
		qualifiedLinks = qualifiedLinks ?? {},
		flags = flags ?? {},
		searchTerms = searchTerms ?? {},
		data = data ?? null,
		appendices = appendices ?? {},
		disabled = disabled ?? false,
		_level = level ?? null;

	factory Code.fromJSON(Map<String, dynamic> data) {
		return Code(
			(data["id"] as String),
			level: (data["level"] as int?),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			context: (data["context"] as String?),
			type: (data["type"] as String?),
			code: (data["code"] as String?),
			version: (data["version"] as String?),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			author: (data["author"] as String?),
			regions: (data["regions"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			periodicity: (data["periodicity"] as List<dynamic>).map((x0) => Periodicity.fromJSON(x0) ).toSet(),
			links: (data["links"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			qualifiedLinks: (data["qualifiedLinks"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			flags: (data["flags"] as List<dynamic>).map((x0) => CodeFlag.fromJSON(x0) ).toSet(),
			searchTerms: (data["searchTerms"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toSet())),
			data: (data["data"] as String?),
			appendices: (data["appendices"] as Map<String, dynamic>).map((k0, v0) => MapEntry(AppendixType.fromJSON(k0), (v0 as String))),
			disabled: (data["disabled"] as bool),
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