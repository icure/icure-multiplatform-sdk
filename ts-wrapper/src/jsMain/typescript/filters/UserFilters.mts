// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalUserFiltersObj} from '../icure-sdk-ts.mjs';
import {User} from '../model/User.mjs';


interface UserFiltersFactory {

	all(): BaseFilterOptions<User>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<User>;

	byPatientId(patientId: string): BaseFilterOptions<User>;

	byNameEmailOrPhone(searchString: string): BaseFilterOptions<User>;

}

const UserFilters: UserFiltersFactory = InternalUserFiltersObj.getInstance();
