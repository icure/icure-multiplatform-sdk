import {Identifiable} from "../model/base/Identifiable.mjs";
import {EntitySubscriptionCloseReason} from "./EntitySubscriptionCloseReason.mjs";
import {EntitySubscriptionEvent} from "./EntitySubscriptionEvent.mjs";
import {CancellablePromise} from "../utils/CancellablePromise";

export interface EntitySubscription<E extends Identifiable<string>> {
  /**
   * Closes the subscription. A closed subscription will not receive any new events, but any existing event may still
   * be consumed after closing.
   */
  close(): Promise<void>

  /**
   * If the subscription is permanently closed. Even if this is true there may still be some unconsumed events
   */
  readonly isClosed: Boolean

  /**
   * If the subscription is closed the reason for closure, null otherwise. Even if this is not null there may still be
   * some unconsumed events
   */
  readonly closeReason: EntitySubscriptionCloseReason | null

  /**
   * Consume the next event in the subscription event queue or null if there is currently no event. If the subscription is
   * closed you can still retrieved any unconsumed event, but no new event will be added to the queue.
   */
  getEvent(): EntitySubscriptionEvent<E> | null

  /**
   * Waits for the next event in the subscription event queue and consumes it, or return null if no new event is produced
   * within the provided timeout or if the subscription gets closed while waiting.
   */
  waitForEvent(timeoutMs: number): CancellablePromise<EntitySubscriptionEvent<E> | null>
}