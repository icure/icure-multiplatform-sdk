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
	@override TelecomType? telecomType;
	@override String? telecomNumber;
	@override String? telecomDescription;
	@override Base64String? encryptedSelf;
	EncryptedTelecom({
			this.telecomType,
			this.telecomNumber,
			this.telecomDescription,
			this.encryptedSelf
		});

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
	@override TelecomType? telecomType;
	@override String? telecomNumber;
	@override String? telecomDescription;
	@override Base64String? encryptedSelf;
	DecryptedTelecom({
			this.telecomType,
			this.telecomNumber,
			this.telecomDescription,
			this.encryptedSelf
		});

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