// auto-generated file
package com.icure.sdk.js.model.filter.predicate

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.model.filter.predicate.AndPredicate
import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun andPredicate_toJs(obj: AndPredicate): AndPredicateJs {
	val predicates = listToArray(
		obj.predicates,
		{ x1: Predicate ->
			predicate_toJs(x1)
		},
	)
	return AndPredicateJs(js("{" +
		"predicates:predicates" +
	"}"))
}

public fun andPredicate_fromJs(obj: AndPredicateJs): AndPredicate {
	val predicates = arrayToList(
		obj.predicates,
		"obj.predicates",
		{ x1: PredicateJs ->
			predicate_fromJs(x1)
		},
	)
	return AndPredicate(
		predicates = predicates,
	)
}
