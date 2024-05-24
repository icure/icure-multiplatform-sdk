// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedTopic, Topic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface TopicFlavouredApi<E extends Topic> {

	shareWith(
			delegateId: string,
			topic: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	modifyTopic(entity: E): Promise<E>;

	getTopic(entityId: string): Promise<E>;

	getTopics(entityIds: Array<string>): Promise<Array<E>>;

	filterTopicsBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<EncryptedTopic>): Promise<PaginatedList<E>>;

	addParticipant(entityId: string, dataOwnerId: string, topicRole: TopicRole): Promise<E>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<E>;

}
