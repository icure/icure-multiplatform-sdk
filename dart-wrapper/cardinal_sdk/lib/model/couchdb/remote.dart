// auto-generated file
import 'package:cardinal_sdk/model/couchdb/remote_authentication.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "remote.freezed.dart";


@freezed
abstract class Remote with _$Remote {
	const factory Remote({
		required String url,
		@Default(null) RemoteAuthentication? auth,
	}) = _Remote;


	static Map<String, dynamic> encode(Remote value) {
		Map<String, dynamic> entityAsMap = {
			"url" : value.url,
			"auth" : value.auth == null ? null : RemoteAuthentication.encode(value.auth!)
		};
		return entityAsMap;
	}

	static Remote fromJSON(Map<String, dynamic> data) {
		return Remote(
			url: (data["url"] as String),
			auth: data["auth"] == null ? null : RemoteAuthentication.fromJSON(data["auth"]),
		);
	}
}