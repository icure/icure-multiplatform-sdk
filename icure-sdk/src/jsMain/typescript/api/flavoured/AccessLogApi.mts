// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {AccessLog, DecryptedAccessLog, EncryptedAccessLog} from '../../model/AccessLog.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {AccessLogFlavouredApi} from './AccessLogFlavouredApi.mjs';


export interface AccessLogApi {

	encrypted: AccessLogFlavouredApi<EncryptedAccessLog>;

	tryAndRecover: AccessLogFlavouredApi<AccessLog>;

	createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>;

	withEncryptionMetadata(
			base: DecryptedAccessLog | undefined,
			patient: Patient,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedAccessLog>;

	deleteAccessLog(entityId: string): Promise<DocIdentifier>;

	deleteAccessLogs(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			accessLog: DecryptedAccessLog,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedAccessLog>>;

	findAccessLogsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<DecryptedAccessLog>>;

}
