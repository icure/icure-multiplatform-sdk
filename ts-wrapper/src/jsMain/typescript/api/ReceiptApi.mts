// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {DecryptedReceipt, EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ReceiptFlavouredApi} from './ReceiptFlavouredApi.mjs';


export interface ReceiptApi {

	encrypted: ReceiptFlavouredApi<EncryptedReceipt>;

	tryAndRecover: ReceiptFlavouredApi<Receipt>;

	withEncryptionMetadata(base: DecryptedReceipt | undefined, patient: Patient | undefined,
			alternateRootDataOwnerReference: EntityReferenceInGroup | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedReceipt>;

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

	decrypt(receipt: EncryptedReceipt): Promise<DecryptedReceipt>;

	tryDecrypt(receipt: EncryptedReceipt): Promise<Receipt>;

	deleteReceipt(entityId: string): Promise<DocIdentifier>;

	deleteReceipts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawReceiptAttachment(receiptId: string, attachmentId: string): Promise<Int8Array>;

	setRawReceiptAttachment(receiptId: string, rev: string, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	shareWith(delegateId: string, receipt: DecryptedReceipt,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<DecryptedReceipt>;

	shareWithMany(receipt: DecryptedReceipt,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<DecryptedReceipt>;

	createReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	modifyReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	getReceipt(entityId: string): Promise<DecryptedReceipt | undefined>;

	listByReference(reference: string): Promise<Array<DecryptedReceipt>>;

}
