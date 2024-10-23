// auto-generated file
import 'package:cardinal_sdk/model/couchdb/remote_authentication.dart';


class Remote {
	String url;
	RemoteAuthentication? auth;
	Remote(
		this.url,
		{
			this.auth
		});

	factory Remote.fromJSON(Map<String, dynamic> data) {
		return Remote(
			data["url"],
			auth: data["auth"] == null ? null : RemoteAuthentication.fromJSON(data["auth"]),
		);
	}

	static Map<String, dynamic> encode(Remote value) {
		Map<String, dynamic> entityAsMap = {
			"url" : value.url,
			"auth" : value.auth == null ? null : RemoteAuthentication.encode(value.auth!)
		};
		return entityAsMap;
	}
}