package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.model.specializations.Base64String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Episode : Encryptable, Identifiable<String>, Named {
	override val id: String

	override val name: String?

	public val comment: String?

	public val startDate: Long?

	public val endDate: Long?

	override val encryptedSelf: Base64String?
	// region Episode-Episode

	// endregion
}

@Serializable
data class DecryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
	internal val dtoSerialName: String,
) : Episode {
	// region Episode-DecryptedEpisode

	// endregion
}

@Serializable
data class EncryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
	internal val dtoSerialName: String,
) : Episode {
	// region Episode-EncryptedEpisode

	// endregion
}
