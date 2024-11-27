package com.icure.cardinal.sdk.js.subscription

import com.icure.cardinal.sdk.js.model.base.IdentifiableJs
import com.icure.cardinal.sdk.js.utils.CancellablePromise
import com.icure.cardinal.sdk.js.utils.cancellablePromise
import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.subscription.EntitySubscription
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.js.Promise
import kotlin.time.Duration.Companion.milliseconds

@JsName("EntitySubscription")
external interface EntitySubscriptionJs<E : IdentifiableJs<String>> {
	/**
	 * Closes the subscription. A closed subscription will not receive any new events, but any existing event may still
	 * be consumed after closing.
	 */
	fun close(): Promise<Unit>

	/**
	 * If the subscription is permanently closed. Even if this is true there may still be some unconsumed events
	 */
	val isClosed: Boolean

	/**
	 * If the subscription is closed the reason for closure, null otherwise. Even if this is not null there may still be
	 * some unconsumed events
	 */
	val closeReason: String?

	/**
	 * Consume the next event in the subscription event queue or null if there is currently no event. If the subscription is
	 * closed you can still retrieved any unconsumed event, but no new event will be added to the queue.
	 */
	fun getEvent(): EntitySubscriptionEventJs<E>?

	/**
	 * Waits for the next event in the subscription event queue and consumes it, or return null if no new event is produced
	 * within the provided timeout or if the subscription gets closed while waiting.
	 */
	fun waitForEvent(timeoutMs: Int): CancellablePromise<EntitySubscriptionEventJs<E>?>
}

fun <EKT : Identifiable<String>, EJS : IdentifiableJs<String>> entitySubscription_toJs(
	subscription: EntitySubscription<EKT>,
	converter: (EKT) -> EJS
): EntitySubscriptionJs<EJS> =
	EntitySubscriptionWrapper(subscription, converter)

private class EntitySubscriptionWrapper<EKT : Identifiable<String>, EJS : IdentifiableJs<String>>(
	private val delegate: EntitySubscription<EKT>,
	private val converter: (EKT) -> EJS
) : EntitySubscriptionJs<EJS> {
	override fun close(): Promise<Unit> = GlobalScope.promise {
		delegate.close()
	}

	override val isClosed: Boolean
		get() = closeReason != null

	override val closeReason: String?
		get() = delegate.closeReason?.name

	override fun getEvent(): EntitySubscriptionEventJs<EJS>? =
		delegate.eventChannel.tryReceive().getOrNull()?.let { entitySubscriptionEvent_toJs(it, converter) }

	override fun waitForEvent(timeoutMs: Int): CancellablePromise<EntitySubscriptionEventJs<EJS>?> =
		GlobalScope.cancellablePromise {
			withTimeoutOrNull(timeoutMs.milliseconds) {
				delegate.eventChannel.receiveCatching().getOrNull()
			}?.let { entitySubscriptionEvent_toJs(it, converter) }
		}
}
