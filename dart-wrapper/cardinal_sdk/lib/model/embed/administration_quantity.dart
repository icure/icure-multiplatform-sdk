// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "administration_quantity.freezed.dart";


@freezed
abstract class AdministrationQuantity with _$AdministrationQuantity {
	const factory AdministrationQuantity({
		@Default(null) double? quantity,
		@Default(null) CodeStub? administrationUnit,
		@Default(null) String? unit,
	}) = _AdministrationQuantity;


	static Map<String, dynamic> encode(AdministrationQuantity value) {
		Map<String, dynamic> entityAsMap = {
			"quantity" : value.quantity,
			"administrationUnit" : value.administrationUnit == null ? null : CodeStub.encode(value.administrationUnit!),
			"unit" : value.unit
		};
		return entityAsMap;
	}

	static AdministrationQuantity fromJSON(Map<String, dynamic> data) {
		return AdministrationQuantity(
			quantity: (data["quantity"] as num?)?.toDouble(),
			administrationUnit: data["administrationUnit"] == null ? null : CodeStub.fromJSON(data["administrationUnit"]),
			unit: (data["unit"] as String?)
		);
	}
}