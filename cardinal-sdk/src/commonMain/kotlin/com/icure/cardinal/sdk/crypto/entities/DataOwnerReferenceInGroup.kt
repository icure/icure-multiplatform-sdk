package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

/**
 * A reference to a data owner in a group.
 * @param dataOwnerId the id of the data owner
 * @param groupId the id of the data owner's group. If left null it is implied to be the same group as the data owner
 * currently logged in to the SDK.
 */
@Serializable
data class DataOwnerReferenceInGroup(
	val dataOwnerId: String,
	@DefaultValue("null")
	val groupId: String? = null
) {
	/**
	 * @param inGroup the group where the reference is to be used
	 * @param sdkGroupId the group id of the SDK using this reference, used as the default group if [groupId] is null
	 */
	@InternalIcureApi
	internal fun asReferenceStringInGroup(inGroup: String?, sdkGroupId: SdkBoundGroup?): String {
		if (sdkGroupId == null) require(inGroup == null) { "Can't use in-group methods on kraken-lite" }
		val thisGroup = groupId ?: sdkGroupId?.groupId
		val forGroup = inGroup ?: sdkGroupId?.groupId
		return if (thisGroup != forGroup) "$thisGroup/$dataOwnerId" else dataOwnerId
	}

	@InternalIcureApi
	internal fun normalized(sdkGroupId: SdkBoundGroup?): DataOwnerReferenceInGroup {
		if (sdkGroupId == null) require(groupId == null) { "Can't use in-group references on kraken-lite" }
		return if (groupId != null && groupId == sdkGroupId?.groupId) DataOwnerReferenceInGroup(dataOwnerId, null) else this
	}

	companion object {
		@InternalIcureApi
		internal fun parse(
			dataOwnerReference: String,
			entityGroup: String?,
			sdkGroupId: SdkBoundGroup?
		): DataOwnerReferenceInGroup {
			val splitReference = dataOwnerReference.split("/")
			val resolvedEntityGroup = sdkGroupId.resolve(entityGroup)
			require(splitReference.size == 1 || splitReference.size == 2) {
				"Invalid user reference $dataOwnerReference"
			}
			return if (resolvedEntityGroup != null) {
				when {
					splitReference.size == 1 -> DataOwnerReferenceInGroup(dataOwnerId = splitReference[0], groupId = resolvedEntityGroup)
					splitReference[0] == sdkGroupId?.groupId -> DataOwnerReferenceInGroup(dataOwnerId = splitReference[1], groupId = null)
					else -> DataOwnerReferenceInGroup(dataOwnerId = splitReference[1], groupId = splitReference[0])
				}
			} else {
				if (splitReference.size == 1)
					DataOwnerReferenceInGroup(dataOwnerId = splitReference[0])
				else
					DataOwnerReferenceInGroup(dataOwnerId = splitReference[1], groupId = splitReference[0])
			}
		}
	}
}
