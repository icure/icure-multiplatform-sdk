// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {IdWithRev} from '../../model/IdWithRev.mjs';
import {ListOfIds} from '../../model/ListOfIds.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {EncryptedPatient, Patient} from '../../model/Patient.mjs';
import {SortDirection} from '../../model/couchdb/SortDirection.mjs';
import {EncryptedContent} from '../../model/embed/Content.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface PatientFlavouredApi<E extends Patient> {

	shareWith(
			delegateId: string,
			patient: E,
			shareSecretIds: Array<string>,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	initialiseConfidentialSecretId(patient: E): Promise<E>;

	modifyPatient(entity: E): Promise<E>;

	getPatient(entityId: string): Promise<E>;

	filterPatientsBy(
			filterChain: FilterChain<EncryptedPatient>,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			skip: number | undefined,
			sort: string | undefined,
			desc: boolean | undefined
	): Promise<PaginatedList<E>>;

	findPatientsByNameBirthSsinAuto(
			healthcarePartyId: string | undefined,
			filterValue: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<E>>;

	listPatientsOfHcParty(
			hcPartyId: string,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<E>>;

	listOfMergesAfter(date: number): Promise<Array<E>>;

	findPatientsModifiedAfter(date: number, startKey: number | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	listPatientsByHcParty(
			hcPartyId: string,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<E>>;

	getPatientHcPartyKeysForDelegate(patientId: string): Promise<{ [ key: string ]: string }>;

	countOfPatients(hcPartyId: string): Promise<EncryptedContent>;

	findPatientsByHealthcareParty(
			hcPartyId: string | undefined,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<E>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<E>;

	findPatientsByAccessLogUserAfterDate(
			userId: string,
			accessType: string | undefined,
			startDate: number | undefined,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<E>>;

	fuzzySearch(firstName: string, lastName: string,
			dateOfBirth: number | undefined): Promise<Array<E>>;

	findDeletedPatients(
			startDate: number,
			endDate: number | undefined,
			desc: boolean | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<E>>;

	listDeletedPatientsByName(firstName: string | undefined,
			lastName: string | undefined): Promise<Array<E>>;

	getPatients(patientIds: ListOfIds): Promise<Array<E>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			system: string | undefined): Promise<E>;

	modifyPatients(patientDtos: Array<EncryptedPatient>): Promise<Array<IdWithRev>>;

	modifyPatientReferral(patientId: string, referralId: string, start: number | undefined,
			end: number | undefined): Promise<E>;

	findDuplicatesBySsin(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	findDuplicatesByName(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<E>>;

	mergePatients(intoId: string, fromId: string, expectedFromRev: string,
			updatedInto: EncryptedPatient): Promise<E>;

}
