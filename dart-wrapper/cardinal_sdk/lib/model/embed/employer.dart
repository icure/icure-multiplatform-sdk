// This file is auto-generated
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Employer implements Named {
	@override  String? name;
	DecryptedAddress? addresse;

	Employer({
		this.name,
		this.addresse
	});

	static Map<String, dynamic> encode(Employer value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"addresse" : value.addresse == null ? null : DecryptedAddress.encode(value.addresse!)
		};
		return entityAsMap;
	}
}