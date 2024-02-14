package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.utils.KtorEngine
import com.icure.sdk.utils.Serialization
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import io.ktor.http.*
import io.ktor.http.content.PartData
import io.ktor.http.contentType
import kotlin.Unit
import kotlinx.serialization.json.Json
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod

open class ApiClient(
    private val baseUrl: String,
    private val authService: AuthService<*>?,
) {
    private val client: HttpClient = HttpClient(KtorEngine) {
        install(ContentNegotiation) {
            json(json = Serialization.json)
        }
    }

    companion object {
        const val BASE_URL = "https://krakenc.icure.cloud"
        val JSON_DEFAULT = Json {
          ignoreUnknownKeys = true
          prettyPrint = true
          isLenient = true
        }
        protected val UNSAFE_HEADERS = listOf(HttpHeaders.ContentType)
    }

    protected suspend fun <T: Any?> multipartFormRequest(requestConfig: RequestConfig<T>, body: kotlin.collections.List<PartData>?): HttpResponse {
        return request(requestConfig, MultiPartFormDataContent(body ?: listOf()))
    }

    protected suspend fun <T: Any?> urlEncodedFormRequest(requestConfig: RequestConfig<T>, body: Parameters?): HttpResponse {
        return request(requestConfig, FormDataContent(body ?: Parameters.Empty))
    }

    protected suspend fun <T: Any?> jsonRequest(requestConfig: RequestConfig<T>, body: Any? = null): HttpResponse = request(requestConfig, body)

    protected suspend fun <T: Any?> request(requestConfig: RequestConfig<T>, body: Any? = null): HttpResponse {
        val headers = requestConfig.headers

        return client.request {
            authService?.setAuthorizationInRequest(this)

            this.url {
                this.takeFrom(URLBuilder(baseUrl))
                appendPath(requestConfig.path.trimStart('/').split('/'))
                requestConfig.query.forEach { query ->
                    query.value.forEach { value ->
                        parameter(query.key, value)
                    }
                }
            }
            this.method = requestConfig.method.httpMethod
            headers.filter { header -> !UNSAFE_HEADERS.contains(header.key) }.forEach { header -> this.header(header.key, header.value) }
            if (requestConfig.method in listOf(RequestMethod.PUT, RequestMethod.POST, RequestMethod.PATCH)) {
                val contentType = (requestConfig.headers[HttpHeaders.ContentType]?.let { ContentType.parse(it) }
                    ?: ContentType.Application.Json)
                this.contentType(contentType)
                this.setBody(body)
            }
        }
    }

    private fun URLBuilder.appendPath(components: kotlin.collections.List<String>): URLBuilder = apply {
        encodedPath = encodedPath.trimEnd('/') + components.joinToString("/", prefix = "/") { it.encodeURLQueryComponent() }
    }

    private val RequestMethod.httpMethod: HttpMethod
        get() = when (this) {
            RequestMethod.DELETE -> HttpMethod.Delete
            RequestMethod.GET -> HttpMethod.Get
            RequestMethod.HEAD -> HttpMethod.Head
            RequestMethod.PATCH -> HttpMethod.Patch
            RequestMethod.PUT -> HttpMethod.Put
            RequestMethod.POST -> HttpMethod.Post
            RequestMethod.OPTIONS -> HttpMethod.Options
        }
}
