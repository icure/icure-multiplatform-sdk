// auto-generated file
import {ClassificationShareOptions} from '../../crypto/entities/ClassificationShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Classification} from '../../model/Classification.mjs';
import {Patient} from '../../model/Patient.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface ClassificationFlavouredApi<E extends Classification> {

	shareWith(delegateId: string, classification: E,
			options?: { delegateId?: string, classification?: E, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(classification: E,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(classification: E,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<E>;

	findClassificationsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	modifyClassification(entity: E): Promise<E>;

	getClassification(entityId: string): Promise<E>;

	getClassifications(entityIds: Array<string>): Promise<Array<E>>;

}
