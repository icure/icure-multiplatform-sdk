// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "and_predicate.freezed.dart";


@freezed
abstract class AndPredicate with _$AndPredicate implements Predicate {
	const factory AndPredicate({
		@Default([]) List<Predicate> predicates,
	}) = _AndPredicate;


	static Map<String, dynamic> encode(AndPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static AndPredicate fromJSON(Map<String, dynamic> data) {
		return AndPredicate(
			predicates: (data["predicates"] as List<dynamic>).map((x0) => Predicate.fromJSON(x0) ).toList()
		);
	}
}