// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {Patient} from '../model/Patient.mjs';
import {DecryptedTopic, EncryptedTopic, Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {TopicFlavouredApi} from './TopicFlavouredApi.mjs';


export interface TopicApi {

	encrypted: TopicFlavouredApi<EncryptedTopic>;

	tryAndRecover: TopicFlavouredApi<Topic>;

	createTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	withEncryptionMetadata(base: DecryptedTopic | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedTopic>;

	getEncryptionKeysOf(topic: Topic): Promise<Array<HexString>>;

	hasWriteAccess(topic: Topic): Promise<boolean>;

	decryptPatientIdOf(topic: Topic): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Array<string>): Promise<void>;

	decrypt(topic: EncryptedTopic): Promise<DecryptedTopic>;

	tryDecrypt(topic: EncryptedTopic): Promise<Topic>;

	matchTopicsBy(filter: FilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<Array<string>>;

	deleteTopic(entityId: string): Promise<DocIdentifier>;

	deleteTopics(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, topic: DecryptedTopic,
			options?: { options?: TopicShareOptions | undefined }): Promise<SimpleShareResult<DecryptedTopic>>;

	tryShareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<SimpleShareResult<DecryptedTopic>>;

	shareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<DecryptedTopic>;

	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	modifyTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	getTopic(entityId: string): Promise<DecryptedTopic>;

	getTopics(entityIds: Array<string>): Promise<Array<DecryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<DecryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<DecryptedTopic>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}
