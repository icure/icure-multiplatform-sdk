package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.utils.InternalIcureApi

@InternalIcureApi
class EntityDataEncryptionResult<T : HasEncryptionMetadata>(
	val updatedEntity: T?,
	val encryptedData: ByteArray
)