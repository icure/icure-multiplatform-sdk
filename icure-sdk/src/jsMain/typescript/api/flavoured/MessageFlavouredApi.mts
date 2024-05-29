// auto-generated file
import {MessageShareOptions} from '../../crypto/entities/MessageShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Message} from '../../model/Message.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface MessageFlavouredApi<E extends Message> {

	shareWith(
			delegateId: string,
			message: E,
			shareSecretIds: Array<string>,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	tryShareWithMany(message: E,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(message: E, delegates: { [ key: string ]: MessageShareOptions }): Promise<E>;

	findMessagesByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<E>>;

	modifyMessage(entity: E): Promise<E>;

	getMessage(entityId: string): Promise<E>;

	getMessages(entityIds: Array<string>): Promise<Array<E>>;

	filterMessagesBy(filterChain: FilterChain<Message>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<E>>;

	listMessagesByTransportGuids(hcPartyId: string, transportGuids: Array<string>): Promise<Array<E>>;

	findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<string>): Promise<Array<E>>;

	findMessages(startKey: any | undefined, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<E>>;

	getChildrenMessages(messageId: string): Promise<Array<E>>;

	getMessagesChildren(messageIds: Array<string>): Promise<Array<E>>;

	listMessagesByInvoices(invoiceIds: Array<string>): Promise<Array<E>>;

	findMessagesByTransportGuid(transportGuid: string): Promise<PaginatedList<E>>;

	findMessagesByTransportGuidSentDate(
			transportGuid: string,
			from: number,
			to: number,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			hcpId: string | undefined
	): Promise<PaginatedList<E>>;

	findMessagesByToAddress(toAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	findMessagesByFromAddress(fromAddress: string, startKey: any | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	setMessagesStatusBits(entityIds: Array<string>, statusBits: number): Promise<Array<E>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string): Promise<Array<E>>;

}
