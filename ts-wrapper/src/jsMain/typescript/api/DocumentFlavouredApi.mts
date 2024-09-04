// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {Document} from '../model/Document.mjs';
import {Patient} from '../model/Patient.mjs';


export interface DocumentFlavouredApi<E extends Document> {

	shareWith(delegateId: string, document: E,
			options?: { options?: DocumentShareOptions | undefined }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(document: E,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(document: E, delegates: { [ key: string ]: DocumentShareOptions }): Promise<E>;

	findDocumentsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	modifyDocument(entity: E): Promise<E>;

	getDocument(entityId: string): Promise<E>;

	getDocumentByExternalUuid(externalUuid: string): Promise<E>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<E>>;

	getDocuments(entityIds: Array<string>): Promise<Array<E>>;

	modifyDocuments(entities: Array<E>): Promise<Array<E>>;

	listDocumentsByHcPartyMessageForeignKeys(hcPartyId: string, documentTypeCode: string | undefined,
			secretMessageKeys: Array<string>): Promise<Array<E>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<E>>;

}
