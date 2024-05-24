// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {Receipt} from '../../model/Receipt.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface ReceiptFlavouredApi<E extends Receipt> {

	shareWith(
			delegateId: string,
			receipt: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	modifyReceipt(entity: E): Promise<E>;

	getReceipt(entityId: string): Promise<E>;

	listByReference(reference: string): Promise<Array<E>>;

}
