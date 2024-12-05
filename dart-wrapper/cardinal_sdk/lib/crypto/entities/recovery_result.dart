// auto-generated file
import 'package:cardinal_sdk/crypto/entities/recovery_data_use_failure_reason.dart';


sealed class RecoveryResult<T> {
	abstract bool isSuccess;
	T get value;

	static Map<String, dynamic> encode(RecoveryResult value) {
		switch (value) {
			case RecoveryResultSuccess entity:
				Map<String, dynamic> entityJson = RecoveryResultSuccess.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success";
				return entityJson;
			case RecoveryResultFailure entity:
				Map<String, dynamic> entityJson = RecoveryResultFailure.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure";
				return entityJson;
		}
	}

	static RecoveryResult fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success":
				return RecoveryResultSuccess.fromJSON(data);
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure":
				return RecoveryResultFailure.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class RecoveryResultSuccess<T> implements RecoveryResult {
	T data;
	RecoveryResultSuccess(this.data);

	static Map<String, dynamic> encode<T>(RecoveryResultSuccess<T> value, dynamic Function(T)  encodeT) {
		Map<String, dynamic> entityAsMap = {
			"data" : encodeT(value.data)
		};
		return entityAsMap;
	}

	static RecoveryResultSuccess<T> fromJSON<T>(Map<String, dynamic> data, T Function(dynamic)  decodeT) {
		return RecoveryResultSuccess(
			decodeT(data["data"])
		);
	}
}

class RecoveryResultFailure implements RecoveryResult {
	RecoveryDataUseFailureReason reason;
	RecoveryResultFailure(this.reason);

	static Map<String, dynamic> encode(RecoveryResultFailure value) {
		Map<String, dynamic> entityAsMap = {
			"reason" : RecoveryDataUseFailureReason.encode(value.reason)
		};
		return entityAsMap;
	}

	static RecoveryResultFailure fromJSON(Map<String, dynamic> data) {
		return RecoveryResultFailure(
			RecoveryDataUseFailureReason.fromJSON(data["reason"])
		);
	}
}