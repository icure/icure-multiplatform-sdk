// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class SchoolingInfo {
	int? startDate = null;
	int? endDate = null;
	String? school = null;
	CodeStub? typeOfEducation = null;
	SchoolingInfo({
			int? startDate,
			int? endDate,
			String? school,
			CodeStub? typeOfEducation
		}) : startDate = startDate ?? null,
		endDate = endDate ?? null,
		school = school ?? null,
		typeOfEducation = typeOfEducation ?? null;

	factory SchoolingInfo.fromJSON(Map<String, dynamic> data) {
		return SchoolingInfo(
			startDate: (data["startDate"] as int?),
			endDate: (data["endDate"] as int?),
			school: (data["school"] as String?),
			typeOfEducation: data["typeOfEducation"] == null ? null : CodeStub.fromJSON(data["typeOfEducation"])
		);
	}

	static Map<String, dynamic> encode(SchoolingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"school" : value.school,
			"typeOfEducation" : value.typeOfEducation == null ? null : CodeStub.encode(value.typeOfEducation!)
		};
		return entityAsMap;
	}
}