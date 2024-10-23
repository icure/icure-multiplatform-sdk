// auto-generated file
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';


class PropertyTypeStub {
	String? identifier;
	TypedValuesType? type;
	PropertyTypeStub({
			this.identifier,
			this.type
		});

	factory PropertyTypeStub.fromJSON(Map<String, dynamic> data) {
		return PropertyTypeStub(
			identifier: data["identifier"],
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