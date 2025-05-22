// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "authentication_token.freezed.dart";


@freezed
abstract class AuthenticationToken with _$AuthenticationToken {
	const factory AuthenticationToken({
		@Default(null) String? token,
		required int creationTime,
		required int validity,
		@Default(null) int? deletionDate,
	}) = _AuthenticationToken;


	static Map<String, dynamic> encode(AuthenticationToken value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"creationTime" : value.creationTime,
			"validity" : value.validity,
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}

	static AuthenticationToken fromJSON(Map<String, dynamic> data) {
		return AuthenticationToken(
			creationTime: (data["creationTime"] as int),
			validity: (data["validity"] as int),
			token: (data["token"] as String?),
			deletionDate: (data["deletionDate"] as int?),
		);
	}
}