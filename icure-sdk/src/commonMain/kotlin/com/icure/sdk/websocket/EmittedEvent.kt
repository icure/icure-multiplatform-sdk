package com.icure.sdk.websocket

sealed interface EmittedEvent {

	val event: WebSocketEvent

	data object Connect : EmittedEvent {
		override val event = WebSocketEvent.OPEN
	}
	data object Reconnect : EmittedEvent {
		override val event = WebSocketEvent.OPEN
	}
	data class Close(val code: Short?, val reason: String?) : EmittedEvent {
		override val event = WebSocketEvent.CLOSE
	}
	data class Error(val data: String?, val fatal: Boolean) : EmittedEvent {
		override val event = WebSocketEvent.ERROR
	}
	data class Message(val message: String) : EmittedEvent {
		override val event = WebSocketEvent.MESSAGE
	}
}
