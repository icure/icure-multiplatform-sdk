package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface SecureDelegationsDecryptor : SecurityMetadataDecryptor {
	/**
	 * Get information for members of secure delegations in the entity. Also provides information for delegations with anonymous delegate and/or
	 * delegator if one of the delegation members is the current data owner (or a parent) AND can still access the exchange data used for that
	 * secure delegation.
	 */
	suspend fun getDelegationMemberDetails(entity: EntityWithTypeInfo<*>): Map<SecureDelegationKeyString, SecureDelegationMembersDetails>
}