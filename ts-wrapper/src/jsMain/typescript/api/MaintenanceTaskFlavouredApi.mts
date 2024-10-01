// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MaintenanceTaskShareOptions} from '../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {MaintenanceTask} from '../model/MaintenanceTask.mjs';


export interface MaintenanceTaskFlavouredApi<E extends MaintenanceTask> {

	shareWith(delegateId: string, maintenanceTask: E,
			options?: { options?: MaintenanceTaskShareOptions | undefined }): Promise<E>;

	shareWithMany(maintenanceTask: E,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<E>;

	filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

	filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<E>>;

	undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<MaintenanceTask>;

	undeleteMaintenanceTaskById(id: string, rev: string): Promise<E>;

	modifyMaintenanceTask(entity: E): Promise<E>;

	getMaintenanceTask(entityId: string): Promise<E>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<E>>;

}
