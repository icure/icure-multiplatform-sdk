// auto-generated file
import 'package:cardinal_sdk/model/embed/telecom_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/telecom.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Telecom implements Encryptable {
	abstract TelecomType? telecomType;
	abstract String? telecomNumber;
	abstract String? telecomDescription;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(Telecom value) {
		switch (value) {
			case EncryptedTelecom entity:
				Map<String, dynamic> entityJson = EncryptedTelecom.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedTelecom";
				return entityJson;
			case DecryptedTelecom entity:
				Map<String, dynamic> entityJson = DecryptedTelecom.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedTelecom";
				return entityJson;
		}
	}

	static Telecom fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedTelecom":
				return EncryptedTelecom.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedTelecom":
				return DecryptedTelecom.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedTelecom implements Telecom {
	@override TelecomType? telecomType = null;
	@override String? telecomNumber = null;
	@override String? telecomDescription = null;
	@override Base64String? encryptedSelf = null;
	EncryptedTelecom({
			TelecomType? telecomType,
			String? telecomNumber,
			String? telecomDescription,
			Base64String? encryptedSelf
		}) : telecomType = telecomType ?? null,
		telecomNumber = telecomNumber ?? null,
		telecomDescription = telecomDescription ?? null,
		encryptedSelf = encryptedSelf ?? null;

	factory EncryptedTelecom.fromJSON(Map<String, dynamic> data) {
		return EncryptedTelecom(
			telecomType: data["telecomType"] == null ? null : TelecomType.fromJSON(data["telecomType"]),
			telecomNumber: (data["telecomNumber"] as String?),
			telecomDescription: (data["telecomDescription"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}

	static Map<String, dynamic> encode(EncryptedTelecom value) {
		Map<String, dynamic> entityAsMap = {
			"telecomType" : value.telecomType == null ? null : TelecomType.encode(value.telecomType!),
			"telecomNumber" : value.telecomNumber,
			"telecomDescription" : value.telecomDescription,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedTelecom implements Telecom {
	@override TelecomType? telecomType = null;
	@override String? telecomNumber = null;
	@override String? telecomDescription = null;
	@override Base64String? encryptedSelf = null;
	DecryptedTelecom({
			TelecomType? telecomType,
			String? telecomNumber,
			String? telecomDescription,
			Base64String? encryptedSelf
		}) : telecomType = telecomType ?? null,
		telecomNumber = telecomNumber ?? null,
		telecomDescription = telecomDescription ?? null,
		encryptedSelf = encryptedSelf ?? null;

	factory DecryptedTelecom.fromJSON(Map<String, dynamic> data) {
		return DecryptedTelecom(
			telecomType: data["telecomType"] == null ? null : TelecomType.fromJSON(data["telecomType"]),
			telecomNumber: (data["telecomNumber"] as String?),
			telecomDescription: (data["telecomDescription"] as String?),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}

	static Map<String, dynamic> encode(DecryptedTelecom value) {
		Map<String, dynamic> entityAsMap = {
			"telecomType" : value.telecomType == null ? null : TelecomType.encode(value.telecomType!),
			"telecomNumber" : value.telecomNumber,
			"telecomDescription" : value.telecomDescription,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}