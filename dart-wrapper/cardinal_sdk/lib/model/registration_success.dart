// auto-generated file


class RegistrationSuccess {
	String groupId;
	String userId;
	String token;
	RegistrationSuccess(
		this.groupId,
		this.userId,
		this.token
		);

	factory RegistrationSuccess.fromJSON(Map<String, dynamic> data) {
		return RegistrationSuccess(
			data["groupId"],
			data["userId"],
			data["token"]
		);
	}

	static Map<String, dynamic> encode(RegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}
}