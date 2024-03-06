package com.icure.sdk.model.base

import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.PersonName
import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface Person : IoSerializable, Identifiable<String> {
  public val civility: String?

  public val gender: Gender?

  public val firstName: String?

  public val lastName: String?

  public val companyName: String?

  public val names: List<PersonName>

  public val addresses: List<Address>

  public val languages: List<String>
}
