package com.icure.sdk.api.flavoured

import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.EntityValidationService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

interface HealthElementBasicFlavourlessApi {
    suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): List<String>
}

interface HealthElementBasicFlavouredApi<E: HealthElement> {
    suspend fun modifyHealthElement(entity: E): E
    suspend fun getHealthElement(entityId: String): E
}

interface HealthElementFlavouredApi<E: HealthElement> : HealthElementBasicFlavouredApi<E> {
    suspend fun shareWith(
        delegateId: String,
        healthcareElement: E,
        shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
        shareOwningEntityIds: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
        requestedPermission: RequestedPermission = RequestedPermission.MaxWrite
    ): SimpleShareResult<E>
}

interface HealthElementApi : HealthElementBasicFlavourlessApi, HealthElementFlavouredApi<DecryptedHealthElement> {
    suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement

    val encrypted : HealthElementFlavouredApi<EncryptedHealthElement>
    val tryAndRecover : HealthElementFlavouredApi<HealthElement>
}

interface HealthElementBasicApi : HealthElementBasicFlavourlessApi, HealthElementBasicFlavouredApi<EncryptedHealthElement>

@InternalIcureApi
private abstract class AbstractHealthElementBasicFlavouredApi<E: HealthElement>(protected val rawApi: RawHealthElementApi): HealthElementBasicFlavouredApi<E> {
    override suspend fun getHealthElement(entityId: String): E = rawApi.getHealthElement(entityId).successBody().let {
        maybeDecrypt(it)
    }
    override suspend fun modifyHealthElement(entity: E): E  = rawApi.modifyHealthElement(validateAndMaybeEncrypt(entity)).successBody().let {
        maybeDecrypt(it)
    }

    abstract suspend fun validateAndMaybeEncrypt(entity: E): EncryptedHealthElement
    abstract suspend fun maybeDecrypt(entity: EncryptedHealthElement): E
}

@InternalIcureApi
private abstract class AbstractHealthElementFlavouredApi<E: HealthElement>(rawApi: RawHealthElementApi): AbstractHealthElementBasicFlavouredApi<E>(rawApi), HealthElementFlavouredApi<E> {
    override suspend fun shareWith(
        delegateId: String,
        healthcareElement: E,
        shareEncryptionKeys: ShareMetadataBehaviour,
        shareOwningEntityIds: ShareMetadataBehaviour,
        requestedPermission: RequestedPermission
    ): SimpleShareResult<E> {
        TODO()
    }
}

@InternalIcureApi
private class AbstractHealthElementBasicFlavourlessApi : HealthElementBasicFlavourlessApi {
    override suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): List<String> {
        TODO()
    }
}

@InternalIcureApi
private class EncryptedHealthElementFlavouredApi(
    rawApi: RawHealthElementApi,
    private val validationService: EntityValidationService,
    private val fieldsToEncrypt: EncryptedFieldsManifest
) : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi) {
    override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
        validationService.validateEncryptedEntity(entity, EncryptedHealthElement.serializer(), fieldsToEncrypt)
    override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}

@InternalIcureApi
internal class HealthElementApiImpl(
    private val rawApi: RawHealthElementApi,
    private val encryptionService: EntityEncryptionService,
    private val fieldsToEncrypt: EncryptedFieldsManifest =
        EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())
) : HealthElementApi, HealthElementFlavouredApi<DecryptedHealthElement> by object: AbstractHealthElementFlavouredApi<DecryptedHealthElement>(rawApi){
    override suspend fun validateAndMaybeEncrypt(entity: DecryptedHealthElement): EncryptedHealthElement =
        encryptionService.encryptEntity(entity, DecryptedHealthElement.serializer(), fieldsToEncrypt) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }

    override suspend fun maybeDecrypt(entity: EncryptedHealthElement): DecryptedHealthElement {
        return encryptionService.tryDecryptEntity(entity, HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
            ?: throw EntityDecryptionException("Entity is not encrypted")
    }
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi() {
    override val encrypted : HealthElementFlavouredApi<EncryptedHealthElement> = object : AbstractHealthElementFlavouredApi<EncryptedHealthElement>(rawApi) {
        override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
            encryptionService.validateEncryptedEntity(entity, EncryptedHealthElement.serializer(), fieldsToEncrypt)
        override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
    }

    override val tryAndRecover : HealthElementFlavouredApi<HealthElement> = object : AbstractHealthElementFlavouredApi<HealthElement>(rawApi) {
        override suspend fun maybeDecrypt(entity: EncryptedHealthElement): HealthElement =
            encryptionService.tryDecryptEntity(entity, HealthElement.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedHealthElement>(it) }
                ?: entity

        override suspend fun validateAndMaybeEncrypt(entity: HealthElement): EncryptedHealthElement  = when (entity) {
            is EncryptedHealthElement -> encryptionService.validateEncryptedEntity(entity, EncryptedHealthElement.serializer(), fieldsToEncrypt)
            is DecryptedHealthElement -> encryptionService.encryptEntity(
                entity,
                DecryptedHealthElement.serializer(),
                fieldsToEncrypt
            ) { Serialization.json.decodeFromJsonElement<EncryptedHealthElement>(it) }
        }
    }

    override suspend fun createHealthElement(entity: DecryptedHealthElement): DecryptedHealthElement {
        TODO("Not yet implemented")
    }
}

@InternalIcureApi
internal class HealthElementBasicApiImpl(
    private val rawApi: RawHealthElementApi,
    private val validationService: EntityValidationService,
    private val fieldsToEncrypt: EncryptedFieldsManifest =
        EncryptedFieldsManifest("HealthElement.", setOf("note", "descr"), emptyMap(), emptyMap(), emptyMap())
) : HealthElementBasicApi, HealthElementBasicFlavouredApi<EncryptedHealthElement> by object : AbstractHealthElementBasicFlavouredApi<EncryptedHealthElement>(rawApi) {
    override suspend fun validateAndMaybeEncrypt(entity: EncryptedHealthElement): EncryptedHealthElement =
        validationService.validateEncryptedEntity(entity, EncryptedHealthElement.serializer(), fieldsToEncrypt)
    override suspend fun maybeDecrypt(entity: EncryptedHealthElement): EncryptedHealthElement = entity
}, HealthElementBasicFlavourlessApi by AbstractHealthElementBasicFlavourlessApi()
