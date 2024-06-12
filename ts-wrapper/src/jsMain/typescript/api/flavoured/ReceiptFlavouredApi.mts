// auto-generated file
import {ReceiptShareOptions} from '../../crypto/entities/ReceiptShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {Receipt} from '../../model/Receipt.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface ReceiptFlavouredApi<E extends Receipt> {

	shareWith(delegateId: string, receipt: E,
			options?: { delegateId?: string, receipt?: E, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(receipt: E,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(receipt: E, delegates: { [ key: string ]: ReceiptShareOptions }): Promise<E>;

	modifyReceipt(entity: E): Promise<E>;

	getReceipt(entityId: string): Promise<E>;

	listByReference(reference: string): Promise<Array<E>>;

}
