// auto-generated file
import {PatientShareOptions} from '../../crypto/entities/PatientShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {IdWithRev} from '../../model/IdWithRev.mjs';
import {ListOfIds} from '../../model/ListOfIds.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedPatient, Patient} from '../../model/Patient.mjs';
import {SortDirection} from '../../model/couchdb/SortDirection.mjs';
import {EncryptedContent} from '../../model/embed/Content.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface PatientFlavouredApi<E extends Patient> {

	shareWith(delegateId: string, patient: E, shareSecretIds: Array<string>,
			options?: { shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(patient: E,
			delegates: { [ key: string ]: PatientShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(patient: E, delegates: { [ key: string ]: PatientShareOptions }): Promise<E>;

	initialiseConfidentialSecretId(patient: E): Promise<E>;

	modifyPatient(entity: E): Promise<E>;

	getPatient(entityId: string): Promise<E>;

	filterPatientsBy(filterChain: FilterChain<Patient>,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, skip?: number | undefined, sort?: string | undefined, desc?: boolean | undefined }): Promise<PaginatedList<E>>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	listOfMergesAfter(date: number): Promise<Array<E>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	getPatientHcPartyKeysForDelegate(patientId: string): Promise<{ [ key: string ]: string }>;

	countOfPatients(hcPartyId: string): Promise<EncryptedContent>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<E>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<E>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<E>>;

	getPatients(patientIds: ListOfIds): Promise<Array<E>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<E>;

	modifyPatients(patientDtos: Array<EncryptedPatient>): Promise<Array<IdWithRev>>;

	modifyPatientReferral(patientId: string, referralId: string,
			options?: { start?: number | undefined, end?: number | undefined }): Promise<E>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	mergePatients(intoId: string, fromId: string, expectedFromRev: string,
			updatedInto: EncryptedPatient): Promise<E>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Patient>,
			eventFired: (x1: E) => Promise<void>,
			options?: { onConnected?: () => Promise<void>, channelCapacity?: number, retryDelay?: DurationMs, retryDelayExponentFactor?: number, maxRetries?: number }): Promise<Connection>;

}
