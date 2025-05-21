// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "registration_success.freezed.dart";


@freezed
abstract class RegistrationSuccess with _$RegistrationSuccess {
	const factory RegistrationSuccess({
		required String groupId,
		required String userId,
		required String token,
	}) = _RegistrationSuccess;


	static Map<String, dynamic> encode(RegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}

	static RegistrationSuccess fromJSON(Map<String, dynamic> data) {
		return RegistrationSuccess(
			groupId: (data["groupId"] as String),
			userId: (data["userId"] as String),
			token: (data["token"] as String)
		);
	}
}