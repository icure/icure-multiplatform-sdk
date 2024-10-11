package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ExchangeData
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawExchangeDataApi {
	// region common endpoints

	suspend fun createExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData>

	suspend fun modifyExchangeData(exchangeData: ExchangeData): HttpResponse<ExchangeData>

	suspend fun getExchangeDataById(exchangeDataId: String): HttpResponse<ExchangeData>

	suspend fun getExchangeDataByParticipant(
		dataOwnerId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<ExchangeData>>

	suspend fun getExchangeDataByDelegatorDelegate(
		delegatorId: String,
		delegateId: String,
	): HttpResponse<List<ExchangeData>>

	suspend fun getParticipantCounterparts(
		dataOwnerId: String,
		counterpartsTypes: String,
		ignoreOnEntryForFingerprint: String? = null,
	): HttpResponse<List<String>>
	// endregion
}
