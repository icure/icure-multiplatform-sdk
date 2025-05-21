// auto-generated file
import 'package:cardinal_sdk/crypto/entities/recovery_key_size.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';
part "recovery_key_options.freezed.dart";


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

@freezed
abstract class RecoveryKeyOptionsGenerate with _$RecoveryKeyOptionsGenerate implements RecoveryKeyOptions {
	const factory RecoveryKeyOptionsGenerate({
		required RecoveryKeySize recoveryKeySize,
	}) = _RecoveryKeyOptionsGenerate;


	static Map<String, dynamic> encode(RecoveryKeyOptionsGenerate value) {
		Map<String, dynamic> entityAsMap = {
			"recoveryKeySize" : RecoveryKeySize.encode(value.recoveryKeySize)
		};
		return entityAsMap;
	}

	static RecoveryKeyOptionsGenerate fromJSON(Map<String, dynamic> data) {
		return RecoveryKeyOptionsGenerate(
			recoveryKeySize: RecoveryKeySize.fromJSON(data["recoveryKeySize"])
		);
	}
}

@freezed
abstract class RecoveryKeyOptionsUse with _$RecoveryKeyOptionsUse implements RecoveryKeyOptions {
	const factory RecoveryKeyOptionsUse({
		required RecoveryDataKey key,
	}) = _RecoveryKeyOptionsUse;


	static Map<String, dynamic> encode(RecoveryKeyOptionsUse value) {
		Map<String, dynamic> entityAsMap = {
			"key" : RecoveryDataKey.encode(value.key)
		};
		return entityAsMap;
	}

	static RecoveryKeyOptionsUse fromJSON(Map<String, dynamic> data) {
		return RecoveryKeyOptionsUse(
			key: RecoveryDataKey.fromJSON(data["key"])
		);
	}
}