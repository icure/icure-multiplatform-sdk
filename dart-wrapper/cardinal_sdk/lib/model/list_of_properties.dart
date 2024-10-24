// auto-generated file
import 'package:cardinal_sdk/model/property_stub.dart';


class ListOfProperties {
	Set<DecryptedPropertyStub> properties = {};
	ListOfProperties({
			Set<DecryptedPropertyStub>? properties}) : properties = properties ?? {};

	factory ListOfProperties.fromJSON(Map<String, dynamic> data) {
		return ListOfProperties(
			properties: data["properties"].map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toList()
		);
	}

	static Map<String, dynamic> encode(ListOfProperties value) {
		Map<String, dynamic> entityAsMap = {
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList()
		};
		return entityAsMap;
	}
}