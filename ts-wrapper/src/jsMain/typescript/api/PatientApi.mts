// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {EntityAccessInformation} from '../crypto/entities/EntityAccessInformation.mjs';
import {EntityWithTypeInfo} from '../crypto/entities/EntityWithTypeInfo.mjs';
import {PatientShareOptions} from '../crypto/entities/PatientShareOptions.mjs';
import {ShareAllPatientDataOptions} from '../crypto/entities/ShareAllPatientDataOptions.mjs';
import {IdWithRev} from '../model/IdWithRev.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {SortDirection} from '../model/couchdb/SortDirection.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {PatientFlavouredApi} from './PatientFlavouredApi.mjs';


export interface PatientApi {

	encrypted: PatientFlavouredApi<EncryptedPatient>;

	tryAndRecover: PatientFlavouredApi<Patient>;

	getSecretIdsOf(patient: Patient): Promise<Array<string>>;

	getEncryptionKeysOf(patient: Patient): Promise<Array<HexString>>;

	createPatient(patient: DecryptedPatient): Promise<DecryptedPatient>;

	withEncryptionMetadata(base: DecryptedPatient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel } }): Promise<DecryptedPatient>;

	hasWriteAccess(patient: Patient): Promise<boolean>;

	createDelegationDeAnonymizationMetadata(entity: Patient, delegates: Array<string>): Promise<void>;

	decrypt(patient: EncryptedPatient): Promise<DecryptedPatient>;

	tryDecrypt(patient: EncryptedPatient): Promise<Patient>;

	createPatients(patientDtos: Array<DecryptedPatient>): Promise<Array<IdWithRev>>;

	shareAllDataOfPatient(patientId: string,
			delegatesWithShareType: { [ key: string ]: Array<ShareAllPatientDataOptions.Tag> }): Promise<ShareAllPatientDataOptions.Result>;

	getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfo<any>): Promise<string>;

	getConfidentialSecretIdsOf(patient: Patient): Promise<Array<string>>;

	forceInitializeExchangeDataToNewlyInvitedPatient(patientId: string): Promise<boolean>;

	matchPatientsBy(filter: FilterOptions<Patient>): Promise<Array<string>>;

	matchPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<Array<string>>;

	ensureEncryptionMetadataForSelfIsInitialized(options?: { sharingWith?: { [ key: string ]: AccessLevel } }): Promise<EncryptedPatient>;

	deletePatient(entityId: string): Promise<DocIdentifier>;

	deletePatients(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	undeletePatients(patientIds: Array<string>): Promise<Array<DocIdentifier>>;

	getDataOwnersWithAccessTo(patient: Patient): Promise<EntityAccessInformation>;

	countOfPatients(hcPartyId: string): Promise<number>;

	shareWith(delegateId: string, patient: DecryptedPatient,
			options?: { options?: PatientShareOptions | undefined }): Promise<DecryptedPatient>;

	shareWithMany(patient: DecryptedPatient,
			delegates: { [ key: string ]: PatientShareOptions }): Promise<DecryptedPatient>;

	initializeConfidentialSecretId(patient: DecryptedPatient): Promise<DecryptedPatient>;

	filterPatientsBy(filter: FilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	filterPatientsBySorted(filter: SortableFilterOptions<Patient>): Promise<PaginatedListIterator<DecryptedPatient>>;

	modifyPatient(entity: DecryptedPatient): Promise<DecryptedPatient>;

	getPatient(entityId: string): Promise<DecryptedPatient>;

	getPatientResolvingMerges(patientId: string,
			maxMergeDepth: number | undefined): Promise<DecryptedPatient>;

	findPatientsByNameBirthSsinAuto(filterValue: string,
			options?: { healthcarePartyId?: string | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsOfHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	listOfMergesAfter(date: number): Promise<Array<DecryptedPatient>>;

	findPatientsModifiedAfter(date: number,
			options?: { startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	listPatientsByHcParty(hcPartyId: string,
			options?: { sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsByHealthcareParty(options?: { hcPartyId?: string | undefined, sortField?: string, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, sortDirection?: SortDirection }): Promise<PaginatedList<DecryptedPatient>>;

	findPatientsIdsByHealthcareParty(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<string>>;

	getPatientByExternalId(externalId: string): Promise<DecryptedPatient>;

	fuzzySearch(firstName: string, lastName: string,
			options?: { dateOfBirth?: number | undefined }): Promise<Array<DecryptedPatient>>;

	findDeletedPatients(startDate: number,
			options?: { endDate?: number | undefined, desc?: boolean | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	listDeletedPatientsByName(options?: { firstName?: string | undefined, lastName?: string | undefined }): Promise<Array<DecryptedPatient>>;

	getPatients(patientIds: Array<string>): Promise<Array<DecryptedPatient>>;

	getPatientByHealthcarePartyAndIdentifier(hcPartyId: string, id: string,
			options?: { system?: string | undefined }): Promise<DecryptedPatient>;

	modifyPatients(patientDtos: Array<EncryptedPatient>): Promise<Array<IdWithRev>>;

	findDuplicatesBySsin(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	findDuplicatesByName(hcPartyId: string,
			options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedPatient>>;

	mergePatients(from: Patient, mergedInto: DecryptedPatient): Promise<DecryptedPatient>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Patient>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedPatient>>;

}
