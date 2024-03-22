package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface SecureDelegationsDecryptor : SecurityMetadataDecryptor {
	/**
	 * Get information for members of secure delegations in the entity. Also provides information for delegations with anonymous delegate and/or
	 * delegator if one of the delegation members is the current data owner (or a parent) AND can still access the exchange data used for that
	 * secure delegation.
	 */
	suspend fun getDelegationMemberDetails(entity: Encryptable): Map<SecureDelegationKeyString, SecureDelegationMembersDetails>
}