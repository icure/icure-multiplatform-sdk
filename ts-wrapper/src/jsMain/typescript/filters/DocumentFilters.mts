// auto-generated file
import {BaseSortableFilterOptions, FilterOptions, InternalDocumentFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {Document} from '../model/Document.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {DocumentType} from '../model/embed/DocumentType.mjs';


interface DocumentFiltersFactory {

	byPatientsCreatedForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byMessagesCreatedForDataOwner(dataOwnerId: string, messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsCreatedForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byMessagesCreatedForSelf(messages: Array<Message>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<Document>;

	byOwningEntitySecretIdsCreatedForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<Document>;

	byPatientsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byMessagesAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	byPatientsAndTypeForSelf(documentType: DocumentType,
			patients: Array<Patient>): FilterOptions<Document>;

	byMessagesAndTypeForSelf(documentType: DocumentType,
			messages: Array<Message>): FilterOptions<Document>;

	byOwningEntitySecretIdsAndTypeForDataOwner(dataOwnerId: string, documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

	byOwningEntitySecretIdsAndTypeForSelf(documentType: DocumentType,
			secretIds: Array<string>): FilterOptions<Document>;

}

export const DocumentFilters: DocumentFiltersFactory = {
			byPatientsCreatedForDataOwner: (dataOwnerId, patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForDataOwner(dataOwnerId, patients, options),
			byMessagesCreatedForDataOwner: (dataOwnerId, messages, options) => InternalDocumentFiltersObj.getInstance().byMessagesCreatedForDataOwner(dataOwnerId, messages, options),
			byPatientsCreatedForSelf: (patients, options) => InternalDocumentFiltersObj.getInstance().byPatientsCreatedForSelf(patients, options),
			byMessagesCreatedForSelf: (messages, options) => InternalDocumentFiltersObj.getInstance().byMessagesCreatedForSelf(messages, options),
			byOwningEntitySecretIdsCreatedForDataOwner: (dataOwnerId, secretIds, options) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsCreatedForDataOwner(dataOwnerId, secretIds, options),
			byOwningEntitySecretIdsCreatedForSelf: (secretIds, options) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsCreatedForSelf(secretIds, options),
			byPatientsAndTypeForDataOwner: (dataOwnerId, documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForDataOwner(dataOwnerId, documentType, patients),
			byMessagesAndTypeForDataOwner: (dataOwnerId, documentType, messages) => InternalDocumentFiltersObj.getInstance().byMessagesAndTypeForDataOwner(dataOwnerId, documentType, messages),
			byPatientsAndTypeForSelf: (documentType, patients) => InternalDocumentFiltersObj.getInstance().byPatientsAndTypeForSelf(documentType, patients),
			byMessagesAndTypeForSelf: (documentType, messages) => InternalDocumentFiltersObj.getInstance().byMessagesAndTypeForSelf(documentType, messages),
			byOwningEntitySecretIdsAndTypeForDataOwner: (dataOwnerId, documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsAndTypeForDataOwner(dataOwnerId, documentType, secretIds),
			byOwningEntitySecretIdsAndTypeForSelf: (documentType, secretIds) => InternalDocumentFiltersObj.getInstance().byOwningEntitySecretIdsAndTypeForSelf(documentType, secretIds)
		};
