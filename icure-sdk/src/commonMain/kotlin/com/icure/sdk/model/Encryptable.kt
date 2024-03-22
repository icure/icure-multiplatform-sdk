package com.icure.sdk.model

interface Encryptable {
	/**
	 * Security metadata for the entity, contains metadata necessary for access control.
	 * In [Encryptable] entities this is also used to store additional encrypted metadata on the entity, including encryption keys for the
	 * [Encryptable.encryptedSelf] (replacing [Encryptable.encryptionKeys]), owning entity id (replacing [Encryptable.cryptedForeignKeys]),
	 * and secret id (replacing the keys of [Encryptable.delegations]).
	 */
	val securityMetadata: SecurityMetadata?

	/**
	 * The secretForeignKeys are filled at the to-many end of a one-to-many relationship (for example inside Contact for the Patient -> Contacts relationship).
	 * Used when we want to find all contacts for a specific patient.
	 * These keys are in clear. You can have several to partition the medical document space.
	 */
	val secretForeignKeys: Set<String>

	//Used when we want to find the patient for this contact
	//These keys are the public patient ids encrypted using the hcParty keys.
	/**
	 * The secretForeignKeys are filled at the to many end of a one to many relationship (for example inside Contact for the Patient -> Contacts relationship).
	 * Used when we want to find the patient for a specific contact. These keys are the encrypted id (using the hcParty key for the delegate) that can be found in clear inside the patient
	 * ids encrypted using the hcParty keys.
	 * With the introduction of [securityMetadata] sdks will stop adding new data to this field, and instead use the [securityMetadata], but the field may still be read
	 * and/or some of his content may be deleted.
	 */
	val cryptedForeignKeys: Map<String, Set<Delegation>>

	//When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities)
	//He/she encrypts it using his own AES exchange key and stores it as a delegation
	//The responsible is thus always in the delegations as well
	/**
	 * When a document is created, the responsible generates a cryptographically random master key (never to be used for something else than referencing from other entities).
	 * He/she encrypts it using his own AES exchange key and stores it as a delegation. The responsible is thus always in the delegations as well.
	 * With the introduction of [securityMetadata] sdks will stop adding new data to this field, and instead use the [securityMetadata], but the field may still be read
	 * and/or some of his content may be deleted.
	 */
	val delegations: Map<String, Set<Delegation>>

	//When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear in clear anywhere in the db)
	//He/she encrypts it using his own AES exchange key and stores it as a delegation
	/**
	 * When a document needs to be encrypted, the responsible generates a cryptographically random master key (different from the delegation key, never to appear
	 * in clear anywhere in the db). He/she encrypts it using his own AES exchange key and stores it as a delegation.
	 * With the introduction of [securityMetadata] sdks will stop adding new data to this field, and instead use the [securityMetadata], but the field may still be read
	 * and/or some of his content may be deleted.
	 */
	val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64 encoded data of this object, formatted as JSON and encrypted in AES using the random master key from encryptionKeys.
	 */
	val encryptedSelf: Base64String?
}