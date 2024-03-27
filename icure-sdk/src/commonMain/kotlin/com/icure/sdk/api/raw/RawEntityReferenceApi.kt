package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EntityReference
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.String
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).
@InternalIcureApi
class RawEntityReferenceApi(
    private val apiUrl: String,
    private val authService: AuthService,
    additionalHeaders: Map<String, String> = emptyMap(),
    timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {
    // region common endpoints

    suspend fun getLatest(prefix: String): HttpResponse<EntityReference> =
        get {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "entityref", "latest", prefix)
                parameter("ts", GMTDate().timestamp)
            }
            setAuthorizationWith(authService)
        }.wrap()

    suspend fun createEntityReference(er: EntityReference): HttpResponse<EntityReference> =
        post {
            url {
                host = apiUrl
                appendPathSegments("rest", "v2", "entityref")
            }
            setAuthorizationWith(authService)
            contentType(ContentType.Application.Json)
            setBody(er)
        }.wrap()

    // endregion
}
