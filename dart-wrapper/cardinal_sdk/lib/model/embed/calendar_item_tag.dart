// auto-generated file


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

	factory CalendarItemTag.fromJSON(Map<String, dynamic> data) {
		return CalendarItemTag(
			code: (data["code"] as String?),
			date: (data["date"] as int?),
			userId: (data["userId"] as String?),
			userName: (data["userName"] as String?)
		);
	}

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