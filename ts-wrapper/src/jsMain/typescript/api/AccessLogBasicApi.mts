// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {AccessLog, EncryptedAccessLog} from '../model/AccessLog.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface AccessLogBasicApi {

	matchAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<Array<string>>;

	matchAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<Array<string>>;

	filterAccessLogsBy(filter: BaseFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	filterAccessLogsBySorted(filter: BaseSortableFilterOptions<AccessLog>): Promise<PaginatedListIterator<EncryptedAccessLog>>;

	deleteAccessLog(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogs(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteAccessLogById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteAccessLogsByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeAccessLogById(id: string, rev: string): Promise<void>;

	deleteAccessLog(accessLog: AccessLog): Promise<DocIdentifier>;

	deleteAccessLogs(accessLogs: Array<AccessLog>): Promise<Array<DocIdentifier>>;

	purgeAccessLog(accessLog: AccessLog): Promise<void>;

	undeleteAccessLogById(id: string, rev: string): Promise<EncryptedAccessLog>;

	undeleteAccessLog(accessLog: AccessLog): Promise<EncryptedAccessLog>;

	modifyAccessLog(entity: EncryptedAccessLog): Promise<EncryptedAccessLog>;

	getAccessLog(entityId: string): Promise<EncryptedAccessLog>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<EncryptedAccessLog>>;

	findAccessLogsBy(
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<EncryptedAccessLog>>;

	findAccessLogsByUserAfterDate(userId: string,
			options?: { accessType?: string | undefined, startDate?: number | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedList<EncryptedAccessLog>>;

	findAccessLogsInGroup(groupId: string,
			options?: { fromEpoch?: number | undefined, toEpoch?: number | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedAccessLog>>;

}
