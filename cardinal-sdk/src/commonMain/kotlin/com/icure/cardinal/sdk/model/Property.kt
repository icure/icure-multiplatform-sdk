package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.embed.TypedValue
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Property : StoredDocument, Encryptable {
	override val id: String

	override val rev: String?

	override val deletionDate: Long?

	public val type: PropertyType?

	public val typedValue: TypedValue?

	override val encryptedSelf: Base64String?
	// region Property-Property

	// endregion
}

@Serializable
data class DecryptedProperty(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val type: PropertyType? = null,
	override val typedValue: DecryptedTypedValue? = null,
	override val encryptedSelf: Base64String? = null,
) : Property {
	// region Property-DecryptedProperty

	// endregion
}

@Serializable
data class EncryptedProperty(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val type: PropertyType? = null,
	override val typedValue: EncryptedTypedValue? = null,
	override val encryptedSelf: Base64String? = null,
) : Property {
	// region Property-EncryptedProperty

	// endregion
}
