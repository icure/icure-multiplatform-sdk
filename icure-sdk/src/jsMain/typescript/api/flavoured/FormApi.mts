// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {DecryptedForm, EncryptedForm, Form} from '../../model/Form.mjs';
import {FormTemplate} from '../../model/FormTemplate.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {FormFlavouredApi} from './FormFlavouredApi.mjs';


export interface FormApi {

	encrypted: FormFlavouredApi<EncryptedForm>;

	tryAndRecover: FormFlavouredApi<Form>;

	createForm(entity: DecryptedForm): Promise<DecryptedForm>;

	createForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	withEncryptionMetadata(
			base: DecryptedForm | undefined,
			patient: Patient,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedForm>;

	deleteForm(entityId: string): Promise<DocIdentifier>;

	deleteForms(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getFormTemplate(formTemplateId: string, raw: boolean | undefined): Promise<FormTemplate>;

	getFormTemplatesByGuid(formTemplateGuid: string, specialityCode: string,
			raw: boolean | undefined): Promise<Array<FormTemplate>>;

	listFormTemplatesBySpeciality(specialityCode: string,
			raw: boolean | undefined): Promise<Array<FormTemplate>>;

	getFormTemplates(loadLayout: boolean | undefined,
			raw: boolean | undefined): Promise<Array<FormTemplate>>;

	createFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	deleteFormTemplate(formTemplateId: string): Promise<DocIdentifier>;

	updateFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	setTemplateAttachment(formTemplateId: string, payload: Int8Array): Promise<string>;

	shareWith(
			delegateId: string,
			form: DecryptedForm,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedForm>>;

	findFormsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedForm>>;

	modifyForm(entity: DecryptedForm): Promise<DecryptedForm>;

	modifyForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	getForm(entityId: string): Promise<DecryptedForm>;

	getForms(entityIds: Array<string>): Promise<Array<DecryptedForm>>;

	getFormByLogicalUuid(logicalUuid: string): Promise<DecryptedForm>;

	getFormsByLogicalUuid(logicalUuid: string): Promise<Array<DecryptedForm>>;

	getFormsByUniqueId(uniqueId: string): Promise<Array<DecryptedForm>>;

	getFormByUniqueId(uniqueId: string): Promise<DecryptedForm>;

	getChildrenForms(hcPartyId: string, parentId: string): Promise<Array<DecryptedForm>>;

	listFormsByHCPartyAndPatientForeignKeys(
			hcPartyId: string,
			secretFKeys: string,
			healthElementId: string | undefined,
			planOfActionId: string | undefined,
			formTemplateId: string | undefined
	): Promise<Array<DecryptedForm>>;

}
