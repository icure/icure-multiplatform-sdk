// auto-generated file
import {DocumentShareOptions} from '../../crypto/entities/DocumentShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {Document, EncryptedDocument} from '../../model/Document.mjs';
import {Patient} from '../../model/Patient.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface DocumentFlavouredApi<E extends Document> {

	shareWith(delegateId: string, document: E,
			options?: { delegateId?: string, document?: E, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(document: E,
			delegates: { [ key: string ]: DocumentShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(document: E, delegates: { [ key: string ]: DocumentShareOptions }): Promise<E>;

	findDocumentsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	modifyDocument(entity: E): Promise<E>;

	getDocument(entityId: string): Promise<E>;

	getDocumentByExternalUuid(externalUuid: string): Promise<E>;

	getDocumentsByExternalUuid(externalUuid: string): Promise<Array<E>>;

	getDocuments(entityIds: Array<string>): Promise<Array<E>>;

	modifyDocuments(entities: Array<E>): Promise<Array<E>>;

	listDocumentsByHcPartyMessageForeignKeys(hcPartyId: string, documentTypeCode: string | undefined,
			secretMessageKeys: Array<string>): Promise<Array<E>>;

	findWithoutDelegation(limit: number | undefined): Promise<Array<E>>;

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

	deleteMainAttachment(entityId: string, rev: string): Promise<E>;

	deleteSecondaryAttachment(documentId: string, key: string, attachmentId: string): Promise<E>;

}
