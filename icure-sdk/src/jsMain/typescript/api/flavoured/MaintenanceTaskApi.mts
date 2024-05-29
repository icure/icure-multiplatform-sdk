// auto-generated file
import {MaintenanceTaskShareOptions} from '../../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {DecryptedMaintenanceTask, EncryptedMaintenanceTask, MaintenanceTask} from '../../model/MaintenanceTask.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {FilterChain} from '../../model/filter/chain/FilterChain.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {MaintenanceTaskFlavouredApi} from './MaintenanceTaskFlavouredApi.mjs';


export interface MaintenanceTaskApi {

	encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>;

	tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>;

	createMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTask | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel }): Promise<DecryptedMaintenanceTask>;

	getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Promise<Array<HexString>>;

	hasWriteAccess(maintenanceTask: MaintenanceTask): Promise<boolean>;

	decryptPatientIdOf(maintenanceTask: MaintenanceTask): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: MaintenanceTask,
			delegates: Array<string>): Promise<void>;

	deleteMaintenanceTask(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasks(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			maintenanceTask: DecryptedMaintenanceTask,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedMaintenanceTask>>;

	tryShareWithMany(maintenanceTask: DecryptedMaintenanceTask,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<SimpleShareResult<DecryptedMaintenanceTask>>;

	shareWithMany(maintenanceTask: DecryptedMaintenanceTask,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<DecryptedMaintenanceTask>;

	modifyMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<DecryptedMaintenanceTask>;

	filterMaintenanceTasksBy(startDocumentId: string | undefined, limit: number | undefined,
			filterChain: FilterChain<MaintenanceTask>): Promise<PaginatedList<DecryptedMaintenanceTask>>;

}
