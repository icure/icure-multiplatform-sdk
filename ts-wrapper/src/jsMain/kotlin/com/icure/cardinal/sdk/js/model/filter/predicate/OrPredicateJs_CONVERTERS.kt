// auto-generated file
package com.icure.cardinal.sdk.js.model.filter.predicate

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.model.filter.predicate.OrPredicate
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun orPredicate_toJs(obj: OrPredicate): OrPredicateJs {
	val predicates = listToArray(
		obj.predicates,
		{ x1: Predicate ->
			predicate_toJs(x1)
		},
	)
	return OrPredicateJs(js("{" +
		"predicates:predicates" +
	"}"))
}

public fun orPredicate_fromJs(obj: OrPredicateJs): OrPredicate {
	val predicates = arrayToList(
		obj.predicates,
		"obj.predicates",
		{ x1: PredicateJs ->
			predicate_fromJs(x1)
		},
	)
	return OrPredicate(
		predicates = predicates,
	)
}
