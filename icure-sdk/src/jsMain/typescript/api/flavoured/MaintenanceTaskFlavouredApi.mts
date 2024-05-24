// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface MaintenanceTaskFlavouredApi<E extends MaintenanceTask> {

	shareWith(
			delegateId: string,
			maintenanceTask: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	modifyMaintenanceTask(entity: E): Promise<E>;

	getMaintenanceTask(entityId: string): Promise<E>;

	filterMaintenanceTasksBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<MaintenanceTask>): Promise<PaginatedList<E>>;

}
