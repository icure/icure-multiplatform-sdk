package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.utils.InternalIcureApi
import io.ktor.http.Headers
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.util.reflect.TypeInfo
import io.ktor.util.reflect.typeInfo

@InternalIcureApi
class HttpResponse<T>(val response: io.ktor.client.statement.HttpResponse, val provider: BodyProvider<T>) {
	val status: HttpStatusCode = response.status
	val headers: Map<String, List<String>> = response.headers.mapEntries()

	suspend fun successBody(): T = if (status.isSuccess()) provider.body(response) else throw RequestStatusException(response.call.request.method, response.call.request.url.toString(), status.value)

	companion object {
		private fun Headers.mapEntries(): Map<String, List<String>> {
			val result = mutableMapOf<String, List<String>>()
			entries().forEach { result[it.key] = it.value }
			return result
		}
	}
}

@InternalIcureApi
suspend fun <T : Any> HttpResponse<T>.successBodyOrNull(): T? = if (status.isSuccess()) provider.body(response) else null

@InternalIcureApi
suspend fun <T : Any> HttpResponse<T>.successBodyOrNull404(): T? = if (status == HttpStatusCode.NotFound) null else successBody()

@InternalIcureApi
suspend fun <T : Any> HttpResponse<T>.successBodyOrThrowRevisionConflict(): T =
	if (status == HttpStatusCode.Conflict) throw RevisionConflictException() else successBody()

interface BodyProvider<T> {
	suspend fun body(response: io.ktor.client.statement.HttpResponse): T
}

class TypedBodyProvider<T>(private val type: TypeInfo) : BodyProvider<T> {
	@Suppress("UNCHECKED_CAST")
	override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
		response.call.bodyNullable(type) as T
}

class MappedBodyProvider<S : Any, T : Any>(private val provider: BodyProvider<S>, private val block: S.() -> T) : BodyProvider<T> {
	override suspend fun body(response: io.ktor.client.statement.HttpResponse): T =
		block(provider.body(response))
}

@InternalIcureApi
inline fun <reified T> io.ktor.client.statement.HttpResponse.wrap(): HttpResponse<T> =
	HttpResponse(this, TypedBodyProvider(typeInfo<T>()))

fun io.ktor.client.statement.HttpResponse.requireSuccess() {
	if (!status.isSuccess()) throw RequestStatusException(call.request.method, call.request.url.toString(), status.value)
}

@InternalIcureApi
fun <T : Any, V : Any> HttpResponse<T>.map(block: T.() -> V): HttpResponse<V> =
	HttpResponse(response, MappedBodyProvider(provider, block))
