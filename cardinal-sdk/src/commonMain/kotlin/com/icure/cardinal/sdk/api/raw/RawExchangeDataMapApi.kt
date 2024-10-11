package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ExchangeDataMap
import com.icure.cardinal.sdk.model.ExchangeDataMapCreationBatch
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawExchangeDataMapApi {
	// region common endpoints

	suspend fun createOrUpdateExchangeDataMapBatch(batch: ExchangeDataMapCreationBatch): HttpResponse<String>

	suspend fun getExchangeDataMapBatch(ids: ListOfIds): HttpResponse<List<ExchangeDataMap>>
	// endregion
}
