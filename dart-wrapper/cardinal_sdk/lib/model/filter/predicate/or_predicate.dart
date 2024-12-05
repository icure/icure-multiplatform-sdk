// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class OrPredicate implements Predicate {
	List<Predicate> predicates = [];
	OrPredicate({
			List<Predicate>? predicates}) : predicates = predicates ?? [];

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