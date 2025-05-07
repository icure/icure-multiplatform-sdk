package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.AccessControlSecret
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class SecureDelegationMembersDetails(
	/**
	 * Delegator of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegator: EntityReferenceInGroup?,
	/**
	 * Delegate of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegate: EntityReferenceInGroup?,
	/**
	 * If the delegation was fully explicit.
	 */
	val fullyExplicit: Boolean,
	/**
	 * Access control secret associated to the exchange data used for the secure delegation, if known and if the
	 * delegation was not fully explicit.
	 */
	val accessControlSecret: AccessControlSecret?,
	/**
	 * Access level granted by the delegation.
	 */
	val accessLevel: AccessLevel,
)