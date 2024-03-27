package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface ClassificationTemplate :
    StoredDocument,
    ICureDocument<String>,
    HasEncryptionMetadata,
    Encryptable {
    override val id: String

    override val rev: String?

    override val created: Long?

    override val modified: Long?

    override val author: String?

    override val responsible: String?

    override val medicalLocationId: String?

    override val tags: Set<CodeStub>

    override val codes: Set<CodeStub>

    override val endOfLife: Long?

    override val deletionDate: Long?

    public val parentId: String?

    public val label: String

    override val secretForeignKeys: Set<String>

    override val cryptedForeignKeys: Map<String, Set<Delegation>>

    override val delegations: Map<String, Set<Delegation>>

    override val encryptionKeys: Map<String, Set<Delegation>>

    override val encryptedSelf: Base64String?

    override val securityMetadata: SecurityMetadata?
    // region ClassificationTemplate-ClassificationTemplate

    // endregion
}

@Serializable
data class DecryptedClassificationTemplate(
    override val id: String,
    override val rev: String? = null,
    override val created: Long? = null,
    override val modified: Long? = null,
    override val author: String? = null,
    override val responsible: String? = null,
    override val medicalLocationId: String? = null,
    override val tags: Set<CodeStub> = emptySet(),
    override val codes: Set<CodeStub> = emptySet(),
    override val endOfLife: Long? = null,
    override val deletionDate: Long? = null,
    override val parentId: String? = null,
    override val label: String,
    override val secretForeignKeys: Set<String> = emptySet(),
    override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val delegations: Map<String, Set<Delegation>> = emptyMap(),
    override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val encryptedSelf: Base64String? = null,
    override val securityMetadata: SecurityMetadata? = null,
) : ClassificationTemplate {
    // region ClassificationTemplate-DecryptedClassificationTemplate
    override fun copyWithSecurityMetadata(
        securityMetadata: SecurityMetadata,
        secretForeignKeys: Set<String>,
    ): DecryptedClassificationTemplate = copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
    // endregion
}

@Serializable
data class EncryptedClassificationTemplate(
    override val id: String,
    override val rev: String? = null,
    override val created: Long? = null,
    override val modified: Long? = null,
    override val author: String? = null,
    override val responsible: String? = null,
    override val medicalLocationId: String? = null,
    override val tags: Set<CodeStub> = emptySet(),
    override val codes: Set<CodeStub> = emptySet(),
    override val endOfLife: Long? = null,
    override val deletionDate: Long? = null,
    override val parentId: String? = null,
    override val label: String,
    override val secretForeignKeys: Set<String> = emptySet(),
    override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val delegations: Map<String, Set<Delegation>> = emptyMap(),
    override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val encryptedSelf: Base64String? = null,
    override val securityMetadata: SecurityMetadata? = null,
) : ClassificationTemplate {
    // region ClassificationTemplate-EncryptedClassificationTemplate
    override fun copyWithSecurityMetadata(
        securityMetadata: SecurityMetadata,
        secretForeignKeys: Set<String>,
    ): EncryptedClassificationTemplate = copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
    // endregion
}

public fun ClassificationTemplate.copy(
    id: String = this.id,
    rev: String? = this.rev,
    created: Long? = this.created,
    modified: Long? = this.modified,
    author: String? = this.author,
    responsible: String? = this.responsible,
    medicalLocationId: String? = this.medicalLocationId,
    tags: Set<CodeStub> = this.tags,
    codes: Set<CodeStub> = this.codes,
    endOfLife: Long? = this.endOfLife,
    deletionDate: Long? = this.deletionDate,
    parentId: String? = this.parentId,
    label: String = this.label,
    secretForeignKeys: Set<String> = this.secretForeignKeys,
    cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
    delegations: Map<String, Set<Delegation>> = this.delegations,
    encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
    encryptedSelf: Base64String? = this.encryptedSelf,
    securityMetadata: SecurityMetadata? = this.securityMetadata,
): ClassificationTemplate {
    return when (this) {
        is DecryptedClassificationTemplate ->
            copy(
                id = id,
                rev =
                rev,
                created = created,
                modified = modified,
                author = author,
                responsible = responsible,
                medicalLocationId = medicalLocationId,
                tags = tags,
                codes = codes,
                endOfLife = endOfLife,
                deletionDate = deletionDate,
                parentId = parentId,
                label = label,
                secretForeignKeys =
                secretForeignKeys,
                cryptedForeignKeys = cryptedForeignKeys,
                delegations = delegations,
                encryptionKeys = encryptionKeys,
                encryptedSelf = encryptedSelf,
                securityMetadata =
                securityMetadata,
            )
        is EncryptedClassificationTemplate ->
            copy(
                id = id,
                rev = rev,
                created = created,
                modified =
                modified,
                author = author,
                responsible = responsible,
                medicalLocationId =
                medicalLocationId,
                tags = tags,
                codes = codes,
                endOfLife = endOfLife,
                deletionDate =
                deletionDate,
                parentId = parentId,
                label = label,
                secretForeignKeys = secretForeignKeys,
                cryptedForeignKeys = cryptedForeignKeys,
                delegations = delegations,
                encryptionKeys =
                encryptionKeys,
                encryptedSelf = encryptedSelf,
                securityMetadata = securityMetadata,
            )
    }
}
