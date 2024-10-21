// This file is auto-generated


class DataOwnerRegistrationSuccess {
	String userLogin;
	String userId;
	String token;

	DataOwnerRegistrationSuccess({
		required this.userLogin,
		required this.userId,
		required this.token
	});

	static Map<String, dynamic> encode(DataOwnerRegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"userLogin" : value.userLogin,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}
}