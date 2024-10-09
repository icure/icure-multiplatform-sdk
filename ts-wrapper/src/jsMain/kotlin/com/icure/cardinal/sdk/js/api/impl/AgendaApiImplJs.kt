// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.AgendaApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.AgendaJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.agenda_fromJs
import com.icure.cardinal.sdk.js.model.agenda_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AgendaApiImplJs(
	private val agendaApi: AgendaApi,
) : AgendaApiJs {
	override fun getAllAgendas(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<AgendaJs>> = GlobalScope.promise {
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = agendaApi.getAllAgendas(
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun createAgenda(agendaDto: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaDtoConverted: Agenda = agenda_fromJs(agendaDto)
		val result = agendaApi.createAgenda(
			agendaDtoConverted,
		)
		agenda_toJs(result)
	}

	override fun deleteAgendaUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = agendaApi.deleteAgendaUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAgendasUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = agendaApi.deleteAgendasUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteAgendaById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = agendaApi.deleteAgendaById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAgendasByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = agendaApi.deleteAgendasByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAgendaById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		agendaApi.purgeAgendaById(
			idConverted,
			revConverted,
		)

	}

	override fun undeleteAgendaById(id: String, rev: String): Promise<AgendaJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = agendaApi.undeleteAgendaById(
			idConverted,
			revConverted,
		)
		agenda_toJs(result)
	}

	override fun deleteAgenda(agenda: AgendaJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.deleteAgenda(
			agendaConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAgendas(agendas: Array<AgendaJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val agendasConverted: List<Agenda> = arrayToList(
			agendas,
			"agendas",
			{ x1: AgendaJs ->
				agenda_fromJs(x1)
			},
		)
		val result = agendaApi.deleteAgendas(
			agendasConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeAgenda(agenda: AgendaJs): Promise<Unit> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		agendaApi.purgeAgenda(
			agendaConverted,
		)

	}

	override fun undeleteAgenda(agenda: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaConverted: Agenda = agenda_fromJs(agenda)
		val result = agendaApi.undeleteAgenda(
			agendaConverted,
		)
		agenda_toJs(result)
	}

	override fun getAgenda(agendaId: String): Promise<AgendaJs> = GlobalScope.promise {
		val agendaIdConverted: String = agendaId
		val result = agendaApi.getAgenda(
			agendaIdConverted,
		)
		agenda_toJs(result)
	}

	override fun getAgendas(agendaIds: Array<String>): Promise<Array<AgendaJs>> = GlobalScope.promise {
		val agendaIdsConverted: List<String> = arrayToList(
			agendaIds,
			"agendaIds",
			{ x1: String ->
				x1
			},
		)
		val result = agendaApi.getAgendas(
			agendaIdsConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun getAgendasForUser(userId: String): Promise<AgendaJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = agendaApi.getAgendasForUser(
			userIdConverted,
		)
		agenda_toJs(result)
	}

	override fun getReadableAgendasForUser(userId: String): Promise<Array<AgendaJs>> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val result = agendaApi.getReadableAgendasForUser(
			userIdConverted,
		)
		listToArray(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun modifyAgenda(agendaDto: AgendaJs): Promise<AgendaJs> = GlobalScope.promise {
		val agendaDtoConverted: Agenda = agenda_fromJs(agendaDto)
		val result = agendaApi.modifyAgenda(
			agendaDtoConverted,
		)
		agenda_toJs(result)
	}

	override fun matchAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
		val result = agendaApi.matchAgendasBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
		val result = agendaApi.matchAgendasBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterAgendasBy(filter: BaseFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Agenda> = baseFilterOptions_fromJs(filter)
		val result = agendaApi.filterAgendasBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}

	override fun filterAgendasBySorted(filter: BaseSortableFilterOptionsJs<AgendaJs>):
			Promise<PaginatedListIteratorJs<AgendaJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Agenda> = baseSortableFilterOptions_fromJs(filter)
		val result = agendaApi.filterAgendasBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Agenda ->
				agenda_toJs(x1)
			},
		)
	}
}
