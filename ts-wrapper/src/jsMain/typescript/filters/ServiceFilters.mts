// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalServiceFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {LinkQualification} from '../model/base/LinkQualification.mjs';
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

	byHealthElementIdFromSubContactForDataOwner(dataOwnerId: string,
			healthElementIds: Array<string>): BaseSortableFilterOptions<Service>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Service>;

	byCodeAndValueDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byTagAndValueDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfServiceValueDate?: number | undefined, endOfServiceValueDate?: number | undefined }): SortableFilterOptions<Service>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Service>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Service>;

	byHealthElementIdFromSubContactForSelf(healthElementIds: Array<string>): SortableFilterOptions<Service>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Service>;

	byAssociationId(associationId: string): BaseFilterOptions<Service>;

	byQualifiedLink(linkValues: Array<string>,
			options?: { linkQualification?: LinkQualification | undefined }): BaseFilterOptions<Service>;

}

export const ServiceFilters: ServiceFiltersFactory = {
			allServicesForDataOwner: (dataOwnerId) => InternalServiceFiltersObj.getInstance().allServicesForDataOwner(dataOwnerId),
			allServicesForSelf: () => InternalServiceFiltersObj.getInstance().allServicesForSelf(),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalServiceFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byCodeAndValueDateForDataOwner: (dataOwnerId, codeType, options) => InternalServiceFiltersObj.getInstance().byCodeAndValueDateForDataOwner(dataOwnerId, codeType, options),
			byTagAndValueDateForDataOwner: (dataOwnerId, tagType, options) => InternalServiceFiltersObj.getInstance().byTagAndValueDateForDataOwner(dataOwnerId, tagType, options),
			byPatientsForDataOwner: (dataOwnerId, patients) => InternalServiceFiltersObj.getInstance().byPatientsForDataOwner(dataOwnerId, patients),
			byPatientsSecretIdsForDataOwner: (dataOwnerId, secretIds) => InternalServiceFiltersObj.getInstance().byPatientsSecretIdsForDataOwner(dataOwnerId, secretIds),
			byHealthElementIdFromSubContactForDataOwner: (dataOwnerId, healthElementIds) => InternalServiceFiltersObj.getInstance().byHealthElementIdFromSubContactForDataOwner(dataOwnerId, healthElementIds),
			byIdentifiersForSelf: (identifiers) => InternalServiceFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byCodeAndValueDateForSelf: (codeType, options) => InternalServiceFiltersObj.getInstance().byCodeAndValueDateForSelf(codeType, options),
			byTagAndValueDateForSelf: (tagType, options) => InternalServiceFiltersObj.getInstance().byTagAndValueDateForSelf(tagType, options),
			byPatientsForSelf: (patients) => InternalServiceFiltersObj.getInstance().byPatientsForSelf(patients),
			byPatientsSecretIdsForSelf: (secretIds) => InternalServiceFiltersObj.getInstance().byPatientsSecretIdsForSelf(secretIds),
			byHealthElementIdFromSubContactForSelf: (healthElementIds) => InternalServiceFiltersObj.getInstance().byHealthElementIdFromSubContactForSelf(healthElementIds),
			byIds: (ids) => InternalServiceFiltersObj.getInstance().byIds(ids),
			byAssociationId: (associationId) => InternalServiceFiltersObj.getInstance().byAssociationId(associationId),
			byQualifiedLink: (linkValues, options) => InternalServiceFiltersObj.getInstance().byQualifiedLink(linkValues, options)
		};
