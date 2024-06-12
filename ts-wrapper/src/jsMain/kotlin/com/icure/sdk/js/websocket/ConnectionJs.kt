package com.icure.sdk.js.websocket

import com.icure.sdk.websocket.Connection
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsName("Connection")
external interface ConnectionJs {
	/**
	 * Close the connection definitively
	 *
	 * This will bypass the retry mechanism and close the connection
	 */
	fun close(): Promise<Unit>

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when the connection is reconnected (due to a retry)
	 */
	fun onReconnected(callback: () -> Promise<Unit>)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when the connection is disconnected, either by the server or by the client. It can be called multiple times due to retries
	 * - `code` The close code
	 * - `reason` The close reason
	 */
	fun onDisconnected(callback: (code: Double?, reason: String?) -> Promise<Unit>)

	/**
	 * Subscribe to connection state changes
	 *
	 * @param callback The callback to be called when an error occurs
	 * - `errorMessage` The error message
	 * - `fatal` Whether the error is fatal or not, if `fatal` is `true`, the connection will be closed and have to be re-established by the client
	 */
	fun onError(callback: (errorMessage: String?, fatal: Boolean) -> Promise<Unit>)
}

fun connection_toJs(connection: Connection): ConnectionJs =
	ConnectionWrapper(connection)

private class ConnectionWrapper(
	private val connection: Connection
): ConnectionJs {
	override fun close(): Promise<Unit> = GlobalScope.promise {
		connection.close()
	}

	override fun onReconnected(callback: () -> Promise<Unit>) {
		connection.onReconnected {
			callback().await()
		}
	}

	override fun onDisconnected(callback: (code: Double?, reason: String?) -> Promise<Unit>) {
		connection.onDisconnected { code, reason ->
			callback(code?.toDouble(), reason)
		}
	}

	override fun onError(callback: (errorMessage: String?, fatal: Boolean) -> Promise<Unit>) {
		connection.onError { errorMessage, fatal ->
			callback(errorMessage, fatal)
		}
	}
}