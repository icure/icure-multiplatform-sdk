package com.icure.sdk.model.extensions

import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.utils.InternalIcureApi

/**
 * Get the data owner id of the user.
 * @throws IllegalArgumentException if the user is not a data owner.
 */
@InternalIcureApi
val User.dataOwnerId get() =
	requireNotNull(healthcarePartyId ?: patientId ?: deviceId) {
		"User ${this.id} must be a data owner but does not have a data owner id - $this"
	}

@InternalIcureApi
fun User.autoDelegationsFor(
	vararg tags: DelegationTag,
	includeTagAll: Boolean = true,
): Map<String, AccessLevel> {
	val allTags = if (includeTagAll) setOf(DelegationTag.All, *tags) else tags.toSet()
	return allTags.flatMapTo(mutableSetOf<String>()) { tag ->
		autoDelegations[tag] ?: emptySet()
	}.associateWith { AccessLevel.Write }
}