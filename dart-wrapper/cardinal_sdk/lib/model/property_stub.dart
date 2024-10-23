// auto-generated file
import 'package:cardinal_sdk/model/property_type_stub.dart';
import 'package:cardinal_sdk/model/embed/typed_value.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class PropertyStub implements Encryptable {
	abstract String? id;
	abstract PropertyTypeStub? type;
	TypedValue? get typedValue;
	@Deprecated('Remove from list instead') abstract int? deletionDate;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(PropertyStub value) {
		switch (value) {
			case EncryptedPropertyStub entity:
				Map<String, dynamic> entityJson = EncryptedPropertyStub.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedPropertyStub";
				return entityJson;
			case DecryptedPropertyStub entity:
				Map<String, dynamic> entityJson = DecryptedPropertyStub.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedPropertyStub";
				return entityJson;
		}
	}

	static PropertyStub fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedPropertyStub":
				return EncryptedPropertyStub.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedPropertyStub":
				return DecryptedPropertyStub.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedPropertyStub implements PropertyStub {
	@override String? id;
	@override PropertyTypeStub? type;
	@override EncryptedTypedValue? typedValue;
	@override @Deprecated('Remove from list instead') int? deletionDate;
	@override Base64String? encryptedSelf;
	EncryptedPropertyStub({
			this.id,
			this.type,
			this.typedValue,
			this.deletionDate,
			this.encryptedSelf
		});

	factory EncryptedPropertyStub.fromJSON(Map<String, dynamic> data) {
		return EncryptedPropertyStub(
			id: data["id"],
			type: data["type"] == null ? null : PropertyTypeStub.fromJSON(data["type"]),
			typedValue: data["typedValue"] == null ? null : EncryptedTypedValue.fromJSON(data["typedValue"]),
			deletionDate: data["deletionDate"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(EncryptedPropertyStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"type" : value.type == null ? null : PropertyTypeStub.encode(value.type!),
			"typedValue" : value.typedValue == null ? null : EncryptedTypedValue.encode(value.typedValue!),
			"deletionDate" : value.deletionDate,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedPropertyStub implements PropertyStub {
	@override String? id;
	@override PropertyTypeStub? type;
	@override DecryptedTypedValue? typedValue;
	@override @Deprecated('Remove from list instead') int? deletionDate;
	@override Base64String? encryptedSelf;
	DecryptedPropertyStub({
			this.id,
			this.type,
			this.typedValue,
			this.deletionDate,
			this.encryptedSelf
		});

	factory DecryptedPropertyStub.fromJSON(Map<String, dynamic> data) {
		return DecryptedPropertyStub(
			id: data["id"],
			type: data["type"] == null ? null : PropertyTypeStub.fromJSON(data["type"]),
			typedValue: data["typedValue"] == null ? null : DecryptedTypedValue.fromJSON(data["typedValue"]),
			deletionDate: data["deletionDate"],
			encryptedSelf: data["encryptedSelf"]
		);
	}

	static Map<String, dynamic> encode(DecryptedPropertyStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"type" : value.type == null ? null : PropertyTypeStub.encode(value.type!),
			"typedValue" : value.typedValue == null ? null : DecryptedTypedValue.encode(value.typedValue!),
			"deletionDate" : value.deletionDate,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}