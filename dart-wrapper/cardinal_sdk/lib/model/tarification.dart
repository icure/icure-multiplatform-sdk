// auto-generated file
import 'package:cardinal_sdk/model/embed/periodicity.dart';
import 'package:cardinal_sdk/model/base/link_qualification.dart';
import 'package:cardinal_sdk/model/base/code_flag.dart';
import 'package:cardinal_sdk/model/base/appendix_type.dart';
import 'package:cardinal_sdk/model/embed/valorisation.dart';
import 'package:cardinal_sdk/model/embed/letter_value.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/code_identification.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "tarification.freezed.dart";


@freezed
abstract class Tarification with _$Tarification implements StoredDocument, CodeIdentification<String> {
	const factory Tarification({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) Map<String, String>? label,
		@Default(null) String? context,
		@Default(null) String? type,
		@Default(null) String? code,
		@Default(null) String? version,
		@Default(null) String? author,
		@Default({}) Set<String> regions,
		@Default([]) List<Periodicity> periodicity,
		@Default(null) int? level,
		@Default([]) List<String> links,
		@Default({}) Map<LinkQualification, List<String>> qualifiedLinks,
		@Default({}) Set<CodeFlag> flags,
		@Default({}) Map<String, Set<String>> searchTerms,
		@Default(null) String? data,
		@Default({}) Map<AppendixType, String> appendices,
		@Default(false) bool disabled,
		@Default({}) Set<DecryptedValorisation> valorisations,
		@Default({}) Map<String, String> category,
		@Default(null) bool? consultationCode,
		@Default(null) bool? hasRelatedCode,
		@Default(null) bool? needsPrescriber,
		@Default({}) Set<String> relatedCodes,
		@Default(null) String? ngroup,
		@Default([]) List<LetterValue> letterValues,
	}) = _Tarification;


	static Map<String, dynamic> encode(Tarification value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"context" : value.context,
			"type" : value.type,
			"code" : value.code,
			"version" : value.version,
			"author" : value.author,
			"regions" : value.regions.map((x0) => x0).toList(),
			"periodicity" : value.periodicity.map((x0) => Periodicity.encode(x0)).toList(),
			"level" : value.level,
			"links" : value.links.map((x0) => x0).toList(),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((x1) => x1).toList())),
			"flags" : value.flags.map((x0) => CodeFlag.encode(x0)).toList(),
			"searchTerms" : value.searchTerms.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"data" : value.data,
			"appendices" : value.appendices.map((k0, v0) => MapEntry(AppendixType.encode(k0), v0)),
			"disabled" : value.disabled,
			"valorisations" : value.valorisations.map((x0) => DecryptedValorisation.encode(x0)).toList(),
			"category" : value.category.map((k0, v0) => MapEntry(k0, v0)),
			"consultationCode" : value.consultationCode,
			"hasRelatedCode" : value.hasRelatedCode,
			"needsPrescriber" : value.needsPrescriber,
			"relatedCodes" : value.relatedCodes.map((x0) => x0).toList(),
			"nGroup" : value.ngroup,
			"letterValues" : value.letterValues.map((x0) => LetterValue.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Tarification fromJSON(Map<String, dynamic> data) {
		return Tarification(
			id: (data["id"] as String),
			level: (data["level"] as int?),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			context: (data["context"] as String?),
			type: (data["type"] as String?),
			code: (data["code"] as String?),
			version: (data["version"] as String?),
			author: (data["author"] as String?),
			regions: (data["regions"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			periodicity: (data["periodicity"] as List<dynamic>).map((x0) => Periodicity.fromJSON(x0) ).toList(),
			links: (data["links"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			qualifiedLinks: (data["qualifiedLinks"] as Map<String, dynamic>).map((k0, v0) => MapEntry(LinkQualification.fromJSON(k0), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			flags: (data["flags"] as List<dynamic>).map((x0) => CodeFlag.fromJSON(x0) ).toSet(),
			searchTerms: (data["searchTerms"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toSet())),
			data: (data["data"] as String?),
			appendices: (data["appendices"] as Map<String, dynamic>).map((k0, v0) => MapEntry(AppendixType.fromJSON(k0), (v0 as String))),
			disabled: (data["disabled"] as bool),
			valorisations: (data["valorisations"] as List<dynamic>).map((x0) => DecryptedValorisation.fromJSON(x0) ).toSet(),
			category: (data["category"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			consultationCode: (data["consultationCode"] as bool?),
			hasRelatedCode: (data["hasRelatedCode"] as bool?),
			needsPrescriber: (data["needsPrescriber"] as bool?),
			relatedCodes: (data["relatedCodes"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			ngroup: (data["nGroup"] as String?),
			letterValues: (data["letterValues"] as List<dynamic>).map((x0) => LetterValue.fromJSON(x0) ).toList(),
		);
	}
}