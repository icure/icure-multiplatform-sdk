package com.icure.sdk.model.filter

import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public interface AbstractFilter<O : IdentifiableDto<String>> : Filter<O> {
  public val desc: String?
}
