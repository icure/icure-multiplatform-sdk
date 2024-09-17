// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {Contact, DecryptedContact, EncryptedContact} from '../model/Contact.mjs';
import {IcureStub} from '../model/IcureStub.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {DecryptedService, EncryptedService, Service} from '../model/embed/Service.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {ContactFlavouredApi} from './ContactFlavouredApi.mjs';


export interface ContactApi {

	encrypted: ContactFlavouredApi<EncryptedContact, EncryptedService>;

	tryAndRecover: ContactFlavouredApi<Contact, Service>;

	matchContactsBy(filter: FilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(filter: FilterOptions<Service>): Promise<Array<string>>;

	matchContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBySorted(filter: SortableFilterOptions<Service>): Promise<Array<string>>;

	createContact(entity: DecryptedContact): Promise<DecryptedContact>;

	createContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	withEncryptionMetadata(base: DecryptedContact | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedContact>;

	getEncryptionKeysOf(contact: Contact): Promise<Array<HexString>>;

	hasWriteAccess(contact: Contact): Promise<boolean>;

	decryptPatientIdOf(contact: Contact): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Contact, delegates: Array<string>): Promise<void>;

	decrypt(contact: EncryptedContact): Promise<DecryptedContact>;

	tryDecrypt(contact: EncryptedContact): Promise<Contact>;

	decryptService(service: EncryptedService): Promise<DecryptedService>;

	tryDecryptService(service: EncryptedService): Promise<Service>;

	subscribeToServiceCreateOrUpdateEvents(filter: FilterOptions<Service>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedService>>;

	deleteContact(entityId: string): Promise<DocIdentifier>;

	deleteContacts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	shareWith(delegateId: string, contact: DecryptedContact,
			options?: { options?: ContactShareOptions | undefined }): Promise<DecryptedContact>;

	shareWithMany(contact: DecryptedContact,
			delegates: { [ key: string ]: ContactShareOptions }): Promise<DecryptedContact>;

	findContactsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedContact>>;

	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<DecryptedContact>>;

	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<DecryptedService>>;

	modifyContact(entity: DecryptedContact): Promise<DecryptedContact>;

	modifyContacts(entities: Array<DecryptedContact>): Promise<Array<DecryptedContact>>;

	getContact(entityId: string): Promise<DecryptedContact>;

	getContacts(entityIds: Array<string>): Promise<Array<DecryptedContact>>;

	listContactByHCPartyServiceId(hcPartyId: string,
			serviceId: string): Promise<Array<DecryptedContact>>;

	listContactsByExternalId(externalId: string): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndFormId(hcPartyId: string,
			formId: string): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string,
			formIds: Array<string>): Promise<Array<DecryptedContact>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			options?: { planOfActionsIds?: string | undefined, skipClosedContacts?: boolean | undefined }): Promise<Array<DecryptedContact>>;

	getService(serviceId: string): Promise<DecryptedService>;

	getServices(entityIds: Array<string>): Promise<Array<DecryptedService>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<DecryptedService>>;

	listServicesByAssociationId(associationId: string): Promise<Array<DecryptedService>>;

	listServicesByHealthElementId(hcPartyId: string,
			healthElementId: string): Promise<Array<DecryptedService>>;

	findContactsByOpeningDate(startDate: number, endDate: number, hcPartyId: string,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedContact>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
