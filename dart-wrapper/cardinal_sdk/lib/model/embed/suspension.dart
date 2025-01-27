// auto-generated file


class Suspension {
	int? beginMoment = null;
	int? endMoment = null;
	String? suspensionReason = null;
	String? lifecycle = null;
	Suspension({
			int? beginMoment,
			int? endMoment,
			String? suspensionReason,
			String? lifecycle
		}) : beginMoment = beginMoment ?? null,
		endMoment = endMoment ?? null,
		suspensionReason = suspensionReason ?? null,
		lifecycle = lifecycle ?? null;

	static Map<String, dynamic> encode(Suspension value) {
		Map<String, dynamic> entityAsMap = {
			"beginMoment" : value.beginMoment,
			"endMoment" : value.endMoment,
			"suspensionReason" : value.suspensionReason,
			"lifecycle" : value.lifecycle
		};
		return entityAsMap;
	}

	static Suspension fromJSON(Map<String, dynamic> data) {
		return Suspension(
			beginMoment: (data["beginMoment"] as int?),
			endMoment: (data["endMoment"] as int?),
			suspensionReason: (data["suspensionReason"] as String?),
			lifecycle: (data["lifecycle"] as String?)
		);
	}
}