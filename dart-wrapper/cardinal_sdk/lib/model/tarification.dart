// auto-generated file
import 'package:cardinal_sdk/model/embed/periodicity.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/link_qualification.dart';
import 'package:cardinal_sdk/model/base/code_flag.dart';
import 'package:cardinal_sdk/model/base/appendix_type.dart';
import 'package:cardinal_sdk/model/embed/valorisation.dart';
import 'package:cardinal_sdk/model/embed/letter_value.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/code_identification.dart';


class Tarification implements StoredDocument, CodeIdentification<String> {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	@override Map<String, String>? label = null;
	@override String? context = null;
	@override String? type = null;
	@override String? code = null;
	@override String? version = null;
	String? author = null;
	Set<String> regions = {};
	List<Periodicity> periodicity = [];
	int? _level = null;
	@ActualInt32() int? get level => _level;
	@ActualInt32() set level(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('level value cannot exceed 2147483647');
		}
		_level = value;
	}
	List<String> links = [];
	Map<LinkQualification, List<String>> qualifiedLinks = {};
	Set<CodeFlag> flags = {};
	Map<String, Set<String>> searchTerms = {};
	String? data = null;
	Map<AppendixType, String> appendices = {};
	bool disabled = false;
	Set<DecryptedValorisation> valorisations = {};
	Map<String, String> category = {};
	bool? consultationCode = null;
	bool? hasRelatedCode = null;
	bool? needsPrescriber = null;
	Set<String> relatedCodes = {};
	String? ngroup = null;
	List<LetterValue> letterValues = [];
	Tarification(
		this.id,
		{
			int? level,
			String? rev,
			int? deletionDate,
			Map<String, String>? label,
			String? context,
			String? type,
			String? code,
			String? version,
			String? author,
			Set<String>? regions,
			List<Periodicity>? periodicity,
			List<String>? links,
			Map<LinkQualification, List<String>>? qualifiedLinks,
			Set<CodeFlag>? flags,
			Map<String, Set<String>>? searchTerms,
			String? data,
			Map<AppendixType, String>? appendices,
			bool? disabled,
			Set<DecryptedValorisation>? valorisations,
			Map<String, String>? category,
			bool? consultationCode,
			bool? hasRelatedCode,
			bool? needsPrescriber,
			Set<String>? relatedCodes,
			String? ngroup,
			List<LetterValue>? letterValues
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		label = label ?? null,
		context = context ?? null,
		type = type ?? null,
		code = code ?? null,
		version = version ?? null,
		author = author ?? null,
		regions = regions ?? {},
		periodicity = periodicity ?? [],
		links = links ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		flags = flags ?? {},
		searchTerms = searchTerms ?? {},
		data = data ?? null,
		appendices = appendices ?? {},
		disabled = disabled ?? false,
		valorisations = valorisations ?? {},
		category = category ?? {},
		consultationCode = consultationCode ?? null,
		hasRelatedCode = hasRelatedCode ?? null,
		needsPrescriber = needsPrescriber ?? null,
		relatedCodes = relatedCodes ?? {},
		ngroup = ngroup ?? null,
		letterValues = letterValues ?? [],
		_level = level ?? null;

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
			(data["id"] as String),
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