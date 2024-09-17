// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';


export interface TopicFlavouredApi<E extends Topic> {

	shareWith(delegateId: string, topic: E,
			options?: { options?: TopicShareOptions | undefined }): Promise<E>;

	shareWithMany(topic: E, delegates: { [ key: string ]: TopicShareOptions }): Promise<E>;

	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

	modifyTopic(entity: E): Promise<E>;

	getTopic(entityId: string): Promise<E>;

	getTopics(entityIds: Array<string>): Promise<Array<E>>;

	addParticipant(entityId: string, dataOwnerId: string, topicRole: TopicRole): Promise<E>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<E>;

}
