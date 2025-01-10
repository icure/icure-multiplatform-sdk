// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/valorisation.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Valorisation implements Encryptable {
	abstract int? startOfValidity;
	abstract int? endOfValidity;
	abstract String? predicate;
	abstract List<int>? reference;
	abstract double? totalAmount;
	abstract double? reimbursement;
	abstract double? patientIntervention;
	abstract double? doctorSupplement;
	abstract double? vat;
	abstract Map<String, String>? label;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(Valorisation value) {
		switch (value) {
			case EncryptedValorisation entity:
				Map<String, dynamic> entityJson = EncryptedValorisation.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedValorisation";
				return entityJson;
			case DecryptedValorisation entity:
				Map<String, dynamic> entityJson = DecryptedValorisation.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedValorisation";
				return entityJson;
		}
	}

	static Valorisation fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedValorisation":
				return EncryptedValorisation.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedValorisation":
				return DecryptedValorisation.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedValorisation implements Valorisation {
	@override int? startOfValidity = null;
	@override int? endOfValidity = null;
	@override String? predicate = null;
	@override List<int>? reference = null;
	@override double? totalAmount = null;
	@override double? reimbursement = null;
	@override double? patientIntervention = null;
	@override double? doctorSupplement = null;
	@override double? vat = null;
	@override Map<String, String>? label = {};
	@override Base64String? encryptedSelf = null;
	EncryptedValorisation({
			int? startOfValidity,
			int? endOfValidity,
			String? predicate,
			List<int>? reference,
			double? totalAmount,
			double? reimbursement,
			double? patientIntervention,
			double? doctorSupplement,
			double? vat,
			Map<String, String>? label,
			Base64String? encryptedSelf
		}) : startOfValidity = startOfValidity ?? null,
		endOfValidity = endOfValidity ?? null,
		predicate = predicate ?? null,
		reference = reference ?? null,
		totalAmount = totalAmount ?? null,
		reimbursement = reimbursement ?? null,
		patientIntervention = patientIntervention ?? null,
		doctorSupplement = doctorSupplement ?? null,
		vat = vat ?? null,
		label = label ?? {},
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(EncryptedValorisation value) {
		Map<String, dynamic> entityAsMap = {
			"startOfValidity" : value.startOfValidity,
			"endOfValidity" : value.endOfValidity,
			"predicate" : value.predicate,
			"reference" : value.reference?.map((x0) => x0).toList(),
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"vat" : value.vat,
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedValorisation fromJSON(Map<String, dynamic> data) {
		return EncryptedValorisation(
			startOfValidity: (data["startOfValidity"] as int?),
			endOfValidity: (data["endOfValidity"] as int?),
			predicate: (data["predicate"] as String?),
			reference: (data["reference"] as List<dynamic>?)?.map((x0) => (x0 as int) ).toList(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

class DecryptedValorisation implements Valorisation {
	@override int? startOfValidity = null;
	@override int? endOfValidity = null;
	@override String? predicate = null;
	@override List<int>? reference = null;
	@override double? totalAmount = null;
	@override double? reimbursement = null;
	@override double? patientIntervention = null;
	@override double? doctorSupplement = null;
	@override double? vat = null;
	@override Map<String, String>? label = {};
	@override Base64String? encryptedSelf = null;
	DecryptedValorisation({
			int? startOfValidity,
			int? endOfValidity,
			String? predicate,
			List<int>? reference,
			double? totalAmount,
			double? reimbursement,
			double? patientIntervention,
			double? doctorSupplement,
			double? vat,
			Map<String, String>? label,
			Base64String? encryptedSelf
		}) : startOfValidity = startOfValidity ?? null,
		endOfValidity = endOfValidity ?? null,
		predicate = predicate ?? null,
		reference = reference ?? null,
		totalAmount = totalAmount ?? null,
		reimbursement = reimbursement ?? null,
		patientIntervention = patientIntervention ?? null,
		doctorSupplement = doctorSupplement ?? null,
		vat = vat ?? null,
		label = label ?? {},
		encryptedSelf = encryptedSelf ?? null;

	static Map<String, dynamic> encode(DecryptedValorisation value) {
		Map<String, dynamic> entityAsMap = {
			"startOfValidity" : value.startOfValidity,
			"endOfValidity" : value.endOfValidity,
			"predicate" : value.predicate,
			"reference" : value.reference?.map((x0) => x0).toList(),
			"totalAmount" : value.totalAmount,
			"reimbursement" : value.reimbursement,
			"patientIntervention" : value.patientIntervention,
			"doctorSupplement" : value.doctorSupplement,
			"vat" : value.vat,
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedValorisation fromJSON(Map<String, dynamic> data) {
		return DecryptedValorisation(
			startOfValidity: (data["startOfValidity"] as int?),
			endOfValidity: (data["endOfValidity"] as int?),
			predicate: (data["predicate"] as String?),
			reference: (data["reference"] as List<dynamic>?)?.map((x0) => (x0 as int) ).toList(),
			totalAmount: (data["totalAmount"] as num?)?.toDouble(),
			reimbursement: (data["reimbursement"] as num?)?.toDouble(),
			patientIntervention: (data["patientIntervention"] as num?)?.toDouble(),
			doctorSupplement: (data["doctorSupplement"] as num?)?.toDouble(),
			vat: (data["vat"] as num?)?.toDouble(),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}