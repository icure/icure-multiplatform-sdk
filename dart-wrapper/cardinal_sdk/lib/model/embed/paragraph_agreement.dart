// This file is auto-generated
import 'package:cardinal_sdk/model/embed/agreement_appendix.dart';


class ParagraphAgreement {
	int? timestamp;
	String? paragraph;
	bool? accepted;
	bool? inTreatment;
	bool? canceled;
	String? careProviderReference;
	String? decisionReference;
	int? start;
	int? end;
	int? cancelationDate;
	double? quantityValue;
	String? quantityUnit;
	String? ioRequestReference;
	String? responseType;
	Map<String, String>? refusalJustification;
	Set<int>? verses;
	String? coverageType;
	double? unitNumber;
	double? strength;
	String? strengthUnit;
	List<AgreementAppendix>? agreementAppendices;
	String? documentId;

	ParagraphAgreement({
		this.timestamp,
		this.paragraph,
		this.accepted,
		this.inTreatment,
		this.canceled,
		this.careProviderReference,
		this.decisionReference,
		this.start,
		this.end,
		this.cancelationDate,
		this.quantityValue,
		this.quantityUnit,
		this.ioRequestReference,
		this.responseType,
		this.refusalJustification,
		this.verses,
		this.coverageType,
		this.unitNumber,
		this.strength,
		this.strengthUnit,
		this.agreementAppendices,
		this.documentId
	});

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
			"verses" : value.verses?.map((x0) => x0),
			"coverageType" : value.coverageType,
			"unitNumber" : value.unitNumber,
			"strength" : value.strength,
			"strengthUnit" : value.strengthUnit,
			"agreementAppendices" : value.agreementAppendices?.map((x0) => AgreementAppendix.encode(x0)),
			"documentId" : value.documentId
		};
		return entityAsMap;
	}
}