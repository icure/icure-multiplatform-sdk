// auto-generated file
import 'package:cardinal_sdk/model/embed/weekday.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/administration_quantity.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "regimen_item.freezed.dart";


@freezed
abstract class RegimenItem with _$RegimenItem {
	const factory RegimenItem({
		@Default(null) int? date,
		@Default(null) int? dayNumber,
		@Default(null) Weekday? weekday,
		@Default(null) CodeStub? dayPeriod,
		@Default(null) int? timeOfDay,
		@Default(null) AdministrationQuantity? administratedQuantity,
	}) = _RegimenItem;


	static Map<String, dynamic> encode(RegimenItem value) {
		Map<String, dynamic> entityAsMap = {
			"date" : value.date,
			"dayNumber" : value.dayNumber,
			"weekday" : value.weekday == null ? null : Weekday.encode(value.weekday!),
			"dayPeriod" : value.dayPeriod == null ? null : CodeStub.encode(value.dayPeriod!),
			"timeOfDay" : value.timeOfDay,
			"administratedQuantity" : value.administratedQuantity == null ? null : AdministrationQuantity.encode(value.administratedQuantity!)
		};
		return entityAsMap;
	}

	static RegimenItem fromJSON(Map<String, dynamic> data) {
		return RegimenItem(
			dayNumber: (data["dayNumber"] as int?),
			date: (data["date"] as int?),
			weekday: data["weekday"] == null ? null : Weekday.fromJSON(data["weekday"]),
			dayPeriod: data["dayPeriod"] == null ? null : CodeStub.fromJSON(data["dayPeriod"]),
			timeOfDay: (data["timeOfDay"] as int?),
			administratedQuantity: data["administratedQuantity"] == null ? null : AdministrationQuantity.fromJSON(data["administratedQuantity"])
		);
	}
}