// This file is auto-generated
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
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	@override  Map<String, String>? label;
	@override  String? context;
	@override  String? type;
	@override  String? code;
	@override  String? version;
	String? author;
	Set<String> regions = {};
	List<Periodicity> periodicity = [];
	int? _level;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get level => _level;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set level(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('level value cannot exceed 2147483647');
		}
		_level = value;
	}
	List<String> links = [];
	Map<LinkQualification, List<String>> qualifiedLinks = {};
	Set<CodeFlag> flags = {};
	Map<String, Set<String>> searchTerms = {};
	String? data;
	Map<AppendixType, String> appendices = {};
	bool disabled = false;
	Set<DecryptedValorisation> valorisations = {};
	Map<String, String> category = {};
	bool? consultationCode;
	bool? hasRelatedCode;
	bool? needsPrescriber;
	Set<String> relatedCodes = {};
	String? ngroup;
	List<LetterValue> letterValues = [];

	Tarification({
		required this.id,
		int? level,
		this.rev,
		this.deletionDate,
		this.label,
		this.context,
		this.type,
		this.code,
		this.version,
		this.author,
		this.data,
		this.consultationCode,
		this.hasRelatedCode,
		this.needsPrescriber,
		this.ngroup,
		Set<String>? regions,
		List<Periodicity>? periodicity,
		List<String>? links,
		Map<LinkQualification, List<String>>? qualifiedLinks,
		Set<CodeFlag>? flags,
		Map<String, Set<String>>? searchTerms,
		Map<AppendixType, String>? appendices,
		bool? disabled,
		Set<DecryptedValorisation>? valorisations,
		Map<String, String>? category,
		Set<String>? relatedCodes,
		List<LetterValue>? letterValues
	}) : regions = regions ?? {},
		periodicity = periodicity ?? [],
		links = links ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		flags = flags ?? {},
		searchTerms = searchTerms ?? {},
		appendices = appendices ?? {},
		disabled = disabled ?? false,
		valorisations = valorisations ?? {},
		category = category ?? {},
		relatedCodes = relatedCodes ?? {},
		letterValues = letterValues ?? [],
		_level = level;

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
			"regions" : value.regions.map((x0) => x0),
			"periodicity" : value.periodicity.map((x0) => Periodicity.encode(x0)),
			"level" : value.level,
			"links" : value.links.map((x0) => x0),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((x1) => x1))),
			"flags" : value.flags.map((x0) => CodeFlag.encode(x0)),
			"searchTerms" : value.searchTerms.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1))),
			"data" : value.data,
			"appendices" : value.appendices.map((k0, v0) => MapEntry(AppendixType.encode(k0), v0)),
			"disabled" : value.disabled,
			"valorisations" : value.valorisations.map((x0) => DecryptedValorisation.encode(x0)),
			"category" : value.category.map((k0, v0) => MapEntry(k0, v0)),
			"consultationCode" : value.consultationCode,
			"hasRelatedCode" : value.hasRelatedCode,
			"needsPrescriber" : value.needsPrescriber,
			"relatedCodes" : value.relatedCodes.map((x0) => x0),
			"ngroup" : value.ngroup,
			"letterValues" : value.letterValues.map((x0) => LetterValue.encode(x0))
		};
		return entityAsMap;
	}
}