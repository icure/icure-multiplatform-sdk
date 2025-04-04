package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable

/**
 * Wraps an entity and associates it with the group it exists in.
 *
 * In-group api methods take in input and return group scoped entities.
 *
 * To prevent mistakes, you shouldn't instantiate this class yourself, instead you should always get the GroupScoped
 * entity from the `inGroup` methods of the apis. Using GroupScoped entities with the wrong groupId, or created by
 * instances of the SDK working on a different base group, can cause errors and other unexpected behavior.
 */
@Serializable
data class GroupScoped<out E>(val entity: E, val groupId: String)
