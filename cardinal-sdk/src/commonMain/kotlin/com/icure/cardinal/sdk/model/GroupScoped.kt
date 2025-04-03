package com.icure.cardinal.sdk.model

import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * Wraps an entity and associates it with the group it exists in.
 *
 * In-group api methods take in input and return group scoped entities.
 * Normally you shouldn't instantiate this class yourself, and should instead always
 */
@Serializable
data class GroupScoped<E : Any> @InternalIcureApi constructor (val entity: E, val group: String)