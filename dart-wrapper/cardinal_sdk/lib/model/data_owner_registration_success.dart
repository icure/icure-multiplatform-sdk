// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "data_owner_registration_success.freezed.dart";


@freezed
abstract class DataOwnerRegistrationSuccess with _$DataOwnerRegistrationSuccess {
	const factory DataOwnerRegistrationSuccess({
		required String userLogin,
		required String userId,
		required String token,
	}) = _DataOwnerRegistrationSuccess;


	static Map<String, dynamic> encode(DataOwnerRegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"userLogin" : value.userLogin,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}

	static DataOwnerRegistrationSuccess fromJSON(Map<String, dynamic> data) {
		return DataOwnerRegistrationSuccess(
			userLogin: (data["userLogin"] as String),
			userId: (data["userId"] as String),
			token: (data["token"] as String)
		);
	}
}