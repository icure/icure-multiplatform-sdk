package com.icure.sdk.model

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class AddFormRequest(
  public val patientId: String? = null,
  public val formId: String? = null,
  public val formTemplateGuid: String? = null,
) : IoSerializable
