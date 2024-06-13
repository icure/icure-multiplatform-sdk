package com.icure.sdk.js.model.filter.predicate

import com.icure.sdk.model.filter.predicate.AlwaysPredicate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun alwaysPredicate_toJs(obj: AlwaysPredicate): AlwaysPredicateJs =
		AlwaysPredicateJs(js("{" +
"}"))

public fun alwaysPredicate_fromJs(obj: AlwaysPredicateJs): AlwaysPredicate = AlwaysPredicate(
)
