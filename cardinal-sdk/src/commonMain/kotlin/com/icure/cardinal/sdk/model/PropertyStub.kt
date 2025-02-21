package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.PropertyTypeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.TypedValueDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.Deprecated
import kotlin.Long
import kotlin.String
import com.icure.cardinal.sdk.model.embed.TypedValue
import org.taktik.icure.services.`external`.rest.v2.dto.PropertyTypeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.TypedValueDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.Deprecated
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface PropertyStub : Encryptable {
	public val id: String?

	public val type: PropertyTypeStubDto?

	public val typedValue: TypedValueDto?

	@Deprecated("Remove from list instead")
	public val deletionDate: Long?

	override val encryptedSelf: Base64StringDto?
	// region PropertyStub-PropertyStub

	// endregion
}

@Serializable
data class DecryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val typedValue: DecryptedTypedValue? = null,
	@Deprecated("Remove from list instead")
	override val deletionDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-DecryptedPropertyStub

	// endregion
}

@Serializable
data class EncryptedPropertyStub(
	override val id: String? = null,
	override val type: PropertyTypeStub? = null,
	override val typedValue: EncryptedTypedValue? = null,
	@Deprecated("Remove from list instead")
	override val deletionDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : PropertyStub {
	// region PropertyStub-EncryptedPropertyStub

	// endregion
}
