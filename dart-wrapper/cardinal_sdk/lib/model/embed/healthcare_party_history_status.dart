// This file is auto-generated
import 'package:cardinal_sdk/model/embed/healthcare_party_status.dart';


class HealthcarePartyHistoryStatus {
	HealthcarePartyStatus status;
	String specialisationCode;
	int startDate;
	bool active;

	HealthcarePartyHistoryStatus({
		required this.status,
		required this.specialisationCode,
		required this.startDate,
		required this.active
	});

	static Map<String, dynamic> encode(HealthcarePartyHistoryStatus value) {
		Map<String, dynamic> entityAsMap = {
			"status" : HealthcarePartyStatus.encode(value.status),
			"specialisationCode" : value.specialisationCode,
			"startDate" : value.startDate,
			"active" : value.active
		};
		return entityAsMap;
	}
}