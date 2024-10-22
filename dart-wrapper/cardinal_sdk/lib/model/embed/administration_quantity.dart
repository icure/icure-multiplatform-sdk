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

	factory AdministrationQuantity.fromJSON(Map<String, dynamic> data) {
		return AdministrationQuantity(
			quantity: data["quantity"],
			administrationUnit: data["administrationUnit"] == null ? null : CodeStub.fromJSON(data["administrationUnit"]),
			unit: data["unit"]
		);
	}

	static Map<String, dynamic> encode(AdministrationQuantity value) {
		Map<String, dynamic> entityAsMap = {
			"quantity" : value.quantity,
			"administrationUnit" : value.administrationUnit == null ? null : CodeStub.encode(value.administrationUnit!),
			"unit" : value.unit
		};
		return entityAsMap;
	}
}