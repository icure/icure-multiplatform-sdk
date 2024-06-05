// auto-generated file
import {FrontEndMigration} from '../model/FrontEndMigration.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface FrontEndMigrationApi {

	getFrontEndMigration(frontEndMigrationId: string): Promise<FrontEndMigration>;

	createFrontEndMigration(frontEndMigration: FrontEndMigration): Promise<FrontEndMigration>;

	getFrontEndMigrations(): Promise<Array<FrontEndMigration>>;

	deleteFrontEndMigration(frontEndMigrationId: string): Promise<DocIdentifier>;

	getFrontEndMigrationByName(frontEndMigrationName: string): Promise<Array<FrontEndMigration>>;

	modifyFrontEndMigration(frontEndMigration: FrontEndMigration): Promise<FrontEndMigration>;

}
