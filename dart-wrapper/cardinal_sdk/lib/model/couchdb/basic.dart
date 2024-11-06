// auto-generated file


class Basic {
	String username;
	String password;
	Basic(
		this.username,
		this.password
		);

	factory Basic.fromJSON(Map<String, dynamic> data) {
		return Basic(
			(data["username"] as String),
			(data["password"] as String)
		);
	}

	static Map<String, dynamic> encode(Basic value) {
		Map<String, dynamic> entityAsMap = {
			"username" : value.username,
			"password" : value.password
		};
		return entityAsMap;
	}
}