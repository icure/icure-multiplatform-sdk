package com.icure.sdk.websocket

class WebSocketEventListener<T> {
	private val listeners = mutableListOf<suspend (data: T) -> Unit>()

	fun addListener(listener: suspend (data: T) -> Unit) {
		listeners.add(listener)
	}

	suspend fun onMessage(data: T) {
		listeners.forEach { it(data) }
	}
}
