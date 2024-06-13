// auto-generated file
import {EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {DurationMs} from '../../utils/DurationMs.mjs';
import {Connection} from '../../websocket/Connection.mjs';


export interface MaintenanceTaskBasicApi {

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask>;

	filterMaintenanceTasksBy(filterChain: FilterChain<MaintenanceTask>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedMaintenanceTask>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<MaintenanceTask>,
			eventFired: (x1: EncryptedMaintenanceTask) => Promise<void>,
			options?: { onConnected?: () => Promise<void>, channelCapacity?: number, retryDelay?: DurationMs, retryDelayExponentFactor?: number, maxRetries?: number }): Promise<Connection>;

}
