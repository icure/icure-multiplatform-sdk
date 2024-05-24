// auto-generated file
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {TimeTable} from '../../model/TimeTable.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface TimeTableFlavouredApi<E extends TimeTable> {

	shareWith(
			delegateId: string,
			timeTable: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	modifyTimeTable(entity: E): Promise<E>;

	getTimeTable(entityId: string): Promise<E>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<E>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<E>>;

}
