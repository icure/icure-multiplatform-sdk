package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class FormSkeleton(
  public val descr: String? = null,
  public val formTemplateId: String? = null,
)
