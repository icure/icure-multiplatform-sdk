// auto-generated file
import 'package:cardinal_sdk/model/couchdb/basic.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "remote_authentication.freezed.dart";


@freezed
abstract class RemoteAuthentication with _$RemoteAuthentication {
	const factory RemoteAuthentication({
		@Default(null) Basic? basic,
	}) = _RemoteAuthentication;


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