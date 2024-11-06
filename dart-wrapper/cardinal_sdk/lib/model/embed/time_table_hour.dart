// auto-generated file


class TimeTableHour {
	int? startHour = null;
	int? endHour = null;
	TimeTableHour({
			int? startHour,
			int? endHour
		}) : startHour = startHour ?? null,
		endHour = endHour ?? null;

	factory TimeTableHour.fromJSON(Map<String, dynamic> data) {
		return TimeTableHour(
			startHour: (data["startHour"] as int?),
			endHour: (data["endHour"] as int?)
		);
	}

	static Map<String, dynamic> encode(TimeTableHour value) {
		Map<String, dynamic> entityAsMap = {
			"startHour" : value.startHour,
			"endHour" : value.endHour
		};
		return entityAsMap;
	}
}