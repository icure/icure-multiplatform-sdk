package com.icure.sdk.js.model.filter.predicate

import com.icure.sdk.model.filter.predicate.NotPredicate

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
