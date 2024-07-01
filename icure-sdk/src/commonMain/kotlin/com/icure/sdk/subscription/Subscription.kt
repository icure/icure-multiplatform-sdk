package com.icure.sdk.subscription

import com.icure.sdk.model.base.Identifiable
import kotlinx.coroutines.channels.ReceiveChannel
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * A subscription allows to get realtime updates on entities of type [E].
 * Note that subscriptions need to be closed explicitly.
 */
interface Subscription<E : Identifiable<String>> {
	/**
	 * Closes the subscription. A closed subscription will not receive any new events, but any existing event may still
	 * be consumed after closing.
	 */
	suspend fun close()

	/**
	 * If the subscription is permanently closed. Even if this is true there may still be some unconsumed events
	 */
	val isClosed: Boolean get() = closeReason != null

	/**
	 * If the subscription is closed the reason for closure, null otherwise. Even if this is not null there may still be
	 * some unconsumed events
	 */
	val closeReason: CloseReason?

	/**
	 * The events observed by this subscription.
	 */
	val eventChannel: ReceiveChannel<Event<E>>

	/**
	 * Events that a subscription observes.
	 */
	sealed interface Event<out E : Identifiable<String>> {
		/**
		 * The subscription could connect successfully to the backend and can start to receive entity notifications.
		 */
		data object Connected : Event<Nothing>

		/**
		 * The subscription has successfully reconnected to the backend and can again receive entity notifications.
		 */
		data object Reconnected : Event<Nothing>

		/**
		 * A general unexpected error.
		 */
		data class UnexpectedError(val e: Throwable) : Event<Nothing>

		/**
		 * There was an error in the connection with the backend.
		 */
		sealed interface ConnectionError : Event<Nothing> {
			/**
			 * The backend has not responded to pings for a while. This could be a network issue or more rarely an issue
			 * with the backend.
			 *
			 * In case of a missed ping the subscription will try to reconnect, according to the configuration.
			 *
			 * Note that between the missed ping and successful reconnection to the backend the subscription may miss
			 * some entity notifications.
			 */
			data object MissedPing : ConnectionError

			/**
			 * The server has closed the connection.
			 *
			 * The subscription will try to reconnect, according to the configuration, but until the reconnection is
			 * successful the subscription may miss some entity notifications.
			 */
			data object ClosedByServer : ConnectionError
		}

		/**
		 * A change has been made to an entity that matches the configured filters.
		 * @param entity the updated entity.
		 */
		data class EntityNotification<E : Identifiable<String>>(
			val entity: E
		) : Event<E>

		/**
		 * The backend has notified the subscription of a change to an entity, but the entity can't be used by the client.
		 */
		sealed interface EntityError: Event<Nothing> {
			/**
			 * The entity can't be deserialized, most likely because you are using an incompatible version of the client
			 * with the backend.
			 */
			data object DeserializationError : EntityError
		}
	}

	sealed interface CloseReason {
		/**
		 * A new event was produced but the event channel was at maximum capacity and the
		 * [Subscription.Configuration.onBufferFull] is [Subscription.Configuration.FullBufferBehaviour.CLOSE].
		 */
		data object ChannelFullException : CloseReason

		/**
		 * The subscription can't connect or lost the connection to the backend (and could not reconnect within the
		 * configured amount of retries).
		 */
		data object ConnectionLost : CloseReason

		/**
		 * The subscription was closed by invoking the [close] method.
		 */
		data object IntentionallyClosed : CloseReason
	}


	/**
	 * Configurations for a subscription,
	 */
	data class Configuration(
		/**
		 * The amount of (unconsumed) events that the subscription can buffer
		 */
		val channelBufferCapacity: Int = 100,
		/**
		 * How the subscription should behave if a new event is received but it does not fit in the buffer
		 */
		val onBufferFull: FullBufferBehaviour = FullBufferBehaviour.CLOSE,
		/**
		 * If the (re)connection fails how long to wait before another attempt.
		 */
		val reconnectionDelay: Duration = 2.seconds,
		/**
		 * Factor for increasing the delay between (re)connection attempts in case of repeated failures.
		 */
		val retryDelayExponentFactor: Double = 2.0,
		/**
		 * How many times should the subscription attempt to (re)connect before closing with a [Subscription.ConnectionException]
		 */
		val connectionMaxRetries: Int = 5,
	) {
		enum class FullBufferBehaviour {
			/**
			 * The subscription will be closed, and the [Subscription.eventChannel] will fail with a [Subscription.ChannelFullException]
			 */
			CLOSE,
			/**
			 * The oldest event will be dropped (i.e. the next element in the [Subscription.eventChannel]), and the new
			 * event will be added.
			 */
			DROP_OLDEST,
			/**
			 * The event will simply be ignored, the [Subscription.eventChannel] will not be changed.
			 */
			IGNORE
		}
	}
}