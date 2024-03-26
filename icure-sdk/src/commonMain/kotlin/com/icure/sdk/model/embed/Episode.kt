package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Named
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Episode : Encryptable, Identifiable<String>, Named {
  override val id: String

  override val name: String?

  public val comment: String?

  public val startDate: Long?

  public val endDate: Long?

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedEpisode(
  override val id: String,
  override val name: String? = null,
  override val comment: String? = null,
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val encryptedSelf: String? = null,
) : Episode

@SerialName
public data class EncryptedEpisode(
  override val id: String,
  override val name: String? = null,
  override val comment: String? = null,
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val encryptedSelf: String? = null,
) : Episode

public fun Episode.copy(
  id: String = this.id,
  name: String? = this.name,
  comment: String? = this.comment,
  startDate: Long? = this.startDate,
  endDate: Long? = this.endDate,
  encryptedSelf: String? = this.encryptedSelf,
): Episode {
                                      return when(this) {
                                          is DecryptedEpisode -> copy(id = id, name = name, comment
          = comment, startDate = startDate, endDate = endDate, encryptedSelf = encryptedSelf)
      is EncryptedEpisode -> copy(id = id, name = name, comment = comment, startDate = startDate,
          endDate = endDate, encryptedSelf = encryptedSelf)
                                          }
}
