// auto-generated file


class TokenWithGroup {
	String token;
	String groupId;
	String? groupName;
	TokenWithGroup(
		this.token,
		this.groupId,
		{
			this.groupName
		});

	factory TokenWithGroup.fromJSON(Map<String, dynamic> data) {
		return TokenWithGroup(
			(data["token"] as String),
			(data["groupId"] as String),
			groupName: (data["groupName"] as String?),
		);
	}

	static Map<String, dynamic> encode(TokenWithGroup value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"groupId" : value.groupId,
			"groupName" : value.groupName
		};
		return entityAsMap;
	}
}