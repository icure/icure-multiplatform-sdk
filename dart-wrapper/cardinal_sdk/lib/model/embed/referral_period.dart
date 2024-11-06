// auto-generated file


class ReferralPeriod {
	DateTime? startDate = null;
	DateTime? endDate = null;
	String? comment = null;
	ReferralPeriod({
			DateTime? startDate,
			DateTime? endDate,
			String? comment
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		comment = comment ?? null;

	factory ReferralPeriod.fromJSON(Map<String, dynamic> data) {
		return ReferralPeriod(
			startDate: data["startDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["startDate"] as int),
			endDate: data["endDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["endDate"] as int),
			comment: (data["comment"] as String?)
		);
	}

	static Map<String, dynamic> encode(ReferralPeriod value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate?.millisecondsSinceEpoch,
			"endDate" : value.endDate?.millisecondsSinceEpoch,
			"comment" : value.comment
		};
		return entityAsMap;
	}
}