// auto-generated file
import {AccessLogShareOptions} from '../../crypto/entities/AccessLogShareOptions.mjs';
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {AccessLog, DecryptedAccessLog, EncryptedAccessLog} from '../../model/AccessLog.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {AccessLogFlavouredApi} from './AccessLogFlavouredApi.mjs';


export interface AccessLogApi {

	encrypted: AccessLogFlavouredApi<EncryptedAccessLog>;

	tryAndRecover: AccessLogFlavouredApi<AccessLog>;

	createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	withEncryptionMetadata(base: DecryptedAccessLog | undefined, patient: Patient,
			options?: { base?: DecryptedAccessLog | undefined, patient?: Patient, user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedAccessLog>;

	getEncryptionKeysOf(accessLog: AccessLog): Promise<Array<HexString>>;

	hasWriteAccess(accessLog: AccessLog): Promise<boolean>;

	decryptPatientIdOf(accessLog: AccessLog): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: AccessLog,
			delegates: Array<string>): Promise<void>;

	deleteAccessLog(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogs(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, accessLog: DecryptedAccessLog,
			options?: { delegateId?: string, accessLog?: DecryptedAccessLog, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<DecryptedAccessLog>>;

	tryShareWithMany(accessLog: DecryptedAccessLog,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<SimpleShareResult<DecryptedAccessLog>>;

	shareWithMany(accessLog: DecryptedAccessLog,
			delegates: { [ key: string ]: AccessLogShareOptions }): Promise<DecryptedAccessLog>;

	findAccessLogsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedAccessLog>>;

	modifyAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	getAccessLog(entityId: string): Promise<DecryptedAccessLog>;

	getAccessLogs(entityIds: Array<string>): Promise<Array<DecryptedAccessLog>>;

	findAccessLogsBy(
			fromEpoch: number | undefined,
			toEpoch: number | undefined,
			startKey: number | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined
	): Promise<PaginatedList<DecryptedAccessLog>>;

	findAccessLogsByUserAfterDate(userId: string,
			options?: { userId?: string, accessType?: string | undefined, startDate?: number | undefined, startKey?: string | undefined, startDocumentId?: string | undefined, limit?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedList<DecryptedAccessLog>>;

	findAccessLogsInGroup(groupId: string,
			options?: { groupId?: string, fromEpoch?: number | undefined, toEpoch?: number | undefined, startKey?: number | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<DecryptedAccessLog>>;

}
