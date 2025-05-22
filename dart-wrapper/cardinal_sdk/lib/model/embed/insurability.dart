// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/insurability.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "insurability.freezed.dart";


sealed class Insurability implements Encryptable {
	abstract final Map<String, String> parameters;
	abstract final bool? hospitalisation;
	abstract final bool? ambulatory;
	abstract final bool? dental;
	abstract final String? identificationNumber;
	abstract final String? insuranceId;
	abstract final int? startDate;
	abstract final int? endDate;
	abstract final String? titularyId;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(Insurability value) {
		switch (value) {
			case DecryptedInsurability entity:
				Map<String, dynamic> entityJson = DecryptedInsurability.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedInsurability";
				return entityJson;
			case EncryptedInsurability entity:
				Map<String, dynamic> entityJson = EncryptedInsurability.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedInsurability";
				return entityJson;
		}
	}

	static Insurability fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedInsurability":
				return DecryptedInsurability.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedInsurability":
				return EncryptedInsurability.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedInsurability with _$DecryptedInsurability implements Insurability {
	const factory DecryptedInsurability({
		@Default({}) Map<String, String> parameters,
		@Default(null) bool? hospitalisation,
		@Default(null) bool? ambulatory,
		@Default(null) bool? dental,
		@Default(null) String? identificationNumber,
		@Default(null) String? insuranceId,
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? titularyId,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedInsurability;


	static Map<String, dynamic> encode(DecryptedInsurability value) {
		Map<String, dynamic> entityAsMap = {
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0)),
			"hospitalisation" : value.hospitalisation,
			"ambulatory" : value.ambulatory,
			"dental" : value.dental,
			"identificationNumber" : value.identificationNumber,
			"insuranceId" : value.insuranceId,
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"titularyId" : value.titularyId,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedInsurability fromJSON(Map<String, dynamic> data) {
		return DecryptedInsurability(
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			hospitalisation: (data["hospitalisation"] as bool?),
			ambulatory: (data["ambulatory"] as bool?),
			dental: (data["dental"] as bool?),
			identificationNumber: (data["identificationNumber"] as String?),
			insuranceId: (data["insuranceId"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			titularyId: (data["titularyId"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedInsurability with _$EncryptedInsurability implements Insurability {
	const factory EncryptedInsurability({
		@Default({}) Map<String, String> parameters,
		@Default(null) bool? hospitalisation,
		@Default(null) bool? ambulatory,
		@Default(null) bool? dental,
		@Default(null) String? identificationNumber,
		@Default(null) String? insuranceId,
		@Default(null) int? startDate,
		@Default(null) int? endDate,
		@Default(null) String? titularyId,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedInsurability;


	static Map<String, dynamic> encode(EncryptedInsurability value) {
		Map<String, dynamic> entityAsMap = {
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0)),
			"hospitalisation" : value.hospitalisation,
			"ambulatory" : value.ambulatory,
			"dental" : value.dental,
			"identificationNumber" : value.identificationNumber,
			"insuranceId" : value.insuranceId,
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"titularyId" : value.titularyId,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedInsurability fromJSON(Map<String, dynamic> data) {
		return EncryptedInsurability(
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			hospitalisation: (data["hospitalisation"] as bool?),
			ambulatory: (data["ambulatory"] as bool?),
			dental: (data["dental"] as bool?),
			identificationNumber: (data["identificationNumber"] as String?),
			insuranceId: (data["insuranceId"] as String?),
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			titularyId: (data["titularyId"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}