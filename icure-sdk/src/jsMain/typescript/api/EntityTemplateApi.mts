// auto-generated file
import {EntityTemplate} from '../model/EntityTemplate.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface EntityTemplateApi {

	getEntityTemplate(documentTemplateId: string): Promise<EntityTemplate>;

	createEntityTemplate(applicationSettings: EntityTemplate): Promise<EntityTemplate>;

	modifyEntityTemplate(documentTemplate: EntityTemplate): Promise<EntityTemplate>;

	listEntityTemplatesBy(userId: string, type: string, searchString: string | undefined,
			includeEntities: boolean | undefined): Promise<Array<EntityTemplate>>;

	listAllEntityTemplatesBy(type: string, searchString: string | undefined,
			includeEntities: boolean | undefined): Promise<Array<EntityTemplate>>;

	listEntityTemplatesByKeyword(userId: string, type: string, keyword: string,
			includeEntities: boolean | undefined): Promise<Array<EntityTemplate>>;

	findAllEntityTemplatesByKeyword(type: string, keyword: string,
			includeEntities: boolean | undefined): Promise<Array<EntityTemplate>>;

	getEntityTemplates(entityTemplateIds: Array<string>): Promise<Array<EntityTemplate>>;

	modifyEntityTemplates(entityTemplates: Array<EntityTemplate>): Promise<Array<EntityTemplate>>;

	createEntityTemplates(entityTemplates: Array<EntityTemplate>): Promise<Array<EntityTemplate>>;

	deleteEntityTemplate(entityTemplateIds: Array<string>): Promise<Array<DocIdentifier>>;

}
