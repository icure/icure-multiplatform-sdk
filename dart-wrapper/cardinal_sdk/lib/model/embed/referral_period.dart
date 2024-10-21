// This file is auto-generated


class ReferralPeriod {
	DateTime? startDate;
	DateTime? endDate;
	String? comment;

	ReferralPeriod({
		this.startDate,
		this.endDate,
		this.comment
	});

	static Map<String, dynamic> encode(ReferralPeriod value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate?.toIso8601String(),
			"endDate" : value.endDate?.toIso8601String(),
			"comment" : value.comment
		};
		return entityAsMap;
	}
}