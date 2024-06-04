// auto-generated file
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedTopic, Topic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface TopicBasicApi {

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	matchTopicsBy(filter: AbstractFilter<Topic>): Promise<Array<string>>;

	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	getTopic(entityId: string): Promise<EncryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

	filterTopicsBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<Topic>): Promise<PaginatedList<EncryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<EncryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

	subscribeToEvents(
			events: Array<SubscriptionEventType>,
			filter: AbstractFilter<Topic>,
			onConnected: () => void,
			channelCapacity: number,
			retryDelay: DurationMs,
			retryDelayExponentFactor: number,
			maxRetries: number,
			eventFired: (x1: EncryptedTopic) => void
	): Promise<Connection>;

}
