// This file is auto-generated
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';


class PropertyTypeStub {
	String? identifier;
	TypedValuesType? type;

	PropertyTypeStub({
		this.identifier,
		this.type
	});

	static Map<String, dynamic> encode(PropertyTypeStub value) {
		Map<String, dynamic> entityAsMap = {
			"identifier" : value.identifier,
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!)
		};
		return entityAsMap;
	}
}