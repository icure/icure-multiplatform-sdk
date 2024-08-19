// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalCodeFiltersObj} from '../icure-sdk-ts.mjs';
import {Code} from '../model/Code.mjs';


interface CodeFiltersFactory {

	all(): FilterOptions<Code>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Code>;

	byLanguageTypeLabelRegion(language: string, type: string,
			options?: { label?: string | undefined, region?: string | undefined }): BaseFilterOptions<Code>;

}

export const CodeFilters: CodeFiltersFactory = {
			all: () => InternalCodeFiltersObj.getInstance().all(),
			byIds: (ids) => InternalCodeFiltersObj.getInstance().byIds(ids),
			byLanguageTypeLabelRegion: (language, type, options) => InternalCodeFiltersObj.getInstance().byLanguageTypeLabelRegion(language, type, options)
		};
