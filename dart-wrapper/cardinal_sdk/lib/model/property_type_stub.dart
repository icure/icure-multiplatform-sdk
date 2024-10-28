// auto-generated file
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';


class PropertyTypeStub {
	String? identifier = null;
	TypedValuesType? type = null;
	PropertyTypeStub({
			String? identifier,
			TypedValuesType? type
		}) : identifier = identifier ?? null,
		type = type ?? null;

	factory PropertyTypeStub.fromJSON(Map<String, dynamic> data) {
		return PropertyTypeStub(
			identifier: (data["identifier"] as String?),
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"])
		);
	}

	static Map<String, dynamic> encode(PropertyTypeStub value) {
		Map<String, dynamic> entityAsMap = {
			"identifier" : value.identifier,
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!)
		};
		return entityAsMap;
	}
}