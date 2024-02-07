package com.icure.sdk.api.raw

import com.icure.sdk.utils.RequestStatusException
import io.ktor.http.Headers
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.typeInfo

open class HttpResponse<T : Any>(val response: io.ktor.client.statement.HttpResponse, val provider: BodyProvider<T>) {
    val status: HttpStatusCode = response.status
    val headers: Map<String, List<String>> = response.headers.mapEntries()

    suspend fun successBody(): T = if (status.isSuccess())
        provider.body(response)
    else
        throw RequestStatusException(response.call.request.method, response.call.request.url.toString(), status.value)

    suspend fun successBodyOrNull404(): T? = if (status == HttpStatusCode.NotFound) null else successBody()

    companion object {
        private fun Headers.mapEntries(): Map<String, List<String>> {
            val result = mutableMapOf<String, List<String>>()
            entries().forEach { result[it.key] = it.value }
            return result
        }
    }
}

interface BodyProvider<T : Any> {
    suspend fun body(response: io.ktor.client.statement.HttpResponse): T
}

class TypedBodyProvider<T : Any>(private val type: TypeInfo) : BodyProvider<T> {
    @Suppress("UNCHECKED_CAST")
    override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
            response.call.body(type) as T
}

class MappedBodyProvider<S : Any, T : Any>(private val provider: BodyProvider<S>, private val block: S.() -> T) : BodyProvider<T> {
    override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
            block(provider.body(response))
}

inline fun <reified T : Any> io.ktor.client.statement.HttpResponse.wrap(): HttpResponse<T> =
        HttpResponse(this, TypedBodyProvider(typeInfo<T>()))

fun <T : Any, V : Any> HttpResponse<T>.map(block: T.() -> V): HttpResponse<V> =
        HttpResponse(response, MappedBodyProvider(provider, block))
