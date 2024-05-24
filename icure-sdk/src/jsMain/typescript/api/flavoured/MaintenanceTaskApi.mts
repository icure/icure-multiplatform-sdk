// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {DecryptedMaintenanceTask, EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {MaintenanceTaskFlavouredApi} from './MaintenanceTaskFlavouredApi.mjs';


export interface MaintenanceTaskApi {

	encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>;

	tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>;

	createMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTask | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel }): Promise<DecryptedMaintenanceTask>;

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			maintenanceTask: DecryptedMaintenanceTask,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedMaintenanceTask>>;

}
