package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class AddFormRequest(
  public val patientId: String? = null,
  public val formId: String? = null,
  public val formTemplateGuid: String? = null,
) {
	// region AddFormRequest-AddFormRequest
	// endregion
}