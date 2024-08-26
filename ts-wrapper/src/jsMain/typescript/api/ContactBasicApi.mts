// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../icure-sdk-ts.mjs';
import {Contact, EncryptedContact} from '../model/Contact.mjs';
import {IcureStub} from '../model/IcureStub.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {EncryptedService, Service} from '../model/embed/Service.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface ContactBasicApi {

	matchContactsBy(filter: BaseFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBy(filter: BaseFilterOptions<Service>): Promise<Array<string>>;

	matchContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<Array<string>>;

	matchServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<Array<string>>;

	filterContactsBy(filter: BaseFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

	filterServicesBy(filter: BaseFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

	filterContactsBySorted(filter: BaseSortableFilterOptions<Contact>): Promise<PaginatedListIterator<EncryptedContact>>;

	filterServicesBySorted(filter: BaseSortableFilterOptions<Service>): Promise<PaginatedListIterator<EncryptedService>>;

	subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptions<Service>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedService>>;

	deleteContact(entityId: string): Promise<DocIdentifier>;

	deleteContacts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<IcureStub>>;

	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	modifyContact(entity: EncryptedContact): Promise<EncryptedContact>;

	modifyContacts(entities: Array<EncryptedContact>): Promise<Array<EncryptedContact>>;

	getContact(entityId: string): Promise<EncryptedContact>;

	getContacts(entityIds: Array<string>): Promise<Array<EncryptedContact>>;

	listContactByHCPartyServiceId(hcPartyId: string,
			serviceId: string): Promise<Array<EncryptedContact>>;

	listContactsByExternalId(externalId: string): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndFormId(hcPartyId: string,
			formId: string): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string,
			formIds: Array<string>): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			options?: { planOfActionsIds?: string | undefined, skipClosedContacts?: boolean | undefined }): Promise<Array<EncryptedContact>>;

	getService(serviceId: string): Promise<EncryptedService>;

	getServices(entityIds: Array<string>): Promise<Array<EncryptedService>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<EncryptedService>>;

	listServicesByAssociationId(associationId: string): Promise<Array<EncryptedService>>;

	listServicesByHealthElementId(hcPartyId: string,
			healthElementId: string): Promise<Array<EncryptedService>>;

	findContactsByOpeningDate(startDate: number, endDate: number, hcPartyId: string,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedContact>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Contact>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedContact>>;

}
