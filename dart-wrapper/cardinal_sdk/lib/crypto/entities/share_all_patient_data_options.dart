// This file is auto-generated
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/crypto/entities/failed_request_details.dart';


class ShareAllPatientDataOptions {
	static final ShareAllPatientDataOptions _singleton = ShareAllPatientDataOptions._internal();

	ShareAllPatientDataOptions._internal();
	factory ShareAllPatientDataOptions() {
		return _singleton;
	}

	static Map<String, dynamic> encode(ShareAllPatientDataOptions value) {
		Map<String, dynamic> entityAsMap = {
		};
		return entityAsMap;
	}
}

enum ShareAllPatientDataOptionsTag {
	all,
	medicalInformation,
	financialInformation;

	static String encode(ShareAllPatientDataOptionsTag value) {
		switch (value) {
			case ShareAllPatientDataOptionsTag.all:
				return '"All"';
			case ShareAllPatientDataOptionsTag.medicalInformation:
				return '"MedicalInformation"';
			case ShareAllPatientDataOptionsTag.financialInformation:
				return '"FinancialInformation"';
			}
	}

}

enum ShareAllPatientDataOptionsShareableEntity {
	calendarItem,
	contact,
	classification,
	document,
	form,
	healthElement,
	invoice,
	patient;

	static String encode(ShareAllPatientDataOptionsShareableEntity value) {
		switch (value) {
			case ShareAllPatientDataOptionsShareableEntity.calendarItem:
				return '"CalendarItem"';
			case ShareAllPatientDataOptionsShareableEntity.contact:
				return '"Contact"';
			case ShareAllPatientDataOptionsShareableEntity.classification:
				return '"Classification"';
			case ShareAllPatientDataOptionsShareableEntity.document:
				return '"Document"';
			case ShareAllPatientDataOptionsShareableEntity.form:
				return '"Form"';
			case ShareAllPatientDataOptionsShareableEntity.healthElement:
				return '"HealthElement"';
			case ShareAllPatientDataOptionsShareableEntity.invoice:
				return '"Invoice"';
			case ShareAllPatientDataOptionsShareableEntity.patient:
				return '"Patient"';
			}
	}

}

class ShareAllPatientDataOptionsEntityResult {
	bool? success;
	ShareAllPatientDataOptionsSharePatientDataError? error;
	int _modified;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get modified => _modified;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set modified(int value) {
		if (value > 2147483647) {
			throw ArgumentError('modified value cannot exceed 2147483647');
		}
		_modified = value;
	}

	ShareAllPatientDataOptionsEntityResult({
		required int modified,
		this.success,
		this.error
	}) : _modified = modified;

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsEntityResult value) {
		Map<String, dynamic> entityAsMap = {
			"success" : value.success,
			"error" : value.error == null ? null : ShareAllPatientDataOptionsSharePatientDataError.encode(value.error!),
			"modified" : value.modified
		};
		return entityAsMap;
	}
}

class ShareAllPatientDataOptionsResult {
	EncryptedPatient patient;
	Map<ShareAllPatientDataOptionsShareableEntity, ShareAllPatientDataOptionsEntityResult> statuses;

	ShareAllPatientDataOptionsResult({
		required this.patient,
		required this.statuses
	});

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsResult value) {
		Map<String, dynamic> entityAsMap = {
			"patient" : EncryptedPatient.encode(value.patient),
			"statuses" : value.statuses.map((k0, v0) => MapEntry(ShareAllPatientDataOptionsShareableEntity.encode(k0), ShareAllPatientDataOptionsEntityResult.encode(v0)))
		};
		return entityAsMap;
	}
}

sealed class ShareAllPatientDataOptionsSharePatientDataError {

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsSharePatientDataError value) {
		switch (value) {
			case ShareAllPatientDataOptionsBulkShareFailure entity:
				Map<String, dynamic> entityJson = ShareAllPatientDataOptionsBulkShareFailure.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure";
				return entityJson;
			case ShareAllPatientDataOptionsFailedRequest entity:
				Map<String, dynamic> entityJson = ShareAllPatientDataOptionsFailedRequest.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest";
				return entityJson;
		}
	}
}

class ShareAllPatientDataOptionsBulkShareFailure implements ShareAllPatientDataOptionsSharePatientDataError {
	List<FailedRequestDetails> errors;
	String message;

	ShareAllPatientDataOptionsBulkShareFailure({
		required this.errors,
		required this.message
	});

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsBulkShareFailure value) {
		Map<String, dynamic> entityAsMap = {
			"errors" : value.errors.map((x0) => FailedRequestDetails.encode(x0)),
			"message" : value.message
		};
		return entityAsMap;
	}
}

class ShareAllPatientDataOptionsFailedRequest implements ShareAllPatientDataOptionsSharePatientDataError {
	String description;

	ShareAllPatientDataOptionsFailedRequest({
		required this.description
	});

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsFailedRequest value) {
		Map<String, dynamic> entityAsMap = {
			"description" : value.description
		};
		return entityAsMap;
	}
}