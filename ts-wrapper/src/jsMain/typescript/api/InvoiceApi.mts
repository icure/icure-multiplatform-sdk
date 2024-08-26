// auto-generated file
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {SecretIdOption} from '../crypto/entities/SecretIdOption.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../icure-sdk-ts.mjs';
import {IcureStub} from '../model/IcureStub.mjs';
import {DecryptedInvoice, EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {InvoiceType} from '../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../model/embed/InvoicingCode.mjs';
import {MediumType} from '../model/embed/MediumType.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {InvoiceFlavouredApi} from './InvoiceFlavouredApi.mjs';


export interface InvoiceApi {

	encrypted: InvoiceFlavouredApi<EncryptedInvoice>;

	tryAndRecover: InvoiceFlavouredApi<Invoice>;

	createInvoice(entity: DecryptedInvoice, prefix: string | undefined): Promise<DecryptedInvoice>;

	createInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	withEncryptionMetadata(base: DecryptedInvoice | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedInvoice>;

	getEncryptionKeysOf(invoice: Invoice): Promise<Array<HexString>>;

	hasWriteAccess(invoice: Invoice): Promise<boolean>;

	decryptPatientIdOf(invoice: Invoice): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Array<string>): Promise<void>;

	decrypt(invoice: EncryptedInvoice): Promise<DecryptedInvoice>;

	tryDecrypt(invoice: EncryptedInvoice): Promise<Invoice>;

	deleteInvoice(entityId: string): Promise<DocIdentifier>;

	findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	shareWith(delegateId: string, invoice: DecryptedInvoice,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<SimpleShareResult<DecryptedInvoice>>;

	tryShareWithMany(invoice: DecryptedInvoice,
			delegates: { [ key: string ]: InvoiceShareOptions }): Promise<SimpleShareResult<DecryptedInvoice>>;

	shareWithMany(invoice: DecryptedInvoice,
			delegates: { [ key: string ]: InvoiceShareOptions }): Promise<DecryptedInvoice>;

	findInvoicesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedInvoice>>;

	modifyInvoice(entity: DecryptedInvoice): Promise<DecryptedInvoice>;

	modifyInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	getInvoice(entityId: string): Promise<DecryptedInvoice>;

	getInvoices(entityIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	findInvoicesByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<DecryptedInvoice>>;

	reassignInvoice(invoice: DecryptedInvoice): Promise<DecryptedInvoice>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<DecryptedInvoice>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<DecryptedInvoice>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			invoicingCodes: Array<EncryptedInvoicingCode>,
			options?: { insuranceId?: string | undefined, invoiceId?: string | undefined, gracePeriod?: number | undefined }
	): Promise<Array<DecryptedInvoice>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	findInvoicesByAuthor(hcPartyId: string,
			options?: { fromDate?: number | undefined, toDate?: number | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedInvoice>>;

	listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<DecryptedInvoice>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string,
			groupId: string): Promise<Array<DecryptedInvoice>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			options?: { from?: number | undefined, to?: number | undefined }
	): Promise<Array<DecryptedInvoice>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToInsurances(userIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listToPatients(hcPartyId: string): Promise<Array<DecryptedInvoice>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<DecryptedInvoice>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<DecryptedInvoice>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<DecryptedInvoice>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<DecryptedInvoice>>;

	listAllHcpsByStatus(status: string, hcpIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined }): Promise<Array<DecryptedInvoice>>;

}
