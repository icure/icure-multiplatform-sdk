// auto-generated file
import {BaseFilterOptions, InternalMedicalLocationFiltersObj} from '../cardinal-sdk-ts.mjs';
import {MedicalLocation} from '../model/MedicalLocation.mjs';


interface MedicalLocationFiltersFactory {

	all(): BaseFilterOptions<MedicalLocation>;

	byPostCode(postCode: string): BaseFilterOptions<MedicalLocation>;

}

export const MedicalLocationFilters: MedicalLocationFiltersFactory = {
			all: () => InternalMedicalLocationFiltersObj.getInstance().all(),
			byPostCode: (postCode) => InternalMedicalLocationFiltersObj.getInstance().byPostCode(postCode)
		};
