// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "basic.freezed.dart";


@freezed
abstract class Basic with _$Basic {
	const factory Basic({
		required String username,
		required String password,
	}) = _Basic;


	static Map<String, dynamic> encode(Basic value) {
		Map<String, dynamic> entityAsMap = {
			"username" : value.username,
			"password" : value.password
		};
		return entityAsMap;
	}

	static Basic fromJSON(Map<String, dynamic> data) {
		return Basic(
			username: (data["username"] as String),
			password: (data["password"] as String)
		);
	}
}