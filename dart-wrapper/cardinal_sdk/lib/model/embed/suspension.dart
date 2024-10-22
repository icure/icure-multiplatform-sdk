// This file is auto-generated


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
			beginMoment: data["beginMoment"],
			endMoment: data["endMoment"],
			suspensionReason: data["suspensionReason"],
			lifecycle: data["lifecycle"]
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