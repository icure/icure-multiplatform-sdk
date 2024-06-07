// auto-generated file
import {IdWithRev} from '../model/IdWithRev.mjs';
import {IndexingInfo} from '../model/IndexingInfo.mjs';
import {ReplicationInfo} from '../model/ReplicationInfo.mjs';
import {ReplicatorDocument} from '../model/couchdb/ReplicatorDocument.mjs';


export interface ICureApi {

	getVersion(): Promise<string>;

	isReady(): Promise<string>;

	getProcessInfo(): Promise<string>;

	getIndexingInfo(): Promise<IndexingInfo>;

	getReplicationInfo(): Promise<ReplicationInfo>;

	updateDesignDoc(entityName: string,
			options?: { entityName?: string, warmup?: boolean | undefined }): Promise<boolean>;

	resolvePatientsConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveContactsConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveFormsConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveHealthElementsConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveInvoicesConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveMessagesConflicts(options?: { limit?: number | undefined }): Promise<Array<IdWithRev>>;

	resolveDocumentsConflicts(options?: { ids?: string | undefined, limit?: number | undefined }): Promise<Array<IdWithRev>>;

	getIndexingInfoByGroup(groupId: string): Promise<IndexingInfo>;

	getReplicatorInfo(id: string): Promise<ReplicatorDocument>;

	evictAllFromMap(mapName: string): Promise<string>;

}
