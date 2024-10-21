// This file is auto-generated


class TokenWithGroup {
	String token;
	String groupId;
	String? groupName;

	TokenWithGroup({
		required this.token,
		required this.groupId,
		this.groupName
	});

	static Map<String, dynamic> encode(TokenWithGroup value) {
		Map<String, dynamic> entityAsMap = {
			"token" : value.token,
			"groupId" : value.groupId,
			"groupName" : value.groupName
		};
		return entityAsMap;
	}
}