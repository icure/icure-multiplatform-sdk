// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {EncryptedInvoice, Invoice} from '../../model/Invoice.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {InvoiceType} from '../../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../../model/embed/InvoicingCode.mjs';
import {MediumType} from '../../model/embed/MediumType.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface InvoiceFlavouredApi<E extends Invoice> {

	shareWith(
			delegateId: string,
			invoice: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	findInvoicesByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<E>>;

	modifyInvoice(entity: E): Promise<E>;

	modifyInvoices(entities: Array<E>): Promise<Array<E>>;

	getInvoice(entityId: string): Promise<E>;

	getInvoices(entityIds: Array<string>): Promise<Array<E>>;

	filterInvoicesBy(filterChain: FilterChain<EncryptedInvoice>): Promise<Array<E>>;

	findInvoicesByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

	reassignInvoice(invoice: E): Promise<E>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<E>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<E>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			insuranceId: string | undefined,
			invoiceId: string | undefined,
			gracePeriod: number | undefined,
			invoicingCodes: Array<EncryptedInvoicingCode>
	): Promise<Array<E>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<E>>;

	findInvoicesByAuthor(
			hcPartyId: string,
			fromDate: number | undefined,
			toDate: number | undefined,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<E>>;

	listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string, groupId: string): Promise<Array<E>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			from: number | undefined,
			to: number | undefined
	): Promise<Array<E>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<E>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<E>>;

	listToInsurances(userIds: Array<string>): Promise<Array<E>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<E>>;

	listToPatients(hcPartyId: string): Promise<Array<E>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<E>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<E>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<E>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<E>>;

	listAllHcpsByStatus(status: string, from: number | undefined, to: number | undefined,
			hcpIds: Array<string>): Promise<Array<E>>;

}
