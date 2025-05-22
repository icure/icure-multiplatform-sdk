// auto-generated file
import 'package:cardinal_sdk/model/embed/periodicity.dart';
import 'package:cardinal_sdk/model/base/code_flag.dart';
import 'package:cardinal_sdk/model/base/appendix_type.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/code_identification.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "code.freezed.dart";


@freezed
abstract class Code with _$Code implements StoredDocument, CodeIdentification<String> {
	const factory Code({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? context,
		@Default(null) String? type,
		@Default(null) String? code,
		@Default(null) String? version,
		@Default(null) Map<String, String>? label,
		@Default(null) String? author,
		@Default({}) Set<String> regions,
		@Default({}) Set<Periodicity> periodicity,
		@Default(null) int? level,
		@Default({}) Set<String> links,
		@Default({}) Map<String, List<String>> qualifiedLinks,
		@Default({}) Set<CodeFlag> flags,
		@Default({}) Map<String, Set<String>> searchTerms,
		@Default(null) String? data,
		@Default({}) Map<AppendixType, String> appendices,
		@Default(false) bool disabled,
	}) = _Code;


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

	static Code fromJSON(Map<String, dynamic> data) {
		return Code(
			id: (data["id"] as String),
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
}