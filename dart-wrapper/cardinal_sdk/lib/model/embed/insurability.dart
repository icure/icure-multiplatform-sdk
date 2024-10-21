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
}

class DecryptedInsurability implements Insurability {
	@override  Map<String, String> parameters = {};
	@override  bool? hospitalisation;
	@override  bool? ambulatory;
	@override  bool? dental;
	@override  String? identificationNumber;
	@override  String? insuranceId;
	@override  int? startDate;
	@override  int? endDate;
	@override  String? titularyId;
	@override  Base64String? encryptedSelf;

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
	@override  Map<String, String> parameters = {};
	@override  bool? hospitalisation;
	@override  bool? ambulatory;
	@override  bool? dental;
	@override  String? identificationNumber;
	@override  String? insuranceId;
	@override  int? startDate;
	@override  int? endDate;
	@override  String? titularyId;
	@override  Base64String? encryptedSelf;

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