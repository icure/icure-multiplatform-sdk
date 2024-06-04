// auto-generated file
import {DocumentShareOptions} from '../../crypto/entities/DocumentShareOptions.mjs';
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {DecryptedDocument, Document, EncryptedDocument} from '../../model/Document.mjs';
import {Message} from '../../model/Message.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {DocumentFlavouredApi} from './DocumentFlavouredApi.mjs';


export interface DocumentApi {

	encrypted: DocumentFlavouredApi<EncryptedDocument>;

	tryAndRecover: DocumentFlavouredApi<Document>;

	createDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	withEncryptionMetadata(
			base: DecryptedDocument | undefined,
			message: Message | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedDocument>;

	getAndTryDecryptMainAttachment(document: Document, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => Promise<boolean>): Promise<Int8Array | undefined>;

	getAndTryDecryptMainAttachmentAsPlainText(document: Document, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => Promise<boolean>): Promise<string | undefined>;

	getAndTryDecryptMainAttachmentAsJson(document: Document, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => Promise<boolean>): Promise<any | undefined>;

	getAndDecryptMainAttachment(document: Document, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => Promise<boolean>): Promise<Int8Array>;

	encryptAndSetMainAttachment(document: Document, utis: Array<string>,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getAndDecryptSecondaryAttachment(document: Document, key: string, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => Promise<boolean>): Promise<Int8Array>;

	encryptAndSetSecondaryAttachment(document: Document, key: string, utis: Array<string>,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getEncryptionKeysOf(document: Document): Promise<Array<HexString>>;

	hasWriteAccess(document: Document): Promise<boolean>;

	decryptPatientIdOf(document: Document): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Document, delegates: Array<string>): Promise<void>;

	deleteDocument(entityId: string): Promise<DocIdentifier>;

	deleteDocuments(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawMainAttachment(documentId: string, attachmentId: string): Promise<Int8Array>;

	getMainAttachmentAsPlainText(documentId: string, attachmentId: string): Promise<string>;

	getMainAttachmentAsJson(documentId: string, attachmentId: string): Promise<any>;

	getRawSecondaryAttachment(documentId: string, key: string,
			attachmentId: string): Promise<Int8Array>;

	shareWith(
			delegateId: string,
			document: DecryptedDocument,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedDocument>>;

	tryShareWithMany(document: DecryptedDocument,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<SimpleShareResult<DecryptedDocument>>;

	shareWithMany(document: DecryptedDocument,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<DecryptedDocument>;

	findDocumentsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedDocument>>;

	modifyDocument(entity: DecryptedDocument): Promise<DecryptedDocument>;

	getDocument(entityId: string): Promise<DecryptedDocument>;

	getDocumentByExternalUuid(externalUuid: string): Promise<DecryptedDocument>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<DecryptedDocument>>;

	getDocuments(entityIds: Array<string>): Promise<Array<DecryptedDocument>>;

	modifyDocuments(entities: Array<DecryptedDocument>): Promise<Array<DecryptedDocument>>;

	listDocumentsByHcPartyMessageForeignKeys(hcPartyId: string, documentTypeCode: string | undefined,
			secretMessageKeys: Array<string>): Promise<Array<DecryptedDocument>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<DecryptedDocument>>;

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

	deleteMainAttachment(entityId: string, rev: string): Promise<DecryptedDocument>;

	deleteSecondaryAttachment(documentId: string, key: string,
			attachmentId: string): Promise<DecryptedDocument>;

}
