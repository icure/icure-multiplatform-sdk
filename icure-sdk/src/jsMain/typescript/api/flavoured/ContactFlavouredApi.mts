// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Contact, EncryptedContact} from '../../model/Contact.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {EncryptedService, Service} from '../../model/embed/Service.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface ContactFlavouredApi<E extends Contact, S extends Service> {

	shareWith(
			delegateId: string,
			contact: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	findContactsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<E>>;

	modifyContact(entity: E): Promise<E>;

	modifyContacts(entities: Array<E>): Promise<Array<E>>;

	getContact(entityId: string): Promise<E>;

	getContacts(entityIds: Array<string>): Promise<Array<E>>;

	filterContactsBy(filterChain: FilterChain<EncryptedContact>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<E>>;

	listContactByHCPartyServiceId(hcPartyId: string, serviceId: string): Promise<Array<E>>;

	listContactsByExternalId(externalId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormId(hcPartyId: string, formId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string, formIds: Array<string>): Promise<Array<E>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			planOfActionsIds: string | undefined,
			skipClosedContacts: boolean | undefined): Promise<Array<E>>;

	closeForHCPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

	getService(serviceId: string): Promise<S>;

	getServices(entityIds: Array<string>): Promise<Array<S>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<S>>;

	listServicesByAssociationId(associationId: string): Promise<Array<S>>;

	listServicesByHealthElementId(hcPartyId: string, healthElementId: string): Promise<Array<S>>;

	findContactsByOpeningDate(
			startDate: number,
			endDate: number,
			hcPartyId: string,
			startKey: any | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<E>>;

	filterServicesBy(filterChain: FilterChain<EncryptedService>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<S>>;

}