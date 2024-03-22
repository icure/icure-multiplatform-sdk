package com.icure.sdk.crypto.entities

import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class EntityEncryptionMetadataInitialisationResult<T : Encryptable>(
	val updatedEntity: T,
	val rawEncryptionKey: HexString?,
	val secretId: String?
)