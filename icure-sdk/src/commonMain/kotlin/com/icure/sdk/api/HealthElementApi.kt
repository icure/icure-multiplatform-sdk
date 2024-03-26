package com.icure.sdk.api

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.model.requests.RequestedPermission
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
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent
		// Temporary, needs a lot more stuff to match typescript implementation
	): HealthElement =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			he.withTypeInfo(),
			patient.id,
			encryptionService.resolveSecretIdOption(patient.withTypeInfo(), secretId),
			true,
			false,
			delegates // TODO add auto delegations
		).updatedEntity

	suspend fun getAndDecrypt(contactId: String) = rawApi.getHealthElement(contactId).successBody().let { p ->
		encryptionService.tryDecryptEntity(p.withTypeInfo(), HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }
	}

	suspend fun encryptAndCreate(he: HealthElement) = encryptionService.encryptEntity(
		he.withTypeInfo(),
		HealthElement.serializer(),
		EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap()),
	) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }.let { rawApi.createHealthElement(it) }.successBody().let {
		encryptionService.tryDecryptEntity(it.withTypeInfo(), HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }
	}

	suspend fun shareWith(
		delegateId: String,
		he: HealthElement,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite
	): SimpleShareResult<HealthElement> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
			he.withTypeInfo(),
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

	suspend fun getHealthElementsFor(
		hcpId: String, // TODO This is slightly ugly... How was it done?
		patient: Patient
	): List<HealthElement> =
		rawApi.findHealthElementsByHCPartyPatientForeignKeys(
			hcpId,
			encryptionService.secretIdsOf(patient.withTypeInfo(), null).toList()
		).successBody().mapNotNull { decrypt(it) }

	suspend fun decrypt(he: HealthElement) =
		encryptionService.tryDecryptEntity(he.withTypeInfo(), HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<HealthElement>(it) }
}