// auto-generated file
import 'package:cardinal_sdk/model/couchdb/basic.dart';


class RemoteAuthentication {
	Basic? basic = null;
	RemoteAuthentication({
			Basic? basic}) : basic = basic ?? null;

	static Map<String, dynamic> encode(RemoteAuthentication value) {
		Map<String, dynamic> entityAsMap = {
			"basic" : value.basic == null ? null : Basic.encode(value.basic!)
		};
		return entityAsMap;
	}

	static RemoteAuthentication fromJSON(Map<String, dynamic> data) {
		return RemoteAuthentication(
			basic: data["basic"] == null ? null : Basic.fromJSON(data["basic"])
		);
	}
}