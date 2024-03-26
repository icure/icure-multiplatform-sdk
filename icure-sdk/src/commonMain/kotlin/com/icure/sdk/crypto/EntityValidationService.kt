package com.icure.sdk.crypto

import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.SerializationStrategy

/**
 * Validation of entities, can be used also if the current user is not a data owner.
 */
@InternalIcureApi
interface EntityValidationService {
	/**
	 * Verifies that the provided entity does not expose any field which should be encrypted according to the provided
	 * manifest. Can be used also if the current user is not a data owner or does not have access to any encryption keys
	 * of the entity.
	 * @throws IllegalArgumentException if any of the content of the entity should be encrypted but is still in clear
	 * in the entity.
	 * @return [encryptedEntity] unmodified if it is valid (throws exception if not).
	 */
	suspend fun <E: Encryptable> validateEncryptedEntity(
		encryptedEntity: E,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): E
}