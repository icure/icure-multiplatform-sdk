package com.icure.cardinal.sdk.auth

import com.icure.utils.InternalIcureApi
import kotlin.jvm.JvmInline

@JvmInline
@InternalIcureApi
value class JwtBearer(
	val token: String
) : AuthToken

@JvmInline
@InternalIcureApi
value class JwtRefresh(
	val token: String
)

@InternalIcureApi
data class JwtBearerAndRefresh(
	val bearer: JwtBearer,
	val refresh: JwtRefresh
)