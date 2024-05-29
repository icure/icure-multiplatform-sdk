// auto-generated file
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedTopic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';


export interface TopicBasicApi {

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	matchTopicsBy(filter: AbstractFilter<EncryptedTopic>): Promise<Array<string>>;

	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	getTopic(entityId: string): Promise<EncryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

	filterTopicsBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<EncryptedTopic>): Promise<PaginatedList<EncryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<EncryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

}