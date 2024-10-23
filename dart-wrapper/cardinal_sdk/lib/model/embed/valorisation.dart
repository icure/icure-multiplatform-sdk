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
	@override int? startOfValidity;
	@override int? endOfValidity;
	@override String? predicate;
	@override List<int>? reference;
	@override double? totalAmount;
	@override double? reimbursement;
	@override double? patientIntervention;
	@override double? doctorSupplement;
	@override double? vat;
	@override Map<String, String>? label = {};
	@override Base64String? encryptedSelf;
	EncryptedValorisation({
			this.startOfValidity,
			this.endOfValidity,
			this.predicate,
			this.reference,
			this.totalAmount,
			this.reimbursement,
			this.patientIntervention,
			this.doctorSupplement,
			this.vat,
			this.encryptedSelf,
			Map<String, String>? label
		}) : label = label ?? {};

	factory EncryptedValorisation.fromJSON(Map<String, dynamic> data) {
		return EncryptedValorisation(
			startOfValidity: data["startOfValidity"],
			endOfValidity: data["endOfValidity"],
			predicate: data["predicate"],
			reference: data["reference"]?.map((x0) => x0 ),
			totalAmount: data["totalAmount"],
			reimbursement: data["reimbursement"],
			patientIntervention: data["patientIntervention"],
			doctorSupplement: data["doctorSupplement"],
			vat: data["vat"],
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0)),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedValorisation value) {
		Map<String, dynamic> entityAsMap = {
			"startOfValidity" : value.startOfValidity,
			"endOfValidity" : value.endOfValidity,
			"predicate" : value.predicate,
			"reference" : value.reference?.map((x0) => x0),
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
}

class DecryptedValorisation implements Valorisation {
	@override int? startOfValidity;
	@override int? endOfValidity;
	@override String? predicate;
	@override List<int>? reference;
	@override double? totalAmount;
	@override double? reimbursement;
	@override double? patientIntervention;
	@override double? doctorSupplement;
	@override double? vat;
	@override Map<String, String>? label = {};
	@override Base64String? encryptedSelf;
	DecryptedValorisation({
			this.startOfValidity,
			this.endOfValidity,
			this.predicate,
			this.reference,
			this.totalAmount,
			this.reimbursement,
			this.patientIntervention,
			this.doctorSupplement,
			this.vat,
			this.encryptedSelf,
			Map<String, String>? label
		}) : label = label ?? {};

	factory DecryptedValorisation.fromJSON(Map<String, dynamic> data) {
		return DecryptedValorisation(
			startOfValidity: data["startOfValidity"],
			endOfValidity: data["endOfValidity"],
			predicate: data["predicate"],
			reference: data["reference"]?.map((x0) => x0 ),
			totalAmount: data["totalAmount"],
			reimbursement: data["reimbursement"],
			patientIntervention: data["patientIntervention"],
			doctorSupplement: data["doctorSupplement"],
			vat: data["vat"],
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0)),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedValorisation value) {
		Map<String, dynamic> entityAsMap = {
			"startOfValidity" : value.startOfValidity,
			"endOfValidity" : value.endOfValidity,
			"predicate" : value.predicate,
			"reference" : value.reference?.map((x0) => x0),
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
}