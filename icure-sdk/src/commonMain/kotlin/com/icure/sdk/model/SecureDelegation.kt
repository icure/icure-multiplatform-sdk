package com.icure.sdk.model

/**
 * Represents a delegation which allows a data owner to access the encrypted data of an entity and specifies his access control level.
 * The encrypted  metadata is created by a "delegator" data owner, and can be used also by a "delegate" data owner. To create new
 * [SecureDelegation] the "delegate" and "delegator" data owners must have created some [ExchangeData]: their [ExchangeData.exchangeKey]
 * is used for the encryption of the content of this delegation, while its [ExchangeData.accessControlSecret] is used for creating the key
 * of [SecurityMetadata.secureDelegations].
 * New [SecureDelegation] will be created in two situations:
 * - When a data owner creates a new entity he will also add [SecureDelegation] where he is both delegator and delegate.
 * - When a data owner wants to share an entity with another data owner he will create new [SecureDelegation] where he
 * is the delegator and the other data owner is the delegate.
 * ## Optionally explicit delegator and delegate
 * The [SecureDelegation] can optionally include explicitly the id of the [delegator] and [delegate] data owners using the
 * respective fields:
 * - When the id of a data owner is explicit the server can know at any moment which users have access to which data. This
 * allows to more easily search for all data that a specific user can access, as access control rights can be checked easily
 * by the server. At the same time, however, this could break confidentiality of the data, because for example knowing that
 * a patient has access to some medical data means that the data is likely about that patient or a close relative, and if
 * the data includes some unencrypted codes this may leak medical information for the patient.
 * - When the id of a data owner is not explicit the data owner will have to know beforehand the access control key to be used
 * for access control, as the server does not have a way of knowing who is the delegator and/or delegate of the secure delegation.
 * A user with only a few instances of exchange data can easily load all his access control keys and pass them to the api method,
 * but this may not be possible for hcps, as they could have exchange data with many of their patients.
 * In general users will want to hide the delegator/delegate id for patient and medical devices data owners, in order to keep
 * data confidentiality. For hcps instead the best choice depends is likely to change depending on the product.
 */
data class SecureDelegation(
	/**
	 * Optionally the id of the delegator data owner for this [SecureDelegation]. May be null if this information must
	 * be hidden to prevent data leakages (see class documentation for more details).
	 */
	val delegator: String? = null,
	/**
	 * Optionally the id of the delegate data owner for this [SecureDelegation]. May be null if this information must
	 * be hidden to prevent data leakages (see class documentation for more details).
	 */
	val delegate: String? = null,
	/**
	 * Secret id of the entity holding this [SecureDelegation] (formerly `delegation`). The id will appear in plaintext in the
	 * `secretForeignKeys` field of children entities.
	 */
	val secretIds: Set<Base64String> = emptySet(),
	/**
	 * Encrypted aes key used for the encryption of the entity's data (data stored in `encryptedSelf`).
	 */
	val encryptionKeys: Set<Base64String> = emptySet(),
	/**
	 * Encrypted id of the entity which owns the entity holding this [SecureDelegation] (formerly `cryptedForeignKey`),
	 * such as the id of the patient for a contact or healthcare element.
	 */
	val owningEntityIds: Set<Base64String> = emptySet(),
	/**
	 * Key of the parent delegation in the [SecurityMetadata.secureDelegations]. Users are allowed to modify/delete
	 * only [SecureDelegation] that they can directly access or any children delegations.
	 */
	val parentDelegations: Set<SecureDelegationKeyString> = emptySet(),
	/**
	 * If both the [delegator] and [delegate] are explicit in this secure delegation this field will hold the id of the exchange
	 * data used for the encryption of this delegation. Otherwise, this will be null.
	 */
	val exchangeDataId: String? = null,
	/**
	 * Permissions of users with access to this [SecureDelegation] on the corresponding entity. Each entry represents
	 * a field or group of fields of the entity that the user can read and/or modify; any field not covered by this map
	 * will not be accessible to the users. Note that the same user may have access to multiple instances of [SecureDelegation]
	 * for the same entity with different permission levels.
	 * The permissions only refer to the actual content of the entity and not to any metadata (excluding the `encryptedSelf`):
	 * - any data owner is always allowed to extend his [SecureDelegation] or its children (according to the hierarchy specified
	 * by the [parentDelegations]).
	 * - any data owner can create new [SecureDelegation] to share an entity he can access with other data owners, but he can
	 * only give equivalent or lower permissions.
	 * Top level delegations must not specify any permissions, as any top-level delegation implicitly has full-write-permissions.
	 * All other delegations instead must specify at least a permission.
	 * The full syntax of permissions is to be defined, currently only "*" is allowed as a key, meaning all entries: essentially
	 * currently it is only possible to give full-read-permissions or full-write-permissions. This should allow for a smoother
	 * transition when fine-grained permissions will be implemented.
	 */
	val permissions: AccessLevel
)
