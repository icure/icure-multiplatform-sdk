// auto-generated file
import {ContactShareOptions} from '../../crypto/entities/ContactShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Contact} from '../../model/Contact.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {Service} from '../../model/embed/Service.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface ContactFlavouredApi<E extends Contact, S extends Service> {

	shareWith(delegateId: string, contact: E,
			options?: { delegateId?: string, contact?: E, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(contact: E,
			delegates: { [ key: string ]: ContactShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(contact: E, delegates: { [ key: string ]: ContactShareOptions }): Promise<E>;

	findContactsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	modifyContact(entity: E): Promise<E>;

	modifyContacts(entities: Array<E>): Promise<Array<E>>;

	getContact(entityId: string): Promise<E>;

	getContacts(entityIds: Array<string>): Promise<Array<E>>;

	filterContactsBy(filterChain: FilterChain<Contact>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<E>>;

	listContactByHCPartyServiceId(hcPartyId: string, serviceId: string): Promise<Array<E>>;

	listContactsByExternalId(externalId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormId(hcPartyId: string, formId: string): Promise<Array<E>>;

	listContactsByHCPartyAndFormIds(hcPartyId: string, formIds: Array<string>): Promise<Array<E>>;

	listContactsByHCPartyAndPatientSecretFKeys(hcPartyId: string, secretPatientKeys: Array<string>,
			options?: { hcPartyId?: string, secretPatientKeys?: Array<string>, planOfActionsIds?: string | undefined, skipClosedContacts?: boolean | undefined }): Promise<Array<E>>;

	closeForHCPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

	getService(serviceId: string): Promise<S>;

	getServices(entityIds: Array<string>): Promise<Array<S>>;

	getServicesLinkedTo(linkType: string, ids: Array<string>): Promise<Array<S>>;

	listServicesByAssociationId(associationId: string): Promise<Array<S>>;

	listServicesByHealthElementId(hcPartyId: string, healthElementId: string): Promise<Array<S>>;

	findContactsByOpeningDate(startDate: number, endDate: number, hcPartyId: string,
			options?: { startDate?: number, endDate?: number, hcPartyId?: string, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	filterServicesBy(filterChain: FilterChain<Service>, startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<S>>;

	subscribeToServiceEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Service>,
			eventFired: (x1: S) => Promise<void>,
			options?: { events?: Array<SubscriptionEventType>, filter?: AbstractFilter<Service>, onConnected?: () => Promise<void>, channelCapacity?: number, retryDelay?: DurationMs, retryDelayExponentFactor?: number, maxRetries?: number, eventFired?: (x1: S) => Promise<void> }): Promise<Connection>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Contact>,
			eventFired: (x1: E) => Promise<void>,
			options?: { events?: Array<SubscriptionEventType>, filter?: AbstractFilter<Contact>, onConnected?: () => Promise<void>, channelCapacity?: number, retryDelay?: DurationMs, retryDelayExponentFactor?: number, maxRetries?: number, eventFired?: (x1: E) => Promise<void> }): Promise<Connection>;

}
