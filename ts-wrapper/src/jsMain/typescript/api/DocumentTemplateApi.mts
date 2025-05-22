// auto-generated file
import {DocumentTemplate} from '../model/DocumentTemplate.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface DocumentTemplateApi {

	getDocumentTemplate(documentTemplateId: string): Promise<DocumentTemplate | undefined>;

	createDocumentTemplate(documentTemplate: DocumentTemplate): Promise<DocumentTemplate>;

	modifyDocumentTemplate(documentTemplate: DocumentTemplate): Promise<DocumentTemplate>;

	deleteDocumentTemplates(documentTemplateIds: Array<string>): Promise<Array<DocIdentifier>>;

	listDocumentTemplatesBySpeciality(specialityCode: string): Promise<Array<DocumentTemplate>>;

	listDocumentTemplatesByDocumentType(documentTypeCode: string): Promise<Array<DocumentTemplate>>;

	listDocumentTemplatesByDocumentTypeForCurrentUser(documentTypeCode: string): Promise<Array<DocumentTemplate>>;

	listDocumentTemplates(): Promise<Array<DocumentTemplate>>;

	findAllDocumentTemplates(options?: { startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DocumentTemplate>>;

	getDocumentTemplateAttachment(documentTemplateId: string,
			attachmentId: string): Promise<Int8Array>;

	getAttachmentText(documentTemplateId: string, attachmentId: string): Promise<Int8Array>;

	setDocumentTemplateAttachment(documentTemplateId: string,
			payload: Int8Array): Promise<DocumentTemplate>;

	getAttachmentUrl(documentId: string, attachmentId: string): string;

}
