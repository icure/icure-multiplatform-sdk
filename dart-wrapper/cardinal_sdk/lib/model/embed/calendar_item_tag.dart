// auto-generated file


class CalendarItemTag {
	String? code = null;
	int? date = null;
	String? userId = null;
	String? userName = null;
	CalendarItemTag({
			String? code,
			int? date,
			String? userId,
			String? userName
		}) : code = code ?? null,
		date = date ?? null,
		userId = userId ?? null,
		userName = userName ?? null;

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