// This file is auto-generated


class RegistrationSuccess {
	String groupId;
	String userId;
	String token;

	RegistrationSuccess({
		required this.groupId,
		required this.userId,
		required this.token
	});

	static Map<String, dynamic> encode(RegistrationSuccess value) {
		Map<String, dynamic> entityAsMap = {
			"groupId" : value.groupId,
			"userId" : value.userId,
			"token" : value.token
		};
		return entityAsMap;
	}
}