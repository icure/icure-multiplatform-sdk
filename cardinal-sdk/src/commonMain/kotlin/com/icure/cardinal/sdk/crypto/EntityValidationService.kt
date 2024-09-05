package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.utils.InternalIcureApi
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
	 * @throws EntityEncryptionException if any of the content of the entity should be encrypted but is still in clear
	 * in the entity.
	 * @return [encryptedEntity] unmodified if it is valid (throws exception if not).
	 */
	suspend fun <E> validateEncryptedEntity(
		encryptedEntity: EntityWithTypeInfo<E>,
		encryptedEntitySerializer: SerializationStrategy<E>,
		fieldsToEncrypt: EncryptedFieldsManifest
	): E where E : Encryptable, E : HasEncryptionMetadata
}
