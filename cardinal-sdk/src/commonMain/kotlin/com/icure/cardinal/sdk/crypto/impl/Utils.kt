package com.icure.cardinal.sdk.crypto.impl

fun mapGroupIdWithBoundGroupId(groupId: String?, boundGroupId: String?): String? {
	if (boundGroupId == null) require(groupId == null) {
		"Can't use in-group methods on kraken-lite"
	}
	return if (groupId == boundGroupId) null else groupId
}