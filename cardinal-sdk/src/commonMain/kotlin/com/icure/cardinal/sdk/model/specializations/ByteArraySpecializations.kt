package com.icure.cardinal.sdk.model.specializations

import com.icure.cardinal.sdk.serialization.Pkcs8BytesAsBase64Serializer
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline


@JvmInline
@Serializable(with = Pkcs8BytesAsBase64Serializer::class)
value class Pkcs8Bytes(
	val bytes: ByteArray
)