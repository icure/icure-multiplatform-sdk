// auto-generated file
import 'package:cardinal_sdk/model/embed/healthcare_party_status.dart';


class HealthcarePartyHistoryStatus {
	HealthcarePartyStatus status;
	String specialisationCode;
	int startDate;
	bool active;
	HealthcarePartyHistoryStatus(
		this.status,
		this.specialisationCode,
		this.startDate,
		this.active
		);

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
			HealthcarePartyStatus.fromJSON(data["status"]),
			(data["specialisationCode"] as String),
			(data["startDate"] as int),
			(data["active"] as bool)
		);
	}
}