// auto-generated file
import {MaintenanceTaskShareOptions} from '../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {MaintenanceTask} from '../model/MaintenanceTask.mjs';


export interface MaintenanceTaskFlavouredApi<E extends MaintenanceTask> {

	shareWith(delegateId: string, maintenanceTask: E,
			options?: { options?: MaintenanceTaskShareOptions | undefined }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<E>;

	filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

	filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

	modifyMaintenanceTask(entity: E): Promise<E>;

	getMaintenanceTask(entityId: string): Promise<E>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<E>>;

}
