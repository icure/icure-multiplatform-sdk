// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/valorisation.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "valorisation.freezed.dart";


sealed class Valorisation implements Encryptable {
	abstract final int? startOfValidity;
	abstract final int? endOfValidity;
	abstract final String? predicate;
	abstract final List<int>? reference;
	abstract final double? totalAmount;
	abstract final double? reimbursement;
	abstract final double? patientIntervention;
	abstract final double? doctorSupplement;
	abstract final double? vat;
	abstract final Map<String, String>? label;
	@override abstract final Base64String? encryptedSelf;

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

@freezed
abstract class EncryptedValorisation with _$EncryptedValorisation implements Valorisation {
	const factory EncryptedValorisation({
		@Default(null) int? startOfValidity,
		@Default(null) int? endOfValidity,
		@Default(null) String? predicate,
		@Default(null) List<int>? reference,
		@Default(null) double? totalAmount,
		@Default(null) double? reimbursement,
		@Default(null) double? patientIntervention,
		@Default(null) double? doctorSupplement,
		@Default(null) double? vat,
		@Default({}) Map<String, String>? label,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedValorisation;


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

@freezed
abstract class DecryptedValorisation with _$DecryptedValorisation implements Valorisation {
	const factory DecryptedValorisation({
		@Default(null) int? startOfValidity,
		@Default(null) int? endOfValidity,
		@Default(null) String? predicate,
		@Default(null) List<int>? reference,
		@Default(null) double? totalAmount,
		@Default(null) double? reimbursement,
		@Default(null) double? patientIntervention,
		@Default(null) double? doctorSupplement,
		@Default(null) double? vat,
		@Default({}) Map<String, String>? label,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedValorisation;


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