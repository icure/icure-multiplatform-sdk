// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalContactFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {Contact} from '../model/Contact.mjs';
import {Patient} from '../model/Patient.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface ContactFiltersFactory {

	allContactsForDataOwner(dataOwnerId: string): BaseFilterOptions<Contact>;

	allContactsForSelf(): FilterOptions<Contact>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<Contact>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<Contact>;

	byCodeAndOpeningDateForDataOwner(dataOwnerId: string, codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byCodeAndOpeningDateForSelf(codeType: string,
			options?: { codeCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	byTagAndOpeningDateForDataOwner(dataOwnerId: string, tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): BaseSortableFilterOptions<Contact>;

	byTagAndOpeningDateForSelf(tagType: string,
			options?: { tagCode?: string | undefined, startOfContactOpeningDate?: number | undefined, endOfContactOpeningDate?: number | undefined }): SortableFilterOptions<Contact>;

	byPatientsForDataOwner(dataOwnerId: string,
			patients: Array<Patient>): SortableFilterOptions<Contact>;

	byPatientsForSelf(patients: Array<Patient>): SortableFilterOptions<Contact>;

	byPatientsSecretIdsForDataOwner(dataOwnerId: string,
			secretIds: Array<string>): BaseSortableFilterOptions<Contact>;

	byPatientsSecretIdsForSelf(secretIds: Array<string>): SortableFilterOptions<Contact>;

	byServiceIds(serviceIds: Array<string>): BaseSortableFilterOptions<Contact>;

}

const ContactFilters: ContactFiltersFactory = InternalContactFiltersObj.getInstance();
