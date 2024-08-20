// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../../icure-sdk-ts.mjs';
import {EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../../subscription/SubscriptionEventType.mjs';


export interface MaintenanceTaskBasicApi {

	matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<EncryptedMaintenanceTask>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
