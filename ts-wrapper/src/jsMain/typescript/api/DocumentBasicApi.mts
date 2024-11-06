// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Document, EncryptedDocument} from '../model/Document.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface DocumentBasicApi {

	matchDocumentsBy(filter: BaseFilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<Array<string>>;

	filterDocumentsBy(filter: BaseFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	filterDocumentsBySorted(filter: BaseSortableFilterOptions<Document>): Promise<PaginatedListIterator<EncryptedDocument>>;

	deleteDocumentUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteDocumentsUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteDocumentById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteDocumentsByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeDocumentById(id: string, rev: string): Promise<void>;

	deleteDocument(document: Document): Promise<DocIdentifier>;

	deleteDocuments(documents: Array<Document>): Promise<Array<DocIdentifier>>;

	purgeDocument(document: Document): Promise<void>;

	getRawMainAttachment(documentId: string): Promise<Int8Array>;

	getMainAttachmentAsPlainText(documentId: string): Promise<string>;

	getMainAttachmentAsJson(documentId: string): Promise<any>;

	getRawSecondaryAttachment(documentId: string, key: string): Promise<Int8Array>;

	setRawMainAttachment(
			documentId: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	setRawSecondaryAttachment(
			documentId: string,
			key: string,
			rev: string,
			utis: Array<string> | undefined,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	deleteMainAttachment(entityId: string, rev: string): Promise<EncryptedDocument>;

	deleteSecondaryAttachment(documentId: string, key: string,
			rev: string): Promise<EncryptedDocument>;

	undeleteDocumentById(id: string, rev: string): Promise<EncryptedDocument>;

	undeleteDocument(document: Document): Promise<EncryptedDocument>;

	modifyDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	getDocument(entityId: string): Promise<EncryptedDocument>;

	getDocumentByExternalUuid(externalUuid: string): Promise<EncryptedDocument>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<EncryptedDocument>>;

	getDocuments(entityIds: Array<string>): Promise<Array<EncryptedDocument>>;

	modifyDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<EncryptedDocument>>;

}
