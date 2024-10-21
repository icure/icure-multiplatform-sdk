// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Substanceproduct {
	List<CodeStub> intendedcds = [];
	List<CodeStub> deliveredcds = [];
	String? intendedname;
	String? deliveredname;
	String? productId;

	Substanceproduct({
		this.intendedname,
		this.deliveredname,
		this.productId,
		List<CodeStub>? intendedcds,
		List<CodeStub>? deliveredcds
	}) : intendedcds = intendedcds ?? [],
		deliveredcds = deliveredcds ?? [];

	static Map<String, dynamic> encode(Substanceproduct value) {
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