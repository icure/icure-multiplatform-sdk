// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/insurability.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Insurability implements Encryptable {
	abstract Map<String, String> parameters;
	abstract bool? hospitalisation;
	abstract bool? ambulatory;
	abstract bool? dental;
	abstract String? identificationNumber;
	abstract String? insuranceId;
	abstract int? startDate;
	abstract int? endDate;
	abstract String? titularyId;
	@override abstract Base64String? encryptedSelf;

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

class DecryptedInsurability implements Insurability {
	@override Map<String, String> parameters = {};
	@override bool? hospitalisation = null;
	@override bool? ambulatory = null;
	@override bool? dental = null;
	@override String? identificationNumber = null;
	@override String? insuranceId = null;
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? titularyId = null;
	@override Base64String? encryptedSelf = null;
	DecryptedInsurability({
			Map<String, String>? parameters,
			bool? hospitalisation,
			bool? ambulatory,
			bool? dental,
			String? identificationNumber,
			String? insuranceId,
			int? startDate,
			int? endDate,
			String? titularyId,
			Base64String? encryptedSelf
		}) : parameters = parameters ?? {},
		hospitalisation = hospitalisation ?? null,
		ambulatory = ambulatory ?? null,
		dental = dental ?? null,
		identificationNumber = identificationNumber ?? null,
		insuranceId = insuranceId ?? null,
		startDate = startDate ?? null,
		endDate = endDate ?? null,
		titularyId = titularyId ?? null,
		encryptedSelf = encryptedSelf ?? null;

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

class EncryptedInsurability implements Insurability {
	@override Map<String, String> parameters = {};
	@override bool? hospitalisation = null;
	@override bool? ambulatory = null;
	@override bool? dental = null;
	@override String? identificationNumber = null;
	@override String? insuranceId = null;
	@override int? startDate = null;
	@override int? endDate = null;
	@override String? titularyId = null;
	@override Base64String? encryptedSelf = null;
	EncryptedInsurability({
			Map<String, String>? parameters,
			bool? hospitalisation,
			bool? ambulatory,
			bool? dental,
			String? identificationNumber,
			String? insuranceId,
			int? startDate,
			int? endDate,
			String? titularyId,
			Base64String? encryptedSelf
		}) : parameters = parameters ?? {},
		hospitalisation = hospitalisation ?? null,
		ambulatory = ambulatory ?? null,
		dental = dental ?? null,
		identificationNumber = identificationNumber ?? null,
		insuranceId = insuranceId ?? null,
		startDate = startDate ?? null,
		endDate = endDate ?? null,
		titularyId = titularyId ?? null,
		encryptedSelf = encryptedSelf ?? null;

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