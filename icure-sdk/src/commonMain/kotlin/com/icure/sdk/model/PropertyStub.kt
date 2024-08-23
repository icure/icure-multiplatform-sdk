package com.icure.sdk.model

import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedTypedValue
import com.icure.sdk.model.embed.TypedValue
import com.icure.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface PropertyStub : Encryptable {
	public val id: String?

	public val type: PropertyTypeStub?

	public val deletionDate: Long?
	public val typedValue: TypedValue?

	override val encryptedSelf: Base64String?
	// region PropertyStub-PropertyStub

	// endregion
}

@Serializable
data class DecryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val deletionDate: Long? = null,
	override val typedValue: DecryptedTypedValue? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-DecryptedPropertyStub

	// endregion
}

@Serializable
data class EncryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val deletionDate: Long? = null,
	override val typedValue: EncryptedTypedValue? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-EncryptedPropertyStub

	// endregion
}
