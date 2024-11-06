// auto-generated file
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class Employer implements Named {
	@override String? name = null;
	DecryptedAddress? addresse = null;
	Employer({
			String? name,
			DecryptedAddress? addresse
		}) : name = name ?? null,
		addresse = addresse ?? null;

	factory Employer.fromJSON(Map<String, dynamic> data) {
		return Employer(
			name: (data["name"] as String?),
			addresse: data["addresse"] == null ? null : DecryptedAddress.fromJSON(data["addresse"])
		);
	}

	static Map<String, dynamic> encode(Employer value) {
		Map<String, dynamic> entityAsMap = {
			"name" : value.name,
			"addresse" : value.addresse == null ? null : DecryptedAddress.encode(value.addresse!)
		};
		return entityAsMap;
	}
}