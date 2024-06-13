// auto-generated file
import {FormShareOptions} from '../../crypto/entities/FormShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk-ts.mjs';
import {Form} from '../../model/Form.mjs';
import {Patient} from '../../model/Patient.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface FormFlavouredApi<E extends Form> {

	shareWith(delegateId: string, form: E,
			options?: { shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(form: E,
			delegates: { [ key: string ]: FormShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(form: E, delegates: { [ key: string ]: FormShareOptions }): Promise<E>;

	findFormsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	modifyForm(entity: E): Promise<E>;

	modifyForms(entities: Array<E>): Promise<Array<E>>;

	getForm(entityId: string): Promise<E>;

	getForms(entityIds: Array<string>): Promise<Array<E>>;

	getFormByLogicalUuid(logicalUuid: string): Promise<E>;

	getFormsByLogicalUuid(logicalUuid: string): Promise<Array<E>>;

	getFormsByUniqueId(uniqueId: string): Promise<Array<E>>;

	getFormByUniqueId(uniqueId: string): Promise<E>;

	getChildrenForms(hcPartyId: string, parentId: string): Promise<Array<E>>;

	listFormsByHCPartyAndPatientForeignKeys(hcPartyId: string, secretFKeys: string,
			options?: { healthElementId?: string | undefined, planOfActionId?: string | undefined, formTemplateId?: string | undefined }): Promise<Array<E>>;

}
