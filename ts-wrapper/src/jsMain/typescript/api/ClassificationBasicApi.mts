// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Classification, EncryptedClassification} from '../model/Classification.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface ClassificationBasicApi {

	matchClassificationsBy(filter: BaseFilterOptions<Classification>): Promise<Array<string>>;

	matchClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): Promise<Array<string>>;

	filterClassificationsBy(filter: BaseFilterOptions<Classification>): Promise<PaginatedListIterator<EncryptedClassification>>;

	filterClassificationsBySorted(filter: BaseSortableFilterOptions<Classification>): Promise<PaginatedListIterator<EncryptedClassification>>;

	deleteClassification(entityId: string): Promise<DocIdentifier>;

	deleteClassifications(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyClassification(entity: EncryptedClassification): Promise<EncryptedClassification>;

	getClassification(entityId: string): Promise<EncryptedClassification>;

	getClassifications(entityIds: Array<string>): Promise<Array<EncryptedClassification>>;

}
