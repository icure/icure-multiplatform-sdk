// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/remote_authentication.dart';


class Remote {
	String url;
	RemoteAuthentication? auth;

	Remote({
		required this.url,
		this.auth
	});

	static Map<String, dynamic> encode(Remote value) {
		Map<String, dynamic> entityAsMap = {
			"url" : value.url,
			"auth" : value.auth == null ? null : RemoteAuthentication.encode(value.auth!)
		};
		return entityAsMap;
	}
}