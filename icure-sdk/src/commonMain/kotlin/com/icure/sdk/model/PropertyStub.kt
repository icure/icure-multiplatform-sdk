package com.icure.sdk.model

import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedTypedValue
import com.icure.sdk.model.embed.TypedValue
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface PropertyStub : Encryptable {
    public val id: String?

    public val type: PropertyTypeStub?

    public val typedValue: TypedValue?

    public val deletionDate: Long?

    override val encryptedSelf: Base64String?
}

@Serializable
data class DecryptedPropertyStub(
    override val id: String? = null,
    override val type: PropertyTypeStub? = null,
    override val typedValue: DecryptedTypedValue? = null,
    override val deletionDate: Long? = null,
    override val encryptedSelf: Base64String? = null,
) : PropertyStub

@Serializable
data class EncryptedPropertyStub(
    override val id: String? = null,
    override val type: PropertyTypeStub? = null,
    override val typedValue: EncryptedTypedValue? = null,
    override val deletionDate: Long? = null,
    override val encryptedSelf: Base64String? = null,
) : PropertyStub

public fun PropertyStub.copy(
    id: String? = this.id,
    type: PropertyTypeStub? = this.type,
    typedValue: TypedValue? = this.typedValue,
    deletionDate: Long? = this.deletionDate,
    encryptedSelf: Base64String? = this.encryptedSelf,
): PropertyStub {
    return when (this) {
        is DecryptedPropertyStub ->
            copy(
                id = id,
                type = type,
                typedValue = typedValue,
                deletionDate = deletionDate,
                encryptedSelf = encryptedSelf,
            )
        is EncryptedPropertyStub ->
            copy(
                id = id,
                type = type,
                typedValue = typedValue,
                deletionDate =
                deletionDate,
                encryptedSelf = encryptedSelf,
            )
    }
}
