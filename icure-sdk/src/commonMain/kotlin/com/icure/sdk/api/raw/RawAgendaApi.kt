package com.icure.sdk.api.raw

import com.icure.sdk.model.Agenda
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.utils.InternalIcureApi
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

	suspend fun deleteAgenda(agendaId: String): HttpResponse<DocIdentifier>

	suspend fun getAgenda(agendaId: String): HttpResponse<Agenda>

	suspend fun getAgendasForUser(userId: String): HttpResponse<Agenda>

	suspend fun getReadableAgendasForUser(userId: String): HttpResponse<List<Agenda>>

	suspend fun modifyAgenda(agendaDto: Agenda): HttpResponse<Agenda>

	suspend fun matchAgendasBy(filter: AbstractFilter<Agenda>): HttpResponse<List<String>>
	// endregion
}
