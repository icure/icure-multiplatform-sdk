// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class OrPredicate implements Predicate {
	List<Predicate> predicates = [];

	OrPredicate({
		List<Predicate>? predicates
	}) : predicates = predicates ?? [];

	static Map<String, dynamic> encode(OrPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0))
		};
		return entityAsMap;
	}
}