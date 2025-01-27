// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/operator.dart';
import 'package:cardinal_sdk/model/specializations/any_primitive.dart';
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class KeyValuePredicate implements Predicate {
	String? key = null;
	Operator? operator = null;
	AnyPrimitive? value = null;
	KeyValuePredicate({
			String? key,
			Operator? operator,
			AnyPrimitive? value
		}) : key = key ?? null,
		operator = operator ?? null,
		value = value ?? null;

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