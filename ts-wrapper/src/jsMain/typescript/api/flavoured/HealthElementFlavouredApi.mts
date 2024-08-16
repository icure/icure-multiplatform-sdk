// auto-generated file
import {HealthElementShareOptions} from '../../crypto/entities/HealthElementShareOptions.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../../icure-sdk-ts.mjs';
import {HealthElement} from '../../model/HealthElement.mjs';
import {Patient} from '../../model/Patient.mjs';


export interface HealthElementFlavouredApi<E extends HealthElement> {

	shareWith(delegateId: string, healthElement: E,
			options?: { options?: HealthElementShareOptions | undefined }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(healthElement: E,
			delegates: { [ key: string ]: HealthElementShareOptions }): Promise<E>;

	findHealthElementsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	filterHealthElementsBy(filter: FilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	filterHealthElementsBySorted(filter: SortableFilterOptions<HealthElement>): Promise<PaginatedListIterator<E>>;

	modifyHealthElement(entity: E): Promise<E>;

	modifyHealthElements(entities: Array<E>): Promise<Array<E>>;

	getHealthElement(entityId: string): Promise<E>;

	getHealthElements(entityIds: Array<string>): Promise<Array<E>>;

	findHealthElementsByHcPartyPatientForeignKeys(hcPartyId: string,
			secretPatientKeys: Array<string>): Promise<Array<E>>;

}
