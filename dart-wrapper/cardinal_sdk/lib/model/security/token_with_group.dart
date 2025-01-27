// auto-generated file


class TokenWithGroup {
	String token;
	String groupId;
	String? groupName = null;
	TokenWithGroup(
		this.token,
		this.groupId,
		{
			String? groupName
		}) : groupName = groupName ?? null;

	static Map<String, dynamic> encode(TokenWithGroup value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"groupId" : value.groupId,
			"groupName" : value.groupName
		};
		return entityAsMap;
	}

	static TokenWithGroup fromJSON(Map<String, dynamic> data) {
		return TokenWithGroup(
			(data["token"] as String),
			(data["groupId"] as String),
			groupName: (data["groupName"] as String?),
		);
	}
}