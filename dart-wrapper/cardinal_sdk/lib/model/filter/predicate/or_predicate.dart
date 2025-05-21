// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "or_predicate.freezed.dart";


@freezed
abstract class OrPredicate with _$OrPredicate implements Predicate {
	const factory OrPredicate({
		@Default([]) List<Predicate> predicates,
	}) = _OrPredicate;


	static Map<String, dynamic> encode(OrPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static OrPredicate fromJSON(Map<String, dynamic> data) {
		return OrPredicate(
			predicates: (data["predicates"] as List<dynamic>).map((x0) => Predicate.fromJSON(x0) ).toList()
		);
	}
}