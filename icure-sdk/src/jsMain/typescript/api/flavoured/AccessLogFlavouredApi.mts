// auto-generated file
import {AccessLogShareOptions} from '../../crypto/entities/AccessLogShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {AccessLog} from '../../model/AccessLog.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface AccessLogFlavouredApi<E extends AccessLog> {

	shareWith(delegateId: string, accessLog: E,
			options?: { delegateId?: string, accessLog?: E, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<E>>;

	tryShareWithMany(accessLog: E,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(accessLog: E, delegates: { [ key: string ]: AccessLogShareOptions }): Promise<E>;

	findAccessLogsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	modifyAccessLog(entity: E): Promise<E>;

	getAccessLog(entityId: string): Promise<E>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<E>>;

	findAccessLogsBy(
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<E>>;

	findAccessLogsByUserAfterDate(userId: string,
			options?: { userId?: string, accessType?: string | undefined, startDate?: number | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedList<E>>;

	findAccessLogsInGroup(groupId: string,
			options?: { groupId?: string, fromEpoch?: number | undefined, toEpoch?: number | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

}
