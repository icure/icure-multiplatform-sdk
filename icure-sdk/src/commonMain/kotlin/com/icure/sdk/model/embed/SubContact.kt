package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface SubContact : Encryptable, ICureDocument<String?> {
    override val id: String?

    override val created: Long?

    override val modified: Long?

    override val author: String?

    override val responsible: String?

    override val medicalLocationId: String?

    override val tags: Set<CodeStub>

    override val codes: Set<CodeStub>

    override val endOfLife: Long?

    public val descr: String?

    public val protocol: String?

    public val status: Int?

    public val formId: String?

    public val planOfActionId: String?

    public val healthElementId: String?

    public val classificationId: String?

    public val services: List<ServiceLink>

    override val encryptedSelf: Base64String?
}

@Serializable
data class DecryptedSubContact(
    override val id: String? = null,
    override val created: Long? = null,
    override val modified: Long? = null,
    override val author: String? = null,
    override val responsible: String? = null,
    override val medicalLocationId: String? = null,
    override val tags: Set<CodeStub> = emptySet(),
    override val codes: Set<CodeStub> = emptySet(),
    override val endOfLife: Long? = null,
    override val descr: String? = null,
    override val protocol: String? = null,
    override val status: Int? = null,
    override val formId: String? = null,
    override val planOfActionId: String? = null,
    override val healthElementId: String? = null,
    override val classificationId: String? = null,
    override val services: List<ServiceLink> = emptyList(),
    override val encryptedSelf: Base64String? = null,
) : SubContact

@Serializable
data class EncryptedSubContact(
    override val id: String? = null,
    override val created: Long? = null,
    override val modified: Long? = null,
    override val author: String? = null,
    override val responsible: String? = null,
    override val medicalLocationId: String? = null,
    override val tags: Set<CodeStub> = emptySet(),
    override val codes: Set<CodeStub> = emptySet(),
    override val endOfLife: Long? = null,
    override val descr: String? = null,
    override val protocol: String? = null,
    override val status: Int? = null,
    override val formId: String? = null,
    override val planOfActionId: String? = null,
    override val healthElementId: String? = null,
    override val classificationId: String? = null,
    override val services: List<ServiceLink> = emptyList(),
    override val encryptedSelf: Base64String? = null,
) : SubContact

public fun SubContact.copy(
    id: String? = this.id,
    created: Long? = this.created,
    modified: Long? = this.modified,
    author: String? = this.author,
    responsible: String? = this.responsible,
    medicalLocationId: String? = this.medicalLocationId,
    tags: Set<CodeStub> = this.tags,
    codes: Set<CodeStub> = this.codes,
    endOfLife: Long? = this.endOfLife,
    descr: String? = this.descr,
    protocol: String? = this.protocol,
    status: Int? = this.status,
    formId: String? = this.formId,
    planOfActionId: String? = this.planOfActionId,
    healthElementId: String? = this.healthElementId,
    classificationId: String? = this.classificationId,
    services: List<ServiceLink> = this.services,
    encryptedSelf: Base64String? = this.encryptedSelf,
): SubContact {
    return when (this) {
        is DecryptedSubContact ->
            copy(
                id = id,
                created = created,
                modified = modified,
                author = author,
                responsible = responsible,
                medicalLocationId =
                medicalLocationId,
                tags = tags,
                codes = codes,
                endOfLife = endOfLife,
                descr = descr,
                protocol = protocol,
                status = status,
                formId = formId,
                planOfActionId = planOfActionId,
                healthElementId = healthElementId,
                classificationId = classificationId,
                services =
                services,
                encryptedSelf = encryptedSelf,
            )
        is EncryptedSubContact ->
            copy(
                id = id,
                created = created,
                modified = modified,
                author =
                author,
                responsible = responsible,
                medicalLocationId = medicalLocationId,
                tags = tags,
                codes = codes,
                endOfLife = endOfLife,
                descr = descr,
                protocol = protocol,
                status = status,
                formId = formId,
                planOfActionId = planOfActionId,
                healthElementId = healthElementId,
                classificationId = classificationId,
                services = services,
                encryptedSelf = encryptedSelf,
            )
    }
}
