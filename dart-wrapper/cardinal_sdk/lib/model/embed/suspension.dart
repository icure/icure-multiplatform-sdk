// auto-generated file


class Suspension {
	int? beginMoment;
	int? endMoment;
	String? suspensionReason;
	String? lifecycle;
	Suspension({
			this.beginMoment,
			this.endMoment,
			this.suspensionReason,
			this.lifecycle
		});

	factory Suspension.fromJSON(Map<String, dynamic> data) {
		return Suspension(
			beginMoment: (data["beginMoment"] as int?),
			endMoment: (data["endMoment"] as int?),
			suspensionReason: (data["suspensionReason"] as String?),
			lifecycle: (data["lifecycle"] as String?)
		);
	}

	static Map<String, dynamic> encode(Suspension value) {
		Map<String, dynamic> entityAsMap = {
			"beginMoment" : value.beginMoment,
			"endMoment" : value.endMoment,
			"suspensionReason" : value.suspensionReason,
			"lifecycle" : value.lifecycle
		};
		return entityAsMap;
	}
}