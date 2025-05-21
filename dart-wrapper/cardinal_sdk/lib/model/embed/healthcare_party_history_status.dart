// auto-generated file
import 'package:cardinal_sdk/model/embed/healthcare_party_status.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "healthcare_party_history_status.freezed.dart";


@freezed
abstract class HealthcarePartyHistoryStatus with _$HealthcarePartyHistoryStatus {
	const factory HealthcarePartyHistoryStatus({
		required HealthcarePartyStatus status,
		required String specialisationCode,
		required int startDate,
		required bool active,
	}) = _HealthcarePartyHistoryStatus;


	static Map<String, dynamic> encode(HealthcarePartyHistoryStatus value) {
		Map<String, dynamic> entityAsMap = {
			"status" : HealthcarePartyStatus.encode(value.status),
			"specialisationCode" : value.specialisationCode,
			"startDate" : value.startDate,
			"active" : value.active
		};
		return entityAsMap;
	}

	static HealthcarePartyHistoryStatus fromJSON(Map<String, dynamic> data) {
		return HealthcarePartyHistoryStatus(
			status: HealthcarePartyStatus.fromJSON(data["status"]),
			specialisationCode: (data["specialisationCode"] as String),
			startDate: (data["startDate"] as int),
			active: (data["active"] as bool)
		);
	}
}