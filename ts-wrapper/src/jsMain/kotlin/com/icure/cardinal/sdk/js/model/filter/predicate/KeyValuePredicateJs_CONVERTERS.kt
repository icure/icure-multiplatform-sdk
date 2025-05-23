// auto-generated file
package com.icure.cardinal.sdk.js.model.filter.predicate

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.anyPrimitive_fromJs
import com.icure.cardinal.sdk.js.model.specializations.anyPrimitive_toJs
import com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate
import com.icure.cardinal.sdk.model.filter.predicate.Operator
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun keyValuePredicate_toJs(obj: KeyValuePredicate): KeyValuePredicateJs {
	val key = nullToUndefined(
		obj.key
	)
	val operator = nullToUndefined(
		obj.operator?.let { nonNull1 ->
			nonNull1.name
		}
	)
	val value = nullToUndefined(
		obj.value?.let { nonNull1 ->
			anyPrimitive_toJs(nonNull1)
		}
	)
	return KeyValuePredicateJs(js("{" +
		"key:key," +
		"operator:operator," +
		"value:value" +
	"}"))
}

public fun keyValuePredicate_fromJs(obj: KeyValuePredicateJs): KeyValuePredicate {
	val key = undefinedToNull(obj.key)
	val operator = obj.operator?.let { nonNull1 ->
		Operator.valueOf(nonNull1)
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
