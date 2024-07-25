// auto-generated file
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedTopic, Topic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {EntitySubscription} from '../../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../../subscription/EntitySubscriptionConfiguration.mjs';


export interface TopicBasicApi {

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	matchTopicsBy(filter: AbstractFilter<Topic>): Promise<Array<string>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	getTopic(entityId: string): Promise<EncryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

	filterTopicsBy(filterChain: FilterChain<Topic>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<EncryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

}
