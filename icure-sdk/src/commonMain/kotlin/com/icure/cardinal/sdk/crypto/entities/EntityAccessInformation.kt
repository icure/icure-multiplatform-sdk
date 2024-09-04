package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.embed.AccessLevel
import kotlinx.serialization.Serializable

/**
 * Details on data owners with access to an entity
 */
@Serializable
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
) {
	companion object {
		internal fun buildPermissionsMap(
			permissionsList: List<Pair<String, AccessLevel>>
		) =
			permissionsList.groupBy { it.first }.mapValues { (_, permissions) ->
				if (permissions.any { it.second == AccessLevel.Write }) AccessLevel.Write else AccessLevel.Read
			}
	}

	/**
	 * Merges two access information. Keeps the highest permission level for each data owner, for example:
	 * - If data owner x has read permission in this and write in [other] (or vice versa), in the merged information data
	 *   owner x will have write permissions.
	 * - If data owner x has read permission in this and no permission in [other], in the merged information data owner
	 *   x will have read permissions.
	 */
	internal fun merge(other: EntityAccessInformation): EntityAccessInformation {
		val newPermissionsByDataOwnerId = other.permissionsByDataOwnerId + permissionsByDataOwnerId.mapValues { (dataOwnerId, accessLevel) ->
			if (other.permissionsByDataOwnerId[dataOwnerId] == AccessLevel.Write) {
				AccessLevel.Write
			} else {
				accessLevel
			}
		}
		return EntityAccessInformation(
			permissionsByDataOwnerId = newPermissionsByDataOwnerId,
			hasUnknownAnonymousDataOwners = hasUnknownAnonymousDataOwners || other.hasUnknownAnonymousDataOwners
		)
	}
}