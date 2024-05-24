// auto-generated file
import {EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';


export interface MaintenanceTaskBasicApi {

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyMaintenanceTask(entity: EncryptedMaintenanceTask): Promise<EncryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<EncryptedMaintenanceTask>;

	filterMaintenanceTasksBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<MaintenanceTask>): Promise<PaginatedList<EncryptedMaintenanceTask>>;

}
