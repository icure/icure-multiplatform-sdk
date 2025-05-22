// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {SortDirection} from '../model/couchdb/SortDirection.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {PatientBasicInGroupApi} from './PatientBasicInGroupApi.mjs';


export interface PatientBasicApi {

	inGroup: PatientBasicInGroupApi;

	matchPatientsBy(filter: BaseFilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): Promise<Array<string>>;

	filterPatientsBy(filter: BaseFilterOptions<Patient>): Promise<PaginatedListIterator<EncryptedPatient>>;

	filterPatientsBySorted(filter: BaseSortableFilterOptions<Patient>): Promise<PaginatedListIterator<EncryptedPatient>>;

	deletePatientUnsafe(entityId: string): Promise<StoredDocumentIdentifier>;

	deletePatientsUnsafe(entityIds: Array<string>): Promise<Array<StoredDocumentIdentifier>>;

	deletePatientById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deletePatientsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatientById(id: string, rev: string): Promise<void>;

	deletePatient(patient: Patient): Promise<StoredDocumentIdentifier>;

	deletePatients(patients: Array<Patient>): Promise<Array<StoredDocumentIdentifier>>;

	purgePatient(patient: Patient): Promise<void>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	countOfPatients(hcPartyId: string): Promise<number>;

	createPatient(patient: EncryptedPatient): Promise<EncryptedPatient>;

	createPatientsMinimal(patients: Array<EncryptedPatient>): Promise<Array<StoredDocumentIdentifier>>;

	createPatients(patients: Array<EncryptedPatient>): Promise<Array<EncryptedPatient>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	modifyPatient(entity: EncryptedPatient): Promise<EncryptedPatient>;

	undeletePatientById(id: string, rev: string): Promise<EncryptedPatient>;

	undeletePatients(ids: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedPatient>>;

	getPatient(entityId: string): Promise<EncryptedPatient | undefined>;

	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<EncryptedPatient>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	listOfMergesAfter(date: number): Promise<Array<EncryptedPatient>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<EncryptedPatient>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<EncryptedPatient>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<EncryptedPatient>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<EncryptedPatient>>;

	getPatients(patientIds: Array<string>): Promise<Array<EncryptedPatient>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<EncryptedPatient>;

	modifyPatientsMinimal(patients: Array<EncryptedPatient>): Promise<Array<StoredDocumentIdentifier>>;

	modifyPatients(patients: Array<EncryptedPatient>): Promise<Array<EncryptedPatient>>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedPatient>>;

	mergePatients(from: Patient, mergedInto: EncryptedPatient): Promise<EncryptedPatient>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
