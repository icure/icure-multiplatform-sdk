package com.icure.sdk.auth

import kotlin.jvm.JvmInline

@JvmInline
value class JwtBearer(
	val token: String
) : AuthToken

@JvmInline
value class JwtRefresh(
	val token: String
)

data class JwtBearerAndRefresh(
	val bearer: JwtBearer,
	val refresh: JwtRefresh
)