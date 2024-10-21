// This file is auto-generated


class CalendarItemTag {
	String? code;
	int? date;
	String? userId;
	String? userName;

	CalendarItemTag({
		this.code,
		this.date,
		this.userId,
		this.userName
	});

	static Map<String, dynamic> encode(CalendarItemTag value) {
		Map<String, dynamic> entityAsMap = {
			"code" : value.code,
			"date" : value.date,
			"userId" : value.userId,
			"userName" : value.userName
		};
		return entityAsMap;
	}
}