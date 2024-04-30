package com.icure.sdk.api.raw

import com.icure.sdk.model.ExchangeDataMap
import com.icure.sdk.model.ExchangeDataMapCreationBatch
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.utils.InternalIcureApi
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
