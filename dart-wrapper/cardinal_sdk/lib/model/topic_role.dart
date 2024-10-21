// This file is auto-generated


enum TopicRole {
	participant,
	admin,
	owner;

	static String encode(TopicRole value) {
		switch (value) {
			case TopicRole.participant:
				return '"Participant"';
			case TopicRole.admin:
				return '"Admin"';
			case TopicRole.owner:
				return '"Owner"';
			}
	}

}