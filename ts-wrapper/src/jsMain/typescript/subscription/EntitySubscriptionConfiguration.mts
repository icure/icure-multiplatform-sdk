// auto-generated file
import {DurationMs} from '../utils/DurationMs.mjs';


export class EntitySubscriptionConfiguration {

  channelBufferCapacity: number;

  onBufferFull: EntitySubscriptionConfiguration.FullBufferBehaviour;

  reconnectionDelay: DurationMs;

  retryDelayExponentFactor: number;

  connectionMaxRetries: number;

  constructor(partial: Partial<EntitySubscriptionConfiguration> & Pick<EntitySubscriptionConfiguration, "channelBufferCapacity" | "onBufferFull" | "reconnectionDelay" | "retryDelayExponentFactor" | "connectionMaxRetries">) {
    this.channelBufferCapacity = partial.channelBufferCapacity;
    this.onBufferFull = partial.onBufferFull;
    this.reconnectionDelay = partial.reconnectionDelay;
    this.retryDelayExponentFactor = partial.retryDelayExponentFactor;
    this.connectionMaxRetries = partial.connectionMaxRetries;
  }

}

export namespace EntitySubscriptionConfiguration {

  export enum FullBufferBehaviour {
    Close = "Close",
    DropOldest = "DropOldest",
    Ignore = "Ignore"
  }

}
