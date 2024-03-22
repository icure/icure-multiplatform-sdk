package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Named
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PlanOfActionTemplate(
  override val id: String,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val name: String? = null,
  public val descr: String? = null,
  public val note: String? = null,
  public val relevant: Boolean,
  public val status: Int = 0,
  public val forms: List<FormSkeleton> = emptyList(),
) : ICureDocument<String>, Named {
	// region PlanOfActionTemplate-PlanOfActionTemplate
	// endregion
}