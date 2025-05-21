// auto-generated file
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/typed_value.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "typed_value.freezed.dart";


sealed class TypedValue implements Encryptable {
	abstract final TypedValuesType? type;
	abstract final bool? booleanValue;
	abstract final int? integerValue;
	abstract final double? doubleValue;
	abstract final String? stringValue;
	abstract final DateTime? dateValue;
	@override abstract final Base64String? encryptedSelf;

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

@freezed
abstract class DecryptedTypedValue with _$DecryptedTypedValue implements TypedValue {
	const factory DecryptedTypedValue({
		@Default(null) TypedValuesType? type,
		@Default(null) bool? booleanValue,
		@Default(null) int? integerValue,
		@Default(null) double? doubleValue,
		@Default(null) String? stringValue,
		@Default(null) DateTime? dateValue,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedTypedValue;


	static Map<String, dynamic> encode(DecryptedTypedValue value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!),
			"booleanValue" : value.booleanValue,
			"integerValue" : value.integerValue,
			"doubleValue" : value.doubleValue,
			"stringValue" : value.stringValue,
			"dateValue" : value.dateValue?.millisecondsSinceEpoch,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedTypedValue fromJSON(Map<String, dynamic> data) {
		return DecryptedTypedValue(
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"]),
			booleanValue: (data["booleanValue"] as bool?),
			integerValue: (data["integerValue"] as int?),
			doubleValue: (data["doubleValue"] as num?)?.toDouble(),
			stringValue: (data["stringValue"] as String?),
			dateValue: data["dateValue"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["dateValue"] as int),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class EncryptedTypedValue with _$EncryptedTypedValue implements TypedValue {
	const factory EncryptedTypedValue({
		@Default(null) TypedValuesType? type,
		@Default(null) bool? booleanValue,
		@Default(null) int? integerValue,
		@Default(null) double? doubleValue,
		@Default(null) String? stringValue,
		@Default(null) DateTime? dateValue,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedTypedValue;


	static Map<String, dynamic> encode(EncryptedTypedValue value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!),
			"booleanValue" : value.booleanValue,
			"integerValue" : value.integerValue,
			"doubleValue" : value.doubleValue,
			"stringValue" : value.stringValue,
			"dateValue" : value.dateValue?.millisecondsSinceEpoch,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedTypedValue fromJSON(Map<String, dynamic> data) {
		return EncryptedTypedValue(
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"]),
			booleanValue: (data["booleanValue"] as bool?),
			integerValue: (data["integerValue"] as int?),
			doubleValue: (data["doubleValue"] as num?)?.toDouble(),
			stringValue: (data["stringValue"] as String?),
			dateValue: data["dateValue"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["dateValue"] as int),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}