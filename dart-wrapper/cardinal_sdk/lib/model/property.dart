// This file is auto-generated
import 'package:cardinal_sdk/model/property_type.dart';
import 'package:cardinal_sdk/model/embed/typed_value.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/property.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Property implements StoredDocument, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? deletionDate;
	abstract PropertyType? type;
	TypedValue? get typedValue;
	@override abstract Base64String? encryptedSelf;


	static Map<String, dynamic> encode(Property value) {
		switch (value) {
			case EncryptedProperty entity:
				Map<String, dynamic> entityJson = EncryptedProperty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedProperty";
				return entityJson;
			case DecryptedProperty entity:
				Map<String, dynamic> entityJson = DecryptedProperty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedProperty";
				return entityJson;
		}
	}
}

class EncryptedProperty implements Property {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	@override  PropertyType? type;
	@override  EncryptedTypedValue? typedValue;
	@override  Base64String? encryptedSelf;

	EncryptedProperty({
		required this.id,
		this.rev,
		this.deletionDate,
		this.type,
		this.typedValue,
		this.encryptedSelf
	});

	static Map<String, dynamic> encode(EncryptedProperty value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"type" : value.type == null ? null : PropertyType.encode(value.type!),
			"typedValue" : value.typedValue == null ? null : EncryptedTypedValue.encode(value.typedValue!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedProperty implements Property {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	@override  PropertyType? type;
	@override  DecryptedTypedValue? typedValue;
	@override  Base64String? encryptedSelf;

	DecryptedProperty({
		required this.id,
		this.rev,
		this.deletionDate,
		this.type,
		this.typedValue,
		this.encryptedSelf
	});

	static Map<String, dynamic> encode(DecryptedProperty value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"type" : value.type == null ? null : PropertyType.encode(value.type!),
			"typedValue" : value.typedValue == null ? null : DecryptedTypedValue.encode(value.typedValue!),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}