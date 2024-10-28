// auto-generated file
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
	String? compoundPrescription = null;
	Substanceproduct? substanceProduct = null;
	Medicinalproduct? medicinalProduct = null;
	int? _numberOfPackages = null;
	@ActualInt32() int? get numberOfPackages => _numberOfPackages;
	@ActualInt32() set numberOfPackages(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfPackages value cannot exceed 2147483647');
		}
		_numberOfPackages = value;
	}
	String? batch = null;
	int? expirationDate = null;
	String? instructionForPatient = null;
	String? instructionForReimbursement = null;
	String? commentForDelivery = null;
	String? drugRoute = null;
	String? temporality = null;
	CodeStub? frequency = null;
	CodeStub? reimbursementReason = null;
	bool? substitutionAllowed = null;
	int? beginMoment = null;
	int? endMoment = null;
	int? deliveryMoment = null;
	int? endExecutionMoment = null;
	Duration? duration = null;
	Renewal? renewal = null;
	bool? knownUsage = null;
	List<RegimenItem>? regimen = null;
	String? posology = null;
	Map<String, ParagraphAgreement>? agreements = null;
	String? medicationSchemeIdOnSafe = null;
	int? _medicationSchemeSafeVersion = null;
	@ActualInt32() int? get medicationSchemeSafeVersion => _medicationSchemeSafeVersion;
	@ActualInt32() set medicationSchemeSafeVersion(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('medicationSchemeSafeVersion value cannot exceed 2147483647');
		}
		_medicationSchemeSafeVersion = value;
	}
	int? medicationSchemeTimeStampOnSafe = null;
	String? medicationSchemeDocumentId = null;
	String? safeIdName = null;
	String? idOnSafes = null;
	int? timestampOnSafe = null;
	bool? changeValidated = null;
	bool? newSafeMedication = null;
	String? medicationUse = null;
	String? beginCondition = null;
	String? endCondition = null;
	String? origin = null;
	bool? medicationChanged = null;
	bool? posologyChanged = null;
	List<Suspension>? suspension = null;
	String? prescriptionRID = null;
	int? _status = null;
	@ActualInt32() int? get status => _status;
	@ActualInt32() set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	Medication({
			int? numberOfPackages,
			int? medicationSchemeSafeVersion,
			int? status,
			String? compoundPrescription,
			Substanceproduct? substanceProduct,
			Medicinalproduct? medicinalProduct,
			String? batch,
			int? expirationDate,
			String? instructionForPatient,
			String? instructionForReimbursement,
			String? commentForDelivery,
			String? drugRoute,
			String? temporality,
			CodeStub? frequency,
			CodeStub? reimbursementReason,
			bool? substitutionAllowed,
			int? beginMoment,
			int? endMoment,
			int? deliveryMoment,
			int? endExecutionMoment,
			Duration? duration,
			Renewal? renewal,
			bool? knownUsage,
			List<RegimenItem>? regimen,
			String? posology,
			Map<String, ParagraphAgreement>? agreements,
			String? medicationSchemeIdOnSafe,
			int? medicationSchemeTimeStampOnSafe,
			String? medicationSchemeDocumentId,
			String? safeIdName,
			String? idOnSafes,
			int? timestampOnSafe,
			bool? changeValidated,
			bool? newSafeMedication,
			String? medicationUse,
			String? beginCondition,
			String? endCondition,
			String? origin,
			bool? medicationChanged,
			bool? posologyChanged,
			List<Suspension>? suspension,
			String? prescriptionRID
		}) : compoundPrescription = compoundPrescription ?? null,
		substanceProduct = substanceProduct ?? null,
		medicinalProduct = medicinalProduct ?? null,
		batch = batch ?? null,
		expirationDate = expirationDate ?? null,
		instructionForPatient = instructionForPatient ?? null,
		instructionForReimbursement = instructionForReimbursement ?? null,
		commentForDelivery = commentForDelivery ?? null,
		drugRoute = drugRoute ?? null,
		temporality = temporality ?? null,
		frequency = frequency ?? null,
		reimbursementReason = reimbursementReason ?? null,
		substitutionAllowed = substitutionAllowed ?? null,
		beginMoment = beginMoment ?? null,
		endMoment = endMoment ?? null,
		deliveryMoment = deliveryMoment ?? null,
		endExecutionMoment = endExecutionMoment ?? null,
		duration = duration ?? null,
		renewal = renewal ?? null,
		knownUsage = knownUsage ?? null,
		regimen = regimen ?? null,
		posology = posology ?? null,
		agreements = agreements ?? null,
		medicationSchemeIdOnSafe = medicationSchemeIdOnSafe ?? null,
		medicationSchemeTimeStampOnSafe = medicationSchemeTimeStampOnSafe ?? null,
		medicationSchemeDocumentId = medicationSchemeDocumentId ?? null,
		safeIdName = safeIdName ?? null,
		idOnSafes = idOnSafes ?? null,
		timestampOnSafe = timestampOnSafe ?? null,
		changeValidated = changeValidated ?? null,
		newSafeMedication = newSafeMedication ?? null,
		medicationUse = medicationUse ?? null,
		beginCondition = beginCondition ?? null,
		endCondition = endCondition ?? null,
		origin = origin ?? null,
		medicationChanged = medicationChanged ?? null,
		posologyChanged = posologyChanged ?? null,
		suspension = suspension ?? null,
		prescriptionRID = prescriptionRID ?? null,
		_numberOfPackages = numberOfPackages ?? null,
		_medicationSchemeSafeVersion = medicationSchemeSafeVersion ?? null,
		_status = status ?? null;

	factory Medication.fromJSON(Map<String, dynamic> data) {
		return Medication(
			numberOfPackages: (data["numberOfPackages"] as int?),
			medicationSchemeSafeVersion: (data["medicationSchemeSafeVersion"] as int?),
			status: (data["status"] as int?),
			compoundPrescription: (data["compoundPrescription"] as String?),
			substanceProduct: data["substanceProduct"] == null ? null : Substanceproduct.fromJSON(data["substanceProduct"]),
			medicinalProduct: data["medicinalProduct"] == null ? null : Medicinalproduct.fromJSON(data["medicinalProduct"]),
			batch: (data["batch"] as String?),
			expirationDate: (data["expirationDate"] as int?),
			instructionForPatient: (data["instructionForPatient"] as String?),
			instructionForReimbursement: (data["instructionForReimbursement"] as String?),
			commentForDelivery: (data["commentForDelivery"] as String?),
			drugRoute: (data["drugRoute"] as String?),
			temporality: (data["temporality"] as String?),
			frequency: data["frequency"] == null ? null : CodeStub.fromJSON(data["frequency"]),
			reimbursementReason: data["reimbursementReason"] == null ? null : CodeStub.fromJSON(data["reimbursementReason"]),
			substitutionAllowed: (data["substitutionAllowed"] as bool?),
			beginMoment: (data["beginMoment"] as int?),
			endMoment: (data["endMoment"] as int?),
			deliveryMoment: (data["deliveryMoment"] as int?),
			endExecutionMoment: (data["endExecutionMoment"] as int?),
			duration: data["duration"] == null ? null : Duration.fromJSON(data["duration"]),
			renewal: data["renewal"] == null ? null : Renewal.fromJSON(data["renewal"]),
			knownUsage: (data["knownUsage"] as bool?),
			regimen: (data["regimen"] as List<dynamic>?)?.map((x0) => RegimenItem.fromJSON(x0) ).toList(),
			posology: (data["posology"] as String?),
			agreements: (data["agreements"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), ParagraphAgreement.fromJSON(v0))),
			medicationSchemeIdOnSafe: (data["medicationSchemeIdOnSafe"] as String?),
			medicationSchemeTimeStampOnSafe: (data["medicationSchemeTimeStampOnSafe"] as int?),
			medicationSchemeDocumentId: (data["medicationSchemeDocumentId"] as String?),
			safeIdName: (data["safeIdName"] as String?),
			idOnSafes: (data["idOnSafes"] as String?),
			timestampOnSafe: (data["timestampOnSafe"] as int?),
			changeValidated: (data["changeValidated"] as bool?),
			newSafeMedication: (data["newSafeMedication"] as bool?),
			medicationUse: (data["medicationUse"] as String?),
			beginCondition: (data["beginCondition"] as String?),
			endCondition: (data["endCondition"] as String?),
			origin: (data["origin"] as String?),
			medicationChanged: (data["medicationChanged"] as bool?),
			posologyChanged: (data["posologyChanged"] as bool?),
			suspension: (data["suspension"] as List<dynamic>?)?.map((x0) => Suspension.fromJSON(x0) ).toList(),
			prescriptionRID: (data["prescriptionRID"] as String?)
		);
	}

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
			"regimen" : value.regimen?.map((x0) => RegimenItem.encode(x0)).toList(),
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
			"suspension" : value.suspension?.map((x0) => Suspension.encode(x0)).toList(),
			"prescriptionRID" : value.prescriptionRID,
			"status" : value.status
		};
		return entityAsMap;
	}
}