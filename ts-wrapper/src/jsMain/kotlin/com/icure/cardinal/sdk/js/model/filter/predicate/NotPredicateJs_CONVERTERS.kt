// auto-generated file
package com.icure.cardinal.sdk.js.model.filter.predicate

import com.icure.cardinal.sdk.model.filter.predicate.NotPredicate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun notPredicate_toJs(obj: NotPredicate): NotPredicateJs {
	val predicate = predicate_toJs(obj.predicate)
	return NotPredicateJs(js("{" +
		"predicate:predicate" +
	"}"))
}

public fun notPredicate_fromJs(obj: NotPredicateJs): NotPredicate {
	val predicate = predicate_fromJs(obj.predicate)
	return NotPredicate(
		predicate = predicate,
	)
}
