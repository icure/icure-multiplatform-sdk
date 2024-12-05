// auto-generated file
import 'package:cardinal_sdk/crypto/entities/recovery_key_size.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';


sealed class RecoveryKeyOptions {

	static Map<String, dynamic> encode(RecoveryKeyOptions value) {
		switch (value) {
			case RecoveryKeyOptionsGenerate entity:
				Map<String, dynamic> entityJson = RecoveryKeyOptionsGenerate.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate";
				return entityJson;
			case RecoveryKeyOptionsUse entity:
				Map<String, dynamic> entityJson = RecoveryKeyOptionsUse.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use";
				return entityJson;
		}
	}

	static RecoveryKeyOptions fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Generate":
				return RecoveryKeyOptionsGenerate.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryKeyOptions.Use":
				return RecoveryKeyOptionsUse.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class RecoveryKeyOptionsGenerate implements RecoveryKeyOptions {
	RecoveryKeySize recoveryKeySize;
	RecoveryKeyOptionsGenerate(this.recoveryKeySize);

	static Map<String, dynamic> encode(RecoveryKeyOptionsGenerate value) {
		Map<String, dynamic> entityAsMap = {
			"recoveryKeySize" : RecoveryKeySize.encode(value.recoveryKeySize)
		};
		return entityAsMap;
	}

	static RecoveryKeyOptionsGenerate fromJSON(Map<String, dynamic> data) {
		return RecoveryKeyOptionsGenerate(
			RecoveryKeySize.fromJSON(data["recoveryKeySize"])
		);
	}
}

class RecoveryKeyOptionsUse implements RecoveryKeyOptions {
	RecoveryDataKey key;
	RecoveryKeyOptionsUse(this.key);

	static Map<String, dynamic> encode(RecoveryKeyOptionsUse value) {
		Map<String, dynamic> entityAsMap = {
			"key" : RecoveryDataKey.encode(value.key)
		};
		return entityAsMap;
	}

	static RecoveryKeyOptionsUse fromJSON(Map<String, dynamic> data) {
		return RecoveryKeyOptionsUse(
			RecoveryDataKey.fromJSON(data["key"])
		);
	}
}