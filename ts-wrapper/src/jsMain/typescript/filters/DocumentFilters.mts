// auto-generated file
import {BaseSortableFilterOptions, FilterOptions, InternalDocumentFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {Document} from '../model/Document.mjs';
import {Patient} from '../model/Patient.mjs';
import {DocumentType} from '../model/embed/DocumentType.mjs';


interface DocumentFiltersFactory {

	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientSecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	byPatientSecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byPatientsAndTypeForSelf(documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byPatientSecretIdsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	byPatientSecretIdsAndTypeForSelf(documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

}

export const DocumentFilters: DocumentFiltersFactory = {
			byPatientsCreatedForDataOwner: (dataOwnerId, patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForDataOwner(dataOwnerId, patients, options),
			byPatientsCreatedForSelf: (patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForSelf(patients, options),
			byPatientSecretIdsCreatedForDataOwner: (dataOwnerId, secretIds, options) => InternalDocumentFiltersObj.getInstance().byPatientSecretIdsCreatedForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsCreatedForSelf: (secretIds, options) => InternalDocumentFiltersObj.getInstance().byPatientSecretIdsCreatedForSelf(secretIds, options),
			byPatientsAndTypeForDataOwner: (dataOwnerId, documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForDataOwner(dataOwnerId, documentType, patients),
			byPatientsAndTypeForSelf: (documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForSelf(documentType, patients),
			byPatientSecretIdsAndTypeForDataOwner: (dataOwnerId, documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byPatientSecretIdsAndTypeForDataOwner(dataOwnerId, documentType, secretIds),
			byPatientSecretIdsAndTypeForSelf: (documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byPatientSecretIdsAndTypeForSelf(documentType, secretIds)
		};
