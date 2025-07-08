// auto-generated file
import {PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
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
			alternateRootDataOwnerReference: EntityReferenceInGroup | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedInvoice>;

	getEncryptionKeysOf(invoice: Invoice): Promise<Array<HexString>>;

	hasWriteAccess(invoice: Invoice): Promise<boolean>;

	decryptPatientIdOf(invoice: Invoice): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Invoice, delegates: Array<string>): Promise<void>;

	decrypt(invoice: EncryptedInvoice): Promise<DecryptedInvoice>;

	tryDecrypt(invoice: EncryptedInvoice): Promise<Invoice>;

	deleteInvoice(entityId: string): Promise<DocIdentifier>;

	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	shareWith(delegateId: string, invoice: DecryptedInvoice,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<DecryptedInvoice>;

	shareWithMany(invoice: DecryptedInvoice,
			delegates: { [ key: string ]: InvoiceShareOptions }): Promise<DecryptedInvoice>;

	findInvoicesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedInvoice>>;

	modifyInvoice(entity: DecryptedInvoice): Promise<DecryptedInvoice>;

	modifyInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	getInvoice(entityId: string): Promise<DecryptedInvoice | undefined>;

	getInvoices(entityIds: Array<string>): Promise<Array<DecryptedInvoice>>;

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
