// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../icure-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';
import {ListOfIds} from '../model/ListOfIds.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface AgendaApi {

	getAllAgendas(startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<Agenda>>;

	createAgenda(agendaDto: Agenda): Promise<Agenda>;

	deleteAgendas(agendaIds: ListOfIds): Promise<Array<DocIdentifier>>;

	deleteAgenda(agendaId: string): Promise<DocIdentifier>;

	getAgenda(agendaId: string): Promise<Agenda>;

	getAgendas(agendaIds: Array<string>): Promise<Array<Agenda>>;

	getAgendasForUser(userId: string): Promise<Agenda>;

	getReadableAgendasForUser(userId: string): Promise<Array<Agenda>>;

	modifyAgenda(agendaDto: Agenda): Promise<Agenda>;

	matchAgendasBy(filter: BaseFilterOptions<Agenda>): Promise<Array<string>>;

	matchAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): Promise<Array<string>>;

	filterAgendasBy(filter: BaseFilterOptions<Agenda>): Promise<PaginatedListIterator<Agenda>>;

	filterAgendasBySorted(filter: BaseSortableFilterOptions<Agenda>): Promise<PaginatedListIterator<Agenda>>;

}
