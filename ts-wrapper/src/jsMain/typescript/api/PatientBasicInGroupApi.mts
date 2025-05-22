// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedPatient, Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface PatientBasicInGroupApi {

	matchPatientsBy(groupId: string, filter: BaseFilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<Array<string>>;

	filterPatientsBy(groupId: string,
			filter: BaseFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

	filterPatientsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Patient>): Promise<PaginatedListIterator<GroupScoped<EncryptedPatient>>>;

	getDataOwnersWithAccessTo(patient: GroupScoped<Patient>): Promise<EntityAccessInformation>;

	createPatient(patient: GroupScoped<EncryptedPatient>): Promise<GroupScoped<EncryptedPatient>>;

	createPatientsMinimal(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	getPatient(groupId: string, entityId: string): Promise<GroupScoped<EncryptedPatient> | undefined>;

	getPatientResolvingMerges(groupId: string, patientId: string,
			maxMergeDepth: number | undefined): Promise<GroupScoped<EncryptedPatient>>;

	getPatients(groupId: string,
			patientIds: Array<string>): Promise<Array<GroupScoped<EncryptedPatient>>>;

	modifyPatientsMinimal(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	modifyPatients(patients: Array<GroupScoped<EncryptedPatient>>): Promise<Array<GroupScoped<EncryptedPatient>>>;

}
