// This file is auto-generated
import 'package:cardinal_sdk/model/embed/substanceproduct.dart';
import 'package:cardinal_sdk/model/embed/medicinalproduct.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/duration.dart';
import 'package:cardinal_sdk/model/embed/renewal.dart';
import 'package:cardinal_sdk/model/embed/regimen_item.dart';
import 'package:cardinal_sdk/model/embed/paragraph_agreement.dart';
import 'package:cardinal_sdk/model/embed/suspension.dart';


class Medication {
	String? compoundPrescription;
	Substanceproduct? substanceProduct;
	Medicinalproduct? medicinalProduct;
	int? _numberOfPackages;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get numberOfPackages => _numberOfPackages;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set numberOfPackages(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfPackages value cannot exceed 2147483647');
		}
		_numberOfPackages = value;
	}
	String? batch;
	int? expirationDate;
	String? instructionForPatient;
	String? instructionForReimbursement;
	String? commentForDelivery;
	String? drugRoute;
	String? temporality;
	CodeStub? frequency;
	CodeStub? reimbursementReason;
	bool? substitutionAllowed;
	int? beginMoment;
	int? endMoment;
	int? deliveryMoment;
	int? endExecutionMoment;
	Duration? duration;
	Renewal? renewal;
	bool? knownUsage;
	List<RegimenItem>? regimen;
	String? posology;
	Map<String, ParagraphAgreement>? agreements;
	String? medicationSchemeIdOnSafe;
	int? _medicationSchemeSafeVersion;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get medicationSchemeSafeVersion => _medicationSchemeSafeVersion;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set medicationSchemeSafeVersion(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('medicationSchemeSafeVersion value cannot exceed 2147483647');
		}
		_medicationSchemeSafeVersion = value;
	}
	int? medicationSchemeTimeStampOnSafe;
	String? medicationSchemeDocumentId;
	String? safeIdName;
	String? idOnSafes;
	int? timestampOnSafe;
	bool? changeValidated;
	bool? newSafeMedication;
	String? medicationUse;
	String? beginCondition;
	String? endCondition;
	String? origin;
	bool? medicationChanged;
	bool? posologyChanged;
	List<Suspension>? suspension;
	String? prescriptionRID;
	int? _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}

	Medication({
		int? numberOfPackages,
		int? medicationSchemeSafeVersion,
		int? status,
		this.compoundPrescription,
		this.substanceProduct,
		this.medicinalProduct,
		this.batch,
		this.expirationDate,
		this.instructionForPatient,
		this.instructionForReimbursement,
		this.commentForDelivery,
		this.drugRoute,
		this.temporality,
		this.frequency,
		this.reimbursementReason,
		this.substitutionAllowed,
		this.beginMoment,
		this.endMoment,
		this.deliveryMoment,
		this.endExecutionMoment,
		this.duration,
		this.renewal,
		this.knownUsage,
		this.regimen,
		this.posology,
		this.agreements,
		this.medicationSchemeIdOnSafe,
		this.medicationSchemeTimeStampOnSafe,
		this.medicationSchemeDocumentId,
		this.safeIdName,
		this.idOnSafes,
		this.timestampOnSafe,
		this.changeValidated,
		this.newSafeMedication,
		this.medicationUse,
		this.beginCondition,
		this.endCondition,
		this.origin,
		this.medicationChanged,
		this.posologyChanged,
		this.suspension,
		this.prescriptionRID
	}) : _numberOfPackages = numberOfPackages,
		_medicationSchemeSafeVersion = medicationSchemeSafeVersion,
		_status = status;

	static Map<String, dynamic> encode(Medication value) {
		Map<String, dynamic> entityAsMap = {
			"compoundPrescription" : value.compoundPrescription,
			"substanceProduct" : value.substanceProduct == null ? null : Substanceproduct.encode(value.substanceProduct!),
			"medicinalProduct" : value.medicinalProduct == null ? null : Medicinalproduct.encode(value.medicinalProduct!),
			"numberOfPackages" : value.numberOfPackages,
			"batch" : value.batch,
			"expirationDate" : value.expirationDate,
			"instructionForPatient" : value.instructionForPatient,
			"instructionForReimbursement" : value.instructionForReimbursement,
			"commentForDelivery" : value.commentForDelivery,
			"drugRoute" : value.drugRoute,
			"temporality" : value.temporality,
			"frequency" : value.frequency == null ? null : CodeStub.encode(value.frequency!),
			"reimbursementReason" : value.reimbursementReason == null ? null : CodeStub.encode(value.reimbursementReason!),
			"substitutionAllowed" : value.substitutionAllowed,
			"beginMoment" : value.beginMoment,
			"endMoment" : value.endMoment,
			"deliveryMoment" : value.deliveryMoment,
			"endExecutionMoment" : value.endExecutionMoment,
			"duration" : value.duration == null ? null : Duration.encode(value.duration!),
			"renewal" : value.renewal == null ? null : Renewal.encode(value.renewal!),
			"knownUsage" : value.knownUsage,
			"regimen" : value.regimen?.map((x0) => RegimenItem.encode(x0)),
			"posology" : value.posology,
			"agreements" : value.agreements?.map((k0, v0) => MapEntry(k0, ParagraphAgreement.encode(v0))),
			"medicationSchemeIdOnSafe" : value.medicationSchemeIdOnSafe,
			"medicationSchemeSafeVersion" : value.medicationSchemeSafeVersion,
			"medicationSchemeTimeStampOnSafe" : value.medicationSchemeTimeStampOnSafe,
			"medicationSchemeDocumentId" : value.medicationSchemeDocumentId,
			"safeIdName" : value.safeIdName,
			"idOnSafes" : value.idOnSafes,
			"timestampOnSafe" : value.timestampOnSafe,
			"changeValidated" : value.changeValidated,
			"newSafeMedication" : value.newSafeMedication,
			"medicationUse" : value.medicationUse,
			"beginCondition" : value.beginCondition,
			"endCondition" : value.endCondition,
			"origin" : value.origin,
			"medicationChanged" : value.medicationChanged,
			"posologyChanged" : value.posologyChanged,
			"suspension" : value.suspension?.map((x0) => Suspension.encode(x0)),
			"prescriptionRID" : value.prescriptionRID,
			"status" : value.status
		};
		return entityAsMap;
	}
}