// auto-generated file
import 'package:cardinal_sdk/model/embed/agreement_appendix.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "paragraph_agreement.freezed.dart";


@freezed
abstract class ParagraphAgreement with _$ParagraphAgreement {
	const factory ParagraphAgreement({
		@Default(null) int? timestamp,
		@Default(null) String? paragraph,
		@Default(null) bool? accepted,
		@Default(null) bool? inTreatment,
		@Default(null) bool? canceled,
		@Default(null) String? careProviderReference,
		@Default(null) String? decisionReference,
		@Default(null) int? start,
		@Default(null) int? end,
		@Default(null) int? cancelationDate,
		@Default(null) double? quantityValue,
		@Default(null) String? quantityUnit,
		@Default(null) String? ioRequestReference,
		@Default(null) String? responseType,
		@Default(null) Map<String, String>? refusalJustification,
		@Default(null) Set<int>? verses,
		@Default(null) String? coverageType,
		@Default(null) double? unitNumber,
		@Default(null) double? strength,
		@Default(null) String? strengthUnit,
		@Default(null) List<AgreementAppendix>? agreementAppendices,
		@Default(null) String? documentId,
	}) = _ParagraphAgreement;


	static Map<String, dynamic> encode(ParagraphAgreement value) {
		Map<String, dynamic> entityAsMap = {
			"timestamp" : value.timestamp,
			"paragraph" : value.paragraph,
			"accepted" : value.accepted,
			"inTreatment" : value.inTreatment,
			"canceled" : value.canceled,
			"careProviderReference" : value.careProviderReference,
			"decisionReference" : value.decisionReference,
			"start" : value.start,
			"end" : value.end,
			"cancelationDate" : value.cancelationDate,
			"quantityValue" : value.quantityValue,
			"quantityUnit" : value.quantityUnit,
			"ioRequestReference" : value.ioRequestReference,
			"responseType" : value.responseType,
			"refusalJustification" : value.refusalJustification?.map((k0, v0) => MapEntry(k0, v0)),
			"verses" : value.verses?.map((x0) => x0).toList(),
			"coverageType" : value.coverageType,
			"unitNumber" : value.unitNumber,
			"strength" : value.strength,
			"strengthUnit" : value.strengthUnit,
			"agreementAppendices" : value.agreementAppendices?.map((x0) => AgreementAppendix.encode(x0)).toList(),
			"documentId" : value.documentId
		};
		return entityAsMap;
	}

	static ParagraphAgreement fromJSON(Map<String, dynamic> data) {
		return ParagraphAgreement(
			timestamp: (data["timestamp"] as int?),
			paragraph: (data["paragraph"] as String?),
			accepted: (data["accepted"] as bool?),
			inTreatment: (data["inTreatment"] as bool?),
			canceled: (data["canceled"] as bool?),
			careProviderReference: (data["careProviderReference"] as String?),
			decisionReference: (data["decisionReference"] as String?),
			start: (data["start"] as int?),
			end: (data["end"] as int?),
			cancelationDate: (data["cancelationDate"] as int?),
			quantityValue: (data["quantityValue"] as num?)?.toDouble(),
			quantityUnit: (data["quantityUnit"] as String?),
			ioRequestReference: (data["ioRequestReference"] as String?),
			responseType: (data["responseType"] as String?),
			refusalJustification: (data["refusalJustification"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			verses: (data["verses"] as List<dynamic>?)?.map((x0) => (x0 as int) ).toSet(),
			coverageType: (data["coverageType"] as String?),
			unitNumber: (data["unitNumber"] as num?)?.toDouble(),
			strength: (data["strength"] as num?)?.toDouble(),
			strengthUnit: (data["strengthUnit"] as String?),
			agreementAppendices: (data["agreementAppendices"] as List<dynamic>?)?.map((x0) => AgreementAppendix.fromJSON(x0) ).toList(),
			documentId: (data["documentId"] as String?)
		);
	}
}