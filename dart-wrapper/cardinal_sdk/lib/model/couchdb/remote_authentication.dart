// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/basic.dart';


class RemoteAuthentication {
	Basic? basic;
	RemoteAuthentication({
			this.basic});

	factory RemoteAuthentication.fromJSON(Map<String, dynamic> data) {
		return RemoteAuthentication(
			basic: data["basic"] == null ? null : Basic.fromJSON(data["basic"])
		);
	}

	static Map<String, dynamic> encode(RemoteAuthentication value) {
		Map<String, dynamic> entityAsMap = {
			"basic" : value.basic == null ? null : Basic.encode(value.basic!)
		};
		return entityAsMap;
	}
}