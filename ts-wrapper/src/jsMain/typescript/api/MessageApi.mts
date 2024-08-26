// auto-generated file
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {SecretIdOption} from '../crypto/entities/SecretIdOption.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../model/Message.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
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

	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	withEncryptionMetadata(base: DecryptedMessage | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedMessage>;

	getEncryptionKeysOf(message: Message): Promise<Array<HexString>>;

	hasWriteAccess(message: Message): Promise<boolean>;

	decryptPatientIdOf(message: Message): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Message, delegates: Array<string>): Promise<void>;

	decrypt(message: EncryptedMessage): Promise<DecryptedMessage>;

	tryDecrypt(message: EncryptedMessage): Promise<Message>;

	matchMessagesBy(filter: FilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<Array<string>>;

	deleteMessage(entityId: string): Promise<DocIdentifier>;

	deleteMessages(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, message: DecryptedMessage,
			options: MessageShareOptions): Promise<SimpleShareResult<DecryptedMessage>>;

	tryShareWithMany(message: DecryptedMessage,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<SimpleShareResult<DecryptedMessage>>;

	shareWithMany(message: DecryptedMessage,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<DecryptedMessage>;

	findMessagesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedMessage>>;

	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	modifyMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	getMessage(entityId: string): Promise<DecryptedMessage>;

	getMessages(entityIds: Array<string>): Promise<Array<DecryptedMessage>>;

	listMessagesByTransportGuids(hcPartyId: string,
			transportGuids: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<string>): Promise<Array<DecryptedMessage>>;

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
