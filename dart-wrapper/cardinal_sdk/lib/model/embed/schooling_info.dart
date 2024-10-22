// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';


class SchoolingInfo {
	int? startDate;
	int? endDate;
	String? school;
	CodeStub? typeOfEducation;
	SchoolingInfo({
			this.startDate,
			this.endDate,
			this.school,
			this.typeOfEducation
		});

	factory SchoolingInfo.fromJSON(Map<String, dynamic> data) {
		return SchoolingInfo(
			startDate: data["startDate"],
			endDate: data["endDate"],
			school: data["school"],
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