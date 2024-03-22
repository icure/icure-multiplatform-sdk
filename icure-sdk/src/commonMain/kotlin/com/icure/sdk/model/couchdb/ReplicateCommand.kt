package com.icure.sdk.model.couchdb

import com.icure.sdk.model.base.Versionable
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ReplicateCommand(
  override val id: String,
  override val rev: String? = null,
  public val continuous: Boolean,
  public val createTarget: Boolean,
  public val docIds: List<String>? = null,
  public val cancel: Boolean? = null,
  public val filter: String? = null,
  public val selector: String? = null,
  public val source: Remote,
  public val target: Remote,
) : Versionable<String>