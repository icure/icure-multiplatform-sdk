// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/basic.dart';


class RemoteAuthentication {
	Basic? basic;

	RemoteAuthentication({
		this.basic
	});

	static Map<String, dynamic> encode(RemoteAuthentication value) {
		Map<String, dynamic> entityAsMap = {
			"basic" : value.basic == null ? null : Basic.encode(value.basic!)
		};
		return entityAsMap;
	}
}