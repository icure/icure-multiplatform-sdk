package com.icure.sdk.api

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
class HealthElementApi(
	private val rawApi: RawHealthElementApi,
	private val encryptionService: EntityEncryptionService
) {
	suspend fun initialiseEncryptionMetadata(
		he: HealthElement,
		patient: Patient,
		// Temporary, needs a lot more stuff to match typescript implementation
	): HealthElement =
		// TODO auto delegations
		encryptionService.entityWithInitialisedEncryptedMetadata(
			he,
			patient.id,
			encryptionService.secretIdsOf(patient, null).first(),
			true,
			false,
			emptyMap()
		).updatedEntity

	suspend fun getAndDecrypt(contactId: String) = rawApi.getHealthElement(contactId).successBody().let { p ->
		encryptionService.tryDecryptEntity(p, HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }
	}

	suspend fun encryptAndCreate(he: HealthElement) = encryptionService.encryptEntity(
		he,
		HealthElement.serializer(),
		EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap()),
	) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }.let { rawApi.createHealthElement(it) }.successBody().let {
		encryptionService.tryDecryptEntity(it, HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }
	}

	suspend fun shareWith(
		delegateId: String,
		he: HealthElement,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite
	): SimpleShareResult<HealthElement> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			he,
			true,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = null,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = shareOwningEntityIds,
					requestedPermissions = requestedPermission
				)
			)
		) {
			rawApi.bulkShare(it).successBody()
		}
}