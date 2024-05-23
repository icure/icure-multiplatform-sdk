// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.filter.chain

import com.icure.sdk.js.model.base.IdentifiableJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.predicate.PredicateJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("FilterChain")
public external class FilterChainJs<O : IdentifiableJs<String>>(
	partial: dynamic,
) {
	public val filter: AbstractFilterJs<O>

	public val predicate: PredicateJs?
}
