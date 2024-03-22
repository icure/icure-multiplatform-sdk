package com.icure.sdk.crypto.entities

import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.utils.InternalIcureApi

/**
 * Details on data owners with access to an entity
 */
@InternalIcureApi
data class EntityAccessInformation(
	/**
	 * The data owners with access to the entity, and how
	 */
	val permissionsByDataOwnerId: Map<String, AccessLevel>,
	/**
	 * Whether the entity has been shared with anonymous data owner who could not be identified by the current data
	 * owner.
	 */
	val hasUnknownAnonymousDataOwners: Boolean
)