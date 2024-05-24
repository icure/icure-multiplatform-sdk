// auto-generated file
import {EntityAccessInformation} from '../../crypto/entities/EntityAccessInformation.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {DataOwnerRegistrationSuccess} from '../../model/DataOwnerRegistrationSuccess.mjs';
import {IdWithRev} from '../../model/IdWithRev.mjs';
import {DecryptedPatient, EncryptedPatient, Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
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

}
