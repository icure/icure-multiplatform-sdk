// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/operator.dart';
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/any_primitive.dart';
part "key_value_predicate.freezed.dart";


@freezed
abstract class KeyValuePredicate with _$KeyValuePredicate implements Predicate {
	const factory KeyValuePredicate({
		@Default(null) String? key,
		@Default(null) Operator? operator,
		@Default(null) AnyPrimitive? value,
	}) = _KeyValuePredicate;


	static Map<String, dynamic> encode(KeyValuePredicate value) {
		Map<String, dynamic> entityAsMap = {
			"key" : value.key,
			"operator" : value.operator == null ? null : Operator.encode(value.operator!),
			"value" : value.value
		};
		return entityAsMap;
	}

	static KeyValuePredicate fromJSON(Map<String, dynamic> data) {
		return KeyValuePredicate(
			key: (data["key"] as String?),
			operator: data["operator"] == null ? null : Operator.fromJSON(data["operator"]),
			value: (data["value"] as AnyPrimitive?)
		);
	}
}