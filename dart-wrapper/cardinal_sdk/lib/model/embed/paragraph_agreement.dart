// auto-generated file
import 'package:cardinal_sdk/model/embed/agreement_appendix.dart';


class ParagraphAgreement {
	int? timestamp = null;
	String? paragraph = null;
	bool? accepted = null;
	bool? inTreatment = null;
	bool? canceled = null;
	String? careProviderReference = null;
	String? decisionReference = null;
	int? start = null;
	int? end = null;
	int? cancelationDate = null;
	double? quantityValue = null;
	String? quantityUnit = null;
	String? ioRequestReference = null;
	String? responseType = null;
	Map<String, String>? refusalJustification = null;
	Set<int>? verses = null;
	String? coverageType = null;
	double? unitNumber = null;
	double? strength = null;
	String? strengthUnit = null;
	List<AgreementAppendix>? agreementAppendices = null;
	String? documentId = null;
	ParagraphAgreement({
			int? timestamp,
			String? paragraph,
			bool? accepted,
			bool? inTreatment,
			bool? canceled,
			String? careProviderReference,
			String? decisionReference,
			int? start,
			int? end,
			int? cancelationDate,
			double? quantityValue,
			String? quantityUnit,
			String? ioRequestReference,
			String? responseType,
			Map<String, String>? refusalJustification,
			Set<int>? verses,
			String? coverageType,
			double? unitNumber,
			double? strength,
			String? strengthUnit,
			List<AgreementAppendix>? agreementAppendices,
			String? documentId
		}) : timestamp = timestamp ?? null,
		paragraph = paragraph ?? null,
		accepted = accepted ?? null,
		inTreatment = inTreatment ?? null,
		canceled = canceled ?? null,
		careProviderReference = careProviderReference ?? null,
		decisionReference = decisionReference ?? null,
		start = start ?? null,
		end = end ?? null,
		cancelationDate = cancelationDate ?? null,
		quantityValue = quantityValue ?? null,
		quantityUnit = quantityUnit ?? null,
		ioRequestReference = ioRequestReference ?? null,
		responseType = responseType ?? null,
		refusalJustification = refusalJustification ?? null,
		verses = verses ?? null,
		coverageType = coverageType ?? null,
		unitNumber = unitNumber ?? null,
		strength = strength ?? null,
		strengthUnit = strengthUnit ?? null,
		agreementAppendices = agreementAppendices ?? null,
		documentId = documentId ?? null;

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