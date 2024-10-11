// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalPatientFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';
import {Gender} from '../model/embed/Gender.mjs';


interface PatientFiltersFactory {

	allPatientsForDataOwner(dataOwnerId: string): BaseFilterOptions<Patient>;

	allPatientsForSelf(): FilterOptions<Patient>;

	byIds(ids: Array<string>): SortableFilterOptions<Patient>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Patient>;

	bySsinsForDataOwner(dataOwnerId: string, ssins: Array<string>): BaseSortableFilterOptions<Patient>;

	byDateOfBirthBetweenForDataOwner(dataOwnerId: string, fromDate: number,
			toDate: number): BaseSortableFilterOptions<Patient>;

	byFuzzyNameForDataOwner(dataOwnerId: string, searchString: string): BaseFilterOptions<Patient>;

	byGenderEducationProfessionForDataOwner(dataOwnerId: string, gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byActiveForDataOwner(dataOwnerId: string, active: boolean): BaseFilterOptions<Patient>;

	byTelecomForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForDataOwner(dataOwnerId: string, searchString: string,
			postalCode: string,
			options?: { houseNumber?: string | undefined }): BaseSortableFilterOptions<Patient>;

	byAddressForDataOwner(dataOwnerId: string,
			searchString: string): BaseSortableFilterOptions<Patient>;

	byExternalIdForDataOwner(dataOwnerId: string,
			externalIdPrefix: string): BaseSortableFilterOptions<Patient>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Patient>;

	bySsinsForSelf(ssins: Array<string>): SortableFilterOptions<Patient>;

	byDateOfBirthBetweenForSelf(fromDate: number, toDate: number): SortableFilterOptions<Patient>;

	byNameForSelf(searchString: string): FilterOptions<Patient>;

	byGenderEducationProfessionForSelf(gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): SortableFilterOptions<Patient>;

	byActiveForSelf(active: boolean): FilterOptions<Patient>;

	byTelecomForSelf(searchString: string): SortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForSelf(searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): SortableFilterOptions<Patient>;

	byAddressForSelf(searchString: string): SortableFilterOptions<Patient>;

	byExternalIdForSelf(externalIdPrefix: string): SortableFilterOptions<Patient>;

	byModificationDateForDataOwner(dataOwnerId: string,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Patient>;

	byModificationDateForSelf(options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Patient>;

}

export const PatientFilters: PatientFiltersFactory = {
			allPatientsForDataOwner: (dataOwnerId) => InternalPatientFiltersObj.getInstance().allPatientsForDataOwner(dataOwnerId),
			allPatientsForSelf: () => InternalPatientFiltersObj.getInstance().allPatientsForSelf(),
			byIds: (ids) => InternalPatientFiltersObj.getInstance().byIds(ids),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalPatientFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			bySsinsForDataOwner: (dataOwnerId, ssins) => InternalPatientFiltersObj.getInstance().bySsinsForDataOwner(dataOwnerId, ssins),
			byDateOfBirthBetweenForDataOwner: (dataOwnerId, fromDate, toDate) => InternalPatientFiltersObj.getInstance().byDateOfBirthBetweenForDataOwner(dataOwnerId, fromDate, toDate),
			byFuzzyNameForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byFuzzyNameForDataOwner(dataOwnerId, searchString),
			byGenderEducationProfessionForDataOwner: (dataOwnerId, gender, options) => InternalPatientFiltersObj.getInstance().byGenderEducationProfessionForDataOwner(dataOwnerId, gender, options),
			byActiveForDataOwner: (dataOwnerId, active) => InternalPatientFiltersObj.getInstance().byActiveForDataOwner(dataOwnerId, active),
			byTelecomForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byTelecomForDataOwner(dataOwnerId, searchString),
			byAddressPostalCodeHouseNumberForDataOwner: (dataOwnerId, searchString, postalCode, options) => InternalPatientFiltersObj.getInstance().byAddressPostalCodeHouseNumberForDataOwner(dataOwnerId, searchString, postalCode, options),
			byAddressForDataOwner: (dataOwnerId, searchString) => InternalPatientFiltersObj.getInstance().byAddressForDataOwner(dataOwnerId, searchString),
			byExternalIdForDataOwner: (dataOwnerId, externalIdPrefix) => InternalPatientFiltersObj.getInstance().byExternalIdForDataOwner(dataOwnerId, externalIdPrefix),
			byIdentifiersForSelf: (identifiers) => InternalPatientFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			bySsinsForSelf: (ssins) => InternalPatientFiltersObj.getInstance().bySsinsForSelf(ssins),
			byDateOfBirthBetweenForSelf: (fromDate, toDate) => InternalPatientFiltersObj.getInstance().byDateOfBirthBetweenForSelf(fromDate, toDate),
			byNameForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byNameForSelf(searchString),
			byGenderEducationProfessionForSelf: (gender, options) => InternalPatientFiltersObj.getInstance().byGenderEducationProfessionForSelf(gender, options),
			byActiveForSelf: (active) => InternalPatientFiltersObj.getInstance().byActiveForSelf(active),
			byTelecomForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byTelecomForSelf(searchString),
			byAddressPostalCodeHouseNumberForSelf: (searchString, postalCode, options) => InternalPatientFiltersObj.getInstance().byAddressPostalCodeHouseNumberForSelf(searchString, postalCode, options),
			byAddressForSelf: (searchString) => InternalPatientFiltersObj.getInstance().byAddressForSelf(searchString),
			byExternalIdForSelf: (externalIdPrefix) => InternalPatientFiltersObj.getInstance().byExternalIdForSelf(externalIdPrefix),
			byModificationDateForDataOwner: (dataOwnerId, options) => InternalPatientFiltersObj.getInstance().byModificationDateForDataOwner(dataOwnerId, options),
			byModificationDateForSelf: (options) => InternalPatientFiltersObj.getInstance().byModificationDateForSelf(options)
		};
