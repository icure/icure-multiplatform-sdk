/*
 * Copyright 2014-2019 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.client.engine.curl

import io.ktor.client.engine.HttpClientEngineBase
import io.ktor.client.engine.callContext
import io.ktor.client.engine.curl.internal.CurlHttpResponseBody
import io.ktor.client.engine.curl.internal.CurlWebSocketResponseBody
import io.ktor.client.engine.curl.internal.CurlWebSocketSession
import io.ktor.client.engine.curl.internal.fromCurl
import io.ktor.client.engine.curl.internal.toCurlRequest
import io.ktor.client.plugins.HttpTimeoutCapability
import io.ktor.client.plugins.sse.DefaultClientSSESession
import io.ktor.client.plugins.sse.SSECapability
import io.ktor.client.plugins.sse.SSEClientContent
import io.ktor.client.plugins.websocket.WebSocketCapability
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.client.request.isUpgradeRequest
import io.ktor.client.request.needToProcessSSE
import io.ktor.http.HeadersImpl
import io.ktor.http.HttpStatusCode
import io.ktor.http.cio.parseHeaders
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.InternalAPI
import io.ktor.utils.io.readUTF8Line
import kotlinx.coroutines.Dispatchers

internal class CurlClientEngine(
    override val config: CurlClientEngineConfig
) : HttpClientEngineBase("ktor-curl") {
    override val dispatcher = Dispatchers.Unconfined

    override val supportedCapabilities = setOf(HttpTimeoutCapability, WebSocketCapability, SSECapability)

    private val curlProcessor = CurlProcessor(coroutineContext)

    @OptIn(InternalAPI::class)
    override suspend fun execute(data: HttpRequestData): HttpResponseData {
        val callContext = callContext()

        val requestTime = GMTDate()

        val curlRequest = data.toCurlRequest(config)
        val responseData = curlProcessor.executeRequest(curlRequest)

        return with(responseData) {
            val headerBytes = ByteReadChannel(headersBytes).apply {
                readUTF8Line()
            }
            val rawHeaders = parseHeaders(headerBytes)

            val status = HttpStatusCode.fromValue(status)

            val headers = HeadersImpl(rawHeaders.toMap())
            rawHeaders.release()

            val responseBody: Any = if (needToProcessSSE(data, status, headers)) {
                val content = data.body as SSEClientContent
                val body = responseBody as CurlHttpResponseBody
                DefaultClientSSESession(content, body.bodyChannel, callContext)
            } else if (data.isUpgradeRequest()) {
                val websocket = responseBody as CurlWebSocketResponseBody
                CurlWebSocketSession(websocket, callContext)
            } else {
                val body = responseBody as CurlHttpResponseBody
                body.bodyChannel
            }

            HttpResponseData(
                status,
                requestTime,
                headers,
                version.fromCurl(),
                responseBody,
                callContext
            )
        }
    }

    override fun close() {
        super.close()
        curlProcessor.close()
    }
}

@Deprecated("This exception will be removed in a future release in favor of a better error handling.")
public class CurlIllegalStateException(cause: String) : IllegalStateException(cause)

@Deprecated("This exception will be removed in a future release in favor of a better error handling.")
public class CurlRuntimeException(cause: String) : RuntimeException(cause)
