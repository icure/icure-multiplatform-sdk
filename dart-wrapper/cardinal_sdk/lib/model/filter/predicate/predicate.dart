// This file is auto-generated
import 'package:cardinal_sdk/model/filter/predicate/not_predicate.dart';
import 'package:cardinal_sdk/model/filter/predicate/and_predicate.dart';
import 'package:cardinal_sdk/model/filter/predicate/always_predicate.dart';
import 'package:cardinal_sdk/model/filter/predicate/or_predicate.dart';
import 'package:cardinal_sdk/model/filter/predicate/key_value_predicate.dart';


abstract interface class Predicate {

	static Map<String, dynamic> encode(Predicate value) {
		switch (value) {
			case NotPredicate entity:
				Map<String, dynamic> entityJson = NotPredicate.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.filter.predicate.NotPredicate";
				return entityJson;
			case AndPredicate entity:
				Map<String, dynamic> entityJson = AndPredicate.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.filter.predicate.AndPredicate";
				return entityJson;
			case AlwaysPredicate _:
				return {"kotlinType": "com.icure.cardinal.sdk.model.filter.predicate.AlwaysPredicate"};
			case OrPredicate entity:
				Map<String, dynamic> entityJson = OrPredicate.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.filter.predicate.OrPredicate";
				return entityJson;
			case KeyValuePredicate entity:
				Map<String, dynamic> entityJson = KeyValuePredicate.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass ${value}');
		}
	}
}