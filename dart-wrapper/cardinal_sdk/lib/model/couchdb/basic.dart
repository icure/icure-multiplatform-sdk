// This file is auto-generated


class Basic {
	String username;
	String password;

	Basic({
		required this.username,
		required this.password
	});

	static Map<String, dynamic> encode(Basic value) {
		Map<String, dynamic> entityAsMap = {
			"username" : value.username,
			"password" : value.password
		};
		return entityAsMap;
	}
}