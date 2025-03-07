package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.utils.DefaultValue

/**
 * A reference to a data owner in a group.
 * @param dataOwnerId the id of the data owner
 * @param groupId the id of the data owner's group. If left null it is implied to be the same group as the data owner
 * currently logged in to the SDK.
 */
data class DataOwnerReferenceInGroup(
	val dataOwnerId: String,
	@DefaultValue("null")
	val groupId: String? = null
) {
	/**
	 * @param inGroup the group where the reference is to be used
	 * @param sdkGroupId the group id of the SDK using this reference, used as the default group if [groupId] is null
	 */
	internal fun asReferenceStringInGroup(inGroup: String?, sdkGroupId: String?): String {
		if (sdkGroupId == null) require(inGroup == null) { "Can't use in-group methods on kraken-lite" }
		val thisGroup = groupId ?: sdkGroupId
		val forGroup = inGroup ?: sdkGroupId
		return if (thisGroup != forGroup) "$thisGroup/$dataOwnerId" else dataOwnerId
	}
}
