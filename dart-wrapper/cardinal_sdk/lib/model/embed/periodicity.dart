// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Periodicity {
	CodeStub? relatedCode;
	CodeStub? relatedPeriodicity;
	Periodicity({
			this.relatedCode,
			this.relatedPeriodicity
		});

	factory Periodicity.fromJSON(Map<String, dynamic> data) {
		return Periodicity(
			relatedCode: data["relatedCode"] == null ? null : CodeStub.fromJSON(data["relatedCode"]),
			relatedPeriodicity: data["relatedPeriodicity"] == null ? null : CodeStub.fromJSON(data["relatedPeriodicity"])
		);
	}

	static Map<String, dynamic> encode(Periodicity value) {
		Map<String, dynamic> entityAsMap = {
			"relatedCode" : value.relatedCode == null ? null : CodeStub.encode(value.relatedCode!),
			"relatedPeriodicity" : value.relatedPeriodicity == null ? null : CodeStub.encode(value.relatedPeriodicity!)
		};
		return entityAsMap;
	}
}