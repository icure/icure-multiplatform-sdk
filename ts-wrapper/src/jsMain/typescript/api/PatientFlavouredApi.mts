// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {SortDirection} from '../model/couchdb/SortDirection.mjs';


export interface PatientFlavouredApi<E extends Patient> {

	shareWith(delegateId: string, patient: E,
			options?: { options?: PatientShareOptions | undefined }): Promise<E>;

	shareWithMany(patient: E, delegates: { [ key: string ]: PatientShareOptions }): Promise<E>;

	initializeConfidentialSecretId(patient: E): Promise<E>;

	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<E>>;

	createPatient(patient: E): Promise<E>;

	createPatientsMinimal(patients: Array<E>): Promise<Array<StoredDocumentIdentifier>>;

	createPatients(patients: Array<E>): Promise<Array<E>>;

	undeletePatient(patient: Patient): Promise<Patient>;

	modifyPatient(entity: E): Promise<E>;

	undeletePatientById(id: string, rev: string): Promise<E>;

	undeletePatients(ids: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	getPatient(entityId: string): Promise<E | undefined>;

	getPatientResolvingMerges(patientId: string, maxMergeDepth: number | undefined): Promise<E>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	listOfMergesAfter(date: number): Promise<Array<E>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<E>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<E>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<E>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<E>>;

	getPatients(patientIds: Array<string>): Promise<Array<E>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<E>;

	modifyPatientsMinimal(patients: Array<E>): Promise<Array<StoredDocumentIdentifier>>;

	modifyPatients(patients: Array<E>): Promise<Array<E>>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	mergePatients(from: Patient, mergedInto: E): Promise<E>;

}
