// auto-generated file
import {EncryptedForm} from '../../model/Form.mjs';
import {FormTemplate} from '../../model/FormTemplate.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface FormBasicApi {

	deleteForm(entityId: string): Promise<DocIdentifier>;

	deleteForms(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getFormTemplate(formTemplateId: string,
			options?: { raw?: boolean | undefined }): Promise<FormTemplate>;

	getFormTemplatesByGuid(formTemplateGuid: string, specialityCode: string,
			raw: boolean | undefined): Promise<Array<FormTemplate>>;

	listFormTemplatesBySpeciality(specialityCode: string,
			options?: { raw?: boolean | undefined }): Promise<Array<FormTemplate>>;

	getFormTemplates(options?: { loadLayout?: boolean | undefined, raw?: boolean | undefined }): Promise<Array<FormTemplate>>;

	createFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	deleteFormTemplate(formTemplateId: string): Promise<DocIdentifier>;

	updateFormTemplate(formTemplate: FormTemplate): Promise<FormTemplate>;

	setTemplateAttachment(formTemplateId: string, payload: Int8Array): Promise<string>;

	modifyForm(entity: EncryptedForm): Promise<EncryptedForm>;

	modifyForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	getForm(entityId: string): Promise<EncryptedForm>;

	getForms(entityIds: Array<string>): Promise<Array<EncryptedForm>>;

	getLatestFormByLogicalUuid(logicalUuid: string): Promise<EncryptedForm>;

	getLatestFormByUniqueId(uniqueId: string): Promise<EncryptedForm>;

	getFormsByLogicalUuid(logicalUuid: string): Promise<Array<EncryptedForm>>;

	getFormsByUniqueId(uniqueId: string): Promise<Array<EncryptedForm>>;

	getChildrenForms(hcPartyId: string, parentId: string): Promise<Array<EncryptedForm>>;

	listFormsByHCPartyAndPatientForeignKeys(hcPartyId: string, secretFKeys: string,
			options?: { healthElementId?: string | undefined, planOfActionId?: string | undefined, formTemplateId?: string | undefined }): Promise<Array<EncryptedForm>>;

}
