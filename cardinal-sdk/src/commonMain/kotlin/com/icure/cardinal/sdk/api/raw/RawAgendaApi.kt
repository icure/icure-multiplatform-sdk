package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAgendaApi {
	// region common endpoints

	suspend fun getAgendas(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Agenda>>

	suspend fun createAgenda(agendaDto: Agenda): HttpResponse<Agenda>

	suspend fun deleteAgendas(agendaIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAgendasWithRev(agendaIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAgenda(agendaId: String): HttpResponse<DocIdentifier>

	suspend fun undeleteAgenda(agendaId: String): HttpResponse<Agenda>

	suspend fun purgeAgenda(agendaId: String): HttpResponse<DocIdentifier>

	suspend fun getAgenda(agendaId: String): HttpResponse<Agenda>

	suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda>

	suspend fun getReadableAgendasForUser(userId: String): HttpResponse<List<Agenda>>

	suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda>

	suspend fun matchAgendasBy(filter: AbstractFilter<Agenda>): HttpResponse<List<String>>

	suspend fun getAgendasByIds(agendaIds: ListOfIds): HttpResponse<List<Agenda>>
	// endregion
}
