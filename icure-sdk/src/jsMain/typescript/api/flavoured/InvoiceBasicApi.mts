// auto-generated file
import {IcureStub} from '../../model/IcureStub.mjs';
import {EncryptedInvoice, Invoice} from '../../model/Invoice.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../../model/data/LabelledOccurence.mjs';
import {InvoiceType} from '../../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../../model/embed/InvoicingCode.mjs';
import {MediumType} from '../../model/embed/MediumType.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';


export interface InvoiceBasicApi {

	deleteInvoice(entityId: string): Promise<DocIdentifier>;

	findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	modifyInvoice(entity: EncryptedInvoice): Promise<EncryptedInvoice>;

	modifyInvoices(entities: Array<EncryptedInvoice>): Promise<Array<EncryptedInvoice>>;

	getInvoice(entityId: string): Promise<EncryptedInvoice>;

	getInvoices(entityIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	filterInvoicesBy(filterChain: FilterChain<Invoice>): Promise<Array<EncryptedInvoice>>;

	findInvoicesByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<EncryptedInvoice>>;

	reassignInvoice(invoice: EncryptedInvoice): Promise<EncryptedInvoice>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<EncryptedInvoice>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<EncryptedInvoice>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			insuranceId: string | undefined,
			invoiceId: string | undefined,
			gracePeriod: number | undefined,
			invoicingCodes: Array<EncryptedInvoicingCode>
	): Promise<Array<EncryptedInvoice>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	findInvoicesByAuthor(
			hcPartyId: string,
			fromDate: number | undefined,
			toDate: number | undefined,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<EncryptedInvoice>>;

	listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<EncryptedInvoice>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string,
			groupId: string): Promise<Array<EncryptedInvoice>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			from: number | undefined,
			to: number | undefined
	): Promise<Array<EncryptedInvoice>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToInsurances(userIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToPatients(hcPartyId: string): Promise<Array<EncryptedInvoice>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<EncryptedInvoice>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<EncryptedInvoice>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<EncryptedInvoice>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listAllHcpsByStatus(status: string, from: number | undefined, to: number | undefined,
			hcpIds: Array<string>): Promise<Array<EncryptedInvoice>>;

}
