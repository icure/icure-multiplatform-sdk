// This file is auto-generated


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
			data["token"],
			data["groupId"],
			groupName: data["groupName"],
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