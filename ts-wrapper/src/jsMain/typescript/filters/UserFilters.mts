// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalUserFiltersObj} from '../icure-sdk-ts.mjs';
import {User} from '../model/User.mjs';


interface UserFiltersFactory {

	all(): BaseFilterOptions<User>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<User>;

	byPatientId(patientId: string): BaseFilterOptions<User>;

	byHealthcarePartyId(healthcarePartyId: string): BaseFilterOptions<User>;

	byNameEmailOrPhone(searchString: string): BaseFilterOptions<User>;

}

export const UserFilters: UserFiltersFactory = {
			all: () => InternalUserFiltersObj.getInstance().all(),
			byIds: (ids) => InternalUserFiltersObj.getInstance().byIds(ids),
			byPatientId: (patientId) => InternalUserFiltersObj.getInstance().byPatientId(patientId),
			byHealthcarePartyId: (healthcarePartyId) => InternalUserFiltersObj.getInstance().byHealthcarePartyId(healthcarePartyId),
			byNameEmailOrPhone: (searchString) => InternalUserFiltersObj.getInstance().byNameEmailOrPhone(searchString)
		};
