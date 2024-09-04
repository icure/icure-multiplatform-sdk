// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalGroupFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Group} from '../model/Group.mjs';


interface GroupFiltersFactory {

	all(): BaseFilterOptions<Group>;

	bySuperGroup(superGroupId: string): BaseFilterOptions<Group>;

	withContent(superGroupId: string, searchString: string): BaseSortableFilterOptions<Group>;

}

export const GroupFilters: GroupFiltersFactory = {
			all: () => InternalGroupFiltersObj.getInstance().all(),
			bySuperGroup: (superGroupId) => InternalGroupFiltersObj.getInstance().bySuperGroup(superGroupId),
			withContent: (superGroupId, searchString) => InternalGroupFiltersObj.getInstance().withContent(superGroupId, searchString)
		};
