// auto-generated file
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "property_type_stub.freezed.dart";


@freezed
abstract class PropertyTypeStub with _$PropertyTypeStub {
	const factory PropertyTypeStub({
		@Default(null) String? identifier,
		@Default(null) TypedValuesType? type,
	}) = _PropertyTypeStub;


	static Map<String, dynamic> encode(PropertyTypeStub value) {
		Map<String, dynamic> entityAsMap = {
			"identifier" : value.identifier,
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!)
		};
		return entityAsMap;
	}

	static PropertyTypeStub fromJSON(Map<String, dynamic> data) {
		return PropertyTypeStub(
			identifier: (data["identifier"] as String?),
			type: data["type"] == null ? null : TypedValuesType.fromJSON(data["type"])
		);
	}
}