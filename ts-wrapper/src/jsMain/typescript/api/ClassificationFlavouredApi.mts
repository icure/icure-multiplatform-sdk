// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {ClassificationShareOptions} from '../crypto/entities/ClassificationShareOptions.mjs';
import {Classification} from '../model/Classification.mjs';
import {Patient} from '../model/Patient.mjs';


export interface ClassificationFlavouredApi<E extends Classification> {

	shareWith(delegateId: string, classification: E,
			options?: { options?: ClassificationShareOptions | undefined }): Promise<E>;

	shareWithMany(classification: E,
			delegates: { [ key: string ]: ClassificationShareOptions }): Promise<E>;

	findClassificationsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	filterClassificationsBy(filter: FilterOptions<Classification>): Promise<PaginatedListIterator<E>>;

	filterClassificationsBySorted(filter: SortableFilterOptions<Classification>): Promise<PaginatedListIterator<E>>;

	createClassification(entity: E): Promise<E>;

	modifyClassification(entity: E): Promise<E>;

	getClassification(entityId: string): Promise<E | undefined>;

	getClassifications(entityIds: Array<string>): Promise<Array<E>>;

}
