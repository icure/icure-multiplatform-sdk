// auto-generated file


class DataOwnerRegistrationSuccess {
	String userLogin;
	String userId;
	String token;
	DataOwnerRegistrationSuccess(
		this.userLogin,
		this.userId,
		this.token
		);

	factory DataOwnerRegistrationSuccess.fromJSON(Map<String, dynamic> data) {
		return DataOwnerRegistrationSuccess(
			data["userLogin"],
			data["userId"],
			data["token"]
		);
	}

	static Map<String, dynamic> encode(DataOwnerRegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"userLogin" : value.userLogin,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}
}