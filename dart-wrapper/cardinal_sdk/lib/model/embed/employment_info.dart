// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/employer.dart';


class EmploymentInfo {
	int? startDate;
	int? endDate;
	CodeStub? professionType;
	Employer? employer;

	EmploymentInfo({
		this.startDate,
		this.endDate,
		this.professionType,
		this.employer
	});

	static Map<String, dynamic> encode(EmploymentInfo value) {
		Map<String, dynamic> entityAsMap = {
			"startDate" : value.startDate,
			"endDate" : value.endDate,
			"professionType" : value.professionType == null ? null : CodeStub.encode(value.professionType!),
			"employer" : value.employer == null ? null : Employer.encode(value.employer!)
		};
		return entityAsMap;
	}
}