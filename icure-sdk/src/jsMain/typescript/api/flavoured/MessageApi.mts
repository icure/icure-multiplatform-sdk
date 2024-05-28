// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../../model/Message.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {MessageFlavouredApi} from './MessageFlavouredApi.mjs';


export interface MessageApi {

	encrypted: MessageFlavouredApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredApi<Message>;

	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	withEncryptionMetadata(
			base: DecryptedMessage | undefined,
			patient: Patient | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedMessage>;

	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	matchMessagesBy(filter: AbstractFilter<EncryptedMessage>): Promise<Array<string>>;

	deleteMessage(entityId: string): Promise<DocIdentifier>;

	deleteMessages(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			message: DecryptedMessage,
			shareSecretIds: Array<string>,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedMessage>>;

	findMessagesByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedMessage>>;

	modifyMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	getMessage(entityId: string): Promise<DecryptedMessage>;

	getMessages(entityIds: Array<string>): Promise<Array<DecryptedMessage>>;

	filterMessagesBy(filterChain: FilterChain<EncryptedMessage>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	listMessagesByTransportGuids(hcPartyId: string,
			transportGuids: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessages(startKey: any | undefined, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	getChildrenMessages(messageId: string): Promise<Array<DecryptedMessage>>;

	getMessagesChildren(messageIds: Array<string>): Promise<Array<DecryptedMessage>>;

	listMessagesByInvoices(invoiceIds: Array<string>): Promise<Array<DecryptedMessage>>;

	findMessagesByTransportGuid(transportGuid: string): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByTransportGuidSentDate(
			transportGuid: string,
			from: number,
			to: number,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			hcpId: string | undefined
	): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByToAddress(toAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	findMessagesByFromAddress(fromAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedMessage>>;

	setMessagesStatusBits(entityIds: Array<string>,
			statusBits: number): Promise<Array<DecryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string): Promise<Array<DecryptedMessage>>;

}
