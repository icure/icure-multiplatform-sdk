// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ContactShareOptions} from '../crypto/entities/ContactShareOptions.mjs';
import {Contact} from '../model/Contact.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {Service} from '../model/embed/Service.mjs';


export interface ContactFlavouredApi<E extends Contact, S extends Service> {

	shareWith(delegateId: string, contact: E,
			options?: { options?: ContactShareOptions | undefined }): Promise<E>;

	shareWithMany(contact: E, delegates: { [ key: string ]: ContactShareOptions }): Promise<E>;

	findContactsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	filterContactsBy(filter: FilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

	filterServicesBy(filter: FilterOptions<Service>): Promise<PaginatedListIterator<S>>;

	filterContactsBySorted(filter: SortableFilterOptions<Contact>): Promise<PaginatedListIterator<E>>;

	filterServicesBySorted(filter: SortableFilterOptions<Service>): Promise<PaginatedListIterator<S>>;

	createContact(entity: E): Promise<E>;

	createContacts(entities: Array<E>): Promise<Array<E>>;

	undeleteContactById(id: string, rev: string): Promise<E>;

	undeleteContact(contact: Contact): Promise<E>;

	modifyContact(entity: E): Promise<E>;

	modifyContacts(entities: Array<E>): Promise<Array<E>>;

	getContact(entityId: string): Promise<E | undefined>;

	getContacts(entityIds: Array<string>): Promise<Array<E>>;

	listContactByHCPartyServiceId(hcPartyId: string, serviceId: string): Promise<Array<E>>;

	listContactsByExternalId(externalId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormId(hcPartyId: string, formId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string, formIds: Array<string>): Promise<Array<E>>;

	getService(serviceId: string): Promise<S>;

	getServices(entityIds: Array<string>): Promise<Array<S>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<S>>;

	listServicesByAssociationId(associationId: string): Promise<Array<S>>;

	listServicesByHealthElementId(hcPartyId: string, healthElementId: string): Promise<Array<S>>;

	findContactsByOpeningDate(startDate: number, endDate: number, hcPartyId: string,
			options?: { startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

}
