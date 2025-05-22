package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.utils.generation.JsMapAsObjectArray
import kotlinx.serialization.Serializable

/**
 * Details on data owners with access to an entity
 */
@Serializable
data class EntityAccessInformation(
	/**
	 * The data owners with access to the entity, and the access level they have to the entity.
	 *
	 * When not using intergroup sharing the [EntityReferenceInGroup.groupId] will always be null.
	 *
	 * When using intergroup sharing the [EntityReferenceInGroup.groupId] is always represented in relation to the group
	 * of the SDK used to get this information: if the SDK is working by default on `groupU` and you extract the access
	 * information from an entity coming from `groupE` accessible to `dataOwnerA` in `groupU` and `dataOwnerB` in
	 * `groupB` the keys will be `EntityReferenceInGroup(dataOwnerA, null)` and
	 * `EntityReferenceInGroup(dataOwnerB, groupE)`.
	 */
	val permissionsByDataOwnerId: @JsMapAsObjectArray(keyEntryName = "delegate", valueEntryName = "accessLevel") Map<EntityReferenceInGroup, AccessLevel>,
	/**
	 * True if the entity has been shared with anonymous data owners which couldn't be identified using the information
	 * available to the instance of SDK used.
	 */
	val hasUnknownAnonymousDataOwners: Boolean
) {
	companion object {
		internal fun buildPermissionsMap(
			permissionsList: List<Pair<EntityReferenceInGroup, AccessLevel>>
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