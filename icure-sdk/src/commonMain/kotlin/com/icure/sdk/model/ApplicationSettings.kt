package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ApplicationSettings(
  override val id: String,
  override val rev: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  override val deletionDate: Long? = null,
  public val settings: Map<String, String> = emptyMap(),
) : StoredDocument, ICureDocument<String> {
	// region ApplicationSettings-ApplicationSettings
	// endregion
}