package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AddFormRequest(
  public val patientId: String? = null,
  public val formId: String? = null,
  public val formTemplateGuid: String? = null,
)
