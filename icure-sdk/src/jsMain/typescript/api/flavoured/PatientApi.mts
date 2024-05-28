// auto-generated file
import {EntityAccessInformation} from '../../crypto/entities/EntityAccessInformation.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {DataOwnerRegistrationSuccess} from '../../model/DataOwnerRegistrationSuccess.mjs';
import {IdWithRev} from '../../model/IdWithRev.mjs';
import {ListOfIds} from '../../model/ListOfIds.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {SortDirection} from '../../model/couchdb/SortDirection.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {EncryptedContent} from '../../model/embed/Content.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {PatientFlavouredApi} from './PatientFlavouredApi.mjs';


export interface PatientApi {

	encrypted: PatientFlavouredApi<EncryptedPatient>;

	tryAndRecover: PatientFlavouredApi<Patient>;

	getSecretIdsOf(patient: Patient): Promise<Array<string>>;

	getEncryptionKeysOf(patient: Patient): Promise<Array<HexString>>;

	createPatient(patient: DecryptedPatient): Promise<DecryptedPatient>;

	withEncryptionMetadata(base: DecryptedPatient | undefined, user: User | undefined,
			delegates: { [ key: string ]: AccessLevel }): Promise<DecryptedPatient>;

	createDelegationsDeAnonymizationMetadata(patient: Patient,
			dataOwnerIds: Array<string>): Promise<void>;

	createPatients(patientDtos: Array<DecryptedPatient>): Promise<Array<IdWithRev>>;

	registerPatient(
			hcPartyId: string,
			groupId: string,
			token: string | undefined,
			useShortToken: boolean | undefined,
			createAutoDelegation: boolean,
			patient: DecryptedPatient
	): Promise<DataOwnerRegistrationSuccess>;

	getConfidentialSecretIdsOf(patient: Patient): Promise<Array<string>>;

	forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: string): Promise<boolean>;

	matchPatientsBy(filter: AbstractFilter<EncryptedPatient>): Promise<Array<string>>;

	deletePatient(entityId: string): Promise<DocIdentifier>;

	deletePatients(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	undeletePatient(patientIds: string): Promise<Array<DocIdentifier>>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	shareWith(
			delegateId: string,
			patient: DecryptedPatient,
			shareSecretIds: Array<string>,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedPatient>>;

	initialiseConfidentialSecretId(patient: DecryptedPatient): Promise<DecryptedPatient>;

	modifyPatient(entity: DecryptedPatient): Promise<DecryptedPatient>;

	getPatient(entityId: string): Promise<DecryptedPatient>;

	filterPatientsBy(
			filterChain: FilterChain<EncryptedPatient>,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			skip: number | undefined,
			sort: string | undefined,
			desc: boolean | undefined
	): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsByNameBirthSsinAuto(
			healthcarePartyId: string | undefined,
			filterValue: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsOfHcParty(
			hcPartyId: string,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<DecryptedPatient>>;

	listOfMergesAfter(date: number): Promise<Array<DecryptedPatient>>;

	findPatientsModifiedAfter(date: number, startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsByHcParty(
			hcPartyId: string,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<DecryptedPatient>>;

	getPatientHcPartyKeysForDelegate(patientId: string): Promise<{ [ key: string ]: string }>;

	countOfPatients(hcPartyId: string): Promise<EncryptedContent>;

	findPatientsByHealthcareParty(
			hcPartyId: string | undefined,
			sortField: string,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			sortDirection: SortDirection
	): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number | undefined): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<DecryptedPatient>;

	findPatientsByAccessLogUserAfterDate(
			userId: string,
			accessType: string | undefined,
			startDate: number | undefined,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<DecryptedPatient>>;

	fuzzySearch(firstName: string, lastName: string,
			dateOfBirth: number | undefined): Promise<Array<DecryptedPatient>>;

	findDeletedPatients(
			startDate: number,
			endDate: number | undefined,
			desc: boolean | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<DecryptedPatient>>;

	listDeletedPatientsByName(firstName: string | undefined,
			lastName: string | undefined): Promise<Array<DecryptedPatient>>;

	getPatients(patientIds: ListOfIds): Promise<Array<DecryptedPatient>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			system: string | undefined): Promise<DecryptedPatient>;

	modifyPatients(patientDtos: Array<EncryptedPatient>): Promise<Array<IdWithRev>>;

	modifyPatientReferral(patientId: string, referralId: string, start: number | undefined,
			end: number | undefined): Promise<DecryptedPatient>;

	findDuplicatesBySsin(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedPatient>>;

	findDuplicatesByName(hcPartyId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<DecryptedPatient>>;

	mergePatients(intoId: string, fromId: string, expectedFromRev: string,
			updatedInto: EncryptedPatient): Promise<DecryptedPatient>;

}
