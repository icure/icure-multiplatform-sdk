package com.icure.sdk.model

import com.icure.sdk.model.base.AppendixType
import com.icure.sdk.model.base.CodeFlag
import com.icure.sdk.model.base.CodeIdentification
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Periodicity
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Code(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val context: String? = null,
  override val type: String? = null,
  override val code: String? = null,
  override val version: String? = null,
  override val label: Map<String, String>? = null,
  public val author: String? = null,
  public val regions: Set<String> = emptySet(),
  public val periodicity: Set<Periodicity> = emptySet(),
  public val level: Int? = null,
  public val links: Set<String> = emptySet(),
  public val qualifiedLinks: Map<String, List<String>> = emptyMap(),
  public val flags: Set<CodeFlag> = emptySet(),
  public val searchTerms: Map<String, Set<String>> = emptyMap(),
  public val `data`: String? = null,
  public val appendices: Map<AppendixType, String> = emptyMap(),
  public val disabled: Boolean = false,
) : StoredDocument, CodeIdentification<String> {
	// region Code-Code
	// endregion
}