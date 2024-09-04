package com.icure.cardinal.sdk.subscription

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.Serializable

/**
 * Events that a subscription observes.
 */
sealed interface EntitySubscriptionEvent<out E : Identifiable<String>> {
	/**
	 * The subscription could connect successfully to the backend and can start to receive entity notifications.
	 */
	@Serializable
	data object Connected : EntitySubscriptionEvent<Nothing>

	/**
	 * The subscription has successfully reconnected to the backend and can again receive entity notifications.
	 */
	@Serializable
	data object Reconnected : EntitySubscriptionEvent<Nothing>

	/**
	 * A general unexpected error.
	 */
	@Serializable
	data class UnexpectedError(val message: String) : EntitySubscriptionEvent<Nothing>

	/**
	 * There was an error in the connection with the backend.
	 */
	@Serializable
	sealed interface ConnectionError : EntitySubscriptionEvent<Nothing> {
		/**
		 * The backend has not responded to pings for a while. This could be a network issue or more rarely an issue
		 * with the backend.
		 *
		 * In case of a missed ping the subscription will try to reconnect, according to the configuration.
		 *
		 * Note that between the missed ping and successful reconnection to the backend the subscription may miss
		 * some entity notifications.
		 */
		@Serializable
		data object MissedPing : ConnectionError

		/**
		 * The server has closed the connection.
		 *
		 * The subscription will try to reconnect, according to the configuration, but until the reconnection is
		 * successful the subscription may miss some entity notifications.
		 */
		@Serializable
		data object ClosedByServer : ConnectionError
	}

	/**
	 * A change has been made to an entity that matches the configured filters.
	 * @param entity the updated entity.
	 */
	@Serializable
	data class EntityNotification<E : Identifiable<String>>(
		val entity: E
	) : EntitySubscriptionEvent<E>

	/**
	 * The backend has notified the subscription of a change to an entity, but the entity can't be used by the client.
	 */
	@Serializable
	sealed interface EntityError: EntitySubscriptionEvent<Nothing> {
		/**
		 * The entity can't be deserialized, most likely because you are using an incompatible version of the client
		 * with the backend.
		 */
		@Serializable
		data object DeserializationError : EntityError
	}
}