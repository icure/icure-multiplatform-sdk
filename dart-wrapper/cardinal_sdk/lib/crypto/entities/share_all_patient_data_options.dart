// auto-generated file
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

	static ShareAllPatientDataOptions fromJSON(Map<String, dynamic> data) {
		return ShareAllPatientDataOptions(
		);
	}
}

enum ShareAllPatientDataOptionsTag {
	all,
	medicalInformation,
	financialInformation;

	static String encode(ShareAllPatientDataOptionsTag value) {
		switch (value) {
			case ShareAllPatientDataOptionsTag.all:
				return 'All';
			case ShareAllPatientDataOptionsTag.medicalInformation:
				return 'MedicalInformation';
			case ShareAllPatientDataOptionsTag.financialInformation:
				return 'FinancialInformation';
			}
	}


	static ShareAllPatientDataOptionsTag fromJSON(String data) {
		switch (data) {
			case "All":
				return ShareAllPatientDataOptionsTag.all;
			case "MedicalInformation":
				return ShareAllPatientDataOptionsTag.medicalInformation;
			case "FinancialInformation":
				return ShareAllPatientDataOptionsTag.financialInformation;
			default:
				throw ArgumentError('Invalid ShareAllPatientDataOptionsTag entry value $data');
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
				return 'CalendarItem';
			case ShareAllPatientDataOptionsShareableEntity.contact:
				return 'Contact';
			case ShareAllPatientDataOptionsShareableEntity.classification:
				return 'Classification';
			case ShareAllPatientDataOptionsShareableEntity.document:
				return 'Document';
			case ShareAllPatientDataOptionsShareableEntity.form:
				return 'Form';
			case ShareAllPatientDataOptionsShareableEntity.healthElement:
				return 'HealthElement';
			case ShareAllPatientDataOptionsShareableEntity.invoice:
				return 'Invoice';
			case ShareAllPatientDataOptionsShareableEntity.patient:
				return 'Patient';
			}
	}


	static ShareAllPatientDataOptionsShareableEntity fromJSON(String data) {
		switch (data) {
			case "CalendarItem":
				return ShareAllPatientDataOptionsShareableEntity.calendarItem;
			case "Contact":
				return ShareAllPatientDataOptionsShareableEntity.contact;
			case "Classification":
				return ShareAllPatientDataOptionsShareableEntity.classification;
			case "Document":
				return ShareAllPatientDataOptionsShareableEntity.document;
			case "Form":
				return ShareAllPatientDataOptionsShareableEntity.form;
			case "HealthElement":
				return ShareAllPatientDataOptionsShareableEntity.healthElement;
			case "Invoice":
				return ShareAllPatientDataOptionsShareableEntity.invoice;
			case "Patient":
				return ShareAllPatientDataOptionsShareableEntity.patient;
			default:
				throw ArgumentError('Invalid ShareAllPatientDataOptionsShareableEntity entry value $data');
			}
	}

}

class ShareAllPatientDataOptionsEntityResult {
	bool? success = null;
	ShareAllPatientDataOptionsSharePatientDataError? error = null;
	int _modified;
	@ActualInt32() int get modified => _modified;
	@ActualInt32() set modified(int value) {
		if (value > 2147483647) {
			throw ArgumentError('modified value cannot exceed 2147483647');
		}
		_modified = value;
	}
	ShareAllPatientDataOptionsEntityResult(
		int modified,
		{
			bool? success,
			ShareAllPatientDataOptionsSharePatientDataError? error
		}) : success = success ?? null,
		error = error ?? null,
		_modified = modified;

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsEntityResult value) {
		Map<String, dynamic> entityAsMap = {
			"success" : value.success,
			"error" : value.error == null ? null : ShareAllPatientDataOptionsSharePatientDataError.encode(value.error!),
			"modified" : value.modified
		};
		return entityAsMap;
	}

	static ShareAllPatientDataOptionsEntityResult fromJSON(Map<String, dynamic> data) {
		return ShareAllPatientDataOptionsEntityResult(
			(data["modified"] as int),
			success: (data["success"] as bool?),
			error: data["error"] == null ? null : ShareAllPatientDataOptionsSharePatientDataError.fromJSON(data["error"]),
		);
	}
}

class ShareAllPatientDataOptionsResult {
	EncryptedPatient patient;
	Map<ShareAllPatientDataOptionsShareableEntity, ShareAllPatientDataOptionsEntityResult> statuses;
	ShareAllPatientDataOptionsResult(
		this.patient,
		this.statuses
		);

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsResult value) {
		Map<String, dynamic> entityAsMap = {
			"patient" : EncryptedPatient.encode(value.patient),
			"statuses" : value.statuses.map((k0, v0) => MapEntry(ShareAllPatientDataOptionsShareableEntity.encode(k0), ShareAllPatientDataOptionsEntityResult.encode(v0)))
		};
		return entityAsMap;
	}

	static ShareAllPatientDataOptionsResult fromJSON(Map<String, dynamic> data) {
		return ShareAllPatientDataOptionsResult(
			EncryptedPatient.fromJSON(data["patient"]),
			(data["statuses"] as Map<String, dynamic>).map((k0, v0) => MapEntry(ShareAllPatientDataOptionsShareableEntity.fromJSON(k0), ShareAllPatientDataOptionsEntityResult.fromJSON(v0)))
		);
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

	static ShareAllPatientDataOptionsSharePatientDataError fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure":
				return ShareAllPatientDataOptionsBulkShareFailure.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest":
				return ShareAllPatientDataOptionsFailedRequest.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class ShareAllPatientDataOptionsBulkShareFailure implements ShareAllPatientDataOptionsSharePatientDataError {
	List<FailedRequestDetails> errors;
	String message;
	ShareAllPatientDataOptionsBulkShareFailure(
		this.errors,
		this.message
		);

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsBulkShareFailure value) {
		Map<String, dynamic> entityAsMap = {
			"errors" : value.errors.map((x0) => FailedRequestDetails.encode(x0)).toList(),
			"message" : value.message
		};
		return entityAsMap;
	}

	static ShareAllPatientDataOptionsBulkShareFailure fromJSON(Map<String, dynamic> data) {
		return ShareAllPatientDataOptionsBulkShareFailure(
			(data["errors"] as List<dynamic>).map((x0) => FailedRequestDetails.fromJSON(x0) ).toList(),
			(data["message"] as String)
		);
	}
}

class ShareAllPatientDataOptionsFailedRequest implements ShareAllPatientDataOptionsSharePatientDataError {
	String description;
	ShareAllPatientDataOptionsFailedRequest(this.description);

	static Map<String, dynamic> encode(ShareAllPatientDataOptionsFailedRequest value) {
		Map<String, dynamic> entityAsMap = {
			"description" : value.description
		};
		return entityAsMap;
	}

	static ShareAllPatientDataOptionsFailedRequest fromJSON(Map<String, dynamic> data) {
		return ShareAllPatientDataOptionsFailedRequest(
			(data["description"] as String)
		);
	}
}