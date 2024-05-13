package com.icure.sdk.api.raw

import com.icure.sdk.model.RecoveryData
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.utils.InternalIcureApi
import kotlin.String

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawRecoveryDataApi {
	// region common endpoints

	suspend fun createRecoveryData(recoveryData: RecoveryData): HttpResponse<RecoveryData>

	suspend fun getRecoveryData(id: String): HttpResponse<RecoveryData>

	suspend fun deleteRecoveryData(id: String): HttpResponse<DocIdentifier>

	suspend fun deleteAllRecoveryDataForRecipient(recipientId: String): HttpResponse<EncryptedContent>

	suspend fun deleteAllRecoveryDataOfTypeForRecipient(
		type: RecoveryData.Type,
		recipientId: String,
	): HttpResponse<EncryptedContent>
	// endregion
}
