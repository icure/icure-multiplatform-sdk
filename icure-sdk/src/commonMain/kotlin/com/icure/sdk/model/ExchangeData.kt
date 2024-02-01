package com.icure.sdk.model

import kotlinx.serialization.Serializable

/**
 * Data necessary for the secure sharing of entities between data owners.
 */
@Serializable
data class ExchangeData(
	val id: String,
	val rev: String? = null,
	/**
	 * ID of the data owner which created this exchange data, in order to share some data with the [delegate].
	 */
	val delegator: String,
	/**
	 * ID of a data owner which can use this exchange data to access data shared with him by [delegator].
	 */
	val delegate: String,
	/**
	 * Aes key to use for sharing data from the delegator to the delegate, encrypted with the public keys of both
	 * delegate and delegator. This key should never be sent decrypted to the server, as it allows to read medical data.""")
	 */
	val exchangeKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Key used for access control to data shared from the delegator to the delegate, encrypted with the public keys of both
	 * delegate and delegator.
	 * This key will be used by the client to calculate the keys of [SecurityMetadata.secureDelegations] in
	 * [HasSecureDelegationsAccessControl.securityMetadata] which allows to implement a form of access control where the
	 * identity of data owners with access to a specific entity can't be deduced from the database alone. This is useful
	 * for example to allow patients to access their medical data without creating a deducible link between the patient
	 * and the medical data in the database.
	 * There are no strict requirements on how the client should use this secret to create the security metadata key,
	 * but for authentication the client must be able to provide a 128 bit long access control key (see
	 * [DataOwnerAuthenticationDetails.accessControlKeys]) which once hashed using sha256 will give the key of the
	 * security metadata.
	 * However, in order to avoid introducing undesired links between entities which could be detrimental to the
	 * patients privacy the access control keys should be created also using information on the entity class and secret
	 * foreign keys of the entity holding the delegation, in order to ensure that in case of different confidentiality
	 * settings for the entity the security metadata key will also be different and won't leak information on links
	 * between data.
	 * ```
	 * accessControlKey = sha256Bytes(accessControlSecret + entityClass + sfk[0]).take(16)
	 * securityMetadataKey = sha256Hex(accessControlKey)
	 */
	val accessControlSecret: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Signature to ensure the key data has not been tampered with by third parties (any actor without access to the
	 * keypair of the delegator/delegate): when creating new exchange data the delegator will create a new hmac key and
	 * sign it with his own private key.
	 * This field will contain the signature by fingerprint of the public key to use for verification.
	 */
	val delegatorSignature: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Encrypted signature key (hmac-sha256) shared between delegate and delegator, to allow either of them to modify
	 * the exchange data, without voiding the authenticity guarantee.
	 */
	val sharedSignatureKey: Map<KeypairFingerprintV2String, Base64String>,
	/**
	 * Base 64 signature of the exchange data, to ensure it was not tampered by third parties. This signature validates:
	 * - The (decrypted) exchange key
	 * - The (decrypted) access control secret
	 * - The delegator and delegates being part of the exchange data
	 * - The public keys used in the exchange data (allows to consider them as verified in a second moment).""")
	 */
	val sharedSignature: Base64String
)
