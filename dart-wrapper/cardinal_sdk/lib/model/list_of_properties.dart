// auto-generated file
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "list_of_properties.freezed.dart";


@freezed
abstract class ListOfProperties with _$ListOfProperties {
	const factory ListOfProperties({
		@Default({}) Set<DecryptedPropertyStub> properties,
	}) = _ListOfProperties;


	static Map<String, dynamic> encode(ListOfProperties value) {
		Map<String, dynamic> entityAsMap = {
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static ListOfProperties fromJSON(Map<String, dynamic> data) {
		return ListOfProperties(
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet()
		);
	}
}