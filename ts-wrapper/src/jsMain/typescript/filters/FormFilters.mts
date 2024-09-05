// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalFormFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Form} from '../model/Form.mjs';
import {Patient} from '../model/Patient.mjs';


interface FormFiltersFactory {

	byParentIdForDataOwner(dataOwnerId: string, parentId: string): BaseFilterOptions<Form>;

	byParentIdForSelf(dataOwnerId: string, parentId: string): FilterOptions<Form>;

	byPatientsOpeningDateForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientsOpeningDateForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Form>;

	byPatientSecretIdsOpeningDateForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Form>;

	byLogicalUuid(logicalUuid: string,
			options?: { descending?: boolean }): BaseSortableFilterOptions<Form>;

	byUniqueId(uniqueId: string, options?: { descending?: boolean }): BaseSortableFilterOptions<Form>;

}

export const FormFilters: FormFiltersFactory = {
			byParentIdForDataOwner: (dataOwnerId, parentId) => InternalFormFiltersObj.getInstance().byParentIdForDataOwner(dataOwnerId, parentId),
			byParentIdForSelf: (dataOwnerId, parentId) => InternalFormFiltersObj.getInstance().byParentIdForSelf(dataOwnerId, parentId),
			byPatientsOpeningDateForDataOwner: (dataOwnerId, patients, options) => InternalFormFiltersObj.getInstance().byPatientsOpeningDateForDataOwner(dataOwnerId, patients, options),
			byPatientsOpeningDateForSelf: (patients, options) => InternalFormFiltersObj.getInstance().byPatientsOpeningDateForSelf(patients, options),
			byPatientSecretIdsOpeningDateForDataOwner: (dataOwnerId, secretIds, options) => InternalFormFiltersObj.getInstance().byPatientSecretIdsOpeningDateForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsOpeningDateForSelf: (secretIds, options) => InternalFormFiltersObj.getInstance().byPatientSecretIdsOpeningDateForSelf(secretIds, options),
			byLogicalUuid: (logicalUuid, options) => InternalFormFiltersObj.getInstance().byLogicalUuid(logicalUuid, options),
			byUniqueId: (uniqueId, options) => InternalFormFiltersObj.getInstance().byUniqueId(uniqueId, options)
		};
