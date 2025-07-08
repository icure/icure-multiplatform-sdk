// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../model/Message.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MessageFlavouredApi} from './MessageFlavouredApi.mjs';


export interface MessageApi {

	encrypted: MessageFlavouredApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredApi<Message>;

	withEncryptionMetadata(base: DecryptedMessage | undefined, patient: Patient | undefined,
			alternateRootDataOwnerReference: EntityReferenceInGroup | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedMessage>;

	getEncryptionKeysOf(message: Message): Promise<Array<HexString>>;

	hasWriteAccess(message: Message): Promise<boolean>;

	decryptPatientIdOf(message: Message): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Message, delegates: Array<string>): Promise<void>;

	decrypt(message: EncryptedMessage): Promise<DecryptedMessage>;

	tryDecrypt(message: EncryptedMessage): Promise<Message>;

	getSecretIdsOf(message: Message): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	matchMessagesBy(filter: FilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<Array<string>>;

	deleteMessageUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteMessagesUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteMessageById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	purgeMessageById(id: string, rev: string): Promise<void>;

	deleteMessage(message: Message): Promise<DocIdentifier>;

	deleteMessages(messages: Array<Message>): Promise<Array<DocIdentifier>>;

	purgeMessage(message: Message): Promise<void>;

	shareWith(delegateId: string, message: DecryptedMessage,
			options?: { options?: MessageShareOptions | undefined }): Promise<DecryptedMessage>;

	shareWithMany(message: DecryptedMessage,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<DecryptedMessage>;

	findMessagesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedMessage>>;

	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	undeleteMessage(message: Message): Promise<Message>;

	modifyMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	undeleteMessageById(id: string, rev: string): Promise<DecryptedMessage>;

	getMessage(entityId: string): Promise<DecryptedMessage | undefined>;

	getMessages(entityIds: Array<string>): Promise<Array<DecryptedMessage>>;

	listMessagesByTransportGuids(hcPartyId: string,
			transportGuids: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessages(startKey: any | undefined, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	getChildrenMessages(messageId: string): Promise<Array<DecryptedMessage>>;

	getMessagesChildren(messageIds: Array<string>): Promise<Array<DecryptedMessage>>;

	listMessagesByInvoices(invoiceIds: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessagesByTransportGuid(transportGuid: string): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByTransportGuidSentDate(transportGuid: string, from: number, to: number,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined, hcpId?: string | undefined }): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByToAddress(toAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByFromAddress(fromAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	setMessagesStatusBits(entityIds: Array<string>,
			statusBits: number): Promise<Array<DecryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<DecryptedMessage>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}
