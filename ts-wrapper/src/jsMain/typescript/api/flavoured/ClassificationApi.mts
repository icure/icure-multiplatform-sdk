// auto-generated file
import {ClassificationShareOptions} from '../../crypto/entities/ClassificationShareOptions.mjs';
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk-ts.mjs';
import {Classification, DecryptedClassification, EncryptedClassification} from '../../model/Classification.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {ClassificationFlavouredApi} from './ClassificationFlavouredApi.mjs';


export interface ClassificationApi {

	encrypted: ClassificationFlavouredApi<EncryptedClassification>;

	tryAndRecover: ClassificationFlavouredApi<Classification>;

	createClassification(entity: DecryptedClassification): Promise<DecryptedClassification>;

	withEncryptionMetadata(base: DecryptedClassification | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedClassification>;

	getEncryptionKeysOf(classification: Classification): Promise<Array<HexString>>;

	hasWriteAccess(classification: Classification): Promise<boolean>;

	decryptPatientIdOf(classification: Classification): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Classification,
			delegates: Array<string>): Promise<void>;

	decrypt(classification: EncryptedClassification): Promise<DecryptedClassification>;

	tryDecrypt(classification: EncryptedClassification): Promise<Classification>;

	deleteClassification(entityId: string): Promise<DocIdentifier>;

	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, classification: DecryptedClassification,
			options?: { options?: ClassificationShareOptions | undefined }): Promise<SimpleShareResult<DecryptedClassification>>;

	tryShareWithMany(classification: DecryptedClassification,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<SimpleShareResult<DecryptedClassification>>;

	shareWithMany(classification: DecryptedClassification,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<DecryptedClassification>;

	findClassificationsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedClassification>>;

	modifyClassification(entity: DecryptedClassification): Promise<DecryptedClassification>;

	getClassification(entityId: string): Promise<DecryptedClassification>;

	getClassifications(entityIds: Array<string>): Promise<Array<DecryptedClassification>>;

}
