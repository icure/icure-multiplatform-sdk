package com.icure.sdk.websocket

class WebSocketEventListener<T>(
	callbacks: List<suspend (data: T) -> Unit> = emptyList()
) {
	private val listeners = mutableListOf<suspend (data: T) -> Unit>()

	init {
		listeners.addAll(callbacks)
	}

	fun addListener(listener: suspend (data: T) -> Unit) {
		listeners.add(listener)
	}

	suspend fun onEvent(data: T) {
		listeners.forEach {
			runCatching {
				it(data)
			}.onFailure {
				it.printStackTrace()
			}
		}
	}
}
