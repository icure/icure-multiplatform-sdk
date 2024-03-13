package com.icure.sdk.model.filter

import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public interface Filter<O : IdentifiableDto<*>>
