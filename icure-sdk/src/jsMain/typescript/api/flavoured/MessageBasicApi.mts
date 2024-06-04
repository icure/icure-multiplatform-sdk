// auto-generated file
import {EncryptedMessage, Message} from '../../model/Message.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface MessageBasicApi {

	matchMessagesBy(filter: AbstractFilter<Message>): Promise<Array<string>>;

	deleteMessage(entityId: string): Promise<DocIdentifier>;

	deleteMessages(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	getMessage(entityId: string): Promise<EncryptedMessage>;

	getMessages(entityIds: Array<string>): Promise<Array<EncryptedMessage>>;

	filterMessagesBy(filterChain: FilterChain<Message>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	listMessagesByTransportGuids(hcPartyId: string,
			transportGuids: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessages(startKey: any | undefined, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	getChildrenMessages(messageId: string): Promise<Array<EncryptedMessage>>;

	getMessagesChildren(messageIds: Array<string>): Promise<Array<EncryptedMessage>>;

	listMessagesByInvoices(invoiceIds: Array<string>): Promise<Array<EncryptedMessage>>;

	findMessagesByTransportGuid(transportGuid: string): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByTransportGuidSentDate(
			transportGuid: string,
			from: number,
			to: number,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			hcpId: string | undefined
	): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByToAddress(toAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	findMessagesByFromAddress(fromAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedMessage>>;

	setMessagesStatusBits(entityIds: Array<string>,
			statusBits: number): Promise<Array<EncryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string): Promise<Array<EncryptedMessage>>;

	subscribeToEvents(
			events: Array<SubscriptionEventType>,
			filter: AbstractFilter<Message>,
			onConnected: () => void,
			channelCapacity: number,
			retryDelay: DurationMs,
			retryDelayExponentFactor: number,
			maxRetries: number,
			eventFired: (x1: EncryptedMessage) => void
	): Promise<Connection>;

}
