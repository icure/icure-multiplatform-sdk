// auto-generated file
import 'package:cardinal_sdk/model/couchdb/remote_authentication.dart';


class Remote {
	String url;
	RemoteAuthentication? auth = null;
	Remote(
		this.url,
		{
			RemoteAuthentication? auth
		}) : auth = auth ?? null;

	factory Remote.fromJSON(Map<String, dynamic> data) {
		return Remote(
			(data["url"] as String),
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