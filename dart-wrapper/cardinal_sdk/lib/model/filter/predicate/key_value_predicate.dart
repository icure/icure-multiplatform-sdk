// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/operator.dart';
import 'package:cardinal_sdk/model/specializations/any_primitive.dart';
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class KeyValuePredicate implements Predicate {
	String? key;
	Operator? operator;
	AnyPrimitive? value;

	KeyValuePredicate({
		this.key,
		this.operator,
		this.value
	});

	static Map<String, dynamic> encode(KeyValuePredicate value) {
		Map<String, dynamic> entityAsMap = {
			"key" : value.key,
			"operator" : value.operator == null ? null : Operator.encode(value.operator!),
			"value" : value.value
		};
		return entityAsMap;
	}
}