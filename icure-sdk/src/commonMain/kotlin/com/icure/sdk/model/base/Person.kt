package com.icure.sdk.model.base

import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.model.embed.PersonName
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface Person : Identifiable<String> {
  public val civility: String?

  public val gender: Gender?

  public val firstName: String?

  public val lastName: String?

  public val companyName: String?

  public val names: List<PersonName>

  public val addresses: List<Address>

  public val languages: List<String>
	// region Person-Person
	// endregion
}