// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {DecryptedInvoice, EncryptedInvoice, Invoice} from '../../model/Invoice.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {InvoiceFlavouredApi} from './InvoiceFlavouredApi.mjs';


export interface InvoiceApi {

	encrypted: InvoiceFlavouredApi<EncryptedInvoice>;

	tryAndRecover: InvoiceFlavouredApi<Invoice>;

	createInvoice(entity: DecryptedInvoice): Promise<DecryptedInvoice>;

	createInvoices(entities: Array<DecryptedInvoice>): Promise<Array<DecryptedInvoice>>;

	withEncryptionMetadata(
			base: DecryptedInvoice | undefined,
			patient: Patient | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedInvoice>;

	deleteInvoice(entityId: string): Promise<DocIdentifier>;

	findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	shareWith(
			delegateId: string,
			invoice: DecryptedInvoice,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedInvoice>>;

	findInvoicesByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedInvoice>>;

}
