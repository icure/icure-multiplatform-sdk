package com.icure.sdk.js.model.filter.predicate

import com.icure.sdk.js.model.specializations.anyPrimitive_fromJs
import com.icure.sdk.js.model.specializations.anyPrimitive_toJs
import com.icure.sdk.model.filter.predicate.KeyValuePredicate

public fun keyValuePredicate_toJs(obj: KeyValuePredicate): KeyValuePredicateJs {
	val key = obj.key
	val operator = obj.operator?.let { nonNull1 ->
		operator_toJs(nonNull1)
	}
	val value = obj.value?.let { nonNull1 ->
		anyPrimitive_toJs(nonNull1)
	}
	return KeyValuePredicateJs(js("{" +
		"key:key," +
		"operator:operator," +
		"value:value" +
	"}"))
}

public fun keyValuePredicate_fromJs(obj: KeyValuePredicateJs): KeyValuePredicate {
	val key = obj.key
	val operator = obj.operator?.let { nonNull1 ->
		operator_fromJs(nonNull1)
	}
	val value = obj.value?.let { nonNull1 ->
		anyPrimitive_fromJs(nonNull1)
	}
	return KeyValuePredicate(
		key = key,
		operator = operator,
		value = value,
	)
}
