// auto-generated file
import {EncryptedAccessLog} from '../../model/AccessLog.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface AccessLogBasicApi {

	deleteAccessLog(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogs(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

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

	findAccessLogsByUserAfterDate(
			userId: string,
			accessType: string | undefined,
			startDate: number | undefined,
			startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedList<EncryptedAccessLog>>;

	findAccessLogsInGroup(
			groupId: string,
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<EncryptedAccessLog>>;

}
