package com.icure.cardinal.sdk.api

interface AuthApi {
	suspend fun getBearerToken(): String
}
