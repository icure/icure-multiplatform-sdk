// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdOption} from '../crypto/entities/SecretIdOption.mjs';
import {SimpleShareResult} from '../crypto/entities/SimpleShareResult.mjs';
import {TimeTableShareOptions} from '../crypto/entities/TimeTableShareOptions.mjs';
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
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedTimeTable>;

	getEncryptionKeysOf(timeTable: TimeTable): Promise<Array<HexString>>;

	hasWriteAccess(timeTable: TimeTable): Promise<boolean>;

	decryptPatientIdOf(timeTable: TimeTable): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: TimeTable,
			delegates: Array<string>): Promise<void>;

	decrypt(timeTable: EncryptedTimeTable): Promise<DecryptedTimeTable>;

	tryDecrypt(timeTable: EncryptedTimeTable): Promise<TimeTable>;

	matchTimeTablesBy(filter: FilterOptions<TimeTable>): Promise<Array<string>>;

	matchTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): Promise<Array<string>>;

	deleteTimeTable(entityId: string): Promise<DocIdentifier>;

	deleteTimeTables(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, timeTable: DecryptedTimeTable,
			options?: { options?: TimeTableShareOptions | undefined }): Promise<SimpleShareResult<DecryptedTimeTable>>;

	tryShareWithMany(timeTable: DecryptedTimeTable,
			delegates: { [ key: string ]: TimeTableShareOptions }): Promise<SimpleShareResult<DecryptedTimeTable>>;

	shareWithMany(timeTable: DecryptedTimeTable,
			delegates: { [ key: string ]: TimeTableShareOptions }): Promise<DecryptedTimeTable>;

	filterTimeTablesBy(filter: FilterOptions<TimeTable>): Promise<PaginatedListIterator<DecryptedTimeTable>>;

	filterTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<DecryptedTimeTable>>;

	modifyTimeTable(entity: DecryptedTimeTable): Promise<DecryptedTimeTable>;

	getTimeTable(entityId: string): Promise<DecryptedTimeTable>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<DecryptedTimeTable>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<DecryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<DecryptedTimeTable>>;

}
