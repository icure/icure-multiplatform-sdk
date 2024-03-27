package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.specializations.Base64String
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
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

data class DecryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : Episode {
	// region Episode-DecryptedEpisode
	// endregion
}

data class EncryptedEpisode(
	override val id: String,
	override val name: String? = null,
	override val comment: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val encryptedSelf: Base64String? = null,
) : Episode {
	// region Episode-EncryptedEpisode
	// endregion
}

public fun Episode.copy(
  id: String = this.id,
  name: String? = this.name,
  comment: String? = this.comment,
  startDate: Long? = this.startDate,
  endDate: Long? = this.endDate,
  encryptedSelf: Base64String? = this.encryptedSelf,
): Episode {
                                      return when(this) {
                                          is DecryptedEpisode -> copy(id = id, name = name, comment
          = comment, startDate = startDate, endDate = endDate, encryptedSelf = encryptedSelf)
      is EncryptedEpisode -> copy(id = id, name = name, comment = comment, startDate = startDate,
          endDate = endDate, encryptedSelf = encryptedSelf)
                                          }

}