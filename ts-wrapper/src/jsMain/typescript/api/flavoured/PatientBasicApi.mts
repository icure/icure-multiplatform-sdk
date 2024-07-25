// auto-generated file
import {EntityAccessInformation} from '../../crypto/entities/EntityAccessInformation.mjs';
import {IdWithRev} from '../../model/IdWithRev.mjs';
import {ListOfIds} from '../../model/ListOfIds.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedPatient, Patient} from '../../model/Patient.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {SortDirection} from '../../model/couchdb/SortDirection.mjs';
import {EncryptedContent} from '../../model/embed/Content.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {EntitySubscription} from '../../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../../subscription/EntitySubscriptionConfiguration.mjs';


export interface PatientBasicApi {

	matchPatientsBy(filter: AbstractFilter<Patient>): Promise<Array<string>>;

	deletePatient(entityId: string): Promise<DocIdentifier>;

	deletePatients(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	undeletePatient(patientIds: string): Promise<Array<DocIdentifier>>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

	modifyPatient(entity: EncryptedPatient): Promise<EncryptedPatient>;

	getPatient(entityId: string): Promise<EncryptedPatient>;

	filterPatientsBy(filterChain: FilterChain<Patient>,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, skip?: number | undefined, sort?: string | undefined, desc?: boolean | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	listOfMergesAfter(date: number): Promise<Array<EncryptedPatient>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	getPatientHcPartyKeysForDelegate(patientId: string): Promise<{ [ key: string ]: string }>;

	countOfPatients(hcPartyId: string): Promise<EncryptedContent>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<EncryptedPatient>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<EncryptedPatient>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<EncryptedPatient>>;

	getPatients(patientIds: ListOfIds): Promise<Array<EncryptedPatient>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<EncryptedPatient>;

	modifyPatients(patientDtos: Array<EncryptedPatient>): Promise<Array<IdWithRev>>;

	modifyPatientReferral(patientId: string, referralId: string,
			options?: { start?: number | undefined, end?: number | undefined }): Promise<EncryptedPatient>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	mergePatients(intoId: string, fromId: string, expectedFromRev: string,
			updatedInto: EncryptedPatient): Promise<EncryptedPatient>;

}
