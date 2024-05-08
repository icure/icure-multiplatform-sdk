package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ExchangeDataMap(
	override val id: String,
	override val rev: String? = null,
	public val encryptedExchangeDataIds: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	override val deletionDate: Long? = null,
) : StoredDocument {
	// region ExchangeDataMap-ExchangeDataMap

	// endregion
}
