// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {EncryptedMaintenanceTask, MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface MaintenanceTaskBasicApi {

	matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteMaintenanceTaskById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTaskById(id: string, rev: string): Promise<void>;

	deleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<DocIdentifier>;

	deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTask>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<void>;

	undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<MaintenanceTask>;

	undeleteMaintenanceTaskById(id: string, rev: string): Promise<EncryptedMaintenanceTask>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<EncryptedMaintenanceTask>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
