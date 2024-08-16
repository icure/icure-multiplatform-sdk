// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalPatientFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
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

	byFuzzyNameForSelf(searchString: string): FilterOptions<Patient>;

	byGenderEducationProfessionForSelf(gender: Gender,
			options?: { education?: string | undefined, profession?: string | undefined }): SortableFilterOptions<Patient>;

	byActiveForSelf(active: boolean): FilterOptions<Patient>;

	byTelecomForSelf(searchString: string): SortableFilterOptions<Patient>;

	byAddressPostalCodeHouseNumberForSelf(searchString: string, postalCode: string,
			options?: { houseNumber?: string | undefined }): SortableFilterOptions<Patient>;

	byAddressForSelf(searchString: string): SortableFilterOptions<Patient>;

	byExternalIdForSelf(externalIdPrefix: string): SortableFilterOptions<Patient>;

}

const PatientFilters: PatientFiltersFactory = InternalPatientFiltersObj.getInstance();
