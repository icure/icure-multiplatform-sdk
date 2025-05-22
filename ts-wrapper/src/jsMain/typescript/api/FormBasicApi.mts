// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface FormBasicApi {

	matchFormsBy(filter: BaseFilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<Array<string>>;

	filterFormsBy(filter: BaseFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

	filterFormsBySorted(filter: BaseSortableFilterOptions<Form>): Promise<PaginatedListIterator<EncryptedForm>>;

	deleteFormUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteFormsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteFormById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteFormsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	purgeFormById(id: string, rev: string): Promise<void>;

	deleteForm(form: Form): Promise<DocIdentifier>;

	deleteForms(forms: Array<Form>): Promise<Array<DocIdentifier>>;

	purgeForm(form: Form): Promise<void>;

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

	createForm(entity: EncryptedForm): Promise<EncryptedForm>;

	createForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	modifyForm(entity: EncryptedForm): Promise<EncryptedForm>;

	undeleteFormById(id: string, rev: string): Promise<EncryptedForm>;

	undeleteForm(form: Form): Promise<EncryptedForm>;

	modifyForms(entities: Array<EncryptedForm>): Promise<Array<EncryptedForm>>;

	getForm(entityId: string): Promise<EncryptedForm | undefined>;

	getForms(entityIds: Array<string>): Promise<Array<EncryptedForm>>;

	getLatestFormByLogicalUuid(logicalUuid: string): Promise<EncryptedForm>;

	getLatestFormByUniqueId(uniqueId: string): Promise<EncryptedForm>;

	getFormsByLogicalUuid(logicalUuid: string): Promise<Array<EncryptedForm>>;

	getFormsByUniqueId(uniqueId: string): Promise<Array<EncryptedForm>>;

	getChildrenForms(hcPartyId: string, parentId: string): Promise<Array<EncryptedForm>>;

}
