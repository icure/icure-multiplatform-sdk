// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Classification, DecryptedClassification, EncryptedClassification} from '../../model/Classification.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {ClassificationFlavouredApi} from './ClassificationFlavouredApi.mjs';


export interface ClassificationApi {

	encrypted: ClassificationFlavouredApi<EncryptedClassification>;

	tryAndRecover: ClassificationFlavouredApi<Classification>;

	createClassification(entity: DecryptedClassification): Promise<DecryptedClassification>;

	withEncryptionMetadata(
			base: DecryptedClassification | undefined,
			patient: Patient,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedClassification>;

	deleteClassification(entityId: string): Promise<DocIdentifier>;

	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			classification: DecryptedClassification,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedClassification>>;

	findClassificationsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedClassification>>;

}
