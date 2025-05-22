// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "referral_period.freezed.dart";


@freezed
abstract class ReferralPeriod with _$ReferralPeriod {
	const factory ReferralPeriod({
		@Default(null) DateTime? startDate,
		@Default(null) DateTime? endDate,
		@Default(null) String? comment,
	}) = _ReferralPeriod;


	static Map<String, dynamic> encode(ReferralPeriod value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate?.millisecondsSinceEpoch,
			"endDate" : value.endDate?.millisecondsSinceEpoch,
			"comment" : value.comment
		};
		return entityAsMap;
	}

	static ReferralPeriod fromJSON(Map<String, dynamic> data) {
		return ReferralPeriod(
			startDate: data["startDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["startDate"] as int),
			endDate: data["endDate"] == null ? null : DateTime.fromMillisecondsSinceEpoch(data["endDate"] as int),
			comment: (data["comment"] as String?)
		);
	}
}