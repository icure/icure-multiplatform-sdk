// auto-generated file
import {Contact, EncryptedContact} from '../../model/Contact.mjs';
import {IcureStub} from '../../model/IcureStub.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {LabelledOccurence} from '../../model/data/LabelledOccurence.mjs';
import {EncryptedService, Service} from '../../model/embed/Service.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';


export interface ContactBasicApi {

	matchContactsBy(filter: AbstractFilter<Contact>): Promise<Array<string>>;

	matchServicesBy(filter: AbstractFilter<Service>): Promise<Array<string>>;

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

	filterContactsBy(filterChain: FilterChain<Contact>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedContact>>;

	listContactByHCPartyServiceId(hcPartyId: string,
			serviceId: string): Promise<Array<EncryptedContact>>;

	listContactsByExternalId(externalId: string): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndFormId(hcPartyId: string,
			formId: string): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string,
			formIds: Array<string>): Promise<Array<EncryptedContact>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			planOfActionsIds: string | undefined,
			skipClosedContacts: boolean | undefined): Promise<Array<EncryptedContact>>;

	closeForHCPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<EncryptedContact>>;

	getService(serviceId: string): Promise<EncryptedService>;

	getServices(entityIds: Array<string>): Promise<Array<EncryptedService>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<EncryptedService>>;

	listServicesByAssociationId(associationId: string): Promise<Array<EncryptedService>>;

	listServicesByHealthElementId(hcPartyId: string,
			healthElementId: string): Promise<Array<EncryptedService>>;

	findContactsByOpeningDate(
			startDate: number,
			endDate: number,
			hcPartyId: string,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<EncryptedContact>>;

	filterServicesBy(filterChain: FilterChain<Service>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<EncryptedService>>;

}
