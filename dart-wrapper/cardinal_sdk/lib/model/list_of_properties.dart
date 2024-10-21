// This file is auto-generated
import 'package:cardinal_sdk/model/property_stub.dart';


class ListOfProperties {
	Set<DecryptedPropertyStub> properties = {};

	ListOfProperties({
		Set<DecryptedPropertyStub>? properties
	}) : properties = properties ?? {};

	static Map<String, dynamic> encode(ListOfProperties value) {
		Map<String, dynamic> entityAsMap = {
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0))
		};
		return entityAsMap;
	}
}