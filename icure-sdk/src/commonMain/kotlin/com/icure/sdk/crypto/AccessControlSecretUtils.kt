package com.icure.sdk.crypto

import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.utils.InternalIcureApi

/**
 * A service to compute access control keys and secure delegation keys.
 * Does not depend on the authenticated user.
 */
@InternalIcureApi
interface AccessControlSecretUtils {
	companion object {
		/**
		 * Size of the access control keys (in bytes) returned by this class.
		 */
		const val ACCESS_CONTROL_KEY_LENGTH_BYTES = 16
	}

	/**
	 * Get the access control key to use for entities of the provided type. The combination of secret foreign keys and
	 * entity type ensures that unauthorised people will not be able to draw links between entities of different types.
	 * These keys can be used to derive the "secure delegation keys", and will be sent to the iCure server for access
	 * control of "anonymous" data owners.
	 * @param accessControlSecret an access control secret
	 * @param entityTypeName an entity type name
	 * @return the access control key to use for entities of the provided type.
	 */
	suspend fun accessControlKeyFor(
		accessControlSecret: String,
		entityTypeName: EntityWithDelegationTypeName,
	): ByteArray

	/**
	 * Get value to use as key in secure delegations for entities of the provided type. The combination of secret
	 * foreign keys and entity type ensures that unauthorised people will not be able to draw links between entities of
	 * different types.
	 * These keys are derived from the access control keys and will be used in the secure delegations map of security
	 * metadata.
	 * @param accessControlSecret an access control secret
	 * @param entityTypeName an entity type name
	 */
	suspend fun secureDelegationKeyFor(
		accessControlSecret: String,
		entityTypeName: EntityWithDelegationTypeName,
	): String

	/**
	 *
	 */
	suspend fun getAccessControlKeysHeaders(
		accessControlSecrets: List<String>,
		entityTypeName: EntityWithDelegationTypeName
	): Pair<String, List<String>> // TODO Ktorify header
}