// This file is auto-generated
import 'package:cardinal_sdk/model/embed/payment_type.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/invoicing_code.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class InvoicingCode implements Encryptable {
	abstract String? id;
	abstract int? dateCode;
	abstract String? logicalId;
	abstract String? label;
	abstract String? userId;
	abstract String? contactId;
	abstract String? serviceId;
	abstract String? tarificationId;
	abstract String? code;
	abstract PaymentType? paymentType;
	abstract double? paid;
	abstract double? totalAmount;
	abstract double? reimbursement;
	abstract double? patientIntervention;
	abstract double? doctorSupplement;
	abstract double? conventionAmount;
	abstract double? vat;
	abstract String? error;
	abstract String? contract;
	abstract int? contractDate;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? units;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? side;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? timeOfDay;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? eidReadingHour;
	abstract String? eidReadingValue;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? override3rdPayerCode;
	abstract String? override3rdPayerReason;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? transplantationCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? prescriberNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? percentNorm;
	abstract String? prescriberNihii;
	abstract String? relatedCode;
	abstract int? prescriptionDate;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? derogationMaxNumber;
	abstract String? prescriberSsin;
	abstract String? prescriberLastName;
	abstract String? prescriberFirstName;
	abstract String? prescriberCdHcParty;
	abstract String? locationNihii;
	abstract String? locationCdHcParty;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? locationService;
	abstract int? admissionDate;
	abstract bool? canceled;
	abstract bool? accepted;
	abstract bool? pending;
	abstract bool? resent;
	abstract bool? archived;
	abstract bool? lost;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? insuranceJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? cancelPatientInterventionReason;
	abstract int? status;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(InvoicingCode value) {
		switch (value) {
			case DecryptedInvoicingCode entity:
				Map<String, dynamic> entityJson = DecryptedInvoicingCode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode";
				return entityJson;
			case EncryptedInvoicingCode entity:
				Map<String, dynamic> entityJson = EncryptedInvoicingCode.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode";
				return entityJson;
		}
	}

	static InvoicingCode fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode":
				return DecryptedInvoicingCode.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode":
				return EncryptedInvoicingCode.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedInvoicingCode implements InvoicingCode {
	@override String? id;
	@override int? dateCode;
	@override String? logicalId;
	@override String? label;
	@override String? userId;
	@override String? contactId;
	@override String? serviceId;
	@override String? tarificationId;
	@override String? code;
	@override PaymentType? paymentType;
	@override double? paid;
	@override double? totalAmount;
	@override double? reimbursement;
	@override double? patientIntervention;
	@override double? doctorSupplement;
	@override double? conventionAmount;
	@override double? vat;
	@override String? error;
	@override String? contract;
	@override int? contractDate;
	int? _units;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get units => _units;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set units(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('units value cannot exceed 2147483647');
		}
		_units = value;
	}
	int? _side;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get side => _side;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set side(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('side value cannot exceed 2147483647');
		}
		_side = value;
	}
	int? _timeOfDay;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get timeOfDay => _timeOfDay;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set timeOfDay(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('timeOfDay value cannot exceed 2147483647');
		}
		_timeOfDay = value;
	}
	int? _eidReadingHour;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get eidReadingHour => _eidReadingHour;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set eidReadingHour(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('eidReadingHour value cannot exceed 2147483647');
		}
		_eidReadingHour = value;
	}
	@override String? eidReadingValue;
	int? _override3rdPayerCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get override3rdPayerCode => _override3rdPayerCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set override3rdPayerCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('override3rdPayerCode value cannot exceed 2147483647');
		}
		_override3rdPayerCode = value;
	}
	@override String? override3rdPayerReason;
	int? _transplantationCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get transplantationCode => _transplantationCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set transplantationCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('transplantationCode value cannot exceed 2147483647');
		}
		_transplantationCode = value;
	}
	int? _prescriberNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get prescriberNorm => _prescriberNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set prescriberNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('prescriberNorm value cannot exceed 2147483647');
		}
		_prescriberNorm = value;
	}
	int? _percentNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get percentNorm => _percentNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set percentNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('percentNorm value cannot exceed 2147483647');
		}
		_percentNorm = value;
	}
	@override String? prescriberNihii;
	@override String? relatedCode;
	@override int? prescriptionDate;
	int? _derogationMaxNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get derogationMaxNumber => _derogationMaxNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set derogationMaxNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('derogationMaxNumber value cannot exceed 2147483647');
		}
		_derogationMaxNumber = value;
	}
	@override String? prescriberSsin;
	@override String? prescriberLastName;
	@override String? prescriberFirstName;
	@override String? prescriberCdHcParty;
	@override String? locationNihii;
	@override String? locationCdHcParty;
	int? _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get locationService => _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override int? admissionDate;
	@override bool? canceled;
	@override bool? accepted;
	@override bool? pending;
	@override bool? resent;
	@override bool? archived;
	@override bool? lost;
	int? _insuranceJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get insuranceJustification => _insuranceJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set insuranceJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('insuranceJustification value cannot exceed 2147483647');
		}
		_insuranceJustification = value;
	}
	int? _cancelPatientInterventionReason;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get cancelPatientInterventionReason => _cancelPatientInterventionReason;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set cancelPatientInterventionReason(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('cancelPatientInterventionReason value cannot exceed 2147483647');
		}
		_cancelPatientInterventionReason = value;
	}
	@override int? status;
	@override Base64String? encryptedSelf;
	DecryptedInvoicingCode({
			int? units,
			int? side,
			int? timeOfDay,
			int? eidReadingHour,
			int? override3rdPayerCode,
			int? transplantationCode,
			int? prescriberNorm,
			int? percentNorm,
			int? derogationMaxNumber,
			int? locationService,
			int? insuranceJustification,
			int? cancelPatientInterventionReason,
			this.id,
			this.dateCode,
			this.logicalId,
			this.label,
			this.userId,
			this.contactId,
			this.serviceId,
			this.tarificationId,
			this.code,
			this.paymentType,
			this.paid,
			this.totalAmount,
			this.reimbursement,
			this.patientIntervention,
			this.doctorSupplement,
			this.conventionAmount,
			this.vat,
			this.error,
			this.contract,
			this.contractDate,
			this.eidReadingValue,
			this.override3rdPayerReason,
			this.prescriberNihii,
			this.relatedCode,
			this.prescriptionDate,
			this.prescriberSsin,
			this.prescriberLastName,
			this.prescriberFirstName,
			this.prescriberCdHcParty,
			this.locationNihii,
			this.locationCdHcParty,
			this.admissionDate,
			this.canceled,
			this.accepted,
			this.pending,
			this.resent,
			this.archived,
			this.lost,
			this.status,
			this.encryptedSelf
		}) : _units = units,
		_side = side,
		_timeOfDay = timeOfDay,
		_eidReadingHour = eidReadingHour,
		_override3rdPayerCode = override3rdPayerCode,
		_transplantationCode = transplantationCode,
		_prescriberNorm = prescriberNorm,
		_percentNorm = percentNorm,
		_derogationMaxNumber = derogationMaxNumber,
		_locationService = locationService,
		_insuranceJustification = insuranceJustification,
		_cancelPatientInterventionReason = cancelPatientInterventionReason;

	factory DecryptedInvoicingCode.fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoicingCode(
			units: data["units"],
			side: data["side"],
			timeOfDay: data["timeOfDay"],
			eidReadingHour: data["eidReadingHour"],
			override3rdPayerCode: data["override3rdPayerCode"],
			transplantationCode: data["transplantationCode"],
			prescriberNorm: data["prescriberNorm"],
			percentNorm: data["percentNorm"],
			derogationMaxNumber: data["derogationMaxNumber"],
			locationService: data["locationService"],
			insuranceJustification: data["insuranceJustification"],
			cancelPatientInterventionReason: data["cancelPatientInterventionReason"],
			id: data["id"],
			dateCode: data["dateCode"],
			logicalId: data["logicalId"],
			label: data["label"],
			userId: data["userId"],
			contactId: data["contactId"],
			serviceId: data["serviceId"],
			tarificationId: data["tarificationId"],
			code: data["code"],
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: data["paid"],
			totalAmount: data["totalAmount"],
			reimbursement: data["reimbursement"],
			patientIntervention: data["patientIntervention"],
			doctorSupplement: data["doctorSupplement"],
			conventionAmount: data["conventionAmount"],
			vat: data["vat"],
			error: data["error"],
			contract: data["contract"],
			contractDate: data["contractDate"],
			eidReadingValue: data["eidReadingValue"],
			override3rdPayerReason: data["override3rdPayerReason"],
			prescriberNihii: data["prescriberNihii"],
			relatedCode: data["relatedCode"],
			prescriptionDate: data["prescriptionDate"],
			prescriberSsin: data["prescriberSsin"],
			prescriberLastName: data["prescriberLastName"],
			prescriberFirstName: data["prescriberFirstName"],
			prescriberCdHcParty: data["prescriberCdHcParty"],
			locationNihii: data["locationNihii"],
			locationCdHcParty: data["locationCdHcParty"],
			admissionDate: data["admissionDate"],
			canceled: data["canceled"],
			accepted: data["accepted"],
			pending: data["pending"],
			resent: data["resent"],
			archived: data["archived"],
			lost: data["lost"],
			status: data["status"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedInvoicingCode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"dateCode" : value.dateCode,
			"logicalId" : value.logicalId,
			"label" : value.label,
			"userId" : value.userId,
			"contactId" : value.contactId,
			"serviceId" : value.serviceId,
			"tarificationId" : value.tarificationId,
			"code" : value.code,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"conventionAmount" : value.conventionAmount,
			"vat" : value.vat,
			"error" : value.error,
			"contract" : value.contract,
			"contractDate" : value.contractDate,
			"units" : value.units,
			"side" : value.side,
			"timeOfDay" : value.timeOfDay,
			"eidReadingHour" : value.eidReadingHour,
			"eidReadingValue" : value.eidReadingValue,
			"override3rdPayerCode" : value.override3rdPayerCode,
			"override3rdPayerReason" : value.override3rdPayerReason,
			"transplantationCode" : value.transplantationCode,
			"prescriberNorm" : value.prescriberNorm,
			"percentNorm" : value.percentNorm,
			"prescriberNihii" : value.prescriberNihii,
			"relatedCode" : value.relatedCode,
			"prescriptionDate" : value.prescriptionDate,
			"derogationMaxNumber" : value.derogationMaxNumber,
			"prescriberSsin" : value.prescriberSsin,
			"prescriberLastName" : value.prescriberLastName,
			"prescriberFirstName" : value.prescriberFirstName,
			"prescriberCdHcParty" : value.prescriberCdHcParty,
			"locationNihii" : value.locationNihii,
			"locationCdHcParty" : value.locationCdHcParty,
			"locationService" : value.locationService,
			"admissionDate" : value.admissionDate,
			"canceled" : value.canceled,
			"accepted" : value.accepted,
			"pending" : value.pending,
			"resent" : value.resent,
			"archived" : value.archived,
			"lost" : value.lost,
			"insuranceJustification" : value.insuranceJustification,
			"cancelPatientInterventionReason" : value.cancelPatientInterventionReason,
			"status" : value.status,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class EncryptedInvoicingCode implements InvoicingCode {
	@override String? id;
	@override int? dateCode;
	@override String? logicalId;
	@override String? label;
	@override String? userId;
	@override String? contactId;
	@override String? serviceId;
	@override String? tarificationId;
	@override String? code;
	@override PaymentType? paymentType;
	@override double? paid;
	@override double? totalAmount;
	@override double? reimbursement;
	@override double? patientIntervention;
	@override double? doctorSupplement;
	@override double? conventionAmount;
	@override double? vat;
	@override String? error;
	@override String? contract;
	@override int? contractDate;
	int? _units;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get units => _units;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set units(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('units value cannot exceed 2147483647');
		}
		_units = value;
	}
	int? _side;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get side => _side;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set side(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('side value cannot exceed 2147483647');
		}
		_side = value;
	}
	int? _timeOfDay;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get timeOfDay => _timeOfDay;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set timeOfDay(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('timeOfDay value cannot exceed 2147483647');
		}
		_timeOfDay = value;
	}
	int? _eidReadingHour;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get eidReadingHour => _eidReadingHour;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set eidReadingHour(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('eidReadingHour value cannot exceed 2147483647');
		}
		_eidReadingHour = value;
	}
	@override String? eidReadingValue;
	int? _override3rdPayerCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get override3rdPayerCode => _override3rdPayerCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set override3rdPayerCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('override3rdPayerCode value cannot exceed 2147483647');
		}
		_override3rdPayerCode = value;
	}
	@override String? override3rdPayerReason;
	int? _transplantationCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get transplantationCode => _transplantationCode;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set transplantationCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('transplantationCode value cannot exceed 2147483647');
		}
		_transplantationCode = value;
	}
	int? _prescriberNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get prescriberNorm => _prescriberNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set prescriberNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('prescriberNorm value cannot exceed 2147483647');
		}
		_prescriberNorm = value;
	}
	int? _percentNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get percentNorm => _percentNorm;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set percentNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('percentNorm value cannot exceed 2147483647');
		}
		_percentNorm = value;
	}
	@override String? prescriberNihii;
	@override String? relatedCode;
	@override int? prescriptionDate;
	int? _derogationMaxNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get derogationMaxNumber => _derogationMaxNumber;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set derogationMaxNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('derogationMaxNumber value cannot exceed 2147483647');
		}
		_derogationMaxNumber = value;
	}
	@override String? prescriberSsin;
	@override String? prescriberLastName;
	@override String? prescriberFirstName;
	@override String? prescriberCdHcParty;
	@override String? locationNihii;
	@override String? locationCdHcParty;
	int? _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get locationService => _locationService;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override int? admissionDate;
	@override bool? canceled;
	@override bool? accepted;
	@override bool? pending;
	@override bool? resent;
	@override bool? archived;
	@override bool? lost;
	int? _insuranceJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get insuranceJustification => _insuranceJustification;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set insuranceJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('insuranceJustification value cannot exceed 2147483647');
		}
		_insuranceJustification = value;
	}
	int? _cancelPatientInterventionReason;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get cancelPatientInterventionReason => _cancelPatientInterventionReason;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set cancelPatientInterventionReason(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('cancelPatientInterventionReason value cannot exceed 2147483647');
		}
		_cancelPatientInterventionReason = value;
	}
	@override int? status;
	@override Base64String? encryptedSelf;
	EncryptedInvoicingCode({
			int? units,
			int? side,
			int? timeOfDay,
			int? eidReadingHour,
			int? override3rdPayerCode,
			int? transplantationCode,
			int? prescriberNorm,
			int? percentNorm,
			int? derogationMaxNumber,
			int? locationService,
			int? insuranceJustification,
			int? cancelPatientInterventionReason,
			this.id,
			this.dateCode,
			this.logicalId,
			this.label,
			this.userId,
			this.contactId,
			this.serviceId,
			this.tarificationId,
			this.code,
			this.paymentType,
			this.paid,
			this.totalAmount,
			this.reimbursement,
			this.patientIntervention,
			this.doctorSupplement,
			this.conventionAmount,
			this.vat,
			this.error,
			this.contract,
			this.contractDate,
			this.eidReadingValue,
			this.override3rdPayerReason,
			this.prescriberNihii,
			this.relatedCode,
			this.prescriptionDate,
			this.prescriberSsin,
			this.prescriberLastName,
			this.prescriberFirstName,
			this.prescriberCdHcParty,
			this.locationNihii,
			this.locationCdHcParty,
			this.admissionDate,
			this.canceled,
			this.accepted,
			this.pending,
			this.resent,
			this.archived,
			this.lost,
			this.status,
			this.encryptedSelf
		}) : _units = units,
		_side = side,
		_timeOfDay = timeOfDay,
		_eidReadingHour = eidReadingHour,
		_override3rdPayerCode = override3rdPayerCode,
		_transplantationCode = transplantationCode,
		_prescriberNorm = prescriberNorm,
		_percentNorm = percentNorm,
		_derogationMaxNumber = derogationMaxNumber,
		_locationService = locationService,
		_insuranceJustification = insuranceJustification,
		_cancelPatientInterventionReason = cancelPatientInterventionReason;

	factory EncryptedInvoicingCode.fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoicingCode(
			units: data["units"],
			side: data["side"],
			timeOfDay: data["timeOfDay"],
			eidReadingHour: data["eidReadingHour"],
			override3rdPayerCode: data["override3rdPayerCode"],
			transplantationCode: data["transplantationCode"],
			prescriberNorm: data["prescriberNorm"],
			percentNorm: data["percentNorm"],
			derogationMaxNumber: data["derogationMaxNumber"],
			locationService: data["locationService"],
			insuranceJustification: data["insuranceJustification"],
			cancelPatientInterventionReason: data["cancelPatientInterventionReason"],
			id: data["id"],
			dateCode: data["dateCode"],
			logicalId: data["logicalId"],
			label: data["label"],
			userId: data["userId"],
			contactId: data["contactId"],
			serviceId: data["serviceId"],
			tarificationId: data["tarificationId"],
			code: data["code"],
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: data["paid"],
			totalAmount: data["totalAmount"],
			reimbursement: data["reimbursement"],
			patientIntervention: data["patientIntervention"],
			doctorSupplement: data["doctorSupplement"],
			conventionAmount: data["conventionAmount"],
			vat: data["vat"],
			error: data["error"],
			contract: data["contract"],
			contractDate: data["contractDate"],
			eidReadingValue: data["eidReadingValue"],
			override3rdPayerReason: data["override3rdPayerReason"],
			prescriberNihii: data["prescriberNihii"],
			relatedCode: data["relatedCode"],
			prescriptionDate: data["prescriptionDate"],
			prescriberSsin: data["prescriberSsin"],
			prescriberLastName: data["prescriberLastName"],
			prescriberFirstName: data["prescriberFirstName"],
			prescriberCdHcParty: data["prescriberCdHcParty"],
			locationNihii: data["locationNihii"],
			locationCdHcParty: data["locationCdHcParty"],
			admissionDate: data["admissionDate"],
			canceled: data["canceled"],
			accepted: data["accepted"],
			pending: data["pending"],
			resent: data["resent"],
			archived: data["archived"],
			lost: data["lost"],
			status: data["status"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedInvoicingCode value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"dateCode" : value.dateCode,
			"logicalId" : value.logicalId,
			"label" : value.label,
			"userId" : value.userId,
			"contactId" : value.contactId,
			"serviceId" : value.serviceId,
			"tarificationId" : value.tarificationId,
			"code" : value.code,
			"paymentType" : value.paymentType == null ? null : PaymentType.encode(value.paymentType!),
			"paid" : value.paid,
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"conventionAmount" : value.conventionAmount,
			"vat" : value.vat,
			"error" : value.error,
			"contract" : value.contract,
			"contractDate" : value.contractDate,
			"units" : value.units,
			"side" : value.side,
			"timeOfDay" : value.timeOfDay,
			"eidReadingHour" : value.eidReadingHour,
			"eidReadingValue" : value.eidReadingValue,
			"override3rdPayerCode" : value.override3rdPayerCode,
			"override3rdPayerReason" : value.override3rdPayerReason,
			"transplantationCode" : value.transplantationCode,
			"prescriberNorm" : value.prescriberNorm,
			"percentNorm" : value.percentNorm,
			"prescriberNihii" : value.prescriberNihii,
			"relatedCode" : value.relatedCode,
			"prescriptionDate" : value.prescriptionDate,
			"derogationMaxNumber" : value.derogationMaxNumber,
			"prescriberSsin" : value.prescriberSsin,
			"prescriberLastName" : value.prescriberLastName,
			"prescriberFirstName" : value.prescriberFirstName,
			"prescriberCdHcParty" : value.prescriberCdHcParty,
			"locationNihii" : value.locationNihii,
			"locationCdHcParty" : value.locationCdHcParty,
			"locationService" : value.locationService,
			"admissionDate" : value.admissionDate,
			"canceled" : value.canceled,
			"accepted" : value.accepted,
			"pending" : value.pending,
			"resent" : value.resent,
			"archived" : value.archived,
			"lost" : value.lost,
			"insuranceJustification" : value.insuranceJustification,
			"cancelPatientInterventionReason" : value.cancelPatientInterventionReason,
			"status" : value.status,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}