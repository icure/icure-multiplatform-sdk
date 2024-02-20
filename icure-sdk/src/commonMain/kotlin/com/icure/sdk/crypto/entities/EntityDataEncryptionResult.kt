package com.icure.sdk.crypto.entities

import com.icure.sdk.model.Encryptable
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class EntityDataEncryptionResult<T : Encryptable>(
	val updatedEntity: T,
	val encryptedData: ByteArray
)