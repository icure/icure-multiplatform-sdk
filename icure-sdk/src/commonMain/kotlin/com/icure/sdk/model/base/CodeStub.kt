package com.icure.sdk.model.base

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class CodeStub(
  override val id: String? = null,
  override val context: String? = null,
  override val type: String? = null,
  override val code: String? = null,
  override val version: String? = null,
  public val contextLabel: String? = null,
  override val label: Map<String, String>? = null,
) : CodeIdentification<String?>
