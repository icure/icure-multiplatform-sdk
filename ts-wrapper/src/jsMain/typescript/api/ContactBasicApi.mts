// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Contact, EncryptedContact} from '../model/Contact.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
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

	deleteContactUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteContactsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteContactById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteContactsByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeContactById(id: string, rev: string): Promise<void>;

	deleteContact(contact: Contact): Promise<DocIdentifier>;

	deleteContacts(contacts: Array<Contact>): Promise<Array<DocIdentifier>>;

	purgeContact(contact: Contact): Promise<void>;

	getServiceCodesOccurrences(codeType: string,
			minOccurrences: number): Promise<Array<LabelledOccurence>>;

	undeleteContactById(id: string, rev: string): Promise<EncryptedContact>;

	undeleteContact(contact: Contact): Promise<EncryptedContact>;

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
