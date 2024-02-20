package com.icure.sdk.crypto.entities

import com.icure.sdk.model.AccessControlSecret
import com.icure.sdk.model.AccessLevel
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class SecureDelegationMembersDetails(
	/**
	 * Delegator of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegator: String?,
	/**
	 * Delegate of the delegation, if known (obtained from the delegation or from the exchange data).
	 */
	val delegate: String?,
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