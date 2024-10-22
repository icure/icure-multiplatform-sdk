// This file is auto-generated


enum TopicRole {
	participant,
	admin,
	owner;

	static String encode(TopicRole value) {
		switch (value) {
			case TopicRole.participant:
				return '"PARTICIPANT"';
			case TopicRole.admin:
				return '"ADMIN"';
			case TopicRole.owner:
				return '"OWNER"';
			}
	}


	static TopicRole fromJSON(String data) {
		switch (data) {
			case "PARTICIPANT":
				return TopicRole.participant;
			case "ADMIN":
				return TopicRole.admin;
			case "OWNER":
				return TopicRole.owner;
			default:
				throw ArgumentError('Invalid TopicRole entry value $data');
			}
	}

}