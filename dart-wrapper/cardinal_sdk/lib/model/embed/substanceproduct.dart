// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Substanceproduct {
	List<CodeStub> intendedcds = [];
	List<CodeStub> deliveredcds = [];
	String? intendedname = null;
	String? deliveredname = null;
	String? productId = null;
	Substanceproduct({
			List<CodeStub>? intendedcds,
			List<CodeStub>? deliveredcds,
			String? intendedname,
			String? deliveredname,
			String? productId
		}) : intendedcds = intendedcds ?? [],
		deliveredcds = deliveredcds ?? [],
		intendedname = intendedname ?? null,
		deliveredname = deliveredname ?? null,
		productId = productId ?? null;

	static Map<String, dynamic> encode(Substanceproduct value) {
		Map<String, dynamic> entityAsMap = {
			"intendedcds" : value.intendedcds.map((x0) => CodeStub.encode(x0)).toList(),
			"deliveredcds" : value.deliveredcds.map((x0) => CodeStub.encode(x0)).toList(),
			"intendedname" : value.intendedname,
			"deliveredname" : value.deliveredname,
			"productId" : value.productId
		};
		return entityAsMap;
	}

	static Substanceproduct fromJSON(Map<String, dynamic> data) {
		return Substanceproduct(
			intendedcds: (data["intendedcds"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			deliveredcds: (data["deliveredcds"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			intendedname: (data["intendedname"] as String?),
			deliveredname: (data["deliveredname"] as String?),
			productId: (data["productId"] as String?)
		);
	}
}