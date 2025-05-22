// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedMaintenanceTask, MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';


export interface MaintenanceTaskBasicApi {

	matchMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	matchMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	filterMaintenanceTasksBy(filter: BaseFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	filterMaintenanceTasksBySorted(filter: BaseSortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<EncryptedMaintenanceTask>>;

	deleteMaintenanceTaskUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteMaintenanceTaskById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTaskById(id: string, rev: string): Promise<void>;

	deleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<DocIdentifier>;

	deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTask>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<void>;

	createMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<MaintenanceTask>;

	undeleteMaintenanceTaskById(id: string, rev: string): Promise<EncryptedMaintenanceTask>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask | undefined>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<EncryptedMaintenanceTask>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
