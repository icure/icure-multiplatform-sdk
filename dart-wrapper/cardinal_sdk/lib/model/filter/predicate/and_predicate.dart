// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class AndPredicate implements Predicate {
	List<Predicate> predicates = [];

	AndPredicate({
		List<Predicate>? predicates
	}) : predicates = predicates ?? [];

	static Map<String, dynamic> encode(AndPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0))
		};
		return entityAsMap;
	}
}