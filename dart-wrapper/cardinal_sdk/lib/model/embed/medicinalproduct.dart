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
			intendedcds: data["intendedcds"].map((x0) => CodeStub.fromJSON(x0) ),
			deliveredcds: data["deliveredcds"].map((x0) => CodeStub.fromJSON(x0) ),
			intendedname: data["intendedname"],
			deliveredname: data["deliveredname"],
			productId: data["productId"]
		);
	}

	static Map<String, dynamic> encode(Medicinalproduct value) {
		Map<String, dynamic> entityAsMap = {
			"intendedcds" : value.intendedcds.map((x0) => CodeStub.encode(x0)),
			"deliveredcds" : value.deliveredcds.map((x0) => CodeStub.encode(x0)),
			"intendedname" : value.intendedname,
			"deliveredname" : value.deliveredname,
			"productId" : value.productId
		};
		return entityAsMap;
	}
}