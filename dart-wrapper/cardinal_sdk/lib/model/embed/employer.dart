// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "employer.freezed.dart";


@freezed
abstract class Employer with _$Employer implements Named {
	const factory Employer({
		@Default(null) String? name,
		@Default(null) DecryptedAddress? addresse,
	}) = _Employer;


	static Map<String, dynamic> encode(Employer value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"addresse" : value.addresse == null ? null : DecryptedAddress.encode(value.addresse!)
		};
		return entityAsMap;
	}

	static Employer fromJSON(Map<String, dynamic> data) {
		return Employer(
			name: (data["name"] as String?),
			addresse: data["addresse"] == null ? null : DecryptedAddress.fromJSON(data["addresse"])
		);
	}
}