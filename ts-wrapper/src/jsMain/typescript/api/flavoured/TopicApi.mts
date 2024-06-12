// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {TopicShareOptions} from '../../crypto/entities/TopicShareOptions.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {DecryptedTopic, EncryptedTopic, Topic} from '../../model/Topic.mjs';
import {TopicRole} from '../../model/TopicRole.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';
import {TopicFlavouredApi} from './TopicFlavouredApi.mjs';


export interface TopicApi {

	encrypted: TopicFlavouredApi<EncryptedTopic>;

	tryAndRecover: TopicFlavouredApi<Topic>;

	createTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	withEncryptionMetadata(base: DecryptedTopic | undefined, patient: Patient | undefined,
			options?: { base?: DecryptedTopic | undefined, patient?: Patient | undefined, user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedTopic>;

	getEncryptionKeysOf(topic: Topic): Promise<Array<HexString>>;

	hasWriteAccess(topic: Topic): Promise<boolean>;

	decryptPatientIdOf(topic: Topic): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Array<string>): Promise<void>;

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	matchTopicsBy(filter: AbstractFilter<Topic>): Promise<Array<string>>;

	shareWith(delegateId: string, topic: DecryptedTopic,
			options?: { delegateId?: string, topic?: DecryptedTopic, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<DecryptedTopic>>;

	tryShareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<SimpleShareResult<DecryptedTopic>>;

	shareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<DecryptedTopic>;

	modifyTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	getTopic(entityId: string): Promise<DecryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<DecryptedTopic>>;

	filterTopicsBy(filterChain: FilterChain<Topic>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined, filterChain?: FilterChain<Topic> }): Promise<PaginatedList<DecryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<DecryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<DecryptedTopic>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Topic>,
			eventFired: (x1: DecryptedTopic) => Promise<void>,
			options?: { events?: Array<SubscriptionEventType>, filter?: AbstractFilter<Topic>, onConnected?: () => Promise<void>, channelCapacity?: number, retryDelay?: DurationMs, retryDelayExponentFactor?: number, maxRetries?: number, eventFired?: (x1: DecryptedTopic) => Promise<void> }): Promise<Connection>;

}
