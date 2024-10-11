// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalCodeFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Code} from '../model/Code.mjs';


interface CodeFiltersFactory {

	all(): BaseFilterOptions<Code>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Code>;

	byQualifiedLink(linkType: string,
			options?: { linkedId?: string | undefined }): BaseFilterOptions<Code>;

	byRegionTypeCodeVersion(region: string,
			options?: { type?: string | undefined, code?: string | undefined, version?: string | undefined }): BaseFilterOptions<Code>;

	byLanguageTypeLabelRegion(language: string, type: string,
			options?: { label?: string | undefined, region?: string | undefined }): BaseFilterOptions<Code>;

	byLanguageTypesLabelRegionVersion(language: string, types: Array<string>, label: string,
			options?: { region?: string | undefined, version?: string | undefined }): BaseFilterOptions<Code>;

}

export const CodeFilters: CodeFiltersFactory = {
			all: () => InternalCodeFiltersObj.getInstance().all(),
			byIds: (ids) => InternalCodeFiltersObj.getInstance().byIds(ids),
			byQualifiedLink: (linkType, options) => InternalCodeFiltersObj.getInstance().byQualifiedLink(linkType, options),
			byRegionTypeCodeVersion: (region, options) => InternalCodeFiltersObj.getInstance().byRegionTypeCodeVersion(region, options),
			byLanguageTypeLabelRegion: (language, type, options) => InternalCodeFiltersObj.getInstance().byLanguageTypeLabelRegion(language, type, options),
			byLanguageTypesLabelRegionVersion: (language, types, label, options) => InternalCodeFiltersObj.getInstance().byLanguageTypesLabelRegionVersion(language, types, label, options)
		};
