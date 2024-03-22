package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeIdsByTypeCodeVersionIntervalFilter")
@Serializable
data class CodeIdsByTypeCodeVersionIntervalFilter(
  override val desc: String? = null,
  public val startType: String? = null,
  public val startCode: String? = null,
  public val startVersion: String? = null,
  public val endType: String? = null,
  public val endCode: String? = null,
  public val endVersion: String? = null,
) : AbstractFilter<Code> {
	// region CodeIdsByTypeCodeVersionIntervalFilter-CodeIdsByTypeCodeVersionIntervalFilter
	// endregion
}