package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class EntityEncryptionMetadataInitialisationResult<T : HasEncryptionMetadata>(
	val updatedEntity: T,
	val rawEncryptionKey: HexString?,
	val secretId: String
)