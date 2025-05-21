// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "substanceproduct.freezed.dart";


@freezed
abstract class Substanceproduct with _$Substanceproduct {
	const factory Substanceproduct({
		@Default([]) List<CodeStub> intendedcds,
		@Default([]) List<CodeStub> deliveredcds,
		@Default(null) String? intendedname,
		@Default(null) String? deliveredname,
		@Default(null) String? productId,
	}) = _Substanceproduct;


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