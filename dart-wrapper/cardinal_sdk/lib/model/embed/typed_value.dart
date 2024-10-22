// This file is auto-generated
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/typed_value.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class TypedValue implements Encryptable {
	abstract TypedValuesType? type;
	abstract bool? booleanValue;
	abstract int? integerValue;
	abstract double? doubleValue;
	abstract String? stringValue;
	abstract DateTime? dateValue;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(TypedValue value) {
		switch (value) {
			case DecryptedTypedValue entity:
				Map<String, dynamic> entityJson = DecryptedTypedValue.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedTypedValue";
				return entityJson;
			case EncryptedTypedValue entity:
				Map<String, dynamic> entityJson = EncryptedTypedValue.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedTypedValue";
				return entityJson;
		}
	}

	static TypedValue fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedTypedValue":
				return DecryptedTypedValue.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedTypedValue":
				return EncryptedTypedValue.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedTypedValue implements TypedValue {
	@override TypedValuesType? type;
	@override bool? booleanValue;
	@override int? integerValue;
	@override double? doubleValue;
	@override String? stringValue;
	@override DateTime? dateValue;
	@override Base64String? encryptedSelf;
	DecryptedTypedValue({
			this.type,
			this.booleanValue,
			this.integerValue,
			this.doubleValue,
			this.stringValue,
			this.dateValue,
			this.encryptedSelf
		});

	factory DecryptedTypedValue.fromJSON(Map<String, dynamic> data) {
		return DecryptedTypedValue(
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"]),
			booleanValue: data["booleanValue"],
			integerValue: data["integerValue"],
			doubleValue: data["doubleValue"],
			stringValue: data["stringValue"],
			dateValue: data["dateValue"] == null ? null : DateTime.parse(data["dateValue"] as String),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedTypedValue value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!),
			"booleanValue" : value.booleanValue,
			"integerValue" : value.integerValue,
			"doubleValue" : value.doubleValue,
			"stringValue" : value.stringValue,
			"dateValue" : value.dateValue?.toIso8601String(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class EncryptedTypedValue implements TypedValue {
	@override TypedValuesType? type;
	@override bool? booleanValue;
	@override int? integerValue;
	@override double? doubleValue;
	@override String? stringValue;
	@override DateTime? dateValue;
	@override Base64String? encryptedSelf;
	EncryptedTypedValue({
			this.type,
			this.booleanValue,
			this.integerValue,
			this.doubleValue,
			this.stringValue,
			this.dateValue,
			this.encryptedSelf
		});

	factory EncryptedTypedValue.fromJSON(Map<String, dynamic> data) {
		return EncryptedTypedValue(
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"]),
			booleanValue: data["booleanValue"],
			integerValue: data["integerValue"],
			doubleValue: data["doubleValue"],
			stringValue: data["stringValue"],
			dateValue: data["dateValue"] == null ? null : DateTime.parse(data["dateValue"] as String),
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedTypedValue value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!),
			"booleanValue" : value.booleanValue,
			"integerValue" : value.integerValue,
			"doubleValue" : value.doubleValue,
			"stringValue" : value.stringValue,
			"dateValue" : value.dateValue?.toIso8601String(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}