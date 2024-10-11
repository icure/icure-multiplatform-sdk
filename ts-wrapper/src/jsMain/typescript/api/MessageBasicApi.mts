// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {EncryptedMessage, Message} from '../model/Message.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface MessageBasicApi {

	matchMessagesBy(filter: BaseFilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<Array<string>>;

	filterMessagesBy(filter: BaseFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

	filterMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

	deleteMessage(entityId: string): Promise<DocIdentifier>;

	deleteMessages(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteMessageById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteMessagesByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeMessageById(id: string, rev: string): Promise<void>;

	deleteMessage(message: Message): Promise<DocIdentifier>;

	deleteMessages(messages: Array<Message>): Promise<Array<DocIdentifier>>;

	purgeMessage(message: Message): Promise<void>;

	undeleteMessage(message: Message): Promise<Message>;

	modifyMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	undeleteMessageById(id: string, rev: string): Promise<EncryptedMessage>;

	getMessage(entityId: string): Promise<EncryptedMessage>;

	getMessages(entityIds: Array<string>): Promise<Array<EncryptedMessage>>;

	listMessagesByTransportGuids(hcPartyId: string,
			transportGuids: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessages(startKey: any | undefined, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	getChildrenMessages(messageId: string): Promise<Array<EncryptedMessage>>;

	getMessagesChildren(messageIds: Array<string>): Promise<Array<EncryptedMessage>>;

	listMessagesByInvoices(invoiceIds: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessagesByTransportGuid(transportGuid: string): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByTransportGuidSentDate(transportGuid: string, from: number, to: number,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined, hcpId?: string | undefined }): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByToAddress(toAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByFromAddress(fromAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	setMessagesStatusBits(entityIds: Array<string>,
			statusBits: number): Promise<Array<EncryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<EncryptedMessage>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}
