// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {TimeTableShareOptions} from '../crypto/entities/TimeTableShareOptions.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {Patient} from '../model/Patient.mjs';
import {DecryptedTimeTable, EncryptedTimeTable, TimeTable} from '../model/TimeTable.mjs';
import {User} from '../model/User.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {TimeTableFlavouredApi} from './TimeTableFlavouredApi.mjs';


export interface TimeTableApi {

	encrypted: TimeTableFlavouredApi<EncryptedTimeTable>;

	tryAndRecover: TimeTableFlavouredApi<TimeTable>;

	createTimeTable(entity: DecryptedTimeTable): Promise<DecryptedTimeTable>;

	withEncryptionMetadata(base: DecryptedTimeTable | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption }): Promise<DecryptedTimeTable>;

	getEncryptionKeysOf(timeTable: TimeTable): Promise<Array<HexString>>;

	hasWriteAccess(timeTable: TimeTable): Promise<boolean>;

	decryptPatientIdOf(timeTable: TimeTable): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: TimeTable,
			delegates: Array<string>): Promise<void>;

	decrypt(timeTable: EncryptedTimeTable): Promise<DecryptedTimeTable>;

	tryDecrypt(timeTable: EncryptedTimeTable): Promise<TimeTable>;

	matchTimeTablesBy(filter: FilterOptions<TimeTable>): Promise<Array<string>>;

	matchTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): Promise<Array<string>>;

	deleteTimeTableUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteTimeTablesUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteTimeTableById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteTimeTablesByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeTimeTableById(id: string, rev: string): Promise<void>;

	deleteTimeTable(timeTable: TimeTable): Promise<DocIdentifier>;

	deleteTimeTables(timeTables: Array<TimeTable>): Promise<Array<DocIdentifier>>;

	purgeTimeTable(timeTable: TimeTable): Promise<void>;

	shareWith(delegateId: string, timeTable: DecryptedTimeTable,
			options?: { options?: TimeTableShareOptions | undefined }): Promise<DecryptedTimeTable>;

	shareWithMany(timeTable: DecryptedTimeTable,
			delegates: { [ key: string ]: TimeTableShareOptions }): Promise<DecryptedTimeTable>;

	filterTimeTablesBy(filter: FilterOptions<TimeTable>): Promise<PaginatedListIterator<DecryptedTimeTable>>;

	filterTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<DecryptedTimeTable>>;

	undeleteTimeTable(timeTable: TimeTable): Promise<TimeTable>;

	modifyTimeTable(entity: DecryptedTimeTable): Promise<DecryptedTimeTable>;

	undeleteTimeTableById(id: string, rev: string): Promise<DecryptedTimeTable>;

	getTimeTable(entityId: string): Promise<DecryptedTimeTable>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<DecryptedTimeTable>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<DecryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<DecryptedTimeTable>>;

}
