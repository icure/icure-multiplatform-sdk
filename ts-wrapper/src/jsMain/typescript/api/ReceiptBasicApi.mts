// auto-generated file
import {EncryptedReceipt} from '../model/Receipt.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface ReceiptBasicApi {

	deleteReceipt(entityId: string): Promise<DocIdentifier>;

	deleteReceipts(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getRawReceiptAttachment(receiptId: string, attachmentId: string): Promise<Int8Array>;

	setRawReceiptAttachment(receiptId: string, rev: string, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	createReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	modifyReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	getReceipt(entityId: string): Promise<EncryptedReceipt | undefined>;

	listByReference(reference: string): Promise<Array<EncryptedReceipt>>;

}
