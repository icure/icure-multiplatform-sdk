package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface SubContact : Encryptable, ICureDocument<String?> {
	public val id: String?

	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val tags: Set<CodeStub>

	public val codes: Set<CodeStub>

	public val endOfLife: Long?

	public val descr: String?

	public val protocol: String?

	public val status: Int?

	public val formId: String?

	public val planOfActionId: String?

	public val healthElementId: String?

	public val classificationId: String?

	public val services: List<ServiceLink>

	public val encryptedSelf: Base64String?
	// region SubContact-SubContact

	// endregion
}

@Serializable
data class DecryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	override val classificationId: String? = null,
	@DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact {
	// region SubContact-DecryptedSubContact

	// endregion
}

@Serializable
data class EncryptedSubContact(
	override val id: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val descr: String? = null,
	override val protocol: String? = null,
	override val status: Int? = null,
	override val formId: String? = null,
	override val planOfActionId: String? = null,
	override val healthElementId: String? = null,
	override val classificationId: String? = null,
	@DefaultValue("emptyList()")
	override val services: List<ServiceLink> = emptyList(),
	override val encryptedSelf: Base64String? = null,
) : SubContact {
	// region SubContact-EncryptedSubContact

	// endregion
}
