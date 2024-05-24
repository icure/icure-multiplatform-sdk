// auto-generated file
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

	getAndDecryptMainAttachment(document: Document, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => boolean): Promise<Int8Array>;

	encryptAndSetMainAttachment(document: Document, utis: Array<string>,
			attachment: Int8Array): Promise<EncryptedDocument>;

	getAndDecryptSecondaryAttachment(document: Document, key: string, attachmentId: string,
			decryptedDocumentValidator: (x1: Int8Array) => boolean): Promise<Int8Array>;

	encryptAndSetSecondaryAttachment(document: Document, key: string, utis: Array<string>,
			attachment: Int8Array): Promise<EncryptedDocument>;

	deleteDocument(entityId: string): Promise<DocIdentifier>;

	deleteDocuments(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawMainAttachment(documentId: string, attachmentId: string): Promise<Int8Array>;

	getRawSecondaryAttachment(documentId: string, key: string,
			attachmentId: string): Promise<Int8Array>;

	shareWith(
			delegateId: string,
			document: DecryptedDocument,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedDocument>>;

	findDocumentsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedDocument>>;

}
