// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';


class AdministrationQuantity {
	double? quantity;
	CodeStub? administrationUnit;
	String? unit;

	AdministrationQuantity({
		this.quantity,
		this.administrationUnit,
		this.unit
	});

	static Map<String, dynamic> encode(AdministrationQuantity value) {
		Map<String, dynamic> entityAsMap = {
			"quantity" : value.quantity,
			"administrationUnit" : value.administrationUnit == null ? null : CodeStub.encode(value.administrationUnit!),
			"unit" : value.unit
		};
		return entityAsMap;
	}
}