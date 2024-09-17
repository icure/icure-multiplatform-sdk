// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {Receipt} from '../model/Receipt.mjs';


export interface ReceiptFlavouredApi<E extends Receipt> {

	shareWith(delegateId: string, receipt: E,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<E>;

	shareWithMany(receipt: E, delegates: { [ key: string ]: ReceiptShareOptions }): Promise<E>;

	modifyReceipt(entity: E): Promise<E>;

	getReceipt(entityId: string): Promise<E>;

	listByReference(reference: string): Promise<Array<E>>;

}
