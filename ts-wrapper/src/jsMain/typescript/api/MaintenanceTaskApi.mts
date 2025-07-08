// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MaintenanceTaskShareOptions} from '../crypto/entities/MaintenanceTaskShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedMaintenanceTask, EncryptedMaintenanceTask, MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MaintenanceTaskFlavouredApi} from './MaintenanceTaskFlavouredApi.mjs';


export interface MaintenanceTaskApi {

	encrypted: MaintenanceTaskFlavouredApi<EncryptedMaintenanceTask>;

	tryAndRecover: MaintenanceTaskFlavouredApi<MaintenanceTask>;

	withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTask | undefined,
			alternateRootDataOwnerReference: EntityReferenceInGroup | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel } }): Promise<DecryptedMaintenanceTask>;

	getEncryptionKeysOf(maintenanceTask: MaintenanceTask): Promise<Array<HexString>>;

	hasWriteAccess(maintenanceTask: MaintenanceTask): Promise<boolean>;

	decryptPatientIdOf(maintenanceTask: MaintenanceTask): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: MaintenanceTask,
			delegates: Array<string>): Promise<void>;

	decrypt(maintenanceTask: EncryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	tryDecrypt(maintenanceTask: EncryptedMaintenanceTask): Promise<MaintenanceTask>;

	matchMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<Array<string>>;

	matchMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<Array<string>>;

	deleteMaintenanceTaskUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteMaintenanceTaskById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteMaintenanceTasksByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTaskById(id: string, rev: string): Promise<void>;

	deleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<DocIdentifier>;

	deleteMaintenanceTasks(maintenanceTasks: Array<MaintenanceTask>): Promise<Array<DocIdentifier>>;

	purgeMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<void>;

	shareWith(delegateId: string, maintenanceTask: DecryptedMaintenanceTask,
			options?: { options?: MaintenanceTaskShareOptions | undefined }): Promise<DecryptedMaintenanceTask>;

	shareWithMany(maintenanceTask: DecryptedMaintenanceTask,
			delegates: { [ key: string ]: MaintenanceTaskShareOptions }): Promise<DecryptedMaintenanceTask>;

	filterMaintenanceTasksBy(filter: FilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<DecryptedMaintenanceTask>>;

	filterMaintenanceTasksBySorted(filter: SortableFilterOptions<MaintenanceTask>): Promise<PaginatedListIterator<DecryptedMaintenanceTask>>;

	createMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	undeleteMaintenanceTask(maintenanceTask: MaintenanceTask): Promise<MaintenanceTask>;

	undeleteMaintenanceTaskById(id: string, rev: string): Promise<DecryptedMaintenanceTask>;

	modifyMaintenanceTask(entity: DecryptedMaintenanceTask): Promise<DecryptedMaintenanceTask>;

	getMaintenanceTask(entityId: string): Promise<DecryptedMaintenanceTask | undefined>;

	getMaintenanceTasks(entityIds: Array<string>): Promise<Array<DecryptedMaintenanceTask>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<MaintenanceTask>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMaintenanceTask>>;

}
