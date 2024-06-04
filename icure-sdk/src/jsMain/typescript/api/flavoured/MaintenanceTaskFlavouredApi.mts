// auto-generated file
import {MaintenanceTaskShareOptions} from '../../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface MaintenanceTaskFlavouredApi<E extends MaintenanceTask> {

	shareWith(
			delegateId: string,
			maintenanceTask: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	tryShareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<E>;

	modifyMaintenanceTask(entity: E): Promise<E>;

	getMaintenanceTask(entityId: string): Promise<E>;

	filterMaintenanceTasksBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<MaintenanceTask>): Promise<PaginatedList<E>>;

	subscribeToEvents(
			events: Array<SubscriptionEventType>,
			filter: AbstractFilter<MaintenanceTask>,
			onConnected: () => Promise<void>,
			channelCapacity: number,
			retryDelay: DurationMs,
			retryDelayExponentFactor: number,
			maxRetries: number,
			eventFired: (x1: E) => Promise<void>
	): Promise<Connection>;

}
