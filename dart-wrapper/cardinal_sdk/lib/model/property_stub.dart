// This file is auto-generated
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
}

class EncryptedPropertyStub implements PropertyStub {
	@override  String? id;
	@override  PropertyTypeStub? type;
	@override  EncryptedTypedValue? typedValue;
	@override @Deprecated('Remove from list instead')  int? deletionDate;
	@override  Base64String? encryptedSelf;

	EncryptedPropertyStub({
		this.id,
		this.type,
		this.typedValue,
		this.deletionDate,
		this.encryptedSelf
	});

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
	@override  String? id;
	@override  PropertyTypeStub? type;
	@override  DecryptedTypedValue? typedValue;
	@override @Deprecated('Remove from list instead')  int? deletionDate;
	@override  Base64String? encryptedSelf;

	DecryptedPropertyStub({
		this.id,
		this.type,
		this.typedValue,
		this.deletionDate,
		this.encryptedSelf
	});

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