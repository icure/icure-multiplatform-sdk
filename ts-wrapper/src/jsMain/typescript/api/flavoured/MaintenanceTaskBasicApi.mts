// auto-generated file
import {EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {SubscriptionEventType} from '../../model/notification/SubscriptionEventType.mjs';
import {EntitySubscription} from '../../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../../subscription/EntitySubscriptionConfiguration.mjs';


export interface MaintenanceTaskBasicApi {

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: AbstractFilter<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask>;

	filterMaintenanceTasksBy(filterChain: FilterChain<MaintenanceTask>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedMaintenanceTask>>;

}
