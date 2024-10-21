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