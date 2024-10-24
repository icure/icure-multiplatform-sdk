// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class AndPredicate implements Predicate {
	List<Predicate> predicates = [];
	AndPredicate({
			List<Predicate>? predicates}) : predicates = predicates ?? [];

	factory AndPredicate.fromJSON(Map<String, dynamic> data) {
		return AndPredicate(
			predicates: data["predicates"].map((x0) => Predicate.fromJSON(x0) ).toList()
		);
	}

	static Map<String, dynamic> encode(AndPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0)).toList()
		};
		return entityAsMap;
	}
}