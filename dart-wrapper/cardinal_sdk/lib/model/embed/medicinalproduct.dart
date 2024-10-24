// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Medicinalproduct {
	List<CodeStub> intendedcds = [];
	List<CodeStub> deliveredcds = [];
	String? intendedname;
	String? deliveredname;
	String? productId;
	Medicinalproduct({
			this.intendedname,
			this.deliveredname,
			this.productId,
			List<CodeStub>? intendedcds,
			List<CodeStub>? deliveredcds
		}) : intendedcds = intendedcds ?? [],
		deliveredcds = deliveredcds ?? [];

	factory Medicinalproduct.fromJSON(Map<String, dynamic> data) {
		return Medicinalproduct(
			intendedcds: (data["intendedcds"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			deliveredcds: (data["deliveredcds"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			intendedname: (data["intendedname"] as String?),
			deliveredname: (data["deliveredname"] as String?),
			productId: (data["productId"] as String?)
		);
	}

	static Map<String, dynamic> encode(Medicinalproduct value) {
		Map<String, dynamic> entityAsMap = {
			"intendedcds" : value.intendedcds.map((x0) => CodeStub.encode(x0)).toList(),
			"deliveredcds" : value.deliveredcds.map((x0) => CodeStub.encode(x0)).toList(),
			"intendedname" : value.intendedname,
			"deliveredname" : value.deliveredname,
			"productId" : value.productId
		};
		return entityAsMap;
	}
}