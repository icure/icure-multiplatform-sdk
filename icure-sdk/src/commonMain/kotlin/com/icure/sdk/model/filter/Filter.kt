package com.icure.sdk.model.filter

import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface Filter<O : IdentifiableDto<*>> : IoSerializable
