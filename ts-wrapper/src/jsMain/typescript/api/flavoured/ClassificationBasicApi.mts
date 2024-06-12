// auto-generated file
import {EncryptedClassification} from '../../model/Classification.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface ClassificationBasicApi {

	deleteClassification(entityId: string): Promise<DocIdentifier>;

	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyClassification(entity: EncryptedClassification): Promise<EncryptedClassification>;

	getClassification(entityId: string): Promise<EncryptedClassification>;

	getClassifications(entityIds: Array<string>): Promise<Array<EncryptedClassification>>;

}
