// auto-generated file
import {BaseSortableFilterOptions, InternalClassificationFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Classification} from '../model/Classification.mjs';
import {Patient} from '../model/Patient.mjs';


interface ClassificationFiltersFactory {

	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

	byPatientSecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Classification>;

	byPatientSecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Classification>;

}

export const ClassificationFilters: ClassificationFiltersFactory = {
			byPatientsCreatedForDataOwner: (dataOwnerId, patients, options) => InternalClassificationFiltersObj.getInstance().byPatientsCreatedForDataOwner(dataOwnerId, patients, options),
			byPatientsCreatedForSelf: (patients, options) => InternalClassificationFiltersObj.getInstance().byPatientsCreatedForSelf(patients, options),
			byPatientSecretIdsCreatedForDataOwner: (dataOwnerId, secretIds, options) => InternalClassificationFiltersObj.getInstance().byPatientSecretIdsCreatedForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsCreatedForSelf: (secretIds, options) => InternalClassificationFiltersObj.getInstance().byPatientSecretIdsCreatedForSelf(secretIds, options)
		};
