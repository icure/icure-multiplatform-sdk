package com.icure.sdk.api.raw

import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.utils.InternalIcureApi
import kotlin.String

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawDataOwnerApi {
	// region common endpoints

	suspend fun getDataOwner(dataOwnerId: String): HttpResponse<DataOwnerWithType>

	suspend fun getDataOwnerStub(dataOwnerId: String): HttpResponse<CryptoActorStubWithType>

	suspend fun modifyDataOwnerStub(updated: CryptoActorStubWithType): HttpResponse<CryptoActorStubWithType>

	suspend fun getCurrentDataOwner(): HttpResponse<DataOwnerWithType>
	// endregion
}
