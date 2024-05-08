package com.icure.sdk.crypto.entities

import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class EntityEncryptionMetadataInitialisationResult<T : HasEncryptionMetadata>(
	val updatedEntity: T,
	val rawEncryptionKey: HexString?,
	val secretId: String?
)