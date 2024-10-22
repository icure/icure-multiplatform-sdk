// This file is auto-generated


class TimeTableHour {
	int? startHour;
	int? endHour;
	TimeTableHour({
			this.startHour,
			this.endHour
		});

	factory TimeTableHour.fromJSON(Map<String, dynamic> data) {
		return TimeTableHour(
			startHour: data["startHour"],
			endHour: data["endHour"]
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