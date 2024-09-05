// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {DocumentShareOptions} from '../crypto/entities/DocumentShareOptions.mjs';
import {SecretIdOption} from '../crypto/entities/SecretIdOption.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {DecryptedDocument, Document, EncryptedDocument} from '../model/Document.mjs';
import {Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {DocumentFlavouredApi} from './DocumentFlavouredApi.mjs';


export interface DocumentApi {

	encrypted: DocumentFlavouredApi<EncryptedDocument>;

	tryAndRecover: DocumentFlavouredApi<Document>;

	createDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	withEncryptionMetadata(base: DecryptedDocument | undefined, message: Message | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedDocument>;

	getAndTryDecryptMainAttachment(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array | undefined>;

	getAndTryDecryptMainAttachmentAsPlainText(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<string | undefined>;

	getAndTryDecryptMainAttachmentAsJson(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<any | undefined>;

	getAndDecryptMainAttachment(document: Document,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array>;

	encryptAndSetMainAttachment(document: Document, utis: Array<string> | undefined,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getAndDecryptSecondaryAttachment(document: Document, key: string,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array>;

	encryptAndSetSecondaryAttachment(document: Document, key: string, utis: Array<string> | undefined,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getEncryptionKeysOf(document: Document): Promise<Array<HexString>>;

	hasWriteAccess(document: Document): Promise<boolean>;

	decryptPatientIdOf(document: Document): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Document, delegates: Array<string>): Promise<void>;

	decrypt(document: EncryptedDocument): Promise<DecryptedDocument>;

	tryDecrypt(document: EncryptedDocument): Promise<Document>;

	tryDecryptAttachment(document: Document, encryptedAttachment: Int8Array,
			options?: { decryptedAttachmentValidator?: (x1: Int8Array) => Promise<boolean> }): Promise<Int8Array | undefined>;

	matchDocumentsBy(filter: FilterOptions<Document>): Promise<Array<string>>;

	matchDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<Array<string>>;

	deleteDocument(entityId: string): Promise<DocIdentifier>;

	deleteDocuments(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

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

	shareWith(delegateId: string, document: DecryptedDocument,
			options?: { options?: DocumentShareOptions | undefined }): Promise<SimpleShareResult<DecryptedDocument>>;

	tryShareWithMany(document: DecryptedDocument,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<SimpleShareResult<DecryptedDocument>>;

	shareWithMany(document: DecryptedDocument,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<DecryptedDocument>;

	findDocumentsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedDocument>>;

	filterDocumentsBy(filter: FilterOptions<Document>): Promise<PaginatedListIterator<DecryptedDocument>>;

	filterDocumentsBySorted(filter: SortableFilterOptions<Document>): Promise<PaginatedListIterator<DecryptedDocument>>;

	modifyDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	getDocument(entityId: string): Promise<DecryptedDocument>;

	getDocumentByExternalUuid(externalUuid: string): Promise<DecryptedDocument>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<DecryptedDocument>>;

	getDocuments(entityIds: Array<string>): Promise<Array<DecryptedDocument>>;

	modifyDocuments(entities: Array<DecryptedDocument>): Promise<Array<DecryptedDocument>>;

	listDocumentsByHcPartyMessageForeignKeys(hcPartyId: string, documentTypeCode: string | undefined,
			secretMessageKeys: Array<string>): Promise<Array<DecryptedDocument>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<DecryptedDocument>>;

}
