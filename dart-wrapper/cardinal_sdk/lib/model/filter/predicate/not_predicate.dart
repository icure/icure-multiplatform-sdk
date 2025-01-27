// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';


class NotPredicate implements Predicate {
	Predicate predicate;
	NotPredicate(this.predicate);

	static Map<String, dynamic> encode(NotPredicate value) {
		Map<String, dynamic> entityAsMap = {
			"predicate" : Predicate.encode(value.predicate)
		};
		return entityAsMap;
	}

	static NotPredicate fromJSON(Map<String, dynamic> data) {
		return NotPredicate(
			Predicate.fromJSON(data["predicate"])
		);
	}
}