package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.constants.PropertyTypeScope
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.constants.TypedValuesType

@Serializable
public data class PropertyType(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val identifier: String,
  public val type: TypedValuesType? = null,
  public val scope: PropertyTypeScope? = null,
  public val unique: Boolean,
  public val editor: String? = null,
  public val localized: Boolean,
) : StoredDocument
