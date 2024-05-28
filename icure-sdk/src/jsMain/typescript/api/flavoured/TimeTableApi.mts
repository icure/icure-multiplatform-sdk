// auto-generated file
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {Patient} from '../../model/Patient.mjs';
import {DecryptedTimeTable, EncryptedTimeTable, TimeTable} from '../../model/TimeTable.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {TimeTableFlavouredApi} from './TimeTableFlavouredApi.mjs';


export interface TimeTableApi {

	encrypted: TimeTableFlavouredApi<EncryptedTimeTable>;

	tryAndRecover: TimeTableFlavouredApi<TimeTable>;

	createTimeTable(entity: DecryptedTimeTable): Promise<DecryptedTimeTable>;

	withEncryptionMetadata(
			base: DecryptedTimeTable | undefined,
			patient: Patient | undefined,
			user: User | undefined,
			delegates: { [ key: string ]: AccessLevel },
			secretId: SecretIdOption
	): Promise<DecryptedTimeTable>;

	deleteTimeTable(entityId: string): Promise<DocIdentifier>;

	deleteTimeTables(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(
			delegateId: string,
			timeTable: DecryptedTimeTable,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<DecryptedTimeTable>>;

	modifyTimeTable(entity: DecryptedTimeTable): Promise<DecryptedTimeTable>;

	getTimeTable(entityId: string): Promise<DecryptedTimeTable>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<DecryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<DecryptedTimeTable>>;

}
