// auto-generated file
@file:JsQualifier("Filter")

package com.icure.sdk.js.model.filter

import com.icure.sdk.js.model.base.IdentifiableJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("IdsFilter")
public external interface FilterJs_IdsFilterJs<T, O : IdentifiableJs<T>> : FilterJs<O> {
	public val ids: Array<T>
}

@JsName("UnionFilter")
public external interface FilterJs_UnionFilterJs<O : IdentifiableJs<*>> : FilterJs<O> {
	public val filters: Array<out FilterJs<O>>
}

@JsName("IntersectionFilter")
public external interface FilterJs_IntersectionFilterJs<O : IdentifiableJs<*>> : FilterJs<O> {
	public val filters: Array<out FilterJs<O>>
}

@JsName("ComplementFilter")
public external interface FilterJs_ComplementFilterJs<O : IdentifiableJs<*>> : FilterJs<O> {
	public val superSet: FilterJs<O>

	public val subSet: FilterJs<O>
}

@JsName("AllFilter")
public external interface FilterJs_AllFilterJs<O : IdentifiableJs<*>> : FilterJs<O>

@JsName("ByHcpartyFilter")
public external interface FilterJs_ByHcpartyFilterJs<O : IdentifiableJs<*>> : FilterJs<O> {
	public val hcpId: String
}
