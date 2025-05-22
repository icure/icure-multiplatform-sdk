// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {FormShareOptions} from '../crypto/entities/FormShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {DecryptedForm, EncryptedForm, Form} from '../model/Form.mjs';
import {FormTemplate} from '../model/FormTemplate.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {FormFlavouredApi} from './FormFlavouredApi.mjs';


export interface FormApi {

	encrypted: FormFlavouredApi<EncryptedForm>;

	tryAndRecover: FormFlavouredApi<Form>;

	withEncryptionMetadata(base: DecryptedForm | undefined, patient: Patient,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedForm>;

	getEncryptionKeysOf(form: Form): Promise<Array<HexString>>;

	hasWriteAccess(form: Form): Promise<boolean>;

	decryptPatientIdOf(form: Form): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Form, delegates: Array<string>): Promise<void>;

	decrypt(form: EncryptedForm): Promise<DecryptedForm>;

	tryDecrypt(form: EncryptedForm): Promise<Form>;

	matchFormsBy(filter: FilterOptions<Form>): Promise<Array<string>>;

	matchFormsBySorted(filter: SortableFilterOptions<Form>): Promise<Array<string>>;

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

	shareWith(delegateId: string, form: DecryptedForm,
			options?: { options?: FormShareOptions | undefined }): Promise<DecryptedForm>;

	shareWithMany(form: DecryptedForm,
			delegates: { [ key: string ]: FormShareOptions }): Promise<DecryptedForm>;

	findFormsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedForm>>;

	filterFormsBy(filter: FilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	filterFormsBySorted(filter: SortableFilterOptions<Form>): Promise<PaginatedListIterator<DecryptedForm>>;

	createForm(entity: DecryptedForm): Promise<DecryptedForm>;

	createForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	modifyForm(entity: DecryptedForm): Promise<DecryptedForm>;

	undeleteFormById(id: string, rev: string): Promise<DecryptedForm>;

	undeleteForm(form: Form): Promise<DecryptedForm>;

	modifyForms(entities: Array<DecryptedForm>): Promise<Array<DecryptedForm>>;

	getForm(entityId: string): Promise<DecryptedForm | undefined>;

	getForms(entityIds: Array<string>): Promise<Array<DecryptedForm>>;

	getLatestFormByLogicalUuid(logicalUuid: string): Promise<DecryptedForm>;

	getLatestFormByUniqueId(uniqueId: string): Promise<DecryptedForm>;

	getFormsByLogicalUuid(logicalUuid: string): Promise<Array<DecryptedForm>>;

	getFormsByUniqueId(uniqueId: string): Promise<Array<DecryptedForm>>;

	getChildrenForms(hcPartyId: string, parentId: string): Promise<Array<DecryptedForm>>;

}
