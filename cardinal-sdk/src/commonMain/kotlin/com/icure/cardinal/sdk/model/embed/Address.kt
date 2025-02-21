package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasCodes
import com.icure.cardinal.sdk.model.base.HasTags
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.CodeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifierDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.AddressTypeDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.AnnotationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.TelecomDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Address : Encryptable, HasTags, HasCodes {
	override val tags: Set<CodeStubDto>

	override val codes: Set<CodeStubDto>

	public val identifier: List<IdentifierDto>

	public val addressType: AddressTypeDto?

	public val descr: String?

	public val street: String?

	public val houseNumber: String?

	public val postboxNumber: String?

	public val postalCode: String?

	public val city: String?

	public val state: String?

	public val country: String?

	public val note: String?

	public val notes: List<AnnotationDto>

	public val telecoms: List<TelecomDto>

	override val encryptedSelf: Base64StringDto?
  // region Address-Address

  // endregion
}

@Serializable
data class DecryptedAddress(
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val addressType: AddressType? = null,
	override val descr: String? = null,
	override val street: String? = null,
	override val houseNumber: String? = null,
	override val postboxNumber: String? = null,
	override val postalCode: String? = null,
	override val city: String? = null,
	override val state: String? = null,
	override val country: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyList()")
	override val telecoms: List<DecryptedTelecom> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : Address {
	// region Address-DecryptedAddress

	// endregion
}

@Serializable
data class EncryptedAddress(
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val addressType: AddressType? = null,
	override val descr: String? = null,
	override val street: String? = null,
	override val houseNumber: String? = null,
	override val postboxNumber: String? = null,
	override val postalCode: String? = null,
	override val city: String? = null,
	override val state: String? = null,
	override val country: String? = null,
	override val note: String? = null,
	@DefaultValue("emptyList()")
	override val notes: List<Annotation> = emptyList(),
	@DefaultValue("emptyList()")
	override val telecoms: List<EncryptedTelecom> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : Address {
	// region Address-EncryptedAddress

	// endregion
}
