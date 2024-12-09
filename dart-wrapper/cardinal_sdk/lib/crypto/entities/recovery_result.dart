import 'package:cardinal_sdk/crypto/entities/recovery_data_use_failure_reason.dart';


sealed class RecoveryResult<T> {
	bool get isSuccess;
	T get value;

	static Map<String, dynamic> encode<T>(RecoveryResult<T> value, dynamic Function(T)  encodeT) {
		switch (value) {
			case RecoveryResultSuccess entity:
				Map<String, dynamic> entityJson = RecoveryResultSuccess.encode(entity as RecoveryResultSuccess<T>, encodeT);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success";
				return entityJson;
			case RecoveryResultFailure entity:
				Map<String, dynamic> entityJson = RecoveryResultFailure.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure";
				return entityJson;
		}
	}

	static RecoveryResult<T> fromJSON<T>(Map<String, dynamic> data, T Function(dynamic) decodeT) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Success":
				return RecoveryResultSuccess.fromJSON(data, decodeT);
			case "com.icure.cardinal.sdk.crypto.entities.RecoveryResult.Failure":
				return RecoveryResultFailure.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class RecoveryResultSuccess<T> implements RecoveryResult<T> {
	T _data;
	RecoveryResultSuccess(this._data);

	static Map<String, dynamic> encode<T>(RecoveryResultSuccess<T> value, dynamic Function(T)  encodeT) {
		Map<String, dynamic> entityAsMap = {
			"data" : encodeT(value._data)
		};
		return entityAsMap;
	}

	static RecoveryResultSuccess<T> fromJSON<T>(Map<String, dynamic> data, T Function(dynamic)  decodeT) {
		return RecoveryResultSuccess(
			decodeT(data["data"])
		);
	}

  @override
  get isSuccess => true;

  @override
  get value => this._data;
}

class RecoveryResultFailure implements RecoveryResult<Never> {
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

	@override
	get isSuccess => false;

	@override
	get value => throw UnsupportedError("Failure result does not have a value");
}