// auto-generated file


class AuthenticationToken {
	String? token;
	int creationTime;
	int validity;
	int? deletionDate;
	AuthenticationToken(
		this.creationTime,
		this.validity,
		{
			this.token,
			this.deletionDate
		});

	factory AuthenticationToken.fromJSON(Map<String, dynamic> data) {
		return AuthenticationToken(
			(data["creationTime"] as int),
			(data["validity"] as int),
			token: (data["token"] as String?),
			deletionDate: (data["deletionDate"] as int?),
		);
	}

	static Map<String, dynamic> encode(AuthenticationToken value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"creationTime" : value.creationTime,
			"validity" : value.validity,
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}