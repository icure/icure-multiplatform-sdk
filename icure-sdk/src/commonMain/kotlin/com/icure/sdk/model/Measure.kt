/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */
package com.icure.sdk.model

import kotlinx.serialization.Serializable

/**
 * A measure is a value that can be associated to a result.
 */
@Serializable
data class Measure(
    /**
     * value of the measure
     */
    val value: Double? = null,
    /**
     * lower bound of the reference range
     * @deprecated use referenceRanges instead
     */
    val min: Double? = null,
    /**
     * higher bound of the reference range
     * @deprecated use referenceRanges instead
     */
    val max: Double? = null,
    val ref: Double? = null,
    val severity: Int? = null,
    val severityCode: String? = null,
    val evolution: Int? = null,
    /**
     * unit of the measure
     */
    val unit: String? = null,
    val sign: String? = null,
    /**
     * unit codes of the measure
     */
    val unitCodes: Set<CodeStub>? = null,
    val comment: String? = null,
    val comparator: String? = null,
    /**
     * reference range of the measure
     *
     * conversion from min/max is done at the client side level since most of the data are encrypted, we can't do it at the server level (or we can, but it will be a lot of work for very little data that aren't encrypted)
     */
//    val referenceRanges: List<ReferenceRange> = emptyList()
)
