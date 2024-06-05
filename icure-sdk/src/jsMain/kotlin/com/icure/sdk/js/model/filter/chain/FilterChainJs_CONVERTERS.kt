package com.icure.sdk.js.model.filter.chain

import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.abstractFilter_toJs
import com.icure.sdk.js.model.filter.predicate.predicate_fromJs
import com.icure.sdk.js.model.filter.predicate.predicate_toJs
import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.chain.FilterChain
import kotlin.String

public fun <O : Identifiable<String>, O_JS : IdentifiableJs<String>>
		filterChain_toJs(obj: FilterChain<O>, convertO: (O) -> O_JS): FilterChainJs<O_JS> {
	val filter = abstractFilter_toJs(
		obj.filter,
		{ x1: O ->
			convertO(x1)
		},
	)
	val predicate = obj.predicate?.let { nonNull1 ->
		predicate_toJs(nonNull1)
	}
	return FilterChainJs<O_JS>(js("{" +
		"filter:filter," +
		"predicate:predicate" +
	"}"))
}

public fun <O : IdentifiableJs<String>, O_KT : Identifiable<String>>
		filterChain_fromJs(obj: FilterChainJs<O>, convertO: (O) -> O_KT): FilterChain<O_KT> {
	val filter = abstractFilter_fromJs(
		obj.filter,
		{ x1: O ->
			convertO(x1)
		},
	)
	val predicate = obj.predicate?.let { nonNull1 ->
		predicate_fromJs(nonNull1)
	}
	return FilterChain<O_KT>(
		filter = filter,
		predicate = predicate,
	)
}
