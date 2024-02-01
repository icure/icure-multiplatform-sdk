package com.icure.sdk.apis

import com.icure.sdk.model.AccessLevel
import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.crypto.SecureDelegationStub

/**
 * API to support the creation of encrypted data from embedded devices.
 * You can get some metadata from this API which you can then send to embedded devices to support the creation of
 * encrypted medical data.
 */
interface IcureEmbeddedSupportApi {
	/**
	 * Get stubs for the creation of secure delegations in entities of the provided type.
	 *
	 * This method will always return at least one stub, which will support the creation of a secure delegation for the
	 * current data owner id.
	 * If you provided additional delegates the returned list will also contain a secure delegation for each of them
	 * (from the current data owner to that delegate).
	 *
	 * The returned stubs can be safely used to create multiple encrypted entities of the provided type (as long as
	 * the encryption keys and, if present, the secret ids of the entities are different).
	 *
	 * Note that the results of different calls to this method may be cached are not "compatible" with each other.
	 * If you merge the results of two different calls to this method once with additionalDelegate A, and once with
	 * additionalDelegate B, the resulting list may not be valid for the creation of an entity with secure delegations
	 * to both A and B.
	 *
	 * This method will automatically create any metadata needed for the future decryption of the secure delegations
	 * created using this stub (exchange data, exchange data maps, ...).
	 *
	 * @param additionalDelegates a map the id of additional delegates to include in the returned stubs, associated to
	 * the access level they should have in the secure delegation.
	 * @param entityType the type of entities which will be created using this stub.
	 * @return stubs providing the encryption key and other metadata needed to create a secure delegations to allow the
	 * current data owner and optionally other delegates to access a certain encrypted entity.
	 */
	suspend fun getOrCreateSecureDelegationStubs(
		additionalDelegates: Map<String, AccessLevel>,
		entityType: EntityWithDelegationTypeName
	): List<SecureDelegationStub>
}