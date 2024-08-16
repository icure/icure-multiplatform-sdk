// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalServiceFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {Service} from '../model/embed/Service.mjs';


interface ServiceFiltersFactory {

	allServicesForDataOwner(dataOwnerId: string): BaseFilterOptions<Service>;

	allServicesForSelf(): FilterOptions<Service>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Service>;

	byCodeAndValueDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byTagAndValueDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): BaseSortableFilterOptions<Service>;

	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Service>;

	byHealthElementIdFromSubcontactForDataOwner(dataOwnerId: string,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Service>;

	byCodeAndValueDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byTagAndValueDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Service>;

	byHealthElementIdFromSubcontactForSelf(healthElementIds: Array<string>): SortableFilterOptions<Service>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Service>;

}

const ServiceFilters: ServiceFiltersFactory = InternalServiceFiltersObj.getInstance();
