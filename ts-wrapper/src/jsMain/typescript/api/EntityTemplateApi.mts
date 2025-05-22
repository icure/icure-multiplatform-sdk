// auto-generated file
import {EntityTemplate} from '../model/EntityTemplate.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface EntityTemplateApi {

	getEntityTemplate(documentTemplateId: string): Promise<EntityTemplate | undefined>;

	createEntityTemplate(applicationSettings: EntityTemplate): Promise<EntityTemplate>;

	modifyEntityTemplate(documentTemplate: EntityTemplate): Promise<EntityTemplate>;

	listEntityTemplatesBy(userId: string, type: string,
			options?: { searchString?: string | undefined, includeEntities?: boolean | undefined }): Promise<Array<EntityTemplate>>;

	listAllEntityTemplatesBy(type: string,
			options?: { searchString?: string | undefined, includeEntities?: boolean | undefined }): Promise<Array<EntityTemplate>>;

	listEntityTemplatesByKeyword(userId: string, type: string, keyword: string,
			options?: { includeEntities?: boolean | undefined }): Promise<Array<EntityTemplate>>;

	findAllEntityTemplatesByKeyword(type: string, keyword: string,
			includeEntities: boolean | undefined): Promise<Array<EntityTemplate>>;

	getEntityTemplates(entityTemplateIds: Array<string>): Promise<Array<EntityTemplate>>;

	modifyEntityTemplates(entityTemplates: Array<EntityTemplate>): Promise<Array<EntityTemplate>>;

	createEntityTemplates(entityTemplates: Array<EntityTemplate>): Promise<Array<EntityTemplate>>;

	deleteEntityTemplates(entityTemplateIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

}
