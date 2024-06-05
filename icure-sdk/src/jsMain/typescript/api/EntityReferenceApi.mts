// auto-generated file
import {EntityReference} from '../model/EntityReference.mjs';


export interface EntityReferenceApi {

	getLatest(prefix: string): Promise<EntityReference>;

	createEntityReference(entityReference: EntityReference): Promise<EntityReference>;

}
