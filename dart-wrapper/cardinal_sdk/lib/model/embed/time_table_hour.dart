// This file is auto-generated


class TimeTableHour {
	int? startHour;
	int? endHour;

	TimeTableHour({
		this.startHour,
		this.endHour
	});

	static Map<String, dynamic> encode(TimeTableHour value) {
		Map<String, dynamic> entityAsMap = {
			"startHour" : value.startHour,
			"endHour" : value.endHour
		};
		return entityAsMap;
	}
}