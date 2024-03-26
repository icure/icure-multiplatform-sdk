package com.icure.sdk.model

import com.icure.sdk.model.base.Named
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Place(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val name: String? = null,
  public val address: Address? = null,
) : StoredDocument, Named
