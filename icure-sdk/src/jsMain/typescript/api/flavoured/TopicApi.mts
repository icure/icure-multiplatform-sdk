// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {DecryptedTopic, EncryptedTopic, Topic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {TopicFlavouredApi} from './TopicFlavouredApi.mjs';


export interface TopicApi {

	encrypted: TopicFlavouredApi<EncryptedTopic>;

	tryAndRecover: TopicFlavouredApi<Topic>;

	createTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	withEncryptionMetadata(
			base: DecryptedTopic | undefined,
			patient: Patient | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedTopic>;

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	matchTopicsBy(filter: AbstractFilter<EncryptedTopic>): Promise<Array<string>>;

	shareWith(
			delegateId: string,
			topic: DecryptedTopic,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedTopic>>;

	modifyTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	getTopic(entityId: string): Promise<DecryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<DecryptedTopic>>;

	filterTopicsBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<EncryptedTopic>): Promise<PaginatedList<DecryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<DecryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<DecryptedTopic>;

}