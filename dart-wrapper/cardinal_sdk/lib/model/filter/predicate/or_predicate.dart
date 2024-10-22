// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class OrPredicate implements Predicate {
	List<Predicate> predicates = [];
	OrPredicate({
			List<Predicate>? predicates}) : predicates = predicates ?? [];

	factory OrPredicate.fromJSON(Map<String, dynamic> data) {
		return OrPredicate(
			predicates: data["predicates"].map((x0) => Predicate.fromJSON(x0) )
		);
	}

	static Map<String, dynamic> encode(OrPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicates" : value.predicates.map((x0) => Predicate.encode(x0))
		};
		return entityAsMap;
	}
}