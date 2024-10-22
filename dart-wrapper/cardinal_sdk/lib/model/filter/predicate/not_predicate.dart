// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class NotPredicate implements Predicate {
	Predicate predicate;
	NotPredicate(this.predicate);

	factory NotPredicate.fromJSON(Map<String, dynamic> data) {
		return NotPredicate(
			Predicate.fromJSON(data["predicate"])
		);
	}

	static Map<String, dynamic> encode(NotPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicate" : Predicate.encode(value.predicate)
		};
		return entityAsMap;
	}
}