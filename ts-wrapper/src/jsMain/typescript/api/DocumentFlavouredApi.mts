// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {Document} from '../model/Document.mjs';
import {Patient} from '../model/Patient.mjs';


export interface DocumentFlavouredApi<E extends Document> {

	shareWith(delegateId: string, document: E,
			options?: { options?: DocumentShareOptions | undefined }): Promise<E>;

	shareWithMany(document: E, delegates: { [ key: string ]: DocumentShareOptions }): Promise<E>;

	findDocumentsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<E>>;

	createDocument(entity: E): Promise<E>;

	undeleteDocumentById(id: string, rev: string): Promise<E>;

	undeleteDocument(document: Document): Promise<E>;

	modifyDocument(entity: E): Promise<E>;

	getDocument(entityId: string): Promise<E | undefined>;

	getDocumentByExternalUuid(externalUuid: string): Promise<E>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<E>>;

	getDocuments(entityIds: Array<string>): Promise<Array<E>>;

	modifyDocuments(entities: Array<E>): Promise<Array<E>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<E>>;

}
