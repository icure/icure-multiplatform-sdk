package com.icure.sdk.crypto.entities

import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
class EntityDataEncryptionResult<T : HasEncryptionMetadata>(
	val updatedEntity: T?,
	val encryptedData: ByteArray
)