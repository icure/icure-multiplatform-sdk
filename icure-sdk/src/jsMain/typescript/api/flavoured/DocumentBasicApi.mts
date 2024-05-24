// auto-generated file
import {EncryptedDocument} from '../../model/Document.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface DocumentBasicApi {

	deleteDocument(entityId: string): Promise<DocIdentifier>;

	deleteDocuments(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawMainAttachment(documentId: string, attachmentId: string): Promise<Int8Array>;

	getRawSecondaryAttachment(documentId: string, key: string,
			attachmentId: string): Promise<Int8Array>;

	modifyDocument(entity: EncryptedDocument): Promise<EncryptedDocument>;

	getDocument(entityId: string): Promise<EncryptedDocument>;

	getDocumentByExternalUuid(externalUuid: string): Promise<EncryptedDocument>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<EncryptedDocument>>;

	getDocuments(entityIds: Array<string>): Promise<Array<EncryptedDocument>>;

	modifyDocuments(entities: Array<EncryptedDocument>): Promise<Array<EncryptedDocument>>;

	listDocumentsByHcPartyMessageForeignKeys(hcPartyId: string, documentTypeCode: string | undefined,
			secretMessageKeys: Array<string>): Promise<Array<EncryptedDocument>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<EncryptedDocument>>;

	setRawMainAttachment(
			documentId: string,
			rev: string,
			utis: Array<string>,
			blobType: string,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	setRawSecondaryAttachment(
			documentId: string,
			key: string,
			rev: string,
			utis: Array<string>,
			blobType: string,
			attachment: Int8Array,
			encrypted: boolean
	): Promise<EncryptedDocument>;

	deleteMainAttachment(entityId: string, rev: string): Promise<EncryptedDocument>;

	deleteSecondaryAttachment(documentId: string, key: string,
			attachmentId: string): Promise<EncryptedDocument>;

}
