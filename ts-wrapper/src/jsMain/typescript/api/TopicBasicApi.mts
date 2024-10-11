// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {EncryptedTopic, Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface TopicBasicApi {

	matchTopicsBy(filter: BaseFilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<Array<string>>;

	filterTopicsBy(filter: BaseFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

	filterTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteTopicById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteTopicsByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeTopicById(id: string, rev: string): Promise<void>;

	deleteTopic(topic: Topic): Promise<DocIdentifier>;

	deleteTopics(topics: Array<Topic>): Promise<Array<DocIdentifier>>;

	purgeTopic(topic: Topic): Promise<void>;

	undeleteTopic(topic: Topic): Promise<Topic>;

	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	undeleteTopicById(id: string, rev: string): Promise<EncryptedTopic>;

	getTopic(entityId: string): Promise<EncryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<EncryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}
