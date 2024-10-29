// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class AdministrationQuantity {
	double? quantity = null;
	CodeStub? administrationUnit = null;
	String? unit = null;
	AdministrationQuantity({
			double? quantity,
			CodeStub? administrationUnit,
			String? unit
		}) : quantity = quantity ?? null,
		administrationUnit = administrationUnit ?? null,
		unit = unit ?? null;

	factory AdministrationQuantity.fromJSON(Map<String, dynamic> data) {
		return AdministrationQuantity(
			quantity: (data["quantity"] as num?)?.toDouble(),
			administrationUnit: data["administrationUnit"] == null ? null : CodeStub.fromJSON(data["administrationUnit"]),
			unit: (data["unit"] as String?)
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