// auto-generated file
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
	@ActualInt32() abstract int? units;
	@ActualInt32() abstract int? side;
	@ActualInt32() abstract int? timeOfDay;
	@ActualInt32() abstract int? eidReadingHour;
	abstract String? eidReadingValue;
	@ActualInt32() abstract int? override3rdPayerCode;
	abstract String? override3rdPayerReason;
	@ActualInt32() abstract int? transplantationCode;
	@ActualInt32() abstract int? prescriberNorm;
	@ActualInt32() abstract int? percentNorm;
	abstract String? prescriberNihii;
	abstract String? relatedCode;
	abstract int? prescriptionDate;
	@ActualInt32() abstract int? derogationMaxNumber;
	abstract String? prescriberSsin;
	abstract String? prescriberLastName;
	abstract String? prescriberFirstName;
	abstract String? prescriberCdHcParty;
	abstract String? locationNihii;
	abstract String? locationCdHcParty;
	@ActualInt32() abstract int? locationService;
	abstract int? admissionDate;
	abstract bool? canceled;
	abstract bool? accepted;
	abstract bool? pending;
	abstract bool? resent;
	abstract bool? archived;
	abstract bool? lost;
	@ActualInt32() abstract int? insuranceJustification;
	@ActualInt32() abstract int? cancelPatientInterventionReason;
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
	@override int? dateCode = null;
	@override String? logicalId = null;
	@override String? label = null;
	@override String? userId = null;
	@override String? contactId = null;
	@override String? serviceId = null;
	@override String? tarificationId = null;
	@override String? code = null;
	@override PaymentType? paymentType = null;
	@override double? paid = null;
	@override double? totalAmount = null;
	@override double? reimbursement = null;
	@override double? patientIntervention = null;
	@override double? doctorSupplement = null;
	@override double? conventionAmount = null;
	@override double? vat = null;
	@override String? error = null;
	@override String? contract = null;
	@override int? contractDate = null;
	int? _units = null;
	@ActualInt32() @override int? get units => _units;
	@ActualInt32() @override set units(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('units value cannot exceed 2147483647');
		}
		_units = value;
	}
	int? _side = null;
	@ActualInt32() @override int? get side => _side;
	@ActualInt32() @override set side(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('side value cannot exceed 2147483647');
		}
		_side = value;
	}
	int? _timeOfDay = null;
	@ActualInt32() @override int? get timeOfDay => _timeOfDay;
	@ActualInt32() @override set timeOfDay(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('timeOfDay value cannot exceed 2147483647');
		}
		_timeOfDay = value;
	}
	int? _eidReadingHour = null;
	@ActualInt32() @override int? get eidReadingHour => _eidReadingHour;
	@ActualInt32() @override set eidReadingHour(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('eidReadingHour value cannot exceed 2147483647');
		}
		_eidReadingHour = value;
	}
	@override String? eidReadingValue = null;
	int? _override3rdPayerCode = null;
	@ActualInt32() @override int? get override3rdPayerCode => _override3rdPayerCode;
	@ActualInt32() @override set override3rdPayerCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('override3rdPayerCode value cannot exceed 2147483647');
		}
		_override3rdPayerCode = value;
	}
	@override String? override3rdPayerReason = null;
	int? _transplantationCode = null;
	@ActualInt32() @override int? get transplantationCode => _transplantationCode;
	@ActualInt32() @override set transplantationCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('transplantationCode value cannot exceed 2147483647');
		}
		_transplantationCode = value;
	}
	int? _prescriberNorm = null;
	@ActualInt32() @override int? get prescriberNorm => _prescriberNorm;
	@ActualInt32() @override set prescriberNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('prescriberNorm value cannot exceed 2147483647');
		}
		_prescriberNorm = value;
	}
	int? _percentNorm = null;
	@ActualInt32() @override int? get percentNorm => _percentNorm;
	@ActualInt32() @override set percentNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('percentNorm value cannot exceed 2147483647');
		}
		_percentNorm = value;
	}
	@override String? prescriberNihii = null;
	@override String? relatedCode = null;
	@override int? prescriptionDate = null;
	int? _derogationMaxNumber = null;
	@ActualInt32() @override int? get derogationMaxNumber => _derogationMaxNumber;
	@ActualInt32() @override set derogationMaxNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('derogationMaxNumber value cannot exceed 2147483647');
		}
		_derogationMaxNumber = value;
	}
	@override String? prescriberSsin = null;
	@override String? prescriberLastName = null;
	@override String? prescriberFirstName = null;
	@override String? prescriberCdHcParty = null;
	@override String? locationNihii = null;
	@override String? locationCdHcParty = null;
	int? _locationService = null;
	@ActualInt32() @override int? get locationService => _locationService;
	@ActualInt32() @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override int? admissionDate = null;
	@override bool? canceled = null;
	@override bool? accepted = null;
	@override bool? pending = null;
	@override bool? resent = null;
	@override bool? archived = null;
	@override bool? lost = null;
	int? _insuranceJustification = null;
	@ActualInt32() @override int? get insuranceJustification => _insuranceJustification;
	@ActualInt32() @override set insuranceJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('insuranceJustification value cannot exceed 2147483647');
		}
		_insuranceJustification = value;
	}
	int? _cancelPatientInterventionReason = null;
	@ActualInt32() @override int? get cancelPatientInterventionReason => _cancelPatientInterventionReason;
	@ActualInt32() @override set cancelPatientInterventionReason(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('cancelPatientInterventionReason value cannot exceed 2147483647');
		}
		_cancelPatientInterventionReason = value;
	}
	@override int? status = null;
	@override Base64String? encryptedSelf = null;
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
			int? dateCode,
			String? logicalId,
			String? label,
			String? userId,
			String? contactId,
			String? serviceId,
			String? tarificationId,
			String? code,
			PaymentType? paymentType,
			double? paid,
			double? totalAmount,
			double? reimbursement,
			double? patientIntervention,
			double? doctorSupplement,
			double? conventionAmount,
			double? vat,
			String? error,
			String? contract,
			int? contractDate,
			String? eidReadingValue,
			String? override3rdPayerReason,
			String? prescriberNihii,
			String? relatedCode,
			int? prescriptionDate,
			String? prescriberSsin,
			String? prescriberLastName,
			String? prescriberFirstName,
			String? prescriberCdHcParty,
			String? locationNihii,
			String? locationCdHcParty,
			int? admissionDate,
			bool? canceled,
			bool? accepted,
			bool? pending,
			bool? resent,
			bool? archived,
			bool? lost,
			int? status,
			Base64String? encryptedSelf
		}) : dateCode = dateCode ?? null,
		logicalId = logicalId ?? null,
		label = label ?? null,
		userId = userId ?? null,
		contactId = contactId ?? null,
		serviceId = serviceId ?? null,
		tarificationId = tarificationId ?? null,
		code = code ?? null,
		paymentType = paymentType ?? null,
		paid = paid ?? null,
		totalAmount = totalAmount ?? null,
		reimbursement = reimbursement ?? null,
		patientIntervention = patientIntervention ?? null,
		doctorSupplement = doctorSupplement ?? null,
		conventionAmount = conventionAmount ?? null,
		vat = vat ?? null,
		error = error ?? null,
		contract = contract ?? null,
		contractDate = contractDate ?? null,
		eidReadingValue = eidReadingValue ?? null,
		override3rdPayerReason = override3rdPayerReason ?? null,
		prescriberNihii = prescriberNihii ?? null,
		relatedCode = relatedCode ?? null,
		prescriptionDate = prescriptionDate ?? null,
		prescriberSsin = prescriberSsin ?? null,
		prescriberLastName = prescriberLastName ?? null,
		prescriberFirstName = prescriberFirstName ?? null,
		prescriberCdHcParty = prescriberCdHcParty ?? null,
		locationNihii = locationNihii ?? null,
		locationCdHcParty = locationCdHcParty ?? null,
		admissionDate = admissionDate ?? null,
		canceled = canceled ?? null,
		accepted = accepted ?? null,
		pending = pending ?? null,
		resent = resent ?? null,
		archived = archived ?? null,
		lost = lost ?? null,
		status = status ?? null,
		encryptedSelf = encryptedSelf ?? null,
		_units = units ?? null,
		_side = side ?? null,
		_timeOfDay = timeOfDay ?? null,
		_eidReadingHour = eidReadingHour ?? null,
		_override3rdPayerCode = override3rdPayerCode ?? null,
		_transplantationCode = transplantationCode ?? null,
		_prescriberNorm = prescriberNorm ?? null,
		_percentNorm = percentNorm ?? null,
		_derogationMaxNumber = derogationMaxNumber ?? null,
		_locationService = locationService ?? null,
		_insuranceJustification = insuranceJustification ?? null,
		_cancelPatientInterventionReason = cancelPatientInterventionReason ?? null;

	factory DecryptedInvoicingCode.fromJSON(Map<String, dynamic> data) {
		return DecryptedInvoicingCode(
			units: (data["units"] as int?),
			side: (data["side"] as int?),
			timeOfDay: (data["timeOfDay"] as int?),
			eidReadingHour: (data["eidReadingHour"] as int?),
			override3rdPayerCode: (data["override3rdPayerCode"] as int?),
			transplantationCode: (data["transplantationCode"] as int?),
			prescriberNorm: (data["prescriberNorm"] as int?),
			percentNorm: (data["percentNorm"] as int?),
			derogationMaxNumber: (data["derogationMaxNumber"] as int?),
			locationService: (data["locationService"] as int?),
			insuranceJustification: (data["insuranceJustification"] as int?),
			cancelPatientInterventionReason: (data["cancelPatientInterventionReason"] as int?),
			id: (data["id"] as String?),
			dateCode: (data["dateCode"] as int?),
			logicalId: (data["logicalId"] as String?),
			label: (data["label"] as String?),
			userId: (data["userId"] as String?),
			contactId: (data["contactId"] as String?),
			serviceId: (data["serviceId"] as String?),
			tarificationId: (data["tarificationId"] as String?),
			code: (data["code"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			conventionAmount: (data["conventionAmount"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			error: (data["error"] as String?),
			contract: (data["contract"] as String?),
			contractDate: (data["contractDate"] as int?),
			eidReadingValue: (data["eidReadingValue"] as String?),
			override3rdPayerReason: (data["override3rdPayerReason"] as String?),
			prescriberNihii: (data["prescriberNihii"] as String?),
			relatedCode: (data["relatedCode"] as String?),
			prescriptionDate: (data["prescriptionDate"] as int?),
			prescriberSsin: (data["prescriberSsin"] as String?),
			prescriberLastName: (data["prescriberLastName"] as String?),
			prescriberFirstName: (data["prescriberFirstName"] as String?),
			prescriberCdHcParty: (data["prescriberCdHcParty"] as String?),
			locationNihii: (data["locationNihii"] as String?),
			locationCdHcParty: (data["locationCdHcParty"] as String?),
			admissionDate: (data["admissionDate"] as int?),
			canceled: (data["canceled"] as bool?),
			accepted: (data["accepted"] as bool?),
			pending: (data["pending"] as bool?),
			resent: (data["resent"] as bool?),
			archived: (data["archived"] as bool?),
			lost: (data["lost"] as bool?),
			status: (data["status"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
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
	@override int? dateCode = null;
	@override String? logicalId = null;
	@override String? label = null;
	@override String? userId = null;
	@override String? contactId = null;
	@override String? serviceId = null;
	@override String? tarificationId = null;
	@override String? code = null;
	@override PaymentType? paymentType = null;
	@override double? paid = null;
	@override double? totalAmount = null;
	@override double? reimbursement = null;
	@override double? patientIntervention = null;
	@override double? doctorSupplement = null;
	@override double? conventionAmount = null;
	@override double? vat = null;
	@override String? error = null;
	@override String? contract = null;
	@override int? contractDate = null;
	int? _units = null;
	@ActualInt32() @override int? get units => _units;
	@ActualInt32() @override set units(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('units value cannot exceed 2147483647');
		}
		_units = value;
	}
	int? _side = null;
	@ActualInt32() @override int? get side => _side;
	@ActualInt32() @override set side(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('side value cannot exceed 2147483647');
		}
		_side = value;
	}
	int? _timeOfDay = null;
	@ActualInt32() @override int? get timeOfDay => _timeOfDay;
	@ActualInt32() @override set timeOfDay(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('timeOfDay value cannot exceed 2147483647');
		}
		_timeOfDay = value;
	}
	int? _eidReadingHour = null;
	@ActualInt32() @override int? get eidReadingHour => _eidReadingHour;
	@ActualInt32() @override set eidReadingHour(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('eidReadingHour value cannot exceed 2147483647');
		}
		_eidReadingHour = value;
	}
	@override String? eidReadingValue = null;
	int? _override3rdPayerCode = null;
	@ActualInt32() @override int? get override3rdPayerCode => _override3rdPayerCode;
	@ActualInt32() @override set override3rdPayerCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('override3rdPayerCode value cannot exceed 2147483647');
		}
		_override3rdPayerCode = value;
	}
	@override String? override3rdPayerReason = null;
	int? _transplantationCode = null;
	@ActualInt32() @override int? get transplantationCode => _transplantationCode;
	@ActualInt32() @override set transplantationCode(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('transplantationCode value cannot exceed 2147483647');
		}
		_transplantationCode = value;
	}
	int? _prescriberNorm = null;
	@ActualInt32() @override int? get prescriberNorm => _prescriberNorm;
	@ActualInt32() @override set prescriberNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('prescriberNorm value cannot exceed 2147483647');
		}
		_prescriberNorm = value;
	}
	int? _percentNorm = null;
	@ActualInt32() @override int? get percentNorm => _percentNorm;
	@ActualInt32() @override set percentNorm(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('percentNorm value cannot exceed 2147483647');
		}
		_percentNorm = value;
	}
	@override String? prescriberNihii = null;
	@override String? relatedCode = null;
	@override int? prescriptionDate = null;
	int? _derogationMaxNumber = null;
	@ActualInt32() @override int? get derogationMaxNumber => _derogationMaxNumber;
	@ActualInt32() @override set derogationMaxNumber(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('derogationMaxNumber value cannot exceed 2147483647');
		}
		_derogationMaxNumber = value;
	}
	@override String? prescriberSsin = null;
	@override String? prescriberLastName = null;
	@override String? prescriberFirstName = null;
	@override String? prescriberCdHcParty = null;
	@override String? locationNihii = null;
	@override String? locationCdHcParty = null;
	int? _locationService = null;
	@ActualInt32() @override int? get locationService => _locationService;
	@ActualInt32() @override set locationService(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('locationService value cannot exceed 2147483647');
		}
		_locationService = value;
	}
	@override int? admissionDate = null;
	@override bool? canceled = null;
	@override bool? accepted = null;
	@override bool? pending = null;
	@override bool? resent = null;
	@override bool? archived = null;
	@override bool? lost = null;
	int? _insuranceJustification = null;
	@ActualInt32() @override int? get insuranceJustification => _insuranceJustification;
	@ActualInt32() @override set insuranceJustification(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('insuranceJustification value cannot exceed 2147483647');
		}
		_insuranceJustification = value;
	}
	int? _cancelPatientInterventionReason = null;
	@ActualInt32() @override int? get cancelPatientInterventionReason => _cancelPatientInterventionReason;
	@ActualInt32() @override set cancelPatientInterventionReason(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('cancelPatientInterventionReason value cannot exceed 2147483647');
		}
		_cancelPatientInterventionReason = value;
	}
	@override int? status = null;
	@override Base64String? encryptedSelf = null;
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
			int? dateCode,
			String? logicalId,
			String? label,
			String? userId,
			String? contactId,
			String? serviceId,
			String? tarificationId,
			String? code,
			PaymentType? paymentType,
			double? paid,
			double? totalAmount,
			double? reimbursement,
			double? patientIntervention,
			double? doctorSupplement,
			double? conventionAmount,
			double? vat,
			String? error,
			String? contract,
			int? contractDate,
			String? eidReadingValue,
			String? override3rdPayerReason,
			String? prescriberNihii,
			String? relatedCode,
			int? prescriptionDate,
			String? prescriberSsin,
			String? prescriberLastName,
			String? prescriberFirstName,
			String? prescriberCdHcParty,
			String? locationNihii,
			String? locationCdHcParty,
			int? admissionDate,
			bool? canceled,
			bool? accepted,
			bool? pending,
			bool? resent,
			bool? archived,
			bool? lost,
			int? status,
			Base64String? encryptedSelf
		}) : dateCode = dateCode ?? null,
		logicalId = logicalId ?? null,
		label = label ?? null,
		userId = userId ?? null,
		contactId = contactId ?? null,
		serviceId = serviceId ?? null,
		tarificationId = tarificationId ?? null,
		code = code ?? null,
		paymentType = paymentType ?? null,
		paid = paid ?? null,
		totalAmount = totalAmount ?? null,
		reimbursement = reimbursement ?? null,
		patientIntervention = patientIntervention ?? null,
		doctorSupplement = doctorSupplement ?? null,
		conventionAmount = conventionAmount ?? null,
		vat = vat ?? null,
		error = error ?? null,
		contract = contract ?? null,
		contractDate = contractDate ?? null,
		eidReadingValue = eidReadingValue ?? null,
		override3rdPayerReason = override3rdPayerReason ?? null,
		prescriberNihii = prescriberNihii ?? null,
		relatedCode = relatedCode ?? null,
		prescriptionDate = prescriptionDate ?? null,
		prescriberSsin = prescriberSsin ?? null,
		prescriberLastName = prescriberLastName ?? null,
		prescriberFirstName = prescriberFirstName ?? null,
		prescriberCdHcParty = prescriberCdHcParty ?? null,
		locationNihii = locationNihii ?? null,
		locationCdHcParty = locationCdHcParty ?? null,
		admissionDate = admissionDate ?? null,
		canceled = canceled ?? null,
		accepted = accepted ?? null,
		pending = pending ?? null,
		resent = resent ?? null,
		archived = archived ?? null,
		lost = lost ?? null,
		status = status ?? null,
		encryptedSelf = encryptedSelf ?? null,
		_units = units ?? null,
		_side = side ?? null,
		_timeOfDay = timeOfDay ?? null,
		_eidReadingHour = eidReadingHour ?? null,
		_override3rdPayerCode = override3rdPayerCode ?? null,
		_transplantationCode = transplantationCode ?? null,
		_prescriberNorm = prescriberNorm ?? null,
		_percentNorm = percentNorm ?? null,
		_derogationMaxNumber = derogationMaxNumber ?? null,
		_locationService = locationService ?? null,
		_insuranceJustification = insuranceJustification ?? null,
		_cancelPatientInterventionReason = cancelPatientInterventionReason ?? null;

	factory EncryptedInvoicingCode.fromJSON(Map<String, dynamic> data) {
		return EncryptedInvoicingCode(
			units: (data["units"] as int?),
			side: (data["side"] as int?),
			timeOfDay: (data["timeOfDay"] as int?),
			eidReadingHour: (data["eidReadingHour"] as int?),
			override3rdPayerCode: (data["override3rdPayerCode"] as int?),
			transplantationCode: (data["transplantationCode"] as int?),
			prescriberNorm: (data["prescriberNorm"] as int?),
			percentNorm: (data["percentNorm"] as int?),
			derogationMaxNumber: (data["derogationMaxNumber"] as int?),
			locationService: (data["locationService"] as int?),
			insuranceJustification: (data["insuranceJustification"] as int?),
			cancelPatientInterventionReason: (data["cancelPatientInterventionReason"] as int?),
			id: (data["id"] as String?),
			dateCode: (data["dateCode"] as int?),
			logicalId: (data["logicalId"] as String?),
			label: (data["label"] as String?),
			userId: (data["userId"] as String?),
			contactId: (data["contactId"] as String?),
			serviceId: (data["serviceId"] as String?),
			tarificationId: (data["tarificationId"] as String?),
			code: (data["code"] as String?),
			paymentType: data["paymentType"] == null ? null : PaymentType.fromJSON(data["paymentType"]),
			paid: (data["paid"] as num?)?.toDouble(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			conventionAmount: (data["conventionAmount"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			error: (data["error"] as String?),
			contract: (data["contract"] as String?),
			contractDate: (data["contractDate"] as int?),
			eidReadingValue: (data["eidReadingValue"] as String?),
			override3rdPayerReason: (data["override3rdPayerReason"] as String?),
			prescriberNihii: (data["prescriberNihii"] as String?),
			relatedCode: (data["relatedCode"] as String?),
			prescriptionDate: (data["prescriptionDate"] as int?),
			prescriberSsin: (data["prescriberSsin"] as String?),
			prescriberLastName: (data["prescriberLastName"] as String?),
			prescriberFirstName: (data["prescriberFirstName"] as String?),
			prescriberCdHcParty: (data["prescriberCdHcParty"] as String?),
			locationNihii: (data["locationNihii"] as String?),
			locationCdHcParty: (data["locationCdHcParty"] as String?),
			admissionDate: (data["admissionDate"] as int?),
			canceled: (data["canceled"] as bool?),
			accepted: (data["accepted"] as bool?),
			pending: (data["pending"] as bool?),
			resent: (data["resent"] as bool?),
			archived: (data["archived"] as bool?),
			lost: (data["lost"] as bool?),
			status: (data["status"] as int?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
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