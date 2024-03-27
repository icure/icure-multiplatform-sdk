package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.security.Permission
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawPermissionApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region cloud endpoints

    suspend fun modifyUserPermissions(
        userId: String,
        permissions: Permission,
    ): HttpResponse<List<Permission>> =
        put {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "permissions", userId)
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(permissions)
        }.wrap()

    // endregion
}
