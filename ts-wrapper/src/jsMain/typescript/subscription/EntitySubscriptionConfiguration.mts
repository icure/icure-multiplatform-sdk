// auto-generated file
import {DurationMs} from '../utils/DurationMs.mjs';


export class EntitySubscriptionConfiguration {

	channelBufferCapacity: number = 100;

	onBufferFull: EntitySubscriptionConfiguration.FullBufferBehaviour = EntitySubscriptionConfiguration.FullBufferBehaviour.Close;

	reconnectionDelay: DurationMs = 2000;

	retryDelayExponentFactor: number = 2.0;

	connectionMaxRetries: number = 5;

	constructor(partial: Partial<EntitySubscriptionConfiguration>) {
		if ('channelBufferCapacity' in partial && partial.channelBufferCapacity !== undefined) this.channelBufferCapacity = partial.channelBufferCapacity;
		if ('onBufferFull' in partial && partial.onBufferFull !== undefined) this.onBufferFull = partial.onBufferFull;
		if ('reconnectionDelay' in partial && partial.reconnectionDelay !== undefined) this.reconnectionDelay = partial.reconnectionDelay;
		if ('retryDelayExponentFactor' in partial && partial.retryDelayExponentFactor !== undefined) this.retryDelayExponentFactor = partial.retryDelayExponentFactor;
		if ('connectionMaxRetries' in partial && partial.connectionMaxRetries !== undefined) this.connectionMaxRetries = partial.connectionMaxRetries;
	}

}

export namespace EntitySubscriptionConfiguration {

	export enum FullBufferBehaviour {
		Close = "Close",
		DropOldest = "DropOldest",
		Ignore = "Ignore"
	}

}
