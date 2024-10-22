// This file is auto-generated
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
	@override bool? hospitalisation;
	@override bool? ambulatory;
	@override bool? dental;
	@override String? identificationNumber;
	@override String? insuranceId;
	@override int? startDate;
	@override int? endDate;
	@override String? titularyId;
	@override Base64String? encryptedSelf;
	DecryptedInsurability({
			this.hospitalisation,
			this.ambulatory,
			this.dental,
			this.identificationNumber,
			this.insuranceId,
			this.startDate,
			this.endDate,
			this.titularyId,
			this.encryptedSelf,
			Map<String, String>? parameters
		}) : parameters = parameters ?? {};

	factory DecryptedInsurability.fromJSON(Map<String, dynamic> data) {
		return DecryptedInsurability(
			parameters: data["parameters"].map((k0, v0) => MapEntry(k0, v0)),
			hospitalisation: data["hospitalisation"],
			ambulatory: data["ambulatory"],
			dental: data["dental"],
			identificationNumber: data["identificationNumber"],
			insuranceId: data["insuranceId"],
			startDate: data["startDate"],
			endDate: data["endDate"],
			titularyId: data["titularyId"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

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
}

class EncryptedInsurability implements Insurability {
	@override Map<String, String> parameters = {};
	@override bool? hospitalisation;
	@override bool? ambulatory;
	@override bool? dental;
	@override String? identificationNumber;
	@override String? insuranceId;
	@override int? startDate;
	@override int? endDate;
	@override String? titularyId;
	@override Base64String? encryptedSelf;
	EncryptedInsurability({
			this.hospitalisation,
			this.ambulatory,
			this.dental,
			this.identificationNumber,
			this.insuranceId,
			this.startDate,
			this.endDate,
			this.titularyId,
			this.encryptedSelf,
			Map<String, String>? parameters
		}) : parameters = parameters ?? {};

	factory EncryptedInsurability.fromJSON(Map<String, dynamic> data) {
		return EncryptedInsurability(
			parameters: data["parameters"].map((k0, v0) => MapEntry(k0, v0)),
			hospitalisation: data["hospitalisation"],
			ambulatory: data["ambulatory"],
			dental: data["dental"],
			identificationNumber: data["identificationNumber"],
			insuranceId: data["insuranceId"],
			startDate: data["startDate"],
			endDate: data["endDate"],
			titularyId: data["titularyId"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

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
}