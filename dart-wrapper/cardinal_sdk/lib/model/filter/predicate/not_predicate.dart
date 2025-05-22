// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "not_predicate.freezed.dart";


@freezed
abstract class NotPredicate with _$NotPredicate implements Predicate {
	const factory NotPredicate({
		required Predicate predicate,
	}) = _NotPredicate;


	static Map<String, dynamic> encode(NotPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicate" : Predicate.encode(value.predicate)
		};
		return entityAsMap;
	}

	static NotPredicate fromJSON(Map<String, dynamic> data) {
		return NotPredicate(
			predicate: Predicate.fromJSON(data["predicate"])
		);
	}
}