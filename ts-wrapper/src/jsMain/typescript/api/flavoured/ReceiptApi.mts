// auto-generated file
import {ReceiptShareOptions} from '../../crypto/entities/ReceiptShareOptions.mjs';
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {Patient} from '../../model/Patient.mjs';
import {DecryptedReceipt, EncryptedReceipt, Receipt} from '../../model/Receipt.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {ReceiptFlavouredApi} from './ReceiptFlavouredApi.mjs';


export interface ReceiptApi {

	encrypted: ReceiptFlavouredApi<EncryptedReceipt>;

	tryAndRecover: ReceiptFlavouredApi<Receipt>;

	createReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	withEncryptionMetadata(base: DecryptedReceipt | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedReceipt>;

	getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: string): Promise<Int8Array>;

	encryptAndSetReceiptAttachment(receipt: Receipt, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	getEncryptionKeysOf(receipt: Receipt): Promise<Array<HexString>>;

	hasWriteAccess(receipt: Receipt): Promise<boolean>;

	decryptPatientIdOf(receipt: Receipt): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Array<string>): Promise<void>;

	logReceipt(
			user: User,
			docId: string,
			refs: Array<string>,
			blobType: string,
			blob: Int8Array
	): Promise<Receipt>;

	deleteReceipt(entityId: string): Promise<DocIdentifier>;

	deleteReceipts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawReceiptAttachment(receiptId: string, attachmentId: string): Promise<Int8Array>;

	setRawReceiptAttachment(receiptId: string, rev: string, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	shareWith(delegateId: string, receipt: DecryptedReceipt,
			options?: { shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<DecryptedReceipt>>;

	tryShareWithMany(receipt: DecryptedReceipt,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<SimpleShareResult<DecryptedReceipt>>;

	shareWithMany(receipt: DecryptedReceipt,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<DecryptedReceipt>;

	modifyReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	getReceipt(entityId: string): Promise<DecryptedReceipt>;

	listByReference(reference: string): Promise<Array<DecryptedReceipt>>;

}
